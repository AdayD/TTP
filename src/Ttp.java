import Picture.MakePicture;

public class Ttp {

    void main() {

        for(byte b : MakePicture.makeHeader(1920,1080)) {
            System.out.println("HEXBYTE:");
            System.out.printf("0x%02X", b);
            System.out.println();
            System.out.println("Int");
            System.out.println(b);
        }
    }
}
