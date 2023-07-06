package StudentScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectCourseScreen extends JFrame implements ActionListener{

    JPanel panel1,panel2;
    JLabel label2;
    ArrayList<String> Course = new ArrayList<>();
    JButton button;
    public SelectCourseScreen(){
        Course.add("Database Management System Theory (DBT-2001)");
        Course.add("Database Management System Lab (DBL-2001)");
        Course.add("Object Oriented Programming Theory (OOPT-2002)");
        Course.add("Object Oriented Programming Lab (OOPL-2002)");
        Course.add("Operating System Lab (OSL-2003)");
        Course.add("Operating System Theory(OSL-2003)");
        Course.add("Software Design and Architecture (SDA-2004)");

        button = new JButton("SUBMIT");
        panel1 = new JPanel();
        panel2 = new JPanel();
        label2 = new JLabel("Student Course");
        panel2.setLayout(null);
        this.setLayout(new BorderLayout());

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);

    panel1.setBackground(Color.LIGHT_GRAY);        
        panel2.add(button);
        button.setFocusable(false);
        panel1.add(label2);
        int y = 20;
        int index = 0;
        for(String course: Course){
            JCheckBox checkBox = new JCheckBox();
            checkBox.setName(Integer.toString(index));

            checkBox.setBounds(0,y,20,20 );

            JLabel  label = new JLabel();
         label.setText(course);
       label.setBounds(20,y,300,20 );
        panel2.add(label);
        panel2.add(checkBox);
            y+=30;
            index++;

        }
        button.setBounds(20,y+50,120,30);
        button.addActionListener(this);
        this.setSize(800,800);
        this.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> Savecourse = new ArrayList<>();

        if(e.getSource() == button){ 
             Component[] components = panel2.getComponents();
             for(Component component : components){
                if(component instanceof JCheckBox){
                    JCheckBox checkBox = (JCheckBox) component;
                    if (checkBox.isSelected()) {
                    int selectedIndex = Integer.parseInt(checkBox.getName());
    
                    Savecourse.add(Course.get(selectedIndex));
                    try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Course.txt"));
                    
                    for (String course : Savecourse) {
                        writer.write(course + "\n");
             
                    }
                    writer.close();
                    } catch (Exception err) {
                        System.out.println(err);
                    }
                    }
                 }
             }
          
        }

       
       new StudentScreen();
    }
}


 // try {
        // BufferedReader reader = new BufferedReader(new FileReader("Course.txt"));
        // ArrayList<String> SelectCourse = new ArrayList();  
        // String line;
        // while((line = reader.readLine())!= null){
        //     SelectCourse.add(line);
        //     }
        //     reader.close();
        //     System.out.println(SelectCourse.get(0));
        // } catch (Exception err) {
        //     System.out.println(err);
        // }