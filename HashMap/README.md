# Hash Table ADT

When the number of elements stored is small compared to the number of "buckets", hashing shines with its search efficiency.

## HashMap Methods

Basics:
* get(key): Return "value" associated with "key"
* getOrDefault(key, defaultVal): Return "value" associated with "key", if "key" is absent then return "defaultVal"
* put(key,val): Insert into HashMap
* putAll(map): Put map into another map, replace any duplicate keys
* remove(key): Remove element with specified "key"
* remove(key, val): Remove only if (key, val) both match
* containsKey(key): Return true if map has key
* containsValue(val): Return true if map has val


Traversal:
* keySet(): Return a set of keys
* values(): Return a set of values
* entrySet(): Return a set of Map.Entry objects
* getKey(): Get key on a Map.Entry object
* getValue(): Get value on a Map.Entry object
* replace(key, val): Replace key's value with "val", return null if key not found

## Hash Table Template

* **HashMap** - Array + Linked List (chaining, data needs equals() and hashCode() methods)
* **LinkedHashMap** - HashMap with order (key insertion order), stores all keys in a doubly linked list (large overhead)
* **TreeMap** - Map with order (smallest-to-biggest), stores all keys in red-black tree (O(log n))
* **HashSet** - A HashMap without *value*, only *keys*

Hash Table is affected by two things: *Initial Capacity* and *Load Factor*

**Initial Capacity** - how many buckets are there in the beginning
**Load Factor** - A Limit on when to resize

When the number of things in the hash table reaches *Load Factor times capacity*, the capacity is doubled. 

For example, if the load factor is 0.5, and the capacity of the hash table is 10. When the number of things reaches 5, the hash table must be **rehashed** to a table size of 20. 

Default Load Factor = 0.75

**The Load Factor controls the tradeoff between TIME and SPACE**

More load factor --> more things to put --> more collisions --> lookup time slows down <br>
Less Load Factor --> more space to put things --> too much wasted empty space <br>

## Hash Functions

A **hash function** maps a *key* to a *bucket*. 

It originated as a way to compress data to reduce memory. Hash functions speed up database lookup.

Hash function must output: a fixed-length string of alphanumeric characters.

Three requirements for hash function: <br>
1. Simple to compute
2. DISTINCT keys gets mapped to DISTINCT locations
3. Distribute keys EVENLY across locations

## History

Hashing with Chaining - Hans Peter Luhn (German Researcher, 1953, IBM) <br>
Open Addressing based Hash Tables, Linear Probing (IBM 701, Arthur Lee Samuel, Gene Myron Amdahl, Elaine M. McGraw, Nathaniel Rochester, 1954, IBM) <br>
Hashing with Linear Probing - Andrey Petrovich Yershov (Soviet Computer Scientist, 1950s) <br>
Came up with word "Hashing" - [Robert Morris](https://www.nytimes.com/2011/06/30/technology/30morris.html) (American Cryptographer, 1960-1986, Bell Labs) <br>

## Direct Addressing

Let universe of keys U = {0,1, 2, ... , m - 1}. We use an array T (direct-address table) to store the keys, each bucket corresponds to a key in U.

The index in T = k. The value in T[k] is the satellite data associated with the k.

Hash function: H(k) = k

Three Dictionary Operations: <br>
1. Search(T, k): return T[k] <br>
2. Insert(T, x): T[x.key] = x <br>
3. Delete(T, x); T[x.key] = null <br>

Table Size: O(|U|)

Let K be the set of active keys used, which is a subset of U. We want storage to be O(|K|).

## Collisions

A collision is when two things gets hashed to same bucket.

According to the Pigeonhole Principle, if n > m and n balls fit into m buckets, then there exists at least one bucket with two or more balls.

Software engineers are interested in hash functions with *infinite domain* and *finite range*, therefore collisions are almost **unavoidable**.

## Collision Resolution: Chaining

Chaining: Every bucket is a linkedlist

Three Dictionary Operations: <br>
1. Search(T, k): Search for k in list T[h(k)] <br>
2. Insert(T, x): Insert x at list T[h(x.key)] <br>
3. Delete(T, x); Remove x at list T[h(x.key)] <br>

### Load Factor

Load factor is [number of elements] divided by [number of buckets].

The load factor is the average number of elements stored in a chain. 

The load factor is used to analyze the search time of a hash table. Because with chaining, we are interested in:

**How evenly does the hash function distribute keys over all m slots**

### Average Search Time Analysis

Assume hash function is simple to compute, <br>
Assuming *Simple Uniform Hashing* - a given key has equal chance to be mapped to any spot:

The expected value of the size of the list at the j-th spot in the table, is equal to the load factor.

When we search, we find a list and search the list, and two things occur: <br>
1. We find the element (O(1 + load factor) time)
2. We don't find the element (O(1 + load factor) time)

(1 for time to compute h(k), load factor for the size of the list)

### hashCode() and equals()

If a key is not in the set of natural numbers, then we must convert it.

hashCode() must be consistent with equals(): two objects that are equal must have the same key (any hash function should map them to the same bucket)
















