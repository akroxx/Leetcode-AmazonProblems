public class LRUCache{

	/**
	 * 1. Create a double Linked List Node data structure
	 * 2. Create the respective functions for DLL
	 * 3. Create HashMap of <Integer, DoubleLinkedList> and int size, capacity
	 * 4. Create LRUCache(int capacity) constructor to instantiate everything
	 * */

	class DoubleLinkedList{
		int key;
		int value;
		DoubleLinkedList prev;
		DoubleLinkedList next;
	}

	private void addNode(DoubleLinkedList node){

		// Always add new node by inserting right after the head
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	private void removeNode(DoubleLinkedList node){

		// Remove an existing node from the DLL
		DoubleLinkedList prev = node.prev;
		DoubleLinkedList next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	private void moveToHead(DoubleLinkedList node){

		// Move certain node to head of list

		removeNode(node);
		addNode(node);
	}

	private DoubleLinkedList popTail(){

		// remove current tail of the DLL
		DoubleLinkedList result = tail.prev;
		
		removeNode(result);
		return result;
	}

	private Map<Integer, DoubleLinkedList> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DoubleLinkedList head, tail;

	public LRUCache(int capacity){
		this.size = 0;
		this.capacity = capacity;

		head = new DoubleLinkedList();

		tail = new DoubleLinkedList();

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key){
		DoubleLinkedList node = cache.get(key);

		if(node == null) return -1;

		// move accessed node to the head of the list
		moveToHead(node);

		return node.value;
	}

	public void put(int key, int value){
		DoubleLinkedList node = cache.get(key);

		if(node == null){
			DoubleLinkedList newNode = new DoubleLinkedList();

			// Set values of newNode before putting into Cache HashMap
			newNode.key = key;
			newNode.value = value;

			cache.put(key, newNode);
			addNode(newNode);

			++size;

			if(size > capacity){

				// simply pop tail
				// since it is the most elderly cache member
				DoubleLinkedList tail = popTail();
				cache.remove(tail.key);
				--size;
			}
		}
		else{
			// update value if node exists
			node.value = value;
			moveToHead(node);
		}
	}
}