package br.com.robsonlangkammer.testeCastGroup.vo;

import br.com.robsonlangkammer.testeCastGroup.model.ResultadosDigitosModel;
import br.com.robsonlangkammer.testeCastGroup.model.UsuarioModel;

import java.util.List;

public class UsuarioVo {

    private Long id;

    private String nome;

    private String email;

    public UsuarioVo(){

    }

    public UsuarioVo(Long id, String nome, String email, List<ResultadosDigitosModel> resultadoVoList) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.resultadoVoList = resultadoVoList;
    }

    private List<ResultadosDigitosModel> resultadoVoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ResultadosDigitosModel> getResultadoVoList() {
        return resultadoVoList;
    }

    public void setResultadoVoList(List<ResultadosDigitosModel> resultadoVoList) {
        this.resultadoVoList = resultadoVoList;
    }

    public UsuarioModel convertToModel(){
        if(this !=null){
            UsuarioModel usuarioModel = new UsuarioModel();
            usuarioModel.setId(this.id);
            usuarioModel.setNome(this.nome);
            usuarioModel.setEmail(this.email);
            usuarioModel.setResultadosDigitos(this.resultadoVoList);
            return usuarioModel;
        }
        else{
            return null;
        }

    }

    public UsuarioVo convertModelInVo(UsuarioModel usuarioModel){
        if(usuarioModel !=null){
            UsuarioVo usuarioVo = new UsuarioVo();

            usuarioVo.setId(usuarioModel.getId());
            usuarioVo.setNome(usuarioModel.getNome());
            usuarioVo.setEmail(usuarioModel.getEmail());
            usuarioVo.setResultadoVoList(usuarioModel.getResultadosDigitos());
            return usuarioVo;
        }
        else{
            return null;
        }

    }

}
