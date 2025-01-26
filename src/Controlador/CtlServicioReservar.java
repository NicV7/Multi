/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.DaoClienteMascotaReporte;
import Modelo.DaoReserva;
import Modelo.DaoServicio;
import Modelo.Mascota;
import Modelo.Reserva;
import Modelo.Servicio;
import Vista.ServicioReservar;
import Vista.Servicios;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author Nic
 */
public class CtlServicioReservar implements ActionListener {
    
    private Servicio ser;
    private Reserva res;
    private Mascota ma;
    private DaoClienteMascotaReporte daoclmare;
    private DaoReserva daore;
    private Cliente cl;
    private Servicios vser;
    private ServicioReservar vserre;
    private ViewPrincipal vpri;
    private DaoServicio daoSer;

    public CtlServicioReservar(Servicio ser, Reserva res, Mascota ma, DaoClienteMascotaReporte daoclmare, DaoReserva daore, Cliente cl, Servicios vser, ServicioReservar vserre, ViewPrincipal vpri, DaoServicio daoSer) {
        this.ser = ser;
        this.res = res;
        this.ma = ma;
        this.daoclmare = daoclmare;
        this.daore = daore;
        this.cl = cl;
        this.vser = vser;
        this.vserre = vserre;
        this.vpri = vpri;
        this.daoSer = daoSer;
        
        vserre.BtnAtras.addActionListener(this);
        vserre.BtnBuscar.addActionListener(this);
        vserre.BtnGenerar.addActionListener(this);
        vserre.BtnConfrimarReserva.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vserre.BtnAtras)){
            
            vserre.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vser);
            vser.setVisible(true);
            
        }
        
        if(ev.getSource().equals(vserre.BtnBuscar)){
            int idmascota = Integer.parseInt(vserre.txtBuscar.getText());
            int nitClienteLogeado = cl.getNit();
            ResultSet rst = daoclmare.obtenerMascotaPorIdYCliente(idmascota, nitClienteLogeado);
    
            try {
                if(rst != null && rst.next()){
                String nombremascota = rst.getString("nombre");
                String razamascota = rst.getString("raza");
                int edadmascota = rst.getInt("edad");
                vserre.txtIDMascota.setText(Integer.toString(idmascota));
                vserre.txtNombre.setText(nombremascota);
                vserre.txtRaza.setText(razamascota);
                vserre.txtEdad.setText(Integer.toString(edadmascota));
                } else {
                JOptionPane.showMessageDialog(null, "No se encontró una mascota asociada con este cliente.");
                }
            } catch (Exception e) {
                System.err.println("Error al realizar la busqueda");
                JOptionPane.showMessageDialog(null, "Error al realizar la busqueda.");
            }
        }
        
        if(ev.getSource().equals(vserre.BtnGenerar)){
            int nitCliente = cl.getNit();
            ResultSet rst = daoclmare.generarReporteClienteMascota(nitCliente);
            if(rst != null){
                String[] tit = {"idmascota","nombre","raza","edad","sexo"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                vserre.Tabla.setModel(dtm);
                try {
                    while(rst.next()){
                        Object[] fila = {rst.getInt("idmascota"),rst.getString("nombreMascota"),rst.getString("raza"),rst.getInt("edad"),rst.getString("sexo")};
                        dtm.addRow(fila);
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al buscar las mascotas: "+ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al generar el listado de mascotas","Error",1);
                }
            }  
        }
        
        if(ev.getSource().equals(vserre.BtnConfrimarReserva)){
            int nitCliente = cl.getNit();
            if(ser.getDisponibilidad() > 0){
                res.setIDCliente(nitCliente);
                res.setIDMascota(Integer.parseInt(vserre.txtBuscar.getText()));
                res.setIDServicio(Integer.parseInt(vserre.txtIDServicio.getText()));
                res.setFechaReserva(LocalDate.parse(vserre.txtFechaReserva.getText()));

                if(daore.Agregar(res)){
                    boolean disponibilidadActualizada = daoSer.actualizarDisponibilidad(Integer.parseInt(vserre.txtIDServicio.getText()));

                if(disponibilidadActualizada) {
                    mensaje("Reserva Confirmada..", "Confirmar");
                } else {
                    mensaje("Error al actualizar la disponibilidad", "Error");
                }
            } else {
                mensaje("No se pudo confirmar la reserva", "Confirmar");
            }
        }
    }
}

    
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }

}
