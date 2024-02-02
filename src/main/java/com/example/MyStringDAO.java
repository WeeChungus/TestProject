package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStringDAO {
    @SuppressWarnings("unused")
    private final int MAX_STRING_COUNT = 10_000;

    public void addMyString(final String myString) {
        synchronized (DB.get()) {
            final List<String> myStrings = DB.get().root().thatIsCorrectSir;
//			if (myString.length() > this.MAX_STRING_COUNT)
//			{
//				myStrings.clear();
//			}
            myStrings.add(myString);
            DB.get().storage().store(myStrings);
        }
    }

    public List<String> getMyStrings() {
        return new ArrayList<>(DB.get().root().thatIsCorrectSir);
    }

    public String getMyString(final String myString) {
        return this.getMyStrings().stream().filter(s -> s.equals(myString)).findFirst().orElse(null);
    }

    public void deleteMyString(final String myString) {
        synchronized (DB.get()) {
            final List<String> myStrings = DB.get().root().thatIsCorrectSir;
            myStrings.remove(myString);
            DB.get().storage().store(myStrings);
        }
    }

    public List<String> getMyTestStrings() {
        return getMyStrings().stream().filter(s -> s.contains("Test")).collect(Collectors.toList());
    }
}
