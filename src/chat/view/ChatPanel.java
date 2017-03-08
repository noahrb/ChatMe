package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JButton colorButton;
	
	/**
	 * Constructs GUI components.
	 * @param baseController
	 */
	public ChatPanel(ChatbotController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.chatDisplay = new JTextArea(5, 25);
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 45, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, -33, SpringLayout.EAST, this);
		this.chatField = new JTextField(25);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -45, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -6, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 68, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, -68, SpringLayout.EAST, this);
		this.chatButton = new JButton("Chat with the bot");
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 229, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatField);
		this.colorButton = new JButton("Change BG");
		baseLayout.putConstraint(SpringLayout.NORTH, colorButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, colorButton, 10, SpringLayout.WEST, chatField);

		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	/**
	 * Sets the proper chatDisplay attributes.
	 */
	public void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setEnabled(false);
	}
	
	/**
	 * Adds the components to the panel and set the BG Color.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatDisplay);
		this.add(colorButton);
	}
	
	/**
	 * Auto Generated code
	 */
	private void setupLayout()
	{
	}
	
	/**
	 * Links the buttons to methods.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click){
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				
				chatDisplay.setText("You said: " + userWords + "\n" + "Chatbot said: " + botResponse);
				chatField.setText("");
			}
		});
		colorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(getRandomColor());
			}
		});
	}
	/**
	 * Shows a message in JTextArea
	 * @param message the text to display
	 */
	public void showMessage(String message) {
		chatDisplay.setText(message);
		
	}
	
	/**
	 * Method to create random color
	 * @return Random color
	 */
	public Color getRandomColor() 
	{
		int r = (int) (Math.random() * 255);
		int g = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		return new Color(r, g, b);
	}
	
	
	
	
}
