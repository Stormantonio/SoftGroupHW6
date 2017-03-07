package chernenko.agc;

import chernenko.agc.model.Car;
import chernenko.agc.model.Mechanic;
import chernenko.agc.model.ServiceStation;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Anton on 02.03.2017.
 */
public class CompleteDBTest {

    public static final Car CAR;
    public static final ServiceStation SERVICE_STATION;
    public static final Mechanic MECHANIC;

    public static final Car[] CARS;
    public static final ServiceStation[] SERVICE_STATIONS;
    public static final Mechanic[] MECHANICS;

    static {
        CARS = new Car[6];
        CARS[0] = new Car(1, "E_Class", "Mercedes-Benz", 12345, 30000, new Date(112, 0, 10));
        CARS[1] = new Car(2, "A6", "Audi", 5467, 3000, new Date(102, 11, 24));
        CARS[2] = new Car(3, "Giulietta", "Alfa Romeo", 54211, 15000, new Date(113, 3, 26));
        CARS[3] = new Car(4, "Sens", "Daewoo", 1212, 3500, new Date(107, 6, 7));
        CARS[4] = new Car(5, "X6", "BMW", 4532, 70000, new Date(116, 10, 12));
        CARS[5] = new Car(6, "Priora", "Lada", 32141, 4000, new Date(109, 9, 25));

//        CARS[0] = new Car(1, "E_Class", "Mercedes-Benz", 12345, 30000, LocalDate.of(2012, 1, 10));
//        CARS[1] = new Car(2, "A6", "Audi", 5467, 3000, LocalDate.of(2002, 12, 24));
//        CARS[2] = new Car(3, "Giulietta", "Alfa Romeo", 54211, 15000, LocalDate.of(2013, 4, 26));
//        CARS[3] = new Car(4, "Sens", "Daewoo", 1212, 3500, LocalDate.of(2007, 7, 7));
//        CARS[4] = new Car(5, "X6", "BMW", 4532, 70000, LocalDate.of(2016, 11, 12));
//        CARS[5] = new Car(6, "Priora", "Lada", 32141, 4000, LocalDate.of(109, 10, 25));

        SERVICE_STATIONS = new ServiceStation[3];
        SERVICE_STATIONS[0] = new ServiceStation(1, "Yatsenko, 4");
        SERVICE_STATIONS[1] = new ServiceStation(2, "Sakko, 112");
        SERVICE_STATIONS[2] = new ServiceStation(3, "Pylypa Orlyka, 36A");


        CARS[0].setServiceStations(new HashSet<>(Arrays.asList(SERVICE_STATIONS[0], SERVICE_STATIONS[1])));
        CARS[1].setServiceStations(new HashSet<>(Arrays.asList(new ServiceStation[]{SERVICE_STATIONS[0]})));
        CARS[2].setServiceStations(new HashSet<>(Arrays.asList(SERVICE_STATIONS[0], SERVICE_STATIONS[1], SERVICE_STATIONS[2])));
        CARS[3].setServiceStations(new HashSet<>(Arrays.asList(new ServiceStation[]{SERVICE_STATIONS[2]})));
        CARS[4].setServiceStations(new HashSet<>(Arrays.asList(SERVICE_STATIONS[1], SERVICE_STATIONS[2])));
        CARS[5].setServiceStations(new HashSet<>(Arrays.asList(new ServiceStation[]{SERVICE_STATIONS[0]})));

        SERVICE_STATIONS[0].setCars(new HashSet<>(Arrays.asList(CARS[0], CARS[1], CARS[2], CARS[5])));
        SERVICE_STATIONS[1].setCars(new HashSet<>(Arrays.asList(CARS[0], CARS[2], CARS[4])));
        SERVICE_STATIONS[2].setCars(new HashSet<>(Arrays.asList(CARS[2], CARS[3], CARS[4])));


        MECHANICS = new Mechanic[15];
        MECHANICS[0] = new Mechanic(1, "Ivan", "Petrov");
        MECHANICS[1] = new Mechanic(2, "Oleg", "Ivanov");
        MECHANICS[2] = new Mechanic(3, "Stepan", "Korol");
        MECHANICS[3] = new Mechanic(4, "Ihor", "Golov");
        MECHANICS[4] = new Mechanic(5, "Evgeniy", "Chaika");
        MECHANICS[5] = new Mechanic(6, "Anton", "Pogoreov");
        MECHANICS[6] = new Mechanic(7, "Ivan", "Golovach");
        MECHANICS[7] = new Mechanic(8, "Sergey", "Nemchinskiy");
        MECHANICS[8] = new Mechanic(9, "Yuri", "Tkach");
        MECHANICS[9] = new Mechanic(10, "Key", "Horstman");
        MECHANICS[10] = new Mechanic(11, "Yakov", "Fine");
        MECHANICS[11] = new Mechanic(12, "Herbert", "Schildt");
        MECHANICS[12] = new Mechanic(13, "Katty", "Sierra");
        MECHANICS[13] = new Mechanic(14, "Josh", "Bloch");
        MECHANICS[14] = new Mechanic(15, "Thomas", "Kormen");

        MECHANICS[0].setServiceStation(SERVICE_STATIONS[0]);
        MECHANICS[1].setServiceStation(SERVICE_STATIONS[2]);
        MECHANICS[2].setServiceStation(SERVICE_STATIONS[1]);
        MECHANICS[3].setServiceStation(SERVICE_STATIONS[2]);
        MECHANICS[4].setServiceStation(SERVICE_STATIONS[1]);
        MECHANICS[5].setServiceStation(SERVICE_STATIONS[0]);
        MECHANICS[6].setServiceStation(SERVICE_STATIONS[2]);
        MECHANICS[7].setServiceStation(SERVICE_STATIONS[1]);
        MECHANICS[8].setServiceStation(SERVICE_STATIONS[0]);
        MECHANICS[9].setServiceStation(SERVICE_STATIONS[2]);
        MECHANICS[10].setServiceStation(SERVICE_STATIONS[0]);
        MECHANICS[11].setServiceStation(SERVICE_STATIONS[1]);
        MECHANICS[12].setServiceStation(SERVICE_STATIONS[0]);
        MECHANICS[13].setServiceStation(SERVICE_STATIONS[0]);
        MECHANICS[14].setServiceStation(SERVICE_STATIONS[1]);

        SERVICE_STATIONS[0].setMechanics(new HashSet<>(Arrays.asList(MECHANICS[0], MECHANICS[5], MECHANICS[8], MECHANICS[10], MECHANICS[12], MECHANICS[13])));
        SERVICE_STATIONS[1].setMechanics(new HashSet<>(Arrays.asList(MECHANICS[2], MECHANICS[4], MECHANICS[7], MECHANICS[11], MECHANICS[14])));
        SERVICE_STATIONS[2].setMechanics(new HashSet<>(Arrays.asList(MECHANICS[1], MECHANICS[3], MECHANICS[6], MECHANICS[9])));


        CAR = new Car(7, "Test_model", "Test_make", 1000, 1000, new Date(111, 11, 30));
        CAR.setServiceStations(new HashSet<>(Arrays.asList(SERVICE_STATIONS[0], SERVICE_STATIONS[2])));

        MECHANIC = new Mechanic(16, "Test_name", "Test_surname");
        MECHANIC.setServiceStation(SERVICE_STATIONS[1]);

        SERVICE_STATION = new ServiceStation(4, "Test_address");
        SERVICE_STATION.setCars(new HashSet<>(Arrays.asList(CARS[1], CARS[3], CARS[5])));
        SERVICE_STATION.setMechanics(new HashSet<>(Arrays.asList(MECHANICS[2], MECHANICS[9], MECHANICS[13])));


    }
}
