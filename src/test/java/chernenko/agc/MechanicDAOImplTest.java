package chernenko.agc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import chernenko.agc.dao.mechanic.MechanicDAO;
import chernenko.agc.dao.mechanic.MechanicDAOImpl;
import chernenko.agc.model.Mechanic;

import java.sql.SQLException;

public class MechanicDAOImplTest {
    private MechanicDAO mechanicDAO = new MechanicDAOImpl();

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
    public void addMechanic() throws SQLException {
        mechanicDAO.addMechanic(CompleteDBTest.MECHANIC);
        Mechanic mechanic = mechanicDAO.getMechanicById(CompleteDBTest.MECHANICS.length + 1);
        Assert.assertEquals(CompleteDBTest.MECHANIC, mechanic);
        Assert.assertEquals(CompleteDBTest.MECHANIC.getServiceStation(), mechanic.getServiceStation());
    }

    @Test
    public void updateMechanic() throws SQLException {
        Mechanic mechanic = mechanicDAO.getMechanicById(1);
        mechanic.setName("update mechanic name");
        mechanic.setSurname("update mechanic surname");
        mechanicDAO.updateMechanic(mechanic);
        Assert.assertEquals(mechanic, mechanicDAO.getMechanicById(mechanic.getMechanicId()));
    }

    @Test
    public void getMechanicById() throws SQLException {
        for (int i = 0; i < CompleteDBTest.MECHANICS.length; i++) {
            Mechanic expected = CompleteDBTest.MECHANICS[i];
            Mechanic actual = mechanicDAO.getMechanicById(i + 1);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void deleteMechanic() throws SQLException {
        Assert.assertNotEquals(null, mechanicDAO.getMechanicById(1));
        mechanicDAO.deleteMechanic(1);
        Assert.assertEquals(null, mechanicDAO.getMechanicById(1));
    }
}
