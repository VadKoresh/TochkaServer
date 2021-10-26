package main.modelConvert;

import main.entity.BoardGameEntity;
import main.entity.UserTochkiEntity;

public class VictoryStoryConvert {

    private int id;
    private UserTochkiEntity userTochkiEntity;
    private BoardGameEntity boardGameEntity;
    private String date;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserTochkiEntity getUserTochkiEntity() {
        return userTochkiEntity;
    }

    public void setUserTochkiEntity(UserTochkiEntity userTochkiEntity) {
        this.userTochkiEntity = userTochkiEntity;
    }

    public BoardGameEntity getBoardGameEntity() {
        return boardGameEntity;
    }

    public void setBoardGameEntity(BoardGameEntity boardGameEntity) {
        this.boardGameEntity = boardGameEntity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
