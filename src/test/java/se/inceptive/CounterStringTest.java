package se.inceptive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by LeoVo on 1/13/2017.
 */
@RunWith(Parameterized.class)
public class CounterStringTest{
    private String getline;
    private String expected;
    private App counterString;
    @Before
    public void initialize(){
        counterString = new App();
    }

    public CounterStringTest(String getline, String expected){
        this.getline = getline;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Collection Resulttable(){
        return Arrays.asList(new Object[][]{
                        {"10","1*3*5*7*10"},
                        {"17","*2*4*6*8*11*14*17"},
                { "0","0"},
                { "1","1"},
                {"-1","Det gärller ett hel tal större än -1."}
                 }
        );
    }
     @Test
    public void testcounterString (){
        System.out.println("Parameterized string is: "+getline);
        System.out.println("result is: " + App.counterString(getline));
        assertEquals(expected, App.counterString(getline));
     }
}
