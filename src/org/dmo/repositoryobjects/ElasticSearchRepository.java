package org.dmo.repositoryobjects;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
//import org.elasticsearch.action.admin.indices.alias.Alias;
//import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
//import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ElasticSearchRepository {
	
	public static String hostUrl = "localhost";
	public static String indexName = "spread-v1";
	public static String indexAlias = "spread";
	public static Client client;
	
	public ElasticSearchRepository() {
		this.getElasticClient();
		// create index
		boolean exists = client.admin().indices()
				.prepareExists(indexName)
				.execute()
				.actionGet()
				.isExists();
		if (!exists) {
			CreateIndexRequest request = new CreateIndexRequest(indexName).alias(new Alias(indexAlias));
			CreateIndexResponse createResponse = client.admin()
					.indices()
					.create(request)
					.actionGet();
		}
	}
	public ElasticSearchRepository(String url) {
		ElasticSearchRepository.hostUrl = url;
		this.getElasticClient();
	}
	protected Client getElasticClient() {
		//Client client = null;
		try {
			Settings settings = Settings.builder()
					.put("cluster.name", "esdemo")
					.build();
			
			ElasticSearchRepository.client = TransportClient.builder()
					.settings(settings)
					.build();
			((TransportClient) ElasticSearchRepository.client).addTransportAddress(
					new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300)
			);
			
		} 
		catch (UnknownHostException e) {
		}
		
		return client;
	}
}
