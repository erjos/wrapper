
public class Wrapper {

	// returns string, no line may be longer than the number of columns
	public static String wrapper(String string, int col) {

		String result = "";
		int counter = 0;

		String remainder = string;
		
		while( counter < string.length()) {
			
			int marker = 0;
			String line = "";

			while (marker <= col) {
				
//				if(remainder.length() <= col){
//					line = remainder;
//				}
//				
				
				int index = remainder.indexOf(" "); // index throws -1 when there isn't a space?
				// index is accurately counting number of letters
				
				String word = remainder.substring(0, index + 1); //should check to see if the word is shorter or longer than the col number here
				// need the plus one to include the space in the substring
				
				if(index == -1){  
					if((line + remainder).length()<=col){
					line = line+remainder;
					marker = col + 1;
					break; //not sure if we need this break here... might be able to get rid of them
					}else if((line + remainder).length()> col){
					line = line+"\n"+remainder;
					marker = col+1;
					break;
					}
				}
				
				marker = marker + (index + 1);
				// need to include the spaces after each word

				// marker is accurately tracking number of columns

				if (marker <= (col) || marker - 1 == col) { 
					line = line.concat(word);
					
					remainder = remainder.substring(index + 1);
					
				}
			}

			counter = line.length() + counter;

			result = result + line.concat("\n");
		}
		return result;
	}

	public static void main(String[] args) {
		String test = "i like cheese and crackers";
		int col = 5; //bug when you use a col number that is shorter than the longest word and that word is not the last word of the string

		String result = wrapper(test, col);
		System.out.println(result);

	}

}
