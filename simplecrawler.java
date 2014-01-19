import java.net.URL;
import java.io.*;


//main class
public class simplecrawler{


	//main method
	public static void main(String[] args) throws Exception {

		// command line argument stored into strings
		String urlStr = args[0];
		String keyWord = args[1];

		URL rawURL = new URL(urlStr);// URL handler

		String rawHTML = URLtoStr(rawURL); // calling URLtoStr method
		String text = tagRemove(rawHTML);// calling tagRemove Method
		matcher(text, keyWord);// Calling matcher method

	}












	
	
	
	
	/*URLtoStr method takes URL type, open it then dump it into a string
	 * */
	public static String URLtoStr(URL page){
		//string buffer to build the string while reading from stream
		StringBuffer HTMLbuff = new StringBuffer();


		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(page.openStream()));//URL stream reader
			String tempStr;
			while ((tempStr = input.readLine()) != null) {
				HTMLbuff.append(tempStr);//building the string untill it hit the EOF
			}
			input.close();//trashing the handler
		} catch (IOException e) {
		}


		String rawStr = HTMLbuff.toString();//String buffer to String

		return rawStr;
	}



	/*tagRemove method takes a raw HTML string and parse it using Regexp patterns
	 * and replace it with null char then returns the string clearText.
	 * it might look a bit confusing but its pretty simple if you can read regex magic :D 
	 * */
	public static String tagRemove(String rawHTML){

		String cleanText = rawHTML.replaceAll("<.*?>|"+ //general tag pattern
				                              "<.*>.*?</.*>"  ,"").trim(); //greedy extended tag pattern         
		return cleanText;
	}



	/*matcher method tests the keyword against the clean text string array
	 * if it hits a match it will print out the result while iterating through the 
	 * Array, Also counts the number of matches while iterating.
	 * */
	public static void matcher(String CleanText, String keyWord){

		String[] strArr = CleanText.split(" ");// splitting single strings by whitespace
		int count= 0;//# of matches

		//tests the keyword against the array strings regardless of case
		for(int i=0;i<strArr.length;i++){
			if(strArr[i].equalsIgnoreCase(keyWord)){
				System.out.println(Integer.toString(i)+", "+strArr[i+1].toString());
				count++;
			}else {continue;}
		}
		//printing out the result
		if(count == 1){
			System.out.print(Integer.toString(count)+" Match found!");
		}else{
			System.out.print(Integer.toString(count)+" Matches found!!");}

	}



}