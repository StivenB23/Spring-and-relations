package com.sena.learnspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sena.learnspringboot.model.IRolRepository;
import com.sena.learnspringboot.model.IUsuarioRepository;
import com.sena.learnspringboot.model.Rol;
import com.sena.learnspringboot.model.Usuario;

@Controller
public class UsuarioController {
    
   @Autowired
   private IUsuarioRepository usuarioRespository;

   @Autowired
   private IRolRepository rolRepository; 

   @GetMapping("usuarios")
   public String listarUsuario(Model model){
       List<Usuario> usuarios = usuarioRespository.findAll();
       model.addAttribute("usuarios", usuarios);
       return "views/usuarios/listarUsuarios";
   }

   @GetMapping("usuarios/new")
   public String formularioUsuario(Model model){
     Usuario usuario = new Usuario();
     List<Rol> roles = rolRepository.findAll();
     model.addAttribute("usuario",usuario);
     model.addAttribute("listaroles",roles);

     return "views/usuarios/formularioUsuarios";
   }
   @PostMapping("usuarios/guardar")
   public String guardarUsuario(Usuario usuario){
    usuarioRespository.save(usuario);
    return "redirect:/";
   }
}
