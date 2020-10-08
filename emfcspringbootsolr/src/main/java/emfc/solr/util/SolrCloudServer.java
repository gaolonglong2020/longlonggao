package emfc.solr.util;

import org.apache.solr.client.solrj.impl.CloudSolrClient;

public class SolrCloudServer {
    private  static final String zkhost = "localhost:2181,localhost:2182,localhost:2183";
    private static final String defaultCollection="eSearch"; //创建的collection的name值
    public static CloudSolrClient getServer(){
        CloudSolrClient client = new CloudSolrClient(zkhost);
        client.setDefaultCollection(defaultCollection);
        client.setZkClientTimeout(20000);
        client.setZkConnectTimeout(1000);
        client.connect();
        return client;
    }
}
