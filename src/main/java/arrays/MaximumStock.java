package arrays;
import java.io.*;

class MaximumStockSolution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length-1; i++) {

            if (buy > prices[i]) {
            //buy when the price is less
                buy = prices[i];
            } else if (prices[i] > prices[i+1]) {
            //sell when the price is high
                sum += prices[i] - buy;
                buy = prices[++i];
            }
        }
        if (prices[prices.length-1] > buy) {
            sum += prices[prices.length-1] - buy;
        }
        return sum;
    }

}

public class MaximumStock {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] prices = stringToIntegerArray(line);

            int ret = new MaximumStockSolution().maxProfit(prices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
