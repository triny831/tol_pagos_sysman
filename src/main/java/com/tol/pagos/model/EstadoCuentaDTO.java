package com.tol.pagos.model;

public class EstadoCuentaDTO {

    private String nombre;
    private Double valorDeuda;
    private String estado;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getValorDeuda() { return valorDeuda; }
    public void setValorDeuda(Double valorDeuda) { this.valorDeuda = valorDeuda; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
