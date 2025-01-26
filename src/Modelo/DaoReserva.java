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
        String sql = "INSERT INTO reserva (IDReserva, IDServiciooo, IDMascota, FechaReserva) VALUES (?, ?, ?, ?)";
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
                reserva.setIDServicio(rst.getInt("IDServiciooo"));
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
                    rst.getInt("IDServiciooo"),
                    rst.getInt("IDMascota"),
                    rst.getInt("IDCliente"),
                    rst.getInt("IDCuidador"),
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
    
    public boolean asignarCuidadorAReserva(int idReserva, int idCuidador) {
    Connection cnx = getConexion();
    PreparedStatement pst;
    String sql = "UPDATE reserva SET IDCuidador = ? WHERE IDReserva = ?";
    try {
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, idCuidador);
        pst.setInt(2, idReserva);
        int filasAfectadas = pst.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException ex) {
        System.err.println("Error al asignar cuidador -> " + ex);
        mensaje("Error al asignar cuidador!!!", "Asignar Cuidador");
        return false;
    }
}
    
    public List<Reserva> obtenerReservasSinCuidador() {
    List<Reserva> lista = new ArrayList<>();
    Connection cnx = getConexion();
    String sql = "SELECT * FROM reserva WHERE IDCuidador IS NULL";
    try (PreparedStatement pst = cnx.prepareStatement(sql); ResultSet rst = pst.executeQuery()) {
        while (rst.next()) {
            lista.add(new Reserva(
                rst.getInt("IDReserva"),
                rst.getInt("IDServiciooo"),
                rst.getInt("IDMascota"),
                rst.getInt("IDCliente"),
                0,
                rst.getDate("FechaReserva").toLocalDate()
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        mensaje("Error al obtener reservas sin cuidador: " + e.getMessage(), "Error");
    }
    return lista;
}

public List<Reserva> obtenerReservasPorMascota(int idMascota) {
    List<Reserva> lista = new ArrayList<>();
    Connection cnx = getConexion();
    PreparedStatement pst;
    String sql = "SELECT r.*, s.Nombre AS NombreServicio FROM reserva r "
                + "JOIN servicio s ON r.IDServiciooo = s.IDServicio "
                + "WHERE r.IDMascota = ?";
    ResultSet rst;
    try {
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, idMascota);
        rst = pst.executeQuery();
        while (rst.next()) {
            
            Reserva reserva = new Reserva(
                rst.getInt("IDReserva"),
                rst.getInt("IDServiciooo"),
                rst.getInt("IDMascota"),
                rst.getInt("IDCliente"),
                rst.getInt("IDCuidador"),
                rst.getDate("FechaReserva").toLocalDate()
            );

            
            Servicio servicio = new Servicio();
            servicio.setNombre(rst.getString("NombreServicio"));
            reserva.setServicio(servicio);

            lista.add(reserva);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        mensaje("Error al obtener reservas de la mascota: " + e.getMessage(), "Error");
    }
    return lista;
}


public List<Reserva> obtenerReservasPorCuidador(int idCuidador) {
    List<Reserva> reservas = new ArrayList<>();
    String query = "SELECT * FROM reserva WHERE idCuidador = ?";
    Connection cnx = getConexion();
    PreparedStatement pst;
    
    try {
        pst = cnx.prepareStatement(query);
        pst.setInt(1, idCuidador);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            Reserva reserva = new Reserva();
            reserva.setIDReserva(rs.getInt("IDReserva"));
            reserva.setIDMascota(rs.getInt("IDMascota"));
            
            reservas.add(reserva);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener las reservas: " + e.getMessage());
    }
    
    return reservas;
}

    public Reserva consultarReservaPorId(int idReserva) {
    Connection cnx = getConexion();
    PreparedStatement pst;
    ResultSet rst;
    Reserva reserva = null;
    
    String sql = "SELECT * FROM reserva WHERE IDReserva = ?";
    
    try {
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, idReserva);
        rst = pst.executeQuery();
        
        if (rst.next()) {
            reserva = new Reserva();
            reserva.setIDReserva(rst.getInt("IDReserva"));
            reserva.setIDServicio(rst.getInt("IDServiciooo"));
            reserva.setIDMascota(rst.getInt("IDMascota"));
            reserva.setIDCliente(rst.getInt("IDCliente"));
            reserva.setIDCuidador(rst.getInt("IDCuidador"));
            reserva.setFechaReserva(rst.getDate("fechaReserva").toLocalDate());

        }
    } catch (SQLException ex) {
        System.err.println("Error al consultar la reserva: " + ex);
    }
    
    return reserva;
}

    
    
}
