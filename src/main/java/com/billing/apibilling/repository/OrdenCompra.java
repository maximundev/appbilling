package com.billing.apibilling.repository;

import com.billing.apibilling.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompra {

    public List<Producto> listar();

    public int actualizar(Producto producto);

    public int insertar(Producto producto);

    public int borrar(int id);
}
