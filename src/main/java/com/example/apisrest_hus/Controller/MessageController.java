package com.example.apisrest_hus.Controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.example.apisrest_hus.entity.Message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;



@RestController
@RequestMapping("/api/message")


public class MessageController {

    private List<Message> message = new ArrayList<>();

    // Constructor para inicializar algunos mensajes de ejemplo
    public MessageController() {
        message.add(new Message(1, "Hola mundo"));
        message.add(new Message(2, "Bienvenido a la API REST"));
        message.add(new Message(3, "Spring Boot es genial"));
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return message;
    }

    @GetMapping("/{id}")
    public Message obtenerMensajePorId(@PathVariable int id) {
        Optional<Message> mensajeEncontrado = message.stream()
        .filter(m -> m.getId() == id)
        .findFirst();
        return mensajeEncontrado.orElse(null);
    }

    @PostMapping
    public Message crearMensaje(@RequestBody Message nuevoMensaje) {
        message.add(nuevoMensaje);
        return nuevoMensaje;
    }

    @DeleteMapping("/{id}")
    public void eliminarMensaje(@PathVariable int id) {
        message.removeIf(m -> m.getId() == id);
    }
}