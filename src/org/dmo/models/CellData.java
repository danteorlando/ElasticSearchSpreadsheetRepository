package org.dmo.models;

import org.dmo.models.NameSuggest;

public class CellData {
	public long id;

    public String value;

    public String pos;

    public String type;

    public NameSuggest nameSuggest;

    public CellData(String pos, String val) {
      this.id = 0L;
      this.pos = pos;
      this.value = val;
      this.type = "String";
    }

    public CellData(long id, String pos, String val) {
        this.id = id;
        this.pos = pos;
        this.value = val;
        this.type = "String";
    }

    public CellData(long id, String val, String pos, String type) {
        this.id = id;
        this.pos = pos;
        this.value = val;
        this.type = type;
    }

    public CellData() {
      this.type = "String";
    }	

}
