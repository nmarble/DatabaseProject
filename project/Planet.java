package project;

import javafx.scene.shape.Ellipse;

public class Planet {
    private String name;
    private double axis, ecc;
    public Planet(String name, double axis, double ecc) {
        this.name = name;
        this.axis = axis;
        this.ecc = ecc;
    }
    
    public Ellipse getElipse(double mag, int offset) {
        return new Ellipse(mag*(axis*ecc) + offset, offset, mag * axis, mag * axis);
    }
}
