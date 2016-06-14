package co.edu.usbcali.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.demo.modelo.TiposUsuarios;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTipoUsuario {
	
	private static final Logger log = LoggerFactory.getLogger(TestCliente.class);

	private Long tusuCodigo = 11L;

	/*
	 * creacion del tipo usuario
	 * 
	 */
	@Test
	public void testA() {

		String nombreTipoUsuario = "Empleado";

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposUsuarios tiposUsuarios = (TiposUsuarios) session.get(TiposUsuarios.class, tusuCodigo);

		assertNull("El tipo de documento ya existe", tiposUsuarios);

		tiposUsuarios = new TiposUsuarios();

		tiposUsuarios.setTusuCodigo(tusuCodigo);
		tiposUsuarios.setTusuNombre(nombreTipoUsuario);

		session.getTransaction().begin();
		session.save(tiposUsuarios);
		session.getTransaction().commit();

		session.close();
	}

	/*
	 * consulta del tipo de usuario
	 * 
	 */
	@Test
	public void testB() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposUsuarios tiposUsuarios = (TiposUsuarios) session.get(TiposUsuarios.class, tusuCodigo);

		assertNotNull("El tipo de usuario no existe", tiposUsuarios);
		log.info("codigo tipo usuario: " + tiposUsuarios.getTusuCodigo());
		log.info("nombre tipo usuario: " + tiposUsuarios.getTusuNombre());

		session.close();
	}

	/*
	 * modificacion del tipo usuario
	 * 
	 */
	@Test
	public void testC() {

		String nombreTipoUsuario = "Secretario";

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposUsuarios tiposUsuarios = (TiposUsuarios) session.get(TiposUsuarios.class, tusuCodigo);

		assertNotNull("El tipo de documento no existe", tiposUsuarios);

		tiposUsuarios.setTusuNombre(nombreTipoUsuario);

		session.getTransaction().begin();
		session.update(tiposUsuarios);
		session.getTransaction().commit();

		session.close();
	}

	/*
	 * borrado del tipo usuario
	 * 
	 */
	@Test
	public void testD() {

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposUsuarios tiposUsuarios = (TiposUsuarios) session.get(TiposUsuarios.class, tusuCodigo);

		assertNotNull("El tipo de documento no existe", tiposUsuarios);

		session.getTransaction().begin();
		session.delete(tiposUsuarios);
		session.getTransaction().commit();

		session.close();
	}

}
