package at.bestsolution.e4.core.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		IEclipseContext rootContext = EclipseContextFactory.createServiceContext(Activator.getContext());

		System.err.println("Run 1");
		System.err.println("-----");
		testCleanup(rootContext, false);
		
		System.err.println("\n\n\n");
		System.err.println("Run 2");
		System.err.println("-----");
		testCleanup(rootContext, true);
		
		return IApplication.EXIT_OK;
	}
	
	private void testCleanup(IEclipseContext rootContext, boolean runWithGC) {
		IEclipseContext child = rootContext.createChild();
		child.set("dummy", "Hello World");
		
		System.err.println(ContextInjectionFactory.make(ConstructorBean.class, child));
		System.err.println(ContextInjectionFactory.make(ConstructorBeanNoClean.class, child));
		System.err.println(ContextInjectionFactory.make(ReinjectedBean.class, child));
		
		if( runWithGC ) {
			forceGC();
		}
		
		System.err.println("Before disposing context");
		
		child.dispose();
		
		System.err.println("After context disposed");
		
		forceGC();
	}
	
	private void forceGC() {
		System.err.println("Forcing GC");
		for( int i = 0; i < 100; i++ ) {
			List<String> arrayList = new ArrayList<>();
			for( int j = 0; j < 100_000; j++ ) {
				arrayList.add(i+j+"");
			}
			System.gc();
		}
	}

	@Override
	public void stop() {
		// nothing to do
	}
}
