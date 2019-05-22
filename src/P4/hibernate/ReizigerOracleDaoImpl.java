package P4.hibernate;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
    @Override
    public List<Reiziger> findAll() throws SQLException, ParseException {
        Session s = this.getConnection();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Reiziger> q = cb.createQuery(Reiziger.class);
        Root<Reiziger> c = q.from(Reiziger.class);

        q.select(c);

        TypedQuery<Reiziger> query = s.createQuery(q);

        List<Reiziger> results = query.getResultList();

        return results;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        return null;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        return null;
    }

    @Override
    public Reiziger delete(Reiziger reiziger) {
        return null;
    }
}
