import com.sun.istack.internal.Nullable;

import java.util.Arrays;

public class discount {

    int[] price;
    int discount;
    int offset;
    int readLength;

    public discount(int[] price, int discount, int offset, int readLength) {
        this.price = price;
        this.discount = discount;
        this.offset = offset;
        this.readLength = readLength;
    }


    int[] getPrice() {
        return price;
    }

    int getDiscount() {
        return discount;
    }

    int getOffset() {
        return offset;
    }

    int getReadLength() {
        return readLength;
    }

    public @Nullable
    int[] decryptData(int[] price,
                      int discount,
                      int offset,
                      int readLength) {
        if (readLength < price.length && readLength > 0 && discount > 0 && discount < 100 && readLength + offset <= price.length) {
            int[] newprices = new int[readLength];
            int i;
            double price_in_double;
            int price_in_int;
            double newdiscount = discount * 0.01;
            for (i = 0; i < readLength; i++) {
                price_in_double = price[i + offset] - price[i + offset] * newdiscount;
                price_in_int = (int) Math.floor(price_in_double);
                newprices[i] = price_in_int;
            }

            return newprices;
        } else {
            System.out.println("Ошибка в данных");
            System.exit(0);
        }


        return price;
    }

    public static void main(String[] args) {
        discount tester = new discount(new int[]{10, 20, 40, 50, 60}, 20, 0, 2);
        System.out.println(Arrays.toString(tester.decryptData(tester.getPrice(), tester.getDiscount(), tester.getOffset(), tester.getReadLength())));
    }
};