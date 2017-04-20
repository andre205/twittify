import net.unto.twitter.Api;
import net.unto.twitter.TwitterProtos.Status;
import net.unto.twitter.*;

public class Twitter{
	public static void main(String[] args){

		try
		{
			Api api = Api.builder().build();
			for (Status status : api.publicTimeline().build().get())
			{
				System.out.println(String.format("%s wrote '%s'", status.getUser().getName(), status.getText()));
			}

		}
		catch(Exception e)
		{
			System.out.print("error");

		}

	}
}
