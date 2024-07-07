package com.miu.checkout;

import com.miu.Address;
import com.miu.person.LibraryMember;
import com.miu.person.Member;
import java.util.Date;

public class CheckoutFactory {
    public static CheckoutRecordEntry addNewCheckoutRecordEntry(int memberId, String isbn, String bookCopyId, Date checkoutDate, Date dueDate, Date paidDate) {
        return new CheckoutRecordEntry ( memberId,  isbn,  bookCopyId,  checkoutDate,  dueDate,  paidDate);
    }

}

