package com.example.pruebaexamen;

public class Imc {
    private float peso, estatura;

    //Constructor vacio
    public Imc() {
    }

    //Constructor de parametros

    public Imc(float peso, float estatura) {
        this.peso = peso;
        this.estatura = estatura;
    }

    //Encapsulamiento
    public float getPeso() {
        return peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    //Metodo
    public float calcularImc(){
        float resultado = 0.0f;
        resultado = peso / (estatura * estatura);
        return resultado;
    }
}
