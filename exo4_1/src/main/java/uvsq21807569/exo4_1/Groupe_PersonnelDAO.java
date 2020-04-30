package uvsq21807569.exo4_1;

import java.io.Serializable;

public class Groupe_PersonnelDAO <T extends Serializable>	extends  OperationSerialiser<Groupe_Personnel> implements DAO<Groupe_Personnel> {

	@Override
	public Groupe_Personnel create(Groupe_Personnel obj) {
		// TODO Auto-generated method stub
		return creerfichier(obj, obj.getId());
	}

	@Override
	public Groupe_Personnel read(String id) {
		// TODO Auto-generated method stub
		return lirefichier(id);
	}

	@Override
	public Groupe_Personnel update(Groupe_Personnel obj) {
		// TODO Auto-generated method stub
		return misejourfichier(obj, obj.getId());
	}

	@Override
	public void delete(Groupe_Personnel obj) {
		suprimerfichier(obj.getId());
		
	}

}
