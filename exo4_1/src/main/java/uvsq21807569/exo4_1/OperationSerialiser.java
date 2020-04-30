package uvsq21807569.exo4_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class OperationSerialiser  <T extends Serializable> {
	
	public T ecrirefichier(T obj, String nom) {
		try (ObjectOutputStream	ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nom)))) {
			ous.writeObject(obj);
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void suprimerfichier(String nom) {
		File file = new File(nom); 
		if(file.delete()) System.out.println("suppresion réalisée"); 
		else System.out.println("Suppression impossible");
	}

	private boolean exister(String nom) {
		File file = new File(nom); 
		return file.exists();
	
	}
	public T lirefichier(String nom) {

		try (ObjectInputStream ois = new ObjectInputStream(	new BufferedInputStream(new FileInputStream(nom)))) {
			T obj = (T) ois.readObject();
			return obj;

		} catch (ClassNotFoundException | IOException e) {
			e.getMessage();

			return null;

		}
	}
	
	public T creerfichier(T obj, String nom) {

		if (exister(nom)) {
		System.out.println("impossible de creer object");
					System.out.println("objet existe deja ");
					return null;
				}
				else {
					ecrirefichier(obj, nom );
					System.out.println("objet creer");
					return obj;
				}
			}
	public T misejourfichier(T obj, String nom) {
		if (!exister(nom)) {
			
			creerfichier(obj, nom);
			 
		}
			suprimerfichier(nom);
			ecrirefichier(obj, nom);
			System.out.println("object mis a jour avec succée");
			return obj;
		
	}
				
	}
