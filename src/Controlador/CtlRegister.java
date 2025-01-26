/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.DaoCliente;
import Vista.ClientePrincipal;
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

    public CtlRegister(Cliente cl, DaoCliente daocl, Login log, Register reg, ViewPrincipal vpri, ClientePrincipal clpri) {
        this.cl = cl;
        this.daocl = daocl;
        this.log = log;
        this.reg = reg;
        this.vpri = vpri;
        this.clpri = clpri;
        
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
            cl.setNit(Integer.parseInt(reg.txtNit.getText()));
            cl.setNombre(reg.txtNombre.getText());
            cl.setApellido(reg.txtApellido.getText());
            cl.setCorreo(reg.txtCorreo.getText());
            cl.setClave(reg.txtClave.getText());
            if(daocl.Agregar(cl)){
                reg.setVisible(false);
            
                if(vpri.Escritorio.getComponentCount()>0){
                    vpri.Escritorio.removeAll();
                }
            
                vpri.Escritorio.add(log);
                log.setVisible(true);
            }else{
                mensaje("Error en las credenciales", "Agregar");
            }
        }
    }
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }
    
}
