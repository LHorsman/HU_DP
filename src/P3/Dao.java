package P3;

import java.util.ArrayList;

public interface Dao<T> {
    public ArrayList<T> findAll();
    public T safe(T t);
    public T update(T t);
    public T delete(T t);
    public void closeConnection();
}
