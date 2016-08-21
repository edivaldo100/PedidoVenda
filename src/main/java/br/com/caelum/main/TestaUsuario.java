package br.com.caelum.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.dao.Dao;
import br.com.caelum.dao.DaoFactory;
import br.com.caelum.modelo.Usuario;
import br.com.caelum.util.HibernateUtil;

public class TestaUsuario {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		// cria um usuario
		Usuario u = new Usuario();
		
		u.setLogin("admin6");
		u.setSenha("admin66");
		
		//UsuarioDao dao = new UsuarioDao(session);
		Dao dao = new DaoFactory().getUsuarioDao();
		dao.adiciona(u);

		// abre transacao e insere
		Transaction t = session.beginTransaction();
		
		session.save(u);
		t.commit();
		
		// lista usuarios
		List<Usuario> lista = dao.listaTudo();
		for (Usuario usuario : lista) {
		System.out.println("ID: "+usuario.getId()+" - "+usuario.getLogin());
		}
		session.close();

		
	}
}
