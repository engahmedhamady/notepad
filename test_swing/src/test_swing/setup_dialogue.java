
package test_swing;

import java.awt.BorderLayout;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class setup_dialogue implements ActionListener {
   // notepad f;
    private JLabel lsize,lsource,imagelabel,portrait,landscape,left,right,top,bottom,header,footer;
 Border border; JComboBox cbsize,cbs;
 JScrollPane pane;
 JPanel main,south,west,center,east, paper,button,orientation,margins,preview;
 JRadioButton rbportrate , rblandscape;
 JTextField theader,tfooter,ttop,tbottom,tleft,tright;
 JDialog su;
 JButton ok , cancel;
    setup_dialogue (JFrame parent)
    { 
        
        su = new JDialog(parent,"setup page",true);
        


 
   
    //__________________________paper _________________________________________________
       
         paper = new JPanel(new   FlowLayout((int) LEFT_ALIGNMENT,5,5));
         paper.setPreferredSize(new Dimension(380,100 ));
        // paper.setMinimumSize(new Dimension(190,120 ));
        // paper.setPreferredSize(new Dimension(100, 100));
        TitledBorder border1 = new TitledBorder("paper");
        border1.setTitleJustification(TitledBorder.LEFT);
         border1.setTitlePosition(TitledBorder.TOP);
        paper.setBorder(border1);
        String size[]={"10×11","10×14","11×17","12×11","15×11","6 3/4 Envelope","9×11",
                      "A2","A3","A3 Extra","A3 Extra Transverse","A3 Rotated","A3 Transverse",
                      "A4","A4 Extra","A4 Plus","A4 Rotated","A4 Small","A4 Transverse",
                      "A5","A5 Extra","A5 Rotated","A5 Transverse","A6","A6 Rotated ",
                      "B4(ISO)","B4(JIS)","B4(JIS)Rotated","B5(ISO)","B5(JIS)",
                      "B5(JIS)Rotated","B5(JIS)","B6(JIS)","B6(JIS)Rotated", "C size sheet","D size sheet","Double Japan Postcard Rotated",
                      "E size sheet","Envelope","Envelope #10","Envelope #11","Envelope #12","Envelope #14","Envelope #9",
                      "Envelope B4","Envelope B5","Envelope B6","Envelope C3","Envelope","Envelope C3",
                      "Envelope C4","Envelope C5","Envelope C6","Envelope C65","Envelope DL","Envelope Invite","Envelope Monarch",
                      "Executive","Folio","German Legal Fanfold","German Std Fanfold" ,"Japan Envelope Chou #3 Rotated",
                      "Japan Envelope Chou #4 Rotated","Japan Envelope Kaku #2 Rotated","Japan Envelope Kaku #3 Rotated","Japan Envelope You #4 ","Japan Envelope You #4 Rotated",
                      "Japanese Double Postcard","Japanese Envelope Chou #3","Japanese Envelope Chou #4","Japanese Envelope Kaku #2","Japanese Envelope Kaku #2",
                      "Japanese  Postcard","Japanese Postcard Rotated","Ledger","Legal","Legal Extra","Letter","Letter Extra", "Letter Extra Transvedse",
                      "Letter Plus","Letter Rotated","Letter Small","Letter Transverse","Note","PRC Envelope #1","PRC Envelope #1 Rotated","PRC Envelope #10","PRC Envelope #3",
                      "PRC Envelope #3 Rotated","PRC Envelope #4","PRC Envelope #4 Rotated","PRC Envelope #5","PRC Envelope #5 Rotated","PRC Envelope #6",
                      "PRC Envelope #6 Rotated","PRC Envelope #7","PRC Envelope #7 Rotated","PRC Envelope #8","PRC Envelope #8 Rotated","PRC Envelope #9","PRC Envelope #9 Rotated",
                      "Quarto","Statement","Super A","Super B","Tabloid","US Std Fanfold" };
        String source[]={"Automatically Select"};   
         cbsize=new JComboBox(size);
         cbsize.setPreferredSize(new Dimension(250, 25));
         pane = new JScrollPane(cbsize,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cbs=new JComboBox(source);
         cbs.setPreferredSize(new Dimension(250, 25));
        lsize = new JLabel("    size:", (int) JLabel.LEFT);
          lsize.setPreferredSize(new Dimension(85, 20));
        lsource = new JLabel("    source:",JLabel.LEFT);
          lsource.setPreferredSize(new Dimension(85, 20));
        paper.add(lsize);
        paper.add(pane);
        paper.add(lsource);
        paper.add(cbs);
        
       // p1.setSize(200, 200);
       
   //_________________________________button panel____________________________________
            button = new JPanel(new FlowLayout((int) LEFT_ALIGNMENT));
             button.setPreferredSize(new Dimension(210,100 ));
            ok = new JButton("ok");
            cancel = new JButton("cancel");
            button.add(ok);
             ok.setPreferredSize(new Dimension(80,25 ));
            button.add(cancel,LEFT_ALIGNMENT);
             cancel.setPreferredSize(new Dimension(80,25 ));
  //________________________preview panel______________________________________
           preview = new JPanel(new FlowLayout(ICONIFIED, 10, 50));
           preview.setPreferredSize(new Dimension(180, 290));
           TitledBorder border2 = new TitledBorder("preview");
           border2.setTitleJustification(TitledBorder.LEFT);
           border2.setTitlePosition(TitledBorder.TOP);
           preview.setBorder(border2);
           ImageIcon icon = new ImageIcon("C:\\Users\\ahmed\\Desktop\\2.jpg");
           imagelabel= new JLabel(icon, JLabel.CENTER);
           imagelabel.setPreferredSize(new Dimension(75, 100));
           preview.add(imagelabel,BorderLayout.CENTER);
  ///_______________________east panel____________________________________________
           east = new JPanel(new  FlowLayout((int) LEFT_ALIGNMENT, 10, 10));
           east.setPreferredSize(new Dimension(200, 500));
           
           east.add(preview);
           east.add(button);
 //___________________________orientation panel___________________________________
         orientation = new JPanel(new FlowLayout((int) LEFT_ALIGNMENT,5,10));
         orientation.setPreferredSize(new Dimension(120, 100));
        TitledBorder border3 = new TitledBorder("orientation");
        border3.setTitleJustification(TitledBorder.LEFT);
        border3.setTitlePosition(TitledBorder.TOP);
        orientation.setBorder(border3);
        rbportrate= new JRadioButton();
        rbportrate.addActionListener(this);
        rblandscape = new JRadioButton();
          rblandscape.addActionListener(this);
        ButtonGroup bg=new ButtonGroup();
        rbportrate.setSelected(true);
        bg.add(rblandscape);
        bg.add(rbportrate);
        portrait = new JLabel("portrait");
        portrait.setPreferredSize(new Dimension(60, 25));
        landscape = new JLabel("landscape");
        orientation.add(rbportrate);
        orientation.add(portrait);
        orientation.add(rblandscape);
        orientation.add(landscape);
        
 //_________________________margins panel________________________________________
          margins = new JPanel(new FlowLayout((int) LEFT_ALIGNMENT,10,10));
          margins.setPreferredSize(new Dimension(240, 100));
          TitledBorder border4 = new TitledBorder("margins(inches)");
        border4.setTitleJustification(TitledBorder.LEFT);
        border4.setTitlePosition(TitledBorder.TOP);
        margins.setBorder(border4);
        left = new JLabel("Left");right = new JLabel("Right");
        top = new JLabel("Top");bottom = new JLabel("Bottom");
        tleft = new JTextField("0.75");tright = new JTextField("0.75");
        ttop = new JTextField("1");tbottom = new JTextField("1");
        margins.add(left);
        left.setPreferredSize(new Dimension(45, 20));
        margins.add(tleft);
          tleft.setPreferredSize(new Dimension(45, 20));
        margins.add(right);
          right.setPreferredSize(new Dimension(45, 20));
        margins.add(tright);
          tright.setPreferredSize(new Dimension(45, 20));
        margins.add(top);
          top.setPreferredSize(new Dimension(45, 20));
        margins.add(ttop);
          ttop.setPreferredSize(new Dimension(45, 20));
        margins.add(bottom);
          bottom.setPreferredSize(new Dimension(45, 20));
        margins.add(tbottom);
          tbottom.setPreferredSize(new Dimension(45, 20));
        
 //_______________center panel_________________________________________________
        center = new JPanel(new FlowLayout());
        center.add(orientation);
        center.add(margins);
 
 
        //______________________________south panel_____________________________________
        
        south = new JPanel(new FlowLayout((int) LEFT_ALIGNMENT,5,10));
        south.setPreferredSize(new Dimension(380,100 ));
        header = new JLabel(" Header:");
        footer = new JLabel(" Footer:");
        theader = new JTextField("&f");
        tfooter= new JTextField("Page &p");
        south.add(header);
        header.setPreferredSize(new Dimension(80, 20));
        south.add(theader);
        theader.setPreferredSize(new Dimension(280, 20));
        south.add(footer);
        footer.setPreferredSize(new Dimension(80, 20));
        south.add(tfooter);
        tfooter.setPreferredSize(new Dimension(280, 20));
        //________________________west panel _________________/----
         west = new JPanel(new FlowLayout((int) LEFT_ALIGNMENT,10,10));
         west.setPreferredSize(new Dimension(390,500 ));
        west.add(paper);
       west.add(center);
       
       west.add(south);
      
  //___________________________main panel__________________________________________________ 
        main = new JPanel(new FlowLayout((int) LEFT_ALIGNMENT,10,10));
       main.add(west);
       main.add(east);
       
       
      
  //___________________________________________________________________________
       su.add(main);
       
        
        su.setSize(635, 400);
       
   su.setVisible(true);
  
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (rblandscape.isSelected())
        {
           tleft.setText("1");
            tright.setText("1");
             ttop.setText("0.75");
              tbottom.setText("0.75");
              imagelabel.setSize(100,75);
        
        }
         if (rbportrate.isSelected())
        {
           tleft.setText("0.75");
            tright.setText("0.75");
             ttop.setText("1");
              tbottom.setText("1");
              imagelabel.setSize(75, 100);
        
        }
        
    }
    

}