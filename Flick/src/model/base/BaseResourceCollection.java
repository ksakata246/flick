package model.base;

import java.util.List;

public class BaseResourceCollection<R extends BaseResource<?>> {

	public List<R> resources;

	public BaseResourceCollection() {
	}

	public BaseResourceCollection(List<R> resources) {
		super();
		this.resources = resources;
	}
}
