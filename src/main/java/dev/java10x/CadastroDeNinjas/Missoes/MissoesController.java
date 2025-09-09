package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesRepository  missoesRepository;
    private final MissoesService missoesService;

    public MissoesController(MissoesRepository missoesRepository, MissoesService missoesService) {
        this.missoesRepository = missoesRepository;
        this.missoesService = missoesService;
    }

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
