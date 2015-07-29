package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.base.BaseResource;
import model.base.BaseResourceCollection;
import model.base.BaseResourceElement;
import android.graphics.Bitmap;

public class ModelFactory {

	// Common
	public static <T> List<T> array(T... values) {
		return new ArrayList<T>(Arrays.asList(values));
	}

	public static <T> List<T> empty(Class<T> clazz) {
		return new ArrayList<T>();
	}

	public static <T extends BaseResource<E>, E extends BaseResourceElement> T resource(
			Class<T> clazz, String sessionId, E resourceElement) {
		try {
			T rtn = clazz.newInstance();
			rtn.sessionId = sessionId;
			rtn.resource = resourceElement;
			return rtn;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static <T extends BaseResourceCollection<E>, E extends BaseResource<?>> T resources(
			Class<T> clazz, E... resources) {
		return resources(clazz, array(resources));
	}

	public static <T extends BaseResourceCollection<E>, E extends BaseResource<?>> T resources(
			Class<T> clazz, List<E> resources) {
		try {
			T rtn = clazz.newInstance();
			rtn.resources = resources;
			return rtn;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static FriendResourceElement friend(Friend... friends) {
		return new FriendResourceElement(array(friends));
	}

	public static Friend friendData(int resourceId, String friendsName,
			Bitmap imp) {
		return new Friend(resourceId, friendsName, imp);
	}
	
}
