package com.projects.birthweather.utils;

import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Component
public class ConvertData implements IConvertData {
    private final ObjectMapper mapper;

    public ConvertData(ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public <T> T getData(String json, Class<T> myClass){
        try{
            return mapper.readValue(json, myClass);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}
