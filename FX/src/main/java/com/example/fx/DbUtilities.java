package com.example.fx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface DbUtilities {

    /**
     * creaaza lista de circuite cu datele din db
     * @return circuite -> lista de circuite
     */
    static List<Circuit> generateCircuite(){

        List<Circuit> circuite = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            ResultSet rez = stmt.executeQuery("select * from circuite");

            while ( rez.next() ){

                //System.out.println( "Tip: " + resultSet.getString(1) + " ; Pret: " + resultSet.getFloat(3) );

                circuite.add( new Circuit( rez.getInt(1), rez.getString(2)
                        , Timp.convertMs(Integer.parseInt(rez.getString(3)))
                        , Timp.convertMs(Integer.parseInt(rez.getString(4)))
                        , rez.getString(5), rez.getInt(6), rez.getInt(7)  ));

            }

            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

        return circuite;

    }

    static List<PersonalLaps> generateLaps(){

        List<PersonalLaps> laps = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            ResultSet rez = stmt.executeQuery("select * from laps");

            while ( rez.next() ){

                int idd = rez.getInt(2);
                String numeCircuit = Main.circuite.stream().filter( f -> f.id == idd  ).collect(Collectors.toList()).get(0).nume;

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime data = LocalDateTime.parse(rez.getString(8), formatter);


                laps.add( new PersonalLaps( rez.getInt(1), new Lap( numeCircuit, Timp.convertMs( rez.getInt(3) )
                        , rez.getInt(5), rez.getInt(6),rez.getInt(7)
                        , Timp.convertMs( rez.getInt(4) )
                        , data) ));

            }



            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

        return laps;

    }

    static List<Cursa> generateRaces(){

        List<Cursa> curse = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            ResultSet rez = stmt.executeQuery("select * from curse");

            while ( rez.next() ){


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(rez.getString(8), formatter);


                curse.add( new Cursa(rez.getInt(1), rez.getInt(2)
                        , Timp.convertMs( rez.getInt(3))
                        , rez.getInt(4), rez.getInt(5), rez.getInt(6), rez.getInt(7)
                        , data ));

            }



            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

        return curse;

    }

    static List<Cheltuieli> generateCheltuieli(){

        List<Cheltuieli> cheltuiala = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            ResultSet rez = stmt.executeQuery("select * from cheltuieli");

            while ( rez.next() ){

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(rez.getString(4), formatter);

                cheltuiala.add( new Cheltuieli(rez.getString(1),rez.getString(2), rez.getFloat(3), data) );

            }



            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

        return cheltuiala;

    }


    /**
     * introduce un circuit nou in db
     * @param nume
     * @param bestLap
     * @param pesronalBest
     * @param tara
     * @param corners
     * @param lungime
     */
    public static void inserareCircuitDB(String nume, int bestLap, int pesronalBest, String tara, int corners, int lungime){

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            String sql = " INSERT INTO circuite ( nume, bestlap, personalbest, tara, corners, lungime )"
                    + " VALUES ( " + "'" + nume + "'" + ", " + bestLap + ", " + pesronalBest + ", " + "'" + tara + "'" + ", " + corners + ", " + lungime + " )" ;

            stmt.executeUpdate(sql);

            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void inserareLapDB(int id, int timp, int best, int s1, int s2, int s3, String data ){

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            String sql = " INSERT INTO laps ( idcircuit, timp, overallbest, s1, s2, s3, data )"
                    + " VALUES ( " +  id +  ", " + timp + ", " + best + ", " + s1 + ", " + s2 + ", " + s3 + ", " + "'" + data + "'" + " )" ;

            stmt.executeUpdate(sql);

            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void inserareRaceDB(int id, int best, int start, int fininsh, int pits, int laps, String data ){

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            String sql = " INSERT INTO curse ( idcircuit, bestlap, startpos, finishpos, pits, laps, data )"
                    + " VALUES ( " +  id +  ", " + best + ", " + start + ", " + fininsh + ", " + pits + ", " + laps + ", " + "'" + data + "'" + " )" ;

            stmt.executeUpdate(sql);

            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void inserareCheltuialaDB(String tip, String descriere, float pret, String data ){

        String url = "jdbc:mysql://localhost:3306/proiect p3";
        String user = "root";
        String pass = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();

            String sql = " INSERT INTO `cheltuieli` (`tip`, `descriere`, `pret`, `data`)"
                    + " VALUES ( " + "'" + tip + "'" + ", " + "'" + descriere + "'" + ", " + pret + ", " + "'" + data + "'" + " )" ;

            System.out.println(sql);

            stmt.executeUpdate(sql);

            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }


}
