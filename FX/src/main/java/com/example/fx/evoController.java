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
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class evoController implements Initializable {

    @FXML
    LineChart<?, ?> line;

    private Stage stage;
    private Scene scene;
    private Parent root;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        Map<LocalDate,Float> tipuri = new HashMap<>();
        int sum = 0;

        for (Cheltuieli c : Main.cheltuieli) {

            sum += c.pret;
            if ( tipuri.containsKey(c.data) ){
                tipuri.put(c.data, tipuri.get(c.data) + c.pret );
            }
            else {
                tipuri.put(c.data, c.pret );
            }

        }

        tipuri = tipuri .entrySet() .stream() .sorted(comparingByKey()) .collect( toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        XYChart.Series series = new XYChart.Series();
        series.setName("Graficul evolutiei chelutililor");

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/YYYY");


        for (LocalDate d : tipuri.keySet()) {
            series.getData().add( new XYChart.Data(d.format(formatters).toString(),tipuri.get(d) ));
        }

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
