package com.sergiojavierre.dao;

import com.sergiojavierre.dao.productos.DAOProductos;
import com.sergiojavierre.dao.productos.DAOProductosORM;

import java.sql.SQLException;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOProductos daoProductos;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOProductos getDaoProductos() {
        if(daoProductos == null){
            try {
                daoProductos = new DAOProductosORM();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return daoProductos;
    }
}
