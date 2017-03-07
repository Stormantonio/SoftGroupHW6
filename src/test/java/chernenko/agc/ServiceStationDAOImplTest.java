package chernenko.agc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import chernenko.agc.dao.serviceStation.ServiceStationDAO;
import chernenko.agc.dao.serviceStation.ServiceStationDAOImpl;
import chernenko.agc.model.ServiceStation;

import java.sql.SQLException;

public class ServiceStationDAOImplTest {
    private ServiceStationDAO stationDAO = new ServiceStationDAOImpl();

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/javaHW6";
    private static final String NAME = "postgres";
    private static final String PASS = "0000";

    @BeforeClass
    public static void initDb() {
        CreateDBTest.newTable(DRIVER, URL, NAME, PASS);
    }

    @Before
    public void populateDB() {
        CreateDBTest.completeTable(DRIVER, URL, NAME, PASS);
    }

    @Test
    public void addServiceStation() throws SQLException {
        stationDAO.addServiceStation(CompleteDBTest.SERVICE_STATION);
        ServiceStation serviceStation = stationDAO.getServiceStationById(CompleteDBTest.SERVICE_STATIONS.length + 1);
        Assert.assertEquals(CompleteDBTest.SERVICE_STATION, serviceStation);
    }

    @Test
    public void updateServiceStation() throws SQLException {
        ServiceStation ss = stationDAO.getServiceStationById(1);
        ss.setAddress("update serviceStation address");
        stationDAO.updateServiceStation(ss);
        Assert.assertEquals(ss, stationDAO.getServiceStationById(1));
    }

    @Test
    public void getServiceStationById() throws SQLException {
        for (int i = 0; i < CompleteDBTest.SERVICE_STATIONS.length; i++) {
            ServiceStation expected = CompleteDBTest.SERVICE_STATIONS[i];
            ServiceStation actual = stationDAO.getServiceStationById(i + 1);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void deleteServiceStationById() throws SQLException {
        stationDAO.deleteServiceStationById(1);
        Assert.assertEquals(null, stationDAO.getServiceStationById(1));
    }
}
