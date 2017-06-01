package java_examples.oop_examples;


public class PlanetUsage {
    public static void main(String[] args) {
        Planet Earth = new Planet("6371,0 км");
        String averageRadiusEarth = Earth.getAverageRadius();
        System.out.println(averageRadiusEarth);
    }
}
