
package test_swing;
import java.awt.BorderLayout;
import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class find_dialogue 
      implements DocumentListener,ActionListener , ChangeListener
{  
    JButton find ,cancel;
    JRadioButton up,down; 
    JLabel larea ;
    JTextField area;
    JCheckBox match;
    JPanel radio1,radio2,radioall,text,button,west,east;
    JDialog find_dialogue ;
    notepad notepad;
      int i =0;
    find_dialogue (JFrame frame)
    {
         //________________text panel________________________________
           text = new JPanel(new FlowLayout(HEIGHT,10,10));
           text.setPreferredSize(new Dimension(305,40));
           area = new JTextField();
           
           area.setPreferredSize(new Dimension(205,30));
           larea = new JLabel("Find What:");
           larea.setPreferredSize(new Dimension(80,10));
           text.add(larea,FlowLayout.LEFT);
           text.add(area);
           //_______________button panel___________________
           button = new JPanel(new FlowLayout(HEIGHT,10, 10));
           button.setPreferredSize(new Dimension(100,140));         
           find = new JButton("Find Next"); 
           find.setEnabled(false);
           find.setPreferredSize(new Dimension(90,25));
           cancel = new JButton("Cancel");
           cancel.setPreferredSize(new Dimension(90,25));
           button.add(find); 
           button.add(cancel);
          //_________________radio1 panel_________________________
           radio1 = new JPanel(new FlowLayout((int)RIGHT_ALIGNMENT));
           radio1.setPreferredSize(new Dimension(80,20));
           TitledBorder border = new TitledBorder("Direction");
           border.setTitleJustification(TitledBorder.LEFT);
           border.setTitlePosition(TitledBorder.TOP);
           radio1.setBorder(border);         
           up = new JRadioButton("Up");
           up.setPreferredSize(new Dimension(40,15));
           down = new JRadioButton("Down");
           down.setSelected(true);
           down.setPreferredSize(new Dimension(70,15));
           ButtonGroup bg = new ButtonGroup();
           bg.add(up);
           bg.add(down);
           radio1.add(up);
           radio1.add(down);
     //_________________radio2 panel__________________________
           radio2 = new JPanel(new BorderLayout());
           radio2.setPreferredSize(new Dimension(105,30));
           match = new JCheckBox("Case Match");
           match.setPreferredSize(new Dimension(80,20));
           radio2.add(match,BorderLayout.CENTER);
     //___________________radioall panel_________________
           radioall = new JPanel(new BorderLayout());
           radioall.setPreferredSize(new Dimension(290,90)); 
           radioall.add(radio1,BorderLayout.CENTER);
           radioall.add(radio2,BorderLayout.WEST);
   //___________________________panel west ________________________
           west = new JPanel(new FlowLayout());
           west.setPreferredSize(new Dimension(395,155));
           west.add(text);
           west.add(radioall);
  //______________________________east panel_________________
           find_dialogue = new JDialog(frame,"Find",false);
           find_dialogue.setLayout(new FlowLayout());
           find_dialogue.add(west,FlowLayout.LEFT);
           find_dialogue.add(button);
           find_dialogue.setSize(530,200);
           find_dialogue.setVisible(true);
      //_________________________________________________________
        cancel.addActionListener(this);
        find.addActionListener(this);
        up.addChangeListener(this);
      area.getDocument().addDocumentListener(this); 
      
      //_______________________________________________________
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
    
      if (area.getText().trim().isEmpty())
      {
        find.setEnabled(false);
        return;
      }
    
    find.setEnabled(true);
  }
//_____________________________________________________________
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if (e.getSource()==cancel)
        {    
            find_dialogue.dispose();
         
        }
        if (e.getSource()==find)
        { 
          
            String text_ta;
            String text_tf;
            int start;
           if (up.isSelected())
           {
               try
               {
                   notepad.next= 0;
               }
               catch (NullPointerException ex)
               {
                   
               }
               if(match.isSelected())
               {
                   try
                   {
                       notepad.cases = true;
                   }
                   catch (NullPointerException ex)
                   {
                   
                   }

                    start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().substring(0,start+1);
                    text_tf = area.getText();
                    if (text_ta.contains(text_tf))
                    {   
                         notepad.area.select(text_ta.lastIndexOf(text_tf) 
                                 ,text_ta.lastIndexOf(text_tf)+text_tf.length() ); 
                         notepad.area.setCaretPosition(text_ta.lastIndexOf(text_tf)-1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(find_dialogue,"Cannot find  "
                                +(char) 34+area.getText()+(char) 34);
                    }
               }
               else
               {
                    try
                   {
                       notepad.cases = false;
                   }
                   catch (NullPointerException ex)
                   {
                   
                   }

                    start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().toLowerCase().substring(0,start+1); 
                    text_tf = area.getText().toLowerCase();
                    if (text_ta.contains(text_tf))
                    {   
                             notepad.area.select(  text_ta.lastIndexOf(text_tf) 
                                 ,text_ta.lastIndexOf(text_tf)+text_tf.length() ); 
                        notepad.area.setCaretPosition(start-1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(find_dialogue,"Cannot find  "
                                +(char) 34+area.getText()+(char) 34);
                    } 
               }
               
               
           }
           
           
           else if(down.isSelected())
           {
               try
               {
                   notepad.next= 1;
               }
               catch (NullPointerException ex)
               {
                   
               }
               try{
                  
               if(match.isSelected())
               {
                   try
                   {
                       notepad.cases =true;
                   }
                   catch (NullPointerException ex)
                   {
                   
                   }

                 start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().substring(start);
                    text_tf = area.getText();
                    if (text_ta.contains(text_tf))
                    {   
                         notepad.area.select(  start+text_ta.indexOf(text_tf) ,start+text_ta.indexOf(text_tf)+text_tf.length() ); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(find_dialogue,"Cannot find  "
                                +(char) 34+area.getText()+(char) 34);
                    }
               }
               else
               {   
                   try
                   {
                       notepad.cases = false;
                   }
                   catch (NullPointerException ex)
                   {
                   
                   }
                    
                    start = notepad.area.getCaretPosition();
                    text_ta = notepad.area.getText().toLowerCase().substring(start); 
                    text_tf = area.getText().toLowerCase();
                    if (text_ta.contains(text_tf))
                    {   
                         notepad.area.select(  start+text_ta.indexOf(text_tf) ,start+text_ta.indexOf(text_tf)+text_tf.length() ); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(find_dialogue,"Cannot find  "
                                +(char) 34+area.getText()+(char) 34);
                    } 
               }
           }
           catch (StringIndexOutOfBoundsException ex)
           {
               JOptionPane.showMessageDialog(find_dialogue,"Cannot find  "
                                +(char) 34+area.getText()+(char) 34);
                     
           }
          
          }
           
         
        }
          
            }
           @Override
    public void stateChanged(ChangeEvent e) {
      
    }
   
           
           }
            
    
    //__________________________________________________________

   
  
  

  

   
