package main.modelConvert;

import main.entity.ProceedsEntity;

public class ProceedsConvert {

    private long id;
    private String date;
    private double countMoney;
    private double cashMoney;
    private double cardMoney;

    public static ProceedsConvert fromJsonToEntity(ProceedsEntity proceedsEntity){
        ProceedsConvert proceedsConv = new ProceedsConvert();
        proceedsConv.setId(proceedsEntity.getId());
        proceedsConv.setDate(proceedsEntity.getDate().toString());
        proceedsConv.setCountMoney(proceedsEntity.getCountMoney());
        proceedsConv.setCashMoney(proceedsEntity.getCashMoney());
        proceedsConv.setCardMoney(proceedsEntity.getCardMoney());
        return proceedsConv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(double countMoney) {
        this.countMoney = countMoney;
    }

    public double getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(double cashMoney) {
        this.cashMoney = cashMoney;
    }

    public double getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(double cardMoney) {
        this.cardMoney = cardMoney;
    }
}
