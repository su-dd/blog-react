# 阿里云部署 nodejs+mongoDB 傻瓜教程



教程完全搬自（https://zhuanlan.zhihu.com/p/24474840），记录在文章头，以防忘记。



**一、阿里云申请/购买服务器**

1. 进入阿里云官方网站，找到云服务器ECS。

阿里云云服务器地址： [阿里云服务器](https://link.zhihu.com/?target=https%3A//s.click.taobao.com/t%3Fe%3Dm%3D2%26s%3DgQ9yP5pPCGQcQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAij7T60t9JDv741EQ3I01g0rm0I6CXbmEWTUsjgao5HN8KDvQmyOMwTA%2FDQJ2oexMhmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6uIOTs4KMj3yjpOyWSRdiSZDEm2YKA6YIrbIzrZDfgWtwGXLU4WXsy8CZuZoOOkzXFxfvOyje0ynomfkDJRs%2BhU%3D)



2. 点击立即购买之后进入到确认订单页， 会有一个设置密码。这个密码设置好之后要记住，待会儿要用到。设好密码之后点击去下单。

![img](https://pic1.zhimg.com/80/v2-5cff62d82e459b86cc75069eb1848378_720w.jpg)




3. 买好云服务器之后，你在阿里云的首页，登陆之后可以直接点击右上角的控制台

![img](https://pic3.zhimg.com/80/v2-2a77e7d304b3842a9748539ae66aed4e_720w.jpg)



4. 在左边点击云服务器ECS

![img](https://pic1.zhimg.com/80/v2-2b771b0c6ba8aa28adbbfae8740c3374_720w.jpg)

5. 找到你刚才购买地区，运行中字样的图标。我买的是云服务器，有一个在运行中，就是这个，点击
   运行中1

![img](https://pic2.zhimg.com/80/v2-a170dad775e9baae5441f55116f8ffd5_720w.jpg)



6. 这时候你就可以看到你买到的云服务器了，注意我用红框框出来的位置，这个IP地址就是你的公网IP，后面要用到。

![img](https://pic2.zhimg.com/80/v2-c671a15fcd4e0a2d972ae19f49c464a5_720w.jpg)



**二、下载及安装putty和Xftp**

putty 是用于连接你手头上这台电脑以及你刚才购买的阿里云服务器，没有这个软件，你都不知道上哪儿敲部署教程里面的那些个字母（没错，我就是白痴到竟然在这个步骤走了许多弯路）

Xftp 用于部署好之后把你本地写好的程序上传到云服务器

tips：putty直接下载就可以用了，Xftp下载好之后安装，一直下一步也可以了。

三、为云服务器安装环境

1. 连接云服务器

A.双击putty

![img](https://pic3.zhimg.com/80/v2-c6c73c3dc4d30b7a1f8d6bc2525c5e5e_720w.jpg)



B.出现的这个页面填写红框内信息，host name那里填写刚才申请的阿里云的公网IP，port一般是22，选择SSH，only on clean exit。点击open

![img](https://pic4.zhimg.com/80/v2-87387c713a39ae5d3298b592db077637_720w.jpg)



C.然后进入这个状态，

![img](https://pic3.zhimg.com/80/v2-8848308acd3f383e4599543587c94ede_720w.jpg)



输入root，回车。这是它会让你输入密码（tips），回车。出现

![img](https://pic1.zhimg.com/80/v2-174e66d0995627b78c176f3cf314136c_720w.jpg)



的时候，表示连接远程服务器成功了。

tips：注意linux系统，输入密码的时候不会出现任何字符包括空格或者*号，放心吧不是电脑坏了。当初我做的时候从来没有用过linux系统，一度怀疑我自己是不是又哪里操作错了，导致没反应

2. 把yum更新到最新版本：

   ```
   yum -y update
   ```

3. 我们将使用最新源代码构建Node.js，要进行软件的安装，需要一组用来编译源代码的开发工具：
	```text
	yum -y groupinstall "Development Tools"
	```

4. 安装node.js

   A.开始安装Node.js，先进入/usr/src文件夹，这个文件夹通常用来存放软件源代码:

	cd /usr/src 

​	B.从 ***[Node.js的站点](https://link.zhihu.com/?target=http%3A//nodejs.org/download)\*** 中获取压缩档源代码, 我选择的版本为v6.9.1：

	wget http://nodejs.org/dist/v6.9.1/node-v6.9.1.tar.gz 

tips：以上安装nodejs的地址所包含的版本号，你需要跟根据不本地配置使用的nodejs版本来决定，先找到自己的版本号，然后把以上地址的‘6.9.1’替换成你使用的版本号

C.解压缩源文件，并且进入到压缩后的文件夹中:

	tar zxf node-v6.9.1.tar.gz
	cd node-v6.9.1

D.执行配置脚本来进行编译预处理:

	./configure 

E.开始编译源代码

	make

F.当编译完成后，我们需要使之在系统范围内可用, 编译后的二进制文件将被放置到系统路径，默认情况下，Node二进制文件应该放在/user/local/bin/node文件夹下

	make install 

G.现在已经安装了Node.js, 可以开始部署应用程序。首先要使用Node.js的应用管理模块，pm2(用于启动程序并在需要时重启非常有用的模块）：



	npm -g install pm2 

H.建立超级链接, 不然 sudo node 时会报 "command not found"

    sudo ln -s /usr/local/bin/node /usr/bin/node 
    sudo ln -s /usr/local/lib/node /usr/lib/node 
    sudo ln -s /usr/local/bin/npm /usr/bin/npm 

5. 安装mongoDB（数据库）

A.进入文件夹/usr/local,下载mongodb源代码：

    cd /usr/local
    wget http://fastdl.mongodb.org/linux/mongodb-linux-x86_64-3.2.11.tgz

tips:同样，以上mongoDB安装的地址所涉及的版本号，也请根据你本地安装的版本进行更改

B.解压安装包，重命名文件夹为mongodb

    tar zxvf mongodb-linux-x86_64-3.2.11.tgz
    mv mongodb-linux-x86_64-2.4.9mongodb

C.在var文件夹里建立mongodb文件夹，并分别建立文件夹data用于存放数据，logs用于存放日志

    mkdir /var/mongodb
    mkdir /var/mongodb/data
    mkdir /var/mongodb/logs

D.打开rc.local文件，添加CentOS开机启动项：

    chmod +x /etc/rc.d/rc.local

E.将mongodb启动命令追加到本文件中，让mongodb开机自启动：

    /usr/local/mongodb/bin/mongod --dbpath=/var/mongodb/data --logpath /var/mongodb/logs/log.log -fork

F.启动mongodb

    /usr/local/mongodb/bin/mongod --dbpath=/var/mongodb/data --logpath /var/mongodb/logs/log.log -fork

G.看到如下信息说明已经安装完成并成功启动:

    forked process:18394

tips：数字不一定是要这个数字，是什么数字不重要，出现类似这样的就可以了



F.tips：给mongodb加密码

这一步可以说非常重要也可以说不重要，如果你只是想要尝试一下使用服务器看看自己的应用。其实可以不用加密码就可以用了（可以直接跳过F.tips这个步骤）。

但是如果你的mongo没有加密码，那么你很有可能被扫库程序删光你的数据（网上流传的一中病毒概念的东西，会一次性删光你的数据，再留下联系方式需要你付款索回【不知道对不对，如果有知道的朋友请提示我】），当初我刚开始弄好mongo的时候，就是没有加密码，老是被清光，然后我又一次一次的把数据加回去。（当时看了一下加密码教程，觉得好麻烦啊，我又不是真的要经营网站，只是想看看效果，就没有加密码）



首先我们进入mongo，添加帐号密码

mongo

进入数据库
admin

use admin

添加账号密码

db.createUser({user: "test",
pwd: "123", roles: ["root"]})

返回 Successfully added user: { "user" : "test",
"roles" : [ "root" ] }说明用户创建成功了。

退出（按ctrl + c）

接下来我们要打开mongo配置文件为需要验证用户才能登陆

先关闭mongo服务

sudo service mongod stop



修改配置文件。

sudo vim /etc/mongod.conf



长这样

![img](https://pic3.zhimg.com/80/v2-9799588c4b0461fdf930018a22af022a_720w.jpg)



我们加上

security:

authorization:
enabled



后长这样

![img](https://pic2.zhimg.com/80/v2-c879315817818a52fe6a0f73af60f3a5_720w.jpg)



启动mongo服务

sudo
service mongod start



再次进入mongo（这次只是尝试能不能成功登陆）

use
admin

db.auth("test","123")



返回1表示登陆成功了。（同样的，你的程序连接数据库的时候应该要写好相应的用户名密码，不然程序连不上库哦）

继续tips:程序连接数据库，我的程序使用的是mongoose，那么我用mongoose来举例，如果你们用的是其他的npm包，那就自己去查查资料了哦。

mongodb://<mongo用户名>:<mongo密码>@$<ip地址>:<port端口号>/<数据库名>?authSource=admin

比如说刚才我设置的用户名是test，密码是123，ip地址是192.168.2.2（刚才买的阿里云服务器的外网ip），端口号是27017（没有重新设置的mongo端口号都是27017），想要连接的数据库名是mybase。那么我应该写成

mongodb://test:123@192.168.2.2:27017/mybase?authSource=admin



tips:
据说曾经有人设密码的时候密码里有"@"字符，这你就要想想你为什么要作死了[doge]





**四、上传代码**

这个时候云服务器的环境其实已经装好了，可以暂时告别一下putty了

1. 双击打开Xftp

![img](https://pic1.zhimg.com/80/v2-fa313c7e4fc207cbea8f1da7c1d37e70_720w.jpg)



2. 点击新建

![img](https://pic2.zhimg.com/80/v2-fcb2d92294a48089a2474c326a37b93d_720w.jpg)



3. 出现一下窗口，名称自己取一个项目名称。主机，填写阿里云服务器的公网IP，协议选择SFTP，端口使用22，用户名root，密码为购买阿里云的时候要你记住的密码。最后点击确定。

![img](https://pic2.zhimg.com/80/v2-a68104e802a263e95d3225e62da00931_720w.jpg)



4. 你将进入你所创建的阿里云内的root文件夹，双击

![img](https://pic3.zhimg.com/80/v2-2d7ee243ef9aa21397c1ff63d7dd05a6_720w.jpg)

去到上一层，

![img](https://pic2.zhimg.com/80/v2-4904c2cdbe7fd753d53af335ab1face9_720w.jpg)



找到home文件夹，双击进入。

5. 左边框的文件夹就是你本机电脑中的文件夹，在当中找到你在本机建立的项目的所有文件，点击右键，传输。那么你就可以在下面的框中看到传输的过程。这时候耐心等待传输完毕。

**五、启动应用**

代码已经上传完了，这时候我们回到putty

\01. 进入存放代码的目录，存放在/home/app目录下,server.js为程序入口文件

```text
cd /home/app
sudo pm2 start server.js --name app
```

![img](https://pic1.zhimg.com/80/v2-1fcc6cd057f298df2fa9f174920d15d8_720w.jpg)

出现这个画面（或者类似的画面，因为pm2初次启动可能会显示一些更多的画面），恭喜你，部署成功了。



tips：以上home文件夹下的app文件夹为你项目所在的文件夹，server.js为你程序的入口文件，可以根据你的实际情况改变为你实际所写的名称。--name后面跟的是你为你的应用程序取的名字。方便以后你查看你的应用运行情况的时候比较清晰。



tips2：以上其实已经结束了。不过如果你的服务器是多核的，你想通过将node应用集群化的方式来完成利用好自己服务器的多核（由于node是单线程的，直接启动只能利用到一个核，当你的服务器是多核的，只用一个核就有些浪费了，而集群化利用好多核有助于分担应用压力），而pm2就是一个非常方便用来将node 应用集群化的模块。

```text
cd /home/app
sudo pm2 start server.js --name app -i 4
```

后面加上 -i表示将该应用集群化布置为4份，因为我的电脑是4个核的。想要知道你的电脑是几核的。可以这样得出

```text
node
>os.cpus().length
```

得出来的数字是几就是几核。（如果你只是想要帮助自己理解一下部署，而部署并不是你发展的方向，可以跳过tips2）



tips：检视运行中的应用:

```text
sudo pm2 list
```

如果需要关闭应用，命令如下：

```text
sudo pm2 stop app
```

如果需要删除应用，命令如下：

```text
sudo pm2 delete app
```

如果需要查看应用日志，命令如下：

```text
sudo pm2 log app 
```

**六、大功告成**

这时打开你的浏览器，输入你所购买的阿里云的公网IP 加上 你入口程序server.js中所listen的端口号（比如我阿里云的公网ip为1.1.1.1，listen的端口号为8000，那么我输入的网址就是[http://1.1.1.1:8000](https://link.zhihu.com/?target=http%3A//1.1.1.1%3A8000/)）打开看看是不是你的网站

happy endding