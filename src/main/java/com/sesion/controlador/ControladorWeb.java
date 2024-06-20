package com.sesion.controlador;
// @author FabianCol

import com.sesion.dominio.Usuario;
import com.sesion.servicio.ServiceUser;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorWeb {

    @Autowired
    private ServiceUser userService;

    @GetMapping("/")
    public String inicio(Model model) {
        var userList = userService.listarUsers();
        log.info("Usuarios recuperados: MVC", userList);
        model.addAttribute("userList", userList);
        return ("index");
    }

    @GetMapping("/agregar")
    public String crearUsuario(Usuario usuario) {
        return ("modificar");
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@Valid Usuario usuario, Errors errors) {
        if(errors.hasErrors()){
         return ("modificar");
        }
        userService.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{idUser}")
    public String editarUsuario(Usuario usuario, Model model) {
        usuario = userService.encontrarUser(usuario);
        model.addAttribute("usuario", usuario);
        return ("modificar");
    }

      //Opcion 2 QueryParam
    /*
    @GetMapping("/editar")
    public String editarUsuario(Usuario usuario, Model model) {
        usuario = userService.encontrarUser(usuario);
        model.addAttribute("usuario", usuario);
        return ("modificar");
    }
    */

    /* Opcion 1
   @GetMapping("/eliminar/{idUser}")
    public String eliminarUsuario(Usuario usuario) {
        userService.eliminar(usuario);
        return "redirect:/";
    }
     */
    //Opcion 2 QueryParam
    @GetMapping("/eliminar")
    public String eliminarUsuario(Usuario usuario) {
        userService.eliminar(usuario);
        return "redirect:/";
    }
}
