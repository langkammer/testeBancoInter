package br.com.robsonlangkammer.testeCastGroup.vo;


public class CalculoVo {

    private Long digito;

    private UsuarioVo usuarioVo;


    public CalculoVo() {

    }

    public CalculoVo(Long digito, UsuarioVo usuarioVo) {
        this.digito = digito;
        this.usuarioVo = usuarioVo;
    }
    public Long getDigito() {
        return digito;
    }


    public void setDigito(Long digito) {
        this.digito = digito;
    }

    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }
}
