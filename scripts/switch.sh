#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/app"

DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

CURRENT_PORT=$(cat /home/ubuntu/service_url.inc | grep -Po '[0-9]+' | tail -1)
TARGET_PORT=0

if [ $CURRENT_PORT -eq 8081 ]; then
  TARGET_PORT=8082
elif [ $CURRENT_PORT -eq 8082 ]; then
  TARGET_PORT=8081
else
  echo "> No WAS is connected to nginx"
  exit 1
fi

# 프록시 포트번호 변경
echo "set \$service_url http://127.0.0.1:${TARGET_PORT};" | tee /home/ubuntu/service_url.inc
echo "> Now Nginx proxies to ${TARGET_PORT}." >> $DEPLOY_LOG

# nginx reload
sudo service nginx -s reload
