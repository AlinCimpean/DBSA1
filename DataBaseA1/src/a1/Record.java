package a1;

public class Record {
	
	private final int fieldCount = 10;
	
	private int birthDate;
	private String birthPlace;
	private int deathDate;
	private String fieldLabel;
	private String genreLabel;
	private String instrumentLabel;
	private String nationality;
	private String thumbnail;
	private String wikiPage_ID;
	private String description;
	
	public Record(int birthDate, String birthPlace, int deathDate, String fieldLabel, String genreLabel, String instrumentLabel, String nationality, String thumbnail,
			String wikiPage_ID, String description) {
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.deathDate = deathDate;
		this.fieldLabel = fieldLabel;
		this.genreLabel = genreLabel;
		this.instrumentLabel = instrumentLabel;
		this.nationality = nationality;
		this.thumbnail = thumbnail;
		this.wikiPage_ID = wikiPage_ID;
		this.description = description;
	}
	
	

}
