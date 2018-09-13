package com.feri.mapper;

import com.feri.domain.City;

import java.util.List;

public interface CityMapper {

    List<City> queryByPid(int pid);
}