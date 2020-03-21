package io.github.hanmufu.IPMap.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import io.github.hanmufu.IPMap.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import io.github.hanmufu.IPMap.DAO.IPLocationDao;
import java.util.Date;
import io.github.hanmufu.IPMap.bean.Record;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private IPLocationDao ipLocationDao;

    @Override
    public String retrieveLocationHistory(String IPAddress, long startDate, long endDate, int lastN) {
        JSONObject responseData = new JSONObject();
        Date inputStartDate = new Date(startDate);
        Date inputEndDate = new Date(endDate);
        System.out.println(IPAddress + ", " + inputStartDate + ", " + inputEndDate + ", " + lastN);
        List<Record> res = ipLocationDao.findIPAddress(IPAddress, inputStartDate, inputEndDate, lastN);
        int counter = 0;
        for(Record r : res) {
            responseData.put("" + counter++, recordToJson(r));
        }
        return responseData.toJSONString();
    }

    public JSONObject recordToJson(Record record) {
        JSONObject jsonData = new JSONObject();
        jsonData.put("IPAddress", record.getIPAddress());
        jsonData.put("lon", record.getLon() + "");
        jsonData.put("lat", record.getLat() + "");
        jsonData.put("date", record.getDate().toString());
        return jsonData;
    }
}
