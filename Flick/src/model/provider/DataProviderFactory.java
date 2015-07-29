package model.provider;

import java.util.HashMap;
import java.util.Map;

import model.FriendDataProvider;
import model.FriendResourceElement;

public class DataProviderFactory {

	private static Map<String, BaseResourceDataProvider<?>> resourceNameProviderMap;

	private static final Map<Class<?>, BaseResourceDataProvider<?>> elemClassProviderMap;

	public static BaseResourceDataProvider<?> getDataProviderByResourceName(
			String name) {
		return resourceNameProviderMap.get(name);
	}

	public static BaseResourceDataProvider<?> getDataProviderByResourceElementClass(
			Class<?> clazz) {
		return elemClassProviderMap.get(clazz);
	}

	static {

		FriendDataProvider fdp = new FriendDataProvider();

		elemClassProviderMap = new HashMap<Class<?>, BaseResourceDataProvider<?>>();

		elemClassProviderMap.put(FriendResourceElement.class, fdp);

		resourceNameProviderMap = new HashMap<String.BaseResourceDataProvider<?>>();

		resourceNameProviderMap.put("frinend", fdp);
	}

}
