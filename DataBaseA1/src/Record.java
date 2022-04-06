
public class Record {
	
	private String instrument_label;
	private String nationality_label;
	private String thumbnail;
	private int wikiPage_ID;
	private String description;
	private String person_Name;
	private String birth_Date;
	private String birthPlace_label;
	private String death_Date;
	private String field_label;
	private String genre_label;

	public Record(String instrument_label, String nationality_label, String thumbnail, int wikiPage_ID,
			String description, String person_Name, String birth_Date, String birthPlace_label, String death_Date, String field_label,
			String genre_label) {
		
		this.instrument_label = instrument_label;
		this.nationality_label = nationality_label;
		this.thumbnail = thumbnail;
		this.wikiPage_ID = wikiPage_ID;
		this.description = description;
		this.person_Name = person_Name;
		this.birth_Date = birth_Date;
		this.birthPlace_label = birthPlace_label;
		this.death_Date = death_Date;
		this.field_label = field_label;
		this.genre_label = genre_label;
		
	}
	public String getPerson_Name() {
		return person_Name;
	}

	public String getBirth_Date() {
		return birth_Date;
	}

	public String getBirth_Place() {
		return birthPlace_label;
	}

	public String getDeath_Date() {
		return death_Date;
	}

	public String getField_Label() {
		return field_label;
	}

	public String getGenre_Label() {
		return genre_label;
	}

	public String getInstrument_Label() {
		return instrument_label;
	}

	public String getNationality_Label() {
		return nationality_label;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public int getWikiPage_ID() {
		return wikiPage_ID;
	}

	public String getDescription() {
		return description;
	}
	
	public String stringToBinary(String value) {
		String binary = "";
		
		char[] charValue = value.toCharArray();
		for (char c : charValue) {
			binary += String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0");
		}
		
		return binary;
	}

	public String intToBinary(int value) {
		String binary = Integer.toBinaryString(value);
		return binary;
	}
	
	public String getBinary() {
		String binaryEntry = "";
		String[] binary = { intToBinary(wikiPage_ID),
				stringToBinary(person_Name),
				stringToBinary(birth_Date),
				stringToBinary(birthPlace_label),
				stringToBinary(death_Date),
				stringToBinary(field_label),
				stringToBinary(genre_label),
				stringToBinary(instrument_label),
				stringToBinary(nationality_label),
				stringToBinary(thumbnail),
				stringToBinary(description), };
		for (String data : binary) {
			binaryEntry += data;
		}
		return binaryEntry;
				
				
		
	}

}

