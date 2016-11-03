/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class View extends Application{
    private List<Planet> testPlanets = new ArrayList<>();
    private final static double MAG = 100;
    private final static int screen = 400;
    @Override
    public void start(Stage primaryStage) {
        Database myDatabase = new Database();
        testPlanets = myDatabase.getPlanetOnStar("GJ 876");
        primaryStage.setTitle("Shapes");
        
        Group root = new Group();
        Scene scene = new Scene(root, screen, screen, Color.WHITE);

        for (Planet planet: testPlanets) {
            Ellipse newPlanet = planet.getElipse(MAG, screen/2);
            newPlanet.setFill(Color.WHITE);
            newPlanet.setStroke(Color.BLACK);
            root.getChildren().add(newPlanet);
            System.out.println(planet.getElipse(MAG, screen/2).toString());
        }
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        
        launch(args);
    }
}
