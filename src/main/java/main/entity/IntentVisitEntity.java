package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "intent_visit")
public class IntentVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intent")
    private int idIntent;
    @Column(name = "intent_text")
    private String intentText;

    public int getIdIntent() {
        return idIntent;
    }

    public void setIdIntent(int idIntent) {
        this.idIntent = idIntent;
    }

    public String getIntentText() {
        return intentText;
    }

    public void setIntentText(String intentText) {
        this.intentText = intentText;
    }
}
