package CheckMarksScreen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarksScreen  extends JFrame{
    JPanel panel1,panel2;
    JLabel label1, label2,label3,label4,label5;

    public MarksScreen(){
        String status = "";
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1  = new JLabel("Teacher Console");
        label2  = new JLabel("Quiz Marks for all Subjects");
        label3  = new JLabel("Student name : Ali Osaid");
        label4  = new JLabel();
        label5  = new JLabel();

        this.setLayout(new BorderLayout());
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);

        panel2.setPreferredSize(new Dimension(700,700));
        panel2.setLayout(null);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.add(label1);
        panel2.add(label5);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(label4);
                label3.setBounds(50,0,200,20);

        label2.setBounds(50,20,200,20);
        this.setSize(800,800);
        this.setVisible(true);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("QuizMarks.txt"));
            String line = reader.readLine();
             if(line==null){
                    status="Absent";
                }
                else{
                    status="Present";
                    label4.setText(line);
                }

               
               
           reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        label5.setText("Student Status :" +  status );
        label5.setBounds(50,70,260,30);
        label4.setBounds(50,90,40,20);
    }
}
