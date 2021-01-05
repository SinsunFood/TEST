package com.example.test;

import android.view.View;

public class ItemDataBastket {

    public String strMenu; // 가게의 메뉴 변수
    public String strCount; // 주문 수량
    public String strCost; // 가격
    public View.OnClickListener onClickListener;

    public String getStrMenu() {
        return strMenu;
    }

    public void setStrMenu(String strMenu) {
        this.strMenu = strMenu;
    }

    public String getStrCount() {
        return strCount;
    }

    public void setStrCount(String strCount) {
        this.strCount = strCount;
    }

    public String getStrCost() {
        return strCost;
    }

    public void setStrCost(String strCost) {
        this.strCost = strCost;
    }

}
