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

    public String amount;
    public Transaction(String maxLevel, String amount, String startTime, String endTime, boolean isBuy) {
        this.amount = amount;
        this.fillLevel = maxLevel;
        this.startTime = Timestamp.valueOf(startTime);
        this.endTime = Timestamp.valueOf(endTime);
        this.isBuy = isBuy;
    }
    public Transaction(){

    }

}