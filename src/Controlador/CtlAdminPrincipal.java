/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.AdminPrincipal;
import Vista.GestionServicios;
import Vista.GestorCliente;
import Vista.GestorCuidadores;
import Vista.Login;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nic
 */
public class CtlAdminPrincipal implements ActionListener {
    
    private GestionServicios gesser;
    private GestorCuidadores gescu;
    private GestorCliente gescl;
    private AdminPrincipal vadminpri;
    private Login log;
    private ViewPrincipal vpri;

    public CtlAdminPrincipal(GestionServicios gesser, GestorCuidadores gescu, GestorCliente gescl, AdminPrincipal vadminpri, Login log, ViewPrincipal vpri) {
        this.gesser = gesser;
        this.gescu = gescu;
        this.gescl = gescl;
        this.vadminpri = vadminpri;
        this.log = log;
        this.vpri = vpri;
        
        vadminpri.btnCerrarSesion.addActionListener(this);
        vadminpri.btnGestCuidador.addActionListener(this);
        vadminpri.btnGestClientes.addActionListener(this);
        vadminpri.btnGestServicios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vadminpri.btnCerrarSesion)){
            
            vadminpri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(log);
            log.setVisible(true); 
            
        }
        
        if(ev.getSource().equals(vadminpri.btnGestClientes)){
            
            vadminpri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(gescl);
            gescl.setVisible(true); 
            
        }
        
        if(ev.getSource().equals(vadminpri.btnGestCuidador)){
            
            vadminpri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(gescu);
            gescu.setVisible(true); 
            
        }
        
        if(ev.getSource().equals(vadminpri.btnGestServicios)){
            
            vadminpri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(gesser);
            gesser.setVisible(true); 
            
        }
        
    }
    
    
    
}
