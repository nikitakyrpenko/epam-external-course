package homework2.bank.utility;

import java.util.Collections;
import java.util.List;

public class CollectionUtility {

    private CollectionUtility(){}

    public static <T> List<T> nullSafetyListInitialize(List<T> items){
        return items == null ? Collections.emptyList() : Collections.unmodifiableList(items);
    }




}
