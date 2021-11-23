package pac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
				
		//Creamos la conexión a partir del fichero de configuración hibernate.cfg.xml:
		Configuration cfg=new Configuration().configure();
		SessionFactory sessionFactory=cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session=sessionFactory.openSession();
		
		//Insertando datos usando transaciones:
		Transaction tx=session.beginTransaction();		
		
		//Inserción de datos de los modulos:
		Modulo modulo1=insertModulo(session,"Programacion B","M03B");
		Modulo modulo2=insertModulo(session,"Acceso a Datos","M06");
		Modulo modulo3=insertModulo(session,"Desarrollo de aplicaciones moviles","M08");
		Modulo modulo4=insertModulo(session,"Servicios y procesos","M09");				
		
		//Insercioón de datos de los profesores:		
		insertProfesor(session,"Alvaro","Hombre");
				
		//Creamos el primer alumno y realizamos el insert en la bbdd con el método insertAlumno:
		Alumno a=new Alumno("Juan","Espaniola",26,"Hombre");
		a.getModulos().add(modulo1);
		a.getModulos().add(modulo2);
		a.getModulos().add(modulo3);
		a.getModulos().add(modulo4);
		insertAlumno(session,a);
		
		//Creamos el segundo alumno y realizamos el insert en la bbdd con el método insertAlumno:
		Alumno b=new Alumno("Pedro","Andorrana",21,"Hombre");
		b.getModulos().add(modulo1);
		b.getModulos().add(modulo2);
		b.getModulos().add(modulo4);
		insertAlumno(session,b);
		
		//Creamos el tercer alumno y realizamos el insert en la bbdd con el método insertAlumno:
		Alumno c=new Alumno("Marta","Espaniola",19,"Mujer");
		c.getModulos().add(modulo3);
		c.getModulos().add(modulo4);
		insertAlumno(session,c);
				
		//Creamos el cuarto alumno y realizamos el insert en la bbdd con el método insertAlumno:
		Alumno d=new Alumno("Carla","Francesa",35,"Mujer");
		d.getModulos().add(modulo2);
		d.getModulos().add(modulo3);
		d.getModulos().add(modulo4);
		insertAlumno(session,d);
		
		
		//Hacemos el commit y guardamos los registros de las tablas:
		tx.commit();
		
		
		//Cerramos session y sessionFactory
		session.close();
		sessionFactory.close();

	}
	
	//En este método recibimos como parametro la session, un nombre y el codigo del modulo para instancirlo y guardarlo con el método save.
	//Luego devolvemos el objeto creado de tipo Modulo para poder usarlo en el main para añadirlo a los alumnos.	
	private static Modulo insertModulo(Session session,String nombre,String codigo) {
		Modulo modulo=new Modulo(nombre,codigo);		
		session.save(modulo);
		System.out.println("Insert into modulo, nombre: "+modulo.getNombre()+", codigo: "+modulo.getCodigo());
		return modulo;
	}
	
	//En este método, recibimos como parametro la session, un nombre y el sexo del profesor para instanciar el objeto y guardarlo.
	private static void insertProfesor(Session session,String nombre,String sexo) {
		Profesor profesor=new Profesor(nombre,sexo);		
		session.save(profesor);
		System.out.println("Insert into profesor, nombre: "+profesor.getNombre()+", sexo: "+profesor.getSexo());
	}
	
	//En este método, recibimos un objeto de tipo Alumno y la session. Guardamos el objeto recibido con el metodo save.
	private static void insertAlumno(Session session,Alumno alumno) {		
		session.save(alumno);
		System.out.println("Insert into alumno, nombre: "+alumno.getNombre()+", nacionalidad: "+alumno.getNacionalidad()+", edad: "+alumno.getEdad()+", sexo: "+alumno.getSexo()+", modulos: "+alumno.getModulos().size());
	}
	
	

}
