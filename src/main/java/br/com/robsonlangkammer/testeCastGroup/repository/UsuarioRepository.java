package br.com.robsonlangkammer.testeCastGroup.repository;

import br.com.robsonlangkammer.testeCastGroup.model.UsuarioModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Page<UsuarioModel> findByNomeContaining(@Param("nome") String nome, Pageable pageable);

    Page<UsuarioModel> findByEmail(@Param("email") String nome, Pageable pageable);
}
