package emfc.solr.service;


import emfc.solr.entity.EntityUser;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolrService extends SolrCrudRepository<EntityUser,String> {
    @Query(" name_s:*?0* ")
    public List<EntityUser> findByQueryAnnotation(String item_title);
}
