package org.dmo.models;

import org.dmo.models.NameSuggest;
import org.dmo.models.SpreadsheetMeta;
import org.dmo.models.Worksheet;

public class Spreadsheet {
	public long id;

    public SpreadsheetMeta meta;

    public NameSuggest nameSuggest;

    public Spreadsheet()
    {
      this.meta = new SpreadsheetMeta();
      this.nameSuggest = new NameSuggest();
    }

    public Spreadsheet(int id, int firmId) {
      this.meta = new SpreadsheetMeta(id, firmId);
      this.nameSuggest = new NameSuggest();
    }

    public Spreadsheet(SpreadsheetMeta meta, Worksheet[] sheetList) {
    }

    public void setSuggestionInputStrings(String[] inputValues) {
    	for(int i = 0; i < inputValues.length; i++)
    		this.nameSuggest.input.add(inputValues[i]);
    }
}
