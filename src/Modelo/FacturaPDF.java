/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

package Modelo;

/**
 *
 * @author Nic


import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;

public class FacturaPDF {
    
    public void generarPDF(String cliente, int nit, String mascota, String edad, String sexo, 
                           List<String> servicios, List<Double> precios, Double total) {
        String ruta = "factura_" + cliente + ".pdf";

        try (PdfWriter writer = new PdfWriter(ruta);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {
            
            // Título
            document.add(new Paragraph("Facturación").setBold().setFontSize(20));

            // Cliente y Mascota
            document.add(new Paragraph("Cliente: " + cliente));
            document.add(new Paragraph("NIT: " + nit));
            document.add(new Paragraph("\nMascota:"));
            document.add(new Paragraph(mascota));
            document.add(new Paragraph(edad + " años"));
            document.add(new Paragraph(sexo));
            
            // Servicios y precios
            document.add(new Paragraph("\nServicios:").setBold());
            for (int i = 0; i < servicios.size(); i++) {
                document.add(new Paragraph(servicios.get(i) + " - " + precios.get(i) + " COP"));
            }

            // Total
            document.add(new Paragraph("\nTotal a pagar: " + total + " COP").setBold());
        } catch (Exception e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
        }
    }
}
*/