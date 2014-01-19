Name of the project: simplecrawler
Description: Reads the HTML resource at the specified URL and search for a keyword position in readable text format.

Source code contains 4 methods (main, URLtoStr, tagRemove and matcher)

URLtoStr:  takes URL type, open it then dump it into a string

tagRemove: method takes a raw HTML string and parse it using Regexp patterns
	   and replace it with null char then returns the string clearText.

matcher:   tests the keyword against the clean text string array
	   if it hits a match it will print out the result while iterating through the 
	   Array, Also counts the number of matches while iterating.
	  

main :     calls for the other 3 method in order URLtoStr(url)>tagRemove(HTMLtext)>matcher(ClearText,Keyword)


usage: javac simplecrawler.java
       java simplecrawler.java URL Keyword
       e.g. java simplecrawler.java http://flyingelephantlab.com/ flying
	output: 0, elephant
                220, elephant
                2 Matches found!!


Author : Mohamed Tareq. 	 
