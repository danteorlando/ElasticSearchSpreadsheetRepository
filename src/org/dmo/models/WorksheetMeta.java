package org.dmo.models;

import java.util.Date;

public class WorksheetMeta {
    public String name;

    public String wkSheetKey;

    public int rowCount;

    public String relId;

    public String creator;

    public Date created;

    public String lastModifiedBy;

    public Date lastModified;

    public WorksheetMeta(String name, String user)
    {
      this.name = name;
      this.creator = user;
      this.lastModifiedBy = user;
      this.created = new Date();
      this.lastModified = new Date();
    }

    public class dimension
    {
      public String topLeft;

      public String bottomRight;
    }

}
