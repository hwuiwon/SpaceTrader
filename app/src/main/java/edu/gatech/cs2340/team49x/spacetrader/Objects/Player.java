package edu.gatech.cs2340.team49x.spacetrader.Objects;

import java.io.Serializable;
import java.util.Arrays;

public class Player implements Serializable {
    private String name;
    private int skillPt;
    private int pilotPt;
    private int fighterPt;
    private int tradePt;
    private int engineerPt;
    private Ship ship;
    private String[] storage;

    private int credits;

    public Player(String name, int skillPt, int pilotPt, int fighterPt, int tradePt, int engineerPt, Ship ship, String[] storage) {
        this.name = name;
        this.skillPt = skillPt;
        this.pilotPt = pilotPt;
        this.fighterPt = fighterPt;
        this.tradePt = tradePt;
        this.engineerPt = engineerPt;
        this.ship = ship;
        this.credits = 1000;
        this.storage = storage;
    }

    public Player(String name) {
        this(name, 16, 0,0,0,0,null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillPt() {
        return skillPt;
    }

    public void setSkillPt(int skillPt) {
        this.skillPt = skillPt;
    }

    public int getPilotPt() {
        return pilotPt;
    }

    public void setPilotPt(int pilotPt) {
        this.pilotPt = pilotPt;
    }

    public int getEngineerPt() {
        return engineerPt;
    }

    public void setEngineerPt(int engineerPt) {
        this.engineerPt = engineerPt;
    }

    public int getTradePt() {
        return tradePt;
    }

    public void setTradePt(int tradePt) {
        this.tradePt = tradePt;
    }

    public int getFighterPt() {
        return fighterPt;
    }

    public void setFighterPt(int fighterPt) {
        this.fighterPt = fighterPt;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String[] getStorage() {
        return storage;
    }

    public void setStorage(String[] storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", skillPt=" + skillPt +
                ", pilotPt=" + pilotPt +
                ", fighterPt=" + fighterPt +
                ", tradePt=" + tradePt +
                ", engineerPt=" + engineerPt +
                ", ship=" + ship +
                ", storage=" + Arrays.toString(storage) +
                ", credits=" + credits +
                '}';
    }
}