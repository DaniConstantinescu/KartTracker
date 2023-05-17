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
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class newRaceController implements Initializable{


    @FXML
    TextField best;
    @FXML
    Spinner<Integer> startPos, finishPos, pits, laps;
    @FXML
    DatePicker data;
    @FXML
    ChoiceBox<String> circuit;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void addRace(ActionEvent event) throws IOException {


        if (circuit.getValue().equals("") || best.getText().equals("") || data.getValue() == null  ||
            startPos.getValue() == 0 || finishPos.getValue() == 0 || pits.getValue() == 0 || laps.getValue() == 0 )
        {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Unul dintre campuri nu a fost completat");
            a.show();

        } else {

            String nnume = circuit.getValue();
            int idCircuit = Main.circuite.stream().filter(f -> f.nume.equals(nnume) ).collect(Collectors.toList()).get(0).id;


            int bs = Timp.convertTimpToMs( Timp.convertStringToTimp(best.getText()) );
            String date = data.getValue().toString();

            DbUtilities.inserareRaceDB(idCircuit, bs, startPos.getValue(), finishPos.getValue(), pits.getValue(), laps.getValue(), date);


            circuit.setValue("");
            best.setText("");
            data.setValue(null);

            SpinnerValueFactory<Integer> spos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
            SpinnerValueFactory<Integer> fpos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
            SpinnerValueFactory<Integer> pit = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20);
            SpinnerValueFactory<Integer> lap = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);

            startPos.setValueFactory(spos);
            finishPos.setValueFactory(fpos);
            pits.setValueFactory(pit);
            laps.setValueFactory(lap);

            Main.laps = DbUtilities.generateLaps();



        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        List<String> numeCirc = Main.circuite.stream().map(Circuit::getNume).collect(Collectors.toList());
        circuit.getItems().addAll(numeCirc);

        SpinnerValueFactory<Integer> spos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        SpinnerValueFactory<Integer> fpos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        SpinnerValueFactory<Integer> pit = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20);
        SpinnerValueFactory<Integer> lap = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);

        startPos.setValueFactory(spos);
        finishPos.setValueFactory(fpos);
        pits.setValueFactory(pit);
        laps.setValueFactory(lap);

    }





    //Schimbare scena din MenuBar
    @FXML
    protected void switchToaddCircuit(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addCircuit.fxml"));
        root = loader.load();
        stage = (Stage) ((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

        scene = new Scene(root);
        stage.setTitle("Adaugati un nou circuit");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void switchToaddTimp(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addTimp.fxml"));
        root = loader.load();
        stage = (Stage) ((MenuItem) event.getTarget()).getParentPopup().getOwnerWindow();

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
