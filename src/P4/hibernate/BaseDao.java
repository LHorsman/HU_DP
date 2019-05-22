package P4.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface BaseDao<T> {
    List<T> findAll()  throws SQLException, ParseException;
    T save(T t);
    T update(T t);
    T delete(T t);
}
