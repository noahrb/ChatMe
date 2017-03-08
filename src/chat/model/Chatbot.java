package chat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Base version of the 2016 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Noah Beverly
 * @version 1.1 11/17/16
 * @param <Meme>
 */
public class Chatbot
{
	/**
	 * The list of memes. 
	 */
	private List<String> memesList;
	/**
	 * The list of political topics.
	 */
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.politicalTopicList = new ArrayList<String>();
		this.memesList = new ArrayList<String>();
		this.userName = userName;
		this.content = new String("Sample");
		this.buildMemesList();
		this.buildPoliticalTopicsList();
		
	}
	/**
	 * adds memes to the memesList
	 */
	private void buildMemesList()
	{
		memesList.add("doge");
		memesList.add("pupper");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("doggo");
		memesList.add("troll face");
		memesList.add("drake");
		memesList.add("ken bone");
		memesList.add("vaporwave");
		memesList.add("facepalm");
		memesList.add("furries");
		memesList.add("anime");
		memesList.add("pen pineapple apple pen");
		memesList.add("loss comic");
		memesList.add("slender man");
		memesList.add("pewdiepie");
		memesList.add("bad luck brian");
	}
	
	/**
	 * Adds political topics to politicalTopicList
	 */
	private void buildPoliticalTopicsList()
	{	
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("liberal");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Hillary");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("James Falls");
		politicalTopicList.add("Ken Bone");
		politicalTopicList.add("Jim Fell");
		politicalTopicList.add("Jimmy Fellen");
		politicalTopicList.add("Misty K Snow");
		politicalTopicList.add("Here come dat Garry Johnson");
		politicalTopicList.add("nukes");
		politicalTopicList.add("islamaphobia");
		politicalTopicList.add("foreign policy");
		politicalTopicList.add("United Nations");
		politicalTopicList.add("UN");
		politicalTopicList.add("America");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		String temp = "↷";
		System.out.println(temp + temp.toLowerCase());
		
		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasTopic = false;
		
		for(int index = 0; index < politicalTopicList.size(); index++)
		{
			if(currentInput.equals(politicalTopicList.get(index)))
			{
				hasTopic = true;
			}
		}
		return hasTopic;
	}
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(int index = 0; index < memesList.size(); index++)
		{
			if(currentInput.equals(memesList.get(index)))
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	/**
	 * Checks to see if the currentInput has html information or tags
	 * @param currentInput
	 * @return a boolean containing the checked value.
	 */
	public boolean inputHTMLChecker(String currentInput)
	{
		boolean htmlPresent = false; 
		
		if(currentInput.contains("<P>"))
		{
			htmlPresent = true;
		}
		else if(currentInput.contains("<A HREF=\""))
		{
			int index = currentInput.indexOf("<A HREF=\"") + 9;
			String sub = currentInput.substring(index);
			
			if(sub.contains("\">"))
			{
				int index2 = sub.indexOf("\">");
				String sub2 = sub.substring(index2);
				
				if(sub2.contains(" </a>"))
				{
					htmlPresent = true;
				}
			}
		}
		else if(currentInput.contains("<"))
		{
			String lower = currentInput.toLowerCase();
			int openIndex1 = lower.indexOf("<") + 1;
			String tag = "";
			if(lower.contains(">"))
			{
				int openIndex2 = lower.indexOf(">");
				tag = lower.substring(openIndex1, openIndex2);
				
				String sub = lower.substring(openIndex2 + 1);
				
				if(sub.contains("</" + tag + ">"))
				{
					htmlPresent = true;
				}
			}
		}
		return htmlPresent;
	}
	/**
	 * Checks the currentInput for twitter tags or username
	 * @param currentInput
	 * @return returns boolean containing checked value
	 */
	public boolean twitterChecker(String currentInput)
	{
		boolean twitterCheckerOn = false;
		String sample = currentInput.replaceAll(" ", "");
		if(sample.length() > 1&& !currentInput.startsWith(" "))
		{
			twitterCheckerOn = true;
		}
		return twitterCheckerOn;
	}
	/**
	 * Checks to see if the currentInput is asking to exit, and exits if present. 
	 * @param currentInput
	 * @return returns boolean contianing checked value
	 */
	public boolean quitChecker(String currentInput)
	{
		boolean assertQuit = false;
		
		if(currentInput.equalsIgnoreCase("Quit"))
		{
			assertQuit = true;
		}
		else if(currentInput.equalsIgnoreCase("Exit"))
		{
			assertQuit = false;
		}
		return assertQuit;
	}
	/**
	 * Checks currentInput for keyboard mashing
	 * @param currentInput
	 * @return boolean to determine if mashing is present
	 */
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean keyboardMash = false;
		
		if (currentInput.equalsIgnoreCase("sdf") || currentInput.equalsIgnoreCase("dfg") || currentInput.equalsIgnoreCase("cvb") || currentInput.equalsIgnoreCase(",./"))
		{
			keyboardMash = true;
		}
		return keyboardMash;
	}
	
	//GETTERS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Getter method for UserName object.
	 * @return
	 */
	public String getUserName()
	{
		return userName;
	}
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
	return content;
	}
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public List<String> getMemesList()
	{
		return memesList;
	}
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	
	//SETTERS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * updates the content area for this chatbot instance
	 * @param content The updated value for the content area
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

}
