package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas vindas";
    }

    //Add ninja
    @PostMapping("/criar")
    public String adicionar() {
        return "Ninja criado";
    }

    //Procurar ninja por id
    @GetMapping("/listarID")
    public String todosID() {
        return "Todos por id";
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterar")
    public String alterarNinjaPorId() {
        return "Ninja alterado";
    }

    //Deletar um ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado";
    }

    //Mostrar os ninjas
    @GetMapping("/todos")
    public String todos() {
        return "Todos";
    }


}
