package main.entity;

import main.modelConvert.VisitUserStoryConvertTo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_user_story")
public class VisitUserStoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visit_user_story")
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_user_tochki")
    private UserTochkiEntity userTochkiEntity;
    @Column(name = "time_in")
    private LocalDateTime timeIn;
    @Column(name = "time_out")
    private LocalDateTime timeOut;
    private double income;
    private boolean paid;
    @Column(name = "payment_type")
    private String paymentType;
    @ManyToOne
    @JoinColumn(name = "id_intent")
    private IntentVisitEntity intentVisitEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserTochkiEntity getUserTochkiEntity() {
        return userTochkiEntity;
    }

    public void setUserTochkiEntity(UserTochkiEntity userTochkiEntity) {
        this.userTochkiEntity = userTochkiEntity;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public IntentVisitEntity getIntentVisitEntity() {
        return intentVisitEntity;
    }

    public void setIntentVisitEntity(IntentVisitEntity intentVisitEntity) {
        this.intentVisitEntity = intentVisitEntity;
    }

    public static VisitUserStoryEntity fromJsonToEntity(VisitUserStoryConvertTo visitUserStoryConvertTo){
        VisitUserStoryEntity visitUserStoryEntity1 = new VisitUserStoryEntity();
        visitUserStoryEntity1.setId(visitUserStoryConvertTo.getId());
        visitUserStoryEntity1.setUserTochkiEntity(visitUserStoryConvertTo.getUserTochkiEntity());
        visitUserStoryEntity1.setTimeIn(LocalDateTime.parse(visitUserStoryConvertTo.getTimeIn()));
        visitUserStoryEntity1.setTimeOut(visitUserStoryConvertTo.getTimeOut() == null ?
                null : LocalDateTime.parse(visitUserStoryConvertTo.getTimeOut()));
        visitUserStoryEntity1.setIncome(visitUserStoryConvertTo.getIncome());
        visitUserStoryEntity1.setPaid(visitUserStoryConvertTo.isPaid());
        visitUserStoryEntity1.setPaymentType(visitUserStoryConvertTo.getPaymentType());
        visitUserStoryEntity1.setIntentVisitEntity(visitUserStoryConvertTo.getIntentVisitEntity());
        return visitUserStoryEntity1;
    }
}
