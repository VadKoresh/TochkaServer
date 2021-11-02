package main.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rate")
    private long idRate;
    @Column(name = "min_age")
    private int minAge;
    @Column(name = "max_age")
    private int maxAge;
    @Column(name = "min_time")
    private LocalDateTime minTime;
    @Column(name = "max_time")
    private LocalDateTime maxTime;
    private double price;
    @Column(name = "stop_check")
    private int stopCheck;
    @Column(name = "min_check")
    private int minCheck;
    private boolean weekdays;

    public long getIdRate() {
        return idRate;
    }

    public void setIdRate(long idRate) {
        this.idRate = idRate;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public LocalDateTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalDateTime minTime) {
        this.minTime = minTime;
    }

    public LocalDateTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalDateTime maxTime) {
        this.maxTime = maxTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStopCheck() {
        return stopCheck;
    }

    public void setStopCheck(int stopCheck) {
        this.stopCheck = stopCheck;
    }

    public int getMinCheck() {
        return minCheck;
    }

    public void setMinCheck(int minCheck) {
        this.minCheck = minCheck;
    }

    public boolean isWeekdays() {
        return weekdays;
    }

    public void setWeekdays(boolean weekdays) {
        this.weekdays = weekdays;
    }
}
