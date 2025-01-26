/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Nic
 */
public class DaoClienteMascotaReporte extends Conexion {
    
    public ResultSet generarReporteClienteMascota(int nitCliente) {
        Connection cnx = getConexion();
        String sql = "SELECT m.idmascota, m.nombre AS nombreMascota, m.raza, m.edad, m.peso, m.color, m.sexo, "+ "c.Nit AS idCliente, c.Nombre AS nombreCliente, c.Apellido AS apellidoCliente, c.correo "+ "FROM mascota AS m "+ "INNER JOIN cliente AS c ON m.nitCliente = c.Nit "+ "WHERE c.Nit = ?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, nitCliente); 
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.err.println("Error al buscar las mascotas: " + ex);
            JOptionPane.showMessageDialog(null, "Error al buscar las mascotas...", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }


    
    public ResultSet obtenerMascotaPorIdYCliente(int idmascota, int nitCliente) {
    Connection cnx = getConexion();
    String sql = "SELECT nombre, raza, edad FROM mascota WHERE idmascota = ? AND nitCliente = ?";
    PreparedStatement pst;
    try {
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, idmascota);  
        pst.setInt(2, nitCliente);
        return pst.executeQuery();  
    } catch (SQLException ex) {
        System.err.println("Error al obtener la mascota: " + ex);
        return null;
    }
}



    
}
