#!/usr/bin/env bash

# CURRENT_PORT : 현재 구동중인 애플리케이션의 포트
CURRENT_PORT=$(cat /home/ubuntu/service_url.inc | grep -Po '[0-9]+' | tail -1)
# TARGET_PORT : 변경할 포트
TARGET_PORT=0

if [ $CURRENT_PORT -eq 8081 ]; then
  TARGET_PORT=8082
elif [ $CURRENT_PORT -eq 8082 ]; then
  TARGET_PORT=8081
else
  echo "> No WAS is connected to nginx"
  exit 1
fi

# 새로 띄운 서버 헬스체크
echo "> Health check of WAS at 'http://127.0.0.1:${TARGET_PORT}' ..."

for RETRY_COUNT in $(seq 10);
do
    echo "> #${RETRY_COUNT} trying..."
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}"  http://127.0.0.1:${TARGET_PORT}/api/games)
    echo ${RESPONSE_CODE}
    if [ ${RESPONSE_CODE} -eq 200 ]; then
        echo "> New WAS successfully running"
        exit 0
    elif [ ${RETRY_COUNT} -eq 10 ]; then
        echo "> Health check failed."
        exit 1
    fi
    sleep 10
done