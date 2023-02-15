import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

class Travel extends JFrame implements ActionListener
{
  JLabel lbFirstName, lbLastName, lbEmail, lbDateOfBirth, lbBaggage, lbTelNumber;
  JLabel lbDeparture, lbReturn;
  JTextField txFirstName, txLastName, txEmail, txDateOfBirth, txBaggage, txTelNumber;
  JButton chooseSeats, checkOut;
  Passengers passengers;
  ChooseSeats cs;
  CheckOut co;
  int departureSitLabelLength, returnSitLabelLength;
  public Travel(String s)
  {
    super(s);
	Container con = getContentPane();
	con.setLayout(new FlowLayout());
	passengers = new Passengers();
	cs = new ChooseSeats(this, "Choose departure and return seat", true);
	co = new CheckOut(this, "Your ticket number", true);
	lbFirstName = new JLabel("First Name");
	txFirstName = new JTextField(10);
	lbLastName = new JLabel("Last Name");
	txLastName = new JTextField(10);
	lbEmail = new JLabel("Email");
	txEmail = new JTextField(10);
	lbDateOfBirth = new JLabel("Date of Birth");
	txDateOfBirth = new JTextField(10);
	lbBaggage = new JLabel("No of Luggages");
	txBaggage = new JTextField(10);
	lbTelNumber = new JLabel("Telephone No");
	txTelNumber = new JTextField(10);
	chooseSeats = new JButton("Choose Seats");
	lbDeparture = new JLabel("Departure sit: ");
	lbReturn = new JLabel("Return sit: ");
	departureSitLabelLength = lbDeparture.getText().length();
	returnSitLabelLength = lbReturn.getText().length();
	checkOut = new JButton("Check Out");
	chooseSeats.addActionListener(this);
	checkOut.addActionListener(this);
	con.add(lbFirstName);
	con.add(txFirstName);
	con.add(lbLastName);
	con.add(txLastName);
	con.add(lbEmail);
	con.add(txEmail);
	con.add(lbDateOfBirth);
	con.add(txDateOfBirth);
	con.add(lbBaggage);
	con.add(txBaggage);
	con.add(lbTelNumber);
	con.add(txTelNumber);
	con.add(chooseSeats);
	con.add(lbDeparture);
	con.add(lbReturn);
	con.add(checkOut);
	setSize(300,300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent evt)
  {
     if(evt.getSource() == chooseSeats)
	 {
           if(passengers.getFirstName().equals("") || passengers.getLastName().equals("") || 
                passengers.getDateOfBirth().equals("") || String.valueOf(passengers.getTelephoneNo()).equals("") ||
                passengers.getEmail().equals("") || String.valueOf(passengers.getNumberOfBags()).equals(""))
                
             {
                 JOptionPane.showMessageDialog(null,"Error:Please do not leave boxes blank", "", JOptionPane.ERROR_MESSAGE); 
				 return;
             }
	        else if(!(passengers.getFirstName().matches("^[a-zA-Z]+$")) || !(passengers.getLastName().matches("^[a-zA-Z]+$")))
			{
	            JOptionPane.showMessageDialog(null,"Error:Review the first name and last name", "", JOptionPane.ERROR_MESSAGE);
				return;
            }
			else if(!(txEmail.getText().contains("@")))
			{
			  JOptionPane.showMessageDialog(null,"Error: Invalid email entered!", "", JOptionPane.ERROR_MESSAGE);
			   return;
			}
			else if(!(txDateOfBirth.getText().matches("^\\d{2}/\\d{2}/\\d{4}$")))
			{
			  JOptionPane.showMessageDialog(null,"Error: Please follow date format DD/MM/YYYY!", "", JOptionPane.ERROR_MESSAGE);
			  return;
			}
            cs.setLocation(500,200);			
            cs.setVisible(true);
      }
      if(evt.getSource() == checkOut)
      {
	    if(co.travel.lbDeparture.getText().length() == departureSitLabelLength || 
		   co.travel.lbReturn.getText().length() == returnSitLabelLength)
		{
		  JOptionPane.showMessageDialog(null,"Error: You can't finalize without choosing departure and error sit", "", JOptionPane.ERROR_MESSAGE);
		  return;
		}
		co.setVisible(true);
      }	  
	
	
   }
   private boolean isValidDate(String dateOfBirth) 
   {
        boolean valid = true;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(dateOfBirth);
        } catch (Exception e) {
            valid = false;
        }
        return valid;
   }
  
}

public class Passengers 
{
    String firstName, lastName, departSeat, email, returnSeat, dateOfBirth;
    int numberOfBags,ticketNo;
    long telephoneNo;
	static Travel travel;
	
	public static void main(String[]args)
    {
      travel = new Travel("Passenger Information");
	  
    }
    
    public String getFirstName() 
    {
        firstName = travel.txFirstName.getText();
        return firstName;
    }

    public String getLastName() 
    {
        lastName = travel.txLastName.getText();
        return lastName;
    }

    public String getDepartSeat() 
    {
        
        return departSeat;
    }

    public String getEmail() 
    {
        email = travel.txEmail.getText();
        return email;
    }

    public String getReturnSeat() {
        return returnSeat;
    }

    public String getDateOfBirth() 
    {
        dateOfBirth = travel.txDateOfBirth.getText();
        return dateOfBirth;
    }

    public int getNumberOfBags() 
    {
	    try
		{
        numberOfBags = Integer.parseInt(travel.txBaggage.getText());
		}
		catch(NumberFormatException e)
		{
		  JOptionPane.showMessageDialog(null, "Please type a number to represent\nthe number of luggages");
		}
        return numberOfBags;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public long getTelephoneNo() 
    {
        telephoneNo = Long.parseLong(travel.txTelNumber.getText());
        return telephoneNo;
    }
    public String toString()
	{
	  return  "" + firstName + " " + lastName + " " + email + " " + dateOfBirth + " " + 
	           numberOfBags + " " + telephoneNo + "";
	}
}
