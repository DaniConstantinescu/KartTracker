package com.example.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main extends Application {

    public static List<Circuit> circuite;
    public static List<Cursa> curse;
    public static List<PersonalLaps> laps;
    public static List<Cheltuieli> cheltuieli;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load( getClass().getResource("homepage.fxml") );
        Scene scene = new Scene(root);

        stage.setTitle("Karting Tracker");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * initializeaza listele de circuite, laps, curse si cheltuieli cu date din db
     */
    static void createLists(){

        circuite = DbUtilities.generateCircuite();
        laps = DbUtilities.generateLaps();
        curse = DbUtilities.generateRaces();
        cheltuieli = DbUtilities.generateCheltuieli();

    }

    public static void main(String[] args) {

        createLists();
        launch();

    }
}