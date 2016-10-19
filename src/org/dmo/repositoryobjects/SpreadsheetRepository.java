package org.dmo.repositoryobjects;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.dmo.models.*;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.index.IndexResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class SpreadsheetRepository extends ElasticSearchRepository {

	public SpreadsheetRepository(String url) {
		ElasticSearchRepository.hostUrl = url;

		// create mappings;
		try {
			
			String spreadsheetrangenamenodeMapping = "";
			String spreadsheetworksheetMapping = "";
			String spreadsheetMapping = "";
			
			spreadsheetrangenamenodeMapping = readJsonDef("src/org/dmo/repositoryobjects/spreadsheetrangenamenode.json");
			spreadsheetworksheetMapping = readJsonDef("src/org/dmo/repositoryobjects/spreadsheetworksheet.json");
			spreadsheetMapping = readJsonDef("src/org/dmo/repositoryobjects/spreadsheet.json");
			
			PutMappingResponse putMappingResponse = null;
			putMappingResponse = client.admin().indices()
	                .preparePutMapping(indexName)
	                .setType("spreadsheetrangenamenode")
	                .setSource(spreadsheetrangenamenodeMapping)
	                .get();

			putMappingResponse = client.admin().indices()
	                .preparePutMapping(indexName)
	                .setType("spreadsheetworksheet")
	                .setSource(spreadsheetworksheetMapping)
	                .get();
			
			putMappingResponse = client.admin().indices()
	                .preparePutMapping(indexName)
	                .setType("spreadsheet")
	                .setSource(spreadsheetMapping)
	                .get();
	                
		}
		catch (IOException ioex) {
			System.out.println(ioex);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public String readJsonDef(String url) throws Exception {
        StringBuffer bufferJSON = new StringBuffer();

        FileInputStream input = new FileInputStream(new File(url).getAbsolutePath());
        DataInputStream inputStream = new DataInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        while ((line = br.readLine()) != null) {
                       bufferJSON.append(line);
        }
        br.close();
        return bufferJSON.toString();
	}

	public void insertSpreadsheetDocs() {
	      
		WorksheetIndexCreator ic1 = new WorksheetIndexCreator(new Worksheet("Acme Corp Q1 2015", 501L, "joesmith"));
		SpreadsheetRangeNameNode node1 = new SpreadsheetRangeNameNode("sheet1_I_0001", "1001.25", "C2");
		SpreadsheetRangeNameNode node2 = new SpreadsheetRangeNameNode("sheet1_I_0002", "1002.25", "C3");
		SpreadsheetRangeNameNode node3 = new SpreadsheetRangeNameNode("sheet1_BegEmployee.001", "1003.48", "C4");
		SpreadsheetRangeNameNode node4 = new SpreadsheetRangeNameNode("sheet1_BegEmployee.002", "10034.58", "C5");
	      
		ic1.rangeNameNodes.add(node1);
		ic1.rangeNameNodes.add(node2);
		ic1.rangeNameNodes.add(node3);
		ic1.rangeNameNodes.add(node4);
	      
		WorksheetIndexCreator ic2 = new WorksheetIndexCreator(new Worksheet("Acme Corp Q2 2015", 501L, "joesmith"));
		SpreadsheetRangeNameNode node5 = new SpreadsheetRangeNameNode("sheet2_I_0001", "2001.25", "C2");
		SpreadsheetRangeNameNode node6 = new SpreadsheetRangeNameNode("sheet2_I_0002", "2002.25", "C3");
		SpreadsheetRangeNameNode node7 = new SpreadsheetRangeNameNode("sheet2_BegEmployee.001", "2003.25", "C4");
		SpreadsheetRangeNameNode node8 = new SpreadsheetRangeNameNode("sheet2_BegEmployee.002", "2004.25", "C5");
		
		ic2.rangeNameNodes.add(node5);
		ic2.rangeNameNodes.add(node6);
		ic2.rangeNameNodes.add(node7);
		ic2.rangeNameNodes.add(node8);
	      
		WorksheetIndexCreator ic3 = new WorksheetIndexCreator(new Worksheet("Acme Corp Q3 2015", 501L, "joesmith"));
		SpreadsheetRangeNameNode node9 = new SpreadsheetRangeNameNode("sheet3_I_0001", "3001.25", "C2");
		SpreadsheetRangeNameNode node10 = new SpreadsheetRangeNameNode("sheet3_I_0001", "3001.25", "C3");
		SpreadsheetRangeNameNode node11 = new SpreadsheetRangeNameNode("sheet3_I_0002", "3002.25", "C4");
		SpreadsheetRangeNameNode node12 = new SpreadsheetRangeNameNode("sheet3_I_0002", "7777.25", "C5");
		SpreadsheetRangeNameNode node13 = new SpreadsheetRangeNameNode("sheet3_I_0002", "3002.25", "C6");
		SpreadsheetRangeNameNode node14 = new SpreadsheetRangeNameNode("sheet3_BegEmployee.001", "3003.48", "C7");
		SpreadsheetRangeNameNode node15 = new SpreadsheetRangeNameNode("sheet3_BegEmployee.002", "3004.48", "C8");
		SpreadsheetRangeNameNode node16 = new SpreadsheetRangeNameNode("sheet3_MoreNotes", "14", "C19");
		SpreadsheetRangeNameNode node17 = new SpreadsheetRangeNameNode("sheet3_MoreNotes", "15", "C18");
		SpreadsheetRangeNameNode node18 = new SpreadsheetRangeNameNode("sheet3_MoreNotes", "16", "C17");
		SpreadsheetRangeNameNode node19 = new SpreadsheetRangeNameNode("sheet3_MoreNotes", "17", "C16");
		SpreadsheetRangeNameNode node20 = new SpreadsheetRangeNameNode("sheet3_MoreNotes", "18", "C15");
		SpreadsheetRangeNameNode node21 = new SpreadsheetRangeNameNode("sheet3_MoreNotes", "19", "C14");
	      
	    ic3.rangeNameNodes.add(node9);
	    ic3.rangeNameNodes.add(node10);
	    ic3.rangeNameNodes.add(node11);
	    ic3.rangeNameNodes.add(node12);
	    ic3.rangeNameNodes.add(node13);
	    ic3.rangeNameNodes.add(node14);
	    ic3.rangeNameNodes.add(node15);
	    ic3.rangeNameNodes.add(node16);
	    ic3.rangeNameNodes.add(node17);
	    ic3.rangeNameNodes.add(node18);
	    ic3.rangeNameNodes.add(node19);
	    ic3.rangeNameNodes.add(node20);
	    ic3.rangeNameNodes.add(node21);
	    this.insertSpreadsheetDoc(501, 10084, "Big Consulting Corp CA-001", "Acme Corp Valhalla CA Office", 10001L, "Acme Corp Earnings Report for Q4 2015", 2, "2015", "2015-12-31", "Delaware", "joesmith", "C:/spreads/RTP-Worksheet-Acme-5.xlsx", 
	    		new ArrayList<WorksheetIndexCreator>(Arrays.asList(
	    				ic1,
				        ic2,
				        ic3
	    				))
	    		);
	}

	public String insertSpreadsheetDoc(int wpId, 
			int firmId, 
			String clientName, 
			String entityName, 
			long entityId, 
			String wpName, 
			int wpVersion, 
			String year, 
			String period, 
			String jurisdiction, 
			String user, 
			String xlsxPath, 
			List<WorksheetIndexCreator> worksheetList) {
		
		Spreadsheet w = new Spreadsheet();
		w.meta.id = wpId;
		w.id = (long) wpId;
		w.meta.name = wpName;
		w.meta.firmId = (long) firmId;
		w.meta.client = clientName;
		w.meta.user = user;
		w.meta.published = false;
		w.meta.creator = user;
		w.meta.created = new Date();
		w.meta.lastModifiedBy = user;
		w.meta.lastModified = new Date();
		
		/*
		Attachment attachment = new Attachment();
		attachment.Content = Convert.ToBase64String(File.ReadAllBytes(xlsxPath));
		attachment.ContentType = "application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		attachment.ContentLength = (long) attachment.Content.Length;
		attachment.Name = Enumerable.Last<string>((IEnumerable<string>) xlsxPath.Split('/'));
		 */
		
		w.setSuggestionInputStrings(new String[] {
				w.meta.name,
				Integer.toString(w.meta.id)
		});
		
		w.nameSuggest.output = w.meta.name;
		w.nameSuggest.payload.uri = "spreadsheet:" + (Object) w.meta.id;
      
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			byte[] json  = mapper.writeValueAsBytes(w);
			IndexResponse response = client.prepareIndex(indexName, "spreadsheet", Long.toString(w.id))
					.setSource(json)
					.get();
			
			// Index name
			String _index = response.getIndex();
			// Type name
			String _type = response.getType();
			// Document ID (generated or not)
			String _id = response.getId();
			// Version (if it's the first time you index this document, you will get: 1)
			long _version = response.getVersion();
			// isCreated() is true if the document is a new one, false if it has been updated
			boolean created = response.isCreated();
			
		} catch (JsonProcessingException e) {
		}
      
		
		long longWkSheetNodeId = Long.parseLong((String) (Object) Integer.toString(w.meta.id) + (Object) "01");
		
		for(int i = 0; i < worksheetList.size(); i++) {
			Worksheet ws = worksheetList.get(i).worksheet;
			ws.meta.creator = w.meta.user;
			ws.meta.lastModifiedBy = w.meta.user;
			ws.feed.worksheetId = longWkSheetNodeId;
			ws.feed.id = (long) w.meta.id;
			ws.nameSuggest.input.add(w.meta.name);
			ws.nameSuggest.payload.uri = "worksheet:" + (Object) longWkSheetNodeId;
        
			
			List<SpreadsheetRangeNameNode> rangeNameNodes = worksheetList.get(i).rangeNameNodes;
			
			
			try {
				//client.admin().indices().create(new CreateIndexRequest("spreadsheetworksheet")).actionGet();
				
				ObjectMapper mapper = new ObjectMapper();
				byte[] json  = mapper.writeValueAsBytes(ws);
				IndexResponse response = client.prepareIndex(indexName, "spreadsheetworksheet", Long.toString(longWkSheetNodeId))
						.setSource(json)
						.setParent(Integer.toString(w.meta.id))
						.get();
				
				// Index name
				String _index = response.getIndex();
				// Type name
				String _type = response.getType();
				// Document ID (generated or not)
				String _id = response.getId();
				// Version (if it's the first time you index this document, you will get: 1)
				long _version = response.getVersion();
				// isCreated() is true if the document is a new one, false if it has been updated
				boolean created = response.isCreated();
				
			} 
			catch (JsonProcessingException e) {
			}
			catch (IOException e) {
			}
			
			
			long longRangeNameNodeId = Long.parseLong((String) (Object) Long.toString(longWkSheetNodeId) + (Object) "01");
			
			for(int j = 0; j < rangeNameNodes.size(); j++) {
				SpreadsheetRangeNameNode node = rangeNameNodes.get(j);
				node.nameSuggest.setPayloadId("spreadsheetrangenamenode:" + (Object) longRangeNameNodeId);

				long num1 = longRangeNameNodeId;
				longRangeNameNodeId = num1 + 1L;
				long num2 = num1;
				try {
					ObjectMapper mapper = new ObjectMapper();
					byte[] json  = mapper.writeValueAsBytes(node);
					IndexResponse response = client.prepareIndex(indexName, "spreadsheetrangenamenode", Long.toString(num2))
							.setSource(json)
							.setRouting(Integer.toString(w.meta.id))
							.setParent(Long.toString(longWkSheetNodeId))
							.get();
					
					// Index name
					String _index = response.getIndex();
					// Type name
					String _type = response.getType();
					// Document ID (generated or not)
					String _id = response.getId();
					// Version (if it's the first time you index this document, you will get: 1)
					long _version = response.getVersion();
					// isCreated() is true if the document is a new one, false if it has been updated
					boolean created = response.isCreated();
					
				} catch (JsonProcessingException e) {
				}
			}
			++longWkSheetNodeId;
		}
		return "success";
    }
	
	public String insertSpreadsheetDoc(String fileUri, 
			int firmId, 
			int id, 
			String username, 
			int version, 
			String name, 
			String fileName) {
      
		if (ElasticSearchRepository.client == null)
			return "spreadsheet insert failed - no ElasticSearch client was detected";
		
		Spreadsheet s = new Spreadsheet();
		s.meta.id = id;
		s.id = (long) id;
		s.meta.name = name;
		s.meta.firmId = (long) firmId;
		s.meta.client = "Big Consulting Corp CA 001";
		s.meta.user = username;
		s.meta.published = false;
		s.meta.creator = username;
		s.meta.created = new Date();
		s.meta.lastModifiedBy = username;
		s.meta.lastModified = new Date();
		s.setSuggestionInputStrings(new String[]{
	        fileName,
	        s.meta.name,
	        Integer.toString(s.meta.id)
		});
		s.nameSuggest.output = s.meta.name + " | " + fileName;
		s.nameSuggest.payload.uri = "spreadsheet:" + (Object) s.meta.id;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			byte[] json  = mapper.writeValueAsBytes(s);
			IndexResponse response = client.prepareIndex(indexName, "spreadsheet", Long.toString(s.id))
					.setSource(json)
					.get();
			
			// Index name
			String _index = response.getIndex();
			// Type name
			String _type = response.getType();
			// Document ID (generated or not)
			String _id = response.getId();
			// Version (if it's the first time you index this document, you will get: 1)
			long _version = response.getVersion();
			// isCreated() is true if the document is a new one, false if it has been updated
			boolean created = response.isCreated();
			
		} 
		catch (JsonProcessingException e) {
		}
		
		//this.insertSpreadsheetWorksheets(w, fileUri);
		
		return "success - spreadsheet name: " + name;
    }	
	
	
}
