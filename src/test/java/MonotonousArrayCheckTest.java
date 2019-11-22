import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MonotonousArrayCheckTest{

    private int[] inputArray;
    private boolean expectedResult;

    @Parameterized.Parameters
    public static Collection parametersforTest(){
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {6,5,4,3,2,1};
        int[] arr3 = {1,2};
        int[] arr4 = {1};
        int[] arr5 = {};
        int[] arr6 = {4,5,2,4,6,3};
        return Arrays.asList(new Object[][]{
                {arr1,true},
                {arr2,true},
                {arr3,true},
                {arr4,true},
                {arr5,true},
                {arr6,false}
        });

    }

    public MonotonousArrayCheckTest(int[] inputArray,boolean expectedResult){
        this.inputArray = inputArray;
        this.expectedResult = expectedResult;
    }

    @Test
    public void isMonotonousTest(){
        assertEquals(MonotonocityChecker.isMonotonous(inputArray),expectedResult);
    }


}