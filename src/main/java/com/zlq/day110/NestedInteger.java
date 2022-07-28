package com.zlq.day110;

import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: NestedInteger
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/15 20:38
 */
public class NestedInteger implements NestedIntegerInterface{
    private int value;

    public NestedInteger() {
    }

    public NestedInteger(int value) {
        this.value = value;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedIntegerInterface ni) {

    }

    @Override
    public List<NestedIntegerInterface> getList() {
        return null;
    }

    @Override
    public String toString() {
        return "NestedInteger{" +
                "value=" + value +
                '}';
    }
}
