package mx.edu.uacm.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@Column
	private String modelo;
	
	//@OneToMany(mappedBy="accesorio")
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,fetch=FetchType.EAGER)
	private List<Accesorio> accesorios= new ArrayList<Accesorio>();
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAccesorios(List<Accesorio> accesorios) {
		this.accesorios=accesorios;
		
	}

	public List<Accesorio> getAccesorios() {
		return accesorios;
	}
	
	

}
