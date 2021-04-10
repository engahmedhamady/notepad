
package test_swing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;
import static test_swing.notepad.f; 
import static test_swing.notepad.filename;
public class open_function 
{  
    String s1,s2;
    public open_function ()
    {
       
        JFileChooser fc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());    
            int i=fc.showOpenDialog(notepad.frame);    
            if(i==JFileChooser.APPROVE_OPTION)
            { 
               f=fc.getSelectedFile();   
                try{ 
                    
                String filepath=notepad.f.getPath();
               filename = notepad.f.getName();
              
           
                try
                {   notepad.frame.setTitle(notepad.filename+"ahmedpad");
                    BufferedReader br=new BufferedReader(new FileReader(notepad.f));    
                                           
                    while((s1=br.readLine())!=null)
                    {    
                        s2+=s1+"\n";    
                    }    
                    //area.setText(s2); 
                    notepad.area.setText(s2);
                    br.close();    
                }
                catch (Exception ex) 
                {
                    ex.printStackTrace(); 
                }
                 }catch(NullPointerException ex){}
            }
       
    
    }
}
