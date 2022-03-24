package a1;

public class BytesConverter {
	
	public BytesConverter() {
		
	}
	
	public int bytesToAllowEntry(int value) {
		int result = (int) Math.ceil((int)(Math.log(value) / Math.log(2)));
		
		return nearestMultiple(8, result)/8;
	}

	public int nearestMultiple(int multiple, int value) {
		return (value + (multiple - 1)) / multiple * multiple;
	}


	
	public int numOfBytes(String value) {
		return value.length()/8;
	}
	
	public String intToNearestBytes(int value) {
		String binary = intToBinary(value);
		String binaryBytes = String.format(
				"%" + nearestMultiple(8, binary.length()) + "s", binary).replaceAll(" ", "0");
		
		return binaryBytes;
	}
	
	public String intToBinary(int value) {
		String binary = Integer.toBinaryString(value);
		return binary;
	}
	
	public String stringToBinary(String value) {
		String binary = "";
		
		char[] charValue = value.toCharArray();
		for (char c : charValue) {
			binary += String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0");
		}
		
		return binary;
	}
	
	public String intToBytes(int value, int bytes) {
		String binary = intToBinary(value);
		
		String binarySize = String.format(
				"%" + bytes*8 + "s"
				, binary).replaceAll(" ", "0");
		
		return binarySize;
		
	}
}