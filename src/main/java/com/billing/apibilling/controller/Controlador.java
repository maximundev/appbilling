package com.billing.apibilling.controller;

import com.billing.apibilling.model.Producto;
import com.billing.apibilling.model.ServiceResponse;
import com.billing.apibilling.service.OrdenCompraServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Controlador {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrdenCompraServicesImpl ordenCompraServiceImpl;

    private ServiceResponse serviceResponse = new ServiceResponse();

    @PostMapping("/v1/listar")
    public List<Producto> listarProductos(){
        List<Producto> row;
        row = ordenCompraServiceImpl.listar();
        return row;

    }

    @PostMapping("/v1/insertar")
    public ResponseEntity<ServiceResponse> insertar(@RequestBody Producto producto){
        int row = ordenCompraServiceImpl.insertar(producto);
        if (row==1) {
            serviceResponse.setMessage("Product insert success");
        } else {
            serviceResponse.setMessage("Product insert failed");
        }
        return  new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/v1/actualizar")
    public ResponseEntity<ServiceResponse> actualizar(@RequestBody Producto producto){
        int row = ordenCompraServiceImpl.actualizar(producto);
        if (row==1) {
            serviceResponse.setMessage("Product update success");
        } else {
            serviceResponse.setMessage("Product update failed");
        }
        return  new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping ("/v1/eliminar")
    public ResponseEntity<ServiceResponse> eliminar(
            @RequestParam(required = true) int id){
        logger.info(">>>>>>>>>>>>>> {}",id);
        int row = ordenCompraServiceImpl.borrar(id);
        if (row==1) {
            serviceResponse.setMessage("Product delete success");
        } else {
            serviceResponse.setMessage("Product delete failed");
        }
        return  new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
