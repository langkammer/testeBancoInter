package br.com.robsonlangkammer.testeCastGroup.services;

import br.com.robsonlangkammer.testeCastGroup.model.UsuarioModel;
import br.com.robsonlangkammer.testeCastGroup.repository.ResultadosDigitosRepository;
import br.com.robsonlangkammer.testeCastGroup.repository.UsuarioRepository;
import br.com.robsonlangkammer.testeCastGroup.vo.UsuarioVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;


    @Autowired
    ResultadosDigitosRepository resultadosDigitosRepository;

    public Page<UsuarioModel> find(Pageable paginacao, String nome){
        Page<UsuarioModel> listPage = repository.findByNomeContaining(nome, paginacao);
        return listPage;
    }

    public void delete(Long id){
        Optional<UsuarioModel> usuario = repository.findById(id);
        if(usuario.isPresent()){
            repository.delete(usuario.get());
        }
    }

    public UsuarioVo create(UsuarioVo usuarioVo){
        UsuarioModel usuarioModel = usuarioVo.convertToModel();
        UsuarioModel userModel = repository.saveAndFlush(usuarioModel);
        return usuarioVo.convertModelInVo(userModel);
    }

    public UsuarioVo update(UsuarioVo usuarioVo){
        UsuarioModel usuarioModel = usuarioVo.convertToModel();
        UsuarioModel userModel = repository.saveAndFlush(usuarioModel);
        return usuarioVo.convertModelInVo(userModel);
    }


}
