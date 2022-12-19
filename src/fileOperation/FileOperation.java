package fileOperation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class FileOperation {
	private String contentOfFile;
	private int numberOfLines;
	private int numberOfColumns;
	
	/*
	 * This constructor creates a FileOperation object that holds
	 * contentOfFile, numberOfLines, and numberOfColumns data.
	 */
	public FileOperation() {
		this.contentOfFile="";
		this.numberOfLines=0;
		this.numberOfColumns=0;
	}
	/*
	 * This method reads the file and assigns the contents to String value contentOfFile.
	 * Also counts the number of lines and number of columns and assigns to numberOfLines and numberOfColumns
	 */
	public void takeTheContentOfFile(String fileName){
		BufferedReader br ;
		String line;
		String tempContentHolder="";
		int numberOfLines=0;
		int initialColumnNumbers=0;
		int currentColumnNumbers=0;
		int maxColumnNumbers=0;
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			line= br.readLine();
			initialColumnNumbers = countColumns(line);
			while(line!=null) {
				numberOfLines++;
				tempContentHolder+=line+"***";
				line= br.readLine();
				if (line!=null) currentColumnNumbers=countColumns(line);
				if(initialColumnNumbers!=currentColumnNumbers) {
					System.out.println("There is a missing information in a file");
					maxColumnNumbers=Math.max(initialColumnNumbers, currentColumnNumbers);
				}
			}			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.contentOfFile=tempContentHolder;
		this.numberOfLines=numberOfLines;
		this.numberOfColumns=Math.max(initialColumnNumbers, maxColumnNumbers);
	}
	/*
	 * This method separates the attributes and counts columns
	 */
	private int countColumns(String line){
		StringTokenizer attributeSeparater = new StringTokenizer(line,",");
		return attributeSeparater.countTokens();		
	}
	/*
	 * This method creates an two dimensional array that holds the content of file.
	 */
	public String[][] generateArrayForContentOfFile(){
		int numberOfLines = getNumberOfLines();
		int numberOfCoulmns = getNumberOfColumns();
		String[][] contentArray= new String[numberOfLines][numberOfCoulmns];
		StringTokenizer lineFinder = new StringTokenizer(getContentOfFile(),"***");
		for(int lineIndex=0;lineIndex<numberOfLines;lineIndex++) {
			String line = lineFinder.nextToken();
			StringTokenizer columnFinder= new StringTokenizer(line,",");
			for(int columnIndex=0;columnIndex<numberOfCoulmns;columnIndex++) {
				contentArray[lineIndex][columnIndex]= columnFinder.nextToken();			}
		}
		return contentArray;
	}
	
	
	public int getNumberOfLines() {
		return numberOfLines;
	}
	
	

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	
	private String getContentOfFile() {
		return contentOfFile;
	}
	
	
}

