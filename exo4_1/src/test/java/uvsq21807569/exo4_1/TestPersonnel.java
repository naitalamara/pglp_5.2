package uvsq21807569.exo4_1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestPersonnel {

	private Personnel a,b; ;
	@Before
	public void init() {
	 a=new Personnel
	.builder("chek", "sabrina", "directrice")
	.naissance(LocalDate.parse("1996-06-15" , DateTimeFormatter.ISO_DATE))
	.numerotelph(new NumeroTelephone("mobile","0700"))
	.numerotelph(new NumeroTelephone("fixe","0600"))
	.build();
	 
	 b=new Personnel
				.builder("cheklat", "sabrina", "directrice")
				.naissance(LocalDate.parse("1996-06-15" , DateTimeFormatter.ISO_DATE))
				.numerotelph(new NumeroTelephone("mobile","0700"))
				.numerotelph(new NumeroTelephone("fixe","0600"))
				.build();
	 
	 
	}
	@Test
	public void test() {
	
		
		assertEquals(a.getNom(), "chek");
		assertEquals(a.getPrenom(), "sabrina");
		assertEquals(a.getFonction(), "directrice");
		assertEquals(a.getDatenaissance(),LocalDate.parse("1996-06-15", DateTimeFormatter.ISO_DATE));
		
		


	
	a.getNumerotelephone().equals(b.getNumerotelephone());  // je ne sais pas comment faire un autre test sur numero teleph??
	

	
	
	

	

}
}
