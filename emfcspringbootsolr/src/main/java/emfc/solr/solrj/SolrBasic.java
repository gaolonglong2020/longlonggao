/*
package emfc.solr.solrj;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.teach.server.SolrServer;

public class SolrBasic {

	*/
/**
	 * 添加索引
	 *//*

	public static void insert() {
		HttpSolrClient server = SolrServer.getServer();
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "1003");
		doc.addField("title_s", "hello bobo!");
		doc.addField("des_s", "波波，你好！");
		try {
			server.add(doc);
			server.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	*/
/**
	 * 删除索引
	 *//*

    public static void DeleteByQueryJobsId() {  
    	HttpSolrClient server = SolrServer.getServer();
        try {  
        	server.deleteById("123456");  
        	server.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }

	*/
/**
	 * 删除索引
	 *//*

	public static void delDocs() {
		long start = System.currentTimeMillis();
		try {
			HttpSolrClient server = SolrServer.getServer();
			List<String> ids = new ArrayList<String>();
			ids.add("123456");
			server.deleteById(ids);
			server.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("time elapsed(ms):" + (System.currentTimeMillis() - start));
	}
	
	*/
/**
	 * 查询索引
	 *//*

	public static void search(String str) {
		HttpSolrClient server = SolrServer.getServer();
		SolrQuery sQuery = new SolrQuery();
//		if(StringUtils.isBlank(str))
//			str = "*:*";
//		sQuery.setQuery(str);
//		sQuery.set("q", "des_s:test*");// ��ѯnickname����chm��ͷ����� 
		sQuery.setQuery("des_s:test*");
		sQuery.setStart(0);
		sQuery.setRows(5);
		
		QueryResponse queryResponse;
		try {
			queryResponse = server.query(sQuery);
			SolrDocumentList list = queryResponse.getResults();
	        System.out.println("query result nums: " + list.getNumFound());
	        for (int i = 0; i < list.size(); i++) {
	        	 System.out.println(list.get(i).getFieldValue("des_s"));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public static void main(String[] args) {
		insert();
	}

}
*/
