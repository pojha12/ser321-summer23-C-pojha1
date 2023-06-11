# Assignment 3 Starter Code

## Grid Image Maker Usage

### Terminal

```
gradle runServer
```

```
gradle runClient
```

## GUI Usage

### Code

1. Create an instance of the GUI

   ```
   ClientGui main = new ClientGui();
   ```

2. Create a new game and give it a grid dimension

   ```
   // the pineapple example is 2, but choose whatever dimension of grid you want
   // you can change the dimension to see how the grid changes size
   main.newGame(2); 
   ```

*Depending on how you want to run the system, 3 and 4 can be run how you want*

3. Insert image

   ```
   // the filename is the path to an image
   // the first coordinate(0) is the row to insert in to
   // the second coordinate(1) is the column to insert in to
   // you can change coordinates to see the image move around the box
   main.insertImage("img/Pineapple-Upside-down-cake_0_1.jpg", 0, 1);
   ```

4. Show GUI

   ```
   // true makes the dialog modal meaning that all interaction allowed is 
   //   in the windows methods.
   // false makes the dialog a pop-up which allows the background program 
   //   that spawned it to continue and process in the background.
   main.show(true);
   ```


### ClientGui.java
#### Summary

> This is the main GUI to display the picture grid. 

#### Methods
  - show(boolean modal) :  Shows the GUI frame with the current state
     * NOTE: modal means that it opens the GUI and suspends background processes. Processing still happens in the GUI If it is desired to continue processing in the background, set modal to false.
   * newGame(int dimension) :  Start a new game with a grid of dimension x dimension size
   * insertImage(String filename, int row, int col) :  Inserts an image into the grid, this is when you know the file name, use the PicturePanel insertImage if you have a ByteStream
   * appendOutput(String message) :  Appends text to the output panel
   * submitClicked() :  Button handler for the submit button in the output panel

### PicturePanel.java

#### Summary

> This is the image grid

#### Methods

- newGame(int dimension) :  Reset the board and set grid size to dimension x dimension
- insertImage(String fname, int row, int col) :  Insert an image at (col, row)
- insertImage(ByteArrayInputStream fname, int row, int col) :  Insert an image at (col, row)

### OutputPanel.java

#### Summary

> This is the input box, submit button, and output text area panel

#### Methods

- getInputText() :  Get the input text box text
- setInputText(String newText) :  Set the input text box text
- addEventHandlers(EventHandlers handlerObj) :  Add event listeners
- appendOutput(String message) :  Add message to output text

### Project Description 
This program is a guessing game for the user to guess the name of the city/country based on the image provided. The user can enter "more" to see up to 4 different images of the same city/country. The user can enter "next" if they want to skip this question. If the user has enough points, their name will be on the leaderboard. After the round is over, the user can choose to play again or quit. 

### Requirements for Assignment
1: When the clients starts up it should connect to the server. The server will
reply by asking for the name of the player. 
2: The client should send their name and the server should receive it and
greet the client by name.
3: The client should be presented a choice between seeing a leader board or
playing the game (make the interface easy so a user will know what to do).
4: Evaluations of the input needs to happen on the server side; the client will not know the pictures, their corresponding answers, the points, or the leader board. The
correct answers should not be sent to the client.
5: The leader board will show all players that have played since the server
started with their name and points. 
6: If the client chooses to start the game, the server will then send over
a first image. 
7: The client can then either enter a guess, "more", or "next"
8: The client enters a guess and the server must check the guess
and respond accordingly. If the answer is correct then they will get a new
image with a new country/city (or they might win - see later). If the answer
is incorrect they will be informed that the answer was incorrect and can try
again.
9: If the client enters "more" then they will get another image from
the same country/city. If they enter "more" when the last image was already
displayed for this country/city then they need to be informed that there are no
more pictures.
10: Users can always enter "next" which will make the server send a new
image for a new country/city. If there are no more countries/cities available
you can show one of the old ones or inform the user and quit the round.
11: If you answer on the first image you get 5 points, answer on the second 4 points, on the third 3 points and on the last one 1 point. If the user types "next" they loose 4 point. 
12: If the points reached are greater than 12 the client wins, if they dip below -3 then they lose.
13: At the end of a game (if lost or won) display how many points the client
got. If the user lost, the leader board does not change. If they won check if their
new points are higher and add that as score. You can assume that their name always
identifies them.
14: Your protocol must be robust.
15: Your programs must be robust. 
16:  After the player wins/loses they can start a new game by entering their
name again or they can quit by typing "quit". After entering their name they can
choose start or the leader board again.
17: If a game is in progress and a second client tries to connect, they should receive a message that a game is already in progress and they cannot connect. How exactly you handle this, whether you let the client wait or just do not let them do anything anymore, is up to you. DO NOT use threads, yes I know I am mean.


### How to run program
1: You will need two terminals. One for the client and one for the server. 
2: Start with running "gradle build" on both terminals. This is to build the project. 
3: Go to the server terminal and use the command: gradle runServer -Pport=8080. This will start the server. 
4: Go to the client terminal and use the command: gradle runClient -Pport=8080 -Phost=localhost. This will run the client and connect with the server. 
5: The GUI should pop up which means the connection was successful and you are ready to play. 

### UML and video
   https://youtu.be/4vLx4JlLxIA 
   https://drive.google.com/file/d/15Rb-erRtWSCZKLh7IcZ_YyCmUNwVYiJR/view?usp=drive_link 

### Protocol explanation 
   Request:
   {
      "type" : "game"
   }
   General Response:
   {
      "type" : "game" -echo
   }

   ### Name 
   Request:
   {
      "type" : "Name"
      "playerID" : <String> -name user inputs
   }
   General Response:
   {
      "type": "playerID" - name user inputs
   }
  

   ### Start
   Request:
   {
      "type" : "start"
   }
   General Response:
   {
      "type" : "start" - echo
   }
   

   ### More
   Request:
   {
      "type" : "more"
   }
   General Response:
   {
      "type" : "more" - echo
   }
   

   ### Quit
   Request:
   {
      "type" : "quit"
   }
   General Response:
   {
      "type" : "quit" - echo
   }
   

   ### Error for incorrect input
   Error:
   {
      "type": "error"
      "message": "Unknown Command"
   }

   ### Why is the program robust
   When playing, if the user inputs an incorrect input, the server will respond accordingly with the correct error protocol. The protocol uses headers. If the file (image cannot be found), the error is handled and surrounded by try/catch blocks. The try/catch blocks are implemented multiple places to handle different types of error handling.

   ### UDP Protocol
   UDP uses a DatagramSocket instead of a Socket. In UDP, you need to specify the destination address and port for each packet you send. You will also need to handle and process UDP packets. It needs a byte[] to store all the data that is recived from the client. UDP is a conectionless protocol. You would need to remove the established connection and termination from my code. 