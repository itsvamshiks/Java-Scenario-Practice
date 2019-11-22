
import java.util.HashMap;
import java.util.Map;

public class MapToJSON {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("V\famshi","V");
        map.put("Raju","L");
        map.put("Hari","L");
        map.put("Tommy","S");
        map.put("Harry",null);

        JSONConverter jsonConverter = new JSONConverter();
        System.out.println(jsonConverter.toJSON(map));

    }

}

class JSONConverter{
    public String toJSON(Map<String,String> map){
        if(map==null)
            throw new IllegalArgumentException("Map is null");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        String separator = "";
        for(Map.Entry<String,String> entry:map.entrySet()){
            stringBuilder.append(separator);
            separator=",";
            String key = entry.getKey();
            String value = entry.getValue();
            toEntry(key,value,stringBuilder);
        }
        stringBuilder.append("}");


        return stringBuilder.toString();

    }

    public void toEntry(String key, String value, StringBuilder stringBuilder){
        stringBuilder.append("\"");
        escapeString(key,stringBuilder);
        stringBuilder.append("\"");
        stringBuilder.append(":");
        if(value!=null){
            stringBuilder.append("\"");
            escapeString(value,stringBuilder);
            stringBuilder.append("\"");
        }else{
            stringBuilder.append("null");
        }

    }

    public void escapeString(String str,StringBuilder stringBuilder){

            for (char c : str.toCharArray()) {
                switch (c) {
                    case '\n':
                        stringBuilder.append("\\n");
                        break;
                    case '\r':
                        stringBuilder.append("\\r");
                        break;
                    case '\b':
                        stringBuilder.append("\\b");
                        break;
                    case '\f':
                        stringBuilder.append("\\f");
                        break;
                    case '\t':
                        stringBuilder.append("\\t");
                        break;
                    case '\"':
                        stringBuilder.append("\\\"");
                        break;
                    case '\'':
                        stringBuilder.append("\\\'");
                        break;
                    case '\\':
                        stringBuilder.append("\\\\");
                        break;
                    default:
                        stringBuilder.append(c);
                        break;
                }
            }

    }

}
