package com.itek.spring.day02; /**
 * @Author xlyu
 * @Date 2019/6/26
 * @Description
 */

import java.util.*;

/**
 * @program: springDay02
 * @description: 基本值注入
 * @author: xlyu
 * @create: 2019-06-26 09:05
 **/
public class Shop {
    /**
     * 字符串
     */
    private String name;

    /**
     * 基本数值
     */
    private byte bt;
    private short aShort;
    private int anInt;
    private long aLong;
    private char aChar;
    private boolean aBoolean;
    private double aDouble;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private ICBC icbc;
    private Properties props;

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public ICBC getIcbc() {
        return icbc;
    }

    public void setIcbc(ICBC icbc) {
        this.icbc = icbc;
    }


    public void print() {
        System.out.println(name);
        System.out.println(bt);
        System.out.println(aShort);
        System.out.println(anInt);
        System.out.println(aLong);
        System.out.println(aChar);
        System.out.println(aBoolean);
        System.out.println(aDouble);
        System.out.println(icbc);
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(props);
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getBt() {
        return bt;
    }

    public void setBt(byte bt) {
        this.bt = bt;
    }

    public short getaShort() {
        return aShort;
    }

    public void setaShort(short aShort) {
        this.aShort = aShort;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }
}
