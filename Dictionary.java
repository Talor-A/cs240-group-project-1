import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dictionary<K, V> implements DictionaryInterface<K, V> {

	DictionaryNode[] table;
	private final static int TABLE_SIZE = 5;

	public Dictionary() {
		table = (DictionaryNode<K, V>[]) new Object[TABLE_SIZE];
	}

	public V add(K key, V value) {
		int hash = (key.hashCode() % table.length);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		table[hash] = new DictionaryNode(key, value);
		return (V) table[hash].getValue();
	}

	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public V getValue(K key) {
		int hash = (key.hashCode() % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
              hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
              return null;
        else
              return (V)table[hash].getValue();
	}

	public boolean contains(K key) {
		// TODO Auto-generated method stub
		for (DictionaryNode i : table) {
			if (i != null && i.getKey() == key)
				return true;
		}
		return false;
	}

	public Iterator<K> getKeyIterator() {
		List<K> iter = new ArrayList<K>();
		for(DictionaryNode d : table) {
			iter.add((K) d.getKey());
		}
		return iter.iterator();
	}

	public Iterator<V> getValueIterator() {
		List<V> iter = new ArrayList<V>();
		for(DictionaryNode d : table) {
			iter.add((V) d.getValue());
		}
		return iter.iterator();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		for (DictionaryNode i : table) {
			if (i != null && !i.valid())
				return false;
		}
		return true;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return table.length;
	}

	public void clear() {
		// TODO Auto-generated method stub
		for (DictionaryNode i : table) {
			if (i != null)
				i.remove();
		}
	}

	public class DictionaryNode<K, V> {
		private K key;
		private V value;
		private boolean valid;

		public DictionaryNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.valid = true;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public boolean valid() {
			return valid;
		}

		public void remove() {
			this.value = null;
			this.key = null;
			this.valid = false;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public void setKey(K key) {
			this.key = key;
		}

	}

}
