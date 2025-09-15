package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesRepository  missoesRepository;
    private final MissoesService missoesService;
    private final NinjaService ninjaService;

    public MissoesController(MissoesRepository missoesRepository, MissoesService missoesService, NinjaService ninjaService) {
        this.missoesRepository = missoesRepository;
        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
    }

    //Add missao
    @PostMapping("/criaMissao")
    public ResponseEntity<String> criaMissao(@RequestBody MissoesDTO missoes) {
        System.out.println("criaMissao");
        MissoesDTO novaMissao =missoesService.criarMissao(missoes);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Nova missao criada com sucesso:"+novaMissao.getNome()+"!");
    }


    //Deletar missao
    @DeleteMapping("/deletaMissao/{id}")
    public ResponseEntity<String> deletaMissao(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id)!=null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missao removida com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao nao encontrada");
        }

    }
    //Procurar missao por ID
    @GetMapping("/procurarMissaoPorId/{id}")
    private ResponseEntity<?> procurarMissaoPorId(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id)!=null) {
            missoesService.listarMissaoPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Missao encontrada");
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum Missao encontrada");
        }

    }
    //Editar missao
    @PutMapping("/editarMissao")
    public ResponseEntity<?> editarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizada) {
        if (missoesService.listarMissaoPorId(id)!=null) {
            missoesService.atualizarMissao(missoesAtualizada,id);
            return ResponseEntity.status(HttpStatus.OK).body("Missao atualizada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao nao encontrada");
        }
    }
    //Mostrar as missoes
    @GetMapping("/mostrarAsMissoes")
    private ResponseEntity<List<MissoesDTO>> mostrarAsMissoes() {
        List<MissoesDTO> missoes =missoesService.listarMissoes();
        return ResponseEntity.status(HttpStatus.OK).body(missoes);
    }


}
