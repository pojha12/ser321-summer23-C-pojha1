package Assign32starter; 
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ClientGui implements Assign32starter.OutputPanel.EventHandlers { 
	JDialog frame;
	PicturePanel picturePanel;
	OutputPanel outputPanel;
  
	Random random = new Random();
	String input = "";
	String pID = "";
	int score = 0;
	boolean gameOn = false;
	Map<String, Integer> leaderboard = new HashMap<String, Integer>();
	Integer points = 5;
	Integer correctAnswers = 0;
	String places[] = {"ireland", "berlin", "phoenix", "rome", "switzerland", "sfo", "paris"};
	String ansChoices[] = {"ireland", "berlin", "phoenix", "rome", "switzerland", "sfo", "paris"};
	boolean updated;
	int updateCode = -1;
	int moreCount =0;
	Integer currentImage = random.nextInt(0, 6);
	Integer currentImageNumber = 1;
  
  
	/**
	 * Construct dialog
	 */
	public ClientGui() {
	  frame = new JDialog();
	  frame.setLayout(new GridBagLayout());
	  frame.setMinimumSize(new Dimension(500, 500));
	  frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  
	  // setup the top picture frame
	  picturePanel = new PicturePanel();
	  GridBagConstraints c = new GridBagConstraints();
	  c.gridx = 0;
	  c.gridy = 0;
	  c.weighty = 0.25;
	  frame.add(picturePanel, c);
  
	  // setup the input, button, and output area
	  c = new GridBagConstraints();
	  c.gridx = 0;
	  c.gridy = 1;
	  c.weighty = 0.75;
	  c.weightx = 1;
	  c.fill = GridBagConstraints.BOTH;
	  outputPanel = new OutputPanel();
	  outputPanel.addEventHandlers(this);
	  frame.add(outputPanel, c);
	}
  
	/**
	 * Shows the current state in the GUI
	 *
	 * @param makeModal - true to make a modal window, false disables modal behavior
	 */
	public void show(boolean makeModal) {
	  frame.pack();
	  frame.setModal(makeModal);
	  frame.setVisible(true);
	}
  
	/**
	 * Creates a new game and set the size of the grid
	 *
	 * @param dimension - the size of the grid will be dimension x dimension
	 */
	public void newGame(int dimension) {
	  picturePanel.newGame(dimension);
	}
  
	/**
	 * Insert an image into the grid at position (col, row)
	 *
	 * @param filename - filename relative to the root directory
	 * @param row      - the row to insert into
	 * @param col      - the column to insert into
	 * @return true if successful, false if an invalid coordinate was provided
	 * @throws IOException An error occured with your image file
	 */
	public boolean insertImage(String filename, int row, int col) throws IOException {
	  String error = "";
	  try {
		// insert the image
		if (picturePanel.insertImage(filename, row, col)) {
		  return true;
		}
		error = "File(\"" + filename + "\") not found.";
	  } catch (PicturePanel.InvalidCoordinateException e) {
		// put error in output
		error = e.toString();
	  }
	  outputPanel.appendOutput(error);
	  return false;
	}
  
	/**
	 * Submit button handling
	 * <p>
	 * Change this to whatever you need
	 */
	@Override
	public void submitClicked() {
	  input = outputPanel.getInputText();
  
	  if (!input.isBlank()) {
		outputPanel.setInputText("");
		outputPanel.appendOutput(input);
	  }
  
	  if (input.isBlank()) {
		outputPanel.setInputText("");
	  }

	  else if (pID.equals("")) {
		updateCode = 1;
		updated = true;
		System.out.println("received a name");
		pID = input;
		outputPanel.appendOutput("Hello " + pID + "! if you want to view leaderboard type 'leader' then press enter");
		outputPanel.appendOutput("if you want to start the game type 'start' then press enter\nTo exit the program, type 'quit' then press enter");
	  }

	  else if (input.equals("leader") && !gameOn) { 
		updateCode = 2;
		updated = true;
		System.out.println("Got a leader");
		outputPanel.appendOutput(leaderboard.toString());
	  } 

	  else if (input.equals("start") && !gameOn) { 
		updateCode = 3;
		updated = true;
		gameOn = true;
		nextImage();
	  }

	  else if(score <= -3){
		updateCode = 5;
		updated = true;
		System.out.println("Player Lose");
		outputPanel.appendOutput("You Lose! You earned " + score + "points.");
		try{
		  insertImage("img/lose.jpg",0,0);
		}
		catch (IOException e){
		  e.printStackTrace();
		}
		gameOn = false;
		gameReset();
	  }
	  
	  else if (input.equals("next") && gameOn) { 
		updateCode = 4;
		updated = true;
		System.out.println("Skipped");
		nextImage();
		score -= 4;
		outputPanel.setPoints(score);
		points = 5;
	  } 

	  else if (input.equals("more") && gameOn) { 
		moreCount++;
		if (currentImageNumber < 4) {
		  if (moreCount == 1) {
			updateCode = 4;
			updated = true;
			moreImages();
			points = 4;
		  }
		  else if(moreCount == 2){
			  updateCode = 4;
			  updated = true;
			  moreImages();
			  points = 3;
		  }
		  else if (moreCount == 3) {
			  updateCode = 4;
			  updated = true;
			  moreImages();
			  points = 1;
			}
		  }
		else {
			outputPanel.appendOutput("There are no more images.");
		  }
		} 
	  else if (input.equals("quit")) {
		System.out.println("Quitting");
		updateCode = 0;
		updated = true;
		System.exit(0);
	  }

	  else if (input.equals(ansChoices[currentImage].toLowerCase()) && gameOn) {
		  System.out.println("Correct");
		  outputPanel.appendOutput("Correct!");
		  score += points;
		  outputPanel.setPoints(score);
		  points = 5;
		  correctAnswers++;
  
		  if (score >= 12) {
			updateCode = 5;
			updated = true;
			System.out.println("Player Wins!");
			outputPanel.appendOutput("WINNER! You have " + score + " points.");
			try {
			  insertImage("img/win.jpg", 0, 0);
			}
			catch (IOException e) {
			  e.printStackTrace();
			}
			gameReset();
		  }
		else {
		 	nextImage();
		}
	}
	  else if (gameOn) {
		  System.out.println("Wrong");
		  outputPanel.appendOutput("WRONG!");
		}
	  else {
		  System.out.println("Unknown Command");
		  outputPanel.appendOutput("Unknown Command!");
		}
	  }
  
	  /**
	   * Key listener for the input text box
	   *
	   * Change the behavior to whatever you need
	   */
	  @Override
	  public void inputUpdated (String input){
	  }
  
	  public void gameReset () {
		outputPanel.appendOutput("Type your name in again and press enter. \nTo exit the program, type 'quit' and press enter");
		if (leaderboard.containsKey(pID)) {
		  if (score > leaderboard.get(pID)) {
			leaderboard.put(pID, score);
		  }
		} else {
		  leaderboard.put(pID, score);
		}
  
		outputPanel.setPoints(0);
		points = 5;
		correctAnswers = 0;
		score = 0;
		pID = "";
		gameOn = false;
	  }

	  public void moreImages () {
		currentImageNumber++;
		points--;
		System.out.println("Image number: " + currentImageNumber);
		outputPanel.appendOutput("Here is another image.");
		String imgStr = currentImageNumber.toString();
		try {
		  insertImage("img/" + places[currentImage] + "/" + places[currentImage] + imgStr + ".jpg", 0, 0);
		} catch (IOException e) {
		  e.printStackTrace();
		}
	  }
  
	  public void nextImage () {
		currentImageNumber = 1;
		currentImage = (currentImage + 1) % 7;
		System.out.println(places[currentImage]);
		String imgStr = currentImageNumber.toString();
		System.out.println("Image number: 1");
		outputPanel.appendOutput("What city or country?");
		moreCount = 0; 
		try {
		  insertImage("img/" + places[currentImage] + "/" + places[currentImage] + imgStr + ".jpg" , 0, 0);
		} catch (IOException e) {
		  e.printStackTrace();
		}
	  }
  
	  public static void main (String[]args) throws IOException {
  
		// create the frame
		ClientGui main = new ClientGui();
  
		// set up the UI to display on image
		main.newGame(1);
  
		main.insertImage("img/hi.png", 0, 0);
		main.outputPanel.appendOutput("Hello. Enter your name: ");
		main.show(true); // you should not have your logic after this. You main logic should happen whenever "submit" is clicked
	  }
  }
