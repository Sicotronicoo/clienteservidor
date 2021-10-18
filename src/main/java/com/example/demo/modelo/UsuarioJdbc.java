package com.example.demo.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioJdbc implements UsuarioDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Usuario usuario) {
		return jdbcTemplate.update("insert into datos (usuario, puntuacion, resultado) values(?,?,?)",
				usuario.getUsuario(), usuario.getPuntuacion(), usuario.getResultado());
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> findByResultadoAndPuntuacion(String resultado, int puntuacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsuarioById(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		return jdbcTemplate.query("SELECT *  FROM datos order by Id DESC limit 5", (rs, rowNum) -> new Usuario(rs.getString("usuario"), rs.getInt("puntuacion"), rs.getString("resultado")));
	}

}