/**
 * @Author xlyu
 * @Date 2019/6/25
 * @Description
 */
package com.itek.spring.day01.module;

/**
 * @program: springDay01
 * @description:
 * @author: xlyu
 * @create: 2019-06-25 09:05
 **/
public class Computer {
    private String name;
    private double price;
    private String cpu;

    public Computer() {
    }

    public Computer(String name, double price, String cpu) {
        this.name = name;
        this.price = price;
        this.cpu = cpu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void print() {
        System.out.println("执行打印方法！");
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}
