#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/app"
JAR_FILE="$PROJECT_ROOT/spring-webapp.jar"

DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# CURRENT_PORT : 현재 구동중인 애플리케이션의 포트
CURRENT_PORT=$(cat /home/ubuntu/service_url.inc | grep -Po '[0-9]+' | tail -1)
# TARGET_PORT : 변경할 포트
TARGET_PORT=0

# 포트번호 변경
if [ $CURRENT_PORT -eq 8081 ]; then
  TARGET_PORT=8082
elif [ $CURRENT_PORT -eq 8082 ]; then
  TARGET_PORT=8081
else
  echo "> No WAS is connected to nginx"
fi

# TARGET_PORT 구동중인 애플리케이션 pid
CURRENT_PID=$(lsof -Fp -i TCP:${TARGET_PORT} | grep -Po 'p[0-9]+' | grep -Po '[0-9]+')

# TARGET_PORT 구동중이면 kill
if [ ! -z $CURRENT_PID ]; then
  echo "$TIME_NOW > 실행중인 $CURRENT_PID 애플리케이션 종료 " >> $DEPLOY_LOG
  kill -15 $CURRENT_PID
fi

