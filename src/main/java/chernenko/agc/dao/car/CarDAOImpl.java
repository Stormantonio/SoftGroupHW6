package chernenko.agc.dao.car;

import chernenko.agc.dao.DAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import chernenko.agc.model.Car;
import chernenko.agc.util.HibernateUtil;

import javax.persistence.EntityNotFoundException;

public class CarDAOImpl extends DAO implements CarDAO {
    public void addCar(Car car) {
        add(car);
    }

    public void updateCar(Car car) {
        update(car);
    }

    public Car getCarById(int id) {
        Session session = null;
        Car car = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            car = session.get(Car.class, id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    e.printStackTrace();
                }
            }
        }
        return car;
    }

    public void deleteCar(int id) {
        Session session = null;
        int count = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Car car = session.getReference(Car.class, id);
            session.delete(car);
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
