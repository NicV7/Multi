/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuidador;
import Modelo.DaoCuidador;
import Vista.CuidadorPerfil;
import Vista.CuidadorPrinci;
import Vista.Login;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nic
 */
public class CtlCuidadorPerfil implements ActionListener {
    
    private DaoCuidador daocu;
    private Cuidador cu;
    private CuidadorPerfil vcuper;
    private CuidadorPrinci vcupri;
    private Login log;
    private ViewPrincipal vpri;

    public CtlCuidadorPerfil(DaoCuidador daocu, Cuidador cu, CuidadorPerfil vcuper, CuidadorPrinci vcupri, Login log, ViewPrincipal vpri) {
        this.daocu = daocu;
        this.cu = cu;
        this.vcuper = vcuper;
        this.vcupri = vcupri;
        this.log = log;
        this.vpri = vpri;
        
        vcuper.BtnAtras.addActionListener(this);
        vcuper.BtnAjustes.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vcuper.BtnAtras)){
            vcuper.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vcupri);
            vcupri.setVisible(true);
        }
        if(ev.getSource().equals(vcuper.BtnAjustes)){
            
        }
        
    }
    
    
    
    
}
