package br.com.robsonlangkammer.testeCastGroup.services;

import br.com.robsonlangkammer.testeCastGroup.model.ResultadosDigitosModel;
import br.com.robsonlangkammer.testeCastGroup.model.UsuarioModel;
import br.com.robsonlangkammer.testeCastGroup.repository.ResultadosDigitosRepository;
import br.com.robsonlangkammer.testeCastGroup.repository.UsuarioRepository;
import br.com.robsonlangkammer.testeCastGroup.vo.CalculoVo;
import br.com.robsonlangkammer.testeCastGroup.vo.ResultadoVo;
import br.com.robsonlangkammer.testeCastGroup.vo.UsuarioVo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.of;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ResultadosDigitosServiceTest extends TestCase {

    Long conta = 9875987598759875l;
    Long contaUmDigito = 1l;
    Long resultadoCorreto= 116l;
    Long resultadoComUmDigito= 1l;
    Long resultadoErrado= 120l;
    Long resultadoSemNada= 0l;


    CalculoVo calculoVoSemUsuarioSemNada = new CalculoVo(null ,null);
    CalculoVo calculoVoSemUsuarioUmDigito = new CalculoVo(contaUmDigito,null);
    CalculoVo calculoVoSemUsuario = new CalculoVo(conta,null);
    CalculoVo calculoVoComUsuario = new CalculoVo(conta,
            new UsuarioVo(1l,"Teste","teste@teste.com.br",null)
    );

    List<ResultadosDigitosModel> listaDigitosCalculados  = new ArrayList<ResultadosDigitosModel>();

    UsuarioModel user = new UsuarioModel(
            1l,
            "Teste",
            "teste@teste.com.br",
            listaDigitosCalculados);

    @InjectMocks
    private ResultadosDigitosService resultadosDigitosService;

    @Mock
    private ResultadosDigitosRepository resultadosDigitosRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    public void testaCalculoComSemNada() {
        ResultadoVo resultadoVo  = resultadosDigitosService.calculaDigito(calculoVoSemUsuarioSemNada);
        assertEquals(resultadoSemNada,resultadoVo.getResultado());
    }
    @Test
    public void testaCalculoComUmDigito() {
        ResultadoVo resultadoVo  = resultadosDigitosService.calculaDigito(calculoVoSemUsuarioUmDigito);
        assertEquals(resultadoComUmDigito,resultadoVo.getResultado());
    }

    @Test
    public void testCalculaDigitoSemUsuario() {
        ResultadoVo resultadoVo  = resultadosDigitosService.calculaDigito(calculoVoSemUsuario);
        assertEquals(resultadoCorreto,resultadoVo.getResultado());
        assertFalse(resultadoErrado == resultadoVo.getResultado());
    }

    @Test
    public void testCalculaDigioComUsuario() {
        when(usuarioRepository.findById(anyLong())).thenReturn(of(user));
        when(usuarioRepository.saveAndFlush(user)).thenReturn(user);
        ResultadoVo resultadoVo = resultadosDigitosService.calculaDigito(calculoVoComUsuario);
        assertEquals(resultadoCorreto,resultadoVo.getResultado());
        verify(usuarioRepository, times(1))
                .findById(anyLong());
        verify(usuarioRepository, times(1))
                .saveAndFlush(any());
    }

}