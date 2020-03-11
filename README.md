## 码匠社区项目




## 工具


**1.@RestController和@Controller之间的区别：** 

@RestController相当于@Controller加上@ResponseBody,也就是说@RestController将返回值进行格式转换，如果返回类型是String，将直接返回
其String数值，而不是某个HTML文件；
 
 **2.@RequestParm和@RequestParam之间的区别：** 
 
 在路径上的区别：一个是 ？键值对，一个是  /参数。
 **@Parm注解**
 
 **3.OKHTTP**
 
 [okhttp](https://square.github.io/okhttp/) 
 
 这是一种http协议框架
 
 **4.OAuth**
 
 案例说明：
 我住在一栋有门禁的小区里面，门禁需要用户名和密码才能进来，
 但是我经常会点外卖和网上购物，所以，外卖小哥和快递员进不来，
 除非他们拥有用户名和密码，但是如果他们拥有了和我一样的用户
 名和密码，那岂不是和我拥有一样的权限了？这显然是不安全的。
 而OAuth就是一种安全的解决方法。这种方法具体点就是：在门禁
 上有一个申请进门的按钮，而这个按钮连到我这里，我通过给外卖
 小哥授权，让他们拥有进门的权限，以后再进来他们就可以用我给
 的授权进门了。而且他们仅仅是拥有进门的权限，而不会干其他越
 权的事情。
 
 
 ## 一次错误记录
 首先从Github第三方授权认证说起：其主要流程为：
 
 ***1.服务端向Github发送请求，Github会进行验证用户，验证成功后向服务端返回
 code，并且会回调服务端的API；***
 
 ***2.服务端向Github发送授权请求，也就是争取获得token***
 
 ***3.拿到token之后，向github拿用户的信息***
 
 其主要流程就这样，然后请求是采用OKHTTP框架发送的。但是通过调试发现获取到的token
 格式不对。然后通过postman将请求到的code以及一些参数带上，访问Github，获取token。
 获取的token格式正确无误，再次检查后发现。在将获取token的参数封装为dto对象时，
 参数名称写错了，改掉之后。正常。。。。
 
 ## H2数据库
 **1.H2数据库是一种单链接的数据库，每次只能一个连接**
 
 **2.H2数据库连接失败，显示用户名和密码不对**
 解决方法：
 
 Step1:
 使用脚本 
 
 `a.create user if not exists sa password 123456`
 
 `b.alter user sa admin true`
 
 Step2:
 使用test测试数据库连接是否成功
 
 **3.H2数据库**
 在IDEA中手动删除community02后，再次创建，发现发生错误，。之后使用rm ~/community02.* 删除成功，再次创建的时候创建成功。
 但是，这时候H2数据库不能显示schema，使用sql脚本才能看到。使用sql脚本也能查看到数据。
 ## MyBatis整合SpringBoot的几种方式
 **4.flyway**
 使用flyway的步骤：
 step1：
  引入flyway依赖：
  
 step2：清除之前创建的H2数据库(rm ~/community02.*)（如果不删除，可以增加配置类进行配置，这种没有尝试）。
 
 step3：使用命令执行数据库脚本(mvn flyway:migrate)
 
## 一次错误记录
```java
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    public void insert(Question question);
```
数据库字段为gmt_create、gmt_modified。之前使用的是驼峰命名法，出现错误，不能和model类匹配成功。修改之后未报错。在配置文件中开启驼峰命名也不起作用。
## 一次错误记录
问题描述：完善首页列表功能时，为用户显示头像，改变头像的大小，在community02.css中写上样式，但是重启项目后样式没有起作用。
问题解决：第二天IDEA重启后，发现问题自然而然解决掉了。(经过测试，发现是浏览器缓存问题，Ctrl+F5强制刷新解决问题)

问题描述：在UserMapper中编写接口：
```java
@Select("SELECT * FROM  user where id=#{id}")
public User findById(@Param("id") Integer id);
```
接着在QuestionService中编写
```java
 User user = userMapper.findById(question.getCreator());
```
其中User对象属性如下：
```java
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
```
数据库中的属性如下：
```sql
    id int auto_increment primary key not null,
    account_id varchar(100),
    name varchar(50),
    token varchar(36),
    gmt_create bigint,
    gmt_modified bigint
```
执行后发现user对象中驼峰命名的属性值为null
解决方案：在application.properties中加上配置
```properties
mybatis.configuration.mapUnderscoreToCamelCase=true
```
问题解决。