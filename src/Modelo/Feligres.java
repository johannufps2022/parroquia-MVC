/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;


/**
 *
 * @author estudiante
 */
public class Feligres {
   
    protected String cedula;
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected int estrato;
    protected boolean estado;
    protected int valorDiezmo;
    

    public Feligres() {
    }

    public Feligres(String cedula, String nombre, String direccion, String telefono, int estrato, boolean estado, int valorDiezmo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrato = estrato;
        this.estado = estado;
        this.valorDiezmo = valorDiezmo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int  getValorDiezmo() {
        return valorDiezmo;
    }

    public void setValorDiezmo(int valorDiezmo) {
        this.valorDiezmo = valorDiezmo;
    }
    
    
    
    @Override
    public String toString() {
        return "CC : " + cedula + " \nnombre : " + nombre + " \ndirección : " + direccion + " \ntelefono : " + telefono + " \nestrato :" 
                       + estrato + "\nestado :"
                + est() + "\nDiezmo :"+valorDiezmo+"";
    }
    
    public String est(){
        if(this.estado){
            return "deudor";
        }else if(this.estado==false)return "Cumplido";
        else
        
        return "estado no valido";
    }
    
}