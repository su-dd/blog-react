# windows上的mongodb安装



**安装包：**使用的是压缩版本（https://fastdl.mongodb.org/windows/mongodb-windows-x86_64-4.4.2.zip）



**path配置：**增加mongo.exe 的文件夹路径 （例 D:\Program\mongodb\bin）



**新建mongod.cfg文件：**

```
# Where and how to store data.
storage:
  dbPath: D:\Program\mongodb\data\db
  journal:
    enabled: true
# where to write logging data.
systemLog:
  destination: file
  logAppend: true
  path:  D:\Program\mongodb\data\mongo.log

# network interfaces
net:
  # 端口号不能被其他程序占用
  port: 27017
  bindIp: 127.0.0.1
```



**安装服务依次执行：**

mongodb初始化.bat

```bat
mongod --dbpath D:\Program\mongodb\data\db
```

mongodb服务安装.bat

```bat
mongod --config "D:\Program\mongodb\bin\mongod.cfg" --install --serviceName mongod --serviceDisplayName mongod
```

服务启动.bat

````bat
net start mongod
````



**卸载依次执行：**

服务关闭.bat

```bat
net start mongod
```

mongodb服务删除.bat

```bat
mongod --remove --serviceName mongod
```

