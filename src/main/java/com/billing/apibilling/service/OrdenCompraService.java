package com.billing.apibilling.service;

import com.billing.apibilling.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdenCompraService {

    public List<Producto> listar();

    public int actualizar(Producto producto);

    public int insertar(Producto producto);

    public int borrar(int id);
}
