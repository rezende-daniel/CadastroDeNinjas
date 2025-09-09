package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui+")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listarninjas")
    public String  listarninjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarninjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";//Retorna o nome da pagina que renderiza
    }
}
