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
public class DaoServicio extends Conexion {
    
    public boolean Agregar(Servicio servicio) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "INSERT INTO servicio (IDServicio, Nombre, Descripcion, DuracionEstimada, Disponibilidad, Precio) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, servicio.getIDServicio());
            pst.setString(2, servicio.getNombre());
            pst.setString(3, servicio.getDescripcion());
            pst.setInt(4, servicio.getDuracionEstimada());
            pst.setInt(5, servicio.getDisponibilidad());
            pst.setDouble(6, servicio.getPrecio());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT->" + ex);
            mensaje("Error al ejecutar el INSERT!!!", "Agregar");
            return false;
        }
    }
    
     public boolean Consultar(Servicio servicio) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM servicio WHERE IDServicio = ?";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, servicio.getIDServicio());
            rst = pst.executeQuery();
            if (rst.next()) {
                servicio.setNombre(rst.getString("Nombre"));
                servicio.setDescripcion(rst.getString("Descripcion"));
                servicio.setDuracionEstimada(rst.getInt("DuracionEstimada"));
                servicio.setDisponibilidad(rst.getInt("Disponibilidad"));
                servicio.setPrecio(rst.getDouble("Precio"));
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT!!!", "Consultar!!!");
        }
        return false;
    }

    public boolean actualizarServicio(Servicio servicio) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "UPDATE servicio SET Nombre = ?, Descripcion = ?, DuracionEstimada = ?, Disponibilidad = ?, Precio = ? WHERE IDServicio = ?";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, servicio.getNombre());
            pst.setString(2, servicio.getDescripcion());
            pst.setInt(3, servicio.getDuracionEstimada());
            pst.setInt(4, servicio.getDisponibilidad());
            pst.setDouble(5, servicio.getPrecio());
            pst.setInt(6, servicio.getIDServicio());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE->" + ex);
            mensaje("Error al ejecutar el UPDATE!!!", "Actualizar");
            return false;
        }
    }

    public boolean eliminarServicio(Servicio servicio) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "DELETE FROM servicio WHERE IDServicio = ?";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, servicio.getIDServicio());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE->" + ex);
            mensaje("Error al ejecutar el DELETE!!!", "Eliminar");
            return false;
        }
    }

    public List<Servicio> obtenerTodosLosServicios() {
        List<Servicio> lista = new ArrayList<>();
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM servicio";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                lista.add(new Servicio(
                    rst.getInt("IDServicio"),
                    rst.getString("Nombre"),
                    rst.getString("Descripcion"),
                    rst.getInt("DuracionEstimada"),
                    rst.getInt("Disponibilidad"),
                    rst.getDouble("Precio")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void mensaje(String msj, String tit) {
        JOptionPane.showMessageDialog(null, msj, tit, 1);
    }
    
    public ResultSet generarReporteServicios() {
    Connection cnx = getConexion();
    String sql = "SELECT IDServicio, Nombre, Descripcion, DuracionEstimada, Disponibilidad, Precio FROM servicio";
    PreparedStatement pst;
    try {
        pst = cnx.prepareStatement(sql);
        return pst.executeQuery();
    } catch (SQLException ex) {
        System.err.println("Error al buscar los servicios: " + ex);
        JOptionPane.showMessageDialog(null, "Error al buscar los servicios...", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
}

    
}
