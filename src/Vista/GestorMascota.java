/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Nic
 */
public class GestorMascota extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewGestorMascotas
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Atras1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        BarraDeBusqueda1 = new javax.swing.JTextField();
        BtnBuscar1 = new javax.swing.JButton();
        PanelMostrarPet3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        nombre3 = new javax.swing.JLabel();
        Raza3 = new javax.swing.JLabel();
        Edad3 = new javax.swing.JLabel();
        Sexo3 = new javax.swing.JLabel();
        txtRaza3 = new javax.swing.JLabel();
        txtNombre4 = new javax.swing.JLabel();
        txtSexo3 = new javax.swing.JLabel();
        txtEdad4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        imgConfiguracion3 = new javax.swing.JLabel();
        ImgPerfilMascota3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(501, 807));
        setMinimumSize(new java.awt.Dimension(501, 807));
        setPreferredSize(new java.awt.Dimension(501, 807));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        Atras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/atras-removebg-preview(1).png"))); // NOI18N
        Atras1.setText("Imagen atras");
        Atras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Atras1MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel15.setText("Mascotas");

        jLabel16.setText("Imagen de interrogacion");

        jLabel17.setText("Busque y Selecciona una mascota ");

        jLabel18.setText("Icono busqueda");

        BarraDeBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarraDeBusqueda1ActionPerformed(evt);
            }
        });

        BtnBuscar1.setText("Buscar");
        BtnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Imagen Mascota");

        nombre3.setText("Nombre: ");

        Raza3.setText("Raza :");

        Edad3.setText("Edad: ");

        Sexo3.setText("Sexo: ");

        txtRaza3.setText(".");

        txtNombre4.setText(".");

        txtSexo3.setText(".");

        txtEdad4.setText(".");

        jLabel20.setText("Ajustes");

        jLabel21.setText("Perfil");

        imgConfiguracion3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ajuste(1).png"))); // NOI18N
        imgConfiguracion3.setText("Img Confi");
        imgConfiguracion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgConfiguracion3imgConfiguracionMouseClicked(evt);
            }
        });

        ImgPerfilMascota3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PerroC(1).png"))); // NOI18N
        ImgPerfilMascota3.setText("Img PeM");
        ImgPerfilMascota3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImgPerfilMascota3ImgPerfilMascotaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelMostrarPet3Layout = new javax.swing.GroupLayout(PanelMostrarPet3);
        PanelMostrarPet3.setLayout(PanelMostrarPet3Layout);
        PanelMostrarPet3Layout.setHorizontalGroup(
            PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(57, 57, 57)
                .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                        .addComponent(nombre3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                        .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                                .addComponent(Sexo3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSexo3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtRaza3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                                    .addComponent(Edad3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEdad4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Raza3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ImgPerfilMascota3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(34, 34, 34)
                        .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgConfiguracion3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel20))))))
        );
        PanelMostrarPet3Layout.setVerticalGroup(
            PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMostrarPet3Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre3)
                            .addComponent(txtNombre4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                                .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Raza3)
                                    .addComponent(txtRaza3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Edad3)
                                    .addComponent(txtEdad4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Sexo3)
                                    .addComponent(txtSexo3)))
                            .addGroup(PanelMostrarPet3Layout.createSequentialGroup()
                                .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ImgPerfilMascota3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imgConfiguracion3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelMostrarPet3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20))))
                        .addContainerGap(11, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Atras1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BarraDeBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(BtnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel15))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelMostrarPet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(144, 144, 144))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Atras1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BarraDeBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(BtnBuscar1))
                .addGap(18, 18, 18)
                .addComponent(PanelMostrarPet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(445, 445, 445))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Atras1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atras1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Atras1MouseClicked

    private void BarraDeBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarraDeBusqueda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarraDeBusqueda1ActionPerformed

    private void BtnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBuscar1ActionPerformed

    private void imgConfiguracion3imgConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgConfiguracion3imgConfiguracionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_imgConfiguracion3imgConfiguracionMouseClicked

    private void ImgPerfilMascota3ImgPerfilMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImgPerfilMascota3ImgPerfilMascotaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgPerfilMascota3ImgPerfilMascotaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Atras1;
    public javax.swing.JTextField BarraDeBusqueda1;
    public javax.swing.JButton BtnBuscar1;
    public javax.swing.JLabel Edad3;
    public javax.swing.JLabel ImgPerfilMascota3;
    public javax.swing.JPanel PanelMostrarPet3;
    public javax.swing.JLabel Raza3;
    public javax.swing.JLabel Sexo3;
    public javax.swing.JLabel imgConfiguracion3;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel nombre3;
    public javax.swing.JLabel txtEdad4;
    public javax.swing.JLabel txtNombre4;
    public javax.swing.JLabel txtRaza3;
    public javax.swing.JLabel txtSexo3;
    // End of variables declaration//GEN-END:variables
}