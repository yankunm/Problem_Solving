# Java Tips and Tricks

## HashCode() and Equals()

* Shallow Comparison: == (compare memory address)
* Deep Comparison: .equals (by default memory address, but customizable)

### Equals()

* Equivalence relation satisfies three properties: Reflexive, symmetry, and transitivity

~~~
public boolean equals(Object o);
~~~

**equals() template:**
1. If same memory address then true
2. If o is null or o and this does not have same class then false
3. Otherwise, typecast o and compare desired fields

-----

Now that we have implemented equals(), we must reimplement *hashCode()* as well because we don't want two objects that we said are logically EQUAL to drop in different buckets in a hash table.

### hashCode contract

1. hashCode must be consistent, if hashCode(x) == 1 then it should always equal to 1
2. If x.equals(y) == true then hashCode(x) must be equal to hashCode(y)
