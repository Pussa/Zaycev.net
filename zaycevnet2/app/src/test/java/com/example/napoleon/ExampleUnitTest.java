package com.example.napoleon;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    int[] price;
    int discount;
    int offset;
    int readLength;

    public ExampleUnitTest(int[] price, int discount, int offset, int readLength) {
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
                      @IntRange(from=1)
                             int discount,
                      @IntRange(from=0)
                             int offset,
                      @IntRange(from=1)
                             int readLength) {
        ExampleUnitTest Discount = new ExampleUnitTest(getPrice(), getDiscount(), getOffset(), getReadLength());
        int[] newprices = new int[readLength];
        int i;
        double price_in_double;
        int price_in_int;
        double newdiscount = discount * 0.01;
        if(readLength<price.length&&offset==price.length-readLength&&offset<100){for (i = 0; i < readLength; i++) {
            price_in_double = price[i + offset] * newdiscount;
            price_in_int = (int) Math.floor(price_in_double);
            newprices[i] = price_in_int;
        }

            return newprices;
        }else{
            System.out.println("Ошибка в данных");
            System.exit(0);
            return price;
        }


    }
    @Test
    public static void main(String[] args) {
        ExampleUnitTest tester = new ExampleUnitTest(new int[]{10, 20, 40, 50, 60}, 50, 1, 3);
        System.out.println(Arrays.toString(tester.decryptData(tester.getPrice(), tester.getDiscount(), tester.getOffset(), tester.getReadLength())));
    }
};