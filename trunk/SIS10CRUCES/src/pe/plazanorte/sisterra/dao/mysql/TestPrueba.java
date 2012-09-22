package pe.plazanorte.sisterra.dao.mysql;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pe.plazanorte.sisterra.entidades.Proveedor;

public class TestPrueba extends TestCase{
	private MySqlProveedorDAO mysqlproveedor;
	
	@Before
	public void setUp() throws Exception {
		mysqlproveedor = new MySqlProveedorDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistrarProveedor() {
		Proveedor proveedor = new Proveedor();
		proveedor.setIdProveedor(10);
		mysqlproveedor.registrarProveedor(proveedor);
		
		assertEquals(1, mysqlproveedor.getClass());
	}

}
