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
    private LocalDate fechaReserva;

    public Reserva(int IDReserva, int IDServicio, int IDMascota, int IDCliente, LocalDate fechaReserva) {
        this.IDReserva = IDReserva;
        this.IDServicio = IDServicio;
        this.IDMascota = IDMascota;
        this.IDCliente = IDCliente;
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

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    
    
    
}
