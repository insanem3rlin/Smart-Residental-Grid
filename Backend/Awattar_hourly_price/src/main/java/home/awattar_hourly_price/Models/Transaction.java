package home.awattar_hourly_price.Models;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public boolean isBuy;

    public Timestamp startTime;

    public Timestamp endTime;

    public String fillLevel;
    public Transaction(String fillLevel, String startTime, String endTime, boolean isBuy) {
        this.fillLevel = fillLevel;
        this.startTime = Timestamp.valueOf(startTime);
        this.endTime = Timestamp.valueOf(endTime);
        this.isBuy = isBuy;
    }
    public Transaction(){

    }

}