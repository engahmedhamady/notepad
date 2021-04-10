package test_swing;
import java.awt.BorderLayout;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class replace_dialogue implements DocumentListener , ActionListener
{notepad notepad;
     JButton find ,replace,replaceall,cancel;
     JLabel larea1,larea2 ;
     JTextField area1,area2;
     JCheckBox match;
     JPanel radio,text,button,west;
     JDialog replace_dialogue ;
     boolean b = false;
     String equal = null,a1="",a2="";
     replace_dialogue (JFrame frame)
     {
    //______________________button panel_______________________________
         button = new JPanel(new FlowLayout(HEIGHT,10, 10));
         button.setPreferredSize(new Dimension(100,170));
         button.setFont(new Font("Verdana", Font.ITALIC, 12));
         find = new JButton("Find Next");
         find.setFont(new Font("Verdana", Font.BOLD, 10));
         find.setPreferredSize(new Dimension(100,20));
         find.setEnabled(false);
         replace = new JButton("Replace");
         replace.setEnabled(false);
         replace.setFont(new Font("Verdana", Font.BOLD, 10));
         replace.setPreferredSize(new Dimension(100,20));
         replaceall = new JButton("Replace All");
         replaceall.setFont(new Font("Verdana", Font.BOLD, 10));
         replaceall.setPreferredSize(new Dimension(100,20));
         replaceall.setEnabled(false);
         cancel = new JButton("Cancel");
         cancel.setFont(new Font("Verdana", Font.BOLD, 10));
         cancel.setPreferredSize(new Dimension(100,20));
         button.add(find); 
         button.add(replace);
         button.add(replaceall);
         button.add(cancel);             
  //___________________________text panel_________________________________
         text = new JPanel(new FlowLayout());
         text.setPreferredSize(new Dimension(330,100));
         area1 = new JTextField(a1);
         area2 = new JTextField(a2);
         area1.setPreferredSize(new Dimension(205,30));
         area2.setPreferredSize(new Dimension(205,30));
         larea1 = new JLabel("Find What:");
         larea1.setPreferredSize(new Dimension(90,10));
         larea2 = new JLabel("Replace With:");
         larea2.setPreferredSize(new Dimension(90,10));
         text.add(larea1);
         text.add(area1);
         text.add(larea2);
         text.add(area2);
  //____________________________radio panel _______________________   
         radio = new JPanel(new BorderLayout(15,15));
         radio.setPreferredSize(new Dimension(100,30));           
         match = new JCheckBox("Case Match");
         match.setPreferredSize(new Dimension(100,20));
         radio.add(match,BorderLayout.WEST);
 //______________________west panel_________________________________
         west = new JPanel(new FlowLayout((int)LEFT_ALIGNMENT));
         west.setPreferredSize(new Dimension(350,155));
         west.add(text);
         west.add(radio);
//____________________find dialogue________________________________
         replace_dialogue = new JDialog(frame,"Find",false);
         replace_dialogue.setLayout(new FlowLayout(HEIGHT,10,10));
         replace_dialogue.add(west,FlowLayout.LEFT);
         replace_dialogue.add(button);  
         replace_dialogue.setSize(500,200);
         replace_dialogue.setVisible(true);
//_____________________________________________________
         area1.getDocument().addDocumentListener(this); 
         cancel.addActionListener(this);
         find.addActionListener(this);
         replace.addActionListener(this);
         replaceall.addActionListener(this);
//+______________________________________________________________
     }
     @Override
     public void changedUpdate(DocumentEvent e)
     {
        checkFieldsFull();
     }
     @Override
     public void insertUpdate(DocumentEvent e)
     {
        checkFieldsFull();
     }
     @Override
     public void removeUpdate(DocumentEvent e)
     {
        checkFieldsFull();
     }
     private void checkFieldsFull()
     {
        if (area1.getText().trim().isEmpty())
        {
           find.setEnabled(false);
           replace.setEnabled(false);
           replaceall.setEnabled(false);
           return;
        }
        find.setEnabled(true);
        replace.setEnabled(true);
        replaceall.setEnabled(true);
     }
     @Override
     public void actionPerformed(ActionEvent e)
     {
        if (e.getSource()== cancel)
        {  a1=area1.getText();
           a2= area2.getText();
          replace_dialogue.dispose();
        }
        if(e.getSource()== find)
        {
            String text_ta;
            String text_tf;
            int start;        
            try
            {
               if(match.isSelected())
               {
                    start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().substring(start);
                    text_tf = area1.getText();
                    if (text_ta.contains(text_tf))
                    {   
                         notepad.area.select(  start+text_ta.indexOf(text_tf) ,start+text_ta.indexOf(text_tf)+text_tf.length() ); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(replace_dialogue,"Cannot find  "
                                +(char) 34+area1.getText()+(char) 34);
                    }
               }
               else
               {
                    start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().toLowerCase().substring(start); 
                    text_tf = area1.getText().toLowerCase();
                    if (text_ta.contains(text_tf))
                    {   
                         notepad.area.select(  start+text_ta.indexOf(text_tf) ,start+text_ta.indexOf(text_tf)+text_tf.length() ); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(replace_dialogue,"Cannot find  "
                                +(char) 34+area1.getText()+(char) 34);
                    } 
               }
            }
            catch (StringIndexOutOfBoundsException ex)
            {
                JOptionPane.showMessageDialog(replace_dialogue,"Cannot find  "
                                +(char) 34+area1.getText()+(char) 34);        
            }
        }
        if (e.getSource()==replaceall)
        {
            notepad.area.setText(notepad.area.getText().replaceAll(area1.getText(),
                 area2.getText()));
        }
        if(e.getSource()== replace)
        {
            String text_ta;
            String text_tf;
            int start;
            try
            {
               if(match.isSelected())
               {    
                    start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().substring(start);
                    text_tf = area1.getText();
                    if (text_ta.contains(text_tf))
                    {   
                        if (null==(notepad.area.getSelectedText()))
                        {
                           notepad.area.select(  start + text_ta.indexOf(text_tf) ,
                                 start + text_ta.indexOf(text_tf)+text_tf.length() );
                        
                        }
                        else
                        {
                            if (notepad.area.getSelectedText().equals(area1.getText()))
                            {
                                 notepad.area.replaceSelection(area2.getText());
                                 start = notepad.area.getCaretPosition();
                             notepad.area.select(  start + text_ta.indexOf(text_tf) ,
                                 start + text_ta.indexOf(text_tf)+text_tf.length() );
                             
                            }
                            else
                            {
                               notepad.area.select(  start + text_ta.indexOf(text_tf) ,
                                 start + text_ta.indexOf(text_tf)+text_tf.length() );
                            }
                        }
                        
                       
                    }
                     else
                    {
                         notepad.area.replaceSelection(area2.getText());
                        JOptionPane.showMessageDialog(replace_dialogue,"Cannot find  "
                                +(char) 34+area1.getText()+(char) 34);
                    }
               }
            }
             catch (StringIndexOutOfBoundsException ex)
           {
               notepad.area.replaceSelection(area2.getText()); 
                JOptionPane.showMessageDialog(replace_dialogue,"Cannot find  "
                                +(char) 34+area1.getText()+(char) 34);             
           }
            try
            {
              if (!match.isSelected())    
              {
                    start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().toLowerCase().substring(start); 
                    text_tf = area1.getText().toLowerCase();
                    if (text_ta.contains(text_tf))
                    {   
                        if (null==(notepad.area.getSelectedText()))
                        {
                           notepad.area.select(  start + text_ta.indexOf(text_tf) ,
                                 start + text_ta.indexOf(text_tf)+text_tf.length() );
                        
                        }
                        else
                        {
                            if (notepad.area.getSelectedText().equals(area1.getText()))
                            {
                                 notepad.area.replaceSelection(area2.getText());
                                 start = notepad.area.getCaretPosition();
                             notepad.area.select(  start + text_ta.indexOf(text_tf) ,
                                 start + text_ta.indexOf(text_tf)+text_tf.length() );
                             
                            }
                            else
                            {
                               notepad.area.select(  start + text_ta.indexOf(text_tf) ,
                                 start + text_ta.indexOf(text_tf)+text_tf.length() );
                            }
                        }
                        
                       
                    }
                    else
                    {
                         notepad.area.replaceSelection(area2.getText());
                        JOptionPane.showMessageDialog(replace_dialogue,"Cannot find  "
                                +(char) 34+area1.getText()+(char) 34);
                    } 
               }
            }
             catch (StringIndexOutOfBoundsException ex)
           {
               notepad.area.replaceSelection(area2.getText()); 
                JOptionPane.showMessageDialog(replace_dialogue,"Cannot find  "
                                +(char) 34+area1.getText()+(char) 34);             
           }
            }}
            }
