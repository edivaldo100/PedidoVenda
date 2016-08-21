package br.com.caelum.vraptor.blank;

import java.util.List;

import br.com.caelum.vraptor.Resource;

/*
* anotando seu controller com @Resource, seus métodos públicos ficarão disponíveis
* para receber requisições web.
*/
@Resource
public class ClientsController {

    private ClientDao dao;

    /*
     * Você pode receber as dependências da sua classe no construtor, e o VRaptor vai
     * se encarregar de criar ou localizar essas dependências pra você e usá-las pra
     * criar o seu controller. Para que o VRaptor saiba como criar o ClientDao você
     * deve anotá-lo com @Component.
     */
    public ClientsController(ClientDao dao) {
        this.dao = dao;
    }

    /*
     * Todos os métodos públicos do seu controller estarão acessíveis pela web.
     * Por exemplo, o método form pode ser acessado pela URI /clients/form e
     * vai redirecionar para a jsp /WEB-INF/jsp/clients/form.jsp
     */
    public void form() {
    	System.out.println("FORMMMMMMMMMMMM");
        // código que carrega dados para checkboxes, selects, etc
    }

    /*
     * Você pode receber parâmetros no seu método e o VRaptor tentará popular os
     * campos dos parâmetro de acordo com a requisição. Se houver na requisição:
     * custom.name=Lucas
     * custom.address=R.Vergueiro
     * então teremos os campos name e address do Client custom populados com
     * Lucas e R.Vergueiro via getters e setters
     * URI: /clients/add
     * view: /WEB-INF/jsp/clients/add.jsp
     */
    public void add(Client custom) {
        dao.save(custom);
    }

    /*
     * O retorno do seu método é exportado para a view. Nesse caso, como o retorno é
     * uma lista de clientes, a variável acessível no jsp será ${clientList}.
     * URI: /clients/list
     * view: /WEB-INF/jsp/clients/list.jsp
     */
    public List<Client> list() {
        return dao.listAll();
    }

    /*
     * Se o retorno for um tipo simples, o nome da variável exportada será o nome da
     * classe com a primeira letra minúscula. Nesse caso, como retornou um Client, a
     * variável na jsp será ${client}.
     * Devemos ter um parâmetro da requisição id=5 por exemplo, e o VRaptor vai
     * fazer a conversão do parâmetro em Long, e passar como parâmetro do método.
     * URI: /clients/view
     * view: /WEB-INF/jsp/clients/view.jsp
     */
    public Client view(Long id) {
        return dao.load(id);
    }
}
