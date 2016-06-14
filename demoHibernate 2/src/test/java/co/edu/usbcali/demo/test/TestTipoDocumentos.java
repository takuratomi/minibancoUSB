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

import co.edu.usbcali.demo.modelo.TiposDocumentos;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTipoDocumentos {
	
	private static final Logger log = LoggerFactory.getLogger(TestCliente.class);
	private Long tdocCodigo = 40L;

	/*
	 * creacion del tipo documento
	 * 
	 */
	@Test
	public void testA() {

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposDocumentos tiposDocumentos = (TiposDocumentos) session.get(TiposDocumentos.class, tdocCodigo);

		assertNull("El tipo de documento ya existe", tiposDocumentos);

		tiposDocumentos = new TiposDocumentos();

		tiposDocumentos.setTdocCodigo(tdocCodigo);
		tiposDocumentos.setTdocNombre("Pasaporte");

		session.getTransaction().begin();
		session.save(tiposDocumentos);
		session.getTransaction().commit();

		session.close();
	}

	/*
	 * consulta del tipo de documento
	 * 
	 */
	@Test
	public void testB() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposDocumentos tiposDocumentos = (TiposDocumentos) session.get(TiposDocumentos.class, tdocCodigo);

		assertNotNull("El tipo de documento no existe", tiposDocumentos);
		log.info("codigo tipo documento: " + tiposDocumentos.getTdocCodigo());
		log.info("nombre tipo documento: " + tiposDocumentos.getTdocNombre());

		session.close();
	}

	/*
	 * modificacion del tipo documento
	 * 
	 */
	@Test
	public void testC() {

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposDocumentos tiposDocumentos = (TiposDocumentos) session.get(TiposDocumentos.class, tdocCodigo);

		assertNotNull("El tipo de documento no existe", tiposDocumentos);

		tiposDocumentos.setTdocNombre("pachanga");

		session.getTransaction().begin();
		session.update(tiposDocumentos);
		session.getTransaction().commit();

		session.close();
	}

	/*
	 * borrado del tipo documento
	 * 
	 */
	@Test
	public void testD() {

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		TiposDocumentos tiposDocumentos = (TiposDocumentos) session.get(TiposDocumentos.class, tdocCodigo);

		assertNotNull("El tipo de documento no existe", tiposDocumentos);

		session.getTransaction().begin();
		session.delete(tiposDocumentos);
		session.getTransaction().commit();

		session.close();
	}

}
