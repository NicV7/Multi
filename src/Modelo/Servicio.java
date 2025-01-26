/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Nic
 */
public class Servicio {
    
    private int IDServicio;
    private String Nombre;
    private String Descripcion;
    private int DuracionEstimada;
    private int Disponibilidad;
    private Double Precio;

    public Servicio(int IDServicio, String Nombre, String Descripcion, int DuracionEstimada, int Disponibilidad, Double Precio) {
        this.IDServicio = IDServicio;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.DuracionEstimada = DuracionEstimada;
        this.Disponibilidad = Disponibilidad;
        this.Precio = Precio;
    }

    public Servicio() {
    }

    
    
    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getDuracionEstimada() {
        return DuracionEstimada;
    }

    public void setDuracionEstimada(int DuracionEstimada) {
        this.DuracionEstimada = DuracionEstimada;
    }

    public int getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(int Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }
    
    
    
}
