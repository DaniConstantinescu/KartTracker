package com.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void switchToaddCircuit(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addCircuit.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Adaugati un nou circuit");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void switchToaddTimp(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("addTimp.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Adaugati un nou timp");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void switchToaddRace(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("addCursa.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Adaugati o noua cursa");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void switchToaddCheltuiala(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("addCheltuiala.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Adaugati o noua cheltuiala");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void switchToBest(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("laps.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Adaugati o noua cursa");
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    protected void switchToDelta(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("delta.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Adaugati o noua cursa");
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    protected void switchToTip(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("grafTip.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem)event.getTarget()).getParentMenu().getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Graficul cheltuielilor grupate dupa tip");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    protected void switchToEvo(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("grafEvo.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem)event.getTarget()).getParentMenu().getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Graficul cheltuielilor grupate dupa tip");
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    protected void switchToEvoTimp(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("evoTimp.fxml"));
        root = loader.load();
        stage = (Stage)((MenuItem)event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Evolutia timpilor pe un circuit ales");
        stage.setScene(scene);
        stage.show();


    }


}