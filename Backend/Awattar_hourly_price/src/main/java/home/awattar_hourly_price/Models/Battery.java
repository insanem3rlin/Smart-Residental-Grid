package home.awattar_hourly_price.Models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public double chargingLevel;

    public double watt;
    public Timestamp time;

    public Battery() {}

    public Battery(double chargingLevel, double watt, Timestamp timestamp) {
        this.chargingLevel = chargingLevel;
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
