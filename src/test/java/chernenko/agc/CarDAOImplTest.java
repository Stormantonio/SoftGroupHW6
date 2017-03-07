package chernenko.agc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import chernenko.agc.dao.car.CarDAO;
import chernenko.agc.dao.car.CarDAOImpl;
import chernenko.agc.model.Car;

import java.sql.SQLException;

public class CarDAOImplTest {
    private CarDAO carDAO = new CarDAOImpl();

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/javaHW6";
    private static final String NAME = "postgres";
    private static final String PASS = "0000";

    @BeforeClass
    public static void createDB() {
        CreateDBTest.newTable(DRIVER, URL, NAME, PASS);
    }

    @Before
    public void completeDB() {
        CreateDBTest.completeTable(DRIVER, URL, NAME, PASS);
    }


    @Test
    public void addCar() throws SQLException {
        carDAO.addCar(CompleteDBTest.CAR);
        Car car = carDAO.getCarById(CompleteDBTest.CARS.length + 1);
        Assert.assertEquals(CompleteDBTest.CAR, car);
        Assert.assertEquals(CompleteDBTest.CAR.getServiceStations(), car.getServiceStations());
    }

    @Test
    public void updateCar() throws SQLException {
        Car car = carDAO.getCarById(1);
        car.setModel("update car model");
        car.setMake("update car make");
        car.setPrice(12345);
        carDAO.updateCar(car);
        Assert.assertEquals(car, carDAO.getCarById(1));
    }

    @Test
    public void getCarById() throws SQLException {
        for (int i = 0; i < CompleteDBTest.CARS.length; i++) {
            Car expected = CompleteDBTest.CARS[i];
            Car actual = carDAO.getCarById(i + 1);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(expected.getServiceStations(), actual.getServiceStations());
        }
    }

    @Test
    public void deleteCar() throws SQLException {
        Assert.assertNotEquals(null, carDAO.getCarById(1));
        carDAO.deleteCar(1);
        Assert.assertEquals(null, carDAO.getCarById(1));
    }
}
