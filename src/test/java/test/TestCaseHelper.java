package test;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Supplier;

@Component
public class TestCaseHelper {

    private final Map<Class, List<Supplier<Integer>>> insertQueriesCallMap = new HashMap<>();
    private final List<Class> insertionOrder = Arrays.asList(

    );

    public void completeTestCase() {
        var entryList = new ArrayList<>(insertQueriesCallMap.entrySet());
        entryList.sort(Comparator.comparingInt(entry -> insertionOrder.indexOf(entry.getKey())));

        entryList.forEach(entry -> entry.getValue().forEach(Supplier::get));
    }

    private void putEntity(Object entity, Supplier<Integer> supplier) {
        insertQueriesCallMap.computeIfAbsent(entity.getClass(), list -> new ArrayList<>())
                .add(supplier);
    }
}
