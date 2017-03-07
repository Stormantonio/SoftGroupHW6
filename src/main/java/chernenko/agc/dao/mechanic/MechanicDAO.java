package chernenko.agc.dao.mechanic;

import chernenko.agc.model.Mechanic;

import java.sql.SQLException;

public interface MechanicDAO {

    void addMechanic(Mechanic mechanic) throws SQLException;

    void updateMechanic(Mechanic mechanic) throws SQLException;

    Mechanic getMechanicById(int id) throws SQLException;

    void deleteMechanic(int id) throws SQLException;
}
