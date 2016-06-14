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

import co.edu.usbcali.demo.modelo.TiposUsuarios;
import co.edu.usbcali.demo.modelo.Usuarios;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUsuarios {
	private static final Logger log = LoggerFactory.getLogger(TestCliente.class);
	private Long usuCedula = 1113L;

	/*
	 * creacion de usuario
	 */
	@Test
	public void testA() {
		String usuNombre = "Ana Carolina Correa";
		String usuLogin = "ACaroliG";
		String usuClave = "Azp001";
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Usuarios usuarios = (Usuarios) session.get(Usuarios.class, usuCedula);

		assertNull("El usuario ya existe", usuarios);
		
		
		usuarios = new Usuarios();
		
		usuarios.setUsuCedula(usuCedula);
		usuarios.setUsuNombre(usuNombre);
		usuarios.setUsuLogin(usuLogin);
		usuarios.setUsuClave(usuClave);
		
		TiposUsuarios tiposUsuarios = (TiposUsuarios)session.get(TiposUsuarios.class, 20L);
		assertNotNull("El tipo de usuario no existe",tiposUsuarios);
		
		usuarios.setTiposUsuarios(tiposUsuarios);
				
		session.getTransaction().begin();
		session.save(usuarios);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * consulta de usuario
	 */
	@Test
	public void testB() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Usuarios usuarios = (Usuarios) session.get(Usuarios.class, usuCedula);

		assertNotNull("El usuario no existe", usuarios);
		log.info("codigo de usuario:" + usuarios.getUsuCedula());
		log.info("nombre de usuario:" + usuarios.getUsuNombre());
		log.info("login de usuario:" + usuarios.getUsuLogin());
		log.info("clave de usuario:" + usuarios.getUsuClave());

		session.close();
	}
	
	/*
	 * modificacion de usuario
	 */
	@Test
	public void testC() {
		String usuNombre = "Paola Guztamante";
		String usuLogin = "Paog";
		String usuClave = "1234pao";
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Usuarios usuarios = (Usuarios) session.get(Usuarios.class, usuCedula);

		assertNotNull("El usuario no existe", usuarios);
				
		usuarios.setUsuNombre(usuNombre);
		usuarios.setUsuLogin(usuLogin);
		usuarios.setUsuClave(usuClave);
				
		session.getTransaction().begin();
		session.update(usuarios);
		session.getTransaction().commit();
		session.close();
	}
	
	
	/*
	 * borrado de usuario
	 */
	@Test
	public void testD() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
		Session session = sessionFactory.openSession();

		Usuarios usuarios = (Usuarios) session.get(Usuarios.class, usuCedula);

		assertNotNull("El usuario no existe",usuarios);
		
		session.getTransaction().begin();
		session.delete(usuarios);
		session.getTransaction().commit();
		
		session.close();
	}

}
