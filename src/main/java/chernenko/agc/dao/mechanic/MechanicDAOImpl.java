package chernenko.agc.dao.mechanic;

import chernenko.agc.dao.DAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import chernenko.agc.model.Mechanic;
import chernenko.agc.util.HibernateUtil;

import javax.persistence.EntityNotFoundException;

public class MechanicDAOImpl extends DAO implements MechanicDAO {

    public void addMechanic(Mechanic mechanic) {
        add(mechanic);
    }

    public void updateMechanic(Mechanic mechanic) {
        update(mechanic);
    }

    public Mechanic getMechanicById(int id) {
        Session session = null;
        Mechanic mechanic = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            mechanic = session.get(Mechanic.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    e.printStackTrace();
                }
            }
        }
        return mechanic;
    }

    public void deleteMechanic(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Mechanic mechanic = session.getReference(Mechanic.class, id);
            session.delete(mechanic);
            session.getTransaction().commit();
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
