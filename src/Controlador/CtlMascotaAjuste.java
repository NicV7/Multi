/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoClienteMascotaReporte;
import Modelo.DaoMascota;
import Modelo.Mascota;
import Modelo.Cliente;
import Vista.ClientePerfil;
import Vista.Login;
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
public class CtlMascotaAjuste implements ActionListener {
    
    private Mascota ma;
    private Cliente cl;
    private DaoClienteMascotaReporte daoclmare;
    private DaoMascota daoma;
    private ClientePerfil vclper;
    private MascotaAjuste vmaajus;
    private ViewPrincipal vpri;
    private Login log;

    public CtlMascotaAjuste(Mascota ma, Cliente cl, DaoClienteMascotaReporte daoclmare, DaoMascota daoma, ClientePerfil vclper, MascotaAjuste vmaajus, ViewPrincipal vpri, Login log) {
        this.ma = ma;
        this.cl = cl;
        this.daoclmare = daoclmare;
        this.daoma = daoma;
        this.vclper = vclper;
        this.vmaajus = vmaajus;
        this.vpri = vpri;
        this.log = log;
        
        vmaajus.BtnAtras.addActionListener(this);
        vmaajus.btnGuardar.addActionListener(this);
        vmaajus.btnConsultar.addActionListener(this);
        vmaajus.btnActualizar.addActionListener(this);
        vmaajus.btnEliminar.addActionListener(this);
        vmaajus.btnLimpiar.addActionListener(this);
        vmaajus.btnGenerar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(ev.getSource().equals(vmaajus.BtnAtras)){
            
            vmaajus.setVisible(false);
            
            if(vpri.Escritorio.getComponentCount()>0){
                vpri.Escritorio.removeAll();
            }
            
            vpri.Escritorio.add(vclper);
            vclper.setVisible(true);
               
        }
        if(ev.getSource().equals(vmaajus.btnGuardar)){
            int nitCliente = Integer.parseInt(log.txtNit.getText());
            ma.setIdMascota(Integer.parseInt(vmaajus.txtidmascota.getText()));
            ma.setNombre(vmaajus.txtNombremascota.getText());
            ma.setRaza(vmaajus.txtRazaMascota.getText());
            ma.setEdad(Integer.parseInt(vmaajus.txtEdadMascota.getText()));
            ma.setPeso(Double.parseDouble(vmaajus.txtPesoMascota.getText()));
            ma.setColor(vmaajus.txtColorMascota.getText());
            ma.setSexo(vmaajus.txtSexoMascota.getText());
            ma.setNitCliente(nitCliente);
            if(daoma.Agregar(ma)){
                mensaje("Mascota Agregada correctamente..", "Agregar");
            }else{
                mensaje("Mascota no se pudo registrar", "Agregar");
            }
        }
        
        if(ev.getSource().equals(vmaajus.btnConsultar)){
            ma.setIdMascota(Integer.parseInt(vmaajus.txtidmascota.getText()));
            if(daoma.Consultar(ma)){
                vmaajus.txtNombremascota.setText(ma.getNombre());
                vmaajus.txtRazaMascota.setText(ma.getRaza());
                vmaajus.txtEdadMascota.setText(Integer.toString(ma.getEdad()));
                vmaajus.txtPesoMascota.setText(Double.toString(ma.getPeso()));
                vmaajus.txtColorMascota.setText(ma.getColor());
                vmaajus.txtSexoMascota.setText(ma.getSexo());
                mensaje("Mascota encontrada..", "Consultar");
            }else{
                mensaje("Mascota no existe..", "Consultar");
            }
        }
        
        if(ev.getSource().equals(vmaajus.btnActualizar)){
            ma.setNombre(vmaajus.txtNombremascota.getText());
            ma.setRaza(vmaajus.txtRazaMascota.getText());
            ma.setEdad(Integer.parseInt(vmaajus.txtEdadMascota.getText()));
            ma.setPeso(Double.parseDouble(vmaajus.txtPesoMascota.getText()));
            ma.setColor(vmaajus.txtColorMascota.getText());
            ma.setSexo(vmaajus.txtSexoMascota.getText());
            if(daoma.actualizarMascota(ma)){
                mensaje("Mascota actualizada exitosamente..", "Actualizar");
            }else{
                mensaje("Mascota no se pudo actualizar..", "Actualizar");
            }
        }
        
        if(ev.getSource().equals(vmaajus.btnEliminar)){
            ma.setIdMascota(Integer.parseInt(vmaajus.txtidmascota.getText()));
            if(daoma.eliminarMascota(ma)){
                mensaje("Mascota eliminada correctamente..", "Eliminar");
            }else{
                mensaje("Mascota no se pudo eliminar", "Eliminar");
            }
        }
        
        if(ev.getSource().equals(vmaajus.btnLimpiar)){
            limpiar();
        }
        if(ev.getSource().equals(vmaajus.btnGenerar)){
            int nitCliente = cl.getNit();
            ResultSet rst = daoclmare.generarReporteClienteMascota(nitCliente);
            if(rst != null){
                String[] tit = {"idmascota","nombre","raza","edad","sexo"};
                DefaultTableModel dtm = new DefaultTableModel(null,tit);
                vmaajus.Tabla.setModel(dtm);
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
    
    
    public void limpiar(){
        
        vmaajus.txtidmascota.setText(null);
        vmaajus.txtNombremascota.setText(null);
        vmaajus.txtRazaMascota.setText(null);
        vmaajus.txtEdadMascota.setText(null);
        vmaajus.txtPesoMascota.setText(null);
        vmaajus.txtColorMascota.setText(null);
        vmaajus.txtSexoMascota.setText(null);
        
        
    }
    
    public void mensaje(String msg, String tit){
        JOptionPane.showMessageDialog(null, msg,tit,1);
    }
    
}
