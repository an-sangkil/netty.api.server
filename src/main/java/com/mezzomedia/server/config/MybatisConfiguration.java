package com.mezzomedia.server.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.04.18
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Configuration
@Lazy
@EnableTransactionManagement
@MapperScan(
        basePackageClasses = {com.mezzomedia.core.repository.mybatis.MybatisUserMapper.class}
        , sqlSessionFactoryRef="mybatisSqlSessionFactory"
)

public class MybatisConfiguration implements EnvironmentAware {

    @Value("${db.driver}")
    private String DB_DRIVER;
    @Value("${db.password}")
    private String DB_PASSWORD;
    @Value("${db.url}")
    private String DB_URL;
    @Value("${db.username}")
    private String DB_USERNAME;

    @Resource
    public MybatisProperties mybatisProperties;

    @Bean(name = "mybatisDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        //dataSource.setDriverClassName(DB_DRIVER);
        //dataSource.setUrl(DB_PASSWORD);
        //dataSource.setUsername(DB_URL);
        //dataSource.setPassword(DB_USERNAME);

        return dataSource;
    }

    @Bean(name = "transactionManagerMybatis")
    public PlatformTransactionManager transactionManager(@Qualifier("mybatisDataSource") DataSource masterDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(masterDataSource);
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
    }

    /**
     * YAML 에설정한 Mybatis Configuration 설정 포함
     * @return
     * @throws Exception
     */
    @Bean(name = "mybatisSqlSessionFactory")
    public SqlSessionFactory mybatisSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.dataSource());

        // YAML에 포함
        sqlSessionFactoryBean.setConfiguration(mybatisProperties.getConfiguration());
        sqlSessionFactoryBean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisProperties.getMapperLocations()[0]));//("classpath:mapper/*.xml"));

        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
    }


    /**
     * 커스텀 Mybatis configuration
     * @return
     */
    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
            }
        };
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception{
        return new SqlSessionTemplate(this.mybatisSqlSessionFactory());
    }

    @Autowired
    @Lazy
    private Environment env;

    /* (non-Javadoc)
     * @see org.springframework.context.EnvironmentAware#setEnvironment(org.springframework.template.template.env.Environment)
     */
    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }


}
