package com.example.demo.modelo;

import java.util.List;

public interface UsuarioDao {
	int count();

	int save(Usuario usuario);

	int update(Usuario usuario);

	int deleteById(Usuario usuario);

	List<Usuario> findAll();

	List<Usuario> findByResultadoAndPuntuacion(String resultado, int puntuacion);

	String getUsuarioById(String usuario);
}