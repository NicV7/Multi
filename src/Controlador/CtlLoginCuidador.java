/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuidador;
import Modelo.DaoCuidador;
import Vista.CuidadorPrinci;
import Vista.Login;
import Vista.LoginCuidador;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Nic
 */
public class CtlLoginCuidador implements ActionListener {
    
    
    private Login log;
    private ViewPrincipal vpri;
    private Cuidador cu;
    private DaoCuidador daocu;
    private LoginCuidador logcu;
    private CuidadorPrinci vcupri;

    public CtlLoginCuidador(Login log, ViewPrincipal vpri, Cuidador cu, DaoCuidador daocu, LoginCuidador logcu, CuidadorPrinci vcupri) {
        this.log = log;
        this.vpri = vpri;
        this.cu = cu;
        this.daocu = daocu;
        this.logcu = logcu;
        this.vcupri = vcupri;
        
        
        logcu.BtnAtras.addActionListener(this);
        logcu.BtnLogin.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(logcu.BtnAtras)){
            
                logcu.setVisible(false);

                if (vpri.Escritorio.getComponentCount() > 0) {
                    vpri.Escritorio.removeAll();
                }

                vpri.Escritorio.add(log);
                log.setVisible(true);

                vpri.revalidate();
                vpri.repaint();
                
                logcu.txtClaveCuida.setText("");
                logcu.txtNitCuida.setText("");
             
        }
        
        if(ev.getSource().equals(logcu.BtnLogin)){
            
            int nit = Integer.parseInt(logcu.txtNitCuida.getText());
            String clave = logcu.txtClaveCuida.getText();

            
            cu.setNit(nit);
            cu.setClave(clave);
            if (daocu.existeCuidador(nit, clave)) {
                mensaje("Logeado con éxito como Cuidador", "Login");
                log.setVisible(false);

                if (vpri.Escritorio.getComponentCount() > 0) {
                    vpri.Escritorio.removeAll();
                }

                vpri.Escritorio.add(vcupri);
                vcupri.setVisible(true);

                vpri.revalidate();
                vpri.repaint();
                return;
            }
            
            
        }
        
        
    }
    
    public void mensaje(String msj,String tit){
        
        JOptionPane.showMessageDialog(null, msj,tit,1);
        
    }
    
    
    
    
}
