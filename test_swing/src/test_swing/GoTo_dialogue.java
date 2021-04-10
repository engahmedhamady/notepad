
package test_swing;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class GoTo_dialogue  implements ActionListener
{
    JButton Goto,cancel;
    notepad notepad;
    JLabel larea1 ;
   static JTextField area1;

    JPanel button;
    JDialog go_to_Dialog ;
   GoTo_dialogue  (JFrame frame , int linenumber)
           
   {
              
               area1 = new JTextField();
               area1.setText(Integer.toString(linenumber));
              area1.setPreferredSize(new Dimension(250,20));
               larea1 = new JLabel("Line Number:");
               larea1.setPreferredSize(new Dimension(250,20));
         //___________________________button panel________________
          button = new JPanel(new FlowLayout(HEIGHT,10, 10));
            button.setPreferredSize(new Dimension(250,80));
             button.setFont(new Font("Verdana", Font.ITALIC, 12));
             cancel = new JButton("Cancel");
             cancel.setFont(new Font("Verdana", Font.BOLD, 10));
              cancel.setPreferredSize(new Dimension(80,25));
              Goto = new JButton("Go To");
             Goto.setFont(new Font("Verdana", Font.BOLD, 10));
              Goto.setPreferredSize(new Dimension(80,25));
               button.add(Goto);
               button.add(cancel);
       //_________________________________________________________
           go_to_Dialog = new JDialog(frame,"Go To Line",ModalityType.MODELESS);
             go_to_Dialog.setLayout(new FlowLayout(HEIGHT, 10,10));  
              go_to_Dialog.add(larea1);
              go_to_Dialog.add(area1);
             go_to_Dialog.add(button);
              go_to_Dialog.setSize(300,160);
             go_to_Dialog.setVisible(true);
        //__________________________________________________
        Goto.addActionListener(this);
        cancel.addActionListener(this);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel)
        {    
            go_to_Dialog.dispose();
        }
         if (e.getSource()==Goto)
        { 
            try {
             int linenum =Integer.parseInt(area1.getText()); 
             notepad.area.setCaretPosition( notepad.area.getLineStartOffset(linenum-1));
            } catch (BadLocationException ex) {
                Logger.getLogger(GoTo_dialogue.class.getName()).log(Level.SEVERE, null, ex);
            }
             go_to_Dialog.dispose(); 
        }
}  
}