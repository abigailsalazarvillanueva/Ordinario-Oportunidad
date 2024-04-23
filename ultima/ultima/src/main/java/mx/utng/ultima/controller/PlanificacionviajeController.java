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

import mx.utng.ultima.model.entity.Planificacionviaje;
import mx.utng.ultima.model.service.IPlanificacionviajeService;




@Controller
@SessionAttributes("planificacionviaje")
public class PlanificacionviajeController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IPlanificacionviajeService planificacionviajeService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/planificacionviaje/list","/planificacionviaje/","/planificacionviaje/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de planificacion de viajes");
    model.addAttribute("planificacionviajes", planificacionviajeService.list());
    return "plist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/planificacionviaje/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Planificacion de viajes");
        model.addAttribute("planificacionviaje", new Planificacionviaje());
        return "pform";
    }

    @GetMapping("/planificacionviaje/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Planificacionviaje planificacionviaje  = null;
        if (id>0) {
            planificacionviaje = planificacionviajeService.getById(id);
        }else{
            return "redirect:/planificacionviaje/list";
        }

        model.addAttribute("title", "Editar planificacion  viaje");
        model.addAttribute("planificacionviaje", planificacionviaje);
        return "pform";
    }


    @PostMapping ("/planificacionviaje/form")
    public String save(@Valid Planificacionviaje planificacionviaje , BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Planificacion de viajes");
            return "pform";
        }

        planificacionviajeService.save(planificacionviaje);
        return "redirect:/planificacionviaje/list";
    }

    @GetMapping("/planificacionviaje/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            planificacionviajeService.delete(id);
        }
        return "redirect:/planificacionviaje/list";
    }

}




