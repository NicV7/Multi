/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuidador;
import Modelo.DaoCuidador;
import Modelo.DaoReserva;
import Modelo.DaoServicio;
import Modelo.Reserva;
import Modelo.Servicio;
import Vista.GestorMascotas;
import Vista.ReservaCliente;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nic
 */
public class CtlMisReservas implements ActionListener {
    
    private DaoReserva daore;
    private DaoCuidador daocu;
    private Cuidador cu;
    private Reserva re;
    private ReservaCliente vrecl;
    private GestorMascotas gsma;
    private ViewPrincipal vpri;
    private Servicio ser;
    private DaoServicio daoser;

    public CtlMisReservas(DaoReserva daore, DaoCuidador daocu, Cuidador cu, Reserva re, ReservaCliente vrecl, GestorMascotas gsma, ViewPrincipal vpri, Servicio ser, DaoServicio daoser) {
        this.daore = daore;
        this.daocu = daocu;
        this.cu = cu;
        this.re = re;
        this.vrecl = vrecl;
        this.gsma = gsma;
        this.vpri = vpri;
        this.ser = ser;
        this.daoser = daoser;
        
        vrecl.BtnGenerar.addActionListener(this);
        vrecl.btnAtras.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vrecl.btnAtras)){
            
            vrecl.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(gsma);
            gsma.setVisible(true); 
            
        }
        
        if(ev.getSource().equals(vrecl.BtnGenerar)){
            int idMascota = Integer.parseInt(gsma.txtBusqueda.getText());
            List<Reserva> reservas = daore.obtenerReservasPorMascota(idMascota);
            String[] tit = {"IDReserva", "NombreServicio", "IDCliente", "IDCuidador", "FechaReserva"};
            DefaultTableModel dtm = new DefaultTableModel(null, tit);
            for (Reserva res : reservas) {
                Object[] fila = {
                    res.getIDReserva(),
                    res.getServicio() != null ? res.getServicio().getNombre() : "No asignado", 
                    res.getIDCliente(),
                    res.getIDCuidador() == 0 ? "Sin Asignar" : res.getIDCuidador(),
                    res.getFechaReserva().toString()
                };
                dtm.addRow(fila);
            }
                 vrecl.TablaReservas.setModel(dtm); 
        }
        
    }
    
    
    
    
}
