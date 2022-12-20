package com.produtos.API.Rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Bean
    public DataSource datasource() {
        try {
            DriverManagerDataSource driver = new DriverManagerDataSource();
            driver.setDriverClassName("org.postgresql.Driver");
            driver.setUrl("jdbc:postgresql://localhost:5432/API_PRODUTOS");
            driver.setUsername("postgres");
            driver.setPassword("root");
            return driver;
        } catch (Exception e) {
            throw new IllegalStateException("Erro de conexão com o banco" + e);
        }
    }

    @Bean
    public JpaVendorAdapter JpaVendorAdapter() {
        try {
            HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
            adapter.setDatabase(Database.POSTGRESQL);
            adapter.setShowSql(true);
            adapter.setGenerateDdl(true);
            adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
            adapter.setPrepareConnection(true);

            return adapter;
        } catch (Exception e) {
            throw new IllegalArgumentException("Hibernate error " + e);
        }
    }
}