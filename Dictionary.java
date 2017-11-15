import java.util.Iterator;

public class Dictionary<K,V> implements DictionaryInterface<K,V> {

	
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	public class DictionaryNode {
		public K key;
		public V value;

		public DictionaryNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
		public void setKey(K key) {
			this.key = key;
		}

	}

}
