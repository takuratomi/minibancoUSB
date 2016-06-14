package co.edu.usbcali.demo.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCliente {

	private static final Logger log = LoggerFactory.getLogger(TestCliente.class);
	private Long idCliente = 162020L;

	/**
	 * Esta prueba crea un cliente
	 */
	@Test
	public void testA() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Clientes clientes = new Clientes();
		clientes.setCliId(idCliente);
		clientes.setCliDireccion("Avenida Siempre Viva 123 Cali");
		clientes.setCliMail("hjsimpson@gmail.com");
		clientes.setCliNombre("Homero J Simpson");
		clientes.setCliTelefono("55555555");

		TiposDocumentos tiposDocumentos = (TiposDocumentos) session.get(TiposDocumentos.class, 10L);

		clientes.setTiposDocumentos(tiposDocumentos);

		session.getTransaction().begin();
		session.save(clientes);
		session.getTransaction().commit();

		session.close();
	}

	/**
	 * Consulta el cliente
	 */
	@Test
	public void testB() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Clientes clientes = (Clientes) session.get(Clientes.class, idCliente);

		assertNotNull("El cliente no existe", clientes);

		log.info("" + clientes.getCliId());
		log.info(clientes.getCliNombre());
		log.info(clientes.getCliTelefono());
		log.info(clientes.getCliMail());

		session.close();
	}

	/**
	 * Modificar Cliente
	 */
	@Test
	public void testC() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Clientes clientes = (Clientes) session.get(Clientes.class, idCliente);
		assertNotNull("El cliente no existe", clientes);

		clientes.setCliDireccion("Avenida Siempre Viva 123");
		clientes.setCliMail("hjsimpson@gmail.com");
		clientes.setCliNombre("Homero J Simpson");
		clientes.setCliTelefono("55555555");

		TiposDocumentos tiposDocumentos = (TiposDocumentos) session.get(TiposDocumentos.class, 10L);

		clientes.setTiposDocumentos(tiposDocumentos);

		session.getTransaction().begin();
		session.update(clientes);
		session.getTransaction().commit();

		session.close();
	}

	/**
	 * Borrar Cliente
	 */
	@Test
	public void testD() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Clientes clientes = (Clientes) session.get(Clientes.class, idCliente);
		assertNotNull("El cliente no existe", clientes);

		session.getTransaction().begin();
		session.delete(clientes);
		session.getTransaction().commit();

		session.close();
	}

}
