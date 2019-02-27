package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeTransaction;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class Player {

    private String name;
    private int skillPt;
    private int pilotPt;
    private int fighterPt;
    private int tradePt;
    private int engineerPt;
    private Ship ship;
    private SolarSystem currentSystem;
    private int credits;

    public Player(String name, int skillPt, int pilotPt, int fighterPt, int tradePt, int engineerPt, Ship ship) {
        this.name = name;
        this.skillPt = skillPt;
        this.pilotPt = pilotPt;
        this.fighterPt = fighterPt;
        this.tradePt = tradePt;
        this.engineerPt = engineerPt;
        this.ship = ship;
        this.credits = 1000;
    }

    public Player(String name) {
        this(name, 16, 0,0,0,0,new Ship(Ship.ShipType.GNAT));
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


    public SolarSystem getCurrentSystem() {
        return currentSystem;
    }

    public void setCurrentSystem(SolarSystem currentSystem) {
        this.currentSystem = currentSystem;
    }

    /**
     * Starts a TradeTransaction on the current planet.
     * @return a new TradeTransaction, or null if the currentSystem is null
     */
    public TradeTransaction startTrade() {
        if (currentSystem == null) {
            return null;
        }
        return new TradeTransaction(this, currentSystem.getPrices());
    }

    public boolean addToCargo(Inventory items) {
        return this.ship.addToCargo(items);
    }

    public boolean removeFromCargo(Inventory items) {
        return this.ship.removeFromCargo(items);
    }

    public boolean has(Inventory items) {
        return ship.has(items);
    }

    public int cargoSpaceRemaining() {
        return ship.cargoSpaceRemaining();
    }

    public void changeCredits(int amount) {
        credits += amount;
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
                ", credits=" + credits +
                '}';
    }
}