package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmokeTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	@Before
	public void set_up() {
	}
	
	@After
	public void tear_down() { }
	
	@Test
	public void smoke_test() {
		boolean test = true;
		assertEquals(true, test);
	}
}
