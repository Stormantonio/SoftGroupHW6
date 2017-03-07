package chernenko.agc.model;

import javax.persistence.*;

@Entity
@Table(name = "mechanic")
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mechanic_id")
    private int mechanicId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "service_stations_id")
    private ServiceStation serviceStation;

    public Mechanic() {
    }

    public Mechanic(int mechanicId, String name, String surname) {
        this.mechanicId = mechanicId;
        this.name = name;
        this.surname = surname;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ServiceStation getServiceStation() {
        return serviceStation;
    }

    public void setServiceStation(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mechanic mechanic = (Mechanic) o;

        if (getMechanicId() != mechanic.getMechanicId()) return false;
        if (getName() != null ? !getName().equals(mechanic.getName()) : mechanic.getName() != null)
            return false;
        if (getSurname() != null ? !getSurname().equals(mechanic.getSurname()) : mechanic.getSurname() != null)
            return false;
        return getServiceStation() != null ? getServiceStation().equals(mechanic.getServiceStation()) : mechanic.getServiceStation() == null;

    }

    @Override
    public int hashCode() {
        int result = getMechanicId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getServiceStation() != null ? getServiceStation().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "mechanicId=" + mechanicId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", serviceStation=" + serviceStation +
                '}';
    }
}
