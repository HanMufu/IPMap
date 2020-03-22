package io.github.hanmufu.IPMap.controller;

import io.github.hanmufu.IPMap.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String retrieveLocationHistory(@RequestParam Map<String, Object> params) {
        String ipAddress = params.get("ip_address").toString();
        int lastN;
        if(params.get("last_n").toString().length() == 0) {
            lastN = -1;
        }else {
            lastN = Integer.parseInt(params.get("last_n").toString());
        }
        long startDate;
        try{
            startDate = Long.parseLong(params.get("start_date").toString());
        }catch (NullPointerException e){
            startDate = 0L;
        }
        long endDate;
        try{
            endDate = Long.parseLong(params.get("end_date").toString());
        }catch (NullPointerException e){
            endDate = 4102466461000L;
        }
        return locationService.retrieveLocationHistory(ipAddress, startDate, endDate, lastN);
    }
}
