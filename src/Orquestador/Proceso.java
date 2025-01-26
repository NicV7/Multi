/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orquestador;

import Controlador.CtlAdminAsignacionCuidador;
import Controlador.CtlAdminPrincipal;
import Controlador.CtlClientePerfil;
import Controlador.CtlClientePrincipal;
import Controlador.CtlCuidadorMascotas;
import Controlador.CtlCuidadorPerfil;
import Controlador.CtlCuidadorPrincipal;
import Controlador.CtlCuidadorReservas;
import Controlador.CtlGestionServicios;
import Controlador.CtlGestorCliente;
import Controlador.CtlGestorCuidadores;
import Controlador.CtlGestorFactura;
import Controlador.CtlGestorMascotas;
import Controlador.CtlLogin;
import Controlador.CtlLoginCuidador;
import Controlador.CtlMascotaAjuste;
import Controlador.CtlMisReservas;
import Controlador.CtlPrincipal;
import Controlador.CtlRegister;
import Controlador.CtlServicio;
import Controlador.CtlServicioReservar;
import Modelo.Cliente;
import Modelo.Cuidador;
import Modelo.DaoCliente;
import Modelo.DaoClienteMascotaReporte;
import Modelo.DaoCuidador;
import Modelo.DaoFactura;
import Modelo.DaoMascota;
import Modelo.DaoReserva;
import Modelo.DaoServicio;
import Modelo.Facturas;
import Modelo.Mascota;
import Modelo.Reserva;
import Modelo.Servicio;
import Vista.AdminAsignacionCuida;
import Vista.AdminCuidaPerfil;
import Vista.AdminPrincipal;
import Vista.ClienteAjust;
import Vista.ClientePerfil;
import Vista.ClientePrincipal;
import Vista.CuidadorMascotas;
import Vista.CuidadorPerfil;
import Vista.CuidadorPrinci;
import Vista.CuidadorReservas;
import Vista.GestionServicios;
import Vista.GestorCliente;
import Vista.GestorCuidadores;
import Vista.GestorFacturas;
import Vista.GestorMascotas;
import Vista.Inventario;
import Vista.Login;
import Vista.LoginCuidador;
import Vista.MascotaAjuste;
import Vista.Register;
import Vista.ReservaCliente;
import Vista.ServicioReservar;
import Vista.Servicios;
import Vista.ViewPrincipal;
import java.time.LocalDate;

/**
 *
 * @author Nic
 */
public class Proceso {
    
    public void procesar(){
        
        ViewPrincipal vpri = new ViewPrincipal();
        AdminAsignacionCuida adsigcui = new AdminAsignacionCuida();
        AdminPrincipal adpri = new AdminPrincipal();
        AdminCuidaPerfil adcuper = new AdminCuidaPerfil();
        ClienteAjust clajus = new ClienteAjust();
        CuidadorMascotas cumas =  new CuidadorMascotas();
        CuidadorPerfil cuper = new CuidadorPerfil();
        CuidadorPrinci cupri = new CuidadorPrinci();
        CuidadorReservas cure = new CuidadorReservas();
        GestionServicios geser = new GestionServicios();
        GestorCliente gescl = new GestorCliente();
        GestorCuidadores gescu = new GestorCuidadores();
        GestorFacturas gefa = new GestorFacturas();
        Inventario inv = new Inventario();
        ReservaCliente recl = new ReservaCliente();
        Register vre = new Register();
        MascotaAjuste vmaajus = new MascotaAjuste();
        Login log = new Login();
        GestorMascotas gesma = new GestorMascotas();
        ClientePrincipal clpri = new ClientePrincipal();
        ClientePerfil clper = new ClientePerfil();
        ServicioReservar serres = new ServicioReservar();
        Servicio ser = new Servicio();
        Servicios vser = new Servicios();
        Cuidador cu = new Cuidador();
        DaoCuidador daocu = new DaoCuidador();
        LoginCuidador logcu = new LoginCuidador();
        Cliente cl = new Cliente();
        DaoCliente daocl = new DaoCliente();
        DaoClienteMascotaReporte daoclmare = new DaoClienteMascotaReporte();
        DaoMascota daoma = new DaoMascota();
        Mascota ma = new Mascota();
        DaoReserva daore = new DaoReserva();
        DaoServicio daoser = new DaoServicio();
        Reserva re = new Reserva();
        DaoFactura daofa = new DaoFactura();
        Facturas fa = new Facturas();
        
        
        CtlLoginCuidador ctllogcu = new CtlLoginCuidador(log, vpri, cu, daocu, logcu, cupri);
        CtlCuidadorReservas ctlcure = new CtlCuidadorReservas(cupri, vpri, cure, daore, daocu, daocl, daoser, daoma);
        CtlCuidadorMascotas ctlcumas = new CtlCuidadorMascotas(cu, ma, daocu, daoma, daore, log, vpri, cumas, re, cupri, cuper, cure);
        CtlCuidadorPerfil ctlcuper = new CtlCuidadorPerfil(daocu, cu, cuper, cupri, log, vpri);
        CtlCuidadorPrincipal ctlcupri = new CtlCuidadorPrincipal(vpri, cumas, cure, cuper, cupri, daocu, cu, logcu);
        CtlAdminAsignacionCuidador cladasigcu = new CtlAdminAsignacionCuidador(daore, daocu, cu, re, adsigcui, gescu, vpri);
        CtlGestorCuidadores ctlgecu = new CtlGestorCuidadores(cu, daocu, vpri, gescu, adpri, adsigcui);
        CtlGestorCliente ctlgescl = new CtlGestorCliente(cl, daocl, vpri, gescl, adpri);
        CtlGestionServicios ctlgesser = new  CtlGestionServicios(ser, daoser, vpri, adpri, geser);
        CtlGestorMascotas ctlgesma = new CtlGestorMascotas(ma, cl, daoclmare, daoma, clpri, vmaajus, vpri, gesma, recl);
        CtlClientePerfil ctlclper = new CtlClientePerfil(log, vpri, clpri, clper, cl, daocl, ma, daoclmare, vmaajus);
        CtlClientePrincipal ctlclpri = new CtlClientePrincipal(log, clpri, clper, vpri, ma, cl, daoclmare, gesma, vser, gefa);
        CtlLogin ctllog = new CtlLogin(cl, daocl, clpri, log, vpri, vre, adpri, cupri, cu, daocu, logcu);
        CtlMascotaAjuste ctlmaajus = new CtlMascotaAjuste(ma, cl, daoclmare, daoma, clper, vmaajus, vpri, log);
        CtlPrincipal ctlpri = new CtlPrincipal(log, vre, clpri, vpri);
        CtlRegister ctlreg = new CtlRegister(cl, daocl, log, vre, vpri, clpri, cu, daocu);
        CtlServicio ctlser = new CtlServicio(ser, vser, serres, vpri, daoser, clpri);
        CtlServicioReservar ctlserre = new CtlServicioReservar(ser, re, ma, daoclmare, daore, cl, vser, serres, vpri, daoser);
        CtlAdminPrincipal ctladmpri = new CtlAdminPrincipal(geser, gescu, gescl, adpri, log, vpri);
        CtlMisReservas ctlmisre = new CtlMisReservas(daore, daocu, cu, re, recl, gesma, vpri, ser, daoser);
        CtlGestorFactura ctlfa = new CtlGestorFactura(fa, daofa, cl, log, vpri, gefa, clpri, ma, ser);
        vpri.setVisible(true);
    }
    
}
