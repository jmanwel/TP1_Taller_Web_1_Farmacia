package ar.edu.unlam.tallerweb1.juanma;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciasMismoBarrio extends SpringTest{

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testFarmaciasMismoBarrio()
	{
		
		Direccion d1 = new Direccion();
		Direccion d2 = new Direccion();
		Direccion d3 = new Direccion();
		Direccion d4 = new Direccion();
		
		getSession().save(d1);
		getSession().save(d2);
		getSession().save(d3);
		getSession().save(d4);
		
		Barrio b1 = new Barrio();
		Barrio b2 = new Barrio();
		
		getSession().save(b1);
		getSession().save(b2);
		
		Farmacia f1 = new Farmacia();
		Farmacia f2 = new Farmacia();
		Farmacia f3 = new Farmacia();
		Farmacia f4 = new Farmacia();
		
		getSession().save(f1);
		getSession().save(f2);
		getSession().save(f3);
		getSession().save(f4);
		
		b1.setNombre("Ramos Mejia");
		b2.setNombre("Boedo");
		
		d1.setCalle("calle 13");
		d1.setNumero("1313");
		d1.setBarrio(b2);
		
		d2.setCalle("calle 13");
		d2.setNumero("1314");
		d2.setBarrio(b2);
		
		d3.setCalle("Margaritas");
		d3.setNumero("1314");
		d3.setBarrio(b1);
		
		d4.setCalle("Rosales");
		d4.setNumero("1314");
		d4.setBarrio(b1);
		
	
		
		f1.setDireccion(d1);		
				
		f2.setDireccion(d2);
		
		f3.setDireccion(d3);
		
		f4.setDireccion(d4);
		
		
		List<Farmacia>resultado;
		resultado=getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "d")
			    .createAlias("d.barrio", "b")
				.add(Restrictions.eq("b.nombre","Ramos Mejia"))
				.list();
		
	
		
		assertThat(resultado).hasSize(2);
		
		
for (Farmacia farray: resultado) {
			//System.out.println(farray.getDireccion().getBarrio().getNombre());
			assertEquals("RAMOS MEJIA",farray.getDireccion().getBarrio().getNombre().toUpperCase());
			
		}
		
	}
		
	}


