/**
 * DictionaryTest
 */
public class DictionaryTest {
  public static void main(String[] args) {
    Dictionary myDictionary = new Dictionary<String,String>();
    System.out.println("adding keys 1-3");
    String key1 = "key1";
    myDictionary.add(key1, "value1");
    myDictionary.add("key2", "value2");
    myDictionary.add("key3", "value3");
    System.out.println("removing key2");
    myDictionary.remove("key2");
    System.out.print("key2 removed successfully: ");
    System.out.println(!myDictionary.contains("key2"));
    System.out.print("key1 value: ");
    System.out.println(myDictionary.getValue(key1));
  }
  
}