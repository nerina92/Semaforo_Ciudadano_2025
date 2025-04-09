package com.example.semaforociudadano;

public class Datos {
    private int limp;
    private int mant;
    private int orden;
    private int espacioVerde;
    private int mascotas;
    private int infra;
    private int seguridad;
    private int basura;

    public Datos(int limp, int mant, int orden, int espacioVerde, int mascotas, int infra, int seguridad, int basura) {
        this.limp = limp;
        this.mant = mant;
        this.orden = orden;
        this.espacioVerde = espacioVerde;
        this.mascotas = mascotas;
        this.infra = infra;
        this.seguridad = seguridad;
        this.basura = basura;
    }

    public int getLimp() {
        return limp;
    }

    public int getMant() {
        return mant;
    }

    public int getOrden() {
        return orden;
    }

    public int getEspacioVerde() {
        return espacioVerde;
    }

    public int getMascotas() {
        return mascotas;
    }

    public int getInfra() {
        return infra;
    }

    public int getSeguridad() {
        return seguridad;
    }

    public int getBasura() {
        return basura;
    }
}


