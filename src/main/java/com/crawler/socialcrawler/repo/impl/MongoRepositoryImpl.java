/**
 * 
 */
package com.crawler.socialcrawler.repo.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.crawler.socialcrawler.entity.BaseEntity;
import com.mongodb.DBObject;

/**
 * @author tbhendar
 *
 */
public class MongoRepositoryImpl<T extends BaseEntity, U extends Serializable> {
	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(MongoRepositoryImpl.class);

	Class classType;

	public MongoRepositoryImpl() {
		ParameterizedType superclass = (ParameterizedType) (getClass()
				.getGenericSuperclass());
		classType = (Class) superclass.getActualTypeArguments()[0];
	}

	@Autowired
	private MongoTemplate mongoTemplate;

	public U save(T t) {
		LOGGER.debug("save start");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		t.setCreatedDate(calendar.getTimeInMillis());
		mongoTemplate.save(t);
		LOGGER.debug("id -{}", t.get_id());
		return (U) t.get_id();
	}

	public T getById(U u, String collectionName) {
		LOGGER.debug("getById start id {} and collection {}", u, collectionName);
		ObjectId objID = new ObjectId((String) u);
		DBObject dbObject = mongoTemplate.findById(objID, DBObject.class,
				collectionName);
		return (T) mongoTemplate.getConverter().read(classType, dbObject);
	}

	public List<T> getDocumentList(String fieldName, String fieldValue,
			String collectionName) {
		LOGGER.debug("getDocumentList start {} , {} , {} ", fieldName,
				fieldValue, collectionName);
		Query query = new Query(Criteria.where(fieldName).is(fieldValue));
		List<T> list = mongoTemplate.find(query, classType, collectionName);
		return list;
	}

	public void deleteDocument(T object, String collectionName) {
		LOGGER.debug("deleteDocument start {} ", collectionName);
		mongoTemplate.remove(object, collectionName);
	}

	public U update(T t) {
		LOGGER.debug("save start");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		t.setModifiedDate(calendar.getTimeInMillis());
		mongoTemplate.save(t);
		LOGGER.debug("id -{}", t.get_id());
		return (U) t.get_id();
	}

	public List<T> getAll() {
		return mongoTemplate.findAll(classType);
	}

}
