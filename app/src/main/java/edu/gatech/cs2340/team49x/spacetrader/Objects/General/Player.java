package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

/**
 * Player object class
 */
public class Player implements Serializable {

    static final long serialVersionUID = 1L;
    private static final int POINT = 16;
    private String name;
    private int skillPt;
    private int pilotPt;
    private int fighterPt;
    private int tradePt;
    private int engineerPt;
    private final Ship ship;
    private int credits;

    private Player(String name, Ship ship) {
        this.name = name;
        this.skillPt = POINT;
        this.pilotPt = 0;
        this.fighterPt = 0;
        this.tradePt = 0;
        this.engineerPt = 0;
        this.ship = ship;
        this.credits = 1000;
    }

    /**
     * Default constructor
     * @param name name of a player
     */
    public Player(String name) {
        this(name, new Ship(Ship.ShipType.GNAT));
    }

    /**
     * Gets player name
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets player name
     * @param name new name of a player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets skill points
     * @return total skill points of a player
     */
    public int getSkillPt() {
        return skillPt;
    }

    /**
     * Sets skill points
     * @param skillPt number of points
     */
    public void setSkillPt(int skillPt) {
        this.skillPt = skillPt;
    }

    /**
     * Gets skill points (pilot)
     * @return total skill points of a player
     */
    public int getPilotPt() {
        return pilotPt;
    }

    /**
     * Sets skill points (pilot)
     * @param pilotPt number of points
     */
    public void setPilotPt(int pilotPt) {
        this.pilotPt = pilotPt;
    }

    /**
     * Gets skill points (engineer)
     * @return total skill points of a player
     */
    public int getEngineerPt() {
        return engineerPt;
    }

    /**
     * Sets skill points
     * @param engineerPt number of points
     */
    public void setEngineerPt(int engineerPt) {
        this.engineerPt = engineerPt;
    }

    /**
     * Gets skill points (trade)
     * @return total skill points of a player
     */
    public int getTradePt() {
        return tradePt;
    }

    /**
     * Sets skill points
     * @param tradePt number of points
     */
    public void setTradePt(int tradePt) {
        this.tradePt = tradePt;
    }

    /**
     * Gets skill points (fighter)
     * @return total skill points of a player
     */
    public int getFighterPt() {
        return fighterPt;
    }

    /**
     * Sets skill points
     * @param fighterPt number of points
     */
    public void setFighterPt(int fighterPt) {
        this.fighterPt = fighterPt;
    }

    /**
     * Gets ship
     * @return current player ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Gets ship type
     * @return ship type
     */
    public Ship.ShipType getShipType() {
        return ship.getShipType();
    }

    /**
     * Sets ship
     * @param shipType new ship
     */
    public void setShipType(Ship.ShipType shipType) {
        ship.setShipType(shipType);
    }

    /**
     * Sets fuel to max
     */
    public void maxFuel() {
        ship.maxFuel();
    }

    /**
     * Gets cargo of a ship
     * @return set of items in ship
     */
    public Set<Tradable> getShipCargo() {
        return ship.getCargoSet();
    }

    /**
     * Gets credits
     * @return credits of a player
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Change credits
     * @param amount changed credit
     */
    public void changeCredits(int amount) {
        credits += amount;
    }

    @NonNull
    @Override
    public String toString() {
        return "\nPlayer{" +
                "\nname = '" + name + '\'' +
                ", \nskillPt = " + skillPt +
                ", pilotPt = " + pilotPt +
                ", fighterPt = " + fighterPt +
                ", tradePt = " + tradePt +
                ", engineerPt = " + engineerPt +
                ", \nship = " + ship.getName() +
                ", credits = " + credits +
                '}';
    }
}