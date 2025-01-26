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
public class DaoCuidador extends Conexion {
    
    public boolean agregar(Cuidador cuidador) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "INSERT INTO cuidador (nit, nombre, apellido, correo, telefono, direccion, cargo, especializacion,clave) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cuidador.getNit());
            pst.setString(2, cuidador.getNombre());
            pst.setString(3, cuidador.getApellido());
            pst.setString(4, cuidador.getCorreo());
            pst.setString(5, cuidador.getTelefono());
            pst.setString(6, cuidador.getDireccion());
            pst.setString(7, cuidador.getCargo());
            pst.setString(8, cuidador.getEspecializacion());
            pst.setString(9, cuidador.getClave());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT -> " + ex);
            mensaje("Error al ejecutar el INSERT!!!", "Agregar");
            return false;
        }
    }

    public boolean consultar(Cuidador cuidador) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM cuidador WHERE Nit = ?";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cuidador.getNit());
            rst = pst.executeQuery();
            if (rst.next()) {
                cuidador.setNombre(rst.getString("nombre"));
                cuidador.setApellido(rst.getString("apellido"));
                cuidador.setCorreo(rst.getString("correo"));
                cuidador.setTelefono(rst.getString("telefono"));
                cuidador.setDireccion(rst.getString("direccion"));
                cuidador.setCargo(rst.getString("cargo"));
                cuidador.setEspecializacion(rst.getString("especializacion"));
                cuidador.setClave(rst.getString("clave"));
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT!!!", "Consultar");
        }
        return false;
    }

    public boolean actualizarCuidador(Cuidador cuidador) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "UPDATE cuidador SET nombre = ?, apellido = ?, correo = ?, telefono = ?, direccion = ?, cargo = ?, especializacion = ?, clave = ? WHERE Nit = ?";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, cuidador.getNombre());
            pst.setString(2, cuidador.getApellido());
            pst.setString(3, cuidador.getCorreo());
            pst.setString(4, cuidador.getTelefono());
            pst.setString(5, cuidador.getDireccion());
            pst.setString(6, cuidador.getCargo());
            pst.setString(7, cuidador.getEspecializacion());
            pst.setString(8, cuidador.getClave());
            pst.setInt(9, cuidador.getNit());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE!!!", "Actualizar");
            return false;
        }
    }

    public boolean eliminarCuidador(Cuidador cuidador) {
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "DELETE FROM cuidador WHERE Nit = ?";
        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cuidador.getNit());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE!!!", "Eliminar");
            return false;
        }
    }

    public List<Cuidador> obtenerTodosLosCuidadores() {
        List<Cuidador> lista = new ArrayList<>();
        Connection cnx = getConexion();
        PreparedStatement pst;
        String sql = "SELECT * FROM cuidador";
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                lista.add(new Cuidador(
                    rst.getInt("nit"),
                    rst.getString("nombre"),
                    rst.getString("apellido"),
                    rst.getString("correo"),
                    rst.getString("telefono"),
                    rst.getString("direccion"),
                    rst.getString("cargo"),
                    rst.getString("especializacion"),
                    rst.getString("clave")
                ));
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
        }
        return lista;
    }

    public ResultSet generarReporteCuidadores() {
        Connection cnx = getConexion();
        String sql = "SELECT nit, nombre, apellido, correo, telefono, direccion, cargo, especializacion, clave FROM cuidador";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException ex) {
            System.err.println("Error al generar el reporte de cuidadores: " + ex);
            JOptionPane.showMessageDialog(null, "Error al generar el reporte de cuidadores...", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void mensaje(String msj, String tit) {
        JOptionPane.showMessageDialog(null, msj, tit, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Cuidador consultarPorId(int idCuidador) {
    Connection cnx = getConexion();
    PreparedStatement pst;
    ResultSet rst;
    Cuidador cuidador = null;
    
    String sql = "SELECT * FROM cuidador WHERE nit = ?";
    
    try {
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, idCuidador);
        rst = pst.executeQuery();
        
        if (rst.next()) {
            cuidador = new Cuidador();
            cuidador.setNombre(rst.getString("nombre"));
            cuidador.setCargo(rst.getString("cargo"));
            cuidador.setCorreo(rst.getString("correo"));
            cuidador.setEspecializacion(rst.getString("especializacion"));
            cuidador.setTelefono(rst.getString("telefono"));
        }
    } catch (SQLException ex) {
        System.err.println("Error al consultar el cuidador: " + ex);
    }
    
    return cuidador;
}

    public boolean existeCuidador(int nit, String clave) {
    String sql = "SELECT COUNT(*) FROM cuidador WHERE nit = ? AND clave = ?";
    Connection cnx = getConexion();
    PreparedStatement pst;
    try{
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, nit);
        pst.setString(2, clave);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al verificar cuidador: " + e.getMessage());
    }
    return false; 
}

    
    public String obtenerNombreCuidador(int idCuidador) {
    String nombreCuidador = null;
    Connection cnx = getConexion();
    PreparedStatement pst;
    ResultSet rst;
    
    String sql = "SELECT nombre FROM cuidador WHERE idCuidador = ?";
    
    try {
        pst = cnx.prepareStatement(sql);
        pst.setInt(1, idCuidador);
        rst = pst.executeQuery();
        
        if (rst.next()) {
            nombreCuidador = rst.getString("nombre");
        }
    } catch (SQLException ex) {
        System.err.println("Error al obtener el nombre del cuidador: " + ex);
    }
    
    return nombreCuidador;
}

    
}
