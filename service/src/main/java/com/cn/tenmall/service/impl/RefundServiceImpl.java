package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.ReturnCauseDao;
import com.cn.tenmall.dao.ReturnOrderDao;
import com.cn.tenmall.entity.WxTabReturnCauseEntity;
import com.cn.tenmall.entity.WxTabReturnOrderEntity;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.RefundService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 退款或退货 业务
 *
 * @author luoyuequan
 * @time 2019/11/22 16:56
 */
@Service
public class RefundServiceImpl implements RefundService {
    private final ReturnOrderDao returnOrderDao;
    private final ReturnCauseDao returnCauseDao;
    private WxTabReturnOrderEntity wxTabReturnOrderEntity = new WxTabReturnOrderEntity();
    private WxTabReturnCauseEntity wxTabReturnCauseEntity = new WxTabReturnCauseEntity();

    public RefundServiceImpl(ReturnOrderDao returnOrderDao, ReturnCauseDao returnCauseDao) {
        this.returnOrderDao = returnOrderDao;
        this.returnCauseDao = returnCauseDao;
    }

    /**
     * 查询 退货退款申请表 分页
     *
     * @param data 分页参数(page,size)
     * @return 退货退款申请表
     */
    @Override
    public TenmallResult findAll(Map data) {
        Integer limit = (Integer) data.get("size");
        Integer offset = ((Integer) data.get("page") - 1) * limit;
        List<WxTabReturnOrderEntity> returnOrderEntityList = returnOrderDao.findAllOfPageModel(offset, limit);
        Map<String, Object> result = new HashMap<>(16);
        result.put("rows", returnOrderEntityList);
        if (returnOrderEntityList == null) {
            result.put("total", 0);
        } else {
            result.put("total", returnOrderEntityList.size());
        }
        return TenmallResult.ok(result);
    }

    /**
     * 退款 退货 审批业务
     *
     * @param data 退款退货申请id,审批类型status
     * @return 操作结果信息
     */
    @Override
    public TenmallResult approval(Map data) {
        Integer id = (Integer) data.get("id");
        Integer status = (Integer) data.get("status");
        wxTabReturnOrderEntity.setId(id);
        wxTabReturnOrderEntity.setStatus(status);
        int updateStatusResult = returnOrderDao.updateStatusById(wxTabReturnOrderEntity);
        if (updateStatusResult <= 0) {
            throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
        } else {
            return TenmallResult.success(MessageEnum.ACTION_SUCCESS);
        }
    }

    /**
     * 退货退款原因 信息
     *
     * @param id 原因表id
     * @return 原因信息
     */
    @Override
    public TenmallResult findCause(Integer id) {
        wxTabReturnCauseEntity.setId(id);
        try {
            wxTabReturnCauseEntity = returnCauseDao.findById(wxTabReturnCauseEntity);
            return TenmallResult.success(MessageEnum.ACTION_SUCCESS, wxTabReturnCauseEntity);
        } catch (Exception e) {
            throw new ServiceException(MessageEnum.FIND_ERROR.getMessage());
        }
    }
}
