package com.example.demo.modelo;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Usuario {
	private String usuario;
	private int puntuacion;
	private String resultado;

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

	public interface UsuarioDao {
		int count();
		int save(Usuario usuario);
		int update(Usuario usuario);
		int deleteById(Usuario usuario);
		
		List<Usuario> findAll();
		List<Usuario> findByResultadoAndPuntuacion(String resultado, int puntuacion);
		String getUsuarioById(String usuario);
	}

	@Repository
	public class UsuarioJdbc implements UsuarioDao {
		@Autowired
		private JdbcTemplate jdbcTemplate;

		@Override
		public int save(Usuario usuario) {
			return jdbcTemplate.update("insert into datos (usuario, puntuacion, resultado) values(?,?,?)", usuario.getUsuario(),
					usuario.getPuntuacion(), usuario.getResultado());
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
			return jdbcTemplate.query("select * from datos", (rs, rowNum) -> new Usuario());
		}

		@Controller
		public class BookController {
			@Autowired
			private UsuarioDao usuariodao;

			@RequestMapping(value = "/", method = RequestMethod.GET)
			public String index(Model modelo) {
				List<Usuario> users = usuariodao.findAll();
				modelo.addAttribute("users", users);
				return "users";
			}
		}
	}
}