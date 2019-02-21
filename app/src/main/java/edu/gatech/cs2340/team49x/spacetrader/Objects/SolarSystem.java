package edu.gatech.cs2340.team49x.spacetrader.Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolarSystem {

    private Coord coordinates;
    private String name;
    private TechLevel techLevel;
    private ArrayList<Planet> planets;
    private Resources resources;

    enum TechLevel {
        PreAgriculture, Agriculture,
        Medieval, Renaissance,
        EarlyIndustrial, Industrial,
        PostIndustrial, HiTech
    }

    private static final Set<String> systemNames = new HashSet<>(Arrays.asList(
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
    ));

    public SolarSystem(Coord coordinates, String name, TechLevel techLevel, Resources resources, ArrayList<Planet> planets) {
        this.coordinates = coordinates;
        this.name = name;
        this.techLevel = techLevel;
        this.resources = resources;
        this.planets = planets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }
}
