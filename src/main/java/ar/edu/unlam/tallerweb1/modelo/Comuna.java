package ar.edu.unlam.tallerweb1.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comuna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	
	@OneToMany (mappedBy = "comuna", cascade = CascadeType.ALL)
	private List <Barrio> listaBarrio = new ArrayList <Barrio>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Barrio> getListaBarrio() {
		return listaBarrio;
	}

	public void setListaBarrio(ArrayList<Barrio> listaBarrio) {
		this.listaBarrio = listaBarrio;
	}
	
	
	
	
}
