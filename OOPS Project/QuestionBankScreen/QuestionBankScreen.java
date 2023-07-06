package QuestionBankScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AddQuestionScreen.Question;
import MainMenu.TeacherScreen;

public class QuestionBankScreen extends JFrame implements ActionListener {
    JPanel panel, panel2;
    JLabel label, label2, label3,label4,label5,label6;
    JButton button,button2;
    ArrayList<Question> List;
    JTextField textfieldOfCourse;
    JComboBox<String> comboBox;
    JComboBox<String> comboBox2;
    public QuestionBankScreen() {
    button2 = new JButton("Main menu");
        
        String[] option = {
            "Database Management System Theory (DBT-2001)",
            "Database Management System Lab (DBL-2001)",
            "Object Oriented Programming Theory (OOPT-2002)",
            "Object Oriented Programming Lab (OOPL-2002)",
            "Operating System Lab (OSL-2003)",
            "Operating System Theory(OSL-2003)",
            "Software Design and Architecture (SDA-2004)"
        };
        String[] option2 = {
            "01:30:00",
            "01:00:00",
            "00:40:00",
            "00:30:00",
            "00:20:00",
            "00:10:00",
        };
      comboBox = new JComboBox<>(option);
           comboBox2 = new JComboBox<>(option2);
        textfieldOfCourse = new JTextField();
        button = new JButton("ADD QUIZ");
        label2 = new JLabel();
        label4 = new JLabel("Select Course");
        label5 = new JLabel("Duration hh:mm:ss");
        label6= new JLabel();
        label3 = new JLabel("Set Time hh:mm:ss");
        panel2 = new JPanel();
        panel2.add(button);
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(300, 800));
        panel2.add(comboBox);
        panel2.add(comboBox2);
        List = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("QuestionList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String question = line;
                String[] options = reader.readLine().split(","); // options are separated by comma
                int answer = Integer.parseInt(reader.readLine());
                Question q = new Question(question, options, answer);
                List.add(q);
            }
        } catch (IOException e) {
          System.out.println(e);
        }   


        int y = 20;
        int index = 0;
        
        for (Question question : List) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setBounds(10, y, 20, 20);
            checkBox.setName(Integer.toString(index));
            panel2.add(checkBox);
    
            JLabel questionLabel = new JLabel(question.QuestionString());
            questionLabel.setBounds(40, y, 500, 20);
            panel2.add(questionLabel);
    
            y += 30;
            index++;
        }
        
        label3.setBounds(10, y + 30, 140, 30);
        textfieldOfCourse.setBounds(10, y, 140, 30);
     
        comboBox.setBounds(200, y, 340, 30);
        comboBox2.setBounds(590, y, 140, 30);
        button.setBounds(10, y + 70, 140, 30);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button2.setBounds(10, y + 120, 140, 30);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        label4.setBounds(200, y+30, 340, 30);
        label5.setBounds(590, y+30, 140, 30);
         label6.setBounds(290, y+100, 190, 30);
        panel2.add(label3);
        
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        label = new JLabel("Question Bank");
        panel2.add(textfieldOfCourse);
        panel2.add(button2);
        panel2.add(label4);
        panel2.add(label5);
                panel2.add(label6);

        panel.add(label);

        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);

        this.setSize(800, 800);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

            if(textfieldOfCourse.getText().length()==0){
                    label6.setText("Please Select time");
            label6.setForeground(Color.red);
                return;
            }
            ArrayList<Question> quiz = new ArrayList<>();
            
            Component[] components = panel2.getComponents();
    
            for (Component component : components) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) component;
                    if (checkBox.isSelected()) {
                        int selectedIndex = Integer.parseInt(checkBox.getName());
                        Question selectedQuestion = List.get(selectedIndex);
                        quiz.add(selectedQuestion);
                    }
                }
            }
    
           if(quiz.size()==0){
            label6.setText("Must select one question");
            label6.setForeground(Color.red);
            return ;
           }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("quiz.txt"))) {
                for (Question question : quiz) {
                    writer.write(question.toString());
                    writer.newLine(); 
                }
             
                writer.close();
            } catch (IOException errorr) {
               System.out.println(errorr);
            }
        }
       try(BufferedWriter writer2 = new BufferedWriter(new FileWriter("quizTiming.txt"))) {
            writer2.write(textfieldOfCourse.getText() + "\n");
            writer2.write(comboBox.getSelectedItem().toString() + "\n");
            writer2.write(comboBox2.getSelectedItem().toString());
            writer2.close();

       } catch (Exception err) {
        System.out.println(err);
    }
    if(e.getSource() == button2){
        this.dispose();
        new TeacherScreen();
    }
    }
}
