package metier.implmetier;

import org.springframework.transaction.annotation.Transactional;

import dao.idao.IDaoPages;
import metier.imetier.IMetierPages;

@Transactional
public class MetierPagesImpl implements IMetierPages{
	private IDaoPages dao;

	public IDaoPages getDao() {
		return dao;
	}

	public void setDao(IDaoPages dao) {
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

	@Override
	public int insertPage(String idModule, String url, String libelle, String defaut, String etat, String surentete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifPage(String id, String idModule, String url, String libelle, String defaut, String etat,
			String surentete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean ordreExiste() {
		// TODO Auto-generated method stub
		return false;
	}

}
