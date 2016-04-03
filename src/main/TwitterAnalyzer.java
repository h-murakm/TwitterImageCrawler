package main;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterAnalyzer {

	String dir;
	String word;

	public TwitterAnalyzer(String dir, String word) {
		this.dir = dir;
		this.word = word;
	}

	public void process() {
		Twitter twitter = new TwitterFactory().getInstance();
		Query query = new Query();
		query.setQuery(word);
		query.setLang("ja");
		try {
			QueryResult result = twitter.search(query);
			for (Status status : result.getTweets()) {
				System.out.println(status.getUser().getName());
				System.out.println(status.getCreatedAt().toString());
				System.out.println(status.getText());
				System.out.println();
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
