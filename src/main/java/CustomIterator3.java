import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomIterator3 {
}

class UserDetails implements Iterable<Map.Entry<String,String>>{
    private HashMap<String,String> map = new HashMap<String,String>();

    public UserDetails(HashMap<String,String> map){
        this.map = map;
    }

    public HashMap<String,String> getMap(){
        return map;
    }

    public Iterator<Map.Entry<String, String>> iterator() {
        return new MapIterator(this);
    }
}

class MapIterator implements Iterator<Map.Entry<String,String>>{
    private Map<String,String> map = new HashMap<String, String>();
    private int position=0;
    public MapIterator(UserDetails userDetails){
        this.map = userDetails.getMap();
    }

    public boolean hasNext(){
        if(position<map.size())
            return true;
        return false;
    }

    public Map.Entry<String, String> next() {
        //Map.Entry<String,String> entry = map.entrySet();
        return null;
    }

    public void remove() {

    }
}
