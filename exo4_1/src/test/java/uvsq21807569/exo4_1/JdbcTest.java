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
	private Personnel a ,b ,c;
	Groupe_Personnel grp ,grp2; 
	@Before
	public void init() {
		b=null ;
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
		DerbyBd b= new DerbyBd();
		b.createTables();
	}

	
	@Test
	public void creatPersonnel() {
		DAO<Personnel> pers =AbstractDaoFactory.getFactory(DAOType.JDBC).getPersonnelDAO();
		
		b=pers.create(a);
		assertEquals(b.getNom(), a.getNom());
		assertEquals(b.getPrenom(), a.getPrenom());
		assertEquals(b.getFonction(), a.getFonction());
		assertEquals(b.getDatenaissance(),a.getDatenaissance());
		assertEquals(a.getNumerotelephone(),a.getNumerotelephone());
	
	}
	
}
