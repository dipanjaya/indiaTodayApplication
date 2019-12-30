package com.ittc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ittc.javabeans.NewsJavaBeans;
import com.ittc.utility.DateFinderUtility;
import com.ittc.utility.TweetToNewsJavaBeansConverter;

@Controller
@RequestMapping
public class IndiaTodayTwitterClientController {

	public static final String TWITTER_BASE_URI = "/";

	@Autowired
	private DateFinderUtility finder;
	
	@Autowired
	private Twitter twitter;

	@Autowired
	private TweetToNewsJavaBeansConverter converter;

	@GetMapping(value = TWITTER_BASE_URI)
	public String getTweetsOfIndiaToday(ModelMap modelMap) {

				fetchTweetsOfIndiaToday(modelMap);

		return "newsFeed";
	}

	public void fetchTweetsOfIndiaToday(ModelMap modelMap) {
		
		modelMap.clear();
		Set<NewsJavaBeans> newsBeans = null;
		List<Tweet> tweets = null;

		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy h:mm a Z");
		TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
		Date d = new Date();
		sdf.setTimeZone(istTimeZone);
		String strtime = sdf.format(d);
		
		tweets = twitter.timelineOperations().getUserTimeline("@IndiaToday", 100);
		newsBeans = converter.getAllNewsJavaBeans(tweets);

		modelMap.addAttribute("newsBeans", newsBeans);
		modelMap.addAttribute("date", finder.getFormatTimeDt(strtime));

	}
}
