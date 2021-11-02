package main.modelConvert;

import main.entity.RateEntity;

public class RateConvertTo {

    private long idRate;
    private int minAge;
    private int maxAge;
    private String minTime;
    private String  maxTime;
    private double price;
    private int stopCheck;
    private int minCheck;
    private boolean weekdays;

    public static RateConvertTo toJson(RateEntity rateEntity){
        RateConvertTo rateConvertTo = new RateConvertTo();
        rateConvertTo.setIdRate(rateEntity.getIdRate());
        rateConvertTo.setMinAge(rateEntity.getMinAge());
        rateConvertTo.setMaxAge(rateEntity.getMaxAge());
        rateConvertTo.setMinTime(rateEntity.getMinTime().toString());
        rateConvertTo.setMaxTime(rateEntity.getMaxTime().toString());
        rateConvertTo.setPrice(rateEntity.getPrice());
        rateConvertTo.setStopCheck(rateEntity.getStopCheck());
        rateConvertTo.setMinCheck(rateEntity.getMinCheck());
        rateConvertTo.setWeekdays(rateEntity.isWeekdays());
        return rateConvertTo;
    }

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

    public String getMinTime() {
        return minTime;
    }

    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(String maxTime) {
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
