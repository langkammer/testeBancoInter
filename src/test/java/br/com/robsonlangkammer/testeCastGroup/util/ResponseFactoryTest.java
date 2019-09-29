package br.com.robsonlangkammer.testeCastGroup.util;

import br.com.robsonlangkammer.testeCastGroup.bean.EvenlopResponse;
import br.com.robsonlangkammer.testeCastGroup.enums.StatusResponseEnum;
import junit.framework.TestCase;
import org.junit.Test;

import static java.util.Arrays.asList;

public class ResponseFactoryTest extends TestCase {

    private ResponseFactory responseFactory;

    @Test
    public void testReturnEnvelopSucesso() {
        Object any = new Object();
        responseFactory = new ResponseFactory();
        EvenlopResponse e = responseFactory.returnEnvelopSucesso(any,"Qualquer coisa" );
        assertEquals(e.getMenssage(), "Qualquer coisa");
        assertEquals(e.getStatus() , StatusResponseEnum.SUCESSO);
    }

    @Test
    public void testReturnEnvelopSucessoList() {
        Object any = new Object();
        responseFactory = new ResponseFactory();
        EvenlopResponse e = responseFactory.returnEnvelopSucessoList(asList(any),1,1,"Qualquer coisa" );
        assertEquals(e.getMenssage(), "Qualquer coisa");
        assertEquals(e.getStatus() , StatusResponseEnum.SUCESSO);
        assertEquals(e.getData() , asList(any));
        assertEquals(e.getTotalElements() , 1);
        assertEquals(e.getTotalPages() , 1);

    }

    @Test
    public void testReturnEnvelopError() {
        Object any = new Object();
        responseFactory = new ResponseFactory();
        EvenlopResponse e = responseFactory.returnEnvelopError("Qualquer coisa" );
        assertEquals(e.getMenssage(), "Qualquer coisa");
        assertEquals(e.getStatus() , StatusResponseEnum.ERRO);
    }
}