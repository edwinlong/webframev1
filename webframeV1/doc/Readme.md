v1
【目标】
extjs userlist实现分页，crud功能，后台采用rest

【步骤】
1、测试userService、环境搭建（从spring-data-jpa项目拷贝）,webapp和web-inf,resources目录
2、加入mvc，测试输出"hello word"
3、extjs mvc实现user列表
4、分页
5、crud功能实现

【过程】
1、mvn test，发现会运行test目录下所有以TEST结尾的类，但是serviceTest是基础类，不用执行，所以把serviceTest改名为serviceTestBase
2、修改pom，加入springmvc
3、增加webapp目录,web-inf/web.xml,webapp/resources/common/404.html
4、增加spring-servlet.xml配置文件
5、增加UserController
6、测试Helloworld
User crud json输出
7、测试\user\1 获取id为1的用户
8、\user\ post修改用户
9、\user\ put 添加用户
10、\user\1 delete id为1的用户


【问题】
1、用mvn build -> jetty:run方式启动，debug时不方便，不能显示跟踪代码。
2、如果不在pom中引入jackson依赖包，当输出@ResponseBody对象时(String除外)报406页面错误，不可接受。
