package com.miu.dao;
import com.miu.LibraryMember;
import com.miu.User;
import com.miu.dataStorage.DataStorage;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

public final class LibraryMemberDao<T extends Serializable> {

    private static Map<String, LibraryMember> members = new HashMap<>();
    public LibraryMemberDao() {
        Map<Object, Object> loadedData = DataStorage.read();
        if (loadedData != null) {
            for (Map.Entry<Object, Object> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof LibraryMember) {
                    members.put((String) entry.getKey().toString(), (LibraryMember) entry.getValue());
                }
            }
        }
    }

    public static LibraryMember findMemberById(int memberId) {
        LibraryMember member = members.get(memberId);
        return member;
    }

    public static boolean addMember(LibraryMember libraryMember) {
            boolean flag;
            Map<Object, Object> data = new HashMap<>();
            data.put(libraryMember.getMemberId(), libraryMember);
            for(Map.Entry<Object, Object> entry : data.entrySet()) {
            if (entry.getValue() instanceof LibraryMember) {
                LibraryMember member = (LibraryMember) entry.getValue();
            }
          }
           flag= DataStorage.write(data);
            if (flag) {
                System.out.println("data write successfully");
            }
         return flag;
    }

 }

