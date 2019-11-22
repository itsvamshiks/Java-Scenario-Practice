import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LetterCountTest {

    private int inputNumber,expectedResult1,expectedResult2;
    private CountCalculator countCalculator;

    @Parameterized.Parameters
    public static Collection inputForTest(){
        Collection<Object[]> params = new ArrayList<Object[]>();

        params.add(new Object[]{25,165,10});
        params.add(new Object[]{-25,290,15});
        params.add(new Object[]{0,4,4});

        return params;
    }

    @Before
    public void initialize(){
        countCalculator = new CountCalculator();
    }

    public LetterCountTest(int inputNumber,int expectedResult1,int expectedResult2){
        this.inputNumber = inputNumber;
        this.expectedResult1 = expectedResult1;
        this.expectedResult2 = expectedResult2;
    }

    @Test
    public void letterCountSumTest(){
        assertEquals(countCalculator.letterCountSum(inputNumber),expectedResult1);
    }

    @Test
    public void letterCountTest(){
        assertEquals(countCalculator.letterCount(inputNumber),expectedResult2);
    }


}