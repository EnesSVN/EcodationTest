package com.example.ecodationtest.exception;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Getter
@Setter
public class ApiResult {

    private int status;

    private String path;

    private String message;

    private String createdDate=nowDate();

    private Map<String,String> validationData;

    //Now Date
    private String nowDate() {
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss",locale);
        Date date=new Date();
        String change=simpleDateFormat.format(date);
        return change;
    }


    //Constructor
    public ApiResult(int status, String path, String message) {
        this.status = status;
        this.path = path;
        this.message = message;
    }

}
