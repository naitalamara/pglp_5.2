package uvsq21807569.exo4_1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class iterator implements Iterator<Personneltype> {

	protected Groupe_Personnel racine ;
	protected ArrayDeque<Personneltype> collection ;
	
	
	
	public iterator(Groupe_Personnel racine,  ArrayDeque<Personneltype> collection) {
		super();
		this.racine = racine;
		this.collection = collection;
	}

	 
	
	public boolean hasNext() {
		
		return !collection.isEmpty();
	}

	
	public Personneltype next() {
		if(!hasNext()) {
			 throw new NoSuchElementException();
		}
		else {
     
			return collection.element(); 
        }

		

	}
	


}
