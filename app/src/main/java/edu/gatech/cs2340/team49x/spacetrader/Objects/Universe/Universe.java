package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Universe {

    private static final List<String> systemNames = Arrays.asList(
            "Acamar",
            "Adahn",
            "Aldea",
            "Balosnee",
            "Baratas",
            "Calondia",
            "Castor",
            "Cestus",
            "Daled",
            "Damast",
            "Davlos",
            "Endor",
            "Esmee",
            "Exo",
            "Ferris",
            "Festen",
            "Fourmi",
            "Gemulon",
            "Guinifer",
            "Hades",
            "Hamlet",
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
            "Largo",
            "Lave",
            "Ligon",
            "Lowry",
            "Magrat",
            "Malcoria",
            "Melina",
            "Mentar",
            "Nelvana",
            "Nix",
            "Nyle",
            "Odet",
            "Og",
            "Omega",
            "Parade",
            "Penthara",
            "Picard",
            "Pollux",
            "Quator",
            "Rakhar",
            "Ran",
            "Regulas",
            "Sarpeidon",
            "Sefalla",
            "Seltrice",
            "Tamus",
            "Tantalos",
            "Thera",
            "Titan",
            "Tyrus",
            "Umberlee",
            "Utopia",
            "Vadera",
            "Vagra",
            "Xenon",
            "Xerxes",
            "Yew",
            "Yojimbo",
            "Zalkon",
            "Zuul"
    );

    private List<SolarSystem> solarSystems;
    private Map<String, SolarSystem> nameMap;
    private Map<Coordinate, SolarSystem> coordMap;
    private Random random;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 100;
    private static final int NUM_NAMES = systemNames.size();

    public Universe(Random random) {
        this.solarSystems = new ArrayList<>();
        this.random = random;
        this.nameMap = new HashMap<>();
        this.coordMap = new HashMap<>();
    }

    public Universe(Random random, int numSystems) {
        this(random);
        while (solarSystems.size() < numSystems
                && solarSystems.size() < WIDTH * HEIGHT
                && solarSystems.size() < NUM_NAMES) {
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

    public List<SolarSystem> getSolarSystems() {
        return solarSystems;
    }

    @Override
    public String toString() {
        return "Universe{" +
                "solarSystems=" + Arrays.toString(solarSystems.toArray()) +
                '}';
    }
}