/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Cuidador;
import Modelo.DaoCuidador;
import Modelo.Reserva;
import Vista.CuidadorMascotas;
import Vista.CuidadorPerfil;
import Vista.CuidadorPrinci;
import Vista.CuidadorReservas;
import Vista.LoginCuidador;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Nic
 */
public class CtlCuidadorPrincipal implements ActionListener {
    
    private ViewPrincipal vpri;
    private CuidadorMascotas vcuma;
    private CuidadorReservas vcure;
    private CuidadorPerfil vcuper;
    private CuidadorPrinci vcupri;
    private DaoCuidador daocu;
    private Cuidador cu;
    private LoginCuidador logcu;
    private Reserva re;

    public CtlCuidadorPrincipal(ViewPrincipal vpri, CuidadorMascotas vcuma, CuidadorReservas vcure, CuidadorPerfil vcuper, CuidadorPrinci vcupri, DaoCuidador daocu, Cuidador cu, LoginCuidador logcu) {
        this.vpri = vpri;
        this.vcuma = vcuma;
        this.vcure = vcure;
        this.vcuper = vcuper;
        this.vcupri = vcupri;
        this.daocu = daocu;
        this.cu = cu;
        this.logcu = logcu;
        
        vcupri.BtnMascotas.addActionListener(this);
        vcupri.BtnPerfil.addActionListener(this);
        vcupri.BtnReservas.addActionListener(this);
        vcupri.BtnCerrarSesion.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vcupri.BtnCerrarSesion)){
            
            vcupri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(logcu);
            logcu.setVisible(true);
            logcu.txtClaveCuida.setText("");
            logcu.txtNitCuida.setText("");
        }
        
        if(ev.getSource().equals(vcupri.BtnMascotas)){
            
            vcupri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vcuma);
            vcuma.setVisible(true);
            
        }
        
        if(ev.getSource().equals(vcupri.BtnPerfil)){
            int nit = Integer.parseInt(logcu.txtNitCuida.getText());
            String clave = logcu.txtClaveCuida.getText();
            vcupri.setVisible(false);
        
            if (vpri.Escritorio.getComponentCount() > 0) {
                vpri.Escritorio.removeAll();
            }
        
            vpri.Escritorio.add(vcuper);
            vcuper.setVisible(true);
            
            Cuidador cu = daocu.consultarPorId(nit);

            if(cu != null){
                
                   vcuper.txtNombreCu.setText(cu.getNombre());
                   vcuper.txtCargo.setText(cu.getCargo());
                   vcuper.txtCorreo.setText(cu.getCorreo());
                   vcuper.txtEspecialidad.setText(cu.getEspecializacion());
                   vcuper.txtTelefono.setText(cu.getTelefono());
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el cuidador");
            } 
                
        }

        if(ev.getSource().equals(vcupri.BtnReservas)){

            vcupri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vcure);
            vcure.setVisible(true);
            
            vcure.txtFecha.setText("fechareserva");
            vcure.txtServicio.setText("nombreservicio");
            vcure.txtNombreCl.setText("nombrecliente");
            vcure.txtTelefono.setText("telefonocliente");
            vcure.txtDireccion.setText("direccioncliente");
            vcure.txtNit.setText("nitcliente");
            vcure.txtCorreo.setText("correocliente");
            vcure.txtNombreMas.setText("nombremascota");
            vcure.txtRaza.setText("razamascota");
            vcure.txtSexo.setText("sexomascota");
        }
    }
    
    
    
    
}
