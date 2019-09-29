package br.com.robsonlangkammer.testeCastGroup.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String email;

    public UsuarioModel(Long id, String nome, String email, List<ResultadosDigitosModel> resultadosDigitos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.resultadosDigitos = resultadosDigitos;
    }

    public UsuarioModel() {
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<ResultadosDigitosModel> resultadosDigitos;

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

    public List<ResultadosDigitosModel> getResultadosDigitos() {
        return resultadosDigitos;
    }

    public void setResultadosDigitos(List<ResultadosDigitosModel> resultadosDigitos) {
        this.resultadosDigitos = resultadosDigitos;
    }
}
