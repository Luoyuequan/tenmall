package com.cn.tenmall.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/12/6 17:05
 */
public interface PublicDao<T> {
    /**
     * 对于具有唯一值索引的列,作为查询条件时
     * 采用动态查询方式
     *
     * @param tableName 表名
     * @param column    列名
     * @param value     参数值
     * @return 实体信息
     */
    T findByColumnForOnlyValue(
            @Param(value = "tableName") String tableName,
            @Param(value = "column") String column,
            @Param(value = "value") Object value
    );

    /**
     * 查询所有
     * 无条件模式
     * 分页模式
     *
     * @param tableName 表名
     * @param offset    偏移量
     * @param limit     限制量
     * @return 实体信息集
     */
    List<T> findAllOfPageModel(
            @Param(value = "tableName") String tableName,
            @Param(value = "offset") Object offset,
            @Param(value = "limit") Object limit
    );

    /**
     * 查询所有实体
     * 无条件模式
     * 无分页模式
     *
     * @param tableName 表名
     * @return 实体信息集
     */
    default List<T> findAll(String tableName) {
        return findAllOfPageModel(tableName, null, null);
    }

    /**
     * 对于具有唯一值索引的列,作为修改条件时
     * 修改单列值
     * 采用动态修改方式
     *
     * @param tableName    表名
     * @param updateColumn 修改的列名
     * @param updateValue  修改的新值
     * @param whereColumn  条件列名
     * @param whereValue   条件值
     * @return 修改结果 影响行数
     */
    int updateSingleColumnByColumnForOnlyValue(
            @Param(value = "tableName") String tableName,
            @Param(value = "updateColumn") String updateColumn,
            @Param(value = "updateValue") Object updateValue,
            @Param(value = "whereColumn") String whereColumn,
            @Param(value = "whereValue") Object whereValue
    );

    /**
     * 物理删除(硬删除)
     * 对于具有唯一值索引的列,作为删除条件时
     * 采用动态删除方式
     *
     * @param tableName   表名
     * @param whereValue  条件值
     * @param whereColumn 条件列名
     * @return 物理删除结果 影响行数
     */
    int physicalDeleteByColumnForOnlyValue(
            @Param(value = "tableName") String tableName,
            @Param(value = "whereColumn") String whereColumn,
            @Param(value = "whereValue") Object whereValue
    );
}
