Chat Client Application Implemented Features and Object Oriented Design Patterns 


The chat client android application has a simple UI. It contains a view which displays
incoming messages from the server and all messages sent by the chat participants.
There is also a space in which to write messages to be sent to the server and the send button for it.

When first opening the application, you get a welcoming message to confirm connection to the server.
To be able to write messages to other participants, the user needs to set their username.
This is done with the commant ":user [username]". 
After this all messages sent to the server which done begin with ":", are seen by other users.

Other chat commands begin with ":". There commands include

- :history
	Prints a list of all messages since the initiation of the server.

- :users
	Prints all the current connected usernames.
	
- :exit
	Exits from the server. Removes the username from connected users. At this moment, to reconnect to the 
	server, the user needs to restart the application.
	
	
The android application code consists of the main activity which inherits AppCompatActivity. The MainActivity stores and initializes variables for the application,
and also contains multiple inner classes which inherit the Runnable() interface. This enables them to be run on their own threads or in the main UI thread.

The MainActivity initializes the main view which contains a RecyclerView to contain the chat messages, the EditText box to write messages and then the send button.
The second class in the code is the ChatAdapter which updates and control the data in the RecyclerView. This is initialized in the MainActivity. 
This class contains the view holder for the text of the messages, and 3 override functions.

Otherwise the android application code has 3 custom .xml files for the MainActivity, RecyclerView and a .xml to create borders to separate the individual chat messages.
