package com.sena.learnspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sena.learnspringboot.model.Categoria;
import com.sena.learnspringboot.model.ICategoriaRepository;

@Controller
public class CategoriaController {
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @GetMapping(value = "/categorias")
    public String listarCategorias(Model model){
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "views/categorias/listarCategorias";
    }

    @GetMapping(value="/categorias/new")
    public String mostrarFormulario(Model model){
        Categoria categoria=new Categoria();
       model.addAttribute("categoria", categoria);

        return "views/categorias/formularioCategoria";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }
}
