package com.projecto.ola.java.model;

public class Product {
    //Atributes starts
    private Integer id;
    private String naame;
    private Integer quantity;
    private Double valor;
    private String observation;
    //Atributes ends
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaame() {
        return naame;
    }

    public void setNaame(String naame) {
        this.naame = naame;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
