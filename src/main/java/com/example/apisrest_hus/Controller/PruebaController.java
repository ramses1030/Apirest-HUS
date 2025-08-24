package com.example.apisrest_hus.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * - Indica que esta clase es un controlador REST.
 * - Combina @Controller y @ResponseBody.
 * - No vistas HTML, solo respuestas JSON.
 * - Los métodos de esta clase devolverán datos en formato JSON.
 * - Controlador REST: Es una clase en Java que maneja solicitudes HTTP y devuelve respuestas en formato JSON o XML.
 */

@RequestMapping("/micontroller") 
@RestController //Configuramos una URL para todos los metodos del controlador

public class PruebaController {

    @GetMapping
    public String saludar() {
        return "Hola desde el controlador REST";
    }

}

