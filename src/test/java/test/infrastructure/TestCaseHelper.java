package test.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Создание и хранение в insertQueriesCallMap моделей и сохранение их в БД при вызове completeTestCase()
 */
@Component
public class TestCaseHelper {

    private final Map<Class, List<Supplier<Integer>>> insertQueriesCallMap = new HashMap<>();
    //Сюда добавляем классы моделей в порядке, в котором будем насыщать таблицы
    private final List<Class> insertionOrder = Arrays.asList(

    );

    @Autowired
    private DefaultEntityHelper entityHelper;


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
