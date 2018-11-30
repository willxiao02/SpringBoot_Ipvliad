# SpringBoot_Ipvliad

# Ipliad Porject specification

### how to use this project

1. Download those whole files.

2. Create Table. The DB system is Mysql(Server version:8.0.13)

The SQL reference information is saved in SQL.txt. You can refer to this doc to create the table.

3. Change configuration (the SpringBoot version is 2.1.0.RELEASE,Java version "11.0.1")

   update application.properties as below. The file path is src->main->resources->application.properties
```
server.port=8080

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/DBNAME?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
spring.datasource.username=xxx
spring.datasource.password=xxx
```
You need to update the DBNAME, username,password.

4. Run this project after configuration changed.

The CRUD API would be proived as below.

Add record(The status could be one of the following:STOPPED, BOOTING, STARTED)
http://localhost:8080/ip/add?ip=127.0.0.1&status=XXXX

get one record
http://localhost:8080/ip/get?id=1

update record 
http://localhost:8080/ip/update?id=1&ip=127.0.0.1&status=XXXX

get all records
http://localhost:8080/ip/getAll

delete record
http://localhost:8080/ip/delete?id=1

Thanks to read this doc. If you have any question, please let me know.

谢谢你关注

使用流程

## 1、下载项目

2、建表。找到SQL.txt文件，创建表

3、更改配置文件application.properties。

文件路径src->main->resources->application.properties文件

本项目使用的mysql数据库

需要更改配置文件的数据库名和登陆登陆信息如下：
```
server.port=8080

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/DBNAME?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
spring.datasource.username=xxx
spring.datasource.password=xxx
```
4、运行，测试。可以通过下面的方式操作数据

新增数据(status只有三种状态STOPPED, BOOTING, STARTED)
http://localhost:8080/ip/add?ip=127.0.0.1&status=XXXX

单个数据查询
http://localhost:8080/ip/get?id=1

数据更新
http://localhost:8080/ip/update?id=1&ip=127.0.0.1&status=XXXX

查看所有数据
http://localhost:8080/ip/getAll

删除数据
http://localhost:8080/ip/delete?id=1

初入springboot。有什么问题，还请指正。

<div align=center><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543526922661&di=a14aecd5c79b6cfda304a2321e8ea281&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201211%2F28%2F20121128180951_Urrhn.thumb.700_0.jpeg" width="400" height="600" alt="图片加载失败时，显示这段字"/> </div>

