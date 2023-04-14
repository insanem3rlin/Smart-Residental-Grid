package home.awattar_hourly_price.Models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import home.awattar_hourly_price.JsonAdapters.TimestampAdapter;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Datapoint {

    @JsonAdapter(TimestampAdapter.class)
    @SerializedName("start_timestamp")
    @Column(unique=true)
    Timestamp startDate;

    @JsonAdapter(TimestampAdapter.class)
    @SerializedName("end_timestamp")
    @Column(unique=true)
    Timestamp endDate;

    @SerializedName("marketprice")
    double value;

    @SerializedName("unit")
    String unity;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    public Datapoint(Timestamp startDate, Timestamp endDate, double value, String unity, Long id) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.value = value;
        this.unity = unity;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Datapoint{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", value=" + value +
                ", unity='" + unity + '\'' +
                ", id=" + id +
                '}';
    }

    public Datapoint() {
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
