# 该项目使用 docker 发布
 base java8

[//]: # 打包为images 通过docker插件<plugins> 和 dockerFile()
 mvn package docker:build
# 运行 mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=spc652324 --privileged=true -v /opt/mysql/log:/var/log/mysql -v /opt/mysql/conf:/etc/mysql/conf.d -v /opt/mysql/data:/var/lib/mysql --name=mysql mysql:5.7
# 运行 镜像
docker run -d --name project -p 7000:8080 030
# docker日志
docker logs -f --tail=100 [容器id]

# docker 启动
docker run --name project -p 7000:8080 030
docker start project 


# 接口列表
 - 签到 **PUT**
   - 8.130.79.79:7000/check
     - 参数列表
     - username:xxx //当前登录的用户名
       worksite:1  // 工地代号 1-4
       time:1    // 时间戳
       year:2023 // 当前年份
       mouth:3  // 当前月份
       day:16   // 当前日期
     - 返回值
       - {
         "reason": "已经签到",
         "message": false
         }
       - {
         "reason": "签到成功",
         "message": true
         }
       - {
         "reason": "时间错误",
         "message": false
         }
 - 登录 **POST**
   - 8.130.79.79:7000/login
     - 参数列表
     - username:xxxds //用户名
       password:123456 //密码
     - 返回值 
       - {
         "message": true
         }
       - {
         "message": false
         }  
 - 注册 **POST**
   - 8.130.79.79:7000/submit
     - 参数列表
     - username:xxxds //用户名
       password:123456 //密码
     - 返回值
        - {
          "message": true
          }
        - {
          "message": false // 错误大概率原因 为 名称已存在
          }
 - 获取X年X月X天的具体签到信息 **GET**
   - 8.130.79.79:7000/getCheckList
     - 参数列表
     - day:15  // 要查询的日期
       mouth:3 // 要查询的月份 
       year:2023  // 要查询的年份
     - 返回值 [result:[结果数组],message:T/F]
       - {
         "result": [
         {
         "id": 13,
         "user": {
         "id": 0,
         "username": "misaka",
         "password": null,
         "root": 0
         },
         "userDate": {
         "day": "15",
         "mouth": "3",
         "year": "2023",
         "currentTime": "1"
         },
         "worksite": "1"
         },
         {
         "id": 14,
         "user": {
         "id": 0,
         "username": "m",
         "password": null,
         "root": 0
         },
         "userDate": {
         "day": "15",
         "mouth": "3",
         "year": "2023",
         "currentTime": "1"
         },
         "worksite": "1"
         },
         {
         "id": 15,
         "user": {
         "id": 0,
         "username": "xxx",
         "password": null,
         "root": 0
         },
         "userDate": {
         "day": "15",
         "mouth": "3",
         "year": "2023",
         "currentTime": "1"
         },
         "worksite": "1"
         }
         ],
         "message": true
         }
