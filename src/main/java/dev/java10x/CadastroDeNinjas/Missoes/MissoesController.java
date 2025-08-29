package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {


    //Add missao
    @PostMapping("/criaMissao")
    public String criaMissao() {
        return "Missao criada";
    }


    //Deletar missao
    @DeleteMapping("/deletaMissao")
    public String deletaMissao() {
        return "Missao deletada";
    }
    //Procurar missao por ID
    @GetMapping("/procurarMissaoPorId")
    private String procurarMissaoPorId() {
        return "Missao procurada por Id";
    }
    //Editar missao
    @PutMapping("/editarMissao")
    public String editarMissao() {
        return "Missao editada";
    }
    //Mostrar as missoes
    @GetMapping("/mostrarAsMissoes")
    private String mostrarAsMissoes() {
        return "Missao mostrada";
    }


}
