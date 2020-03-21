package io.github.hanmufu.IPMap.DAOImpl;
import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.hanmufu.IPMap.DAO.IPLocationDao;
import io.github.hanmufu.IPMap.bean.Record;
import org.bson.Document;

import java.util.*;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import io.github.hanmufu.IPMap.bean.Record;
import org.springframework.stereotype.Service;

@Service
public class IPLocationDaoImpl extends BaseDaoImpl implements IPLocationDao {

    /*
    Return one IP address' location history
     */
    public List<Record> findIPAddress(String IPAddress, Date startDate, Date endDate, int lastN) {
        System.out.println("at IPLocationDaoImpl: " + IPAddress + ", " + startDate + ", " + endDate + ", " + lastN);
        List<Record> res = new ArrayList<>();
        MongoClient mongoClient = getConnection();
        MongoDatabase database = mongoClient.getDatabase("IPLocation");
        MongoCollection<Document> collection = database.getCollection("records");
        MongoCursor<Document> cursor;
        if(lastN == -1) {
            cursor = collection.find(and(eq("IPAddress", IPAddress), gte("date", startDate), lte("date", endDate))).iterator();
        }else {
            cursor = collection.find(and(eq("IPAddress", IPAddress), gte("date", startDate), lte("date", endDate))).limit(lastN).iterator();
        }
        System.out.println("get curosr!!!");
        try {
            while (cursor.hasNext()) {
                System.out.println("insert record into res");
                Document doc = cursor.next();
                Record record = new Record((String)doc.get("IPAddress"), Float.parseFloat((String)doc.get("lon")), Float.parseFloat((String)doc.get("lat")), (Date)doc.get("date"));
                res.add(record);
            }
        } finally {
            cursor.close();
        }
        close(mongoClient);
        return res;
    }

    /*
    Return all location history in mongoDB
     */
    public List<Record> findAllRecords() {
        List<Record> res = new ArrayList<>();
        MongoClient mongoClient = getConnection();
        MongoDatabase database = mongoClient.getDatabase("IPLocation");
        MongoCollection<Document> collection = database.getCollection("records");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Record record = new Record((String)doc.get("IPAddress"), Float.parseFloat((String)doc.get("lon")), Float.parseFloat((String)doc.get("lat")), (Date)doc.get("date"));
                res.add(record);
            }
        } finally {
            cursor.close();
        }
        close(mongoClient);
        return res;
    }

}
