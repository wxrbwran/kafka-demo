package com.xiaoran.log;

import com.xiaoram.log.collector.LogCollectorApplication;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogCollectorApplication.class)
public class LogGenerator {

  public static final String[] VISIT = new String[]{"浏览页面", "评论商品", "加入收藏", "加入购物车", "提交订单", "使用优惠券", "领取优惠券", "搜索", "查看订单"};

  @Test
  public void generate() throws InterruptedException {
    while(true){
      Long sleep = RandomUtils.nextLong(200, 1000 * 5);
      Thread.sleep(sleep);
      Long maxUserId = 9999L;
      Long userId = RandomUtils.nextLong(1, maxUserId);
      String visit = VISIT[RandomUtils.nextInt(0, VISIT.length)];
      DateTime now = new DateTime();
      int maxHour = now.getHourOfDay();
      int maxMillis = now.getMinuteOfHour();
      int maxSeconds = now.getSecondOfMinute();
      String date = now.plusHours(-(RandomUtils.nextInt(0, maxHour)))
          .plusMinutes(-(RandomUtils.nextInt(0, maxMillis)))
          .plusSeconds(-(RandomUtils.nextInt(0, maxSeconds)))
          .toString("yyyy-MM-dd HH:mm:ss");

      String result = "DAU|" + userId + "|" + visit + "|" + date;
      log.info(result);
    }
  }
}
