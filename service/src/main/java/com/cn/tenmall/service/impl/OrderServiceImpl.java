package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.OrderDao;
import com.cn.tenmall.dao.OrderItemDao;
import com.cn.tenmall.entity.WxTabOrderEntity;
import com.cn.tenmall.entity.WxTabOrderItemEntity;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.OrderService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.TenmallResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author luoyuequan
 * @time 2019/11/22 16:56
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final OrderItemDao orderItemDao;
    private WxTabOrderEntity wxTabOrderEntity = new WxTabOrderEntity();
    private WxTabOrderItemEntity wxTabOrderItemEntity = new WxTabOrderItemEntity();

    public OrderServiceImpl(OrderDao orderDao, OrderItemDao orderItemDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
    }

    /**
     * 订单列表及明细
     *
     * @param data 请求参数map
     * @return 订单信息列表
     */
    @Override
    public TenmallResult listInfo(Map data) {
        Integer limit = (Integer) data.get("size");
        Integer offset = ((Integer) data.get("page") - 1) * limit;
        List<WxTabOrderEntity> orderEntityList = orderDao.findAllOfPageModel(offset, limit);
        for (WxTabOrderEntity orderEntity : orderEntityList) {
            wxTabOrderItemEntity.setOrderId(orderEntity.getId());
            orderEntity.setWxTabOrderItemEntityList(orderItemDao.findByOrderId(wxTabOrderItemEntity));
        }
        return TenmallResult.ok(orderEntityList);
    }

    /**
     * 批量发货查询
     *
     * @param idArray 订单id组
     * @return 订单列表
     */
    @Override
    public TenmallResult batchList(String[] idArray) {
        List<WxTabOrderEntity> orderEntityList = orderDao.findByIdIn(idArray);
        for (WxTabOrderEntity orderEntity : orderEntityList) {
            wxTabOrderItemEntity.setOrderId(orderEntity.getId());
            orderEntity.setWxTabOrderItemEntityList(orderItemDao.findByOrderId(wxTabOrderItemEntity));
        }
        return TenmallResult.ok(orderEntityList);
    }

    /**
     * 批量发货提交
     *
     * @param data 请求参数map
     * @return 批量发货提交后信息
     */
    @Override
    public TenmallResult batchSendSubmit(Map data) {
        wxTabOrderEntity.setId((Integer) data.get("id"));
        wxTabOrderEntity.setShippingCode((String) data.get("shippingCode"));
        wxTabOrderEntity.setShippingName((String) data.get("shippingName"));
        int updateResult = orderDao.updateById(wxTabOrderEntity);
        // TODO: 2019/12/8 订单的操作日志需要添加日志信息记录到表wx_tab_order_log中
        if (updateResult <= 0) {
            throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
        } else {
            return TenmallResult.ok("发货成功");
        }
    }
}
