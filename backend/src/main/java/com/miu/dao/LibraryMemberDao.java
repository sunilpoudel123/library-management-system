package com.miu.dao;

import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.person.LibraryMember;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class LibraryMemberDao<T extends Serializable> {
    private static Map<Integer, LibraryMember> members = new HashMap<>();

    static {
        HashMap<Integer, LibraryMember> loadedData = DataStorageFacade.readMemberMap();

        if (loadedData != null) {
            for (Map.Entry<Integer, LibraryMember> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof LibraryMember) {
                    members.put(entry.getKey(), (LibraryMember) entry.getValue());
                }
            }
        }
    }

    public static LibraryMember findMember(int memberId) {

        for (Map.Entry<Integer, LibraryMember> entry : members.entrySet()) {
            if (entry.getValue().getMemberId() == memberId) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static LibraryMember addLibraryMember(LibraryMember libraryMember) {
        DataStorageFacade.saveNewMember(libraryMember);
        System.out.println("data write successfully");
        for (Map.Entry<Integer, LibraryMember> entry : members.entrySet()) {
            if (entry.getValue().getMemberId() == libraryMember.getMemberId()) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static LibraryMember editMember(LibraryMember libraryMember) {
        boolean updated = false;
        System.out.println("Updating member with ID: " + libraryMember.getMemberId());
        LibraryMember loadedData = LibraryMemberDao.findMember(libraryMember.getMemberId());
        if (loadedData != null) {
            for (Map.Entry<Integer, LibraryMember> entry : members.entrySet()) {
                if (entry.getValue() instanceof LibraryMember) {
                    LibraryMember member = entry.getValue();
                    System.out.println(member.getMemberId() + "==" + libraryMember.getMemberId());
                    if (member.getMemberId().equals(libraryMember.getMemberId())) {
                        entry.setValue(libraryMember);
                        updated = true;
                        break;
                    }
                }
            }
        }
        if (updated) {
            DataStorageFacade.saveNewMember(loadedData);
            System.out.println("Data written successfully");
            System.out.println(STR."Updated member: \{libraryMember.getFirstName()}");
            return libraryMember;
        }
        System.out.println("Member not found");
        return null;
    }



    public static int findMaxId() {
        return members.keySet().stream()
                .map(id -> {
                    try {
                        return Integer.parseInt(String.valueOf(id));
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(id -> id != null)
                .max(Integer::compareTo).orElse(0);
    }

}

