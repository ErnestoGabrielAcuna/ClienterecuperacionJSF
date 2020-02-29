package rest.cdi.client.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rest.cdi.client.consumidor.ClienteTodosHttp;
import rest.cdi.client.entidad.Todos;

@ApplicationScoped
public class ClienteTodosHttpImpl implements ClienteTodosHttp {


	 final static String TODOS_URL = "http://localhost:8000/Servicio-Todos/todos";
	CloseableHttpClient httpClient = HttpClients.createDefault();

	@Override
	public List<Todos> listar() {

		

		HttpGet get = new HttpGet(TODOS_URL);
		get.addHeader("Accept", "application/json");
		List<Todos> dto = new ArrayList();
		ObjectMapper mapper = new ObjectMapper();
		try {
			dto = httpClient.execute(get, response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status == 200) {
					return new ObjectMapper().readValue(response.getEntity().getContent(),
							new TypeReference<List<Todos>>() {
							});
				}
				return null;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("lista: " + dto);
		return dto;
	}

	
}
