package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas vindas";
    }

    //Add ninja
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Procurar ninja por id
    @GetMapping("/listarID/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id,ninjaAtualizado);
    }

    //Deletar um ninja
    @DeleteMapping("/deletarID/{id}")
    public void deletarNinjaPorId(@PathVariable long id) {
        ninjaService.deletarNinjaPorId(id);
    }

    //Mostrar os ninjas
    @GetMapping("/listarninjas")
    public List<NinjaDTO> listarninjas() {
        return ninjaService.listarninjas() ;
    }




}
