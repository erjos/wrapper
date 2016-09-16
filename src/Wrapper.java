
public class Wrapper {

	// returns string, no line may be longer than the number of columns
	public static String wrapper(String string, int col) {

		String result = "";
		int counter = 0;

		String remainder = string;
		
		while( counter < string.length()) {
			
			int lineMarker = 0;
			String line = "";

			while (lineMarker <= col) {	
				
				int spaceIndex = remainder.indexOf(" ");
				// index is accurately counting number of letters
				
				String word = remainder.substring(0, spaceIndex + 1); 
				// need the plus one to include the space in the substring
				
//				if(word.length()>col){
//					
//					String wordA = word.substring(0, col);
//					line = line + "\n"+ wordA;
//					System.out.println(line);
//					remainder = remainder.substring(col);
//					lineMarker = col+1;
//					
//				}
				
				if(spaceIndex == -1){  
					
					if((line + remainder).length()<=col){
					line = line+remainder;
					lineMarker = col + 1;
					//break; 
					}else if((line + remainder).length()> col){
					line = line+"\n"+remainder;
					lineMarker = col+1;
					
					//break;
					}
				}
				
				lineMarker = lineMarker + (spaceIndex + 1);
				// need to include the spaces after each word

				if (lineMarker <= (col) || lineMarker - 1 == col) { 
					line = line.concat(word);
					
					remainder = remainder.substring(spaceIndex + 1);
					
				}
			}

			counter = line.length() + counter;

			result = result + line.concat("\n");
			
		}
		return result;
	}

	public static void main(String[] args) {
		String test = "Hi, my name is bob what is your name?";
		int col = 5; //bug when you use a col number that is shorter than the longest word and that word is not the last word of the string

		String result = wrapper(test, col);
		System.out.println(result);

	}

}
