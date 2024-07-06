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
                    members.put((String) entry.getKey().toString(), (LibraryMember) entry.getValue());
                }
            }
        }
    }

    public static LibraryMember findMember(int memberId) {
        for (Map.Entry<String, LibraryMember> entry : members.entrySet()) {
            return entry.getValue();
        }
        return null;
    }

    public static int findMaximumMemberId() {
        return findMaxId().orElse(0); // Return 0 if no members exist
    }

    public static Optional<Integer> findMaxId() {
        return members.keySet().stream()
                .map(id -> {
                    try {
                        return Integer.parseInt(id);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(id -> id != null)
                .max(Integer::compareTo);
    }

    public static boolean addLibraryMember(LibraryMember libraryMember) {
            boolean flag;
            Map<Object, Object> data = new HashMap<>();
            data.put(libraryMember.getMemberId(), libraryMember);
            flag= DataStorage.write(data);
            if (flag) {
                System.out.println("data write successfully");
            }
        return flag;
    }

 }

