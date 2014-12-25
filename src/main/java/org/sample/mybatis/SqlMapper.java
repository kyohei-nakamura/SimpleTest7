package org.sample.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SqlMapper {
    // メソッド名と同じid属性値を持つsql-mapping.xmlのSQL設定が利用される
    public List<TestTable> selectTestTables(@Param("id") int id, @Param("LIMIT_ID") String limitId, @Param("name") String name);

    public int insertTestTable(@Param("id") int id, @Param("name") String name, @Param("address") String address);

}
