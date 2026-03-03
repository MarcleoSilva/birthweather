package com.projects.birthweather.utils;

public interface IConvertData {
    <T> T getData(String json, Class<T> myClass);
}
