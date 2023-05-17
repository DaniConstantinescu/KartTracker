package com.example.fx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    void testMsToTimp(){

        Timp rez = new Timp(2,50,0);
        Assertions.assertEquals( rez, Timp.convertMs(110000), "conversie din ms in lap time" );

        rez = new Timp(1,19,2);
        Assertions.assertEquals( rez, Timp.convertMs(79200), "conversie din ms in lap time" );

    }

    @Test
    void testTimpToMs(){

        Timp input = new Timp(2,50,0);
        Assertions.assertEquals( 110000,Timp.convertTimpToMs(input) );

        input = new Timp(1,19,2);
        Assertions.assertEquals( 79200,Timp.convertTimpToMs(input) );

    }

}
