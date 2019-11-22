import java.util.ArrayList;
import java.util.Iterator;


public class CustomIterator1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Cat");
        arrayList.add("Dog");
        arrayList.add("Rat");
        arrayList.add("Deer");
        arrayList.add("Pigeon");
        arrayList.add("Crow");
        Animal animal = new Animal(arrayList);
        for(String animalString:animal){
            System.out.println(animalString);
        }

    }
}

class Animal implements Iterable<String>{
    private ArrayList<String> animalList;
    public Animal(ArrayList<String> animalList){
        this.animalList = animalList;
    }

    public ArrayList<String> getAnimalList(){
        return this.animalList;
    }

    public Iterator<String> iterator() {
        return new AnimalIterator(this);
    }
}

class AnimalIterator implements Iterator<String>{
    private ArrayList<String> animalList;
    private int position=0;

    public AnimalIterator(Animal animalObject){
        this.animalList = animalObject.getAnimalList();
    }

    public boolean hasNext() {
        if(position<animalList.size())
            return true;

        return false;
    }

    public String next() {
        String nextString = animalList.get(position);
        position++;
        return nextString;
    }

    public void remove(){
        animalList.remove(position);
    }
}