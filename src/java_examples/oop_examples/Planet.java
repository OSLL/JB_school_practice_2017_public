package java_examples.oop_examples;

public class Planet {
    String averageRadius;

    Planet(String averageRadius){
        this.averageRadius = averageRadius;
    }
    Planet(){
        this.averageRadius = "0.0";
    }

    String getAverageRadius(){
        return averageRadius;
    }

}
