package metier.imetier;

public interface IMetier<T> {
	
	public T addObj(T p);
	public T update(T p);
	public T findAll();
	public T delete(int id);
	public T findMc(String mc);
	public T findOne(int id);
	public T connection(T conn);

}
