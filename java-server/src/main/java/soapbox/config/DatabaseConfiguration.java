package soapbox.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/*
 By default, Spring Boot will enable JPA repository support and look in the package (and its subpackages)
 where @SpringBootApplication is located. If your configuration has JPA repository interface definitions
 located in a package not visible, you can point out alternate packages using
 @EnableJpaRepositories and its type-safe basePackageClasses=MyRepository.class parameter.

 Add @EnableJpaRepositories(basePackages="com.your.package", repositoryFactoryBeanClass = YourCustomRepositoryFactoryBean.class)
 if implementing Jpa Entity Graphs and specifying custom repositories to expose those graphs
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration implements EnvironmentAware {
    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
    private RelaxedPropertyResolver dataSourcePropertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        this.dataSourcePropertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    @Bean(destroyMethod = "")
    public DataSource dateSource() {
        log.debug("Configuring Hikari Datasource...");
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(dataSourcePropertyResolver.getProperty("dataSourceClassName"));
        config.addDataSourceProperty("url", dataSourcePropertyResolver.getProperty("url"));
        return new HikariDataSource(config);
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        // any other config here for liquibase
        return liquibase;
    }
}