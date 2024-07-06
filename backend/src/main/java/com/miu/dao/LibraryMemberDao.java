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

    public LibraryMember findMember(int memberId) {
          for (Map.Entry<String, LibraryMember> entry : members.entrySet()) {

             if (entry.getValue().getMemberId() == memberId) {
                return entry.getValue();
            }
        }
        return null;
    }

    public LibraryMember addLibraryMember(LibraryMember libraryMember) {
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

    public int findMaxId() {
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

