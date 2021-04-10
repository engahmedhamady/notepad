
package test_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class font_dialogue implements ListSelectionListener , ActionListener
  
{notepad notepad;
    JButton ok,cancel;
    JList lfont ,lstyle , lsize ;
    JLabel font ,style ,size, script , sample , hyperlink ;
    JTextField areafont,areasize,areastyle;
    JComboBox cb;
    JPanel font_grid_panel,style_grid_panel,
           size_grid_panel,center,south_center,button,east,link_show;
    JScrollPane scrollPane;
    JDialog font_dialogue ;

    public font_dialogue(JFrame frame)
    {
        
    
      //_____________font_grid_panel___________________________________
           font_grid_panel = new JPanel(new FlowLayout(HEIGHT,0,0));
           font_grid_panel.setPreferredSize(new Dimension(180, 190));
          
           String type []={"Andalus","Angsana New","Arabic Typesetting","Arial",
                          "Calibri","Cambria","Cambria Math","Candara","Comic Sans MS",
                          "Consolas","Constantia","Corbel","Courier","Courier New","Doulos SIL",
                          "Fixedsys","Franklin Gothic","Gabriola","Georgia","Impact",
                          "Lucida Console","Lucida Sans Unicode","Microsoft Sans Serif",
                          "Modern","MS Sans Serif","MS Serif","Palatino Linotype","Roman",
                          "Sakkal Majalla", "Script","Segoe Print","Segoe Script","Segoe UI",
                          "Segoe UI Symbol","Simplified Arabic","Simplified Arabic Fixed",
                          "Small Fonts","Symbol","System","Tahoma","Terminal","Times New Roman",
                          "Traditional Arabic","Trebuchet MS","Verdana","Webdings","Wingdings"};
          
           lfont = new JList(type);
           lfont.setPreferredSize(new Dimension(160, 852));
             scrollPane = new JScrollPane(lfont,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
             //scrollPane.setViewportView(lfont);
           lfont.setSelectedIndex(0); 
           font = new JLabel("Font:");
           font.setPreferredSize(new Dimension(170, 25)); 
           areafont = new JTextField (lfont.getSelectedValue().toString());
           areafont.selectAll();
           areafont.setPreferredSize(new Dimension(178, 25));
           font_grid_panel.add(font);
           font_grid_panel.add(areafont);
           font_grid_panel.add(scrollPane);
       //____________________________________________________________________
           style_grid_panel = new JPanel(new FlowLayout(HEIGHT,0,0));
           style_grid_panel.setPreferredSize(new Dimension(130, 190));
         
           String stylearray []={"Regular","Oblique","Bold","Bold Oblique" };
                     
           lstyle = new JList(stylearray);
           lstyle.setPreferredSize(new Dimension(100, 140));
           scrollPane = new JScrollPane(lstyle,
               JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           lstyle.setSelectedIndex(0);
          style = new JLabel("Font Style:");
           style.setPreferredSize(new Dimension(115, 25));
           areastyle = new JTextField (lstyle.getSelectedValue().toString());
           areastyle.setPreferredSize(new Dimension(117, 25));
            style_grid_panel.add(style);
           style_grid_panel.add(areastyle);
           style_grid_panel.add(scrollPane);
        //_________________________________________________________________
           size_grid_panel = new JPanel(new FlowLayout(HEIGHT,0,0));
           size_grid_panel.setPreferredSize(new Dimension(100, 190));
            
           String size_array []=  new String [100] ;
           int i = 1;
           while (i<=100)
           {
              size_array[i-1]=Integer.toString(i);
              
               i++;
               
           }
                     
           lsize = new JList(size_array);
           lsize.setPreferredSize(new Dimension(70, 1805));
            scrollPane = new JScrollPane(lsize,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            lsize.setSelectedIndex(16);
            size = new JLabel("Size:");
           size.setPreferredSize(new Dimension(80, 25));
           areasize = new JTextField (lsize.getSelectedValue().toString());
           areasize.setPreferredSize(new Dimension(88, 25));
           size_grid_panel.add(size);
           size_grid_panel.add(areasize);
           size_grid_panel.add(scrollPane);
       //_____________________show_link panel____________________________
          link_show = new JPanel(new BorderLayout());
          link_show.setPreferredSize(new Dimension(180,230));
          hyperlink = new JLabel("<html><a href=''>Show more fonts</a></html>");
          hyperlink.setForeground(Color.BLUE.darker());
          hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          link_show.add( hyperlink,BorderLayout.CENTER);
      //________________________________button____________________________
              button = new JPanel(new FlowLayout());
              button.setPreferredSize(new Dimension(165,40));
              ok = new JButton("Ok");
              ok.setPreferredSize(new Dimension(75,20));
              cancel = new JButton("Cancel");
              cancel.setPreferredSize(new Dimension(75,20));
              button.add(ok);
              button.add(cancel);
         //_______________________south_center panel _____________________
             south_center = new JPanel(new BorderLayout());
             south_center.setPreferredSize(new Dimension(250,100));
             south_center.add(button,BorderLayout.SOUTH);
           
      //____________________________center panel____________________________________
             center = new JPanel(new FlowLayout((int) RIGHT_ALIGNMENT,0,0));
             center.setPreferredSize(new Dimension(220,160));
             script = new JLabel("Script:");
             script.setPreferredSize(new Dimension(220,30));
            sample = new JLabel("AaBbCc");
            sample.setPreferredSize(new Dimension(220, 80));
            TitledBorder border = new TitledBorder("Sample");
              border.setTitleJustification(TitledBorder.LEFT);
              border.setTitlePosition(TitledBorder.TOP);
              sample.setBorder(border);
              String language []= {"Western","Greek","Turkish","Baltic","Central European","Cyrillic"};
              cb=new JComboBox(language);
              cb.setPreferredSize(new Dimension(220,30));
              cb.setBackground(Color.WHITE);
              center.add(sample);
              center.add(script);
              center.add(cb);
            
         //___________________________east panel _____________________________
            east = new JPanel(new FlowLayout(HEIGHT,0,0));
              east.setPreferredSize(new Dimension (230,270));
              east.add(center);
              east.add(south_center);
   //_____________________________font_dialogue dialogue____________________________________________
            font_dialogue = new JDialog(frame,"Font",false);
            font_dialogue.setLayout(new FlowLayout((int)LEFT_ALIGNMENT,20,10));
            font_dialogue.add(font_grid_panel);
            font_dialogue.add(style_grid_panel);
            font_dialogue.add(size_grid_panel);
             font_dialogue.add(link_show);
            
            font_dialogue.add(east);
            //font_dialogue.add(button);
            font_dialogue.setSize(500,520);
            font_dialogue.setVisible(true);  
 //_______________________________________-------------________________\
  hyperlink.addMouseListener(new MouseAdapter() {
 
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
         
        Desktop.getDesktop().open(new File("C:\\Users\\ahmed\\Desktop\\font"));
         
    } catch (IOException e1) {
        e1.printStackTrace();
    }
    }
 
   });
   lfont.addListSelectionListener(this);
   lstyle.addListSelectionListener(this);
    lsize.addListSelectionListener(this);
  ok.addActionListener(this);
  cancel.addActionListener(this);
    }
    //{_______________________________________________________________________
    

    @Override
    public void valueChanged(ListSelectionEvent e) {
     try
     {
      areafont.setText(lfont.getSelectedValue().toString());
      areastyle.setText(lstyle.getSelectedValue().toString());
      areasize.setText(lsize.getSelectedValue().toString());
      String s  = areastyle.getText();
      int y =0;
      switch (s)
      {
          case "Regular"       :  y= Font.ITALIC;
          case "Bold"          :  y= Font.BOLD;
          case "Oblique"       :  y= Font.PLAIN;
          case "Bold Oblique"  :  y= Font.HANGING_BASELINE;    
      }
           sample.setFont
           (               
               new Font(  (areafont.getText()),y ,
                       Integer.parseInt(areasize.getText())));
        
     }
     catch(NullPointerException ex){ex.printStackTrace();}
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==ok)
      {
          try 
          {
             int x =Font.BOLD;
             switch (areastyle.getText())
             {
                 case "Regular" :x= Font.ITALIC;
                 case "Bold" :x= Font.BOLD;
                 case "Oblique" :x= Font.PLAIN;
                 case "Bold Oblique" :x= Font.HANGING_BASELINE;
             
             }
           notepad.area.setFont
           (               
               new Font(  (areafont.getText()),x , Integer.parseInt(areasize.getText())));
               font_dialogue.dispose(); 
           
          }
          catch (NumberFormatException ex){}
      }
      if(e.getSource()==cancel)
      {
        
          font_dialogue.dispose();
      
      }
    }

   
    
}
