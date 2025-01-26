/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nic
 */
public class DaoCliente extends Conexion {
    
    public boolean Agregar(Cliente cliente) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "INSERT INTO cliente (Nit, Nombre, Apellido, correo, clave) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cliente.getNit());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getCorreo());
            pst.setString(5, cliente.getClave());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT->"+ex);
            mensaje("Error al ejecutar el INSERT!!!", "Agregar");
            return false;
        }
    }
    
    public boolean Consultar (Cliente cl) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM cliente WHERE Nit = ?";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cl.getNit());
            rst = pst.executeQuery();
            if (rst.next()) {
                cl.setNombre(rst.getString("Nombre"));
                cl.setApellido(rst.getString("Apellido"));
                cl.setCorreo(rst.getString("correo"));
                cl.setClave(rst.getString("clave"));
            }
            return true;
            
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> "+ex);
            mensaje("Error al ejecutar el SELECT!!!","Consultar!!!");
        }
        return false;
    }
    
    public boolean actualizarCliente(Cliente cliente) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "UPDATE cliente SET Nombre = ?, Apellido = ?, correo = ?, clave = ? WHERE Nit = ?";
        try{
            pst = cnx.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getCorreo());
            pst.setString(4, cliente.getClave());
            pst.setInt(5, cliente.getNit());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE->"+ex);
            mensaje("Error al ejecutar el UPDATE!!!", "actualizar");
            return false;
        }
    }

    public boolean eliminarCliente(Cliente cl) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "DELETE FROM cliente WHERE Nit = ?";
        try{
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cl.getNit());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE->"+ex);
            mensaje("Error al ejecutar el DELETE!!!", "Eliminar");
            return false;
        }
    }
    
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> lista = new ArrayList<>();
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM Cliente";
        ResultSet rst;
        try{
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                lista.add(new Cliente(
                    rst.getInt("nit"),
                    rst.getString("nombre"),
                    rst.getString("apellido"),
                    rst.getString("correo"),
                    rst.getString("clave")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    public void mensaje(String msj, String tit){
        
        JOptionPane.showMessageDialog(null, msj,tit,1);
    }
    
    
}
