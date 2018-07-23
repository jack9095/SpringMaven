package com.spring.annotation.bean;

import org.springframework.stereotype.Service;

/**
 * 默认它的id就是类名UserSerVice首字母小写
 *
 * 也可以通过value属性来设置bean的id,代码如下，这样bean的id就改为uService了。
 */
@Service
//@Service("uService")
public class UserSerVice {
    public void add(){
        System.out.println("service add");
    }
}
