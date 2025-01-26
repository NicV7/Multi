/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoCliente;
import Modelo.DaoCuidador;
import Modelo.DaoMascota;
import Modelo.DaoReserva;
import Modelo.DaoServicio;
import Modelo.Reserva;
import Vista.CuidadorPrinci;
import Vista.CuidadorReservas;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Nic
 */
public class CtlCuidadorReservas implements ActionListener {
    
    private CuidadorPrinci vcupri;
    private ViewPrincipal vpri;
    private CuidadorReservas vcure;
    private DaoReserva daore;
    private DaoCuidador dacocu;
    private DaoCliente daocl;
    private DaoServicio daoser;
    private DaoMascota daoma;

    public CtlCuidadorReservas(CuidadorPrinci vcupri, ViewPrincipal vpri, CuidadorReservas vcure, DaoReserva daore, DaoCuidador dacocu, DaoCliente daocl, DaoServicio daoser, DaoMascota daoma) {
        this.vcupri = vcupri;
        this.vpri = vpri;
        this.vcure = vcure;
        this.daore = daore;
        this.dacocu = dacocu;
        this.daocl = daocl;
        this.daoser = daoser;
        this.daoma = daoma;
        
        vcure.BtnAtras.addActionListener(this);
        vcure.BtnBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vcure.BtnAtras)){
            
            vcure.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vcupri);
            vcupri.setVisible(true);
            
        }
        
        if(ev.getSource().equals(vcure.BtnBuscar)){
            
            int idReserva = obtenerIdReserva();
        
            Reserva reserva = daore.consultarReservaPorId(idReserva); 
        
            if (reserva != null) {
                
                vcure.txtFecha.setText(reserva.getFechaReserva().toString());
                vcure.txtServicio.setText(daoser.obtenerNombreServicio(reserva.getIDServicio()));
                vcure.txtNombreCl.setText(daocl.obtenerNombreCliente(reserva.getIDCliente()));
                vcure.txtNombreMas.setText(daoma.obtenerNombreMascota(reserva.getIDMascota()));
                vcure.txtSexo.setText(dacocu.obtenerNombreCuidador(reserva.getIDCuidador()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la reserva.");
            }
            
            
        }
        
    }
    
    private int obtenerIdReserva() {
    
    String textoIdReserva = vcure.txtIDReserva.getText();
    
    int idReserva = 0;
    try {
        idReserva = Integer.parseInt(textoIdReserva);
    } catch (NumberFormatException e) {
        System.err.println("Error al parsear el ID de la reserva: " + e.getMessage());
    }
    
    return idReserva;
}

    
    
}
