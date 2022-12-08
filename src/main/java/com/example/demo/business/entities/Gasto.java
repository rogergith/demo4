package com.example.demo.business.entities;

import java.sql.Date;
import java.time.LocalDateTime;

public class Gasto {
    private Integer gasto = null;
    private String descripcion = null;
    private Date date;
    private Integer tipoGasto;
    
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(Integer tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	@Override
	public String toString() {
		return "Gasto [\n\tgasto = " + gasto + ",\n       descripcion = " + descripcion + ",\n       date = " + date
				+ ",\n       tipoGasto = " + tipoGasto + "\n]";
	}
	

}
