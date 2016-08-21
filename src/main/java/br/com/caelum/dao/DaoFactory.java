package br.com.caelum.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.modelo.Usuario;
import br.com.caelum.util.HibernateUtil;

public class DaoFactory {
	private final Session session;
	private Transaction transaction;

	public DaoFactory() {
		session = HibernateUtil.getSession();
	}

	public void beginTransaction() {
		this.transaction = this.session.beginTransaction();
	}

	public void commit() {
		this.transaction.commit();
		this.transaction = null;
	}

	public boolean hasTransaction() {
		return this.transaction != null;
	}

	public void rollback() {
		this.transaction.rollback();
		this.transaction = null;
	}

	public void close() {
		this.session.close();
	}

	public Dao<Usuario> getUsuarioDao() {
		return new Dao<Usuario>(this.session, Usuario.class);
	}

}
