package emfc.solr.control;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import emfc.solr.entity.EntityUser;
import emfc.solr.service.SolrService;
import emfc.solr.service.SolrServices;
import emfc.solr.util.BaseSolr;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
public class SolrController {
    @Autowired
    private SolrService solrService;

    @Autowired
    private SolrServices solrServices;

  //  @Autowired
  //  private BaseSolr baseSolr;

    @Autowired
    private CloudSolrClient client;
    @RequestMapping("/index")
    public List<EntityUser> solrCloud(@RequestParam String title){
        return solrServices.finduser(title);
    }
    @RequestMapping("/in")
    public List<EntityUser> findCloud(@RequestParam String title){
        client.setDefaultCollection("eSearch");
        SolrQuery query = new SolrQuery();
        query.setQuery("name_s:"+title);
        QueryRequest request = new QueryRequest(query, SolrRequest.METHOD.POST);
        try {
           QueryResponse resp =  request.process(client);
          return  resp.getBeans(EntityUser.class);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/add")
    public void addUser(){
        EntityUser entityUser = new EntityUser();
        entityUser.setId("003");
        entityUser.setName_s("王小双");
        entityUser.setSex_s("男");
        entityUser.setAge_i(20);
        solrService.save(entityUser);
    }
    @RequestMapping("/adds")
    public void addUserClient() throws IOException, SolrServerException {
        EntityUser entityUser = new EntityUser();
        entityUser.setId("004");
        entityUser.setName_s("刘洪");
        entityUser.setSex_s("男");
        entityUser.setAge_i(16);
        client.setDefaultCollection("eSearch");
        client.connect();
        client.addBean(entityUser);
        client.commit();
    }
    /*
    * 删除数据*/
    @RequestMapping("/delete")
    public void deleteUser(){
        EntityUser u = new EntityUser();
        u.setId("007");
        u.setName_s("小小");
        u.setSex_s("女");
        u.setAge_i(9);
        solrService.save(u);
        //通过用户名删除数据
        List<EntityUser> list = solrService.findByQueryAnnotation("小小");
        list.forEach(l->{
            System.out.println("查询响应："+ JSONObject.toJSONString(l));
            //直接删除对象
            solrService.delete(l);
        });
    }
    /*
    * data JPA 方式查询
    * */
    @RequestMapping("/jps")
    public List<EntityUser> jpaSearch(){
        Iterable<EntityUser> list =  solrService.findAll();
        Iterator<EntityUser> iter = list.iterator();

       return (List<EntityUser>) iter;
    }
    /*
    *
    * SolrQuery语法查询
    * */
    @RequestMapping("/solr")
    public List<EntityUser> solrEntity(){
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        client.setDefaultCollection("eSearch");
        client.connect();
        try {
            QueryResponse response = client.query(query);
           return   response.getBeans(EntityUser.class);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * 使用工具类查询
    * */

 /*   @RequestMapping("/tool")
    public List<EntityUser> getTool(){
        SolrQuery query = new SolrQuery();
        String str ="*:*";
        String defaultCol = "eSearch";
        query.setQuery(str);
       List<EntityUser> list =  baseSolr.query(defaultCol,EntityUser.class,query);
        list.forEach(l->{
            System.out.println("工具类 查询响应"+JSONObject.toJSONString(l));
        });
        return list;
    }*/
    /*
    * 分页 工具类查询*/
   /* @RequestMapping("/page")
    public List<EntityUser> getPage(){
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
       PageInfo pageInfo = baseSolr.query("eSearch",EntityUser.class,new RowBounds(0,2));
       return pageInfo;
    }*/
}
