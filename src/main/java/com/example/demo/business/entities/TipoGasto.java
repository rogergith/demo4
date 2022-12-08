package com.example.demo.business.entities;

public class TipoGasto {
	
	private int id;
	private String tipo;
	public TipoGasto(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	public TipoGasto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "TipoGasto [\n\tid = " + id + ",\n       tipo = " + tipo + "\n]";
	}

}
