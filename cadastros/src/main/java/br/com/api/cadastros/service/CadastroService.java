package br.com.api.cadastros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.cadastros.model.CadastroModel;
import br.com.api.cadastros.model.ResponseModel;
import br.com.api.cadastros.service.repository.CadastroRepository;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cr;

    @Autowired
    private ResponseModel rm;

    // Metodo para listar todos os Cadastro
    public Iterable<CadastroModel> listar() {
        return cr.findAll();
    }

    // Metodo para cadastrar ou alterar tarefas
    public ResponseEntity<?> cadastrarAlterar(CadastroModel cm, String acao) {

        if (cm.getTarefa().equals("")) {
            rm.setMensagem("O nome da Tarefa é obrigatorio?");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (cm.getStatus().equals("")) {
            rm.setMensagem("O status é obrigatorio!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<CadastroModel>(cr.save(cm), HttpStatus.CREATED);

            } else {
                return new ResponseEntity<CadastroModel>(cr.save(cm), HttpStatus.OK);

            }

        }
    }

    // Método para remover produtos
    public ResponseEntity<ResponseModel> remover(long codigo) {
        cr.deleteById(codigo);
        rm.setMensagem("A tarefa foi removida com sucesso");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }

}
