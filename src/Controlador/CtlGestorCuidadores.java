/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Cuidador;
import Modelo.DaoCuidador;
import Vista.AdminAsignacionCuida;
import Vista.AdminPrincipal;
import Vista.GestorCuidadores;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nic
 */
public class CtlGestorCuidadores implements ActionListener {
    
    private Cuidador cu;
    private DaoCuidador daocu;
    private ViewPrincipal vpri;
    private GestorCuidadores gescu;
    private AdminPrincipal adpri;
    private AdminAsignacionCuida adasigcu;

    public CtlGestorCuidadores(Cuidador cu, DaoCuidador daocu, ViewPrincipal vpri, GestorCuidadores gescu, AdminPrincipal adpri, AdminAsignacionCuida adasigcu) {
        this.cu = cu;
        this.daocu = daocu;
        this.vpri = vpri;
        this.gescu = gescu;
        this.adpri = adpri;
        this.adasigcu = adasigcu;
        
        gescu.BtnAtras.addActionListener(this);
        gescu.BtnAgregar.addActionListener(this);
        gescu.BtnConsultar.addActionListener(this);
        gescu.BtnEliminar.addActionListener(this);
        gescu.BtnActulizar.addActionListener(this);
        gescu.BtnLimpiar.addActionListener(this);
        gescu.BtnBuscar.addActionListener(this);
        gescu.BtnAsignacion.addActionListener(this);
    }

    


    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(gescu.BtnAtras)){
            gescu.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(adpri);
            adpri.setVisible(true);
        }
        
        if(ev.getSource().equals(gescu.BtnAgregar)){
            
            cu.setNit(Integer.parseInt(gescu.txtNit.getText()));
            cu.setNombre(gescu.txtNombreCu.getText());
            cu.setApellido(gescu.txtApellido.getText());
            cu.setCorreo(gescu.txtCorreo.getText());
            cu.setTelefono(gescu.txtTelefono.getText());
            cu.setDireccion(gescu.txtDireccion.getText());
            cu.setEspecializacion(gescu.txtEspecialidad.getText());
            cu.setCargo(gescu.txtCargo.getText());
            cu.setClave(gescu.txtClave.getText());
            
            if(daocu.agregar(cu)){
                mensaje("Cuidador agregado correctamente...", "Agregar");
            }else{
                mensaje("Cuidaodr no se pudo agregar", "Agregar");
            }
            
        }
        
        if(ev.getSource().equals(gescu.BtnConsultar)){
            
            cu.setNit(Integer.parseInt(gescu.txtNit.getText()));
            if(daocu.consultar(cu)){
                gescu.txtNombreCu.setText(cu.getNombre());
                gescu.txtApellido.setText(cu.getApellido());
                gescu.txtCorreo.setText(cu.getCorreo());
                gescu.txtClave.setText(cu.getClave());
                gescu.txtCargo.setText(cu.getCargo());
                gescu.txtEspecialidad.setText(cu.getEspecializacion());
                gescu.txtTelefono.setText(cu.getTelefono());
                gescu.txtDireccion.setText(cu.getDireccion());
                mensaje("Cuidador actualizao correctamnte...", "Consultar");
            }else{
                mensaje("Cuidador no existe...", "Consultar");
            }
        }
        
        if(ev.getSource().equals(gescu.BtnActulizar)){
            
            cu.setNit(Integer.parseInt(gescu.txtNit.getText()));
            cu.setNombre(gescu.txtNombreCu.getText());
            cu.setApellido(gescu.txtApellido.getText());
            cu.setCorreo(gescu.txtCorreo.getText());
            cu.setTelefono(gescu.txtTelefono.getText());
            cu.setDireccion(gescu.txtDireccion.getText());
            cu.setEspecializacion(gescu.txtEspecialidad.getText());
            cu.setCargo(gescu.txtCargo.getText());
            cu.setClave(gescu.txtClave.getText());
            
            if(daocu.actualizarCuidador(cu)){
                mensaje("Cuidador Actualizado correctamente..", "Actualizar");
            }else{
                mensaje("Cuidador no se pudo Actualizar", "Actualizar");
            } 
            
        }
        
        
        if(ev.getSource().equals(gescu.BtnEliminar)){
            cu.setNit(Integer.parseInt(gescu.txtNit.getText()));
            if(daocu.eliminarCuidador(cu)){
                mensaje("Cuidador eliminado correctamente...", "Eliminar");
            }else{
                mensaje("Cuidador no se pudo eliminar..", "Eliminar");
            }
        }
        
        if(ev.getSource().equals(gescu.BtnLimpiar)){
            limpiar();
        }
        
        if(ev.getSource().equals(gescu.BtnBuscar)){
            
            ResultSet rst = daocu.generarReporteCuidadores();
            if(rst != null){
                String[] tit = {"nit","nombre","apellido","cargo"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                gescu.Tabla.setModel(dtm);
                try {
                    while(rst.next()){
                        Object[] fila = {rst.getInt("nit"),rst.getString("nombre"),rst.getString("apellido"),rst.getString("cargo")};
                        dtm.addRow(fila);
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al buscar las mascotas: "+ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al generar el listado de mascotas","Error",1);
                }
            }
            
        }
        
        if(ev.getSource().equals(gescu.BtnAsignacion)){
            if(!gescu.txtNit.getText().isEmpty()){
               gescu.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(adasigcu);
            adasigcu.setVisible(true); 
            }else{
                JOptionPane.showMessageDialog(null, "El campo NIT no puede estar vacio","Error",1);
            }
            
        }
        
    }
    
    
    public void limpiar(){
        
       gescu.txtNit.setText(null);
       gescu.txtNombreCu.setText(null);
       gescu.txtApellido.setText(null);
       gescu.txtCorreo.setText(null);
       gescu.txtClave.setText(null);
       gescu.txtDireccion.setText(null);
       gescu.txtTelefono.setText(null);
       gescu.txtCargo.setText(null);
       gescu.txtEspecialidad.setText(null);
        
    }
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    } 
    
    
    
}
