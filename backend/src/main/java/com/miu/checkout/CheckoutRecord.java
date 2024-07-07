package com.miu.checkout;

import java.util.List;

public class CheckoutRecord {
    private List<CheckoutRecordEntry> checkoutRecordEntryList;

    public CheckoutRecord() {
    }

    public CheckoutRecord(List<CheckoutRecordEntry> checkoutRecordEntryList) {
        this.checkoutRecordEntryList = checkoutRecordEntryList;
    }
}