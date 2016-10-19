package org.dmo.models;

public class WorksheetFeed {
	public long id;

    public long worksheetId;

    public WorksheetFeed(long wpId) {
      this.id = wpId;
      this.worksheetId = 0L;
    }
}
