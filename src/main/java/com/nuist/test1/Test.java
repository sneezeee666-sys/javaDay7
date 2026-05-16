package com.nuist.test1;

import jdk.internal.util.ArraysSupport;

import java.util.*;

@SuppressWarnings("all")
//抑制所有的警告的注解
public class Test {
    //数组弊端？ 长度固定 没有足够多的方法操作元素。（好处是 运行效率高）
    //集合 2个接口：单列集合：Collection  双列集合：Map
    //Collection 子实现类---->List(ArrayList,LinkedList,Vector) Set(HashSet,LinkedHashSet,TreeSet).
    //Map 子实现类---->HashMap,LinkedHashMap,TreeMap,ConcurrentHashMap
    //Map区别于Collection，存储的是键值对，key 不能重复，value可以重复

    //list接口的三个特性：
    //1.元素的存储和读取顺序一致
    //2.可以存储重复数据
    //3.数据是有下标的（链表的下标特殊实现）
    //set接口的特性
    //1.元素的存储和读取顺序不保证一致
    //2.不可以存储重复数据
    //3.数据无下标，无法用传统for循环进行遍历

    //学习目标：
    //1.所有常见集合的基本使用（创建，修改，遍历）
    //2.掌握不同集合的共性和差异
    //3.掌握部分集合的数据结构和源码实现原理
    //方式
    //从接口进行学习 使用底层类实现。





    public static void main(String[] args) {
/*        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add(123);
        System.out.println(c);*//*
        //集合自带打印方法

        //集合中的元素没有限定类型，可以添加任意类型元素

//泛型介绍，举例
        //用泛型 来限制集合中的元素类型
        //在代码经过编译之后，运行的时候，会擦除泛型信息（泛型擦除）
        Collection<String> c1 = new ArrayList();
        c1.add("hello");
        c1.add("world");
//        c1.add(666);*/




/*        Person p = new Person();
        p.setName("张三");
        Animal pet = new Dog();
        p.setPet(pet);
        p.play();

        //如果通过Person获取pet 调用pet的子类特有方法 需要进行向下转型。
//        p.getPet().bark();
        if(p.getPet() instanceof Dog d){
            d.bark();
        }
        */

/*        //用泛型避免类型转换问题
        Person<Dog> p = new Person<>();
        p.setName("张三");
        p.setPet(new Dog());
        p.play();
        p.getPet().bark();

//      Person<Person> p1 = new Person<>();
//      人没有实现Animal接口*/


/*        Collection<String> c1 = new ArrayList<>();
        Collection<String> c2 = new ArrayList<>();

        c1.add("a");
        c1.add("b");
        c1.add("c");
        c2.add("a");
        c2.add("d");
*//*        c1.addAll(c2);
        //类似于mysql 的UNION ALL
        System.out.println(c1);*//*
//        c1.removeAll(c2);
//         去交集
//        System.out.println(c1);
        System.out.println(c1.equals(c2));
        c1.clear();
        c2.clear();
        System.out.println(c1.equals(c2));
        c1.add("a");
        c1.add("b");
        c2.add("b");
        c2.add("a");
        System.out.println(c1.equals(c2));*/
        //满足顺序，元素，长度都相等。

/*        List<String> l = new ArrayList<>();
        l.add("a");
        l.add(0,"b");
        //在指定位置添加元素
        System.out.println(l);
        l.set(0,"c");
        System.out.println(l);
        System.out.println(l.get(0));
        l.add("c");
        System.out.println(l.indexOf("c"));
        System.out.println(l.lastIndexOf("c"));
        System.out.println(l.subList(0,1));
        l.remove(1);
        System.out.println(l);
        //仅限于List使用的方法，因为List有下标。*/

/*        //List集合的遍历方式
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("c");

        //1.传统for循环
        for(int i = 0;i < l.size();i++){
            System.out.print(l.get(i)+" ");
        }
        System.out.println( "");

        //2.增强for循环
        for(String s : l){
            System.out.print(s+" ");
        }
        System.out.println("");

        //3.stream流式计算方式遍历(后续课程)
        //TODO
        l.stream().forEach(System.out::print);
        System.out.println("");

        //4.迭代器遍历方式
        //1.获取当前集合的迭代器对象
        Iterator<String> it = l.iterator();
        //迭代器有两个核心方法
        //1.hasNext() 判断是否还有下一个元素
        //2.next() 获取下一个元素
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }*/

/*        // 迭代器删除陷阱
        //定义一个学生类id，name
        //创建一个List<Student>，存放1000个学生对象 id从1-1000；
        //找到list中所有id能被8整除的元素 从集合中删除它
        //遍历的时候分别用传统for和 迭代器遍历删除；
        List<Student> list = new ArrayList<>();
        for(int i = 1;i <= 1000;i++){
            Student s = new Student();
            s.setId(i);
            s.setName("学生"+i+"号");
            list.add(s);
        }

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.getId() % 8 == 0){
                *//*list.remove(s);
                //modCount值变化了*//*
                it.remove();
                //在使用迭代器的remove()方法删除元素时，迭代器对象it的modCount值不变
                //应该要使用迭代器自己的remove方法来代替集合的remove方法。
            }
        }
        System.out.println(list);*/

        //部分源码
        /*ArrayList.this.remove(lastRet);
        cursor = lastRet;
        lastRet = -1;
        expectedModCount = modCount;
        更新了ModCount，进行数据同步*/

/*        for(int i = 0;i < list.size();i++){
            Student s = list.get(i);
            if(s.getId() % 8 == 0){
                list.remove(s);
            }
        }
        System.out.println( list);
        //size是动态获取的，每次删除都会改变集合的长度*/




/*        //嵌套泛型问题
        List<Dog> l = new ArrayList<>();
        List<List<Dog>> l2 = new ArrayList<>();
        List<List<List<Dog>>> l3 = new ArrayList<>();
        //装狗的笼子：List<Dog>
        //装狗笼子的笼子（卡车）：List<List<Dog>>

        //TODO 后续要用流式计算的flatMap方法进行遍历*/

/*        List<String> l = new ArrayList<>();
        l.add("a");
        //此时集合的容量是10
        //size 是 1

        //源码部分
        *//*private Object[] grow(int minCapacity) {
            int oldCapacity = elementData.length;
            if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                int newCapacity = ArraysSupport.newLength(oldCapacity,
                        minCapacity - oldCapacity, *//**//* minimum growth *//**//*
                        oldCapacity >> 1           *//**//* preferred growth *//**//*);
                        //右移一位是  /2
                        //左移一位是  *2
                return elementData = Arrays.copyOf(elementData, newCapacity);
            } else {
                return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
            }*//*

        //扩容
        //扩容1.5倍
        //如果增长的超过之前的0.5，则扩容增长的长度
        //当 ArrayList 容量不足时，会按原容量的 1.5 倍进行自动扩容（若新容量仍小于所需最小容量，则直接扩容至所需最小容量），并将原数组元素拷贝到新数组中
        for(int i = 0;i < 11;i++){
            l.add("b");
        }*/





        //LinkedList部分

        /*LinkedList<String> l = new LinkedList<>();

        //单向队列
        Queue<String> q = new LinkedList<>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        System.out.println(q.peek());
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
        //队列的三种常用方法offer poll peek

        //双向队列
        Deque<String> d = new LinkedList<>();
        d.offerLast("a");
        d.offerLast("b");
        d.offerFirst("c");
        System.out.println(d.peekLast());
        System.out.println(d);
        System.out.println(d.pollFirst());
        System.out.println(d);*/

        //ArrayList数组特点 有index 并且在内存中又连续存储 查询快 插入和删除慢
//        List<String> l = new ArrayList<>();
//        l.remove(l.size()-1);
//        l.remove(0);
        //效率跟位置有关

//        LinkedList 底层是双向链表 插入和删除快 查询相对较慢



        //Set集合部分
        //1.存读不保证有序
        //2.不允许存储重复元素
        //3.没有下标
        //需要掌握三个Set：HashSet TreeSet LinkedHashSet
        //HashSet底层实现由 HashMap 提供
        //TreeSet底层实现由 TreeMap 提供
        //LinkedHashSet底层实现由 LinkedHashMap 提供
        /*Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(3);
        s.add(2);
        System.out.println(s.add(1));
        //有重复元素就会返回false；
        System.out.println(s);*/
        /*Set<Animal> s = new HashSet<>();
        List<Dog> d = new ArrayList<>();
        s.addAll( d);*/
        //源码部分
        //boolean addAll(Collection<? extends E> c);
        //只要满足E或者是E的子类就可以
        //set集合的大部分方法和Collection一样
        //需要注意的是add方法会判断是否插入了重复的元素

        /*//set集合的遍历方法
        Set<String> s = new HashSet<>();
        s.add("a");
        s.add("b");
        s.add("c");
        //1.增强for循环
        for(String s1:s){
            System.out.println(s1);
        }
        //2.迭代器
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

        //TreeSet排序底层是红黑树
        //比较器的实现方式
        //1.实现Comparable接口 jdk中的类大部分都是这么实现的
        //2.实现Comparator接口 自定义比较器 通常用于开发
        //划重点，只有一个方法的接口叫做函数式接口
        //Comparable 接口就是函数式接口
//        System.out.println("a".compareTo("c"));

       /* TreeSet<String> ts = new TreeSet<>();
        ts.add("aa");
        ts.add("c");
        ts.add("b");
        System.out.println(ts);*/

        //如果要使用无参构造方法创建TreeSet对象，那么必须保证集合中的元素必须实现Comparable接口
        //要么就自定义比较器
        //否则会报异常
/*        TreeSet<Product> ts = new TreeSet<>();
//        ts.add(new Product());
//Exception in thread "main" java.lang.ClassCastException
// class com.nuist.test1.Product cannot be cast to class java.lang.Comparable (com.nuist.test1.Product is in unnamed module
        ts.add(new Product("a",1,1,"a","a","a",1));
        ts.add(new Product("b",2,2,"b","b","b",2));
        ts.add(new Product("c",3,3,"c","c","c",3));*/
//        System.out.println(ts);
/*        List<Product> ps = new ArrayList<>();
        ps.add(new Product("a",1,1,"a","a","a",1));
        ps.add(new Product("b",2,2,"b","b","b",2));
        ps.add(new Product("c",3,3,"c","c","c",3));
        Collections.sort(ps);
        System.out.println(ps);*/

        //使用自定义比较器
        //创建自定义比较器对象
        /*ProductPriceAscComparator p = new ProductPriceAscComparator();
        TreeSet<Product> ts = new TreeSet<>(p);
        ts.add(new Product("a",1,1,"a","a","a",1));
        ts.add(new Product("b",2,2,"b","b","b",2));
        ts.add(new Product("c",3,3,"c","c","c",3));
        System.out.println(ts);
        System.out.println("========================================================");
        List<Product> ps = new ArrayList<>();
        ps.add(new Product("a",1,1,"a","a","a",1));
        ps.add(new Product("b",2,2,"b","b","b",2));
        ps.add(new Product("c",3,3,"c","c","c",3));
        Collections.sort(ps,p);
        System.out.println(ps);*/

        //Map键值对集合
        //json{"name":"张三","age":18}
        //可以互相转化
        //Map的key不能重复   value是可以重复的
        //HashMap HashTable LinkedHashMap TreeMap ConcurrentHashMap(线程安全且高效的并发集合，来自juc包）
        /*Map<String,String> m = new HashMap<>();

        System.out.println(m.put("man","牢大"));
        System.out.println(m.put("man","科比"));
        //put的返回值，是旧值。
        //key相同时用新值替换旧值，返回旧值。
        System.out.println(m.containsKey("man"));
        System.out.println(m.containsValue("ikun"));
        m.remove("man");
        m.put("man","ikun");

        //map的遍历
        //1.迭代器
        Iterator<String> it = m.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = m.get(key);
            System.out.println(key+":"+value);
        }
        //2.借助EntrySet
        Iterator<Map.Entry<String,String>> it1 = m.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry<String,String> entry = it1.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //3.增强for循环
        for(String key:m.keySet()){
            String value = m.get(key);
            System.out.println(key+":"+value);
        }
        //4.增强for 借助EntrySet
        for(Map.Entry<String,String> entry:m.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/

        //TreeMap 所有的键值对都会按照键的升序排列
        //前提：键必须实现Comparable接口 或者自定义比较器
/*        TreeMap<Integer,String> m = new TreeMap<>();
        m.put(1,"kobe");
        m.put(2,"james");
        m.put(3,"curry");
        System.out.println(m);
        System.out.println(m.firstKey());
        System.out.println(m.firstEntry());
        //获取第一个键值对。
        System.out.println(m.ceilingKey(2));
        //找>=2的最小键
        System.out.println(m.floorKey(2));
        //找<=2的最大键
        System.out.println(m.higherKey(2));
        //找>2的最小键
        System.out.println(m.lowerKey(2));
        //找<2的最大键*/


        //LinkedHashMap 是HashMap的子类，继承了HashMap的属性和方法，并且还添加了双向链表
        //保证map的存储顺序和读取顺序一致
/*        LinkedHashMap<Integer,String> m = new LinkedHashMap<>();
        m.put(24,"kobe");
        m.put(2,"james");
        m.put(3,"curry");
        System.out.println(m);
        //LinkedHashSet 是HashSet的子类，继承了HashSet的属性和方法，并且还添加了双向链表
        //保证set的存储顺序和读取顺序一致
        LinkedHashSet<Integer> s = new LinkedHashSet<>();
        s.add(24);
        s.add(2);
        s.add(3);
        System.out.println(s);*/

        //总结：
        //集合Collection Map
        //List ArrayList LinkedList             Vector（线程安全，和ArrayList相似）
        //Set HashSet LinkedHashSet TreeSet
        //Map HashMap LinkedHashMap TreeMap     HashTable（线程安全，和HashMap相似，但键值不能为null）

//        Hashtable<Integer,String> m = new Hashtable<>();
//        m.put(null,"kobe");

        //比较器：用来比较两个对象，并返回结果
        //1.自定义类实现Comparable接口
        //2.自定义类创建Comparator对象（实际开发的时候更加易于拓展）

        //预告：
        //hash表原理 手撕青春版HashMap
        //排序二叉树 手撕 一个
        //匿名内部类 lambda表达式 函数式接口 流式计算
        //File I/O流























    }

}




































