
package test_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.RIGHT;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static test_swing.notepad.area;
import static test_swing.notepad.frame;
import static test_swing.notepad.saved;


public class save_dialogue  implements  ActionListener
{
      JDialog savedialogue ;
      JButton save,notsave,cancel;
       JPanel north,south,main;
      JTextArea text;
      String x= null;
     save_dialogue ()
     {
       
     //__________________north panel _______________________________________
        
        north = new JPanel(new BorderLayout());
        north.setBackground(Color.WHITE);
        north.setPreferredSize(new Dimension(380,55 ));
        text = new JTextArea (("  " + " Do you want tosave changes to"));
        text.setFont(new Font("Serif", Font.PLAIN, 20));
        text.setPreferredSize(new Dimension(380,70 ));
       
        text.setEditable(false);
        text.setForeground(Color.BLUE);
        text.setBackground(Color.white);
        north.add(text,BorderLayout.WEST);
        //____________________south panel_______________________________
         south= new JPanel(new FlowLayout((int) RIGHT,10,10));
        south.setPreferredSize(new Dimension(380,45 ));
         save = new JButton("Save");
         save.setFont(new Font("Serif", Font.PLAIN, 10));
         save.setPreferredSize(new Dimension(65,25));
          notsave = new JButton("Don’t Save");
          notsave.setFont(new Font("Serif", Font.PLAIN, 10));
         notsave.setPreferredSize(new Dimension(80,25  ));
          cancel = new JButton("Cancel");
          cancel.setFont(new Font("Serif", Font.PLAIN, 10));
         cancel.setPreferredSize(new Dimension(70,25 ));
         save.addActionListener(this);
         notsave.addActionListener(this);
         cancel.addActionListener(this);
         south.add(save);
         south.add(notsave);
         south.add(cancel);
    //____________________________main panel________________________________
         main = new JPanel(new BorderLayout());
         main.add(north,BorderLayout.NORTH);
         main.add(south,BorderLayout.SOUTH);
         main.setPreferredSize(new Dimension(380,145 ));
    //________________________su dialogue________________________________
         savedialogue = new JDialog();
        savedialogue .setSize(380,145);
         savedialogue .add(main);
         savedialogue .setVisible(true);
         
     }

      @Override
      public void actionPerformed(ActionEvent e) 
      {
                if ( e.getSource()==cancel)
                {
                      savedialogue.setVisible(false);
                     frame.setEnabled(true);
                     
                }
                if ( e.getSource()==save)
                {
                       savedialogue.setVisible(false);
                       frame.setEnabled(true);
                       if (saved==0)
                       {
                             new saveas_function();
                            
                       }
                        if (saved==1)
                       {
                            new save_function();
                       }
                }
                if ( e.getSource()==notsave)
                {
                       savedialogue.setVisible(false);
                       frame.setEnabled(true);
                       area.setText("");
                }
          
      }
}
