package at.bestsolution.e4.core.context;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

public class ReinjectedBean {
	
	@Inject
	@Named("dummy") String value;
	
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
