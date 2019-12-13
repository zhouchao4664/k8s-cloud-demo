FROM openjdk:8
#更改docker中的变量参数
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8
ENV TZ=Asia/Shanghai
#把本地maven编译的代码jar包复制到docker中
COPY  user.jar .
#开放的端口要与代码中的开放的端口保持一致
EXPOSE 8080
#通过参数启动jar包
ENTRYPOINT ["java", "-jar","user.jar"]
