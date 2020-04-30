package uvsq21807569.exo4_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class Application  
{
    public static void main( String[] args )
    {
    	
    	Personnel a=new Personnel
				.builder("chiko", "sab", "directrice")
				.naissance(LocalDate.parse("1996-06-15" , DateTimeFormatter.ISO_DATE))
				.numerotelph(new NumeroTelephone("mobile","0756143267"))
				.numerotelph(new NumeroTelephone("fixe","0647143267"))
				.build();
    	
    	Personnel b=new Personnel
				.builder("wall", "nait", "manager")
				.naissance(LocalDate.parse("1995-07-02" , DateTimeFormatter.ISO_DATE))
				.numerotelph(new NumeroTelephone("mobile","0753233267"))
				.numerotelph(new NumeroTelephone("fixe","0747143267"))
				.build();
    	
    	Personnel c=new Personnel
				.builder("samis", "nicolas", "employe")
				.naissance(LocalDate.parse("1986-06-15" , DateTimeFormatter.ISO_DATE))
				.numerotelph(new NumeroTelephone("mobile","0756143267"))
				.numerotelph(new NumeroTelephone("fixe","0647143267"))
				.build();
    	
    	
    
    	
    	 Groupe_Personnel grp = new Groupe_Personnel();
    	 Groupe_Personnel grp2 = new Groupe_Personnel();
    	 
    	 grp2.addpersonnel(c);
    	
    	 grp.addpersonnel(a);
    	
    	 grp.addpersonnel(b);
    	// grp.affichage();
    	//System.out.println("supprimer la personne b");
    	// grp.removepersonnel(b);
    	// grp.affichage();
    	// grp.removepersonnel(a);
    	
    	 grp.addpersonnel(grp2);
    	 grp.affichage();
       
    		   
    }

}
