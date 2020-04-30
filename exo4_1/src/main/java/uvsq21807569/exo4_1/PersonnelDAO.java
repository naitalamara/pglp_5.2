package uvsq21807569.exo4_1;

import java.io.Serializable;

public class PersonnelDAO <T extends Serializable>	extends  OperationSerialiser<Personnel> implements DAO<Personnel> {

	@Override
	public Personnel create(Personnel obj) {
		// TODO Auto-generated method stub
		return creerfichier(obj, obj.getNom());
	}

	@Override
	public Personnel read(String id) {
		// TODO Auto-generated method stub
		return lirefichier(id);
	}

	@Override
	public Personnel update(Personnel obj) {
		// TODO Auto-generated method stub
		return misejourfichier(obj, obj.getNom());
	}

	@Override
	public void delete(Personnel obj) {
		// TODO Auto-generated method stub
		suprimerfichier(obj.getNom());
	}

}
