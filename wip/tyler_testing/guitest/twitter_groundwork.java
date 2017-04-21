import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.api.*;
import twitter4j.conf.*;
import twitter4j.json.*;
import twitter4j.management.*;
import twitter4j.util.*;
import java.util.List;
import java.util.LinkedList;

//A class made to handle the Twitter API
public class twitter_groundwork {

  public List<String> search(String foofoo) throws TwitterException {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
            .setOAuthConsumerKey("LGya8GWbitBpZMEYVTVSAmphb")
            .setOAuthConsumerSecret("tbuFJ1r1pt0tAHPV1IkvI8Ouy28QOGZS8LJswKc4Sslcb1UbF7")
            .setOAuthAccessToken("383855581-pSxjbbILvzuT28xY12xFStIRLKnbPKok02vzbVSC")
            .setOAuthAccessTokenSecret("YlUoiGp120CAIbnhcuUzWjrXzya6w0Is1lwZNd8TLlt6w");

    TwitterFactory tf = new TwitterFactory(cb.build());
    twitter4j.Twitter twitter = tf.getInstance();
    Query query = new Query(foofoo);
    QueryResult result = twitter.search(query);
    List<String> tweets = new LinkedList<String>();
    for (Status status : result.getTweets()) {
        tweets.add("@" + status.getUser().getScreenName() + ":" + status.getText());
    }
    return tweets;
  }

  public String[] search_s(String foofoo) throws TwitterException {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
            .setOAuthConsumerKey("LGya8GWbitBpZMEYVTVSAmphb")
            .setOAuthConsumerSecret("tbuFJ1r1pt0tAHPV1IkvI8Ouy28QOGZS8LJswKc4Sslcb1UbF7")
            .setOAuthAccessToken("383855581-pSxjbbILvzuT28xY12xFStIRLKnbPKok02vzbVSC")
            .setOAuthAccessTokenSecret("YlUoiGp120CAIbnhcuUzWjrXzya6w0Is1lwZNd8TLlt6w");

    TwitterFactory tf = new TwitterFactory(cb.build());
    twitter4j.Twitter twitter = tf.getInstance();
    Query query = new Query(foofoo);
    QueryResult result = twitter.search(query);
    String[] tweets = new String[20];
    int i = 0;
    for (Status status : result.getTweets()) {
        tweets[i] = "@" + status.getUser().getScreenName() + ":" + status.getText();
        ++i;
    }
    return tweets;
  }
}
