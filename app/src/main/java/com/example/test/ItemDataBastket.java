package com.example.test;

import android.view.View;

public class ItemDataBastket {

    public String strMenu; // 가게의 메뉴 변수
    public int intCount; // 주문 수량
    public String strCount; // 주문수량(String)
    public int intCost; // 가격
    public String strCost; // 가격(String)
    public View.OnClickListener onClickListener1; // 삭제 버튼
    public View.OnClickListener onClickListener2; // 수량 버튼
    public View.OnClickListener onClickListener3;

    public int getIntCount() {
        return intCount;
    }

    public void setIntCount(int strCount) {
        this.intCount = strCount;
    }

    public void strToIntCount(int intCount){
        this.strCount = Integer.toString(intCount) + "개";
    }

    public int getIntCost() {
        return intCost;
    }

    public void setIntCost(int intCost) {
        this.intCost = intCost;
    }

    public void strToIntCost(int intCost){
        this.strCost = Integer.toString(intCost) + "원";
    }

}
