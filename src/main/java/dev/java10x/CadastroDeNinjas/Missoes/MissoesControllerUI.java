package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaControllerUI;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {

    private final MissoesService missoesService;
    private final NinjaService ninjaService;
    private final NinjaControllerUI ninjaControllerUI;

    public MissoesControllerUI(MissoesService missoesService, NinjaService ninjaService, NinjaControllerUI ninjaControllerUI) {

        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
        this.ninjaControllerUI = ninjaControllerUI;
    }

    //Mostrar as missoes
    @GetMapping("/mostrarAsMissoes")
    private String mostrarAsMissoes(Model model) {
        List<MissoesDTO> missoes =missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);

        return "listarmissoes";
    }

    //Ir para a pagina de adicionar missao
    @GetMapping("/paginacrianovamissao")
    private String paginacrianovamissao(Model model) {
        model.addAttribute("missoes", new MissoesDTO());
        List<NinjaDTO> ninjas = ninjaService.listarninjas();
        model.addAttribute("ninjas", ninjas);
        return "adicionarmissao";
    }
    //Criar missao
    @PostMapping("/adicionarnovamissao")
    public String criaMissao(@ModelAttribute MissoesDTO missoes, RedirectAttributes redirectAttributes) {
        missoesService.criarMissao(missoes);
        redirectAttributes.addFlashAttribute("mensagem", "missao criada");


        return "redirect:/missoes/ui/mostrarAsMissoes";
    }
    //Deletar missao
    @GetMapping("/deletaMissao/{id}")
    public String deletaMissao(@PathVariable Long id) {
       missoesService.deletarMissao(id);
       return "redirect:/missoes/ui/mostrarAsMissoes";

    }
    //Pagina de alterar
    @GetMapping("/alterarMissao/{id}")
    public String alterarMissaoPagina(@PathVariable Long id, Model model) {
        MissoesDTO missoesDTO = missoesService.listarMissaoPorId(id);
        model.addAttribute("missoes", missoesDTO);
        return "alterarmissao";
    }
    //Alterar missao
    @PostMapping("/alterarmissao/{id}")
    public String alterMissao (@PathVariable Long id, MissoesDTO missoesDTO) {
        missoesService.atualizarMissao(missoesDTO,id);
        return "redirect:/missoes/ui/mostrarAsMissoes";
    }



}
