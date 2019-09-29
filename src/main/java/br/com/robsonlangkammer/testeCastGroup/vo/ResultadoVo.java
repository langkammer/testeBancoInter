package br.com.robsonlangkammer.testeCastGroup.vo;

import br.com.robsonlangkammer.testeCastGroup.model.ResultadosDigitosModel;

public class ResultadoVo {

    private Long id;

    private Long resultado;

    private UsuarioVo usuarioVo;

    public ResultadoVo(){

    }

    public ResultadoVo(Long resultado, UsuarioVo usuarioVo) {
        this.resultado = resultado;
        this.usuarioVo = usuarioVo;
    }

    public Long getResultado() {
        return resultado;
    }

    public void setResultado(Long resultado) {
        this.resultado = resultado;
    }

    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public ResultadosDigitosModel convertModel(){
        ResultadosDigitosModel resultadosDigitosModel = new ResultadosDigitosModel();
        if(this!=null){
            resultadosDigitosModel.setId(this.id);
            resultadosDigitosModel.setResultado(this.resultado);
            return resultadosDigitosModel;
        }
        return resultadosDigitosModel;
    }
}
