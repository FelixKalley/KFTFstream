import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;




public class PrintSampleStream {
    public static void main(String[] args) {
    	//bla
    	//blablablub
    	ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("p4h5GnRN1PifAiLqPq6Advsgv");
        cb.setOAuthConsumerSecret("zJWx8uzmRjZvEx1idTb3M3HrbcnzKsfVYKhFmnlRo4mdrCVil6");
        cb.setOAuthAccessToken("307545859-kPrLZrDsRbZjaYYzDclEbIV62o1O6fqaKXpEODC9");
        cb.setOAuthAccessTokenSecret("Mbj06hTbxZMXfHlF96l2qfDUJDZvAzVDLjrzoTl4hAjmw");

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        StatusListener listener = new StatusListener() {

            public void onException(Exception arg0) {
                // TODO Auto-generated method stub

            }

            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            public void onStatus(Status status) {
            User user = status.getUser();
                
                // gets Username
                String username = status.getUser().getScreenName();
                System.out.println(username);
                String profileLocation = user.getLocation();
                System.out.println(profileLocation);
                long tweetId = status.getId(); 
                System.out.println(tweetId);
                String content = status.getText();
                System.out.println(content +"\n");

            }

            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

        };
        FilterQuery fq = new FilterQuery();
    
        String keywords[] = {"#WWDC, #WWDC2014"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);  

    }
}