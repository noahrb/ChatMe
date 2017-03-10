package chat.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import chat.controller.ChatbotController;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class CTEC 
{

	private ChatbotController baseController;
	private Twitter twitterBot;
	private List<String> tweetedWords;
	private List<Status> allTheTweets;
	
	public CTEC(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.twitterBot = TwitterFactory.getSingleton();
		this.allTheTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
	}
	
	private String [] createIgnoredWordsArray()
	{
		String[] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine()){
			boringWordScanner.nextLine();
			wordCount++;
		}
		boringWordScanner.close();
		
		boringWords = new String[wordCount];
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boringWords.length; index++){
			boringWords[index] = boringWordScanner.next();
		}
		boringWordScanner.close();
		
		return boringWords;
	}
	
	private void removeBlankWords()
	{
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
				index--;
			}
		}
	}
	
	private void gatherTheTweets(String user)
	{
		tweetedWords.clear();
		allTheTweets.clear();
		
		int pageCount = 1;
		Paging statusPage = new Paging(1, 200);
		
		while(pageCount <= 10){
			try{
				allTheTweets.addAll(twitterBot.getUserTimeline(user, statusPage));
			}catch(TwitterException e){
				baseController.handleErrors(e);
			}
			pageCount++;
		}
	}
	
	public sendTweet(String textToTweet)
	{
		try {
			twitterBot.updateStatus(textToTweet + " @ChatbotCTEC");
		} catch(TwitterException tweetError) {
			baseController.handleErrors(tweetError);
		}catch(Exception e){
			baseController.handleErrors(e);
		}
	}
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText);
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]));
			}
			
			for(String word : tweetWords)
			{
				tweetedWords.add(removePunctuaion(word));
			}
		}
	}
	private String calculateTopWord()
	{
		String results = "";
		String topWord = "";
		int mostPopularIndex = 0;
		int popularCount = 0;
		
		for (int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for (int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
				{
					currentPopularity++;
				}
			}
			if(currentPopularity > popularCount)
			{
				popularCount = currentPopularity;
				mostPopularIndex = index;
				topWord = tweetedWords.get(mostPopularIndex);
			}
		}
		results += " the most popular word was " + topWord + ", and it occured " + popularCount + "times";
		results += "\nThat means it has a percentage of " + popularCount/tweetedWords.size() + "%";
		
		return results;
	}
	
	private String removePunctuatioon(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		
		String scrubbedString = "";
		for(int i=0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
}
