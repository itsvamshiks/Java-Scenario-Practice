import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class romanConverterTest {

    private String romanString;
    private int expectedResult;
    private RomanToNumber romanToNumber;

    @Parameterized.Parameters
    public static Collection parametersForJSON(){
        return Arrays.asList(new Object[][]{
                {"MCMIV",1904},
                {null,-1},
                {"",-1},
                {"MC//KV",-1}
        });

    }

    @Before
    public void initialize(){
        romanToNumber = new RomanToNumber();
    }

    public romanConverterTest(String romanString,int expectedResult){
        this.romanString = romanString;
        this.expectedResult = expectedResult;
    }

    @Test
    public void RomanToNumberTest(){
        assertEquals(expectedResult,romanToNumber.convertRoman(romanString));
    }

}