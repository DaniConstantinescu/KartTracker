package com.example.fx;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class evoTimpController implements Initializable {


    @FXML
    LineChart<?, ?> line;
    @FXML
    ChoiceBox<String> circuit;


    private Stage stage;
    private Scene scene;
    private Parent root;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        //initializare choiceBox cu numele circuilelor
        List<String> numeCirc = Main.circuite.stream().map(Circuit::getNume).collect(Collectors.toList());
        circuit.getItems().addAll(numeCirc);

        circuit.setOnAction(this::populareGraf);

    }

    void populareGraf(ActionEvent event){


        Map<LocalDateTime,Integer> tipuri = new HashMap<>();

        List<PersonalLaps> timpi = Main.laps.stream().filter(f -> f.getTimp().getNumeCircuit().equals(circuit.getValue()) ).collect(Collectors.toList());


        for (PersonalLaps l : timpi) {

            if ( tipuri.containsKey(l.timp.data) ){
                tipuri.put(l.timp.data, tipuri.get(l.timp.data) + Timp.convertTimpToMs(l.timp.timp) );
            }
            else {
                tipuri.put(l.timp.data, Timp.convertTimpToMs(l.timp.timp) );
            }

        }

        tipuri = tipuri .entrySet() .stream() .sorted(comparingByKey()) .collect( toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        XYChart.Series series = new XYChart.Series();
        series.setName("Graficul evolutiei timpilor");

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");


        for (LocalDateTime d : tipuri.keySet()) {
            series.getData().add( new XYChart.Data(d.format(formatters).toString(),tipuri.get(d) ));
        }

        line.getData().clear();
        line.getData().add(series);



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
