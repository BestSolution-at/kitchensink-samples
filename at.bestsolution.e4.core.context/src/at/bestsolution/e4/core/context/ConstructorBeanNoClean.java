package at.bestsolution.e4.core.context;

import javax.inject.Inject;
import javax.inject.Named;

public class ConstructorBeanNoClean {
	@Inject
	public ConstructorBeanNoClean(@Named("dummy") String value) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.err.println( this + ": GC");
		super.finalize();
	}
}
