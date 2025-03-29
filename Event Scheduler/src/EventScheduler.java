import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.text.DateFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventScheduler {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Event Scheduler");
        frame.setLayout(null);
        frame.setResizable(false);

        JPanel backGrounfJPanel = new JPanel();
        backGrounfJPanel.setBackground(new Color(252, 239, 232));
        backGrounfJPanel.setLayout(null);
        frame.setContentPane(backGrounfJPanel);
      
   

 // Left side front End
// Make the table non-editable but selectable
DefaultTableModel model = new DefaultTableModel(new String[]{"Event Title", "Description", "Date", "Time", "Duration"}, 0) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Disable editing in table cells
    }
};

JTable table = new JTable(model);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow single row selection
table.getTableHeader().setReorderingAllowed(false);




table.setForeground(Color.BLACK);
JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setBounds(20, 20, 400, 500);
scrollPane.getViewport().setBackground(new Color(255, 253, 209));
frame.add(scrollPane);


// Table header
JTableHeader tableHeader = table.getTableHeader();
tableHeader.setBackground(Color.YELLOW); // Set background color for the header
tableHeader.setForeground(Color.BLACK);
// frame.add(tableHeader);

        JButton button1 = new JButton("Save as .txt file");
        button1.setBounds(20, 525, 150, 30); // Positioned below the scroll pane
        button1.setBackground(new Color(8, 102, 255));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 12)); 
        frame.add(button1);

        JButton button2 = new JButton("Save as .csv file");
        button2.setBounds(180, 525, 150, 30); // Positioned below button1 with a gap
        button2.setBackground(new Color(8, 102, 255));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 12)); 
        frame.add(button2);



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
JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, "hh:mm a");
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
button3.setBounds(450, 485, 150, 30);
button3.setBackground(new Color(66, 183, 42));
button3.setForeground(Color.WHITE);
button3.setFont(new Font("Arial", Font.BOLD, 12));     
frame.add(button3);
frame.setVisible(true);


JButton button4 = new JButton("Modify Event");
button4.setBounds(620, 485, 150, 30);
button4.setBackground(new Color(66, 183, 42));

button4.setForeground(Color.WHITE);
button4.setFont(new Font("Arial", Font.BOLD, 12));     
frame.add(button4);

JButton button5 = new JButton("Delete Event");
button5.setBounds(620, 525, 150, 30);
button5.setBackground(new Color(255, 0, 51));
//rgb(255, 0, 51)

button5.setForeground(Color.WHITE);
button5.setFont(new Font("Arial", Font.BOLD, 12));     
frame.add(button5);





// Back-End create event 
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
        try {
          
            String title = Fields1.getText().trim();
            String description = Fields2.getText().trim();
            String date = dateEditor.getFormat().format(dateSpinner.getValue());
            String time = timeEditor.getFormat().format(spinner.getValue());
            String duration = Fields5.getText().trim();
    
            // Check if any field is empty & a warnning message
            if (title.isEmpty() || description.isEmpty() || date.isEmpty() || time.isEmpty() || duration.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields before creating an event!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
    
            // Add the event details to the table
            model.addRow(new Object[]{title, description, date, time, duration});
    
            // Clear the input fields after adding the event
            Fields1.setText("");
            Fields2.setText("");
            Fields5.setText("");
    //If successfully event can add on the table then this message will appear
            JOptionPane.showMessageDialog(frame, "Event Created Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "An error occurred while creating the event.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

       
// For save as .txt file Backend
button1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, 
                "Please add some events before saving!", 
                "Warning", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save as .txt file");

            int userSelection = fileChooser.showSaveDialog(frame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();//location for saving the file

                if (!fileToSave.getName().toLowerCase().endsWith(".txt")) {
                    fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".txt");
                }

                java.io.FileWriter writer = new java.io.FileWriter(fileToSave);

                // maximum length for each column (including headers)
                int[] columnWidths = new int[model.getColumnCount()];
                for (int col = 0; col < model.getColumnCount(); col++) {
                    // Start with the length of the column header
                    columnWidths[col] = model.getColumnName(col).length();
                    //longest string in each column
                    for (int row = 0; row < model.getRowCount(); row++) {
                        String cellValue = model.getValueAt(row, col).toString();
                        if (cellValue.length() > columnWidths[col]) {
                            columnWidths[col] = cellValue.length();
                        }
                    }
                }

                // Wri column headers
                for (int col = 0; col < model.getColumnCount(); col++) {
                    writer.write(String.format("%-" + (columnWidths[col] + 2) + "s", model.getColumnName(col)));
                }
                writer.write("\n");

                // Writ data rows with adjusted col width
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        writer.write(String.format("%-" + (columnWidths[j] + 2) + "s", model.getValueAt(i, j)));//%-Xs--> reserves X spaces.


                    }
                    writer.write("\n");
                }

                writer.close();
                JOptionPane.showMessageDialog(frame, "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});



// modify button back-end
 int[] row_modify = {-1}; // -1 means row_modify hoy ni
button4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // If no row is modified--> load selected event 
        if (row_modify[0] == -1) {
            int selected_Row = table.getSelectedRow();
            
            if (selected_Row >= 0) {
                try {
                    
                    Fields1.setText(model.getValueAt(selected_Row, 0).toString()); // Event Title-->get data--> fill the text fields
                    Fields2.setText(model.getValueAt(selected_Row, 1).toString()); // Description-->get data-->fill the text fields
                    
                    // sameway te date
                    String dateStr = model.getValueAt(selected_Row, 2).toString();
                    java.util.Date date = dateEditor.getFormat().parse(dateStr);
                    dateSpinner.setValue(date);
                    
                    // taking the date
                    String timeStr = model.getValueAt(selected_Row, 3).toString();
                    java.util.Date time = timeEditor.getFormat().parse(timeStr);//parse-->text er shuru theke sesh
                    spinner.setValue(time);
                    
                    Fields5.setText(model.getValueAt(selected_Row, 4).toString()); // Duration
                    
                    // Mark this row as--->> modified
                    row_modify[0] = selected_Row;
                    
                    JOptionPane.showMessageDialog(frame, 
                        "Event data loaded. Edit the fields and click 'Modify Event' again to save changes.",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error loading event data: " + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    // ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(frame, 
                    "Please select an event to modify!", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } 
        // If a row is already modified
        else {
            try {
                String title = Fields1.getText().trim();
                String description = Fields2.getText().trim();
                String date = dateEditor.getFormat().format(dateSpinner.getValue());
                String time = timeEditor.getFormat().format(spinner.getValue());
                String duration = Fields5.getText().trim();

                // Check if any field is empty
                if (title.isEmpty() || description.isEmpty() || date.isEmpty() || 
                    time.isEmpty() || duration.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Please fill in all fields before saving changes!", 
                        "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Update-->> existing row in the table
                int row = row_modify[0];
                model.setValueAt(title, row, 0);
                model.setValueAt(description, row, 1);
                model.setValueAt(date, row, 2);
                model.setValueAt(time, row, 3);
                model.setValueAt(duration, row, 4);

                // Clear --> fields & reset --> tracker
                Fields1.setText("");
                Fields2.setText("");
                Fields5.setText("");
                row_modify[0] = -1;

                JOptionPane.showMessageDialog(frame, 
                    "Event Modified Successfully!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, 
                    "Error saving modified event: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
                    // ex.printStackTrace();
            }
        }
    }
});


//Back-end delete button
button5.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int selectedRow = table.getSelectedRow();
            
            if (selectedRow >= 0) {
                // Confirm deletion with user
                int confirmation = JOptionPane.showConfirmDialog(frame, 
                    "Are you sure you want to delete this event?", 
                    "Confirm Deletion", 
                    JOptionPane.YES_NO_OPTION);
                
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Remove the selected row from the table model
                    model.removeRow(selectedRow);
                    
                    // Clear the input fields
                    Fields1.setText("");
                    Fields2.setText("");
                    Fields5.setText("");
                    
                    JOptionPane.showMessageDialog(frame, 
                        "Event deleted successfully!", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, 
                    "Please select an event to delete!", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, 
                "Error deleting event: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            // ex.printStackTrace();
        }
    }
});



//Back-end for ms excel file
// Action for saving data to CSV
button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, 
                "Please add some events before saving!", 
                "Warning", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save as .csv file");

            int userSelection = fileChooser.showSaveDialog(frame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();

                if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
                    fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".csv");
                }

                java.io.FileWriter writer = new java.io.FileWriter(fileToSave);

                // Write the column headers
                for (int col = 0; col < model.getColumnCount(); col++) {
                    writer.write(model.getColumnName(col));
                    if (col < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");

                // Write the data rows
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        String cellData = model.getValueAt(i, j).toString();
                        
                        // Handle long text
                        if (cellData.contains(",") || cellData.contains("\n") || cellData.contains("\"")) {
                            cellData = "\"" + cellData.replace("\"", "\"\"") + "\""; // Escape quotes
                        }
                        
                        writer.write(cellData); // Cell values
                        if (j < model.getColumnCount() - 1) {
                            writer.write(",");
                        }
                    }
                    writer.write("\n");
                }

                writer.close();
                JOptionPane.showMessageDialog(frame, "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});



frame.setVisible(true);



    }
}
