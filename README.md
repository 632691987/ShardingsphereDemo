https://shardingsphere.apache.org/index_zh.html

概念：
垂直分表：把一张表的一部分 column 存到新的表
垂直分库：把一部分表放到新的数据库

水平分表：把完全一样结构的表复制到同一个数据库，只是名字不同
水平分库：把完全一样的数据库复制出来放到另外一个数据库, 里面的结构一样




读写分离，就是把增删改做成一个数据库，写的话，就另外一个数据库

具体原理：
01, 主服务器开启 binlog ，记录当前服务器增删改操作
02, 从服务器实时监控 binlog 文件变化, 然后写入自己的日志，然后读取该日志并解释执行

步骤:
01, docker pull mysql
02, docker network create --subnet=172.18.0.0/16 mynetwork
03, docker run --name mastersql -it -p 3307:3306 --net mynetwork --ip 172.18.0.10 -e MYSQL_ROOT_PASSWORD=1q2w3e4R -d mysql
04, docker run --name slavesql -it -p 3308:3306 --net mynetwork --ip 172.18.0.12 -e MYSQL_ROOT_PASSWORD=1q2w3e4R -d mysql
05, docker run --name slavesql2 -it -p 3309:3306 --net mynetwork --ip 172.18.0.14 -e MYSQL_ROOT_PASSWORD=1q2w3e4R -d mysql
06, 
07, 
08, 
09, 



========================1, 开启主服务器 binlog======================
主服务器
[mysqld]
#开启日志
log-bin = mysql-bin
#设置服务id,主从不能一致
server-id = 1
#设置需要同步的数据库
binlog-do-db=user_db
#屏蔽系统库同步
binlog-ignore-db=mysql
binlog-ignore-db=information_schema
binlog-ignore-db=performance_schema

========================2, 开启从服务器 replicate======================
[mysqld]
#开启日志
log-bin = mysql-bin
#设置服务id,主从不能一致
server-id = 2
#设置需要同步的数据库
replicate_wild_do_table=user_db.%
#屏蔽系统库同步
replicate_wild_ignore_table=mysql.%
replicate_wild_ignore_table=information_schema.%
replicate_wild_ignore_table=performance_schema.%

=============================3, 允许被复制 ==============================
#切换至主库bin目录,登录主库
mysql ‐h localhost ‐uroot ‐p
#授权主备复制专用账号
GRANT REPLICATION SLAVE ON *.* TO 'db_sync'@'%' IDENTIFIED BY '1q2w3e4R';
#刷新权限
FLUSH PRIVILEGES;
#确认位点 记录下文件名以及位点
show master status

=============================4, 搭建过去 ==============================
#切换至从库bin目录,登录从库
mysql ‐h localhost ‐P3307 ‐uroot ‐p
#先停止同步
STOP SLAVE;
#修改从库指向到主库,使用上一步记录的文件名以及位点, 注意 container 之间的通讯
#其中 master_log_file 和 master_log_pos 的值来源于 `show master status`
CHANGE MASTER TO master_host = '172.18.0.10', master_port=3306, master_user = 'db_sync', master_password = '1q2w3e4R', master_log_file = 'mysql-bin.000001', master_log_pos = 609;
#启动同步
START SLAVE;
SHOW SLAVE STATUS;
#查看从库状态Slave_IO_Runing和Slave_SQL_Runing都为Yes说明同步成功,如果不为Yes,请检查