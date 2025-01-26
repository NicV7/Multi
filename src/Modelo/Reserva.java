/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Nic
 */
public class Reserva {
    
    private int IDReserva;
    private int IDServicio;
    private int IDMascota;
    private int IDCliente;
    private int IDCuidador;
    private LocalDate fechaReserva;

    private Servicio servicio;

    public Reserva(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public Reserva() {
    }

    public Reserva(int IDReserva, int IDServicio, int IDMascota, int IDCliente, int IDCuidador, LocalDate fechaReserva) {
        this.IDReserva = IDReserva;
        this.IDServicio = IDServicio;
        this.IDMascota = IDMascota;
        this.IDCliente = IDCliente;
        this.IDCuidador = IDCuidador;
        this.fechaReserva = fechaReserva;
    }

    public int getIDReserva() {
        return IDReserva;
    }

    public void setIDReserva(int IDReserva) {
        this.IDReserva = IDReserva;
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public int getIDMascota() {
        return IDMascota;
    }

    public void setIDMascota(int IDMascota) {
        this.IDMascota = IDMascota;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getIDCuidador() {
        return IDCuidador;
    }

    public void setIDCuidador(int IDCuidador) {
        this.IDCuidador = IDCuidador;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    

    
    
    
}
