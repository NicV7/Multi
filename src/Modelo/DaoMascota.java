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
public class DaoMascota extends Conexion {
    
    public boolean Agregar(Mascota mascota) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "INSERT INTO mascota (idmascota, nombre, raza, edad, peso, color, sexo, nitCliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, mascota.getIdMascota());
            pst.setString(2, mascota.getNombre());
            pst.setString(3, mascota.getRaza());
            pst.setInt(4, mascota.getEdad());
            pst.setDouble(5, mascota.getPeso());
            pst.setString(6, mascota.getColor());
            pst.setString(7, mascota.getSexo());
            pst.setInt(8, mascota.getNitCliente());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT->" + ex);
            mensaje("Error al ejecutar el INSERT!!!", "Agregar");
            return false;
        }
    }

    public boolean Consultar(Mascota mascota) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM mascota WHERE idmascota = ?";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, mascota.getIdMascota());
            rst = pst.executeQuery();
            if (rst.next()) {
                mascota.setNombre(rst.getString("nombre"));
                mascota.setRaza(rst.getString("raza"));
                mascota.setEdad(rst.getInt("edad"));
                mascota.setPeso(rst.getDouble("peso"));
                mascota.setColor(rst.getString("color"));
                mascota.setSexo(rst.getString("sexo"));
                mascota.setNitCliente(rst.getInt("nitCliente"));
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT!!!", "Consultar!!!");
        }
        return false;
    }

    public boolean actualizarMascota(Mascota mascota) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "UPDATE mascota SET nombre = ?, raza = ?, edad = ?, peso = ?, color = ?, sexo = ?, nitCliente = ? WHERE idmascota = ?";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, mascota.getNombre());
            pst.setString(2, mascota.getRaza());
            pst.setInt(3, mascota.getEdad());
            pst.setDouble(4, mascota.getPeso());
            pst.setString(5, mascota.getColor());
            pst.setString(6, mascota.getSexo());
            pst.setInt(7, mascota.getNitCliente());
            pst.setInt(8, mascota.getIdMascota());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE->" + ex);
            mensaje("Error al ejecutar el UPDATE!!!", "Actualizar");
            return false;
        }
    }

    public boolean eliminarMascota(Mascota mascota) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "DELETE FROM mascota WHERE idmascota = ?";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, mascota.getIdMascota());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE->" + ex);
            mensaje("Error al ejecutar el DELETE!!!", "Eliminar");
            return false;
        }
    }

    
    public void mensaje(String msj, String tit) {
        JOptionPane.showMessageDialog(null, msj, tit, 1);
    }
    
    public Mascota obtenerMascotaPorId(int idMascota) {
    Mascota mascota = null;
    String query = "SELECT * FROM mascota WHERE idMascota = ?";
    Connection cnx = getConexion();
    PreparedStatement pst;
    try{
        pst = cnx.prepareStatement(query);
        pst.setInt(1, idMascota);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            mascota = new Mascota();
            mascota.setIdMascota(rs.getInt("idMascota"));
            mascota.setNombre(rs.getString("nombre"));
            mascota.setRaza(rs.getString("raza"));
            mascota.setEdad(rs.getInt("edad"));
            mascota.setColor(rs.getString("color"));
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener la mascota por ID: " + e.getMessage());
    }
    
    return mascota;
}

    public String obtenerNombreMascota(int idMascota) {
    String nombreMascota = null;
    Connection cnx = getConexion();
    PreparedStatement pst;
    ResultSet rst;
    
    String sql = "SELECT nombre FROM mascota WHERE idMascota = ?";
    
    try {
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, idMascota);
        rst = pst.executeQuery();
        
        if (rst.next()) {
            nombreMascota = rst.getString("nombre");
        }
    } catch (SQLException ex) {
        System.err.println("Error al obtener el nombre de la mascota: " + ex);
    }
    
    return nombreMascota;
}

    
}
