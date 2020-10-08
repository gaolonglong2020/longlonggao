package emfc.solr.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.Id;
import java.io.Serializable;

@SolrDocument(solrCoreName = "eSearch")
public class EntityUser implements Serializable {
    @Id
    @Field
    private String id;
    @Field
    private String name_s;
    @Field
    private String sex_s;
    @Field
    private int age_i;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_s() {
        return name_s;
    }

    public void setName_s(String name_s) {
        this.name_s = name_s;
    }

    public String getSex_s() {
        return sex_s;
    }

    public void setSex_s(String sex_s) {
        this.sex_s = sex_s;
    }

    public int getAge_i() {
        return age_i;
    }

    public void setAge_i(int age_i) {
        this.age_i = age_i;
    }

}

