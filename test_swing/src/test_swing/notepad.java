package test_swing;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;
public class notepad  implements ActionListener ,
        ItemListener,CaretListener
{   
      boolean cases = true;  
      int next = 2;
      public static  int saved  =0 ;
      public static JFrame frame;UndoManager undoManager ;
     JMenu File,Edit,Format,View,Help;
     JMenuItem New,Open,Save, SaveAs,PageSetup,Print,Exit,Undo,Redo , Copy ,
             Cut,Paste,Delete, Find, FindNext, Replace,GoTo, SelectAll 
             , td , font , ViewHelp, AboutAhmedPad,
             pUndo ,pRedo, pCopy ,pCut,pPaste,pDelete,pSelectAll;
     JPanel statusPanel ;
     JCheckBoxMenuItem WordWrap , StatusBar;
     JMenuBar mb;
     public  static JTextArea area;
     Container contentPane;
     JPopupMenu jpm; 
      public  static  File f = null;
     JLabel status ;
     JScrollPane textAreaScroller;
    public static String filename = "Untitled";
    public static String filecontent = "";
//    
    notepad() 
    {
       super();
       frame =new JFrame();
        ImageIcon icon = new ImageIcon("1.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle(filename+"-Ahmednote");
       undoManager = new UndoManager();
  //################################################################
        File = new JMenu("File");
        New = new JMenuItem ("New");
        Open = new JMenuItem ("Open"); 
        Save = new JMenuItem ("Save");
        SaveAs = new JMenuItem ("Save As");
        PageSetup = new JMenuItem ("Page Setup");
        Print = new JMenuItem ("Print");
        Exit = new JMenuItem ("Exit");
        File.addSeparator();
        File.add(New);File.addSeparator();
        File.add(Open);File.addSeparator();
        File.add(Save);File.addSeparator();
        File.add(SaveAs);File.addSeparator();
        File.add(PageSetup);File.addSeparator();
        File.add(Print); File.addSeparator();
        File.add(Exit);File.addSeparator();
 //##############################################################
        Edit = new JMenu("Edit");
        Undo = new JMenuItem ("Undo"); 
        Cut = new JMenuItem ("Cut");
        Copy = new JMenuItem ("Copy"); 
        Paste = new JMenuItem ("Paste");     
        Delete = new JMenuItem ("Delete");
        Find = new JMenuItem ("Find"); 
        FindNext = new JMenuItem ("Find Next");
        Replace = new JMenuItem ("Replace");
        GoTo = new JMenuItem ("Go To");
        SelectAll = new JMenuItem ("Select All");
        td = new JMenuItem ("Time/Date ");  
        Edit.addSeparator();
        Edit.add(Undo); Edit.addSeparator();
       // Edit.add(Redo); Edit.addSeparator();
        Edit.add(Cut); Edit.addSeparator();
        Edit.add(Copy); Edit.addSeparator();
        Edit.add(Paste); Edit.addSeparator();       
        Edit.add(Delete);Edit.addSeparator();
        Edit.add(Find);Edit.addSeparator();
        Edit.add(FindNext);Edit.addSeparator();
        Edit.add(Replace);Edit.addSeparator();
        Edit.add(GoTo);Edit.addSeparator();
        Edit.add(SelectAll);Edit.addSeparator();
        Edit.add(td);Edit.addSeparator();
 //########################################################################
        Format = new JMenu("Format");
        WordWrap = new JCheckBoxMenuItem("Word Wrap");
        font = new JMenuItem ("Font..");
        Format.addSeparator();
        Format.add(WordWrap); Format.addSeparator();
        Format.add(font); Format.addSeparator();
        //####################################################################
        View = new JMenu("View");       
        StatusBar = new JCheckBoxMenuItem("Status Bar");
        StatusBar.setSelected(false);
        View.addSeparator();
        View.add(StatusBar); View.addSeparator();
        //##################################################################
        Help = new JMenu("Help");
        ViewHelp = new JMenuItem ("ViewHelp");       
        AboutAhmedPad = new JMenuItem ("About AhmedPad");
        Help.addSeparator();
        Help.add(ViewHelp); Help.addSeparator();
        Help.add(AboutAhmedPad); Help.addSeparator();
        //#################################################################
        mb = new JMenuBar();      
        mb.add(File); mb.add(Edit); mb.add(Format); mb.add(View);
        mb.add(Help);
     //###################################################################
        jpm = new JPopupMenu();
        pUndo = new JMenuItem("Undo");
        pCopy = new JMenuItem("Copy");
        pCut = new JMenuItem("Cut");
        pPaste = new JMenuItem("Paste");
        pDelete = new JMenuItem("Delete");
        pSelectAll = new JMenuItem("SelectAll");
        jpm.addSeparator();
        jpm.add(pUndo);jpm.addSeparator();
//        jpm.add(pRedo); Edit.addSeparator();
        jpm.add(pCopy);jpm.addSeparator();
        jpm.add(pCut);jpm.addSeparator();
        jpm.add(pPaste);jpm.addSeparator();
        jpm.add(pDelete);jpm.addSeparator();
        jpm.add(pSelectAll);jpm.addSeparator();
     //########################################################3#####
         statusPanel = new JPanel();
         statusPanel.setBorder(new TitledBorder(""));
         statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 25));
         status = new JLabel ();
         status.setPreferredSize(new Dimension (100,15));
         statusPanel.add(status);
         statusPanel.setVisible(false);
 //####################################################################        
        contentPane = frame.getContentPane();  
        contentPane.add(mb, BorderLayout.NORTH); 
         contentPane.add(statusPanel, BorderLayout.SOUTH);
        area = new JTextArea();
        area.add(jpm);
        textAreaScroller = new JScrollPane(area);
        frame.add(textAreaScroller);    
        textAreaScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        textAreaScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);    
        frame.setVisible(true); 
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  //##################################################################3
        area.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                if( SwingUtilities.isRightMouseButton(e) )
                    jpm.show(area, e.getX(), e.getY());
            }
        });
        New.addActionListener(this);
        Open.addActionListener(this);
        Save.addActionListener(this);
        SaveAs.addActionListener(this);
        PageSetup.addActionListener(this);
        Print.addActionListener(this);
        Exit.addActionListener(this);
        Replace.addActionListener(this);
        FindNext.addActionListener(this);
        Find.addActionListener(this);
        Copy.addActionListener(this);
        Cut.addActionListener(this);
        Undo.addActionListener(this);
        Paste.addActionListener(this);
        Delete.addActionListener(this);
        GoTo.addActionListener(this);
        SelectAll.addActionListener(this);
        td.addActionListener(this);
        AboutAhmedPad.addActionListener(this);
        ViewHelp.addActionListener(this);
        StatusBar.addItemListener(this);
        WordWrap.addItemListener(this);
        font.addActionListener(this);
        pUndo.addActionListener(this);
        pCut.addActionListener(this);
        pCopy.addActionListener(this);
        pPaste.addActionListener(this);
        pDelete.addActionListener(this);
        pSelectAll.addActionListener(this);
         area.addCaretListener(this);
      
//#####################################################################    
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {   
       
        if (e.getSource()==New)  
        {   
             if(f == null )
             {
                       if (area.getText()==null)
                       {
                        
                       }
                       else
                       {
                    //savaas
                                 frame.setEnabled(false);
                                 new save_dialogue();
                 
                       }
             
             }
             else
             {
                if(f==null)
                {
                
                }
                else
                {
                
                
                }
                
             
             }
              // new notepad();
               //processEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
  //*****************************************************8**********************
        if(e.getSource()==Open)
        {    
             
            new open_function ();
        }
    //************************************************************
       if (e.getSource()==Save)
       {
          
           new save_function();
       
       }
 //*****************************************************************      
       if (e.getSource()==SaveAs)
       { 
          new saveas_function();
       }    
  //******************************************************************     
       if (e.getSource()==PageSetup) 
       {
           new setup_dialogue (frame);
           
       }
   //****************************************************************
        
       if (e.getSource()==Print)  {}
   //***********************************************************88   
       if (e.getSource()==Exit)  
       {
         
         //  processEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
       }
   //***************************************************************8
       if (e.getSource()==Undo)
       {}
   //*************************************************************
       
       if (e.getSource()==Cut)  
       {
           area.cut();
       }
   //*************************************************************
       if (e.getSource()==Copy)  
       {
           area.copy();
       }
  //*******************************************************************
       if (e.getSource()==Paste)  
       {
           area.paste();
       }
  //***************************************************************8
       if (e.getSource()==Delete)
       {
          area.replaceSelection("");
       }  
   //**************************************************************8
         
       if (e.getSource()==Find) 
       {
          new find_dialogue(frame);
       }
 //*****************************************************************8      
    /*   
       if (e.getSource()==FindNext) 
       {
             String text_ta;
            String text_tf;
            int start;
            switch (next) 
            {
              case 0:
                    try
                      {
                      if(cases)
                      {
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
                            JOptionPane.showMessageDialog(this,"Cannot find  "
                                    +(char) 34+area.getText()+(char) 34);
                         }
                      }
                      else if (!cases)
                      {
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
                              JOptionPane.showMessageDialog(this,"Cannot find  "
                                    +(char) 34+area.getText()+(char) 34);
                          }
                      }   } 
                      catch (StringIndexOutOfBoundsException ex)
                      {
                           JOptionPane.showMessageDialog(this,"Cannot find  "
                                +(char) 34+area.getText()+(char) 34);
                        
                      }         break;

              case 1:
                      try
                      {
                          if(cases)
                          {
                               start = notepad.area.getCaretPosition();
                               text_ta = notepad.area.getText().substring(start);
                               text_tf = area.getText();
                               if (text_ta.contains(text_tf))
                               {
                                   notepad.area.select(  start+text_ta.indexOf(text_tf) ,start+text_ta.indexOf(text_tf)+text_tf.length() );
                               }
                               else
                               {
                                   JOptionPane.showMessageDialog(this,"Cannot find  "
                                        +(char) 34+area.getText()+(char) 34);
                               }
                          }
                          else if (!cases)
                          {
                               start = notepad.area.getCaretPosition();
                               text_ta = notepad.area.getText().toLowerCase().substring(start);
                               text_tf = area.getText().toLowerCase();
                               if (text_ta.contains(text_tf))
                               {
                                  notepad.area.select(  start+text_ta.indexOf(text_tf) ,start+text_ta.indexOf(text_tf)+text_tf.length() );
                               }
                               else
                               {
                                    JOptionPane.showMessageDialog(this,"Cannot find  "
                                        +(char) 34+area.getText()+(char) 34);
                               }
                          }
                      } 
                      catch (StringIndexOutOfBoundsException ex)
                      {
                           JOptionPane.showMessageDialog(this,"Cannot find  "
                                +(char) 34+area.getText()+(char) 34);
                        
                      }         break;
             //  case 2:
                 //    new find_dialogue(this);
                  //   break;
               default:
                    break;
           }
           
         
        }
         */
         
        
  //*******************************************************************8     
       if (e.getSource()==Replace)
       {
           new replace_dialogue (frame);
       } 
  //********************************************************************8     
       if (e.getSource()==GoTo) 
       {
            try {  
                int lineNumber=area.getLineOfOffset(area.getCaretPosition())+1;
                new GoTo_dialogue(frame ,lineNumber);
            } catch (BadLocationException ex) {
                Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
            }
       } 
   //****************************************************************8    
       if (e.getSource()==SelectAll)  
       {
           area.selectAll();
       }
   //************************************************************
       if (e.getSource()==td) 
       {
          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();  
            area.setText(area.getText()+formatter.format(date));
       }
   
    //**********************************************************8
        if (e.getSource()==font) 
        {
           new font_dialogue(frame);
        }
    //******************************************************88    //******************************************************88
        
       if (e.getSource()==StatusBar){}
   //*************************************************************8     //*************************************************************8  
        
        if (e.getSource()==ViewHelp){}
   //*************************************************************   //*************************************************************
    
        if (e.getSource()==AboutAhmedPad) {} 
///*****************************************************************8      
      if (e.getSource()==pUndo) {} 
 //*******************************************************************       
        if (e.getSource()==pCut)  
        {
            area.cut();
        }
   //************************************************************
        if (e.getSource()==pCopy)  
        {
            area.copy();
        }
   //**************************************************************
        if (e.getSource()==pPaste)  
        {
            area.paste();
        }
   //***********************************************************
        if (e.getSource()==pDelete)
        {
           area.replaceSelection("");
        }
  //***************************************************************  //***************************************************************
       
        if (e.getSource()==pSelectAll)  
        {
            area.selectAll();
        }
 
          
         
  //******************************************************************  
  
}
    @Override
       public void itemStateChanged(ItemEvent e)
     {   
         if (e.getSource()==WordWrap)
         {
            if (e.getStateChange()==1)
            {
                textAreaScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                area.setLineWrap(true);
                StatusBar.setSelected(false);
                StatusBar.setEnabled(false);
                //area.setWrapStyleWord(true );
            }
            else 
            {
        
               textAreaScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                StatusBar.setSelected(true);
                StatusBar.setEnabled(true);
            }
         }
          if (e.getSource()==StatusBar)
         {
            if (e.getStateChange()==1)
            {
                 statusPanel.setVisible(true);
             
               
            }
            else 
            {
        
              statusPanel.setVisible(false);
               
            }
         }
     }

    @Override
    public void caretUpdate(CaretEvent e) 
    {
        try {
               int linenum =1;
               int columnnum =1;
               int caretpos = area.getCaretPosition();
               linenum = area.getLineOfOffset(caretpos);    
               columnnum = caretpos -area.getLineStartOffset(linenum);
               columnnum+=1;
               linenum+= 1;
               status.setText("Line: " + linenum + " Column: " + columnnum);
        } catch (BadLocationException ex) {
            Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
         

    }

   
      


}    