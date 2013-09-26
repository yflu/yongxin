package com.eric.util.model;

import java.io.Serializable;

public class QueryParams implements Serializable {

    private static final long serialVersionUID = 2063610281411857498L;

    /**
     * 属性名称
     */
    private String field;

    /**
     * 对应值
     */
    private Object value;

    /**
     * 比较方式
     */
    private int eq;

    /**
     * 比较符 等于
     */
    public static final int EQ = 0;

    /**
     * 比较符 大于等于
     */
    public static final int GE = -1;

    /**
     * 比较符 小于等于
     */
    public static final int LE = 1;

    /**
     * 比较符 大于
     */
    public static final int GT = -2;

    /**
     * 比较符 小于
     */
    public static final int LT = 2;

    /**
     * 比较符 like
     */
    public static final int LIKE = 3;

    /**
     * 集合匹配 in
     */
    public static final int IN = 4;

    /**
     * null值 查询
     */
    public static final int NULL = 5;

    /**
     * 比较符 左like
     */
    public static final int LEFT_LIKE = 6;

    /**
     * 比较符 右like
     */
    public static final int RIGHT_LIKE = 7;

    public QueryParams(String field, Object value, int eq) {
        this.field = field;
        this.value = value;
        this.eq = eq;

        if (eq == LIKE)
            this.value = "%" + value + "%";

        if (eq == LEFT_LIKE)
            this.value = "%" + value;

        if (eq == RIGHT_LIKE)
            this.value = value + "%";
    }

    public QueryParams(String field, Object value) {
        this.field = field;
        this.value = value;
        this.eq = 0;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }

    public int getEq() {
        return eq;
    }
}
