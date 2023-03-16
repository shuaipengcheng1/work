# 该项目使用 docker 发布
 base java8
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=spc652324 --privileged=true -v /opt/mysql/log:/var/log/mysql -v /opt/mysql/conf:/etc/mysql/conf.d -v /opt/mysql/data:/var/lib/mysql --name=mysql mysql:5.7

docker run --name project -p 7000:8080 030
# docker日志
docker logs -f --tail=100 [容器id]

# docker 启动
docker run --name project -p 7000:8080 030
docker start project 


# 接口列表
 - 签到
   - 8.130.79.79:7000/check
 - 登录
   - 8.130.79.79:7000/login
 - 注册
   - 8.130.79.79:7000/submit
 - 获取X年X月X天的具体签到信息
   - 8.130.79.79:7000/getCheckList?day=1&mouth=1&year=1