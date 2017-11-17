/**
 * DictionaryTest
 */
public class DictionaryTest {
  public static void main(String[] args) {
    Dictionary<String, String> myDictionary = new Dictionary<String, String>();
    System.out.println("adding keys 1-3");
    String key1 = "key1";
    String key3 = "key3";
    myDictionary.add(key1, "value1");
    myDictionary.add("key2", "value2");
    myDictionary.add(key3, "value3");
    // System.out.println("removing key2");
    // myDictionary.remove("key2");
    // System.out.print("key2 removed successfully: ");
    System.out.println(!myDictionary.contains("key2"));
    System.out.print("key1 value: ");
    System.out.println(myDictionary.getValue(key1));
    System.out.println("Adding a bunch of keys...");
    for (int i = 4; i < 15; i++) {
      System.out.println("adding " + i);
      myDictionary.add("key" + i, "value" + i);
    }
    System.out.println("Testing Rehashing...");
    System.out.print("key3 value: ");
    System.out.println(myDictionary.getValue(key3));
  }

}