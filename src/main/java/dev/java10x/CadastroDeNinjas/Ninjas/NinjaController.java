package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas vindas";
    }

    //Add ninja
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Procurar ninja por id
    @GetMapping("/listarID/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterar")
    public String alterarNinjaPorId() {
        return "Ninja alterado";
    }

    //Deletar um ninja
    @DeleteMapping("/deletarID/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }

    //Mostrar os ninjas
    @GetMapping("/listarninjas")
    public List<NinjaModel> listarninjas() {
        return ninjaService.listarninjas() ;
    }


}
