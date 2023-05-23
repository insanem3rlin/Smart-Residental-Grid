package home.awattar_hourly_price.Models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import home.awattar_hourly_price.JsonAdapters.TimestampAdapter;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class PV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAdapter(TimestampAdapter.class)
    @SerializedName("timestamp")
    @Column(unique = true)
    Timestamp timestamp;

    double watt;

    public PV() {
    }

    public PV(Timestamp timestamp, double watt) {
        this.timestamp = timestamp;
        this.watt = watt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getWatt() {
        return watt;
    }

    public void setWatt(double watt) {
        this.watt = watt;
    }
}
