package metier.implmetier;

import org.springframework.transaction.annotation.Transactional;

import dao.idao.IDaoMatiere;
import metier.imetier.IMetierMatiere;
@Transactional
public class MetierMatiereImpl implements IMetierMatiere{
	private IDaoMatiere dao;

	public IDaoMatiere getDao() {
		return dao;
	}

	public void setDao(IDaoMatiere dao) {
		this.dao = dao;
	}

	@Override
	public Object addObj(Object p) {
		
		return dao.addObj(p);
	}

	@Override
	public Object update(Object p) {
		
		return dao.update(p);
	}

	@Override
	public Object findAll() {
		
		return dao.findAll();
	}

	@Override
	public Object delete(int id) {
		
		return dao.delete(id);
	}

	@Override
	public Object findMc(String mc) {
		
		return dao.findMc(mc);
	}

	@Override
	public Object findOne(int id) {
		
		return dao.findOne(id);
	}

	@Override
	public Object connection(Object conn) {
		
		return dao.connection(conn);
	}

}
