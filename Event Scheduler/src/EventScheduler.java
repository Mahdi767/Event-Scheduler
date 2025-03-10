import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.awt.Color;
import java.awt.Font;


public class EventScheduler {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Event Scheduler");
        frame.setLayout(null);
   

        // Left side front End
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Event Title", "Description", "Date", "Time", "Duration"});
        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 400, 500);
        frame.add(scrollPane);

        JButton button1 = new JButton("Save as .txt file");
        
        button1.setBounds(20, 525, 150, 30); // Positioned below the scroll pane
        button1.setBackground(new Color(8, 102, 255));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 12)); 
 
        frame.add(button1);

        JButton button2 = new JButton("Save as .xlsx file");
        button2.setBounds(180, 525, 150, 30); // Positioned below button1 with a gap
        button2.setBackground(new Color(8, 102, 255));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 12)); 
        frame.add(button2);


// Right-side Panel
JPanel rPanel = new JPanel();
// rightPanel.setLayout(new GridLayout(7, 2, 10, 10)); // 7 rows, 2 columns, with gaps
rPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

// Input Fields
JLabel eventTLabel = new JLabel("Event Title:");
JTextField eventTField = new JTextField();
rPanel.add(eventTLabel);
rPanel.add(eventTField);

JLabel descriptionLabel = new JLabel("Description:");
JTextField descriptionField = new JTextField();
rPanel.add(descriptionLabel);
rPanel.add(descriptionField);

JLabel dateLabel = new JLabel("Date:");
JTextField dateField = new JTextField();
rPanel.add(dateLabel);
rPanel.add(dateField);

JLabel timeLabel = new JLabel("Time:");
JTextField timeField = new JTextField();
rPanel.add(timeLabel);
rPanel.add(timeField);

JLabel durationLabel = new JLabel("Duration:");
JTextField durationField = new JTextField();
rPanel.add(durationLabel);
rPanel.add(durationField);

// Buttons
JButton addButton = new JButton("Add Event");
JButton updateButton = new JButton("Update Event");
rPanel.add(addButton);
rPanel.add(updateButton);

// Right side front end
// Event
JLabel Label1 = new JLabel("Event Title:");
Label1.setBounds(440, 20, 100, 30);

JTextField Fields1 = new JTextField();
Fields1.setBounds(440, 50, 200, 30);
frame.add(Label1);
frame.add(Fields1);

// Description
JLabel Label2 = new JLabel("Description:");
Label2.setBounds(440, 100, 100, 30); 
frame.add(Label2);

JTextField Fields2 = new JTextField();
Fields2.setBounds(440, 130, 200, 30); 
frame.add(Fields2);

// Date
JLabel Label3 = new JLabel("Date:");
Label3.setBounds(440, 180, 100, 30); 
frame.add(Label3);

SpinnerDateModel dateModel = new SpinnerDateModel();

JSpinner dateSpinner = new JSpinner(dateModel);
dateSpinner.setBounds(440, 210, 200, 30);
frame.add(dateSpinner); 
JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner,"dd-MM-yyyy");
dateSpinner.setEditor(dateEditor);  //Setting date editor for date spinner
// Time
JLabel Label4 = new JLabel("Time:");
Label4.setBounds(440, 260, 100, 30); 
frame.add(Label4);

SpinnerDateModel timeModel = new SpinnerDateModel(); //Manage date and time
JSpinner spinner = new JSpinner(timeModel);//Selecting time through spinner
spinner.setBounds(440, 290, 200, 30); 
frame.add(spinner);
JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, "HH:mm a");
spinner.setEditor(timeEditor);  


 



// Duration
JLabel Label5 = new JLabel("Duration:");
Label5.setBounds(440, 340, 100, 30);
frame.add(Label5);

JTextField Fields5 = new JTextField();
Fields5.setBounds(440, 370, 200, 30);
frame.add(Fields5);

// Buton for left side front end
JButton button3 = new JButton("Create Event");
button3.setBounds(450, 525, 150, 30);
button3.setBackground(new Color(8, 102, 255));
button3.setForeground(Color.WHITE);
button3.setFont(new Font("Arial", Font.BOLD, 12));     
frame.add(button3);
frame.setVisible(true);


JButton button4 = new JButton("Modify Event");
button4.setBounds(620, 525, 150, 30);
button4.setBackground(new Color(8, 102, 255));
button4.setForeground(Color.WHITE);
button4.setFont(new Font("Arial", Font.BOLD, 12));     
frame.add(button4);
frame.setVisible(true);



    }
}
