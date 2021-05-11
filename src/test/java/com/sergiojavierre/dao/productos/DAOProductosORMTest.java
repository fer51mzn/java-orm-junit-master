package com.sergiojavierre.dao.productos;

import com.sergiojavierre.dao.DAOFactory;
import com.sergiojavierre.entities.Producto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DAOProductosORMTest {

    @BeforeAll
    @AfterAll
    static void clearDatabase(){
        DAOFactory.getInstance().getDaoProductos().clear();
    }

    @Test
    void addProducto(){
        Producto expected = new Producto(1,"PC");
        DAOFactory.getInstance().getDaoProductos().add(expected);
        Producto producto = DAOFactory.getInstance().getDaoProductos().get(expected.getId());
        assertEquals(expected.getId(), producto.getId());
    }

}