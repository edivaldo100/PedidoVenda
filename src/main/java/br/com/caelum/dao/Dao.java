package br.com.caelum.dao;

import java.util.List;

import org.hibernate.Session;

public class Dao<T> {
	private final Session session;
	private final Class classe;

	Dao(Session session, Class classe) {
		this.session = session;
		this.classe = classe;
	}

	public void adiciona(T u) {
		this.session.save(u);
	}

	public List<T> listaTudo() {
		return this.session.createCriteria(this.classe).list();
	}



	public void remove(T u) {
		this.session.delete(u);

	}

	public void atualiza(T u) {
		this.session.merge(u);
	}



	//public T procura(Long id) {
		//return (T) session.load(T.class, id);
	//}
}