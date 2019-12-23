package com.mindtree.channelshow.entity;

import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Channel implements Comparable<Channel>
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int channelId;
	private String channelName;
	private int channelPrice;
	@ManyToOne
	@JsonIgnore
	private ChannelGroup channelGroup;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "channel")
	@JsonIgnoreProperties("channel")
	private List<Show> shows;
	public Channel() {
		super();
	}
	public Channel(int channelId, String channelName, int channelPrice, ChannelGroup channelGroup, List<Show> shows) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelPrice = channelPrice;
		this.channelGroup = channelGroup;
		this.shows = shows;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getChannelPrice() {
		return channelPrice;
	}
	public void setChannelPrice(int channelPrice) {
		this.channelPrice = channelPrice;
	}
	public ChannelGroup getChannelGroup() {
		return channelGroup;
	}
	public void setChannelGroup(ChannelGroup channelGroup) {
		this.channelGroup = channelGroup;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	public Channel(String channelName) {
		super();
		this.channelName = channelName;
	}
	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", channelPrice=" + channelPrice
				+ "]";
	}
	@Override
	public int compareTo(Channel arg0) 
	{
		int result = this.getChannelPrice() - arg0.getChannelPrice();
		if(result == 0)
		{
			return this.getChannelName().compareTo(arg0.getChannelName());
		}
		return result;
	}
	
	
/*public static Comparator<Channel> priceComparator = new Comparator<Channel>() {
		
		@Override
		public int compare(Channel e1, Channel e2) 
		{
			
			//return (int) (e2.getEmployeeSalary() - e1.getEmployeeSalary());
			int result = (int) (e2.getChannelPrice() - e1.getChannelPrice());
			if(result == 0)
			{
				result = e1.getChannelName().compareTo(e2.getChannelName());
			}
			return result;
		}
	};*/
	
}
