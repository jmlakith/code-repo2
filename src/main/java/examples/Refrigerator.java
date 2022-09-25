package examples;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 20/04/2022
 */
public interface Refrigerator {
    void switchOn();
    void switchOff();
    void putItems(List<String> items);
    List<String> getItems();
    void displayDetails();
}
