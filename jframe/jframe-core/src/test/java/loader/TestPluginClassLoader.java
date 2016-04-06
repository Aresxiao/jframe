/**
 * 
 */
package loader;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import jframe.core.dispatch.DefDispatcher;
import jframe.core.plugin.loader.PluginCase;
import jframe.core.plugin.loader.PluginClassLoader;
import jframe.core.plugin.loader.ext.DefPluginLoaderContext;

/**
 * @author dzh
 * @date Oct 14, 2013 3:09:09 PM
 * @since 1.0
 */
public class TestPluginClassLoader {

	private static PluginClassLoader pcl;

	public static void main(String[] args) {
		URL url1 = TestPluginClassLoader.class
				.getResource("jframe-example-plugin-1.0.0.jar");
		URL url2 = TestPluginClassLoader.class
				.getResource("jframe-core-1.0.0.jar");
		DefPluginLoaderContext plc = new DefPluginLoaderContext();
		PluginCase pc = new PluginCase();
		pcl = new PluginClassLoader(pc, plc);
		pcl.addURL(url1);
		pcl.addURL(url2);

		// ClassLoader p = pcl.getParent();
		try {
			Class<?> clazz = pcl
					.loadClass("jframe.example.plugin.ExamplePlugin");
			System.out.println(clazz.newInstance().toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testClazzName() {
		Assert.assertEquals("jframe.core.dispatch.DefDispatcher",
				DefDispatcher.class.getName());
		System.out.println(DefDispatcher.class.getName());
		System.out.println(DefDispatcher.class.getSimpleName());
	}

}
