import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ChooseSeats extends JDialog implements ItemListener, ActionListener
{
   Travel travel;
   JComboBox cbDepart, cbReturn;
   JButton okButton;
   int sitIdCounterDepart = 0, sitIdCounterReturn = 0;
   ChooseSeats(Frame parent, String title, boolean modal)
   {
      travel = (Travel)parent;
	  String[] depart = {"","10b", "11d", "12c", "15e", "12f", "23b"};
	  String[] returning = {"", "14a", "16b", "17e", "18h", "30b", "19j"};
	  cbDepart = new JComboBox(depart);
	  cbDepart.addItemListener(this);
	  cbReturn = new JComboBox(returning);
	  cbReturn.addItemListener(this);
	  okButton = new JButton("OK");
	  okButton.addActionListener(this);
	  setLayout(new FlowLayout());
	  setBackground(Color.white);
	  add(cbDepart);
	  add(cbReturn);
	  add(okButton);
	  setSize(300,300);
	  
   }
   public void itemStateChanged(ItemEvent evt)
   {
     if(evt.getSource() == cbDepart && evt.getStateChange() == ItemEvent.SELECTED)
	 {
	    String sitId = (String)cbDepart.getSelectedItem();
		sitIdCounterDepart++;
		if(sitIdCounterDepart > 1)
		 return;
		travel.lbDeparture.setText(travel.lbDeparture.getText() + sitId);
		
	 }
	 if(evt.getSource() == cbReturn && evt.getStateChange() == ItemEvent.SELECTED)
	 {
	    String sitId = (String)cbReturn.getSelectedItem();
		sitIdCounterReturn++;
		if(sitIdCounterReturn > 1)
		 return;
		travel.lbReturn.setText(travel.lbReturn.getText() + sitId);
		
	 }
	 
   }
   public void actionPerformed(ActionEvent evt)
   {
     if(evt.getSource() == okButton)
	 {
	   dispose();
	 }
   }
}