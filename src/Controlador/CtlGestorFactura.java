/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.DaoFactura;
import Modelo.Facturas;
import Modelo.Mascota;
import Modelo.Servicio;
import Vista.ClientePrincipal;
import Vista.GestorFacturas;
import Vista.Login;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nic
 */
public class CtlGestorFactura implements ActionListener {
    
    private Facturas fa;
    private DaoFactura daofa;
    private Cliente cl;
    private Login log;
    private ViewPrincipal vpri;
    private GestorFacturas gesfa;
    private ClientePrincipal vclpri;
    private Mascota ma;
    private Servicio se;

    public CtlGestorFactura(Facturas fa, DaoFactura daofa, Cliente cl, Login log, ViewPrincipal vpri, GestorFacturas gesfa, ClientePrincipal vclpri, Mascota ma, Servicio se) {
        this.fa = fa;
        this.daofa = daofa;
        this.cl = cl;
        this.log = log;
        this.vpri = vpri;
        this.gesfa = gesfa;
        this.vclpri = vclpri;
        this.ma = ma;
        this.se = se;
        
        gesfa.BtnAtras.addActionListener(this);
        gesfa.BtnBuscar.addActionListener(this);
        gesfa.BtnGeenrarFactura.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(gesfa.BtnAtras)){
            
            gesfa.setVisible(false);

            if (vpri.Escritorio.getComponentCount() > 0) {
                vpri.Escritorio.removeAll();
            }

            vpri.Escritorio.add(vclpri);
            vclpri.setVisible(true);
            
        }
        
        if(ev.getSource().equals(gesfa.BtnGeenrarFactura)){
            
        }
        
    }
    
    
    
}
