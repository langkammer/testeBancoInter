package br.com.robsonlangkammer.testeCastGroup.controller;

import br.com.robsonlangkammer.testeCastGroup.bean.EvenlopResponse;
import br.com.robsonlangkammer.testeCastGroup.model.UsuarioModel;
import br.com.robsonlangkammer.testeCastGroup.services.ResultadosDigitosService;
import br.com.robsonlangkammer.testeCastGroup.services.UsuarioService;
import br.com.robsonlangkammer.testeCastGroup.util.ResponseFactory;
import br.com.robsonlangkammer.testeCastGroup.vo.CalculoVo;
import br.com.robsonlangkammer.testeCastGroup.vo.ResultadoVo;
import br.com.robsonlangkammer.testeCastGroup.vo.UsuarioVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController extends ResponseFactory {

    @Autowired
    UsuarioService serviceUsuario;


    @Autowired
    ResultadosDigitosService serivceResultados;


    @GetMapping
    public EvenlopResponse list(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC, page = 0,size = 10) Pageable paginacao){
        try{

            Page<UsuarioModel> list = serviceUsuario.find(paginacao,nome);

            return returnEnvelopSucessoList(list,list.getTotalPages(),list.getTotalElements(),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }


    @PostMapping
    public EvenlopResponse create(@RequestBody UsuarioVo usuarioVo){
        try{

            UsuarioVo usuarioVo1 = serviceUsuario.create(usuarioVo);

            return returnEnvelopSucesso(usuarioVo1,"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PutMapping
    public EvenlopResponse update(@RequestBody UsuarioVo usuarioVo){
        try{

            UsuarioVo usuarioVo1 = serviceUsuario.update(usuarioVo);

            return returnEnvelopSucesso(usuarioVo1,"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public EvenlopResponse delete(@PathVariable Long id){
        try{
            serviceUsuario.delete(id);
            return returnEnvelopSucesso(null,"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PostMapping(path = "/calculoDigito")
    @Cacheable("createCalculoDigito")
    public EvenlopResponse createCalculoDigito(@RequestBody CalculoVo calculoVo){
        try{

            ResultadoVo resultadoVo = serivceResultados.calculaDigito(calculoVo);

            return returnEnvelopSucesso(resultadoVo,"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }
}
