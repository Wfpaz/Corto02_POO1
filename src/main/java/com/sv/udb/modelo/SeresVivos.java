/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Walter
 */
public class SeresVivos {
    private int codigoSer, codigoReferSer;
    private String nombreSer, descripcionSer;

    public SeresVivos() {
    }

    public SeresVivos(int codigoSer, int codigoReferSer, String nombreSer, String descripcionSer) {
        this.codigoSer = codigoSer;
        this.codigoReferSer = codigoReferSer;
        this.nombreSer = nombreSer;
        this.descripcionSer = descripcionSer;
    }

    public int getCodigoSer() {
        return codigoSer;
    }

    public void setCodigoSer(int codigoSer) {
        this.codigoSer = codigoSer;
    }

    public int getCodigoReferSer() {
        return codigoReferSer;
    }

    public void setCodigoReferSer(int codigoReferSer) {
        this.codigoReferSer = codigoReferSer;
    }

    public String getNombreSer() {
        return nombreSer;
    }

    public void setNombreSer(String nombreSer) {
        this.nombreSer = nombreSer;
    }

    public String getDescripcionSer() {
        return descripcionSer;
    }

    public void setDescripcionSer(String descripcionSer) {
        this.descripcionSer = descripcionSer;
    }

    @Override
    public String toString() {
        return nombreSer;
    }
}
