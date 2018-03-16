public class Magpie4
{
	public String getGreeting()
	{
	return "Hey, what's up?.";
	}
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
		response = "Come on man, whats up?";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
		response = "Why are you like that?";
		}
		else if (findKeyword(statement, "mother") >= 0
		|| findKeyword(statement, "father") >= 0
		|| findKeyword(statement, "sister") >= 0
		|| findKeyword(statement, "brother") >= 0)
		{
		response = "Tell me about your family.";
		}
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
		response = transformIWantToStatement(statement);
		}

		else
		{
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
			&& findKeyword(statement, "me", psn) >= 0)
			{
			response = transformYouMeStatement(statement);
			}
			else
			{
			response = getRandomResponse();
			}
		}
		return response;
	}
	private String transformIWantToStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}
	private String transformYouMeStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What gives you the idea that I " + restOfStatement + " you?";
	}
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		while (psn >= 0) 
		{
			String before = " ", after = " "; 
			if (psn > 0)
			{
			before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
			after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
			&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
			return psn;
			}
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
		}
		
		return -1;
	}
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
		response = "Is that so? Please elaborate?.";
		}
		else if (whichResponse == 1)
		{
		response = "Really?.";
		}
		else if (whichResponse == 2)
		{
		response = "Why?";
		}
		else if (whichResponse == 3)
		{
		response = "How?.";
		}
		else if (whichResponse == 4)
		{
		response = "Why?";
		}
		else if (whichResponse == 5){
		response = "Whats the point?";
		}
		return response;
	}

}
