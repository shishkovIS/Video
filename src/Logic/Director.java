package Logic;

public class Director {
	private int id;
	private String directorName;
	private boolean isRemoved;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
    public boolean getIsRemoved()
    {
        return isRemoved;
    }
    public void setIsRemoved(boolean isRemoved)
    {
        this.isRemoved = isRemoved;
    }
	
}