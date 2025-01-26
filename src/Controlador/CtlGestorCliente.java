/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.DaoCliente;
import Vista.AdminPrincipal;
import Vista.GestorCliente;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nic
 */
public class CtlGestorCliente implements ActionListener {
    
    private Cliente cl;
    private DaoCliente daocl;
    private ViewPrincipal vpri;
    private GestorCliente gescl;
    private AdminPrincipal adpri;

    public CtlGestorCliente(Cliente cl, DaoCliente daocl, ViewPrincipal vpri, GestorCliente gescl, AdminPrincipal adpri) {
        this.cl = cl;
        this.daocl = daocl;
        this.vpri = vpri;
        this.gescl = gescl;
        this.adpri = adpri;
        
        gescl.btnAtras.addActionListener(this);
        gescl.btnAgregar.addActionListener(this);
        gescl.btnActualizar.addActionListener(this);
        gescl.btnBuscar.addActionListener(this);
        gescl.btnEliminar.addActionListener(this);
        gescl.btnLimpiar.addActionListener(this);
        gescl.btnConsultar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(gescl.btnAtras)){
            
            gescl.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(adpri);
            adpri.setVisible(true);
            
        }
        
        if(ev.getSource().equals(gescl.btnAgregar)){
            
            cl.setNit(Integer.parseInt(gescl.txtNit.getText()));
            cl.setNombre(gescl.txtNombre.getText());
            cl.setApellido(gescl.txtApellido.getText());
            cl.setCorreo(gescl.txtCorreo.getText());
            cl.setClave(gescl.txtClave.getText());
            
            if(daocl.Agregar(cl)){
                mensaje("Cliente Agregado correctamente..", "Agregar");
            }else{
                mensaje("Cliente no se pudo registrar", "Agregar");
            }
        }
        
        if(ev.getSource().equals(gescl.btnConsultar)){
            cl.setNit(Integer.parseInt(gescl.txtNit.getText()));
            if(daocl.Consultar(cl)){
                gescl.txtNombre.setText(cl.getNombre());
                gescl.txtApellido.setText(cl.getApellido());
                gescl.txtCorreo.setText(cl.getCorreo());
                gescl.txtClave.setText(cl.getClave());
                mensaje("Cliente encontrado...", "Consultar");
            }else{
                mensaje("Cliente no existe..", "Consultar");
            }
        }
        
        if(ev.getSource().equals(gescl.btnActualizar)){
            cl.setNit(Integer.parseInt(gescl.txtNit.getText()));
            cl.setNombre(gescl.txtNombre.getText());
            cl.setApellido(gescl.txtApellido.getText());
            cl.setCorreo(gescl.txtCorreo.getText());
            cl.setClave(gescl.txtClave.getText());
            
            if(daocl.actualizarCliente(cl)){
                mensaje("Cliente Actualizado correctamente..", "Actualizar");
            }else{
                mensaje("Cliente no se pudo Actualizar", "Actualizar");
            }  
        }
        
        if(ev.getSource().equals(gescl.btnEliminar)){
            cl.setNit(Integer.parseInt(gescl.txtNit.getText()));
            if(daocl.eliminarCliente(cl)){
                mensaje("Cliente eliminado correctamente...", "Eliminar");
            }else{
                mensaje("Cliente no se pudo eliminar..", "Eliminar");
            }
        }
        
        if(ev.getSource().equals(gescl.btnLimpiar)){
            limpiar();
        }
        
        if(ev.getSource().equals(gescl.btnBuscar)){
            ResultSet rst = daocl.generarReporteClientes();
            if(rst != null){
                String[] tit = {"Nit","Nombre","Apellido","correo","clave"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                gescl.Tabla.setModel(dtm);
                try {
                    while(rst.next()){
                        Object[] fila = {rst.getInt("Nit"),rst.getString("Nombre"),rst.getString("Apellido"),rst.getString("correo"),rst.getString("clave")};
                        dtm.addRow(fila);
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al buscar las mascotas: "+ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al generar el listado de mascotas","Error",1);
                }
            }
        }
        
    }
    
    
   public void limpiar(){
       
       gescl.txtNit.setText(null);
       gescl.txtNombre.setText(null);
       gescl.txtApellido.setText(null);
       gescl.txtCorreo.setText(null);
       gescl.txtClave.setText(null);
       gescl.txtDireccion.setText(null);
       gescl.txtTel.setText(null);
       
   } 
    
   public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    } 
    
}
