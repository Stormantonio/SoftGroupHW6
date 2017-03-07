package chernenko.agc.dao.serviceStation;

import chernenko.agc.dao.DAO;
import chernenko.agc.model.ServiceStation;
import chernenko.agc.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.EntityNotFoundException;

public class ServiceStationDAOImpl extends DAO implements ServiceStationDAO {

    public void addServiceStation(ServiceStation serviceStation) {
        add(serviceStation);
    }

    public void updateServiceStation(ServiceStation serviceStation) {
        update(serviceStation);
    }

    public ServiceStation getServiceStationById(int id) {
        Session session = null;
        ServiceStation ss = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ss = session.get(ServiceStation.class, id);
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
        return ss;
    }

    public void deleteServiceStationById(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ServiceStation serviceStation = session.getReference(ServiceStation.class, id);
            session.delete(serviceStation);
            session.getTransaction().commit();
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
//            return false;
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
//        return true;
    }
}
