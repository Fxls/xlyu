package com.iek.netctoss.commons;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public enum AccountStatus {

    START("0", "开通"),

    PAUSE("1", "暂停"),

    DELETE("2", "删除");

    String status;
    String msg;

    AccountStatus(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String toJSONStr() {
        AccountStatus[] vals = AccountStatus.values();
        JSONArray jsonArray = new JSONArray();
        for (AccountStatus val : vals) {
            String status = val.getStatus();
            String msg = val.getMsg();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", status);
            jsonObject.put("msg", msg);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}
