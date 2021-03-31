package com.example.demo.service;

import java.util.List;

public class PublicData {
    public String help;
    public boolean success;
    public Result result;
}

class Result{
    public String resource_id;
    public List<Object> fields;
    public List<Record> records;
    public Object _links;
    public int total;
}

class Record{
    public String _id;
    public String name;
    public String fax_office;
    public String postal_code;
    public String address;
    public String type;
    public String tel_office_1;
    public String tel_office_2;
}