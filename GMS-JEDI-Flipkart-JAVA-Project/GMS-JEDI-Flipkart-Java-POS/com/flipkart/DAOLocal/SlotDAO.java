package com.flipkart.DAOLocal;

import com.flipkart.bean.Slot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SlotDAO implements SlotInterfaceDAO {

    private static List<Slot> slotList = new ArrayList<>();

    public SlotDAO() {
    }

    public List<Slot> getSlotList() {
        return new ArrayList<>(slotList);
    }

    public List<Slot> getSlotByCentreId(String gymCentreId) {
        List<Slot> filteredSlots = new ArrayList<>();
        for (Slot slot : slotList) {
            if (slot.getCentreID().equals(gymCentreId)) {
                filteredSlots.add(slot);
            }
        }
        return filteredSlots;
    }

    public void addSlot(Slot slot) {
        //String slotId = generateUniqueSlotId(slot.getCentreID(), slot.getTime());
        String slotId= slot.getSlotId();
        slot.setSlotId(slotId);
        slotList.add(slot);
    }

    public Slot getSlotById(String slotID) {
        for (Slot slot : slotList) {
            if (slot.getSlotId().equals(slotID)) {
                return slot;
            }
        }
        return null;
    }

    public Slot getSlotByIdAndCentreId(String slotID, String centreID) {
        for (Slot slot : slotList) {
            if (slot.getSlotId().equals(slotID) && slot.getCentreID().equals(centreID)) {
                return slot;
            }
        }
        return null;
    }

    private String generateUniqueSlotId(String centreID, LocalTime time) {
        return centreID + "-" + time.toString();
    }
}
