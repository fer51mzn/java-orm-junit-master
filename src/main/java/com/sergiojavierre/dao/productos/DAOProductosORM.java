package com.sergiojavierre.dao.productos;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.sergiojavierre.db.DBConnectionORM;
import com.sergiojavierre.entities.Producto;

import java.sql.SQLException;
import java.util.List;

public class DAOProductosORM implements DAOProductos {

    Dao<Producto, String> daoProductosORM;

    public DAOProductosORM() throws SQLException {
        this.daoProductosORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),
                Producto.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),
                daoProductosORM);
    }

    @Override
    public List<Producto> list() {
        try {
            return daoProductosORM.queryForAll();
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public Producto get(int id) {
        try {
            return daoProductosORM.queryForId(String.valueOf(id));
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public void add(Producto producto) {
        try {
            daoProductosORM.create(producto);
        } catch (SQLException throwables) {

        }
    }

    @Override
    public void clear() {
        try {
            daoProductosORM.delete(list());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
