public class Magpie2
{
	public String getGreeting()
	{
		return "Hey, what's up?.";
	}
	
	public String getResponse(String statement)
	{
		String response = "";
		
		
		if (statement.trim().length() ==0)
		{
			response = "Come on man, whats up?";
			return response;	
		}
		
		if (statement.indexOf("no") >= 0)
		{
		response = "Why the negativity?";	
		} else if (statement.indexOf("cat") >=0 || statement.indexOf("dog") >=0 )
		{
		response = "What about your dog?";
		} else if (statement.indexOf("Edhesive") >=0)
		{
		response = "A great program that teaches computer science";
		} else if (statement.indexOf("mother") >= 0 || statement.indexOf("father") >= 0
		|| statement.indexOf("sister") >= 0
		|| statement.indexOf("brother") >= 0)
		{
		response = "Tell me about your family.";
		} else if (statement.indexOf("cringe") >=0)
		{
		response = "What did I do?";
		} else if (statement.indexOf("Nothing") >=0)
		{
		response = "Yes, Nothing";
		} else if (statement.indexOf("Nothing, really?") >=0)
		{
		response = "I don't believe so.";
		} else
		{
		response = getRandomResponse();
		}
		return response;
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
