package neusoft.test.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement()
@ComponentScan(basePackages = { "neusoft.test.module.service" })
public class ModuleConfig {
	// 引入配置文件
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(
			@Value("classpath:config.properties") Resource locations) {
		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocations(locations);
		return propertyPlaceholderConfigurer;
	}

	@Bean
	public DataSource dataSource(@Value("${datasource.userName}") String userName,
			@Value("${datasource.password}") String password,
			@Value("${datasource.driverClassName}") String driverClassName,
			@Value("${datasource.jdbcUrl}") String jdbcUrl) {
		// HikariDataSource dataSource=new HikariDataSource();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(jdbcUrl);
		return dataSource;
	}

	// spring和MyBatis完美整合，不需要mybatis的配置映射文件
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		return sqlSessionFactory.getObject();
	}

	// 接口所在包名，Spring会自动查找其下的类
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("neusoft.test.module.mapper");
		return mapperScannerConfigurer;
	}

	// (事务管理)transaction manager, use JtaTransactionManager for global tx
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
