package org.dmo.models;

import org.dmo.models.CellData;
import org.dmo.models.NameSuggest;

public class WorksheetDataCell {
	public long id;

    public CellData node;

    public NameSuggest nameSuggest;

    public WorksheetDataCell(long id, String name, String pos, String val) {
      this.id = id;
      this.node = new CellData(id, pos, val);
      this.nameSuggest = new NameSuggest(name, "WorksheetDataCell:" + (Object) 0);
    }

    public WorksheetDataCell(String name, String pos, String val) {
      this.node = new CellData(pos, val);
      this.nameSuggest = new NameSuggest(name, "WorksheetDataCell:" + (Object) 0);
    }

    public WorksheetDataCell(String pos, String val) {
      this.node = new CellData(pos, val);
      this.nameSuggest = new NameSuggest(val, "WorksheetDataCell:" + (Object) 0);
    }

    public WorksheetDataCell() {
    }
}
