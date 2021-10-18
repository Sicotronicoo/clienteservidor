package com.example.demo.modelo;

public class Usuario {
	private String usuario;
	private int puntuacion;
	private String resultado;

	public Usuario() {

	}
	public Usuario(String usuario, int puntuacion, String resultado) {
		this.usuario = usuario;
		this.puntuacion = puntuacion;
		this.resultado =  resultado;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}