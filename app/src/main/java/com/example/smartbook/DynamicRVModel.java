package com.example.smartbook;

import androidx.appcompat.app.AppCompatActivity;

public class DynamicRVModel extends AppCompatActivity {
    int imagen;
    String titulo, sinopsis,fecha, autor;

    public DynamicRVModel(String titulo) {
        this.titulo = titulo;
    }

    public DynamicRVModel(int imagen, String titulo, String sinopsis, String fecha, String autor) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fecha = fecha;
        this.autor = autor;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
