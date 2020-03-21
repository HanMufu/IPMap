package io.github.hanmufu.IPMap.DAOImpl;
import io.github.hanmufu.IPMap.DAO.BaseDao;
import com.mongodb.MongoClient;

public class BaseDaoImpl implements BaseDao{

    public MongoClient getConnection() {
        MongoClient mongoClient = new MongoClient("ec2-18-191-42-72.us-east-2.compute.amazonaws.com");
        return mongoClient;
    }

    public void close(MongoClient mongoClient) {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
