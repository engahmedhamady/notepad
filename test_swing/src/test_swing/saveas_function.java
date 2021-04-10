
package test_swing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import static test_swing.notepad.area;
import static test_swing.notepad.frame;

public class saveas_function  {
     saveas_function()
    {
        JFileChooser fsa = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
          int retval = fsa.showSaveDialog(frame);
          if (retval == JFileChooser.APPROVE_OPTION) 
          {
              File file = fsa.getSelectedFile();
             
              String text = area.getText();
              try 
              {
                  FileWriter fw = new FileWriter(file+".txt");
                   BufferedWriter bw = new  BufferedWriter (fw);
                  bw.write(text);
                  bw.flush();
                  bw.close();
                  area.setText("");
              }
              catch (IOException ex)
              {
                  Logger.getLogger(saveas_function.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
       }
    
    
    }
    

