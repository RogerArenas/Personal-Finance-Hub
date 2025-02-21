 Definição das Entidades e Relacionamentos
 
🔹 Usuário (usuarios)

Representa os usuários que acessam o sistema.

Campo	Tipo	Descrição

id	UUID (PK)	Identificador único do usuário

nome	VARCHAR(100)	Nome completo

email	VARCHAR(255)	E-mail (único)

senha	VARCHAR(255)	Senha hash (BCrypt)

criado_em	TIMESTAMP	Data de criação

 Relacionamento: Um usuário pode ter múltiplas transações.
 
 ----------------

 🔹 Transação (transacoes)
 
Registra as entradas e saídas financeiras.

Campo	Tipo	Descrição

id	UUID (PK)	Identificador único da transação

usuario_id	UUID (FK)	Usuário dono da transação

tipo	ENUM	RECEITA ou DESPESA

valor	DECIMAL(10,2)	Valor da transação

categoria_id	UUID (FK)	Categoria associada

data	DATE	Data da transação

criado_em	TIMESTAMP	Data de criação

🔹 Relacionamento: Cada transação pertence a um usuário e a uma categoria.	

--------------
🔹 Categoria (categorias)

Agrupa as transações em tipos específicos.

Campo	Tipo	Descrição

id	UUID (PK)	Identificador único

usuario_id	UUID (FK)	Usuário dono da categoria

nome	VARCHAR(50)	Nome da categoria (ex: Alimentação, Transporte)

criado_em	TIMESTAMP	Data de criação

🔹 Relacionamento: Cada categoria pertence a um usuário e pode ser usada em várias transações.


