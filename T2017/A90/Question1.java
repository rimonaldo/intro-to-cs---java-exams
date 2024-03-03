package T2017.A90;

public class Question1 {

    // max weight - capacity = w
    public static int knapSack(Item[] items, int w) {
        // base case
        return knapSack(items, w, 0);
    }

    public static int knapSack(Item[] items, int weightLeft, int i) {
        // base case
        if (weightLeft < 0 || i > items.length - 1) {
            return 0;
        }

        // if item weight is valid
        if (weightLeft - items[i].getWeight() >= 0) {
            // option1 - take item, add value, less weigt left
            int op1 = items[i].getValue() + knapSack(items, weightLeft - items[i].getWeight(), i + 1);
            // option2 - dont take item, dont add value
            int op2 = knapSack(items, weightLeft, i + 1);
            return Math.max(op1, op2);
        }

        // if item is overweight, were not taking it for sure
        return knapSack(items, weightLeft, i + 1);
    }
}
