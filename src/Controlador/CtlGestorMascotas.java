/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.DaoClienteMascotaReporte;
import Modelo.DaoMascota;
import Modelo.Mascota;
import Vista.ClientePrincipal;
import Vista.GestorMascotas;
import Vista.MascotaAjuste;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nic
 */
public class CtlGestorMascotas implements ActionListener {
    
    
    private Mascota ma;
    private Cliente cl;
    private DaoClienteMascotaReporte daoclmare;
    private DaoMascota daoma;
    private ClientePrincipal vclpri;
    private MascotaAjuste vmaajus;
    private ViewPrincipal vpri;
    private GestorMascotas vgesma;

    public CtlGestorMascotas(Mascota ma, Cliente cl, DaoClienteMascotaReporte daoclmare, DaoMascota daoma, ClientePrincipal vclpri, MascotaAjuste vmaajus, ViewPrincipal vpri, GestorMascotas vgesma) {
        this.ma = ma;
        this.cl = cl;
        this.daoclmare = daoclmare;
        this.daoma = daoma;
        this.vclpri = vclpri;
        this.vmaajus = vmaajus;
        this.vpri = vpri;
        this.vgesma = vgesma;
        
        vgesma.BtnAtras.addActionListener(this);
        vgesma.BtnBuscar.addActionListener(this);
        vgesma.BtnGenerar.addActionListener(this);
        vgesma.BtnPefilAjuste.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vgesma.BtnAtras)){
            
            vgesma.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vclpri);
            vclpri.setVisible(true); 
            
            vpri.revalidate();
            vpri.repaint();
            
            DefaultTableModel dtm = (DefaultTableModel) vgesma.Tabla.getModel();
            dtm.setRowCount(0);
            
            vgesma.txtBusqueda.setText("");
            vgesma.txtNombre.setText("");
            vgesma.txtEdad.setText("");
            vgesma.txtRaza.setText("");
        }
        
        if(ev.getSource().equals(vgesma.BtnBuscar)){
            
            int idmascota = Integer.parseInt(vgesma.txtBusqueda.getText());
            int nitClienteLogeado = cl.getNit();
            ResultSet rst = daoclmare.obtenerMascotaPorIdYCliente(idmascota, nitClienteLogeado);
    
            try {
                if(rst != null && rst.next()){
                String nombremascota = rst.getString("nombre");
                String razamascota = rst.getString("raza");
                int edadmascota = rst.getInt("edad");
                vgesma.txtNombre.setText(nombremascota);
                vgesma.txtRaza.setText(razamascota);
                vgesma.txtEdad.setText(Integer.toString(edadmascota));
                } else {
                JOptionPane.showMessageDialog(null, "No se encontró una mascota asociada con este cliente.");
                }
            } catch (Exception e) {
                System.err.println("Error al realizar la busqueda");
                JOptionPane.showMessageDialog(null, "Error al realizar la busqueda.");
            }      
        }
        
        if(ev.getSource().equals(vgesma.BtnGenerar)){
            
            int nitCliente = cl.getNit();
            ResultSet rst = daoclmare.generarReporteClienteMascota(nitCliente);
            if(rst != null){
                String[] tit = {"idmascota","nombre","raza","edad","sexo"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                vgesma.Tabla.setModel(dtm);
                try {
                    while(rst.next()){
                        Object[] fila = {rst.getInt("idmascota"),rst.getString("nombreMascota"),rst.getString("raza"),rst.getInt("edad"),rst.getString("sexo")};
                        dtm.addRow(fila);
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al buscar las mascotas: "+ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al generar el listado de mascotas","Error",1);
                }
            }
            
        }
        
        if(ev.getSource().equals(vgesma.BtnPefilAjuste)){
            
            vgesma.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vmaajus);
            vmaajus.setVisible(true); 
            
        }
        
        
    }
    
    
    
    
    
}
