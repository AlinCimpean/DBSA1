
public class Page {
	
	private int pageSize;
	private int freeSpace;
	
	public Page(int pageSize) {
		this.pageSize = pageSize;
		this.freeSpace = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getSpaceFree() {
		return freeSpace;
	}
	public void setFreeSpace(int value) {
		this.freeSpace = value;
	}
	

}
