package org.uweb.uv.dao.idao;

import java.util.List;

public interface IDao<T> {

	public T connection(T conn);
	public T addObj(T p);
	public T update(T p);
	public List<T> findAll();
	public T delete(int id);
	public T findMc(String mc);
	public T findOne(int id);

}
