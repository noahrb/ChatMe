package chat.model;

import java.util.List;

import chat.controller.ChatbotController;

public class CTEC 
{

	private ChatController baseController;
	private Twitter twitterBot;
	private List<String> tweetedWords;
	private List<Status> allTheTweets;
	
	public CTEC(ChatbotController baseController)
	{
		
	}
	
	private String [] createIgnoredWordsArray()
	{
		
	}
	
	private void removeBlankWords()
	{
		
	}
	
	private void gatherTheTweets(String user)
	{
		
	}
	
	public sendTweet(String textToTweet)
	{
		
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
}
