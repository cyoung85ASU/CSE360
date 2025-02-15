package questionAndAnswerApplication;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p> Title: Answer Class </p>
 * 
 * <p> Description: A class designed to create an Answer object that users can reply to questions with  in the 
 * Q & A Application with multiple unique identifiers to store the questions. </p>
 * 
 * @author Callan Young
 * 
 * @version 1.00		2024-02-14	Initial baseline 
 * 
 */

// Question Class
/*******
 * <p> Title: Answer Class. </p>
 * 
 * <p> Description: Represents an individual answer in the Q&A system. </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2024 </p>
 * 
 * @author Lynn Robert Carter
 * 
 * @version 1.00    2024-02-14 Initial version
 * 
 */
public class Answer {
	private final String id; // Unique identifier for the Answer
	private String text; // Actual question text
	private String author; // User that gave the answer. 
	private LocalDateTime timestamp; // Time stamp 
	
	// Constructor
	public Answer(String txt, String auth)
	{
		id = UUID.randomUUID().toString(); // Creates a unique 4-character string to identify the Answer
		text = txt; // Initialized the text 
		author = auth; // Initializes the author 
		timestamp = LocalDateTime.now(); // Uses Java time API to store the current time stamp of when the 
										 // question was asked 		
	}
	
	// Getter methods
	public String getId() { return id; }
	public String getAnswer() { return text; }
	public String getAuthor() { return author; }
	public LocalDateTime getTimestamp() { return timestamp; } 
	
	//Setter Methods
	public void setAnswer(String newAnswer) { text = newAnswer; }
	public void setTimeStamp() { timestamp = LocalDateTime.now(); }

}
