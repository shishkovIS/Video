package Logic;



public class Copy {
	private int id;
	private Movie movie;
	private CopyType copyType;
	private int count;
	private int countAvailable;
	private int rentCost;
	private boolean isRemoved;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public CopyType getCopyType() {
		return copyType;
	}
	public void setCopyType(CopyType copyType) {
		this.copyType = copyType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCountAvailable() {
		return countAvailable;
	}
	public void setCountAvailable(int countAvailable) {
		this.countAvailable = countAvailable;
	}
	public int getRentCost() {
		return rentCost;
	}
	public void setRentCost(int rentCost) {
		this.rentCost = rentCost;
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