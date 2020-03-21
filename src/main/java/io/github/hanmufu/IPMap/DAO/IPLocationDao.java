package io.github.hanmufu.IPMap.DAO;
import io.github.hanmufu.IPMap.bean.Record;
import java.util.*;

public interface IPLocationDao extends BaseDao {

    List<Record> findIPAddress(String IPAddress, Date startDate, Date endDate, int lastN);

    List<Record> findAllRecords();

}
