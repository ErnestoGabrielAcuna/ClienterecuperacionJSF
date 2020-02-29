package rest.cdi.client.manejador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rest.cdi.client.consumidor.ClienteUsersHttp2;
import rest.cdi.client.entidad.Users;

@Named("manejadorUsers")
@SessionScoped
public class ManejadorUsers2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Users> UsersList;
	@Inject private ClienteUsersHttp2 cliente;
	
	public List<Users> getUsersList() {
	return cliente.listar();
	}
	public void setUsersList(List<Users> UsersList) {
		this.UsersList = UsersList;
	}
	
}

