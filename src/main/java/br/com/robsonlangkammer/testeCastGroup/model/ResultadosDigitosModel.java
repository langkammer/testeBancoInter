package br.com.robsonlangkammer.testeCastGroup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResultadosDigitosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long resultado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResultado() {
        return resultado;
    }

    public void setResultado(Long resultado) {
        this.resultado = resultado;
    }
    public ResultadosDigitosModel() {

    }
    public ResultadosDigitosModel(Long id, Long resultado) {
        this.id = id;
        this.resultado = resultado;
    }
}
