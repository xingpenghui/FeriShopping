package com.feri.mapper;

import com.feri.domain.County;

import java.util.List;

public interface CountyMapper {
  List<County> queryByCityId(int cid);
}