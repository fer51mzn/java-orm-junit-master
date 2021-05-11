package com.sergiojavierre.dao.productos;

import com.sergiojavierre.entities.Producto;

import java.util.List;

public interface DAOProductos {

    public List<Producto> list();
    public Producto get(int id);
    public void add(Producto producto);
    public void clear();

}
