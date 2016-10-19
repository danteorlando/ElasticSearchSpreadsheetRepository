package org.dmo.models;

import java.util.Date;

public class WorksheetRangeNameMeta {
	
	public String name;
    public String creator;
    public Date created;
    public String lastModifiedBy; 
    public Date lastModified;

    public WorksheetRangeNameMeta(String name, String user)
    {
      this.name = name;
      this.creator = user;
      this.lastModifiedBy = user;
      this.created = new Date();
      this.lastModified = new Date();
    }
    
    
	public String getName() { return this.name; }
    public String getCreator() { return this.creator; }
    public Date getCreated() { return this.created; }
    public String getLastModifiedBy() { return this.lastModifiedBy; } 
    public Date getLastModified() { return this.lastModified; }
    
	public void setName(String name) { this.name = name; }
    public void setCreator(String creator) { this.creator = creator; }
    public void setCreated(Date created) { this.created = created; }
    public void setLastModifiedBy(String lastModifiedBy) { this.lastModifiedBy = lastModifiedBy; } 
    public void setLastModified(Date lastModified) { this.lastModified = lastModified; }
}
