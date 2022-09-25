package examples;

import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 20/04/2022
 */
public class LGModel extends ElectricalDevice implements Refrigerator{

    private Integer length;
    private Integer width;
    private Integer height;
    private String modelNumber;
    private List<String> items;

    public LGModel(Integer length, Integer width, Integer height, String modelNumber) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.modelNumber = modelNumber;
    }

    @Override
    public void switchOn() {
        super.currentOn();
    }

    @Override
    public void switchOff() {
        super.currentOff();
    }

    @Override
    public void putItems(List<String> items) {
        this.items.addAll(items);
    }

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public void displayDetails() {
        System.out.println(length+"X"+width+"X"+height);
    }
}
