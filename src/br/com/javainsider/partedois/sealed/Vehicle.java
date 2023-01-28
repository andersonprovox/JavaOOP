package br.com.javainsider.partedois.sealed;

public abstract  sealed class Vehicle permits Car, Bus {
    public abstract void drive();
}
