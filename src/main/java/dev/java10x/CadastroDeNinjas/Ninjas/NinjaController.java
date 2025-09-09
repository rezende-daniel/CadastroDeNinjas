package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja crido com sucesso:"+novoNinja.getNome()+"!");

    }

    //Procurar ninja por id
    @GetMapping("/listarID/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.listarNinjasPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninjas encontradas com sucesso!");
        }
        else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninjas nao encontradas!");
        }
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.atualizarNinja(id,ninjaAtualizado);
            return ResponseEntity.ok("Ninja atualizado com sucesso!");
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao encontrado!");
        }


    }

    //Deletar um ninja
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable long id) {
        if (ninjaService.listarNinjasPorId(id)!=null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        }
        else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja nao foi encontrado");
        }
    }

    //Mostrar os ninjas
    @GetMapping("/listarninjas")
    public ResponseEntity<List<NinjaDTO>> listarninjas() {


        List<NinjaDTO> ninjas= ninjaService.listarninjas() ;
        return ResponseEntity.ok(ninjas);
    }




}
