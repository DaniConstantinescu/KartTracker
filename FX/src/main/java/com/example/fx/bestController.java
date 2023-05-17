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
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class bestController implements Initializable {

    @FXML
    ChoiceBox<String> circuit, zi, ideal;
    @FXML
    Label lcircuit, lzi, lideal, sectors;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void bestCircuit(ActionEvent event){

        lcircuit.setText("");
        lzi.setText("");
        lideal.setText("");

        String text = "Cel mai bun timp este: ";

        List<Lap> lista = Main.laps.stream().map(f -> f.getTimp()).filter( f -> f.getNumeCircuit().equals(circuit.getValue()) ).collect(Collectors.toList());
        Timp t = Lap.bestLap(lista, circuit.getValue());

        text += t.getMinute() + ":" + t.getSecunde() + ":" + t.getMilisecunde();

        lcircuit.setText(text);

    }
    @FXML
    protected void bestZi(ActionEvent event){

        lcircuit.setText("");
        lzi.setText("");
        lideal.setText("");

        String text = "Cel mai bun timp este: ";

        LocalDate data = LocalDate.parse(zi.getValue());

        List<Lap> lista = Main.laps.stream().map(f -> f.getTimp()).filter( f -> f.getData().toLocalDate().equals(data)).collect(Collectors.toList());
        Timp t = Lap.bestLap(lista, data);

        text += t.getMinute() + ":" + t.getSecunde() + ":" + t.getMilisecunde();

        lzi.setText(text);


    }
    @FXML
    protected void ideal(ActionEvent event){

        lcircuit.setText("");
        lzi.setText("");
        lideal.setText("");
        sectors.setText("");

        String text = "Cel mai bun timp este: ";

        List<Lap> lista = Main.laps.stream().map(f -> f.getTimp()).filter( f -> f.getNumeCircuit().equals(ideal.getValue()) ).collect(Collectors.toList());
        Lap t = Lap.idelLap(lista, ideal.getValue());

        text += t.getTimp().getMinute() + ":" + t.getTimp().getSecunde() + ":" + t.getTimp().getMilisecunde();
        String s = "Sector 1:  " + t.getS1() * 0.001 + "     ;     " + "Sector 2:  " + t.getS2() * 0.001 + "     ;     " + "Sector 3:  " + t.getS3() * 0.001 ;

        lideal.setText(text);
        sectors.setText(s);

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        List<String> numeCirc = Main.circuite.stream().map(Circuit::getNume).collect(Collectors.toList());
        Set<String> dateLaps = Main.laps.stream().map( f -> f.getTimp().getData().toLocalDate().toString() ).collect(Collectors.toSet());

        circuit.getItems().addAll(numeCirc);
        zi.getItems().addAll(dateLaps);
        ideal.getItems().addAll(numeCirc);

        circuit.setOnAction(this::bestCircuit);
        zi.setOnAction(this::bestZi);
        ideal.setOnAction(this::ideal);

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
