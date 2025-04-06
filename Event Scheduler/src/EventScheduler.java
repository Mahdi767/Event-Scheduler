import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.text.DateFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventScheduler {
    public EventScheduler() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Event Scheduler");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        JPanel backGrounfJPanel = new JPanel();
        backGrounfJPanel.setBackground(new Color(250, 250, 250));
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




table.setForeground( new Color(44, 62, 80));
JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setBounds(20, 20, 400, 500);
scrollPane.getViewport().setBackground(new Color(236, 240, 241));
frame.add(scrollPane);


// Table header
JTableHeader tableHeader = table.getTableHeader();
 // Set background color for the header
tableHeader.setForeground(Color.WHITE);
tableHeader.setBackground(new Color(44, 62, 80)); // Light yellow background
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



JLabel titleErrorLabel = new JLabel("Required");
titleErrorLabel.setForeground(Color.RED);
titleErrorLabel.setBounds(650, 50, 100, 30);
titleErrorLabel.setVisible(false);
frame.add(titleErrorLabel);

JLabel descriptionErrorLabel = new JLabel("Required");
descriptionErrorLabel.setForeground(Color.RED);
descriptionErrorLabel.setBounds(650, 130, 100, 30);
descriptionErrorLabel.setVisible(false);
frame.add(descriptionErrorLabel);

JLabel dateErrorLabel = new JLabel("Required");
dateErrorLabel.setForeground(Color.RED);
dateErrorLabel.setBounds(650, 210, 100, 30);
dateErrorLabel.setVisible(false);
frame.add(dateErrorLabel);

JLabel timeErrorLabel = new JLabel("Required");
timeErrorLabel.setForeground(Color.RED);
timeErrorLabel.setBounds(650, 290, 100, 30);
timeErrorLabel.setVisible(false);
frame.add(timeErrorLabel);

JLabel durationErrorLabel = new JLabel("Required");
durationErrorLabel.setForeground(Color.RED);
durationErrorLabel.setBounds(650, 370, 100, 30);
durationErrorLabel.setVisible(false);
frame.add(durationErrorLabel);



JLabel createSuccessLabel = new JLabel("Event created successfully!");
createSuccessLabel.setForeground(new Color(26, 92, 27)); // Green color for success
createSuccessLabel.setBounds(450, 455, 200, 20); // Position above the button
createSuccessLabel.setVisible(false); // Initially hidden
frame.add(createSuccessLabel);

JLabel deleteSuccessLabel = new JLabel("Event deleted!");
deleteSuccessLabel.setForeground(new Color(255, 0, 51)); // Red color for delete message
deleteSuccessLabel.setBounds(470, 525, 150, 20); // Position to the left of the "Delete Event" button
deleteSuccessLabel.setVisible(false); // Initially hidden
frame.add(deleteSuccessLabel);
// Not selected
JLabel modifyWarningLabel = new JLabel("No event selected!");
modifyWarningLabel.setForeground(Color.RED);
modifyWarningLabel.setBounds(620, 460, 150, 20); // Position above the button
modifyWarningLabel.setVisible(false); // Initially hidden
frame.add(modifyWarningLabel);

// ok the event
JLabel modifyIsOk = new JLabel("Event selected!");
modifyIsOk.setForeground(new Color(26, 92, 27));
modifyIsOk.setBounds(620, 460, 150, 20); // Position above the button
modifyIsOk.setVisible(false); // Initially hidden
frame.add(modifyIsOk);

JLabel modifySuccessfully = new JLabel("Event Modified!");
modifySuccessfully.setForeground(new Color(26, 92, 27));
modifySuccessfully.setBounds(620, 460, 150, 20); // Position above the button
modifySuccessfully.setVisible(false); // Initially hidden
frame.add(modifySuccessfully);


// Back-End create event 
button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
        deleteSuccessLabel.setVisible(false);
        titleErrorLabel.setVisible(false);
        descriptionErrorLabel.setVisible(false);
        dateErrorLabel.setVisible(false);
        timeErrorLabel.setVisible(false);
        durationErrorLabel.setVisible(false);
        try {
          
            String title = Fields1.getText().trim();
            String description = Fields2.getText().trim();
            String date = dateEditor.getFormat().format(dateSpinner.getValue());
            String time = timeEditor.getFormat().format(spinner.getValue());
            String duration = Fields5.getText().trim();
    
            // Check if any field is empty & a warnning message
            boolean hasError = false;

            // Validate each field and show error messages
            if (title.isEmpty()) {
                titleErrorLabel.setVisible(true);
                hasError = true;
            }
            if (description.isEmpty()) {
                descriptionErrorLabel.setVisible(true);
                hasError = true;
            }
            if (date.isEmpty()) {
                dateErrorLabel.setVisible(true);
                hasError = true;
            }
            if (time.isEmpty()) {
                timeErrorLabel.setVisible(true);
                hasError = true;
            }
            if (duration.isEmpty()) {
                durationErrorLabel.setVisible(true);
                hasError = true;
            }

            if (hasError) {
                return; // Stop execution if there are errors
            }
    
            // Add the event details to the table
            model.addRow(new Object[]{title, description, date, time, duration});
    
            // Clear the input fields after adding the event
            Fields1.setText("");
            Fields2.setText("");
            Fields5.setText("");
    //If successfully event can add on the table then this message will appear
    modifyWarningLabel.setVisible(false);
    deleteSuccessLabel.setVisible(false);
            modifySuccessfully.setVisible(false); // Hide success message
            modifyIsOk.setVisible(false);
            createSuccessLabel.setVisible(false); // Hide success message
            createSuccessLabel.setText("Event created successfully!");
    createSuccessLabel.setVisible(true);
    
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
        // Hide all error labels to ensure they don't appear unnecessarily
       
        titleErrorLabel.setVisible(false);
        descriptionErrorLabel.setVisible(false);
        dateErrorLabel.setVisible(false);
        timeErrorLabel.setVisible(false);
        durationErrorLabel.setVisible(false);

        modifyWarningLabel.setVisible(false); // Hide the warning label initially

        // If no row is modified --> load selected event
        if (row_modify[0] == -1) {
            int selected_Row = table.getSelectedRow();

            if (selected_Row >= 0) {
                try {
                    // Retrieve data from the selected row and set it in the input fields
                    Fields1.setText(model.getValueAt(selected_Row, 0).toString()); // Event Title
                    Fields2.setText(model.getValueAt(selected_Row, 1).toString()); // Description

                    // Parse and set the date
                    String dateStr = model.getValueAt(selected_Row, 2).toString();
                    java.util.Date date = dateEditor.getFormat().parse(dateStr);
                    dateSpinner.setValue(date);

                    // Parse and set the time
                    String timeStr = model.getValueAt(selected_Row, 3).toString();
                    java.util.Date time = timeEditor.getFormat().parse(timeStr);
                    spinner.setValue(time);

                    // Set the duration
                    Fields5.setText(model.getValueAt(selected_Row, 4).toString()); // Duration

                    // Mark this row as modified
                    row_modify[0] = selected_Row;
                    button4.setText("Update Event"); // Change button text to "Save Changes"

                    // Reset visibility of success and warning labels
                    deleteSuccessLabel.setVisible(false);
                    createSuccessLabel.setVisible(false);
                    modifySuccessfully.setVisible(false); // Hide success message
                    modifyIsOk.setVisible(true); // Show success message
                } catch (Exception ex) {
                    System.err.println("Error loading event data: " + ex.getMessage());
                }
            } else {
                // Show warning if no row is selected
                deleteSuccessLabel.setVisible(false);
                createSuccessLabel.setVisible(false);
                modifyWarningLabel.setVisible(true);
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
               
                boolean hasEr = false;

                // Validate each field and show error messages
                if (title.isEmpty()) {
                    titleErrorLabel.setVisible(true);
                    hasEr = true;
                }
                if (description.isEmpty()) {
                    descriptionErrorLabel.setVisible(true);
                    hasEr = true;
                }
                if (date.isEmpty()) {
                    dateErrorLabel.setVisible(true);
                    hasEr = true;
                }
                if (time.isEmpty()) {
                    timeErrorLabel.setVisible(true);
                    hasEr = true;
                }
                if (duration.isEmpty()) {
                    durationErrorLabel.setVisible(true);
                    hasEr = true;
                }
    
                if (hasEr) {
                    return; // Stop execution if there are errors
                }
            

                // Update the existing row in the table
                int row = row_modify[0];
                model.setValueAt(title, row, 0);
                model.setValueAt(description, row, 1);
                model.setValueAt(date, row, 2);
                model.setValueAt(time, row, 3);
                model.setValueAt(duration, row, 4);

                // Clear the fields and reset the tracker
                Fields1.setText("");
                Fields2.setText("");
                Fields5.setText("");
                row_modify[0] = -1;

                button4.setText("Modify Event");

                // Reset visibility of success and warning labels
                deleteSuccessLabel.setVisible(false);
                createSuccessLabel.setVisible(false);
                modifyIsOk.setVisible(false); // Hide success message
                modifySuccessfully.setVisible(true); // Show success message
            } catch (Exception ex) {
                System.err.println("Error saving modified event: " + ex.getMessage());
            }
        }
    }
});


//Back-end delete button



button5.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        deleteSuccessLabel.setVisible(false);
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
                    

                    createSuccessLabel.setVisible(false);
                    modifySuccessfully.setVisible(false); // Hide success message
                    modifyIsOk.setVisible(false);
                    deleteSuccessLabel.setVisible(true);
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
