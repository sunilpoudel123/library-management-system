package com.miu.model;

import com.miu.model.CheckoutRecordEntry;

import java.util.Date;
import java.util.List;

public class CheckoutRecord {
 private List<CheckoutRecordEntry> checkoutRecordEntryList;

 public CheckoutRecord() {}
    public CheckoutRecord(List<CheckoutRecordEntry> checkoutRecordEntryList) {
     this.checkoutRecordEntryList = checkoutRecordEntryList;
    }
}