/**
 * 
 */
package com.crawler.socialcrawler.repo;

import java.io.Serializable;
import java.util.List;

/**
 * @author tbhendar
 *
 */
public interface MongoRepository<T, U extends Serializable> {

	/**
	 * Generic Save document to Mongo
	 * 
	 * @param t
	 * @return
	 */
	U save(T t);

	/**
	 * Generic Get Document bu object Id (document Id)
	 * 
	 * @param u
	 * @param collectionName
	 * @return
	 */
	T getById(U u, String collectionName);

	/**
	 * Get Document List by field
	 */

	List<T> getDocumentList(String fieldName, String fieldValue,
			String collectionName);

	/**
	 * Delete Document by Object
	 * 
	 * @param object
	 * @param collectionName
	 */
	void deleteDocument(T object, String collectionName);

	/**
	 * Generic Save document to Mongo
	 * 
	 * @param t
	 * @return
	 */
	U update(T t);

	/**
	 * Get Document List by field
	 */

	List<T> getAll();
}
