
package Course;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuizPage extends JFrame implements ActionListener {
    JPanel panel1, panel2;
    JLabel label, label2, label3, label4;
    String CourseName;
    JButton button, button2;
    ArrayList<JCheckBox> checkBoxes; 
    ButtonGroup checkBoxGroup;
    ArrayList<String> Question;
    ArrayList<String> rightAnswer;

    public QuizPage() {
        Question = new ArrayList<>();
        button2 = new JButton("Finish Quiz");
        panel1 = new JPanel();
        panel2 = new JPanel();
        label = new JLabel("Student Console");
        label3 = new JLabel("Course Teacher: Miss Sumaira");
        label2 = new JLabel("GOOD LUCK");
        this.setSize(800, 800);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        panel2.setLayout(null);
        panel1.add(label);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(button2);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        panel1.setBackground(Color.LIGHT_GRAY);
        label2.setBounds(20, 10, 430, 20);
        label3.setBounds(20, 30, 190, 20);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("quiz.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                Question.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        rightAnswer = new ArrayList<>();

        for (int i = 2; i < Question.size(); i += 2) {
            rightAnswer.add(Question.get(i));
            Question.remove(i);
        }
        
        int y = 90;
        int xx = 20;

        checkBoxes = new ArrayList<>(); 

        for (int i = 0; i < Question.size(); i++) {
            int yy = y;

            if (i % 2 == 0) {
                JCheckBox checkBox1 = new JCheckBox(); 
                checkBox1.setBounds(xx, yy + 20, 20, 30);
                JCheckBox checkBox2 = new JCheckBox();
                checkBox2.setBounds(xx + 20, yy + 20, 20, 30);
                JCheckBox checkBox3 = new JCheckBox();
                checkBox3.setBounds(xx + 40, yy + 20, 20, 30);
                JCheckBox checkBox4 = new JCheckBox();
                checkBox4.setBounds(xx + 60, yy + 20, 20, 30);

                checkBoxGroup = new ButtonGroup();
                checkBoxGroup.add(checkBox1);
                checkBoxGroup.add(checkBox2);
                checkBoxGroup.add(checkBox3);
                checkBoxGroup.add(checkBox4);

                panel2.add(checkBox1);
                panel2.add(checkBox2);
                panel2.add(checkBox3);
                panel2.add(checkBox4);
                yy += 50;

                checkBoxes.add(checkBox1);
                checkBoxes.add(checkBox2);
                checkBoxes.add(checkBox3);
                checkBoxes.add(checkBox4);
            }
            JLabel label4 = new JLabel();
            label4.setText(Question.get(i));
            label4.setBounds(20, y, 500, 15);
            panel2.add(label4);
            y += 50;
        }
        button2.addActionListener(this);
        button2.setBounds(20, y + 30, 140, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {

            ArrayList<String> Answer = new ArrayList<>();
            for (int i = 0; i < checkBoxes.size(); i++) {
                JCheckBox checkBox = checkBoxes.get(i);
                boolean isSelected = checkBox.isSelected();

               
                if (isSelected) {
                    Answer.add(Integer.toString(i % 4));
                }
            }
            int marks = 0;
            for (int i = 0; i < rightAnswer.size(); i++) {
                if (rightAnswer.get(i).equals(Answer.get(i))) {
                    marks++;
                }
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("QuizMarks.txt"));
                writer.write(Integer.toString(marks));
                writer.close();
            } catch (Exception err) {
                System.out.println(err);
            }
            JOptionPane.showMessageDialog(null, "Marks :" +  marks);
        }
    }

}
