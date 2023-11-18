package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.Iautoable;
import model.TblAuto;

public class ClassCrudAuto implements Iautoable {

	@Override
	public void RegistrarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
				//de persistencia...
				EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenLpIITUNO");
				//gestionar las entidades
				EntityManager emanager=em.createEntityManager();
				//iniciamos la transaccion
				emanager.getTransaction().begin();
				//registramos
				emanager.persist(tblauto);
				//emitimos mensaje
				System.out.println("auto registrado en BD");
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
		
	}  //fin del metodo registrar

	@Override
	public void ActualizarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenLpIITUNO");
		//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//actualizar
		emanager.merge(tblauto);
		//emitimos mensaje
		System.out.println("auto actualizado en BD");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}  //fin del metodo actuaizar

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
				//de persistencia...
				EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenLpIITUNO");
				//gestionar las entidades
				EntityManager emanager=em.createEntityManager();
				//iniciamos la transaccion
				emanager.getTransaction().begin();
				//recuperamos el codigo a eliminar
				TblAuto elim=emanager.merge(tblauto);
				//eliminamos
				emanager.remove(elim);
				//emitimos mensaje
				System.out.println("auto eliminado en BD");
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
		
	}  //fin del metodo eliminar

	@Override
	public TblAuto BuscarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenLpIITUNO");
		//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblAuto buscar=emanager.find(TblAuto.class,tblauto.getIdauto());
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		return buscar;
	}  //fin del metodo buscar autor...

	@Override
	public List<TblAuto> Listado() {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenLpIITUNO");
		//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		List<TblAuto> listado=emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		return listado;
	}  //fin del metodo listado..

}  //fin de la clase...
