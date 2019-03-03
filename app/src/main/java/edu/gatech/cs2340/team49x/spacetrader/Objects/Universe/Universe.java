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
                    Resources.getRandom(random),
                    random
            );
            this.solarSystems.add(newSystem);
            this.nameMap.put(name, newSystem);
            this.coordMap.put(coordinate, newSystem);
        }
    }

    public boolean addSolarSystem(SolarSystem system) {
        if (nameMap.containsKey(system.getName()) || coordMap.containsKey(system.getCoordinate())) {
            return false;
        }
        this.solarSystems.add(system);
        this.nameMap.put(system.getName(), system);
        this.coordMap.put(system.getCoordinate(), system);
        return true;
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