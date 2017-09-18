package ar.edu.unlam.tallerweb1.juanma;

import static org.junit.Assert.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

import static org.assertj.core.api.Assertions.assertThat;

public class FarmaciaTurnoMartes extends SpringTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
		
	@Test
	@Transactional
	@Rollback(true)
	public void testFarmaciaTurnoMartes()
	{
		//creo el dato y lo guardo en la BD
		Farmacia f1 = new Farmacia();
		f1.setDiaDeTurno("Martes");
		getSession().save(f1);
		
		
		Farmacia f2 = new Farmacia();
		f2.setDiaDeTurno("Martes");
		getSession().save(f2);
		
		Farmacia f3 = new Farmacia();
		f3.setDiaDeTurno("Jueves");
		getSession().save(f3);
		
		
		//creo la consulta
		List<Farmacia>resultado;
		resultado=getSession().createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno","Martes"))
				.list();
		
		assertThat(resultado).hasSize(2);
		
		
		for (Farmacia farray: resultado) {
			
			assertEquals("Martes",farray.getDiaDeTurno());
			
		}
		
	}
	
	

}
