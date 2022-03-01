/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author horre
 */
@Entity
@Table(name="score")
public class Score implements java.io.Serializable{
    @Transient
    private int rank ;
    @Id
    @Column(name="username")
    private String name;
    @Column(name="score")
    private int score;
    @Column(name="levelDoneNum")
    private int levelDoneNum;

    public Score(String name, int levelDoneNum,int score) {
        this.name = name;
        this.score = score;
        this.levelDoneNum = levelDoneNum;
    }

    public Score() {
    }

    public int getLevelDoneNum() {
        return levelDoneNum;
    }

    public void setLevelDoneNum(int levelDoneNum) {
        this.levelDoneNum = levelDoneNum;
    }

    

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
    
    
    
}
