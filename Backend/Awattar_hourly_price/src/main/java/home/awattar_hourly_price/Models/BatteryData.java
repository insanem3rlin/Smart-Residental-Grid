package home.awattar_hourly_price.Models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class BatteryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long chargingLevel;
    public Timestamp time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
