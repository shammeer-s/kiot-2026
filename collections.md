# **Java Collections Framework: Method Reference**

## **1\. ArrayList**

A resizable-array implementation of the List interface. Permits all elements, including null.

| Method Signature | Usage / Description |
| :---- | :---- |
| boolean add(Object e) | Appends the specified element to the end of this list. |
| void add(int index, Object element) | Inserts the specified element at the specified position in this list. Shifts subsequent elements to the right. |
| boolean addAll(Collection c) | Appends all elements in the specified collection to the end of this list. |
| Object get(int index) | Returns the element at the specified position in this list. |
| Object set(int index, Object element) | Replaces the element at the specified position with the specified element. Returns the old element. |
| Object remove(int index) | Removes the element at the specified position. Shifts subsequent elements to the left. Returns the removed element. |
| boolean remove(Object o) | Removes the first occurrence of the specified element from this list, if it is present. |
| int indexOf(Object o) | Returns the index of the first occurrence of the specified element, or \-1 if not found. |
| boolean contains(Object o) | Returns true if this list contains the specified element. |
| int size() | Returns the number of elements in this list. |
| boolean isEmpty() | Returns true if this list contains no elements. |
| void clear() | Removes all elements from this list. |

## **2\. LinkedList**

A doubly-linked list implementation of the List and Deque interfaces.

| Method Signature | Usage / Description |
| :---- | :---- |
| void addFirst(Object e) | Inserts the specified element at the beginning of this list. |
| void addLast(Object e) | Appends the specified element to the end of this list. |
| boolean offerFirst(Object e) | Inserts the specified element at the front of this list. Returns true if successful. |
| boolean offerLast(Object e) | Inserts the specified element at the end of this list. Returns true if successful. |
| Object getFirst() | Returns the first element. Throws NoSuchElementException if empty. |
| Object getLast() | Returns the last element. Throws NoSuchElementException if empty. |
| Object peekFirst() | Retrieves, but does not remove, the first element, or returns null if empty. |
| Object peekLast() | Retrieves, but does not remove, the last element, or returns null if empty. |
| Object removeFirst() | Removes and returns the first element. Throws NoSuchElementException if empty. |
| Object removeLast() | Removes and returns the last element. Throws NoSuchElementException if empty. |
| Object pollFirst() | Retrieves and removes the first element, or returns null if empty. |
| Object pollLast() | Retrieves and removes the last element, or returns null if empty. |

*(Note: LinkedList also implements all standard List methods like add, get, remove(index), etc., as seen in ArrayList.)*



## **5\. HashSet**

A set backed by a hash table (actually a HashMap instance). Makes no guarantees as to iteration order.

| Method Signature | Usage / Description |
| :---- | :---- |
| boolean add(Object e) | Adds the specified element to this set if it is not already present. Returns true if the set did not already contain the element. |
| boolean remove(Object o) | Removes the specified element from this set if it is present. Returns true if the set contained the element. |
| boolean contains(Object o) | Returns true if this set contains the specified element. |
| int size() | Returns the number of elements in this set (its cardinality). |
| boolean isEmpty() | Returns true if this set contains no elements. |
| void clear() | Removes all elements from this set. |

## **6\. LinkedHashSet**

A hash table and linked list implementation of the Set interface, with predictable insertion-order iteration.

| Method Type | Usage / Description |
| :---- | :---- |
| Inherited Set Methods | Uses add(Object), remove(Object), contains(Object), size(), isEmpty(), and clear() identically to HashSet, but iteration yields elements in insertion order. |

## **7\. TreeSet**

A NavigableSet implementation based on a TreeMap. Elements are ordered using their natural ordering or a provided Comparator.

| Method Signature | Usage / Description |
| :---- | :---- |
| Object first() | Returns the first (lowest) element currently in this set. |
| Object last() | Returns the last (highest) element currently in this set. |
| Object pollFirst() | Retrieves and removes the first (lowest) element, or returns null if this set is empty. |
| Object pollLast() | Retrieves and removes the last (highest) element, or returns null if this set is empty. |

## **8\. HashMap**

A hash table based implementation of the Map interface.

| Method Signature | Usage / Description |
| :---- | :---- |
| Object put(Object key, Object value) | Associates the specified value with the specified key in this map. Returns the previous value associated with key, or null. |
| Object putIfAbsent(Object key, Object value) | If the specified key is not already associated with a value (or is mapped to null) associates it with the given value. |
| Object get(Object key) | Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key. |
| Object getOrDefault(Object key, Object defaultValue) | Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key. |
| Object remove(Object key) | Removes the mapping for the specified key from this map if present. Returns the previous value associated with key, or null. |
| boolean remove(Object key, Object value) | Removes the entry for the specified key only if it is currently mapped to the specified value. |
| boolean containsKey(Object key) | Returns true if this map contains a mapping for the specified key. |
| boolean containsValue(Object value) | Returns true if this map maps one or more keys to the specified value. |
| Object replace(Object key, Object value) | Replaces the entry for the specified key only if it is currently mapped to some value. |
| Set keySet() | Returns a Set view of the keys contained in this map. |
| Collection values() | Returns a Collection view of the values contained in this map. |
| Set entrySet() | Returns a Set view of the mappings contained in this map. |
| int size() | Returns the number of key-value mappings in this map. |
| void clear() | Removes all mappings from this map. |

## **9\. Iterator**

An interface for iterating over a collection, allowing the caller to safely remove elements during traversal.

| Method Signature | Usage / Description |
| :---- | :---- |
| boolean hasNext() | Returns true if the iteration has more elements. |
| Object next() | Returns the next element in the iteration. Throws NoSuchElementException if no more elements exist. |
| void remove() | Removes from the underlying collection the last element returned by this iterator. Can be called only once per call to next(). |
| void forEachRemaining(Consumer action) | Performs the given action for each remaining element until all elements have been processed. |

