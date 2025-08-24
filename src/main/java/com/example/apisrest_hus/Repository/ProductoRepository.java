package com.example.apisrest_hus.Repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apisrest_hus.entity.Estado_Producto;
import com.example.apisrest_hus.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByNombreProducto(String nombreProducto);

    Optional<Producto> findByIdProducto(Long idProducto);

    List<Producto> findByEstadoProducto(Estado_Producto estadoProducto);

    List<Producto> findByUsuario(String usuario);

    List<Producto> findByCalificacion(int calificacion);
}
