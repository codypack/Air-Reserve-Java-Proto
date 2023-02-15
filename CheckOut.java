import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CheckOut extends JDialog implements ActionListener
{
  Random random;
  JLabel label;
  float id;
  Travel travel;
  int idCounter = 0;
  JButton okButton;
  ArrayList<Integer> yourId;
  CheckOut(Frame parent, String title, boolean modal)
  {
    travel = (Travel)parent;
    random = new Random();
	label = new JLabel();
	okButton = new JButton("OK");
	okButton.addActionListener(this);
	setLayout(new FlowLayout());
	setBackground(Color.white);
	setSize(300,300);
	yourId = new ArrayList<Integer>();
	yourId.add(random.nextInt(99999999));
	idCounter++;
	if(idCounter > 1)
	  return;
	label.setText("Your ticket number is " + yourId);
	add(label);
	add(okButton);
  }
  public void actionPerformed(ActionEvent evt)
   {
     if(evt.getSource() == okButton)
	 {
	   dispose();
	 }
   }
}