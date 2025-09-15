package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesService;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;
    private final MissoesService missoesService;

    public NinjaControllerUI(NinjaService ninjaService, MissoesService missoesService) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
    }

    @GetMapping("/listarninjas")
    public String  listarninjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarninjas();
        model.addAttribute("ninjas", ninjas);
        return "listarninjas";//Retorna o nome da pagina que renderiza
    }
    //Deletar um ninja
    @GetMapping("/deletarID/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
       ninjaService.deletarNinjaPorId(id);
       return "redirect:/ninjas/ui/listarninjas";
    }

    //Ver detalhes
    @GetMapping("/listarID/{id}")
    public String listarNinjasPorId(@PathVariable long id, Model model) {
        NinjaDTO ninja =ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";

        } else {
            model.addAttribute("memnsagem", "Ninja nao encontrado");
            return "listarninjas";
        }


    }
    //Adicionar ninja
    @PostMapping("/adicionarninja")
    public String criarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("message", "Ninja adicionada com sucesso!");
        return "redirect:/ninjas/ui/listarninjas";

    }
    //Pagina de adicionar
    @GetMapping("/adicionar")
    public String adicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarninja";
    }

    //Pagina de alterar
    @GetMapping("/alterarninja/{id}")
    public String alterarNinjaPagina(Model model,@PathVariable Long id){
        NinjaDTO ninja =ninjaService.listarNinjasPorId(id);
        model.addAttribute("ninja", ninja);
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "alterarninjas";
    }
    //Alterar ninja
    @PostMapping("/alterarNinja/{id}")
    public String alterarNinja(@PathVariable Long id,NinjaDTO ninjaDTO){
        ninjaService.atualizarNinja(id, ninjaDTO);

        return "redirect:/ninjas/ui/listarninjas";
    }

}
