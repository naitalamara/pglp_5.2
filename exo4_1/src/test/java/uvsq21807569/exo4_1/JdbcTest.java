package uvsq21807569.exo4_1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import Liste_exception.ExisteException;

import uvsq21807569.exo4_1.AbstractDaoFactory.DAOType;

public class JdbcTest {

	private  PersonnelDAOjdbc jdbc ;
	private Personnel a ,b ,c,d;
	Groupe_Personnel grp ,grp2; 
	@Before
	public void init() {
		b=null ;
		d=null ;
	  a=new Personnel
		.builder("chek", "sabrina", "directrice")
		.naissance(LocalDate.parse("1996-06-15" , DateTimeFormatter.ISO_DATE))
		.numerotelph(new NumeroTelephone("mobile","0700"))
		.numerotelph(new NumeroTelephone("fixe","0600"))
		.build();
	 
	  c=new Personnel
				.builder("walli", "nait", "manager")
				.naissance(LocalDate.parse("1999-05-10" , DateTimeFormatter.ISO_DATE))
				.numerotelph(new NumeroTelephone("mobile","0900"))
				.numerotelph(new NumeroTelephone("fixe","0550"))
				.build();
	grp = new Groupe_Personnel();
	grp2 = new Groupe_Personnel(); // groupe vide
	
	grp.addpersonnel(a);
	grp.addpersonnel(c);
	
	}
	
	
	
	
	
	@Test(expected = ExisteException.class) 
	public void test() throws ExisteException{
		System.out.println(" *********Création de la BD *********************");
		DerbyBd b= new DerbyBd();
		b.createTables();
		
	}

	/*
	@Test
	public void creatPersonnel() {
		DAO<Personnel> pers =AbstractDaoFactory.getFactory(DAOType.JDBC).getPersonnelDAO();
		System.out.println(" *********tester la creation de personne ************");
		b=pers.create(a);
		assertEquals(b.getNom(), a.getNom());
		assertEquals(b.getPrenom(), a.getPrenom());
		assertEquals(b.getFonction(), a.getFonction());
		assertEquals(b.getDatenaissance(),a.getDatenaissance());
		assertEquals(a.getNumerotelephone(),a.getNumerotelephone());
		}
	*/
	/*
	@Test
	public void personnel_read() {
		DAO<Personnel> perss =AbstractDaoFactory.getFactory(DAOType.JDBC).getPersonnelDAO();
		System.out.println(" *********tester read personnel  ************");
		d=perss.read("oiseau");
		
		b=perss.create(a);
		d=perss.read("chek");
		assertEquals(b.getNom(), d.getNom());
		assertEquals(b.getPrenom(), d.getPrenom());
		assertEquals(b.getFonction(), d.getFonction());
		}
	*/
	@Test
	public void personnel_delete() {
		DAO<Personnel> pe =AbstractDaoFactory.getFactory(DAOType.JDBC).getPersonnelDAO();
		System.out.println(" *********tester DELETE personnel  ************");
		b=pe.create(c);
		d=pe.read("walli");
		pe.delete(c);
		d=pe.read("walli");
		
		pe.delete(c);
	}
}
