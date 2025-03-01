package com.api.gestao_financeira.repository;

import com.api.gestao_financeira.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

    List<Transacao> findByUsuarioId(UUID usuarioID);
}
