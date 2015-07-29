package model.provider;

import model.base.BaseResourceCollection;

abstract public class BaseResourceDataProvider<T extends BaseResourceCollection<?>>
		extends BaseDataProvider {

	final Class<T> collectionClass;
	
	BaseResourceDataProvider(Class<T> collectionClass){
		this.collectionClass = collectionClass;
	}
	abstract public T get(String sessionGroupId);
	
	public Class<T> getCollectionClass(){
		return collectionClass;
	}
	
}
