/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Cliente;
import Modelo.DaoCliente;
import Modelo.DaoClienteMascotaReporte;
import Modelo.Mascota;
import Vista.ClientePerfil;
import Vista.ClientePrincipal;
import Vista.Login;
import Vista.MascotaAjuste;
import Vista.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nic
 */
public class CtlClientePerfil implements ActionListener {
    
    private Login log;
    private ViewPrincipal vpri;
    private ClientePrincipal vclpri;
    private ClientePerfil vclper;
    private Cliente cl;
    private DaoCliente daocl;
    private Mascota ma;
    private DaoClienteMascotaReporte daoclmare;
    private MascotaAjuste vmaajus;

    public CtlClientePerfil(Login log, ViewPrincipal vpri, ClientePrincipal vclpri, ClientePerfil vclper, Cliente cl, DaoCliente daocl, Mascota ma, DaoClienteMascotaReporte daoclmare, MascotaAjuste vmaajus) {
        this.log = log;
        this.vpri = vpri;
        this.vclpri = vclpri;
        this.vclper = vclper;
        this.cl = cl;
        this.daocl = daocl;
        this.ma = ma;
        this.daoclmare = daoclmare;
        this.vmaajus = vmaajus;
        
        vclper.BtnSalir.addActionListener(this);
        vclper.BtnAjuste.addActionListener(this);
        vclper.BtnBuscar.addActionListener(this);
        vclper.BtnAjusteMascota.addActionListener(this);
        vclper.BtnGenerar.addActionListener(this);
    }

   
    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vclper.BtnSalir)){
            
            vclper.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vclpri);
            vclpri.setVisible(true);
 
        }
        if(ev.getSource().equals(vclper.BtnAjuste)){
            
        }
        if(ev.getSource().equals(vclper.BtnBuscar)){
            int idmascota = Integer.parseInt(vclper.txtBusqueda.getText());
            int nitClienteLogeado = cl.getNit();
            ResultSet rst = daoclmare.obtenerMascotaPorIdYCliente(idmascota, nitClienteLogeado);
    
            try {
                if(rst != null && rst.next()){
                String nombremascota = rst.getString("nombre");
                String razamascota = rst.getString("raza");
                int edadmascota = rst.getInt("edad");
                vclper.txtNombreMascota.setText(nombremascota);
                vclper.txtRazaMascota.setText(razamascota);
                vclper.txtEdadMascota.setText(Integer.toString(edadmascota));
                } else {
                JOptionPane.showMessageDialog(null, "No se encontró una mascota asociada con este cliente.");
                }
            } catch (Exception e) {
                System.err.println("Error al realizar la busqueda");
                JOptionPane.showMessageDialog(null, "Error al realizar la busqueda.");
            }
        }
        
        if(ev.getSource().equals(vclper.BtnAjusteMascota)){
            vclper.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vmaajus);
            vmaajus.setVisible(true);
        }
        if(ev.getSource().equals(vclper.BtnGenerar)){
            int nitCliente = cl.getNit();
            ResultSet rst = daoclmare.generarReporteClienteMascota(nitCliente);
            if(rst != null){
                String[] tit = {"idmascota","nombre","raza","edad","sexo"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                vclper.Tabla.setModel(dtm);
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
        
    }
    
    
    
    
}
