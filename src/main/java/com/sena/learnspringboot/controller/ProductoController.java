package com.sena.learnspringboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sena.learnspringboot.model.ICategoriaRepository;
import com.sena.learnspringboot.model.IProductoRepository;
import com.sena.learnspringboot.model.Producto;

@Controller
public class ProductoController {
    
    @Autowired
    private IProductoRepository productRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @GetMapping(value = "/productos")
    public String listarCategorias(Model model){
        List<Producto> productos = productRepository.findAll();
        model.addAttribute("productos", productos);
        return "views/productos/listarProductos";
    }

    @GetMapping("/productos/new")
    public String mostrarFormularioProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "views/productos/formularioProducto";
    }
    @GetMapping(value = "/productos/editar/{id}")
    public String mostratFormularioActualizacion(@PathVariable("id") Integer id,Model model){
        Producto producto = productRepository.findById(id).get();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "views/productos/formularioProducto";
    }
    @GetMapping(value = "/productos/eliminar/{id}")
    public String eliminarproducto(@PathVariable("id") Integer id){
         productRepository.deleteById(id);
        return "redirect:/productos";
    }
    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto){
        productRepository.save(producto);
        return "redirect:/productos";
    }

}
