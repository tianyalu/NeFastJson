package com.sty.ne.fastjson.library.serializer;

/**
 * 对象序列化接口
 * @Author: tian
 * @UpdateDate: 2020/11/3 10:27 PM
 */
public interface ObjectSerializer {
    /**
     * 序列化对象
     *
     * @param config 序列化 / 反序列化配置
     * @param object 序列化对象
     * @param out    字符串拼接
     */
    void write(SerializeConfig config, Object object, StringBuilder out);
}
