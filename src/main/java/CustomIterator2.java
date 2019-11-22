import java.util.Iterator;

public class CustomIterator2 {
    public static void main(String[] args) {
        String sampleName = "Vamshi Krishna Sai";
        Names names = new Names(sampleName);
        Iterator iterator = names.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

class Names implements Iterable<String> {
    private String name;

    public Names(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public Iterator<String> iterator(){
        return new NamesIterator(this);
    }
}

class NamesIterator implements Iterator<String>{
    private int position;
    private String name;

    public NamesIterator(Names nameObject){
        this.name = nameObject.getName();
    }

    public boolean hasNext(){
        if(position<name.length())
            return true;

        return false;
    }

    public String next() {
        String letter = Character.toString(name.charAt(position));
        position++;
        return letter;
    }

    public void remove(){
        System.out.println("Remove not possible");
    }
}
