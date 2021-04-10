
package test_swing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class save_function extends notepad{
       save_function ()
       {
                
               filename = f.getName();
              if (!filename.equals("Untitled"))
              {
                 String text = (area.getText());
                 FileWriter fwd;
                 try
                 {
                      fwd = new FileWriter(f);
                      BufferedWriter bwd = new  BufferedWriter (fwd);
                      bwd.write("");
                      PrintWriter fwr = new PrintWriter(fwd,true);
                      BufferedWriter bwr = new  BufferedWriter (fwr);  
                      String[] strings = text.split("\n");
                      for (String s : strings)
                      {
                         bwr.write(s);
                         bwr.newLine();  
                      }
                      bwr.flush();
                      bwr.close();
                 }
                 catch (IOException ex) 
                 {
                      Logger.getLogger(save_function.class.getName()).log(Level.SEVERE, null, ex);
                 } 
              }
              else
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
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(save_function.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
              }
       }
}
    

