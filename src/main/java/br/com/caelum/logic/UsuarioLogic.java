package br.com.caelum.logic;

import br.com.caelum.modelo.Usuario;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class UsuarioLogic {
	public void adiciona(Usuario usuario) {
		// ... logica de adicionar no banco aqui ...
		System.out.println("Adiciona usuario " + usuario.getLogin());
	}
}
