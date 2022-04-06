
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapFile {
	
	
	//List to store records
	private ArrayList<Record> records = new ArrayList<Record>();
	//writer for data
	private FileWriter writer;
	//read in the CSV
	private BufferedReader reader;
	 
	//basic constructor
	public HeapFile() {
		
	}
	
	//main method where the files will be read from and data will be extrapolated.
	public void readFile(int pageSize, String file) throws FileNotFoundException {
		//create reader object
		reader = new BufferedReader(new FileReader(file));
		//timer starts
		long startTime = System.currentTimeMillis();
		//variables to keep track of pages
		//start on second page in the csv
		int pageNum = 1;
		
		//begin as an empty string
		String entry = "";
		try {
			//ensure the csv is able to be read in correctly.
			entry = reader.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			//when the reader has a valid line
			while ((entry = reader.readLine()) != null) {
				//split entry into tokens
				String[] tokens = entry.split(",", -1);
				//check how many tokens are in the line
				if (tokens.length == 11) {
					
					//set the id to 0
					int wikiPage_ID = 0;
					//if tokens arent null
					//since wikiPage_ID isnt a string it must take a few more steps to be recorded
					if (tokens[9] != null)
					{ 
						//if tokens arent empty
						if (!tokens[9].isEmpty()) 
						{
							//assign wikipage to a token
							wikiPage_ID = Integer.parseInt(tokens[9]);
						}
					}
					//create a record object 
					Record record = new Record(tokens[0], 
							tokens[1],
							tokens[2],
							wikiPage_ID, 
							tokens[3],
							tokens[4],
							tokens[5],
							tokens[6],
							tokens[7],
							tokens[8],
							tokens[9]);
					//add to the array
					records.add(record);
					entry = reader.readLine();
				}
			}
			Page page = new Page(pageSize);
			try {
				//create writer
				writer = new FileWriter(new File("heap." + pageSize));
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (Record record : records) {
				//determine how much space is available on the page and if the record will still fit on the page
				int recordSize = NumOfBytes(record.getBinary());
				//if theres space, write the next line
				if (page.getSpaceFree() > recordSize) {
					page.setFreeSpace(page.getSpaceFree() - recordSize);
					//otherwise create a new page
				} else {
					pageNum++;
					page = new Page(pageSize);
				}
				try {
					writer.write(record.getBinary());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//get time by end of operation
		long endTime = System.currentTimeMillis();
		System.out.println("Records Loaded: " + records.size());
		System.out.println("Page Count: " + pageNum);
		System.out.println("Time Taken (milliseconds): " + (endTime - startTime));
		try {
			//close writer
			writer.close();
			//closer reader
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//Part 2 work, incomplete
	public void rangeQuery(String file, String d1, String d2) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		
		System.out.println("Artists: ");
		System.out.println("Time Taken (milliseconds): " + (endTime - startTime));
	}
	
	
	private int NumOfBytes(String input) throws UnsupportedEncodingException {
		byte[] value = input.getBytes("UTF-8");

		return value.length;
	}
}
