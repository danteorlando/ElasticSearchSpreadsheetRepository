package org.dmo.models;

import java.util.ArrayList;
import java.util.List;

public class WorksheetIndexCreator {
	public long id;
	public WorksheetRangeNameMeta meta;
	public WorksheetRangeNameFeed feed;
	
	public List<SpreadsheetRangeNameNode> rangeNameNodes; 

    public List<WorksheetDataCell> sheetDataCells;

    public Worksheet worksheet;

    public WorksheetIndexCreator(Worksheet sheet) {
      this.worksheet = sheet;
      this.rangeNameNodes = new ArrayList<SpreadsheetRangeNameNode>();
      this.sheetDataCells = new ArrayList<WorksheetDataCell>();
    }
	
	
}
