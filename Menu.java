import java.util.Scanner;

public class Menu
{
	private Scanner input;

	public Menu()
	{
		input = new Scanner(System.in);
	}

	public void prompt()
	{
		System.out.println("\nWelcome to Twittify!\n");
		System.out.println("Please choose an option:\n");
		System.out.println("1 - Find most tweeted songs\n2 - Create playlist based on most tweeted songs\n");

		String answer = input.nextLine();
		boolean badAnswer = true;

		while (badAnswer)
		{
			switch (answer.toLowerCase())
			{
				case ("1"):
					System.out.println("You chose option 1");
					badAnswer = false;
					break;

				case ("2"):
					System.out.println("You chose option 2");
					badAnswer = false;
					break;

				default:
					System.out.println("\nInvalid answer, try again.\n");
					answer = input.nextLine();
					break;
			}
		}
	}
}
