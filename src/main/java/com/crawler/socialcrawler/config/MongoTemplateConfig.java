/**
 * 
 */
package com.crawler.socialcrawler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author tbhendar
 *
 */
@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = "com.crawler")
public class MongoTemplateConfig {
	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port}")
	private String mongoPort;

	@Value("${spring.data.mongodb.database}")
	private String mongoDB;

	public @Bean MongoTemplate mongoTemplate() {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
		MongoMappingContext mappingContext = new MongoMappingContext();
		mappingContext.setSimpleTypeHolder(null);
		MappingMongoConverter converter = new MappingMongoConverter(
				dbRefResolver, mappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(),
				converter);
		return mongoTemplate;
	}

	@Bean
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(mongoClient(), mongoDB);
	}

	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(mongoHost, Integer.parseInt(mongoPort));

	}

	@Bean
	public MongoDatabase getMongoDatabase() {
		return mongoClient().getDatabase(mongoDB).withCodecRegistry(
				com.mongodb.MongoClient.getDefaultCodecRegistry());

	}
}
