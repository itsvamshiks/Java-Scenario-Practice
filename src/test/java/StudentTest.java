import org.junit.Before;
import org.junit.Test;

import java.io.NotSerializableException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class StudentTest {



    @Test(expected = ClassNotFoundException.class)
    public void testClassNotFound(){

    }

    @Test(expected = NotSerializableException.class)
    public void testNotSerializableException(){

    }

}