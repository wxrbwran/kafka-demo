zkServer.sh start
kafka-server-start.sh -daemon /Users/wuxiaoran/env/bin/kafka_2.13-2.8.0/config/server.properties
filebeat -e -c log-collector.yml
logstash -f ./script/log-collector.conf