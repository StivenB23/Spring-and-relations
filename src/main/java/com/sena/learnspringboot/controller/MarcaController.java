package com.sena.learnspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sena.learnspringboot.model.Categoria;
import com.sena.learnspringboot.model.ICategoriaRepository;
import com.sena.learnspringboot.model.IMarcaRepository;
import com.sena.learnspringboot.model.Marca;

@Controller
public class MarcaController {
    
    @Autowired
    private IMarcaRepository marcaRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @GetMapping("/marcas")
    public String mostrarMarcas(Model model){
      model.addAttribute("marcas", marcaRepository.findAll());
    return "views/marcas/listarMarcas"; 
   }

    @GetMapping("/marcas/new")
    public String mostrarFormularioCrearMarca(Model model){
        List<Categoria> listarCategoria = categoriaRepository.findAll();
        Marca marca =new Marca();
        model.addAttribute("categorias", listarCategoria);
        model.addAttribute("marca", marca);
        return "views/marcas/formularioMarca";
    }

    @PostMapping("marcas/guardar")
    public String guardarMarca(Marca marca){
    marcaRepository.save(marca);
    return "redirect:/";
    }

}
