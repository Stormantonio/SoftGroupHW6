package chernenko.agc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "make", nullable = false)
    private String make;
    @Column(name = "id_engine", nullable = false)
    private int engineId;
    @Column(name = "price")
    private int price;
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "car_service_stations", joinColumns = {@JoinColumn(name = "car_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "service_stations_id", nullable = false)})
    private Set<ServiceStation> serviceStations = new HashSet<>();

    public Car() {
    }

    public Car(int carId, String model, String make, int engineId, int price, Date date) {
        this.carId = carId;
        this.model = model;
        this.make = make;
        this.engineId = engineId;
        this.price = price;
        this.date = date;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<ServiceStation> getServiceStations() {
        return serviceStations;
    }

    public void setServiceStations(Set<ServiceStation> serviceStations) {
        this.serviceStations = serviceStations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (getCarId() != car.getCarId()) return false;
        if (getEngineId() != car.getEngineId()) return false;
        if (getPrice() != car.getPrice()) return false;
        if (getModel() != null ? !getModel().equals(car.getModel()) : car.getModel() != null) return false;
        if (getMake() != null ? !getMake().equals(car.getMake()) : car.getMake() != null) return false;
        return getDate() != null ? getDate().equals(car.getDate()) : car.getDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getCarId();
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getMake() != null ? getMake().hashCode() : 0);
        result = 31 * result + getEngineId();
//        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", engineId=" + engineId +
//                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
