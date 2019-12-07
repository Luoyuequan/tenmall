package com.cn.tenmall.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/12/6 17:05
 */
public interface PublicDao<T> {
    /**
     * 适用于 全部查询 分页查询 唯一索引查询 非唯一索引查询 集合in查询
     *
     * @param tableName    表名
     * @param equalsColumn 单值比较列名
     * @param equalsValue  比较值
     * @param offset       偏移量
     * @param limit        限制量
     * @param inColumn     多值比较列名
     * @param collection   集合值
     * @return 信息集
     */
    List<T> findAllOfCommon(
            @Param(value = "tableName") String tableName, @Param(value = "equalsColumn") String equalsColumn,
            @Param(value = "equalsValue") Object equalsValue, @Param(value = "offset") Object offset,
            @Param(value = "limit") Object limit, @Param(value = "inColumn") String inColumn,
            @Param(value = "collection") Object collection
    );

    /**
     * 具有唯一值索引的列作为查询条件时
     *
     * @param tableName    表名
     * @param equalsColumn 列名
     * @param equalsValue  参数值
     * @return 实体信息
     */
    default T findByColumnForOnlyValue(String tableName, String equalsColumn, Object equalsValue) {
        return findAllOfCommon(
                tableName, equalsColumn, equalsValue,
                null, null, null, null)
                .get(0);
    }

    /**
     * 非唯一值索引的列作为查询条件时 分页模式
     *
     * @param tableName    表名
     * @param equalsColumn 列名
     * @param equalsValue  参数值
     * @return 实体信息集合
     */
    default List<T> findByColumnOfPageModel(
            String tableName, String equalsColumn, Object equalsValue, Object offset, Object limit
    ) {
        return findAllOfCommon(tableName, equalsColumn, equalsValue, offset, limit, null, null);
    }

    /**
     * 非唯一值索引的列作为查询条件 无分页模式
     *
     * @param tableName    表名
     * @param equalsColumn 列名
     * @param equalsValue  参数值
     * @return 实体信息集合
     */
    default List<T> findByColumn(String tableName, String equalsColumn, Object equalsValue) {
        return findByColumnOfPageModel(tableName, equalsColumn, equalsValue, null, null);
    }

    /**
     * 查询所有 无条件模式 分页模式
     *
     * @param tableName 表名
     * @param offset    偏移量
     * @param limit     限制量
     * @return 实体信息集
     */
    default List<T> findAllOfPageModel(String tableName, Object offset, Object limit) {
        return findAllOfCommon(tableName, null, null, offset, limit, null, null);
    }

    /**
     * 查询所有 无条件模式 无分页模式
     *
     * @param tableName 表名
     * @return 实体信息集
     */
    default List<T> findAll(String tableName) {
        return findAllOfPageModel(tableName, null, null);
    }

    /**
     * 查询指定列的范围集合内 in查询
     *
     * @param tableName  表名
     * @param inColumn   列名
     * @param collection 数据集合
     * @return 实体信息集合
     */
    default List<T> findByColumnIn(String tableName, String inColumn, Object collection) {
        return findAllOfCommon(tableName, null, null, null, null,
                inColumn, collection);
    }

    /**
     * 具有唯一值索引的列作为修改条件时 修改单列值
     * 采用动态修改方式
     *
     * @param tableName    表名
     * @param updateColumn 修改的列名
     * @param updateValue  修改的新值
     * @param equalsColumn 条件列名
     * @param equalsValue  条件值
     * @return 修改结果 影响行数
     */
    int updateSingleColumnByColumnForOnlyValue(
            @Param(value = "tableName") String tableName, @Param(value = "updateColumn") String updateColumn,
            @Param(value = "updateValue") Object updateValue, @Param(value = "equalsColumn") String equalsColumn,
            @Param(value = "equalsValue") Object equalsValue
    );

    /**
     * 物理删除(硬删除) 对于具有唯一值索引的列,作为删除条件时
     * 采用动态删除方式
     *
     * @param tableName    表名
     * @param equalsColumn 条件列名
     * @param equalsValue  条件值
     * @return 物理删除结果 影响行数
     */
    int physicalDeleteByColumn(
            @Param(value = "tableName") String tableName, @Param(value = "equalsColumn") String equalsColumn,
            @Param(value = "equalsValue") Object equalsValue
    );
}
