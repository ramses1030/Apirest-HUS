package com.example.apisrest_hus.service;

import java.util.List;
import java.util.Optional;

import com.example.apisrest_hus.entity.Producto;
import com.example.apisrest_hus.entity.Estado_Producto;


public interface ProductoService {

    Producto registrarProducto(Producto producto);

    List<Producto> listarProductos();

    Optional<Producto> buscarPorNombre(String nombre);

    Optional<Producto> buscarPorId(Long id);

    Producto actualizarProducto(Long idProducto, Producto producto);

    void eliminarProducto(Long idProducto);

    Producto cambiarEstadoProducto(Long idProducto, Estado_Producto nuevoEstadoProducto);

    List<Producto> obtenerProductosPorEstado(Estado_Producto estadoProducto);

    List<Producto> obtenerProductosPorUsuario(String usuario);

    List<Producto> obtenerProductosPorCalificacion(int calificacion);

}
