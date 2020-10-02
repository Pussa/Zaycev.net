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

    public
    int[] decryptData( int[] price,
                       int discount,
                       int offset,
                       int readLength) {
        discount Discount = new discount(getPrice(), getDiscount(), getOffset(), getReadLength());
        int[] newprices = new int[readLength];
        int i;
        int n = 0;
        double price_in_double;
        int price_in_int;
        double newdiscount = discount * 0.01;
        for (i = offset; i < offset + readLength; i++) {
            price_in_double = price[i] * newdiscount;
            price_in_int = (int) Math.floor(price_in_double);
            newprices[n] = price_in_int;
            n++;

        }

        return newprices;

    }
    public static void main(String[] args) {
        discount tester = new discount(new int[]{10, 20, 40, 50, 60},50,1,3);
        System.out.println(Arrays.toString(tester.decryptData(tester.getPrice(), tester.getDiscount(), tester.getOffset(), tester.getReadLength())));
    }
};


