/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Cuidador;
import Modelo.DaoCliente;
import Modelo.DaoCuidador;
import Vista.ClientePrincipal;
import Vista.CuidadorPrinci;
import Vista.Login;
import Vista.Register;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Nic
 */
public class CtlRegister implements ActionListener {
    
    private Cliente cl;
    private DaoCliente daocl;
    private Login log;
    private Register reg;
    private ViewPrincipal vpri;
    private ClientePrincipal clpri;
    private Cuidador cu;
    private DaoCuidador daocu;

    public CtlRegister(Cliente cl, DaoCliente daocl, Login log, Register reg, ViewPrincipal vpri, ClientePrincipal clpri, Cuidador cu, DaoCuidador daocu) {
        this.cl = cl;
        this.daocl = daocl;
        this.log = log;
        this.reg = reg;
        this.vpri = vpri;
        this.clpri = clpri;
        this.cu = cu;
        this.daocu = daocu;
        
        reg.BtnLogin.addActionListener(this);
        reg.BtnRegistrarse.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(reg.BtnLogin)){
            
            reg.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(log);
            log.setVisible(true);
            
        }
        if(ev.getSource().equals(reg.BtnRegistrarse)){
            
            if (ev.getSource().equals(reg.BtnLogin)) {
        reg.setVisible(false);

        if (vpri.Escritorio.getComponentCount() > 0) {
            vpri.Escritorio.removeAll();
        }

        vpri.Escritorio.add(log);
        log.setVisible(true);
        }

        if (ev.getSource().equals(reg.BtnRegistrarse)) {
            if (reg.txtClave.getText().equalsIgnoreCase("elenemigos")) {
            
                cu = new Cuidador();
                cu.setNit(Integer.parseInt(reg.txtNit.getText()));
                cu.setNombre(reg.txtNombre.getText());
                cu.setApellido(reg.txtApellido.getText());
                cu.setCorreo(reg.txtCorreo.getText());
                cu.setClave(reg.txtClave.getText());

                if (daocu.agregar(cu)) {
                    reg.setVisible(false);

                    if (vpri.Escritorio.getComponentCount() > 0) {
                        vpri.Escritorio.removeAll();
                    }

                    vpri.Escritorio.add(log);
                    log.setVisible(true);
                } else {
                    mensaje("Error en las credenciales", "Agregar");
                }
            } else {
                
                cl = new Cliente();
                cl.setNit(Integer.parseInt(reg.txtNit.getText()));
                cl.setNombre(reg.txtNombre.getText());
                cl.setApellido(reg.txtApellido.getText());
                cl.setCorreo(reg.txtCorreo.getText());
                cl.setClave(reg.txtClave.getText());

                if (daocl.Agregar(cl)) {
                    reg.setVisible(false);

                    if (vpri.Escritorio.getComponentCount() > 0) {
                        vpri.Escritorio.removeAll();
                    }

                    vpri.Escritorio.add(log);
                    log.setVisible(true);
                } else {
                    mensaje("Error en las credenciales", "Agregar");
                }
            }
        }
    }
}
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }
    
}
