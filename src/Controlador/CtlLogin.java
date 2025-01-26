/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Cuidador;
import Modelo.Cliente;
import Modelo.DaoCliente;
import Modelo.DaoCuidador;
import Vista.AdminPrincipal;
import Vista.ClientePrincipal;
import Vista.CuidadorPrinci;
import Vista.Login;
import Vista.LoginCuidador;
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
    private AdminPrincipal vadpri;
    private CuidadorPrinci vcupri;
    private Cuidador cu;
    private DaoCuidador daocu;
    private LoginCuidador logcu;

    public CtlLogin(Cliente cl, DaoCliente daocl, ClientePrincipal vclpri, Login log, ViewPrincipal vpri, Register vreg, AdminPrincipal vadpri, CuidadorPrinci vcupri, Cuidador cu, DaoCuidador daocu, LoginCuidador logcu) {
        this.cl = cl;
        this.daocl = daocl;
        this.vclpri = vclpri;
        this.log = log;
        this.vpri = vpri;
        this.vreg = vreg;
        this.vadpri = vadpri;
        this.vcupri = vcupri;
        this.cu = cu;
        this.daocu = daocu;
        this.logcu = logcu;
        
        log.BtnLogin.addActionListener(this);
        log.BtnOlvContra.addActionListener(this);
        log.BtnRegister.addActionListener(this);
        log.BtnCuidador.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(log.BtnLogin)){
            int nit = Integer.parseInt(log.txtNit.getText());
            String clave = log.txtClave.getText();
            
            if (nit == 2013 && clave.equalsIgnoreCase("MyLife")) {
                mensaje("Logeado con éxito como Admin", "Login");
                log.setVisible(false);

                if (vpri.Escritorio.getComponentCount() > 0) {
                    vpri.Escritorio.removeAll();
                }

                vpri.Escritorio.add(vadpri);
                vadpri.setVisible(true);

                vpri.revalidate();
                vpri.repaint();
                return;
            }

            
            cl.setNit(nit);
            cl.setClave(clave);
            if (daocl.existeCliente(nit, clave)) {
                mensaje("Logeado con éxito como Cliente", "Login");
                log.setVisible(false);

                if (vpri.Escritorio.getComponentCount() > 0) {
                    vpri.Escritorio.removeAll();
                }

                vpri.Escritorio.add(vclpri);
                vclpri.setVisible(true);

                vpri.revalidate();
                vpri.repaint();
                return;
            }

            mensaje("Credenciales no válidas", "Login");
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
        
        if(ev.getSource().equals(log.BtnCuidador)){
            
                log.setVisible(false);

                if (vpri.Escritorio.getComponentCount() > 0) {
                    vpri.Escritorio.removeAll();
                }

                vpri.Escritorio.add(logcu);
                logcu.setVisible(true);

                vpri.revalidate();
                vpri.repaint();
            
        }
        
    }
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }
    
}
