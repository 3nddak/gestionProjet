package metier.implmetier;

import org.springframework.transaction.annotation.Transactional;

import dao.idao.IDaoProfil;
import metier.imetier.IMetierProfil;

@Transactional
public class MetierProfilImpl implements IMetierProfil{
	private IDaoProfil dao;

	public IDaoProfil getDao() {
		return dao;
	}

	public void setDao(IDaoProfil dao) {
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
	public void ajouterPageProfil(int idPage, int idProfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retiterPageProfil(int idPage, int idProfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean utilProfil(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
