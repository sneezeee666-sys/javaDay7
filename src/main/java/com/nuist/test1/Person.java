package com.nuist.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person<T extends Animal> {
    //T extends Animal 限制了T的类型
    //用泛型避免类型转换问题
    private String name;
//    private Animal pet ;

    private T pet;


    public void play(){
//        pet.eat();
        pet.eat();
//        限定完类型pet之后，pet就可以调用子类特有方法
        System.out.println(name+"正在和pet玩");
    }

}



















