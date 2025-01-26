/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
import java.util.List;
/**
 *
 * @author Nic
 */
public class DaoFactura extends Conexion {
    
    public int guardarFactura(Facturas factura) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "INSERT INTO FACTURAS (id_cliente, id_mascota, total) VALUES (?, ?, ?)";
        try{
            pst = cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, factura.getIdCliente());
            pst.setInt(2, factura.getIdMascota());
            pst.setDouble(3, factura.getTotal());
            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar factura: " + e.getMessage());
        }
        return -1;
    }

    public void guardarDetalleFactura(int idFactura, int idServicio, Double precio) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "INSERT INTO DETALLE_FACTURA (id_factura, id_servicio, precio) VALUES (?, ?, ?)";
        try{
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, idFactura);
            pst.setInt(2, idServicio);
            pst.setDouble(3, precio);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al guardar detalle de factura: " + e.getMessage());
        }
    }
    
    
}

