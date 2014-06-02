package Logic;

import java.util.Set;



public class Movie {
	private int id;
	private String title;
	private int year;
	private Director director;
	private Company company;
	private boolean isRemoved;
	private Set<OrderHistory> historyFilms;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

    public boolean getIsRemoved()
    {
        return isRemoved;
    }

    public void setIsRemoved(boolean isRemoved)
    {
        this.isRemoved = isRemoved;
    }

    public Set<OrderHistory> getHistoryFilms()
    {
        return historyFilms;
    }

    public void setHistoryFilms(Set<OrderHistory> historyFilms)
    {
        this.historyFilms = historyFilms;
    }
	

}