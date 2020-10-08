/*
package emfc.solr.solrj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.teach.bean.TestBO;
import com.teach.server.SolrServer;

public class SolrBean {

	*/
/**
	 * 添加索引
	 *//*

	public static void addBeanIndex() {
		HttpSolrClient server = SolrServer.getServer();
		List<TestBO> beans = new ArrayList<TestBO>(); 
		TestBO bo = new TestBO();
		bo.setId("1002");
		bo.setTitle_s("hello test replication2.");
		bo.setDes_s("core1 bean2.");
		beans.add(bo);
		try {
			server.addBeans(beans);
			server.commit();
			System.out.println("----提交完毕!!!----");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	*/
/**
	 * 查询索引
	 * @param str
	 *//*

	public static void search(String str) {
		HttpSolrClient server = SolrServer.getServer();
		SolrQuery sQuery = new SolrQuery();
		if(StringUtils.isBlank(str))
			str = "*:*";
		sQuery.setQuery(str);
		sQuery.setStart(0);
		sQuery.setRows(5);
		
		QueryResponse queryResponse;
		try {
			queryResponse = server.query(sQuery);
			List<TestBO> indexBOLists = queryResponse.getBeans(TestBO.class);
			System.out.println("----------------------------" + indexBOLists.size());
			for (TestBO bo : indexBOLists) {
				System.out.println(bo.getDes_s());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	*/
/**
	 * 删除索引
	 * @param condition
	 *//*

	public static void delteIndex(String condition){		
		try {
			HttpSolrClient server = SolrServer.getServer();
			server.deleteByQuery(condition);
			//server.deleteById(id);
			server.commit();
			System.out.println("删除完毕！");
		} catch (SolrServerException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		delteIndex("*:*");
	}

}
*/
