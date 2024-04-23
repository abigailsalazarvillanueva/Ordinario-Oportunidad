
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
import mx.utng.ultima.model.entity.Solicitud;
import mx.utng.ultima.model.service.ISolictudService;





@Controller
@SessionAttributes("solicitud")
public class SolicitudController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private ISolictudService solicitudService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/solicitud/list","/solicitud/","/solicitud/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Solicitud de Vacaciones");
    model.addAttribute("solicitudes", solicitudService.list());
    return "slist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/solicitud/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Solicitud de Vacaciones");
        model.addAttribute("solicitud", new Solicitud());
        return "sform";
    }

    @GetMapping("/solicitud/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Solicitud solicitud  = null;
        if (id>0) {
            solicitud = solicitudService.getById(id);
        }else{
            return "redirect:/solicitud/list";
        }

        model.addAttribute("title", "Editar solicitud de vacaciones");
        model.addAttribute("solicitud", solicitud);
        return "sform";
    }


    @PostMapping ("/solicitud/form")
    public String save(@Valid Solicitud solicitud , BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Solicitud de Vacaciones");
            return "sform";
        }

        solicitudService.save(solicitud);
        return "redirect:/solicitud/list";
    }

    @GetMapping("/solicitud/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            solicitudService.delete(id);
        }
        return "redirect:/solicitud/list";
    }

}




