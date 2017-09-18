package ar.edu.unlam.tallerweb1.juanma;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

import static org.assertj.core.api.Assertions.assertThat;




public class FarmaciasMismaCalle extends SpringTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testFarmaciaMismaCalle()
	{
		//creo los datos y lo guardo en la BD
		
		
		Direccion d1 = new Direccion("Calle 13","1313");
		Direccion d2 = new Direccion("Calle 13","1314");		
		Direccion d3 = new Direccion("Azores","1024");
		getSession().save(d1);
		getSession().save(d2);
		getSession().save(d3);

		
		
		Farmacia f1 = new Farmacia();
		f1.setDireccion(d1);
		
		getSession().save(f1);
		
		Farmacia f2 = new Farmacia();
		f2.setDireccion(d2);
		getSession().save(f2);
		
		Farmacia f3 = new Farmacia();
		f3.setDireccion(d3);
		
		getSession().save(f3);
		
		
		//creo la consulta
		List<Farmacia>resultado;
		resultado=getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "d")
				.add(Restrictions.eq("d.calle","calle 13"))
				.list();
						
		assertThat(resultado).hasSize(2);
		
        for (Farmacia farray: resultado) {
			
			assertEquals("CALLE 13",farray.getDireccion().getCalle().toUpperCase());
			
		}
		
	}

}
