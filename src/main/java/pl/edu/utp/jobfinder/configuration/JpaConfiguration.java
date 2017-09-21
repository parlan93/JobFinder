package pl.edu.utp.jobfinder.configuration;

import java.util.Properties;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"pl.edu.utp.jobfinder.model", "pl.edu.utp.jobfinder.service", "pl.edu.utp.jobfinder.repository"})
@ComponentScan("pl.edu.utp.jobfinder.*")
public class JpaConfiguration {

    public JpaConfiguration() {
        super();
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        return new JndiTemplate().lookup("java:/JobFinderDS", DataSource.class);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"pl.edu.utp.jobfinder.model"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    final Properties additionalProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show.sql", "false");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }

}
