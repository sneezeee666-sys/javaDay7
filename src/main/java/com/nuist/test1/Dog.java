package com.nuist.test1;

public class Dog implements  Animal{
    @Override
    public void eat() {
        System.out.println("狗吃饭");
    }
    public void bark(){
        System.out.println("汪汪汪");
    }
}
