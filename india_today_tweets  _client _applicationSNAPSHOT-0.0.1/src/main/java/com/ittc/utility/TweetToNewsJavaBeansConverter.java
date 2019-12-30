package com.ittc.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

import com.ittc.javabeans.NewsJavaBeans;

@Component
public class TweetToNewsJavaBeansConverter {

	@Autowired
	private URLFinder finder;

	public Set<NewsJavaBeans> getAllNewsJavaBeans(List<Tweet> tweets) {

		Set<NewsJavaBeans> newsBeans = null;

		newsBeans = new LinkedHashSet<>(100);

		if (tweets.isEmpty() == false) {
			for (Tweet tweet : tweets) {
				
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
				
				newsBeans.add(new NewsJavaBeans( formatter.format(tweet.getCreatedAt()), tweet.getUnmodifiedText(),
						tweet.getProfileImageUrl(), finder.extractURL(tweet.getUnmodifiedText()), tweet.getFromUser()));
			}
		}

		return newsBeans;
	}

}
