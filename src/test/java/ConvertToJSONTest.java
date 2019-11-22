import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConvertToJSONTest {

    @Test
    public void printJSONTest() {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("Vamshi",1);
        map.put("Raju",2);
        map.put("Hari",3);
        map.put("Tommy",4);
        map.put("Harry",5);

        Employee emp = new Employee("Vamshi",map);
        String jsonString =  ConvertToJSON.printJSON(emp);
        System.out.println(jsonString);
        JSONParser parser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            System.out.println(jsonObject.keySet());
        }catch (ParseException e){
            fail("Not a valid json string");
        }

    }

}