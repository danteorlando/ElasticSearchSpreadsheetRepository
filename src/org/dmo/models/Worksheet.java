package org.dmo.models;

import org.dmo.models.NameSuggest;
import org.dmo.models.WorksheetFeed;
import org.dmo.models.WorksheetMeta;

public class Worksheet {
	
	public long id;
    public WorksheetMeta meta;
    public WorksheetFeed feed;

    public NameSuggest nameSuggest;

    public Worksheet(String name, long parentId, String user) {
      this.meta = new WorksheetMeta(name, user);
      this.feed = new WorksheetFeed(parentId);
      this.nameSuggest = new NameSuggest(name, "worksheet:" + (Object) 0);
    }

    public Worksheet() {
    }

}
