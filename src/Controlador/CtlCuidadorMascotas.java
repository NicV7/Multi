/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuidador;
import Modelo.DaoCuidador;
import Modelo.DaoMascota;
import Modelo.DaoReserva;
import Modelo.Mascota;
import Modelo.Reserva;
import Vista.CuidadorMascotas;
import Vista.CuidadorPerfil;
import Vista.CuidadorPrinci;
import Vista.CuidadorReservas;
import Vista.Login;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nic
 */
public class CtlCuidadorMascotas implements ActionListener {
    
    private Cuidador cu;
    private Mascota ma;
    private DaoCuidador daocu;
    private DaoMascota daomas;
    private DaoReserva daore;
    private Login log;
    private ViewPrincipal vpri;
    private CuidadorMascotas vcuma;
    private Reserva re;
    private CuidadorPrinci vcupri;
    private CuidadorPerfil vcuper;
    private CuidadorReservas vcure;

    public CtlCuidadorMascotas(Cuidador cu, Mascota ma, DaoCuidador daocu, DaoMascota daomas, DaoReserva daore, Login log, ViewPrincipal vpri, CuidadorMascotas vcuma, Reserva re, CuidadorPrinci vcupri, CuidadorPerfil vcuper, CuidadorReservas vcure) {
        this.cu = cu;
        this.ma = ma;
        this.daocu = daocu;
        this.daomas = daomas;
        this.daore = daore;
        this.log = log;
        this.vpri = vpri;
        this.vcuma = vcuma;
        this.re = re;
        this.vcupri = vcupri;
        this.vcuper = vcuper;
        this.vcure = vcure;
        
        vcuma.BtnAtras.addActionListener(this);
        vcuma.BtnBuscar.addActionListener(this);
        vcuma.BtnReservas.addActionListener(this);
        vcuma.BtnGenerar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vcuma.BtnGenerar)){
            
            int idCuidador = Integer.parseInt(log.txtNit.getText());
            
            List<Reserva> reservas = daore.obtenerReservasPorCuidador(idCuidador);
            
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("IDMascota");
            dtm.addColumn("Nombre");
            dtm.addColumn("Raza");
            dtm.addColumn("Edad");
            
            for (Reserva reserva : reservas) {
            int idMascota = reserva.getIDMascota();
            Mascota mascota = daomas.obtenerMascotaPorId(idMascota);

            if (mascota != null) {
                Object[] fila = {
                    mascota.getIdMascota(),
                    mascota.getNombre(),
                    mascota.getRaza(),
                    mascota.getEdad()
                };
                dtm.addRow(fila);
            }
        }

        
        vcuma.Tabla.setModel(dtm);
    
        }
        
        
        if(ev.getSource().equals(vcuma.BtnAtras)){
            
            vcuma.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vcupri);
            vcupri.setVisible(true);
            
        }
        
        
        if(ev.getSource().equals(vcuma.BtnReservas)){
            String idText = vcuma.txtBusqueda.getText();
        
            if (!idText.isEmpty()) {
                try {
                    int idMascota = Integer.parseInt(idText);
                
                    Mascota mascota = daomas.obtenerMascotaPorId(idMascota);
                
                    if (mascota != null) {
                    
                    List<Reserva> reservas = daore.obtenerReservasPorMascota(idMascota);
                    
                    if (!reservas.isEmpty()) {
                        
                        Reserva reserva = reservas.get(0);
                        String fechaReserva = reserva.getFechaReserva().toString();
                        String nombreServicio = reserva.getServicio().getNombre();
                        Cuidador cuidador = daocu.consultarPorId(reserva.getIDCuidador());
                        
                        
                        vcure.txtFecha.setText(fechaReserva);
                        vcure.txtServicio.setText(nombreServicio);
                        vcure.txtNombreCl.setText(cuidador.getNombre());  
                        vcure.txtTelefono.setText(cuidador.getTelefono());  
                        vcure.txtDireccion.setText(cuidador.getDireccion());  
                        vcure.txtNit.setText(Integer.toString(cuidador.getNit()));  
                        vcure.txtCorreo.setText(cuidador.getCorreo());  
                        vcure.txtNombreMas.setText(mascota.getNombre());  
                        vcure.txtRaza.setText(mascota.getRaza());  
                        vcure.txtEdad.setText(String.valueOf(mascota.getEdad()));  
                        vcure.txtSexo.setText(mascota.getSexo());  
                    } else {
                        JOptionPane.showMessageDialog(vcuma, "No se encontraron reservas para esta mascota.");
                    }
                } else {
                    JOptionPane.showMessageDialog(vcuma, "No se encontró una mascota con ese ID.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(vcuma, "Por favor, ingrese un ID de mascota válido.");
            }
        } else {
            JOptionPane.showMessageDialog(vcuma, "Por favor, ingrese un ID para buscar.");
        }

        
        vcuma.setVisible(false);
        
        
        if (vpri.Escritorio.getComponentCount() > 0) {
            vpri.Escritorio.removeAll();
        }
        
        
        vpri.Escritorio.add(vcure);
        vcure.setVisible(true);
    }   
        
        if(ev.getSource().equals(vcuma.BtnBuscar)){
            
            String idText = vcuma.txtBusqueda.getText();
        
            if (!idText.isEmpty()) {
                try {
                    int idMascota = Integer.parseInt(idText);
                
                    Mascota mascota = daomas.obtenerMascotaPorId(idMascota);
                
                    if (mascota != null) {
                    
                        vcuma.txtNombreMas.setText(mascota.getNombre());
                        vcuma.txtEdad.setText(String.valueOf(mascota.getEdad()));
                        vcuma.txtRaza.setText(mascota.getRaza());
                        vcuma.txtSexo.setText(mascota.getSexo()); 
                        vcuma.txtIDMascota.setText(String.valueOf(mascota.getIdMascota()));
                    } else {
                        JOptionPane.showMessageDialog(vcuma, "No se encontró una mascota con ese ID.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(vcuma, "Por favor, ingrese un ID de mascota válido.");
                }
            } else {
                JOptionPane.showMessageDialog(vcuma, "Por favor, ingrese un ID para buscar.");
            }
        }    
}
    
    
    
    
    
}
