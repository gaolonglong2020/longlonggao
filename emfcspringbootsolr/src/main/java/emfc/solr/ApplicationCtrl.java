package emfc.solr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSolrRepositories("emfc.solr")
public class ApplicationCtrl {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationCtrl.class,args);
    }
}
