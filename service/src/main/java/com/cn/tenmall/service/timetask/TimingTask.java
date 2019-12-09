package com.cn.tenmall.service.timetask;

import com.cn.tenmall.dao.CategoryReportDao;
import com.cn.tenmall.dao.OrderConfigDao;
import com.cn.tenmall.dao.OrderDao;
import com.cn.tenmall.dao.OrderItemDao;
import com.cn.tenmall.entity.WxTabCategoryReportEntity;
import com.cn.tenmall.entity.WxTabOrderConfigEntity;
import com.cn.tenmall.entity.WxTabOrderEntity;
import com.cn.tenmall.entity.WxTabOrderItemEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author luoyuequan
 * @time 2019/12/9 10:29
 */
@Service
public class TimingTask {
    private final OrderDao orderDao;
    private final OrderItemDao orderItemDao;
    private final OrderConfigDao orderConfigDao;
    private final CategoryReportDao categoryReportDao;

    public TimingTask(OrderDao orderDao, OrderItemDao orderItemDao, OrderConfigDao orderConfigDao, CategoryReportDao categoryReportDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
        this.orderConfigDao = orderConfigDao;
        this.categoryReportDao = categoryReportDao;
    }

    /**
     * 订单支付超时，自动关闭订单
     * 每隔10分钟执行一次
     */
//    每隔5秒执行一次："*/5 * * * * ?"
//    每隔1分钟执行一次："0 */1 * * * ?"
//    每天23点执行一次："0 0 23 * * ?"
    @Scheduled(cron = "0 */10 * * * ?")
    public void orderPayTimeoutAutoProcess() {
        List<WxTabOrderConfigEntity> configEntityList = orderConfigDao.findAll();
        List<WxTabOrderEntity> orderEntityList = null;
        if (configEntityList.size() > 0) {
//            读取订单主表中，支付已超过 订单设置表中的规定时间
            orderEntityList = orderDao.findByPayStatusEqualsAndCreateTimeBeforeHalfhour(configEntityList.get(0).getOrderTimeout());
        }
        if (orderEntityList != null) {
//            遍历订单主表信息
            for (WxTabOrderEntity orderEntity : orderEntityList) {
//                修改订单主表状态为关闭:4
                orderEntity.setOrderStatus(4);
//                设置订单关闭时间
                orderEntity.setCloseTime(Timestamp.valueOf(LocalDateTime.now()));
                orderDao.updateById(orderEntity);
//                查询订单详细表信息
                WxTabOrderItemEntity orderItemEntity = new WxTabOrderItemEntity();
                orderItemEntity.setOrderId(orderEntity.getId());
                List<WxTabOrderItemEntity> orderItemEntityList = orderItemDao.findByOrderId(orderItemEntity);
                for (WxTabOrderItemEntity wxTabOrderItemEntity : orderItemEntityList) {
                    Integer skuId = wxTabOrderItemEntity.getSkuId();
                    Integer num = wxTabOrderItemEntity.getNum();
                    // TODO: 2019/12/9 修改库存数量
                }
            }
        }
    }

    /**
     * 每天凌晨，统计昨天订单的销售金额和销售数量，并写入存储统计数据表
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void countPayMoneyAndNumForOrderItem() {
//        获取昨天订单主表集
        List<WxTabOrderEntity> orderEntityList = orderDao.findByCreateTimeBeforeYesterday();
//        根据订单主表id
        List<Map> countPayMoneyAndNumberList = orderItemDao.countPayMoneyAndNumberByOrderIdInGroupByCategoryId1(orderEntityList);
        for (Map countPayMoneyAndNumber : countPayMoneyAndNumberList) {
            WxTabCategoryReportEntity wxTabCategoryReportEntity = new WxTabCategoryReportEntity();
            wxTabCategoryReportEntity.setCategoryId1((Integer) countPayMoneyAndNumber.get("categoryId1"));
            wxTabCategoryReportEntity.setCategoryId2((Integer) countPayMoneyAndNumber.get("categoryId2"));
            wxTabCategoryReportEntity.setCategoryId3((Integer) countPayMoneyAndNumber.get("categoryId3"));
//            设置统计日期为昨天日期
            wxTabCategoryReportEntity.setCountDate(Timestamp.valueOf(LocalDateTime.now().minusDays(1)));
            wxTabCategoryReportEntity.setMoney((Double) countPayMoneyAndNumber.get("money"));
            wxTabCategoryReportEntity.setNum((Integer) countPayMoneyAndNumber.get("num"));
            categoryReportDao.insert(wxTabCategoryReportEntity);
        }
    }
}
