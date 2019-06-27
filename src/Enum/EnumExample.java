import javax.swing.JOptionPane;

public class EnumExample 
{

	public enum DaysOfWeek
	{
		Sunday(0),Monday(1),Tuesday(2),Wednesday(3),Thursday(4),Friday(5),Saturday(6);
		
		int dayNum;
		
		private DaysOfWeek(int dayNum)
		{
			this.dayNum = dayNum;
		}
	}
	
	public static void main(String[] args) 
	{
		//Static input for day of week, asking user
		chooseDay();
		
	}
	
	public static void chooseDay()
	{
		String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		String choices = (String)JOptionPane.showInputDialog(null,"Options:\n"
				+ "Sunday\n"
				+ "Monday\n"
				+ "Tuesday\n"
				+ "Wednesday\n"
				+ "Thursday\n"
				+ "Friday\n"
				+ "Saturday\n","What is the current day?",JOptionPane.QUESTION_MESSAGE,null,days,days[6]);
		
		DaysOfWeek d = DaysOfWeek.valueOf(choices);
		
		switch(d)
		{
			case Sunday:
				System.out.println("You have chosen Sunday\n"
						+ "Choice: "+d.dayNum);
				break;
			case Monday:
				System.out.println("You have chosen Monday\n"
						+ "Choice "+d.dayNum);
				break;
			case Tuesday:
				System.out.println("You have chosen Tuesday\n"
						+ "Choice "+d.dayNum);
				break;
			case Wednesday:
				System.out.println("You have chosen Wednesday\n"
				+ "Choice "+d.dayNum);
				break;
			case Thursday:
				System.out.println("You have chosen Thursday\n"
				+ "Choice "+d.dayNum);
				break;
			case Friday:
				System.out.println("You have chosen Friday\n"
				+ "Choice "+d.dayNum);
				break;
			case Saturday:
				System.out.println("You have chosen Saturday\n"
				+ "Choice "+d.dayNum);
				break;
		}
	}
}
