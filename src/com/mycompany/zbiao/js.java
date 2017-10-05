package com.mycompany.zbiao;

public class js
{
	
	public static float answer(String need)
	{

		String str = need;
		String str1 = str;
		float answer = 0;
				
		if(str.contains("+")==true)
		{
			str = str.substring(str.indexOf(""),str.indexOf("+"));
			str1 = str1.substring(str1.indexOf("+")+1,str1.indexOf("\""));

			float a = Integer.parseInt(str);
			float b = Integer.parseInt(str1);
			
			answer = a+b;
			
		}
		
		if(str.contains("-")==true)
		{
			str = str.substring(str.indexOf(""),str.indexOf("-"));
			str1 = str1.substring(str1.indexOf("-")+1,str1.indexOf("\""));

			float a = Integer.parseInt(str);
			float b = Integer.parseInt(str1);
			
			answer = a-b;
		}
		
		if(str.contains("*")==true)
		{
			str = str.substring(str.indexOf(""),str.indexOf("*"));
			str1 = str1.substring(str1.indexOf("*")+1,str1.indexOf("\""));

			float a = Integer.parseInt(str);
			float b = Integer.parseInt(str1);
			
			answer = a*b;
		}
		
		if(str.contains("/")==true)
		{
			str = str.substring(str.indexOf(""),str.indexOf("/"));
			str1 = str1.substring(str1.indexOf("/")+1,str1.indexOf("\""));

			float a = Integer.parseInt(str);
			float b = Integer.parseInt(str1);
			
			answer = a/b;
		}	
		
		return answer;
	}
}
