## 义码当仙之集合框架

|Java集合框架图|Java集合框架简化图|
|:----|:----|
|![](images/集合框架图.png)|![](images/集合框架简化图.png) |

说明：对于以上的框架图有如下几点说明  
1. 所有集合类都位于java.util包下。Java的集合类主要由两个接口派生而出：Collection和Map，Collection和Map是Java集合框架的根接口，这两个接口又包含了一些子接口或实现类。  
2. 集合接口：6个接口（短虚线表示），表示不同集合类型，是集合框架的基础。  
3. 抽象类：5个抽象类（长虚线表示），对集合接口的部分实现。可扩展为自定义集合类。  
4. 实现类：8个实现类（实线表示），对接口的具体实现。  
5. Collection 接口是一组允许重复的对象。  
6. Set 接口继承 Collection，集合元素不重复。  
7. List 接口继承 Collection，允许重复，维护元素插入顺序。  
8. Map接口是键－值对象，与Collection接口没有什么关系。  
9. Set、List和Map可以看做集合的三大类：  
- List集合：是有序集合，集合中的元素可以重复，访问集合中的元素可以根据元素的索引来访问。  
- Set集合：是无序集合，集合中的元素不可以重复，访问集合中的元素只能根据元素本身来访问（也是集合里元素不允许重复的原因）。  
- Map集合：保存Key-value对形式的元素，访问时只能根据每项元素的key来访问其value。  

<hr>

### 手写List框架  
List集合代表一个有序集合，集合中每个元素都有其对应的顺序索引。List集合允许使用重复元素，可以通过索引来访问指定位置的集合元素。  

List接口继承于Collection接口，它可以定义一个允许重复的有序集合。因为List中的元素是有序的，所以我们可以通过使用索引（元素在List中的位置，类似于数组下标）来访问List中的元素，这类似于Java的数组。  

List接口为Collection直接接口。List所代表的是有序的Collection，即它用某种特定的插入顺序来维护元素顺序。用户可以对列表中每个元素的插入位置进行精确地控制，同时可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。实现List接口的集合主要有：ArrayList、LinkedList、Vector、Stack。  

#### ArrayList底层实现原理

- Arraylist底层基于数组实现  
```java
transient Object[] elementData;
```

- Arraylist底层默认数组初始化大小为10个object数组  
```java
/**
 * Default initial capacity.
 */
private static final int DEFAULT_CAPACITY = 10;

/**
 * Constructs an empty list with the specified initial capacity.
 *
 * @param  initialCapacity  the initial capacity of the list
 * @throws IllegalArgumentException if the specified initial capacity is negative
 */
public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
}
```

#### Vector底层实现原理
Vector是线程安全的，但是性能比ArrayList要低。  
ArrayList，Vector主要区别为以下几点：   
1. Vector是线程安全的，源码中有很多的synchronized可以看出，而ArrayList不是。导致Vector效率无法和ArrayList相比；  
2. ArrayList和Vector都采用线性连续存储空间，当存储空间不足的时候，ArrayList默认增加为原来的50%，Vector默认增加为原来的一倍；  
3. Vector可以设置capacityIncrement，而ArrayList不可以，从字面理解就是capacity容量，Increment增加，容量增长的参数。  

<hr>

### 手写Set框架

<hr>

### 手写Map框架

<hr>

### Java运算符

|运算符|说明|
|:----|:----|
|<<|左移运算符，num << 1,相当于num乘以2|
|\>>|右移运算符，num >> 1,相当于num除以2|
|\>>>|无符号右移，忽略符号位，空位都以0补齐|

<hr>

### 数组拷贝
Arrays.copyOf 功能是实现数组的复制，返回复制后的数组。参数是被复制的数组和复制的长度  
System.arraycopy 方法：如果是数组比较大，那么使用System.arraycopy会比较有优势，因为其使用的是内存复制，省去了大量的数组寻址访问等时间  
复制指定源数组src到目标数组dest。复制从src的srcPos索引开始，复制的个数是length，复制到dest的索引从destPos开始。  

src:源数组；	 
srcPos:源数组要复制的起始位置；  
dest:目的数组；  
destPos:目的数组放置的起始位置；  
length:复制的长度。  

注意：src and dest都必须是同类型或者可以进行转换类型的数组。  

有趣的是这个函数可以实现自己到自己复制，比如：
```java
int[] fun = {0,1,2,3,4,5,6}; 
System.arraycopy(fun,0,fun,3,3);
```
则结果为：{0,1,2,0,1,2,6};  

实现过程：先生成一个长度为length的临时数组，将fun数组中srcPos到srcPos+length-1之间的数据拷贝到临时数组中，再执行System.arraycopy(临时数组,0,fun,3,3)。  

<hr>





