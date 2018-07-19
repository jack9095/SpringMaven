package com.stuspring.one;

import java.util.Properties;

/**
 * 模拟数据库连接
 */
public class DataSource {

    // 主要用于读取Java的配置文件
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
