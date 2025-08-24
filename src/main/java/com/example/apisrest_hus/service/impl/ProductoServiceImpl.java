package com.example.apisrest_hus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apisrest_hus.Repository.ProductoRepository;
import com.example.apisrest_hus.service.ProductoService;

import lombok.SneakyThrows;

import com.example.apisrest_hus.entity.Producto;
import com.example.apisrest_hus.entity.Estado_Producto;
import java.util.List;
import java.util.Optional;

@Service

public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto registrarProducto(Producto producto) {
        // Implementación del registro de un producto
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();

    }

    @Override
    public Optional<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreProducto(nombre);
    }

    @Override
    public Optional<Producto> buscarPorId(Long idProducto) {
        return productoRepository.findByIdProducto(idProducto);
    }

    @Override
    @SneakyThrows
    public Producto actualizarProducto(Long idProducto, Producto producto) {
        Producto productoExistente = productoRepository.findByIdProducto(idProducto)
                .orElseThrow(() -> new Exception("Producto con ID" + idProducto + " no encontrado"));

        productoExistente.setNombreProducto(producto.getNombreProducto());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setCantidad(producto.getCantidad());
        productoExistente.setEstadoProducto(producto.getEstadoProducto());

        return productoRepository.save(productoExistente);
    }

    @Override
    @SneakyThrows
    public void eliminarProducto(Long idProducto) {
        productoRepository.findByIdProducto(idProducto)
                .orElseThrow(() -> new Exception("Producto con ID" + idProducto + " no encontrado"));
        productoRepository.deleteById(idProducto);
    }

    @Override
    @SneakyThrows
    public Producto cambiarEstadoProducto(Long idProducto, Estado_Producto nuevoEstadoProducto) {
    Producto productoExistente = productoRepository.findByIdProducto(idProducto)
            .orElseThrow(() -> new Exception("Producto con ID" + idProducto + " no encontrado"));
    productoExistente.setEstadoProducto(nuevoEstadoProducto);
    return productoRepository.save(productoExistente);
}

    @Override
    public List<Producto> obtenerProductosPorEstado(Estado_Producto estadoProducto) {
        return productoRepository.findByEstadoProducto(estadoProducto);
    }

    @Override
    public List<Producto> obtenerProductosPorUsuario(String usuario) {
        return productoRepository.findByUsuario(usuario);
    }

    @Override
    public List<Producto> obtenerProductosPorCalificacion(int calificacion) {
        return productoRepository.findByCalificacion(calificacion);
    }

}
