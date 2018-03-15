public class Magpie3
{
	public String getGreeting()
	{
		return "Hey, what's up?";
	}
	public void doNothing (int dud) {	
	}
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Come on man, whats up?;
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
		else
		{
			response = getRandomResponse();
		}
		return response;
	}
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(),startPos);

		while (psn >= 0)
		{
			String before = " ", after = " ";
			if (psn > 0)
			{
			before = phrase.substring(psn - 1, psn)
			.toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
			after = phrase.substring(
			psn + goal.length(),
			psn + goal.length() + 1)
			.toLowerCase();
			}
			if (((before.compareTo("a") < 0) || (before
			.compareTo("z") > 0))
			&& ((after.compareTo("a") < 0) || (after
			.compareTo("z") > 0)))
			{
			return psn;
			}
			psn = phrase.indexOf(goal.toLowerCase(),
					psn + 1);
		}

		return -1;
	}
	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
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
