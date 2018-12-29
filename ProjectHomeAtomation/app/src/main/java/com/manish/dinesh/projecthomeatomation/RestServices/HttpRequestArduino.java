package com.manish.dinesh.projecthomeatomation.RestServices;

import android.os.AsyncTask;

import com.manish.dinesh.projecthomeatomation.Models.Arduino;

//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.client.RestTemplate;

/**
 * Created by R Dinesh Kumar on 18-10-17.
 */

public class HttpRequestArduino extends AsyncTask<Void, Void, String > {

    public Boolean request_status = false;
    public Arduino arduino;
    public int aid;


    @Override
    protected String doInBackground(Void... voids) {
        try{
            final String url = "http://homeautomation-env.48fi6jjnfj.ap-south-1.elasticbeanstalk.com/Arduino/getArduinoById/"+aid;
            /*RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            arduino = restTemplate.getForObject(url, Arduino.class);*/
            request_status = true;
        } catch (Exception e) {}
        return null;
    }
}
