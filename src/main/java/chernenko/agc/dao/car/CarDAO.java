package chernenko.agc.dao.car;

import chernenko.agc.model.Car;

import java.sql.SQLException;

public interface CarDAO {

    void addCar(Car car) throws SQLException;

    void updateCar(Car car) throws SQLException;

    Car getCarById(int id) throws SQLException;

    void deleteCar(int id) throws SQLException;
}
