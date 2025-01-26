/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nic
 */
public class DaoReserva extends Conexion {
    
    public boolean Agregar(Reserva reserva) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "INSERT INTO reserva (IDReserva, IDServicio, IDMascota, FechaReserva) VALUES (?, ?, ?, ?)";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, reserva.getIDReserva());
            pst.setInt(2, reserva.getIDServicio());
            pst.setInt(3, reserva.getIDMascota());
            pst.setDate(4, Date.valueOf(reserva.getFechaReserva()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT->" + ex);
            mensaje("Error al ejecutar el INSERT!!!", "Agregar");
            return false;
        }
    }

    
    public boolean Consultar(Reserva reserva) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM reserva WHERE IDReserva = ?";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, reserva.getIDReserva());
            rst = pst.executeQuery();
            if (rst.next()) {
                reserva.setIDServicio(rst.getInt("IDServicio"));
                reserva.setIDMascota(rst.getInt("IDMascota"));
                reserva.setFechaReserva(rst.getDate("FechaReserva").toLocalDate());
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT!!!", "Consultar!!!");
        }
        return false;
    }
    

    public List<Reserva> obtenerReservasDeCliente(int idCliente) {
        List<Reserva> lista = new ArrayList<>();
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM reserva WHERE IDCliente = ?";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, idCliente);
            rst = pst.executeQuery();
            while (rst.next()) {
                lista.add(new Reserva(
                    rst.getInt("IDReserva"),
                    rst.getInt("IDServicio"),
                    rst.getInt("IDMascota"),
                    rst.getInt("IDCliente"),
                    rst.getDate("FechaReserva").toLocalDate()
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
    
    public List<Reserva> consultarReservasPorCliente(int nitCliente) {
        List<Reserva> lista = new ArrayList<>();
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM reserva WHERE nitCliente = ?";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, nitCliente);
            rst = pst.executeQuery();
            while (rst.next()) {
                lista.add(new Reserva(
                    rst.getInt("idReserva"),
                    rst.getInt("idServicio"),
                    rst.getInt("idMascota"),
                    rst.getInt("nitCliente"),
                    rst.getDate("fechaReserva").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
