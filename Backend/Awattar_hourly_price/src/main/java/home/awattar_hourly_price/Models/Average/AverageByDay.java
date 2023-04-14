package home.awattar_hourly_price.Models.Average;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import home.awattar_hourly_price.JsonAdapters.TimestampAdapter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class AverageByDay {
    @JsonAdapter(TimestampAdapter.class)
    @SerializedName("start_timestamp")
    Timestamp day;

    double avg;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public AverageByDay() {
    }

    public AverageByDay(Timestamp day, double avg, Long id) {
        this.day = day;
        this.avg = avg;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getStartDate() {
        return day;
    }

    public void setStartDate(Timestamp startDate) {
        this.day = startDate;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
