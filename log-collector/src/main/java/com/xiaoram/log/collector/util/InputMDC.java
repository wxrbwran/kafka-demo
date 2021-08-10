package com.xiaoram.log.collector.util;

import java.net.UnknownHostException;
import org.slf4j.MDC;

/**
 * @author wuxiaoran
 */
public class InputMDC {

  public static void putMDC() throws UnknownHostException {

    MDC.put("hostname", NetUtil.getHostName());
    MDC.put("ip", NetUtil.getLocalIP());
    MDC.put("applicationName", "log-collector");
  }
}
