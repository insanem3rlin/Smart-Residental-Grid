package home.awattar_hourly_price.Models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public double watt;
    public Timestamp time;

    public Supplier() {}

    public Supplier(double watt, Timestamp timestamp) {
        this.watt = watt;
        this.time = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
