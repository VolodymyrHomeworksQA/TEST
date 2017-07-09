package myprojects.automation.assignment4.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;

/**
 * Hold Product information that is used among tests.
 */
public class ProductData {
    private String name;
    private String key;
    private int qty;
    private float price;
    private float weight;

    public ProductData(String key, String name, int qty, float price, float weight) {
        this.key = key;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.weight = weight;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Integer getQty() {
        return qty;
    }

    public String getPrice() {
        DecimalFormatSymbols separators = new DecimalFormatSymbols();
        separators.setDecimalSeparator(',');
        return new DecimalFormat("#0.00", separators).format(price);
    }

    public String getWeight() {
        DecimalFormatSymbols separators = new DecimalFormatSymbols();
        separators.setDecimalSeparator(',');
        return new DecimalFormat("#0.00 lb", separators).format(price);
    }

    /**
     * @return New Product object with random name, quantity and price values.
     */
    public static ProductData generate() {
        Random random = new Random();

        String key = "Name";
        return new ProductData(
            key,
            "Name " + System.currentTimeMillis(),
            random.nextInt(100) + 1,
            (float) Math.round(random.nextInt(100_00) + 1) / 100,
            new Random().nextFloat());
    }

    private static String getId() {

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
        for (int i = 0; i < 5; i++) {
            sb.append(chars[rnd.nextInt(chars.length)]);
        }
        return sb.toString();
    }
}
