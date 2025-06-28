package web_mining.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Keywords 
{
	@Id
	String keywords;

	public String getKeywords() 
	{
		return keywords;
	}
	public void setKeywords(String keywords) 
	{
		this.keywords = keywords;
	}
}