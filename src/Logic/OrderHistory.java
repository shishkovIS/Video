
package Logic;

import java.util.Date;

public class OrderHistory {
	private int id;
	private Copy copy;
	private Client client;
	private Date orderTime;
	private Date returnTime;
	private boolean isReturned;
	private int payout;
	private boolean isRemoved;
	private Movie movie;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Copy getCopy() {
		return copy;
	}
	public void setCopy(Copy copy) {
		this.copy = copy;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public int getPayout() {
		return payout;
	}
	public void setPayout(int payout) {
		this.payout = payout;
	}
    public boolean getIsRemoved()
    {
        return isRemoved;
    }
    public void setIsRemoved(boolean isRemoved)
    {
        this.isRemoved = isRemoved;
    }
    public Movie getMovie()
    {
        return movie;
    }
    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }
}