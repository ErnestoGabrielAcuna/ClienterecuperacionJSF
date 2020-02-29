package rest.cdi.client.entidad;

import java.io.Serializable;



public class Todos implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer user_id;
	private Integer id;
	private String tittle;
	private String  completed;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	
	

}
