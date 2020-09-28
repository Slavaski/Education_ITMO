import java.util.Random;
import java.util.Vector;

import static java.lang.Math.sqrt;

public class myVector {
    private final int x;
    private final int y;
    private final int z;

    public static void main(String[] args) {
        myVector myV1 = new myVector();
        myVector myV2 = new myVector();
        float lengthMyV1 = myV1.length(myV1.get('x'), myV1.get('y'), myV1.get('z'));
        float lengthMyV2 = myV2.length(myV2.get('x'), myV2.get('y'), myV2.get('z'));
        int scalarProduct = myV1.scalarProduct(myV1.get('x'), myV1.get('y'), myV1.get('z'), myV2.get('x'), myV2.get('y'), myV2.get('z'));
        float angle = myV1.angle(myV1.get('x'), myV1.get('y'), myV1.get('z'), myV2.get('x'), myV2.get('y'), myV2.get('z'));
        myVector myV3 = myV1.vectorProduct(myV1.get('x'), myV1.get('y'), myV1.get('z'), myV2.get('x'), myV2.get('y'), myV2.get('z'));
        myVector myV4 = myV1.sum(myV1.get('x'), myV1.get('y'), myV1.get('z'), myV2.get('x'), myV2.get('y'), myV2.get('z'));
        myVector myV5 = myV1.dif(myV1.get('x'), myV1.get('y'), myV1.get('z'), myV2.get('x'), myV2.get('y'), myV2.get('z'));

        System.out.println(lengthMyV1);
        System.out.println(lengthMyV2);
        System.out.println(scalarProduct);
        System.out.println(angle);
        createNewNVectors(2);
    }

    public myVector() {
        x = new Random().nextInt(10);
        y = new Random().nextInt(10);
        z = new Random().nextInt(10);

        System.out.println("New vector: " + x + ", " + y + ", " + z);
    }

    public myVector(int xP, int yP, int zP) {
        x = xP;
        y = yP;
        z = zP;

        System.out.println("New vector: " + x + ", " + y + ", " + z);
    }

    public int get(char a) {
        if (a == 'x')
            return x;
        if (a == 'y')
            return y;
        if (a == 'z')
            return z;
        else
            return -1;
    }

    public float length(int x, int y, int z) {
        return (float) sqrt(x * x + y * y + z * z);
    }

    public int scalarProduct(int x1, int y1, int z1, int x2, int y2, int z2) {
        return (x1 * x2 + y1 * y2 + z1 * z2);
    }

    public myVector vectorProduct(int x1, int y1, int z1, int x2, int y2, int z2) {
        return new myVector(y1 * z2 - z1 * y2, z1 * x2 - x1 * z2, x1 * y2 - y1 * x2);
    }

    public float angle(int x1, int y1, int z1, int x2, int y2, int z2) {
        return scalarProduct(x1, y1, z1, x2, y2, z2) / (length(x1, y1, z1) * (length(x2, y2, z2)));
    }

    public myVector sum(int x1, int y1, int z1, int x2, int y2, int z2) {
        return new myVector(x1 + x2, y1 + y2, z1 + z2);
    }

    public myVector dif(int x1, int y1, int z1, int x2, int y2, int z2) {
        return new myVector(x1 - x2, y1 - y2, z1 - z2);
    }

    public static Vector createNewNVectors(int N) {
        Vector arr = new Vector();
        for (int i=0; i<N; i++) {
            arr.add(new myVector());
        }
        return arr;
    }
}
