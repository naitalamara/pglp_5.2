package uvsq21807569.exo4_1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class DAOTest {
	private Personnel a ,b ,c;
	Groupe_Personnel grp ,grp2; 
	@Before
	public void init() {
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
	
	

	@Test
	public void test() {
		DAO<Personnel> per =DAOFactory.getPersonneDAO();
		per.delete(a);
		b=per.create(a);
		assertEquals(b.getNom(), a.getNom());
		assertEquals(b.getPrenom(), a.getPrenom());
		assertEquals(b.getFonction(), a.getFonction());
		assertEquals(b.getDatenaissance(),a.getDatenaissance());
		assertEquals(a.getNumerotelephone(),a.getNumerotelephone());
		
		System.out.println("on va modifier b ");
		b=per.update(c);
		 assertFalse(b.getNom()==a.getNom());
		assertEquals(b.getNom(), c.getNom());
		assertEquals(b.getPrenom(), c.getPrenom());
		assertEquals(b.getFonction(), c.getFonction());
		assertEquals(b.getDatenaissance(),c.getDatenaissance());
		assertEquals(b.getNumerotelephone(),c.getNumerotelephone());
		}

	
	
	
	@Test
	public void test2_avec_read() {
		DAO<Personnel> pers =DAOFactory.getPersonneDAO();
		pers.delete(a);
		b=pers.create(a);
		c=pers.read("chek");
		
		assertEquals(b.getNom(), c.getNom());
		assertEquals(b.getPrenom(), c.getPrenom());
		assertEquals(b.getFonction(), c.getFonction());
		assertEquals(b.getDatenaissance(),c.getDatenaissance());
		}
	
	@Test

	public void test_groupe() {
		DAO<Groupe_Personnel>perss =DAOFactory.getGroupeDAO();
		grp2=perss.create(grp);
		 assertEquals(2, grp2.retournergroupe().size());
		
		 
		 

	}
}
