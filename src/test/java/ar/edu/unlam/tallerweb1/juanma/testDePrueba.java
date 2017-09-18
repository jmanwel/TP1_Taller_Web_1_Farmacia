package ar.edu.unlam.tallerweb1.juanma;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Producto;

public class testDePrueba extends SpringTest {

	//@Test
	//public void test() {
	//fail("Not yet implemented");
	//}

	@Test
	@Transactional 
	@Rollback(false)
	public void QueUnDatoPersista() {
				
		Producto p1 = new Producto();
		
		p1.setDescripcion("teclado");
		p1.setPrecio(100.00);
		getSession().save(p1);
		assertThat(getSession().get(Producto.class , p1.getId()));
	
}
	
}
