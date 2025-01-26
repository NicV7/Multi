/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoServicio;
import Modelo.Servicio;
import Vista.Servicios;
import java.sql.*;
import Vista.ClientePrincipal;
import Vista.ServicioReservar;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nic
 */
public class CtlServicio implements ActionListener {
    
    
    private Servicio ser;
    private Servicios vser;
    private ServicioReservar vserre;
    private ViewPrincipal vpri;
    private DaoServicio daoser;
    private ClientePrincipal vclpri;

    public CtlServicio(Servicio ser, Servicios vser, ServicioReservar vserre, ViewPrincipal vpri, DaoServicio daoser, ClientePrincipal vclpri) {
        this.ser = ser;
        this.vser = vser;
        this.vserre = vserre;
        this.vpri = vpri;
        this.daoser = daoser;
        this.vclpri = vclpri;
        
        vser.BtnAtras.addActionListener(this);
        vser.BtnBuscar.addActionListener(this);
        vser.BtnReservar.addActionListener(this);
        vser.BtnGenerar.addActionListener(this);
    }

    

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vser.BtnAtras)){
            
            vser.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vclpri);
            vclpri.setVisible(true);

        }
        
        if(ev.getSource().equals(vser.BtnBuscar)){
            ser.setIDServicio(Integer.parseInt(vser.txtBusqueda.getText()));
            if(daoser.Consultar(ser)){
                vser.txtIDServicio.setText(Integer.toString(ser.getIDServicio()));
                vser.txtNombre.setText(ser.getNombre());
                vser.txtDescripcion.setText(ser.getDescripcion());
                vser.txtDuracionEstimada.setText(Integer.toString(ser.getDuracionEstimada()));
                vser.txtPrecio.setText(Double.toString(ser.getPrecio()));
                vser.txtDisponibilidad.setText(Integer.toString(ser.getDisponibilidad()));
                mensaje("Servicio Encontrado..", "Consultar");
            }else{
                mensaje("Servicio no existe", "Consultar");
            }
        }
        
        if(ev.getSource().equals(vser.BtnGenerar)){
            ResultSet rst = daoser.generarReporteServicios();
            if(rst != null){
                String[] tit = {"IDServicio","Nombre","Descripcion","DuracionEstimada","Disponibilidad","Precio"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                vser.Tabla.setModel(dtm);
                try {
                    while(rst.next()){
                        Object[] fila = {rst.getInt("IDServicio"),rst.getString("Nombre"),rst.getString("Descripcion"),rst.getInt("DuracionEstimada"),rst.getInt("Disponibilidad"),rst.getDouble("Precio")};
                        dtm.addRow(fila);
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al buscar los Servicios: "+ex.getMessage());
                    mensaje(null, "Error al generar el listado de mascota");
                }
            }
        }
        
        if(ev.getSource().equals(vser.BtnReservar)){
            vser.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vserre);
            vserre.setVisible(true);
            
            
            vserre.txtIDServicio.setText(vser.txtIDServicio.getText());
            vserre.txtServicio.setText(vser.txtNombre.getText());
            vserre.txtDuracionEstimada.setText(vser.txtDuracionEstimada.getText());
            vserre.txtPrecio.setText(vser.txtPrecio.getText());
            vserre.txtDisponibilidad.setText(vser.txtDisponibilidad.getText());
        }
        
        if(ev.getSource().equals(vser.BtnAtras)){
            
            vser.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vclpri);
            vclpri.setVisible(true);
            
        }
        
    }
    
    
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }
    
    
}
