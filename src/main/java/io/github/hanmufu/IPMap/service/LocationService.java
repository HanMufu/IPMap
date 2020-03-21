package io.github.hanmufu.IPMap.service;

import io.github.hanmufu.IPMap.bean.Record;
import java.util.*;

public interface LocationService {

    String retrieveLocationHistory(String IPAddress, long startDate, long endDate, int lastN);

}
