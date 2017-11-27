package co.edu.udea.microserviceclientregistration.microserviceudearegistrationclient;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String reservationName;
    private String email;

    @Override
    public String toString() {
        return "A cliente{"
                + "id:" + id
                + ", name='" + reservationName + '\''
                + '}';
    }

    public Cliente() {
    }

    public Cliente(String reservationName) {
        this.reservationName = reservationName;
    }
    public Cliente(String reservationName, String email) {
        this.reservationName = reservationName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return reservationName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
