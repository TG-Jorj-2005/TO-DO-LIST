package Dao;

public interface GenericDao<T> {
  T findById(int id);

  void add(T entity);

  void save(T entity);

  void update(T entity);

  void delete(T entity);
}
