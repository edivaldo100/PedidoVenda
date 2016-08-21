package br.com.caelum.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.modelo.Usuario;

public class UsuarioDao {
	private Session session;

	UsuarioDao(Session session) {
		this.session = session;
	}


	void adiciona(Usuario u) {
		this.session.save(u);
	}



	void remove (Usuario u) {
	this.session.delete(u);
	
	}



	void atualiza(Usuario u) {
		this.session.merge(u);
	}



	List<Usuario> listaTudo() {
		return this.session.createCriteria(Usuario.class).list();
	}


	Usuario procura(Long id) {
		return (Usuario) session.load(Usuario.class, id);
	}
}
