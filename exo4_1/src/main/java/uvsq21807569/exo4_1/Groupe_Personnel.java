package uvsq21807569.exo4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Groupe_Personnel extends Personneltype{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Personneltype> listpers ;
	private Integer id ;

		public Groupe_Personnel(){
			listpers=new ArrayList <Personneltype>();
			id=(int)( Math.random()*( 900 - 1 + 1 ) ) + 1;
		}

		
		public void addpersonnel(Personneltype a) {

		listpers.add(a);

	}

	

		public void removepersonnel(Personneltype a) throws  
		IllegalArgumentException{

			if(this.listpers.contains(a)) {

			this.listpers.remove(a);}

			else {throw new IllegalArgumentException("cette personne que vous essayer de suprimer n existe pa au sein du groupe");}

			}

	public List<Personneltype> retournergroupe(){

		return listpers;

	}

	

	public void affichage() {
		for (Personneltype  pers :listpers) {

			pers.affichage(); 

			}

		}

		
	
	

	public String getId() {
		return id.toString();
	}


	public boolean estgroupe() {
		return true;

	}
	
	
	}
	
	


