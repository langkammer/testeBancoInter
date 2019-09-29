package br.com.robsonlangkammer.testeCastGroup.services;

import br.com.robsonlangkammer.testeCastGroup.model.UsuarioModel;
import br.com.robsonlangkammer.testeCastGroup.repository.ResultadosDigitosRepository;
import br.com.robsonlangkammer.testeCastGroup.repository.UsuarioRepository;
import br.com.robsonlangkammer.testeCastGroup.vo.UsuarioVo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

import static java.util.Optional.of;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest extends TestCase {

    UsuarioModel user = new UsuarioModel(
            1l,
            "Teste",
            "teste@teste.com.br",
            new ArrayList<>());


    UsuarioVo userVo = new UsuarioVo(
            1l,
            "Teste",
            "teste@teste.com.br",
            new ArrayList<>());


    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private ResultadosDigitosRepository resultadosDigitosRepository;

    @Mock
    private UsuarioVo usuarioVo;


    @Test
    public void testFind() {
        when(usuarioRepository.findByNomeContaining(anyString(),any(Pageable.class))).thenReturn(any(Page.class));
        usuarioService.find(any(Pageable.class), "");
    }

    @Test
    public void testDelete() {
        when(usuarioRepository.findById(anyLong())).thenReturn(of(user));
        usuarioService.delete(anyLong());
    }


    @Test
    public void testCreate() {
        usuarioService.create(userVo);
        when(usuarioRepository.saveAndFlush(user)).thenReturn(user);
    }

    @Test
    public void testUpdate() {
        usuarioService.update(userVo);
        when(usuarioRepository.saveAndFlush(user)).thenReturn(user);
    }
}