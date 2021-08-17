package com.xiaoram.log.collector.controller;

import com.xiaoram.log.collector.util.InputMDC;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaoran
 */
@Slf4j
@RestController
public class IndexController {

  /*
  * [%d{yyyy-MM-dd'T'HH:mm:ss.SSSZZ}]
  * [%level{length=5}]
  * [%thread-%tid]
  * [%logger]
  * [%X{hostname}]
  * [%X{ip}]
  * [%X{applicationName}]
  * [%F, %L, %C, %M]
  * [%m] ## '%ex'%n"
  *
  * [2021-08-10T16:37:04.258+08:00]
  * [DEBUG]
  * [main-1]
  * [org.springframework.core.env.PropertySourcesPropertyResolver]
  * []
  * []
  * []
  * [PropertySourcesPropertyResolver.java, 115, org.springframework.core.env.PropertySourcesPropertyResolver, logKeyFound]
  * [Found key 'spring.liveBeansView.mbeanDomain' in PropertySource 'systemProperties' with value of type String] ## ''
  *
  * */

  /*
  *
  * ["message", "\[%{NOTSPACE:currentDateTime}\] \[%{NOTSPACE:level}\] \[%{NOTSPACE:thread-id}\] \[%{NOTSPACE:class}\] \[%{DATA:hostName}\] \[%{DATA:ip}\] \[%{DATA:applicationName}\] \[%{DATA:location}\] \[%{DATA:messageInfo}\] ## (\'\'|%{QUOTEDSTRING:throwable})"]
  * ["message",
  *  "\[%{NOTSPACE:currentDateTime}\]
  *   \[%{NOTSPACE:level}\]
  *   \[%{NOTSPACE:thread-id}\]
  *   \[%{NOTSPACE:class}\]
  *   \[%{DATA:hostName}\]
  *   \[%{DATA:ip}\]
  *   \[%{DATA:applicationName}\]
  *   \[%{DATA:location}\]
  *   \[%{DATA:messageInfo}\]
  *   ## (\'\'|%{QUOTEDSTRING:throwable})"]
  *
  * */

  @GetMapping("index")
  public String index() throws UnknownHostException {
    InputMDC.putMDC();


    log.info("我是一条info日志");

    log.warn("我是一条warn日志");
    log.error("我是一条error日志");

    return "idx";
  }

  @GetMapping("err")
  public String error() throws UnknownHostException {
    InputMDC.putMDC();
    try {
      int a = 1/0;
    } catch (Exception e) {
      log.error("算术异常：", e);
    }
    return "error";
  }
}
