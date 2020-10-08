package emfc.solr.service;

import emfc.solr.entity.EntityUser;

import java.util.List;


public interface SolrServices {
    public List<EntityUser> finduser(String name);
}
