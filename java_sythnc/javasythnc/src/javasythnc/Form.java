package javasythnc;

import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
 
public class Form {
 
    private JFrame frame;
    JTextArea output;
    JTextArea textArea;
    
    
 
 
    public Form() {
        initialize();
        frame.setVisible(true);
        
    }
    public void addToFrame(String str)
    {
        output.append(str);
    }
    public void addToFrame2(String n)
    {
        textArea.append(n);
    }
    
    private void initialize() {
        frame = new JFrame("connections");
        frame.setBounds(100, 100, 901, 539);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel label = new JLabel("Connections: ");
        label.setBounds(86, 16, 767, 41);
        frame.getContentPane().add(label);
        JLabel lblConnectionBehaviour = new JLabel("Connection behaviour: ");
        lblConnectionBehaviour.setBounds(278, 88, 309, 29);
        frame.getContentPane().add(lblConnectionBehaviour);
        output = new JTextArea();
        output.setBounds(169, 125, 535, 308);
        output.setEditable(false);
        frame.getContentPane().add(output);
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(169, 24, 47, 22);
        frame.getContentPane().add(textArea);
    }
}