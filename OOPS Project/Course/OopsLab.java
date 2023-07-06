package Course;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import StudentScreen.ViewCourse;

public class OopsLab extends JFrame implements ActionListener{
    JPanel panel1,panel2;
    JLabel label,label2,label3;
    String CourseName;
        JButton button,button2;
   ArrayList<String> check;
    public OopsLab(String CoursName){
check = new ArrayList<>();

  
        this.CourseName = CoursName;
        panel1 = new JPanel();
        panel2 = new JPanel();
        label = new JLabel("Student Console");
        label2 = new JLabel("Course Title : " +CourseName);
        label3 = new JLabel("Course Teacher :   Miss Sumaira");
            this.setSize(800,800);
            this.setVisible(true);
            this.setLayout(new BorderLayout());
        panel2.setLayout(null);
            panel1.add(label);
        panel2.add(label2);
        panel2.add(label3);
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
        panel1.setBackground(Color.LIGHT_GRAY);
        label2.setBounds(20,10,430,20);
        label3.setBounds(20,30,190,20);

        button2 = new JButton("Back to Course");
     button2.addActionListener(this);
         panel2.add(button2);
         button2.setBackground(Color.BLACK);
         button2.setForeground(Color.white);
         button2.setBounds(20,130,180,30);
        button2.setFocusable(false);

           try {
            BufferedReader reader = new BufferedReader(new FileReader("quiztiming.txt"));
            String line;
            while((line = reader.readLine())!=null){
                check.add(line);
                
            
            }
            reader.close();
    } catch (Exception err) {
        System.out.println(err);
    }

        System.out.println(check);
        System.out.println(CourseName);

        String QuizTime = check.get(0);
        LocalTime currentTime = LocalTime.now();
        String currentTimeString = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    // Compare the quiz time with the current time
    // MY CURRENT TIME 12:52 AM
    //12:40:00 QUIZ TIME
    System.out.println(currentTimeString);
    System.out.println(check.get(0));
    int comparison = QuizTime.compareTo(currentTimeString);

        if(check.get(1).equals(CourseName ) &&  comparison <= 0 ){
            button = new JButton();
            button.setBounds(20,60,190,20);
            button.setText("Quiz :)");
            button.addActionListener(this);
            panel2.add(button);
            button.setBackground(Color.black);
            button.setForeground(Color.WHITE);

        }
    }

    
    @Override
public void actionPerformed(ActionEvent e) {
   if(e.getSource() == button){
            this.dispose();
            new QuizPage();
        }
        if(e.getSource() == button2){
            this.dispose();
            new ViewCourse();
        }
}

}
