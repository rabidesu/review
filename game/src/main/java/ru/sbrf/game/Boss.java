package ru.sbrf.game;

public class Boss {

    private Integer HP;

    // Не использовать тут ASLEEP!!!
    private PlayerState bossState;


    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public PlayerState getBossState() {
        return bossState;
    }

    public void setBossState(PlayerState bossState) {
        this.bossState = bossState;
    }
}
