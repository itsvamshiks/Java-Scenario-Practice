import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SerializationExample{
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("Vamshi","Nagabandi");
        Student student = new Student("Vamshi","Nagabandi",map);
        StudentSerializer studentSerializer = new StudentSerializer();
        studentSerializer.serializeObject(student);
        System.out.println("Serialization successful");
        student = studentSerializer.deserializeObject("SerializedObject.txt");
        System.out.println(student.getFirstName()+" "+student.getLastName());
    }
}

class StudentSerializer{
    public void serializeObject(Student student){
        try {
            FileOutputStream fos = new FileOutputStream("SerializedObject.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Student deserializeObject(String filename){
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student = (Student) ois.readObject();
            return student;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

class Student implements Serializable{
    private String firstName,lastName;
    private static final long serialVersionUID = 2L;
    transient private Map<String,String> map = new HashMap<String,String>();
    public Student(String firstName,String lastName,Map<String,String> map){
        this.firstName = firstName;
        this.lastName = lastName;
        this.map = map;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Map<String,String> getMap(){
        return map;
    }

}

/*public class SerializationExample {

    public static void main(String[] args){
        Student student = new Student("Vamshi Krishna Sai","Nagabandi");
        StudentSerializer serializer = new StudentSerializer();
        serializer.serializeObject(student);
        System.out.println("Serialization complete");
        student = serializer.deserializeObject();
        System.out.println(student.getFirstName()+" "+student.getLastName());
    }
}

class StudentSerializer{
    public void serializeObject(Student object){
        try {
            FileOutputStream fout = new FileOutputStream("StudentSerialized.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
            oos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Student deserializeObject(){
        Student object1;
        try {
            FileInputStream fis = new FileInputStream("StudentSerialized.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            object1 = (Student) ois.readObject();
            return object1;
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}

class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    private String firstName,lastName;
    public Student(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }


}*/
