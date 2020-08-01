#镜像出处
FROM java:8
#维护者信息
MAINTAINER xizho
#镜像操作指令
#在容器的根目录中创建spring-cloud文件夹
RUN mkdir -p /data/docker
#将本地项目jar包拷贝到Docker容器中的位置
COPY ../../target/web-demo-0.0.1-SNAPSHOT.jar /data/docker/.
#将本地的可执行文件拷贝到Docker容器中的根目录下
COPY ../script/run.sh /
#给app-entrypoint.sh赋予可执行权限
RUN chmod +x /run.sh
#对外暴漏的端口号
EXPOSE 8080
#开机启动
ENTRYPOINT ["/run.sh"]
