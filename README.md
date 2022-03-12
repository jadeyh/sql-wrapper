#sql-wrapper
##用于MyBatis的条件构造器
***
实现参考了 *MyBatis-plus* ，所以条件构造的使用方式大概跟 *MyBatis-plus* 的条件构造器使用方式一致，链式调用，支持lambada表达式  
写这个工具的原因在于 *MyBatis-plus* 的条件构造器源代码功能更多，跟其他代码关联比较重，不好单独拆分出来，所以参照它的源码重新实现了一个，并加入了一些个人的理解。  
***
最终实现的大概有SelectWrapper和UpdateWrapper，用于构造查询和更新语句。  
大概的使用方法如下  
```
    @Select("SELECT ${sw.selectSegment} FROM r_form ${sw.sqlSegment}")
    List<Form> list(@Param(Constants.WRAPPER) SelectWrapper selectWrapper);
    
    @Update("update r_form SET ${sw.updateSegment} ${sw.sqlSegment}")
    void update(@Param(Constants.WRAPPER) UpdateWrapper updateWrapper);
```
sw为Constants.WRAPPER规定的默认变量名，如有需要可以自行修改
