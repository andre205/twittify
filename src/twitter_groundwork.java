import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.api.*;
import twitter4j.conf.*;
import twitter4j.json.*;
import twitter4j.management.*;
import twitter4j.util.*;
import java.util.List;

//A class made to handle the Twitter API
public class twitter_groundwork {

    public twitter_groundwork () {};

    public static void test() throws TwitterException{

        try
        {

            ConfigurationBuilder cb = new ConfigurationBuilder();

            cb.setDebugEnabled(true)
                        .setOAuthConsumerKey("LGya8GWbitBpZMEYVTVSAmphb")
                        .setOAuthConsumerSecret("tbuFJ1r1pt0tAHPV1IkvI8Ouy28QOGZS8LJswKc4Sslcb1UbF7")
                        .setOAuthAccessToken("383855581-pSxjbbILvzuT28xY12xFStIRLKnbPKok02vzbVSC")
                        .setOAuthAccessTokenSecret("YlUoiGp120CAIbnhcuUzWjrXzya6w0Is1lwZNd8TLlt6w");

            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter4j.Twitter twitter = tf.getInstance();

            Query query = new Query("aerosmith");
            QueryResult result = twitter.search(query);

            for (Status status : result.getTweets())
            {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
      }

      catch(Exception e)
      {
        System.out.println("error");
      }




    }

    public static void print_tweet_search(String query)
    {
    }
}
