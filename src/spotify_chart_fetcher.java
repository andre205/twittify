/*
  Gets top 200 songs on spotify and returns them as an array of strings

  @author Tyler Andrews
*/

import org.apache.commons.csv.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class spotify_chart_fetcher
{
		public spotify_chart_fetcher(){};

		public String[] getTop20()
		{
				String[] returnlist = new String[20];

				try{
						//Get top 200 CSV from spotifycharts
						URL url = new URL("https://spotifycharts.com/regional/global/daily/latest/download");
						URLConnection urlConnection = url.openConnection();
						InputStreamReader urlStreamReader = new InputStreamReader(urlConnection.getInputStream());
						//Parse CSV
						//~~~~FOR DEFAULT CHANGE TO CSVFormat.DEFAULT
						CSVParser csv_p = new CSVParser(urlStreamReader, CSVFormat.EXCEL.withHeader());
						//Print all
						//csv_p.getRecords().stream().forEach(System.out::println);

						//Get only track names (can get links to songs or other info later)
						int i = 0;
						for (CSVRecord record : csv_p)
						{
									String s = record.get("Track Name");
									//Print all
					        //System.out.println(s);

									returnlist[i] = s;
									i++;
									if (i == 21)
									{
										break;
									}
					    }

				}

				catch (Exception e)
				{
						System.out.println("Sorry, Spotifycharts.com is offline.\nDisplaying cached list.");

				}

				return returnlist;
		}
}
