package dataProvider;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Unit test class
public class FileResourcesTest
{
//    Properties prop = new Properties();
//    InputStream inputStream;
//   public Properties loadPropTest() throws IOException, URISyntaxException {
//       try {
//
//           String propFileName = "configuration.properties";
//
//           inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//
//           if (inputStream != null) {
//               prop.load(inputStream);
//           } else {
//               throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
//           }
//
//       }
//       catch (Exception e)
//       {
//
//       }
//       return prop;
//   }
    public static Properties getPropertyObject() throws IOException
    {
        FileInputStream fp = new FileInputStream("src/main/resources/configuration.properties");
        Properties prop = new Properties();
        prop.load(fp);
        return prop;
    }
    public static String getApplicationUrl() throws IOException
    {
        return getPropertyObject().getProperty("url");
    }
    public static long getImplicityWait() throws IOException {
        String implicitlyWait = getPropertyObject().getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the configuration.properties file.");

    }
    public static String getUsername() throws IOException
    {
        return getPropertyObject().getProperty("username");
    }
    public static String getPassword() throws IOException
    {
        return getPropertyObject().getProperty("password");
    }

}