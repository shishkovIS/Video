package Logic;

import java.util.Set;



public class Client {
	private int id;
	private String name;
	private String email;
	private String adress;
	private Set<OrderHistory> historyRecords;
	private boolean isRemoved;
	
	
	public Set<OrderHistory> getHistoryRecords()
    {
        return historyRecords;
    }
    public void setHistoryRecords(Set<OrderHistory> historyRecords)
    {
        this.historyRecords = historyRecords;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
    public void setIsRemoved(boolean isRemoved)
    {
        this.isRemoved = isRemoved;
    }
    public boolean getIsRemoved()
    {
        return isRemoved;
        
    }
	
}