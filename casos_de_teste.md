Casos de Teste - Gestão Financeira

📌 1. Autenticação de Usuário

📂 Cenário 1: Cadastro de usuário com sucesso

Dado que o usuário acessa o endpoint /auth/register

Quando ele envia um nome, e-mail e senha válidos

Então o sistema deve retornar 201 Created

E o usuário deve ser salvo no banco de dados

📂 Cenário 2: Tentativa de cadastro com e-mail já existente

Dado que já existe um usuário cadastrado com o e-mail teste@email.com

Quando um novo usuário tenta se cadastrar com o mesmo e-mail

Então o sistema deve retornar 400 Bad Request

E exibir a mensagem "E-mail já cadastrado"

📂 Cenário 3: Login com credenciais corretas

Dado que o usuário está cadastrado

Quando ele envia e-mail e senha corretos para /auth/login

Então o sistema deve retornar 200 OK

E um token JWT válido

📂 Cenário 4: Login com credenciais inválidas

Dado que o usuário não existe ou a senha está errada

Quando ele tenta logar

Então o sistema deve retornar 401 Unauthorized

E exibir a mensagem "Credenciais inválidas"

📌 2. Cadastro de Transações

📂 Cenário 5: Criar uma nova transação

Dado que o usuário está autenticado

Quando ele envia uma requisição POST para /transacoes com os dados:


{
  "tipo": "DESPESA",
  
  "valor": 100.00,
  
  "data": "2024-02-18",
  
  "categoria": "Alimentação"
  
}

Então o sistema deve retornar 201 Created

E a transação deve ser salva corretamente no banco


📂 Cenário 6: Criar uma transação sem categoria

Dado que o usuário está autenticado

Quando ele tenta cadastrar uma transação sem informar a categoria

Então o sistema deve retornar 400 Bad Request

E exibir a mensagem "Categoria é obrigatória"


📌 3. Listagem de Transações

📂 Cenário 7: Listar transações do usuário autenticado

Dado que o usuário está autenticado e possui transações cadastradas

Quando ele faz uma requisição GET para /transacoes

Então o sistema deve retornar 200 OK

E a lista de transações deve ser exibida corretamente


📂 Cenário 8: Listar transações sem autenticação

Dado que o usuário não está autenticado

Quando ele tenta acessar /transacoes

Então o sistema deve retornar 401 Unauthorized

📌 4. Geração de Relatórios

📂 Cenário 9: Gerar relatório de despesas por mês

Dado que o usuário possui transações cadastradas

Quando ele faz uma requisição GET para /relatorios?periodo=mes

Então o sistema deve retornar 200 OK

E um relatório contendo o total de despesas do mês

📂 Cenário 10: Gerar relatório sem transações cadastradas

Dado que o usuário não possui transações no período selecionado

Quando ele solicita um relatório

Então o sistema deve retornar 200 OK

E exibir uma mensagem "Nenhuma transação encontrada"
