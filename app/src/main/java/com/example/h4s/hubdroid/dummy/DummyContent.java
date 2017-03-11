package com.example.h4s.hubdroid.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<LockItem> ITEMS = new ArrayList<LockItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, LockItem> ITEM_MAP = new HashMap<String, LockItem>();

    static {
        // Add some sample items
        addItem(new LockItem("abc-123", "Andreas cykel", "Låstes " + new Date().toString(), true));
        addItem(new LockItem("åäö-321", "Isabell cykel", "Låstes " + new Date().toString(), false));

    }

    private static void addItem(LockItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class LockItem {
        public final String id;
        public final String content;
        public final String details;
        public final Boolean isLocked;

        public LockItem(String id, String content, String details, Boolean isLocked) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.isLocked = isLocked;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
