import org.dmo.repositoryobjects.SpreadsheetRepository;

public class Runner {

	
	public static void main (String[] args) {
		SpreadsheetRepository repository = new SpreadsheetRepository("localhost");
		repository.insertSpreadsheetDocs();
	}

}
