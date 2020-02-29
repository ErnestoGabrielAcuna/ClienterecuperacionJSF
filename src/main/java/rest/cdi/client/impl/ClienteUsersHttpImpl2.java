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
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import rest.cdi.client.consumidor.ClienteUsersHttp2;
import rest.cdi.client.entidad.Users;

@ApplicationScoped
public class ClienteUsersHttpImpl2 implements ClienteUsersHttp2 {


	 final static String Users_URL = "http://localhost:8000/Servicio-Users/Users";
	CloseableHttpClient httpClient = HttpClients.createDefault();

	@Override
	public List<Users> listar() {

		

		HttpGet get = new HttpGet(Users_URL);
		get.addHeader("Accept", "application/json");
		List<Users> dto = new ArrayList();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			dto = httpClient.execute(get, response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status == 200) {
					return new ObjectMapper().readValue(response.getEntity().getContent(),
							new TypeReference<List<Users>>() {
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
