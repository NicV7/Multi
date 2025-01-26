/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoServicio;
import Modelo.Servicio;
import Vista.AdminPrincipal;
import Vista.GestionServicios;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nic
 */
public class CtlGestionServicios implements ActionListener {
    
    private Servicio ser;
    private DaoServicio daoser;
    private ViewPrincipal vpri;
    private AdminPrincipal vadpri;
    private GestionServicios vgesser;

    public CtlGestionServicios(Servicio ser, DaoServicio daoser, ViewPrincipal vpri, AdminPrincipal vadpri, GestionServicios vgesser) {
        this.ser = ser;
        this.daoser = daoser;
        this.vpri = vpri;
        this.vadpri = vadpri;
        this.vgesser = vgesser;
        
        vgesser.BtnAtras.addActionListener(this);
        vgesser.BtnAgregar.addActionListener(this);
        vgesser.BtnConsultar.addActionListener(this);
        vgesser.BtnEliminar.addActionListener(this);
        vgesser.BtnActualizar.addActionListener(this);
        vgesser.BtnLimpiar.addActionListener(this);
        vgesser.BtnGenerar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vgesser.BtnAtras)){
            
            vgesser.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vadpri);
            vadpri.setVisible(true);
            
        }
        
        if(ev.getSource().equals(vgesser.BtnAgregar)){
            ser.setIDServicio(Integer.parseInt(vgesser.txtIDServicio.getText()));
            ser.setNombre(vgesser.txtNombre.getText());
            ser.setDescripcion(vgesser.txtDescripcion.getText());
            ser.setDisponibilidad(Integer.parseInt(vgesser.txtDisponibilidad.getText()));
            ser.setPrecio(Double.parseDouble(vgesser.txtPrecio.getText()));
            ser.setDuracionEstimada(Integer.parseInt(vgesser.txtDuracionEstimada.getText()));
            if(daoser.Agregar(ser)){
                mensaje("Servicio agregado correctamente..", "Agregar");
            }else{
                mensaje("Servicio no se pudo agregar", "Agregar");
            }
        }
        
        if(ev.getSource().equals(vgesser.BtnConsultar)){
            ser.setIDServicio(Integer.parseInt(vgesser.txtIDServicio.getText()));
            if(daoser.Consultar(ser)){
                vgesser.txtIDServicio.setText(Integer.toString(ser.getIDServicio()));
                vgesser.txtNombre.setText(ser.getNombre());
                vgesser.txtDescripcion.setText(ser.getDescripcion());
                vgesser.txtDisponibilidad.setText(Integer.toString(ser.getDisponibilidad()));
                vgesser.txtPrecio.setText(Double.toString(ser.getPrecio()));
                vgesser.txtDuracionEstimada.setText(Integer.toString(ser.getDuracionEstimada()));
                mensaje("Servicio encontrado..", "Consultar");
            }else{
                mensaje("No existe el servicio", "Consultar");
            }
        }
        
        if(ev.getSource().equals(vgesser.BtnActualizar)){
            ser.setIDServicio(Integer.parseInt(vgesser.txtIDServicio.getText()));
            ser.setNombre(vgesser.txtNombre.getText());
            ser.setDescripcion(vgesser.txtDescripcion.getText());
            ser.setDisponibilidad(Integer.parseInt(vgesser.txtDisponibilidad.getText()));
            ser.setPrecio(Double.parseDouble(vgesser.txtPrecio.getText()));
            ser.setDuracionEstimada(Integer.parseInt(vgesser.txtDuracionEstimada.getText()));
            if(daoser.actualizarServicio(ser)){
                mensaje("Servicio actualizado correctamente..", "Actualizar");
            }else{
                mensaje("Servicio no se pudo actualizar", "Actualizar");
            }
        }
        
        if(ev.getSource().equals(vgesser.BtnEliminar)){
           ser.setIDServicio(Integer.parseInt(vgesser.txtIDServicio.getText()));
           if(daoser.eliminarServicio(ser)){
               mensaje("Servicio eliminado..", "Eliminar");
           }else{
               mensaje("Servicio no se pudo eliminar", "Eliminar");
           }
        }
        
        if(ev.getSource().equals(vgesser.BtnLimpiar)){
            limpiar();
        }
        
        if(ev.getSource().equals(vgesser.BtnGenerar)){
            ResultSet rst = daoser.generarReporteServicios();
            if(rst != null){
                String[] tit = {"IDServicio","Nombre","Descripcion","DuracionEstimada","Disponibilidad","Precio"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                vgesser.Tabla.setModel(dtm);
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
        
    }
    
    public void limpiar(){
        
        vgesser.txtIDServicio.setText(null);
        vgesser.txtNombre.setText(null);
        vgesser.txtDescripcion.setText(null);
        vgesser.txtDisponibilidad.setText(null);
        vgesser.txtDuracionEstimada.setText(null);
        vgesser.txtPrecio.setText(null);
    }
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }
    
}
