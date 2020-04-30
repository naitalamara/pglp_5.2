package uvsq21807569.exo4_1;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class SerialisationTest {
	private Personnel a;
	Groupe_Personnel grp; 

	@Before
	public void init() {
	 a=new Personnel
	.builder("chek", "sabrina", "directrice")
	.naissance(LocalDate.parse("1996-06-15" , DateTimeFormatter.ISO_DATE))
	.numerotelph(new NumeroTelephone("mobile","0700"))
	.numerotelph(new NumeroTelephone("fixe","0600"))
	.build();
	 
	grp = new Groupe_Personnel();
	grp.addpersonnel(a);

			
	}
	
	@Test
	public void test() {
		Personnel c =null ;
		
		
		try(FileOutputStream fo= new FileOutputStream("student.sr");
				ObjectOutputStream obj= new ObjectOutputStream(fo)) {
				obj.writeObject(a);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
	FileInputStream fi=new FileInputStream("student.sr");
	ObjectInputStream obj=new ObjectInputStream(fi);
	c=(Personnel)obj.readObject();
	
	
	
	
		} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
		assertEquals(c.getNom(), a.getNom());
		assertEquals(c.getPrenom(), a.getPrenom());
		assertEquals(c.getFonction(), a.getFonction());
		assertEquals(c.getDatenaissance(),a.getDatenaissance());
		a.getNumerotelephone().equals(c.getNumerotelephone());
		}
	

	@Test()

	public void testSerializationGroupe() {

		Groupe_Personnel d = null ;
	
		try(FileOutputStream fo= new FileOutputStream("st.sr");
		ObjectOutputStream obj= new ObjectOutputStream(fo)) {
		obj.writeObject(grp);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}	

	try {
	FileInputStream fi=new FileInputStream("st.sr");
	ObjectInputStream obj=new ObjectInputStream(fi);
	d=(Groupe_Personnel)obj.readObject();




	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertEquals(grp.retournergroupe().size(), d.retournergroupe().size());

	

	



}

}

