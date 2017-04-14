/**
 * Menu class that is used to create on-screen menus that allow for user input.
 * Their input is returned by the method to be used in a search query.
 *
 * @author Vince Carpino
 */

import java.util.Scanner;

public class Menu
{
	public Menu(){};

	/* FIRST MENU ATTEMPT - NOT USED ANYMORE */
	public int prompt()
	{
		System.out.println("\nWelcome to Twittify!\n");
		System.out.println("Please choose an option:\n");
		System.out.println("1 - Search Spotify for a track\n2 - Search Spotify for an artist\n3 - Search Spotify for an album");

		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		boolean badAnswer = true;

		while (badAnswer)
		{
			switch (answer.toLowerCase())
			{
				case ("1"):
					System.out.println("You chose option 1 - track");
					badAnswer = false;
					return 1;

				case ("2"):
					System.out.println("You chose option 2 - artist");
					badAnswer = false;
					return 2;

				case ("3"):
					System.out.println("You chose option 3 - album");
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

	/* CREATES NUMBER-BASED MENU BASED ON ARGUMENTS AND RETURNS USER'S ANSWER */
	public int create(String prompt, String[] options)
	{
		int answer = 0;
		boolean badAnswer = true;
		Scanner input = new Scanner(System.in);

		System.out.println(prompt);

		for (int i = 0; i < options.length; ++i)
		{
			System.out.println((i+1) + " - " + options[i]);
		}

		while (badAnswer)
		{
			try
			{
				answer = input.nextInt();

				if (answer >= 1 && answer <= options.length)
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

	/* CREATES SINGLE-PROMPT MENU THAT ACCEPTS STRING RESPONSE AND RETURNS IT */
	public String create(String prompt)
	{
		System.out.println(prompt);
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();

		return answer;
	}
}
