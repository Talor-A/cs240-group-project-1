import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dictionary<K, V> implements DictionaryInterface<K, V> {

	DictionaryNode<K, V>[] table;
	private final static int INITIAL_TABLE_SIZE = 5;
	private int tableSize;

	public Dictionary() {
		tableSize = INITIAL_TABLE_SIZE;
		table = (DictionaryNode<K, V>[]) new DictionaryNode[tableSize];
	}

	public void rehash() {
		System.out.println("rehashing...");
		int newTableSize = (tableSize * 2) + 1;
		DictionaryNode<K, V>[] oldTable = table;
		table = (DictionaryNode<K, V>[]) new DictionaryNode[newTableSize];

		for (DictionaryNode<K, V> entry : oldTable) {
			if (entry != null && entry.valid()) {
				System.out.println("rehashing key " + (K) entry.getKey());
				add((K) entry.getKey(), (V) entry.getValue());
			}
		}
	}

	public V add(K key, V value) {
		if (isFull()) {
			rehash();
		}
		int hash = (key.hashCode() % table.length);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % tableSize;
		if (table[hash] != null) {
			//linear probe
		}
		table[hash] = new DictionaryNode<K, V>(key, value);
		return (V) table[hash].getValue();
	}

	public int getHash(K key) {
		int hash = key.hashCode() % tableSize;
		while (table[hash].getKey() != key) {
			hash = (hash + 1) % tableSize;
		}
		return hash;
	}

	public V remove(K key) {
		DictionaryNode<K, V> n = table[getHash(key)];
		V value = (V) n.getValue();
		n.remove();
		return value;
	}

	public V getValue(K key) {
		int hash = getHash(key);
		if (table[hash] == null)
			return null;
		else
			return (V) table[hash].getValue();
	}

	public boolean contains(K key) {
		// TODO Auto-generated method stub
		for (DictionaryNode<K, V> i : table) {
			if (i != null && i.getKey() == key)
				return true;
		}
		return false;
	}

	public Iterator<K> getKeyIterator() {
		List<K> iter = new ArrayList<K>();
		for (DictionaryNode<K, V> d : table) {
			iter.add((K) d.getKey());
		}
		return iter.iterator();
	}

	public Iterator<V> getValueIterator() {
		List<V> iter = new ArrayList<V>();
		for (DictionaryNode<K, V> d : table) {
			iter.add((V) d.getValue());
		}
		return iter.iterator();
	}

	public boolean isEmpty() {
		for (DictionaryNode<K, V> i : table) {
			if (i != null && !i.valid())
				return false;
		}
		return true;
	}

	public boolean isFull() {
		for (DictionaryNode<K, V> entry : table) {
			if (entry == null){
				System.out.println("not full!!");
				return false;
			}
		}
		System.out.println("full!");
		
		return true;
	}

	public int getSize() {
		return table.length;
	}

	public void clear() {

		for (DictionaryNode<K, V> i : table) {
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
