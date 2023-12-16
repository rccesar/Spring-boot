package br.com.api.cadastros.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cadastros.model.CadastroModel;
import br.com.api.cadastros.model.ResponseModel;
import br.com.api.cadastros.service.CadastroService;

@RestController
@CrossOrigin(origins = "*")
public class CadastroControl {

    @Autowired
    private CadastroService cs;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<ResponseModel> remover(@PathVariable long codigo) {
        return cs.remover(codigo);

    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody CadastroModel cm) {
        return cs.cadastrarAlterar(cm, "alterar");

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody CadastroModel cm) {
        return cs.cadastrarAlterar(cm, "cadastrar");

    }

    @GetMapping("/listar")
    public Iterable<CadastroModel> listar() {
        return cs.listar();

    }

    @GetMapping("/")
    public String rota() {
        return "API de cadastro Funcionando!";
    }

}
