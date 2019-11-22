import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.HashMap;
import java.util.Map;

public class jsonConversion{
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("V\"amshi",null);
        map.put("Raju",2);
        map.put("Hari",3);
        map.put("Tommy",4);
        map.put("Harry",5);
        String jsonString =  ConvertToJSON.printJSON(new Employee("Vamshi Krishna Sai",map));
        System.out.println(jsonString) ;
        /*Employee employee = new Employee("Vamshi",map);
        Class c = employee.getClass();
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType());
        }*/
    }
}


class ConvertToJSON {

    public static String printJSON(Employee emp){
        StringBuilder stringBuilder = new StringBuilder("{");
        if(emp.getName()!=null){
            StringBuilder empName = new StringBuilder(emp.getName());
            if(empName.indexOf("\"")!=-1){
                if(empName.indexOf(("\""))>0 && empName.charAt(empName.indexOf("\"")-1)=='\\'){
                    empName.insert(empName.indexOf("\""),"\\\\");
                }else{
                    empName.insert(empName.indexOf("\""),"\\");
                }
                //key.insert(key.indexOf("\""),"\\");

            }
            stringBuilder.append("\"name\": \"").append(empName).append("\", ");
        }else{
            stringBuilder.append("\"name\" :").append(emp.getName()).append(", ");
        }
        stringBuilder.append("\"hashMap\" :{");
        if (emp.getHashMap() != null) {
            for (Map.Entry<String, Integer> mp : emp.getHashMap().entrySet()) {
                if (mp.getKey() != null) {
                    StringBuilder key = new StringBuilder(mp.getKey());
                    if(key.indexOf("\"")!=-1){
                        if(key.indexOf(("\""))>0 && key.charAt(key.indexOf("\"")-1)=='\\'){
                            key.insert(key.indexOf("\""),"\\\\");
                        }else{
                            key.insert(key.indexOf("\""),"\\");
                        }
                        //key.insert(key.indexOf("\""),"\\");
                        stringBuilder.append("\"").append(key).append("\": ");
                    }else{
                        stringBuilder.append("\"").append(mp.getKey()).append("\" : ");
                    }
                    stringBuilder.append(mp.getValue()).append(",");
                }

            }
        }else{
            stringBuilder.append(emp.getHashMap()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1).append("}}");
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(stringBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}

class Employee{
    private String name;
    private Map<String,Integer> hashMap;

    public Employee(String name,Map<String,Integer> map){

        this.name = name;
        hashMap = new HashMap<String, Integer>();
        for(Map.Entry<String,Integer> mp :map.entrySet()){
            hashMap.put(mp.getKey(),mp.getValue());
        }
    }

    public synchronized Map<String, Integer> getHashMap() {
        return hashMap;
    }

    public synchronized String getName(){
        return name;
    }
}
