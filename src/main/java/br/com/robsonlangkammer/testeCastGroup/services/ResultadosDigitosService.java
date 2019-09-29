package br.com.robsonlangkammer.testeCastGroup.services;

import br.com.robsonlangkammer.testeCastGroup.model.ResultadosDigitosModel;
import br.com.robsonlangkammer.testeCastGroup.model.UsuarioModel;
import br.com.robsonlangkammer.testeCastGroup.repository.ResultadosDigitosRepository;
import br.com.robsonlangkammer.testeCastGroup.repository.UsuarioRepository;
import br.com.robsonlangkammer.testeCastGroup.vo.CalculoVo;
import br.com.robsonlangkammer.testeCastGroup.vo.ResultadoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.parseLong;

@Service
public class ResultadosDigitosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ResultadosDigitosRepository resultadosDigitosRepository;


    public ResultadoVo calculaDigito(CalculoVo calculoVo){
        if(calculoVo.getUsuarioVo() != null){
            ResultadoVo resultadoVo = new ResultadoVo(calculaDigitoUnico(calculoVo.getDigito()),
                    calculoVo.getUsuarioVo());
            Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(resultadoVo.getUsuarioVo().getId());
            if(usuarioModel.isPresent()){
                UsuarioModel user = usuarioModel.get();
                List<ResultadosDigitosModel> digitosCalculados = user.getResultadosDigitos();
                ResultadosDigitosModel digiCalculado = resultadoVo.convertModel();
                digitosCalculados.add(digiCalculado);
                usuarioRepository.saveAndFlush(user);
            }
            return resultadoVo;
        }else{
            ResultadoVo resultadoVo = new ResultadoVo(calculaDigitoUnico(calculoVo.getDigito()),null);
            return resultadoVo;
        }
    }


    public Long calculaDigitoUnico(Long valor){
        if(valor != null){
            String valorString = String.valueOf(valor);
            if(valorString.length() == 1){
                return valor;
            }
            else if (valorString.length() > 1){
                return extrairDigitoUnico(valorString);
            }
        }
        return 0l;
    }

    public Long extrairDigitoUnico(String valor){
        Long digito = 0l;
        for (String s : valor.split("")) {
            digito += parseLong(s);
        }

        return digito;
    }


}
