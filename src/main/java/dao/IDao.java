package dao;

import java.util.*;

public interface IDao<T,E> {
    Optional<T> get(E id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
