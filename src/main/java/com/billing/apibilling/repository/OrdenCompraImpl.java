package com.billing.apibilling.repository;

import com.billing.apibilling.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdenCompraImpl implements  OrdenCompra{

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Producto producto;

    @Override
    public List<Producto> listar() {
        List<Producto> row = null;
        try {
            String sql = "select * from t_producto where active = 1";
            row = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Producto.class));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    return row;
    }

    @Override
    public int actualizar(Producto producto) {
        int row = 0;
        try {
            String sql = "update t_producto set name=?,stock=?,category=?,price=?,active=? where id_product=?";
            logger.info(">>>>>>>>>> {}",sql);
            row = jdbcTemplate.update(sql,
                    producto.getName(),
                    producto.getStock(),
                    producto.getCategory(),
                    producto.getPrice(),
                    producto.getActive(),
                    producto.getIdProduct());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return row;
    }

    @Override
    public int insertar(Producto producto) {
        int row = 0;
        try {
            String sql = "insert into t_producto values(?,?,?,?,?,?)";
            row = jdbcTemplate.update(sql,
                    producto.getIdProduct(),
                    producto.getName(),
                    producto.getStock(),
                    producto.getCategory(),
                    producto.getPrice(),
                    producto.getActive());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return row;
    }

    @Override
    public int borrar(int id) {
        int row = 0;
        try {
            String sql = "delete from t_producto where id_product=?";
            row = jdbcTemplate.update(sql,id);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return row;
    }
}
