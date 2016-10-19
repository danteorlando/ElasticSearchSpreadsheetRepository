package org.dmo.models;

import java.util.Date;
import java.util.Dictionary;

public class SpreadsheetMeta {
    
	public Dictionary<String, String> attributes;

    public int id;

    public long firmId;

    public String client;

    public String user;

    public Boolean published;

    public String version;

    public String name;

    public String file;

    public String creator;

    public Date created;

    public String lastModifiedBy;

    public Date lastModified;

    public SpreadsheetMeta(int id, int firmId) {
      this.id = id;
      this.firmId = (long) firmId;
    }

    public SpreadsheetMeta() {
      this.id = 0;
      this.firmId = 0L;
    }
}
