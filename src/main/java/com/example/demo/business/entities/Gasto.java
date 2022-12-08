package com.example.demo.business.entities;

import java.time.LocalDateTime;

public class Gasto {
    private Integer gasto = null;
    private String descripcion = null;
    private LocalDateTime fecha;
    
	public Gasto() {
		super();
	}
	public Integer getGasto() {
		return gasto;
	}
	public void setGasto(Integer gasto) {
		this.gasto = gasto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Gastos [\n\tgasto = " + gasto + ",\n       descripcion = " + descripcion + "\n]";
	}

}
