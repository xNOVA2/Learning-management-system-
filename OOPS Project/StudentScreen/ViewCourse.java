package StudentScreen;

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

import Course.*;

public class ViewCourse extends JFrame implements ActionListener {
    JPanel panel1, panel2;
    JLabel label, label2;
    ArrayList<String> selectCourse = new ArrayList<>();
    JButton buttonBack;
    public ViewCourse() {
        buttonBack = new JButton("Main Menu");
        panel1 = new JPanel();
        panel2 = new JPanel();
        label = new JLabel("Student Console");
        this.setSize(800, 800);
        this.setVisible(true);

        this.setLayout(new BorderLayout());
        panel2.setLayout(null);

        this.add(panel1, BorderLayout.NORTH);
        panel1.add(label);
        panel1.setBackground(Color.LIGHT_GRAY);
        buttonBack.addActionListener(this);
        panel2.add(buttonBack);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Course.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                selectCourse.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        int y = 40;
        for (String course : selectCourse) {

            JButton courseButton = new JButton(course);
            courseButton.setBounds(50, y, 350, 40);
            courseButton.setBackground(Color.black);
            courseButton.setForeground(Color.WHITE);

            panel2.add(courseButton);
            y += 60;
            courseButton.addActionListener(this);
        }
        buttonBack.setBounds(50, y, 150, 40);
        buttonBack.setBackground(Color.black);
        buttonBack.setForeground(Color.WHITE);
        this.add(panel2, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
   

        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
                 if(e.getSource()==buttonBack){
            dispose();
            new StudentScreen();
        }
            if(button.getText().equals("Software Design and Architecture (SDA-2004)")){
                this.dispose();
                new SoftwareDesign(button.getText());
            }
            else if(button.getText().equals("Database Management System Lab (DBL-2001)")){
                new DatabaseLab(button.getText());
                this.dispose();
            }
            else if(button.getText().equals("Object Oriented Programming Theory (OOPT-2002)")){
                new OopsTheory(button.getText());
                this.dispose();
            }
            else if(button.getText().equals("Object Oriented Programming Lab (OOPL-2002)")){
                new OopsLab(button.getText());
                this.dispose();
            }
            else if(button.getText().equals("Operating System Lab (OSL-2003)")){
                new OperatingSystemLab(button.getText());
                this.dispose();
            }
            else if(button.getText().equals("Operating System Theory(OSL-2003)")){
                new OperatingSystemTheory(button.getText());
                this.dispose();
            }
            else if(button.getText().equals("Database Management System Theory (DBT-2001)")){
                new DatabaseTheory(button.getText());
                this.dispose();
            }
          
        }
    }

   
}
