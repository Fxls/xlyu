package com.itek.myoa.service;

import com.itek.myoa.domain.ZCApplication;

import java.util.List;

public interface ZCApplicationService {
    boolean insertThisZCApplication(ZCApplication zcApplication);

    List<ZCApplication> getHistoryByUserId(int userId);

    ZCApplication getDeatilZCApplicationById(int parseInt);

    List<ZCApplication> getZCApplicationShouldHandleByMe(Integer myRoleId);

    ZCApplication getDetailInfoById(int parseInt);

    int changeStatusTo1ById(Integer applicationId);

    int changeStatusTo2ById(Integer applicationId);

    int setNewRoleIdByApplicationIdForZc(int newRoleId, Integer applicationId);
}
