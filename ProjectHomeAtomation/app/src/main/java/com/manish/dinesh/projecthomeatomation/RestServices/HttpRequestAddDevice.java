package com.manish.dinesh.projecthomeatomation.RestServices;

import android.os.AsyncTask;

import com.manish.dinesh.projecthomeatomation.Models.Arduino;
import com.manish.dinesh.projecthomeatomation.Models.Device;

//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.client.RestTemplate;

/**
 * Created by R Dinesh Kumar on 23-10-17.
 */

public class HttpRequestAddDevice extends AsyncTask<Void, Void, String > {

    public Boolean request_status = false;
    public Device device;
    public  Arduino arduino;
    public int aid;

    @Override
    protected String doInBackground(Void... voids) {
        try{
            final String url = "http://homeautomation-env.48fi6jjnfj.ap-south-1.elasticbeanstalk.com/Arduino/"+aid+"/addDevice";
            /*RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            arduino = restTemplate.postForObject(url,device,Arduino.class);*/
            request_status = true;
        } catch (Exception e) {}
        return null;
    }
}