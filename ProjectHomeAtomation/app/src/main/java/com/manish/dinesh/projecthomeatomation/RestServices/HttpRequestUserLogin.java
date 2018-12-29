package com.manish.dinesh.projecthomeatomation.RestServices;

import android.os.AsyncTask;

//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.client.RestTemplate;

/**
 * Created by R Dinesh Kumar on 18-10-17.
 */

public class HttpRequestUserLogin extends AsyncTask<Void, Void, String > {

    public String res="0";
    public Boolean request_status = false;
    public String mail;
    public String pwd;
    public int aid;

    @Override
    protected String doInBackground(Void... voids) {
        try{
            final String url = "http://homeautomation-env.48fi6jjnfj.ap-south-1.elasticbeanstalk.com/User/login/"+mail+"/"+pwd;
            /*RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            String aids = restTemplate.getForObject(url, String.class);*/
            //aid = Integer.parseInt(aids);
            request_status = true;
        } catch (Exception e) {}
        return null;
    }
}