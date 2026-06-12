//package utils;
//
//import java.io.FileInputStream;
//import java.util.Properties;
//
//public class TestDataReader {
//
//    private static Properties properties;
//
//    static {
//        try {
//            FileInputStream fis =
//                    new FileInputStream("src/test/resources/testdata.properties");
//
//            properties = new Properties();
//            properties.load(fis);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load test data file");
//        }
//    }
//
//    public static String get(String key) {
//        return properties.getProperty(key);
//    }
//}