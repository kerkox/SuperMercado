/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import supermecado.ObjectNotFoundException;
import supermecado.Producto;

/**
 *
 * @author Sistemas
 */
public class ProductoDAO {

    public void guardar(Producto producto) throws Exception {
        Connection connection = Conexion.getInstance().getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into producto (codigo, nombre, costo) values (?,?,?)");
        stmt.setString(1, producto.getCodigo());
        stmt.setString(2, producto.getNombre());
        stmt.setInt(3, producto.getCostoUnitario());
        stmt.execute();
    }

    public List<Producto> buscarTodos() throws Exception {
        Connection connection = Conexion.getInstance().getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from producto");
        List<Producto> productos = new LinkedList<>();

        while (rs.next()) {
            productos.add(new Producto(rs.getString("codigo"), rs.getNString("nombre"), rs.getInt("costo")));
        }

        return productos;
    }
    public Producto buscar(String codigo) throws Exception {
        Connection connection = Conexion.getInstance().getConnection();
        PreparedStatement stmt = connection.prepareStatement("selct * from producto where codigo = ?");
        stmt.setString(1, codigo);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            return new Producto(rs.getString("codigo"), rs.getNString("nombre"), rs.getInt("costo"));
        }
        throw new ObjectNotFoundException(codigo);
    }

}
