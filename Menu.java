import java.util.Scanner;

public class Menu
{
	private Scanner input;

	public Menu()
	{
		input = new Scanner(System.in);
	}

	public int prompt()
	{
		System.out.println("\nWelcome to Twittify!\n");
		System.out.println("Please choose an option:\n");
		System.out.println("1 - Search spotify for a track\n2 - Search spotify for an album\n3 - Search spotify for an artist");

		String answer = input.nextLine();
		boolean badAnswer = true;

		while (badAnswer)
		{
			switch (answer.toLowerCase())
			{
				case ("1"):
					System.out.println("You chose option 1");
					badAnswer = false;
					return 1;

				case ("2"):
					System.out.println("You chose option 2");
					badAnswer = false;
					return 2;

				case ("3"):
					System.out.println("You chose option 2");
					badAnswer = false;
					return 3;

				default:
					System.out.println("\nInvalid answer, try again.\n");
					answer = input.nextLine();
					break;
			}
		}

		return 1;
	}
}
