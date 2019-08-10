package com.team.service;

import com.team.bean.Manufacture;
import com.team.bean.ResponseOV;

import java.util.List;

public interface IManufactureService {
    ResponseOV<Manufacture> getManufacture(int page, int rows);

    List<Manufacture> selectByExample();

    boolean updateManufacture(Manufacture manufacture);

    boolean deleteManufacturesByIds(String[] ids);

    boolean insertManufacture(Manufacture manufacture);

    ResponseOV<Manufacture> searchManufactureByCondition(int flag, String searchValue, int page, int rows);
}
