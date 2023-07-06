package MainMenu;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;



public class Main{
    public static void main(String[] args) {
        new MyFrame(); 
        Teacher teacher = new Teacher("OOPS", "OOPS123");
        Student student = new Student("Ali Osaid", "TAHMYVES");
        try {
            ObjectOutputStream  ObjectWriter = new ObjectOutputStream(new FileOutputStream("Teacher.txt"));
            ObjectWriter.writeObject(teacher);
            ObjectWriter.close();
        } catch (Exception e) {
        System.out.println(e);
        }

       try {
           ObjectOutputStream  ObjectWriter = new ObjectOutputStream(new FileOutputStream("Student.txt"));
           ObjectWriter.writeObject(student);
           ObjectWriter.close();
       } catch (Exception e) {
        System.out.println(e);
       }
    }
}