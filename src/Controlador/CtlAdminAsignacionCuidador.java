/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuidador;
import Modelo.DaoCuidador;
import Modelo.DaoReserva;
import Modelo.Reserva;
import Vista.AdminAsignacionCuida;
import Vista.GestorCuidadores;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;
/**
 *
 * @author Nic
 */
public class CtlAdminAsignacionCuidador implements ActionListener {
    
    private DaoReserva daore;
    private DaoCuidador daocu;
    private Cuidador cu;
    private Reserva re;
    private AdminAsignacionCuida vadminasigcu;
    private GestorCuidadores gstocuida;
    private ViewPrincipal vpri;

    public CtlAdminAsignacionCuidador(DaoReserva daore, DaoCuidador daocu, Cuidador cu, Reserva re, AdminAsignacionCuida vadminasigcu, GestorCuidadores gstocuida, ViewPrincipal vpri) {
        this.daore = daore;
        this.daocu = daocu;
        this.cu = cu;
        this.re = re;
        this.vadminasigcu = vadminasigcu;
        this.gstocuida = gstocuida;
        this.vpri = vpri;
        
        vadminasigcu.btnAtras.addActionListener(this);
        vadminasigcu.BtnGenerarCuidadores.addActionListener(this);
        vadminasigcu.BtnGenerarReservas.addActionListener(this);
        vadminasigcu.btnAsignar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vadminasigcu.btnAtras)){
            vadminasigcu.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(gstocuida);
            gstocuida.setVisible(true);
        }
        
        if(ev.getSource().equals(vadminasigcu.BtnGenerarCuidadores)){
            
            ResultSet rst = daocu.generarReporteCuidadores();
            if(rst != null){
                String[] tit = {"nit","nombre","apellido","correo","telefono","direccion","cargo","especializacion"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                vadminasigcu.TablaCuidadores.setModel(dtm);
                try {
                    while(rst.next()){
                        Object[] fila = {rst.getInt("nit"),rst.getString("nombre"),rst.getString("apellido"),rst.getString("correo"),rst.getString("telefono"),rst.getString("direccion"),rst.getString("cargo"),rst.getString("especializacion")};
                        dtm.addRow(fila);
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al buscar las mascotas: "+ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al generar el listado de mascotas","Error",1);
                }
            }
            
        }
        
        if(ev.getSource().equals(vadminasigcu.BtnGenerarReservas)){
            
            List<Reserva> reservas = daore.obtenerReservasSinCuidador();
            String[] tit = {"IDReserva", "IDServicio", "IDMascota", "IDCliente", "IDCuidador", "FechaReserva"};
            DefaultTableModel dtm = new DefaultTableModel(null, tit);
            for (Reserva res : reservas) {
                Object[] fila = {
                    res.getIDReserva(),
                    res.getIDServicio(),
                    res.getIDMascota(),
                    res.getIDCliente(),
                    res.getIDCuidador() == 0 ? "Sin Asignar" : res.getIDCuidador(),
                    res.getFechaReserva().toString()
                };
                dtm.addRow(fila);
            }
            vadminasigcu.TablaReservas.setModel(dtm);   
        }
        
        if(ev.getSource().equals(vadminasigcu.btnAsignar)){
            
            try {
                
                int idReserva = Integer.parseInt(vadminasigcu.txtIDReserva.getText());
                int idCuidador = Integer.parseInt(vadminasigcu.txtNit.getText());
                
                Reserva reserva = new Reserva();
                reserva.setIDReserva(idReserva);
                if(daore.Consultar(reserva)){
                    if(reserva.getIDCuidador() != 0){
                        JOptionPane.showMessageDialog(null, "Esta reserva ya tiene un cuiador asignado");
                        return;
                    }
                }
                
                boolean asignado = daore.asignarCuidadorAReserva(idReserva, idCuidador);
                if(asignado){
                    JOptionPane.showMessageDialog(null, "Cuidador asignado correctamente");
                    
                    List<Reserva> reservas = daore.obtenerReservasSinCuidador();
                    String[] tit = {"IDReserva", "IDServicio", "IDMascota", "IDCliente", "IDCuidador", "FechaReserva"};
                    DefaultTableModel dtm = new DefaultTableModel(null, tit);
                    for (Reserva res : reservas) {
                        Object[] fila = {
                            res.getIDReserva(),
                            res.getIDServicio(),
                            res.getIDMascota(),
                            res.getIDCliente(),
                            res.getIDCuidador() == 0 ? "Sin Asignar" : res.getIDCuidador(),
                            res.getFechaReserva().toString()
                        };
                        dtm.addRow(fila);
                    }
                    vadminasigcu.TablaReservas.setModel(dtm);
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede asiganr el cuiaddor","Error",1);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, Ingrese valores para los campos.","Error",1);
            }
            
        }
        
    }
    
    
    
    
}
