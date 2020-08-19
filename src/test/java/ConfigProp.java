import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProp {

	public static Properties prop = new Properties();
	public static String filepath;

	static {
		try {
			InputStream str = new FileInputStream("config.properties");
			prop.load(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

}