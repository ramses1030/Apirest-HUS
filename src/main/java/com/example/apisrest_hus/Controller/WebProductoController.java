package com.example.apisrest_hus.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.apisrest_hus.entity.Producto;
import com.example.apisrest_hus.service.ProductoService;

import com.example.apisrest_hus.entity.Producto;

@Controller
@RequestMapping("/productos")

public class WebProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "productos";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        productoService.registrarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Producto producto = productoService.buscarPorId(id).orElse(null);
        model.addAttribute("producto", producto);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }

}
