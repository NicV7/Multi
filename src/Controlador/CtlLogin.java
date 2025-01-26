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
public class CtlLogin implements ActionListener {
    
    private Cliente cl;
    private DaoCliente daocl;
    private ClientePrincipal vclpri;
    private Login log;
    private ViewPrincipal vpri;
    private Register vreg;

    public CtlLogin(Cliente cl, DaoCliente daocl, ClientePrincipal vclpri, Login log, ViewPrincipal vpri, Register vreg) {
        this.cl = cl;
        this.daocl = daocl;
        this.vclpri = vclpri;
        this.log = log;
        this.vpri = vpri;
        this.vreg = vreg;
        
        log.BtnLogin.addActionListener(this);
        log.BtnOlvContra.addActionListener(this);
        log.BtnRegister.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(log.BtnLogin)){
            cl.setNit(Integer.parseInt(log.txtNit.getText()));
            cl.setClave(log.txtClave.getText());
            if(daocl.Consultar(cl)){
                mensaje("Logeado con exito", "Consultar");
                
                log.setVisible(false);
                
                if(vpri.Escritorio.getComponentCount()>0){
                   vpri.Escritorio.removeAll();
                }
                
                vpri.Escritorio.add(vclpri);
                vclpri.setVisible(true);
                
                cl.setNit(Integer.parseInt(log.txtNit.getText()));
                cl.setClave(log.txtClave.getText());
                
                vpri.revalidate();
                vpri.repaint();
            }else{
                mensaje("Error el cliente no existe", "Consultar");
            }
        }
        if(ev.getSource().equals(log.BtnOlvContra)){
            
        }
        if(ev.getSource().equals(log.BtnRegister)){
            log.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            vpri.Escritorio.add(vreg);
            vreg.setVisible(true);
        }
    }
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }
    
}
