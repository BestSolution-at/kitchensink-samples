package at.bestsolution.e4.core.context;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

public class ConstructorBean {
	@Inject
	public ConstructorBean(@Named("dummy") String value) {
		// TODO Auto-generated constructor stub
	}
	
	@PreDestroy
	void cleanup() {
		System.err.println( this + ": DISPOSE");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.err.println( this + ": GC");
		super.finalize();
	}
}
