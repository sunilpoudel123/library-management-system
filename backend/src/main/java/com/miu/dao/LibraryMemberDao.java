package com.miu.dao;

import com.miu.LibraryMember;
import com.miu.User;
import com.miu.dataStorage.DataStorage;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class LibraryMemberDao<T extends Serializable> {
    private static Map<String, LibraryMember> members = new HashMap<>();

    public LibraryMemberDao() {
        Map<Object, Object> loadedData = DataStorage.read();
        if (loadedData != null) {
            for (Map.Entry<Object, Object> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof LibraryMember) {
                    members.put(entry.getKey().toString(), (LibraryMember) entry.getValue());
                }
            }
        }
    }

    public static LibraryMember findMember(int memberId) {
        Map<Object, Object> loadedData = DataStorage.read();
        if (loadedData != null) {
            for (Map.Entry<Object, Object> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof LibraryMember) {
                    LibraryMember member = (LibraryMember) entry.getValue();
                         // System.out.println("***"+member.getMemberId()  + " " + memberId+"Before Test find data" );
                     if (member.getMemberId() == memberId) {
                         // System.out.println("*******"+member.getMemberId() +" After Test find data");
                        return member;
                    }
                }
            }
        }
        return null;
    }

    public static LibraryMember addMember(LibraryMember libraryMember) {
        Map<Object, Object> data = new HashMap<>();
        data.put(libraryMember.getMemberId(), libraryMember);
        DataStorage.write(data);
        System.out.println("data write successfully");
        for (Map.Entry<String, LibraryMember> entry : members.entrySet()) {
            if (entry.getValue().getMemberId() == libraryMember.getMemberId()) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static LibraryMember editMember(LibraryMember libraryMember) {
        boolean updated = false;
        System.out.println("Updating member with ID: " + libraryMember.getMemberId());
        Map<Object, Object> loadedData = DataStorage.read();
        if (loadedData != null) {
            for (Map.Entry<Object, Object> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof LibraryMember) {
                    LibraryMember member = (LibraryMember) entry.getValue();
                    if (member.getMemberId() == libraryMember.getMemberId()) {
                        entry.setValue(libraryMember);
                        updated = true;
                        break;
                    }
                }
            }
        }
        if (updated) {
            DataStorage.write(loadedData);
            System.out.println("Data written successfully");
            System.out.println("Updated member: " + libraryMember.getFirstName());
            return libraryMember;
        }
        System.out.println("Member not found");
        return null;
    }



    public static int findMaxId() {
        return members.keySet().stream()
                .map(id -> {
                    try {
                        return Integer.parseInt(id);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(id -> id != null)
                .max(Integer::compareTo).orElse(0);
    }

}

