package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatViewer
{
	private String title;
	private ImageIcon chatIcon;
	
	public ChatViewer()
	{
		title = "Sample Window Text";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}
	
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, title,
				JOptionPane.INFORMATION_MESSAGE, chatIcon, null, 
				"Type here please!").toString();
		
		return response;
	}
	
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null,  question);
		
		return response;
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}
}