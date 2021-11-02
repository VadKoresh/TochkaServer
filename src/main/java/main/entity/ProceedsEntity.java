package main.entity;

import main.modelConvert.ProceedsConvert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "proceeds")
public class ProceedsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceed")
    private long id;
    private LocalDate date;
    @Column(name = "count_money")
    private double countMoney;
    @Column(name = "cash_money")
    private double cashMoney;
    @Column(name = "card_money")
    private double cardMoney;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public static ProceedsEntity fromJsonToEntity(ProceedsConvert proceedsConvert){
        ProceedsEntity proceedsEntity = new ProceedsEntity();
        proceedsEntity.setId(proceedsConvert.getId());
        proceedsEntity.setDate(LocalDate.parse(proceedsConvert.getDate()));
        proceedsEntity.setCountMoney(proceedsConvert.getCountMoney());
        proceedsEntity.setCashMoney(proceedsConvert.getCashMoney());
        proceedsEntity.setCardMoney(proceedsConvert.getCardMoney());
        return proceedsEntity;
    }
}
