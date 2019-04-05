package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Universe implements Serializable {

    static final long serialVersionUID = 1L;
    private static final List<String> systemNames = Arrays.asList(
            "Acamar",
            "Adahn",
            "Aldea",
            "Andevian",
            "Antedi",
            "Balosnee",
            "Baratas",
            "Brax",
            "Bretel",
            "Calondia",
            "Campor",
            "Capelle",
            "Carzon",
            "Castor",
            "Cestus",
            "Cheron",
            "Courteney",
            "Daled",
            "Damast",
            "Davlos",
            "Deneb",
            "Deneva",
            "Devidia",
            "Draylon",
            "Drema",
            "Endor",
            "Esmee",
            "Exo",
            "Ferris",
            "Festen",
            "Fourmi",
            "Frolix",
            "Gemulon",
            "Guinifer",
            "Hades",
            "Hamlet",
            "Helena",
            "Hulst",
            "Iodine",
            "Iralius",
            "Janus",
            "Japori",
            "Jarada",
            "Jason",
            "Kaylon",
            "Khefka",
            "Kira",
            "Klaatu",
            "Klaestron",
            "Korma",
            "Kravat",
            "Krios",
            "Laertes",
            "Largo",
            "Lave",
            "Ligon",
            "Lowry",
            "Magrat",
            "Malcoria",
            "Melina",
            "Mentar",
            "Merik",
            "Mintaka",
            "Montor",
            "Mordan",
            "Myrthe",
            "Nelvana",
            "Nix",
            "Nyle",
            "Odet",
            "Og",
            "Omega",
            "Omphalos",
            "Orias",
            "Othello",
            "Parade",
            "Penthara",
            "Picard",
            "Pollux",
            "Quator",
            "Rakhar",
            "Ran",
            "Regulas",
            "Relva",
            "Rhymus",
            "Rochani",
            "Rubicum",
            "Rutia",
            "Sarpeidon",
            "Sefalla",
            "Seltrice",
            "Sigma",
            "Sol",
            "Somari",
            "Stakoron",
            "Styris",
            "Talani",
            "Tamus",
            "Tantalos",
            "Tanuga",
            "Tarchannen",
            "Terosa",
            "Thera",
            "Titan",
            "Torin",
            "Triacus",
            "Turkana",
            "Tyrus",
            "Umberlee",
            "Utopia",
            "Vadera",
            "Vagra",
            "Vandor",
            "Ventax",
            "Xenon",
            "Xerxes",
            "Yew",
            "Yojimbo",
            "Zalkon",
            "Zuul"
    );

    private final List<SolarSystem> solarSystems;
    private final Map<String, SolarSystem> nameMap;
    private final Map<Coordinate, SolarSystem> coordMap;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 100;
    private static final int NUM_NAMES = systemNames.size();

    private Universe() {
        this.solarSystems = new ArrayList<>();
        this.nameMap = new HashMap<>();
        this.coordMap = new HashMap<>();
    }

    public Universe(Random random, int numSystems) {
        this();
        while ((solarSystems.size() < numSystems)
                && (solarSystems.size() < (WIDTH * HEIGHT))
                && (solarSystems.size() < NUM_NAMES)) {
            String name = systemNames.get(random.nextInt(systemNames.size()));
            Coordinate coordinate = new Coordinate(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            while (nameMap.containsKey(name)) {
                name = systemNames.get(random.nextInt(systemNames.size()));
            }
            while (coordMap.containsKey(coordinate)) {
                coordinate = new Coordinate(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            }
            SolarSystem newSystem = new SolarSystem(
                    name,
                    coordinate,
                    TechLevel.getRandom(random),
                    Resources.getRandom(random)
            );
            this.solarSystems.add(newSystem);
            this.nameMap.put(name, newSystem);
            this.coordMap.put(coordinate, newSystem);
        }
    }

    /**
     * Returns the solarSystem at a given index.
     *
     * @param i the index of the solarSystem
     * @return the solarSystem
     */
    public SolarSystem getSolarSystem(int i) {
        return solarSystems.get(i);
    }

    public List<SolarSystem> getSystemsInRange(SolarSystem system, double range) {
        List<SolarSystem> inRange = new ArrayList<>();
        for (SolarSystem other : solarSystems) {
            if (!system.equals(other) && (system.distanceTo(other) <= range)) {
                inRange.add(other);
            }
        }
        return inRange;
    }

    @Override
    public String toString() {
        return "Universe{" +
                "solarSystems=" + Arrays.toString(solarSystems.toArray()) +
                '}';
    }
}