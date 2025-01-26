/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mascota;
import Modelo.Cliente;
import Modelo.DaoClienteMascotaReporte;
import Vista.ClientePerfil;
import Vista.ClientePrincipal;
import Vista.GestorMascotas;
import Vista.Login;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nic
 */
public class CtlClientePrincipal implements ActionListener {
    
    private Login log;
    private ClientePrincipal vclpri;
    private ClientePerfil vclper;
    private ViewPrincipal vpri;
    private Mascota ma;
    private Cliente cl;
    private DaoClienteMascotaReporte daoclmare;
    private GestorMascotas vgesma;

    public CtlClientePrincipal(Login log, ClientePrincipal vclpri, ClientePerfil vclper, ViewPrincipal vpri, Mascota ma, Cliente cl, DaoClienteMascotaReporte daoclmare, GestorMascotas vgesma) {
        this.log = log;
        this.vclpri = vclpri;
        this.vclper = vclper;
        this.vpri = vpri;
        this.ma = ma;
        this.cl = cl;
        this.daoclmare = daoclmare;
        this.vgesma = vgesma;
        
        vclpri.BtnPefilUsuario.addActionListener(this);
        vclpri.BtnPefilMascota.addActionListener(this);
        vclpri.BtnMisReservas.addActionListener(this);
        vclpri.BtnReservarServicios.addActionListener(this);
        vclpri.BtnFacturacion.addActionListener(this);
        vclpri.BtnCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vclpri.BtnPefilUsuario)){
            vclpri.setVisible(false);

            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vclper);
            vclper.setVisible(true);
        }
        if(ev.getSource().equals(vclpri.BtnPefilMascota)){
            vclpri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vgesma);
            vgesma.setVisible(true);
        }
        if(ev.getSource().equals(vclpri.BtnMisReservas)){
            
        }
        if(ev.getSource().equals(vclpri.BtnReservarServicios)){
            
        }
        if(ev.getSource().equals(vclpri.BtnFacturacion)){
            
        }
        if(ev.getSource().equals(vclpri.BtnCerrarSesion)){
            vclpri.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(log);
            log.setVisible(true);
            
            log.txtNit.setText("");
            log.txtClave.setText("");
            cl.setNit(-1);
            cl.setClave(null);
        }
    
    }
    
    
    
    
}
