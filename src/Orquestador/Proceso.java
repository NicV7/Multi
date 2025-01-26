/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orquestador;

import Controlador.CtlClientePerfil;
import Controlador.CtlClientePrincipal;
import Controlador.CtlGestorMascotas;
import Controlador.CtlLogin;
import Controlador.CtlMascotaAjuste;
import Controlador.CtlPrincipal;
import Controlador.CtlRegister;
import Modelo.Cliente;
import Modelo.DaoCliente;
import Modelo.DaoClienteMascotaReporte;
import Modelo.DaoMascota;
import Modelo.Mascota;
import Vista.ClientePerfil;
import Vista.ClientePrincipal;
import Vista.GestorMascotas;
import Vista.Login;
import Vista.MascotaAjuste;
import Vista.Register;
import Vista.ViewPrincipal;

/**
 *
 * @author Nic
 */
public class Proceso {
    
    public void procesar(){
        
        ViewPrincipal vpri = new ViewPrincipal();
        
        Register vre = new Register();
        MascotaAjuste vmaajus = new MascotaAjuste();
        Login log = new Login();
        GestorMascotas gesma = new GestorMascotas();
        ClientePrincipal clpri = new ClientePrincipal();
        ClientePerfil clper = new ClientePerfil();
        
        
        Cliente cl = new Cliente();
        DaoCliente daocl = new DaoCliente();
        DaoClienteMascotaReporte daoclmare = new DaoClienteMascotaReporte();
        DaoMascota daoma = new DaoMascota();
        Mascota ma = new Mascota();
        
        CtlGestorMascotas ctlgesma = new CtlGestorMascotas(ma, cl, daoclmare, daoma, clpri, vmaajus, vpri, gesma);
        CtlClientePerfil ctlclper = new CtlClientePerfil(log, vpri, clpri, clper, cl, daocl, ma, daoclmare, vmaajus);
        CtlClientePrincipal ctlclpri = new CtlClientePrincipal(log, clpri, clper, vpri, ma, cl, daoclmare, gesma);
        CtlLogin ctllog = new CtlLogin(cl, daocl, clpri, log, vpri, vre);
        CtlMascotaAjuste ctlmaajus = new CtlMascotaAjuste(ma, cl, daoclmare, daoma, clper, vmaajus, vpri, log);
        CtlPrincipal ctlpri = new CtlPrincipal(log, vre, clpri, vpri);
        CtlRegister ctlreg = new CtlRegister(cl, daocl, log, vre, vpri, clpri);
        
        vpri.setVisible(true);
    }
    
}
