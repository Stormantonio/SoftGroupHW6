package chernenko.agc.model;

import org.hibernate.proxy.HibernateProxyHelper;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service_stations")
public class ServiceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_stations_id")
    private int serviceStationsId;
    @Column(name = "address", nullable = false)
    private String address;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "car_service_stations", inverseJoinColumns = {@JoinColumn(name = "car_id", nullable = false)},
            joinColumns = {@JoinColumn(name = "service_stations_id", nullable = false)})
    private Set<Car> cars = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceStation", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<Mechanic> mechanics = new HashSet<>();

    public ServiceStation() {
    }

    public ServiceStation(int serviceStationsId, String address) {
        this.serviceStationsId = serviceStationsId;
        this.address = address;
    }

    public int getServiceStationsId() {
        return serviceStationsId;
    }

    public void setServiceStationsId(int serviceStationsId) {
        this.serviceStationsId = serviceStationsId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(Set<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != HibernateProxyHelper.getClassWithoutInitializingProxy(o)) return false;

        ServiceStation that = (ServiceStation) o;

        if (getServiceStationsId() != that.getServiceStationsId()) return false;
        return getAddress() != null ? getAddress().equals(that.getAddress()) : that.getAddress() == null;

    }

    @Override
    public int hashCode() {
        int result = getServiceStationsId();
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServiceStation{" +
                "serviceStationsId=" + serviceStationsId +
                ", address='" + address + '\'' +
                '}';
    }
}
