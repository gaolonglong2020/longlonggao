package emfc.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest

public class SolrApplicationTest {

    @Autowired
    private CloudSolrClient  cloudSolrClient;

    @Test
    public void contextLoad(){
        System.out.println("--------");
        SolrDocumentList query = queryStr("name_s:*");
        System.out.println(query.getNumFound());
        System.out.println("============");

    }

    private SolrDocumentList queryStr(String s) {
        cloudSolrClient.setDefaultCollection("eSearch");
        SolrDocumentList st = null;
        SolrQuery param = new SolrQuery();
        param.setQuery(s);
        QueryRequest req =  new QueryRequest(param, SolrRequest.METHOD.POST);

        try {
          QueryResponse response =  req.process(cloudSolrClient);
            st = response.getResults();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return st;
    }
}
