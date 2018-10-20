package metier.implmetier;

import org.springframework.transaction.annotation.Transactional;

import dao.idao.IDaoServicesIUV;
import metier.imetier.IMetierServiceIUV;

@Transactional
public class MetierServicelUVImpl implements IMetierServiceIUV{
	private IDaoServicesIUV dao;
	
	public IDaoServicesIUV getDao() {
		return dao;
	}

	public void setDao(IDaoServicesIUV dao) {
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
		// TODO Auto-generated method stub
		return null;
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
