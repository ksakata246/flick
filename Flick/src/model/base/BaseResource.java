package model.base;

public class BaseResource<R extends BaseResourceElement> {
	public R resource;

	public BaseResource() {
	}

	public BaseResource(R resource) {
		super();
		this.resource = resource;
	}

}
