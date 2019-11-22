import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class jsonConversionTest {
    private String name;
    private Map<String,Integer> map;
    private Employee employee;

    @Parameterized.Parameters
    public static Collection parametersForJSON(){
        ArrayList<Map<String,Integer>> mapList = new ArrayList<Map<String, Integer>>();
        mapList.add(new HashMap<String, Integer>());
        mapList.get(0).put("Vamshi",1);
        mapList.get(0).put("Raju",2);
        mapList.get(0).put("Hari",3);
        mapList.get(0).put("Tommy",4);
        mapList.get(0).put("Harry",5);
        mapList.add(new HashMap<String, Integer>());
        mapList.get(1).put("Vamshi",null);
        mapList.get(1).put("Raju",2);
        mapList.get(1).put("Hari",3);
        mapList.get(1).put("Tommy",4);
        mapList.get(1).put("Harry",5);
        mapList.add(new HashMap<String, Integer>());
        mapList.get(2).put("Vam\\\"shi",1);
        mapList.get(2).put("Raju",2);
        mapList.get(2).put("Hari",3);
        mapList.get(2).put("Tommy",4);
        mapList.get(2).put("Harry",5);
        mapList.add(new HashMap<String, Integer>());
        mapList.get(3).put("",1);
        mapList.get(3).put("Raju",2);
        mapList.get(3).put("Hari",3);
        mapList.get(3).put("Tommy",4);
        mapList.get(3).put("Harry",5);

        return Arrays.asList(new Object[][]{
                {"Vamshi",mapList.get(0)},
                {null,mapList.get(1)},
                {"",mapList.get(2)},
                {"\"",mapList.get(3)}
        });

    }

    public jsonConversionTest(String name,Map<String,Integer> map){
        this.name = name;
        this.map = map;
    }

    @Before
    public void initialize(){
         employee = new Employee(this.name,this.map);
    }

    @Test
    public void printJSONTest(){
        String jsonString =  ConvertToJSON.printJSON(employee);
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
