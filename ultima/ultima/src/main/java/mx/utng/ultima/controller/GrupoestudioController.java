package mx.utng.ultima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;

import mx.utng.ultima.model.entity.Grupoestudio;
import mx.utng.ultima.model.service.IGrupoestudioService;



@Controller
@SessionAttributes("grupoestudio")
public class GrupoestudioController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IGrupoestudioService grupoestudioService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/grupoestudio/list","/grupoestudio/","/grupoestudio/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Grupo Estudio");
    model.addAttribute("grupoestudios", grupoestudioService.list());
    return "glist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/grupoestudio/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Grupo Estudio");
        model.addAttribute("grupoestudio", new Grupoestudio());
        return "gform";
    }

    @GetMapping("/grupoestudio/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Grupoestudio grupoestudio  = null;
        if (id>0) {
            grupoestudio = grupoestudioService.getById(id);
        }else{
            return "redirect:/grupoestudio/list";
        }

        model.addAttribute("title", "Editar Grupo Estudio");
        model.addAttribute("grupoestudio", grupoestudio);
        return "gform";
    }


    @PostMapping ("/grupoestudio/form")
    public String save(@Valid Grupoestudio grupoestudio, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Grupo Estudio");
            return "gform";
        }

        grupoestudioService.save(grupoestudio);
        return "redirect:/grupoestudio/list";
    }

    @GetMapping("/grupoestudio/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            grupoestudioService.delete(id);
        }
        return "redirect:/grupoestudio/list";
    }

}



