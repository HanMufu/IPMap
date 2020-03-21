package io.github.hanmufu.IPMap.controller;

import io.github.hanmufu.IPMap.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String retrieveLocationHistory(@RequestBody Map<String, Object> params) {
        String ipAddress = params.get("ip_address").toString();
        int lastN = Integer.parseInt(params.get("last_n").toString());
        Long startDate = Long.parseLong(params.get("start_date").toString());
        Long endDate = Long.parseLong(params.get("end_date").toString());
        return locationService.retrieveLocationHistory(ipAddress, startDate, endDate, lastN);
    }
}
