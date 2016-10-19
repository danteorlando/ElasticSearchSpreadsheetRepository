package org.dmo.models;

import java.util.ArrayList;
import java.util.List;

public class SpreadsheetRangeNameNode {
	public long id;

    public RangeName node;

    public List<String> labels;

    public NameSuggest nameSuggest;

    public SpreadsheetRangeNameNode() {
      this.node = new RangeName("I_0001", "1001.25", "D10");
      this.nameSuggest = new NameSuggest("Suggest Display Info Here", "spreadsheetrangenamenode:111001-TBD");
      this.labels = new ArrayList<String>();
    }

    public SpreadsheetRangeNameNode(String name, String value, String pos) {
      this.node = new RangeName(name, value, pos);
      this.nameSuggest = new NameSuggest(this.node.name + ":" + this.node.value, "spreadsheetrangenamenode:pending");
      this.nameSuggest.input.add(this.node.name);
      this.nameSuggest.input.add(this.node.value);
      this.labels = new ArrayList<String>();
    }

    public SpreadsheetRangeNameNode(String name, String value, String pos, String label) {
      this.node = new RangeName(name, value, pos);
      this.nameSuggest = new NameSuggest(this.node.name + ":" + this.node.value, "spreadsheetrangenamenode:pending");
      this.nameSuggest.input.add(this.node.name);
      this.nameSuggest.input.add(this.node.value);
      this.labels = new ArrayList<String>();
      this.labels.add(label);
    }
}
