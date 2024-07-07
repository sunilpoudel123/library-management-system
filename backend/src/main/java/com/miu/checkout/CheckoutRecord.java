package com.miu.checkout;

import com.miu.dao.CheckoutRecordEntryDao;

import java.util.List;
import java.util.ArrayList;

public class CheckoutRecord {
 private List<CheckoutRecordEntry> checkoutRecordEntryList;

 public CheckoutRecord() {}
   /* public CheckoutRecord(List<CheckoutRecordEntry> checkoutRecordEntryList) {
     this.checkoutRecordEntryList = checkoutRecordEntryList;
    }*/

    public static  List<CheckoutRecordEntry> checkoutRecordEntryList() {
        return  CheckoutRecordEntryDao.getCheckoutRecord();
    }
}