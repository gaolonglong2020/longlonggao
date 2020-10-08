package emfc.solr.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface BaseSolr {
    /*
    * 添加数据
    *
    * */
    public void add(String defaultCollection,Object bean);

    /*
    * 添加遗嘱数据*/
    public void adds(String defaultCollection, Collection<?> beans);

    /*
    * 根据多个id删除数据
    *
    * */
    public void deleteByIds(String defaultCollection, List<String> ids);

    /*
    * 根据id删除数据
    * */
    public void deleteById(String defaultCollection,String id);

    /*
    * 根据直定索引（字段）是模糊删除数据*/
    public void deleteByField(String defaultCollection,String field,String fieldValue);

    /*
    * 查询数据
    * */
    public <T> List<T> query(String defaultCollection, Class<T> clazz, SolrQuery query);

    /*查询*/
    public QueryResponse query(String defaultCollection,SolrQuery query);

/*
    public <T> PageInfo query(String defaultCollection,Class<T> clazz,SolrQuery query,RowBounds rowBounds)

    public PageInfo query(String defaultCollection,SolrQuery query,RowBounds rowBounds);

   solrJ 的facet结果查询
    public PageInfoFacet queryFacet(String defaultCollection,SolrQuery query,RowBounds rowBounds);
      */
}
