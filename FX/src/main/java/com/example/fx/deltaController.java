package com.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class deltaController implements Initializable {

    @FXML
    ChoiceBox<String> circuit,zi;
    @FXML
    Label deltaC, deltaD;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void deltaCircuit(ActionEvent event){

        deltaC.setText("");
        deltaD.setText("");

        String text = "Delta:  ";

        List<PersonalLaps> lista = Main.laps.stream().filter( f -> f.getTimp().getNumeCircuit().equals(circuit.getValue()) ).collect(Collectors.toList());
        int ms = PersonalLaps.calculateDelta(lista, circuit.getValue());
        double delta = Math.round( (ms*0.001) *100.0)/100.0;

        deltaC.setText(text + delta + " s");

    }
    @FXML
    protected void deltaZi(ActionEvent event){

        deltaC.setText("");
        deltaD.setText("");

        String text = "Delta:  ";

        LocalDate data = LocalDate.parse(zi.getValue());

        List<PersonalLaps> lista = Main.laps.stream().filter( f -> f.getTimp().getData().toLocalDate().equals(data)).collect(Collectors.toList());
        int ms = PersonalLaps.calculateDelta(lista,data);
        double delta = Math.round( (ms*0.001) *100.0)/100.0;

        //text += t.getMinute() + ":" + t.getSecunde() + ":" + t.getMilisecunde();

        deltaD.setText(text + delta + " s");


    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        List<String> numeCirc = Main.circuite.stream().map(Circuit::getNume).collect(Collectors.toList());
        Set<String> dateLaps = Main.laps.stream().map( f -> f.getTimp().getData().toLocalDate().toString() ).collect(Collectors.toSet());

        circuit.getItems().addAll(numeCirc);
        zi.getItems().addAll(dateLaps);

        circuit.setOnAction(this::deltaCircuit);
        zi.setOnAction(this::deltaZi);

    }


    //Schimbare scena din MenuBar
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
