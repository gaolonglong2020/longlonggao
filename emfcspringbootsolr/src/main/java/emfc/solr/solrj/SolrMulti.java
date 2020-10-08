/*
package emfc.solr.solrj;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.teach.bean.TestBO;
import com.teach.server.SolrServer;

public class SolrMulti {

	public static void search(String str)
	{
		HttpSolrClient server = SolrServer.getServer();
		SolrQuery sQuery = new SolrQuery();
		sQuery.setQuery(str);
		sQuery.setStart(0);
		sQuery.setRows(5);
		sQuery.set("shards", "localhost:8081/solr/test,localhost:8081/solr/core1,localhost:8081/solr/core2");
		QueryResponse queryResponse;
		try {
			queryResponse = server.query(sQuery);
			List<TestBO> indexBOLists = queryResponse.getBeans(TestBO.class);
			for (TestBO bo : indexBOLists) {
			System.out.println(bo.getDes_s());
		}
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		search("*:*");
	}

}
*/
