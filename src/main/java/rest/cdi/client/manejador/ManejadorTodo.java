package rest.cdi.client.manejador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rest.cdi.client.consumidor.ClienteTodosHttp;
import rest.cdi.client.entidad.Todos;

@Named("manejadorTodos")
@SessionScoped
public class ManejadorTodo implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Todos> todosList;
	@Inject private ClienteTodosHttp cliente;
	
	public List<Todos> getTodosList() {
		return cliente.listar();
	}
	public void setTodosList(List<Todos> todosList) {
		this.todosList = todosList;
	}
}

