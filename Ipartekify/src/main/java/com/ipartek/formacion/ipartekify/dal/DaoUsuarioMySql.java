package com.ipartek.formacion.ipartekify.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.ipartekify.modelos.Cancion;
import com.ipartek.formacion.ipartekify.modelos.Lista;
import com.ipartek.formacion.ipartekify.modelos.Usuario;

public class DaoUsuarioMySql implements DaoUsuario {

	@Override
	public void favoritoCancion(Long idUsuario, Long idCancion) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_favorito_cancion(?,?)}");) {
			cs.setLong(1, idUsuario);
			cs.setLong(2, idCancion);

			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido crear el favorito", e);
		}
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_buscar_email(?)}");) {
			cs.setString(1, email);

			ResultSet rs = cs.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("rol"));
			}

			return usuario;
		} catch (SQLException e) {
			throw new DalException("No se ha podido leer el usuario", e);
		}
	}

	@Override
	public void insertarLista(Long idUsuario, Lista nuevaLista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_lista_insertar(?, ?, ?)}");) {
			cs.setLong(1, idUsuario);
			cs.setString(2, nuevaLista.getNombre());
			cs.setString(3, nuevaLista.getDescripcion());

			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar la lista", e);
		}
	}

	@Override
	public Iterable<Lista> obtenerListas(Long id) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_listas(?)}");) {
			cs.setLong(1, id);

			ResultSet rs = cs.executeQuery();

			Lista lista = null;
			ArrayList<Lista> listas = new ArrayList<>();

			while (rs.next()) {
				lista = new Lista(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
				listas.add(lista);
			}

			return listas;
		} catch (SQLException e) {
			throw new DalException("No se han podido leer las listas", e);
		}
	}

	@Override
	public Lista obtenerListaPorId(Long idLista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_lista(?)}");) {
			cs.setLong(1, idLista);

			ResultSet rs = cs.executeQuery();

			Lista lista = null;

			if (rs.next()) {
				lista = new Lista(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
			}

			return lista;
		} catch (SQLException e) {
			throw new DalException("No se ha podido leer la lista", e);
		}
	}

	@Override
	public Iterable<Cancion> obtenerCancionesLista(Long idLista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_lista_canciones(?)}");) {
			cs.setLong(1, idLista);

			ResultSet rs = cs.executeQuery();

			Cancion cancion = null;
			ArrayList<Cancion> canciones = new ArrayList<>();

			while (rs.next()) {
				// FIXME las canciones de las listas pueden o no ser favoritas para ese usuario
				cancion = new Cancion(rs.getLong("id"), rs.getString("nombre"), Globales.timeADuration(rs.getTime("tiempo")), rs.getString("mp3"), null, null);
				canciones.add(cancion);
			}

			return canciones;
		} catch (SQLException e) {
			throw new DalException("No se han podido leer las canciones", e);
		}
	}

	@Override
	public void insertarCancionLista(Long idCancion, Long idLista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_cancion_lista_insertar(?, ?)}");) {
			cs.setLong(1, idCancion);
			cs.setLong(2, idLista);

			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar la cancion en la lista", e);
		}
	}

	@Override
	public void quitarCancionLista(Long idCancion, Long idLista) {
		try (Connection con = Globales.obtenerConexion();
				CallableStatement cs = con.prepareCall("{call usuarios_cancion_lista_borrar(?, ?)}");) {
			cs.setLong(1, idCancion);
			cs.setLong(2, idLista);

			cs.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("No se ha podido borrar la cancion en la lista", e);
		}
	}
}
