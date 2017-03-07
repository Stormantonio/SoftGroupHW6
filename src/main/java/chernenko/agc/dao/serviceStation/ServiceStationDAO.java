package chernenko.agc.dao.serviceStation;

import chernenko.agc.model.ServiceStation;

import java.sql.SQLException;

public interface ServiceStationDAO {
    void addServiceStation(ServiceStation serviceStation) throws SQLException;

    void updateServiceStation(ServiceStation serviceStation) throws SQLException;

    ServiceStation getServiceStationById(int id) throws SQLException;

    void deleteServiceStationById(int id) throws SQLException;
}
