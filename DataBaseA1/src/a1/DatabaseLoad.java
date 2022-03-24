package a1;

public class DatabaseLoad {

	public static void main(String[] args) {
		if (args[0].equals("-p") && args.length == 3) {
			HeapFile heapFile = new HeapFile();
			heapFile.readFile(Integer.parseInt(args[1]), args[2]);
		} else {
			System.out.println("Incorrect Arguments");
		}

	}

}
