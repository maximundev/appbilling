package com.billing.apibilling.service;

import com.billing.apibilling.model.Producto;
import com.billing.apibilling.repository.OrdenCompraImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraServicesImpl implements OrdenCompraService{

    @Autowired
    private OrdenCompraImpl ordenCompraImpl;
    @Override
    public List<Producto> listar() {
        return ordenCompraImpl.listar();
    }

    @Override
    public int actualizar(Producto producto) {
        return ordenCompraImpl.actualizar(producto);
    }

    @Override
    public int insertar(Producto producto) {
        return  ordenCompraImpl.insertar(producto);
    }

    @Override
    public int borrar(int id) {
        return ordenCompraImpl.borrar(id);
    }
}
