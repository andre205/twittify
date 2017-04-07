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
		System.out.println("1 - Search Spotify for a track\n2 - Search Spotify for an album\n3 - Search Spotify for an artist");

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

	/* CREATES MENU BASED ON ARGUMENTS AND RETURNS USER'S ANSWER */
	public int create(String prompt, int numOptions, String[] options)
	{
		int answer = 0;
		boolean badAnswer = true;

		System.out.println(prompt);

		for (int i = 0; i < numOptions; ++i)
		{
			System.out.println((i+1) + " - " + options[i]);
		}

		while (badAnswer)
		{
			try
			{
				answer = input.nextInt();

				if (answer >= 1 && answer <= numOptions)
				{
					badAnswer = false;
				}

				else
				{
					System.out.println("Invalid answer, try again.");
				}
			} catch (Exception e) {
				System.out.println("You're an idiot.");
				System.exit(0);
			}
		}

		return answer;
	}
}
