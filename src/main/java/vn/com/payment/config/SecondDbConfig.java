package vn.com.payment.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager", basePackages = {
        "vn.com.paymentservice.model.second" })
public class SecondDbConfig {

    @Bean(name = "second-datasource")
    @ConfigurationProperties("spring.second-datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(EntityManagerFactoryBuilder builder,
            @Qualifier("second-datasource") DataSource secondDataSource) {
        return builder.dataSource(secondDataSource).packages("vn.com.paymentservice.model.second").build();
    }

    public PlatformTransactionManager secondTransactionManager(
            @Qualifier("second-datasource") EntityManagerFactory primaEntityManagerFactory) {
        return new JpaTransactionManager(primaEntityManagerFactory);
    }
}
