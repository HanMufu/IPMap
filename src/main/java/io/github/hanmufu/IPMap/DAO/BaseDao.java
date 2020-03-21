package io.github.hanmufu.IPMap.DAO;

import com.mongodb.MongoClient;

public interface BaseDao {

    MongoClient getConnection();

    void close(MongoClient mongoClient);

}
