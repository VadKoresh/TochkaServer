package main.modelConvert;

import main.entity.UserTochkiEntity;
import main.entity.VisitUserStoryEntity;

public class VisitUserStoryConvertTo {

    private long id;
    private UserTochkiEntity userTochkiEntity;
    private String timeIn;
    private String timeOut;
    private double income;
    private boolean paid;
    private String paymentType;

    public static VisitUserStoryConvertTo convertTo(VisitUserStoryEntity visitUserStoryEntity){
        VisitUserStoryConvertTo visitUserStoryConvertTo = new VisitUserStoryConvertTo();
        visitUserStoryConvertTo.setId(visitUserStoryEntity.getId());
        visitUserStoryConvertTo.setUserTochkiEntity(visitUserStoryEntity.getUserTochkiEntity());
        visitUserStoryConvertTo.setTimeIn(visitUserStoryEntity.getTimeIn().toString());
        visitUserStoryConvertTo.setTimeOut(visitUserStoryEntity.getTimeOut() == null ?
                null : visitUserStoryEntity.getTimeOut().toString());
        visitUserStoryConvertTo.setIncome(visitUserStoryEntity.getIncome());
        visitUserStoryConvertTo.setPaid(visitUserStoryEntity.isPaid());
        visitUserStoryConvertTo.setPaymentType(visitUserStoryEntity.getPaymentType());
        return visitUserStoryConvertTo;
    }

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

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
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
}
