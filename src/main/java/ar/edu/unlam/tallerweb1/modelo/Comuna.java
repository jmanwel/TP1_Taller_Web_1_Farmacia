package ar.edu.unlam.tallerweb1.modelo;


import java.util.ArrayList;

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
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Barrio barrio;

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

	
	private ArrayList <Barrio> listaBarrio = new ArrayList <Barrio>();
	
	public void agregarBarrio (Barrio b) 
	{listaBarrio.add(b);}
	
	public void setBarrio (Barrio b) 
	{this.barrio=b;}
	
	public Barrio getBarrio() 
	{return barrio;}
	
	
}
