/*
package emfc.solr.solrj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;

import com.teach.server.CloudSolrServer;

public class CloudSolrTest {
	
	public static void addIndex()
	{
		CloudSolrClient server =  CloudSolrServer.getServer();
		SolrInputDocument doc1 = new SolrInputDocument();
		doc1.addField("id", "1001");
		doc1.addField("name_s", "王海");
		
		SolrInputDocument doc2 = new SolrInputDocument();
		doc2.addField("id", "1002");
		doc2.addField("name_s", "张芳");
		
		SolrInputDocument doc3 = new SolrInputDocument();
		doc3.addField("id", "1003");
		doc3.addField("name_s", "刘军");
		
		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		docs.add(doc1);
		docs.add(doc2);
		docs.add(doc3);
		
		try {
			server.add(docs);
			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		addIndex();
	}

}
*/
