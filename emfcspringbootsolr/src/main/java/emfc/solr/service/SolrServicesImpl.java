package emfc.solr.service;

import emfc.solr.entity.EntityUser;
import emfc.solr.util.SolrCloudServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SolrServicesImpl implements SolrServices{
    @Override
    public List<EntityUser> finduser(String name) {
        CloudSolrClient client = SolrCloudServer.getServer();
        SolrQuery query = new SolrQuery();
        query.set("q","name_s:"+name);
        try {
            QueryResponse response =  client.query(query);
         return  response.getBeans(EntityUser.class);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
