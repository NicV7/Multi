/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ClientePrincipal;
import Vista.Login;
import Vista.Register;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Nic
 */
public class CtlPrincipal implements ActionListener {
    
    private Login logx;
    private Register reg;
    private ClientePrincipal clpri;
    private ViewPrincipal vpri;

    public CtlPrincipal(Login logx, Register reg, ClientePrincipal clpri, ViewPrincipal vpri) {
        this.logx = logx;
        this.reg = reg;
        this.clpri = clpri;
        this.vpri = vpri;
        
        vpri.BtnLogin.addActionListener(this);
        vpri.Register.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vpri.BtnLogin)){
            vpri.Escritorio.add(logx);
            logx.setVisible(true);
        }
        if(ev.getSource().equals(vpri.Register)){
            vpri.Escritorio.add(reg);
            reg.setVisible(true);
        }
    }
    
    
    
}
