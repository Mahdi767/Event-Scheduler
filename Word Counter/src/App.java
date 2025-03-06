import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class App {
    public static void main(String[] args) throws Exception {

    // This portion is for frame..!
JFrame frame = new JFrame();
        frame.setTitle("Word counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.white);
        frame.setSize(600, 600);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter your text:");
        label.setBounds(5, 10, 200, 20);
        frame.add(label);

      
        JTextArea textArea = new JTextArea();
        textArea.setBounds(30, 80, 350, 350);
        textArea.setBackground(new Color(255, 253, 208));
        textArea.setLineWrap(true); 
        textArea.setWrapStyleWord(true); 
        textArea.requestFocus();

       
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 80, 350, 350);
        frame.add(scrollPane);



        // This is for Button
        JButton button = new JButton("Count words");
        button.setBounds(400, 90, 150, 30); 
        button.setBackground(new Color(135, 206, 250)); 
        button.setForeground(Color.BLACK); 
        button.setFocusPainted(false); 
        frame.add(button);

        JButton button1 = new JButton("Count Sentence");
        button1.setBounds(400, 130, 150, 30); 
        button1.setBackground(new Color(135, 206, 250)); 
        button1.setForeground(Color.BLACK); 
        button1.setFocusPainted(false); 
        frame.add(button1);


        JButton button2 = new JButton("Count Characters");
        button2.setBounds(400, 170, 150, 30); 
        button2.setBackground(new Color(135, 206, 250)); 
        button2.setForeground(Color.BLACK); 
        button2.setFocusPainted(false); 
        frame.add(button2);

        JButton button3 = new JButton("Count lines");
        button3.setBounds(400, 210, 150, 30); 
        button3.setBackground(new Color(135, 206, 250));
        button3.setForeground(Color.BLACK); 
        button3.setFocusPainted(false); 
        frame.add(button3);


        JButton button4 = new JButton("See All Stats");
        button4.setBounds(400, 250, 150, 30); 
        button4.setBackground(new Color(135, 206, 250)); 
        button4.setForeground(Color.BLACK); 
        button4.setFocusPainted(false); 
        frame.add(button4);








    
    

    

   
    




 









    
    frame.setVisible(true);

    }
}
