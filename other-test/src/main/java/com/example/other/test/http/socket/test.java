package com.example.other.test.http.socket;

public class test {
    public static void main(String[] args) {
        int a = 0x7f;
        int b = 0x00;
        int c = 0x00;
        int d = 0x01;
        byte[] addr = {0x7f, 0x00, 0x00, 0x01};
        System.out.println(addr[0]);
        System.out.println(addr[1]);
        System.out.println(addr[2]);
        System.out.println(addr[3]);

        System.out.println("*********************");
        int address = addr[3] & 0xFF;
        System.out.println("0x01 & 0xFF -> " + address);

        System.out.println("*********************");
        int address2_1 = addr[2] << 8;
        System.out.println("0x00 << 8 -> " + address2_1);
        int address2_2 = address2_1 & 0xFF00;
        System.out.println("(0x00 << 8) & 0xFF0000 -> " + address2_2);
        address |= address2_2;
        System.out.println("0x01 | ((0x00 << 8) & 0xFF0000) -> " + address);

        System.out.println("*********************");
        int address1_1 = addr[1] << 16;
        System.out.println("0x00 << 16 -> " + address1_1);
        int address1_2 = address2_1 & 0xFF0000;
        System.out.println("(0x00 << 16) & 0xFF0000 -> " + address1_2);
        address |= address | address2_2;
        System.out.println("0x01 | ((0x00 << 16) & 0xFF0000) -> " + address);

        System.out.println("*********************");
        int address0_1 = addr[0] << 24;
        System.out.println("0x00 << 24 -> " + address0_1);
        int address0_2 = address2_1 & 0xFF000000;
        System.out.println("(0x00 << 24) & 0xFF000000 -> " + address0_2);
        address |= address | address2_2;
        System.out.println("0x01 | ((0x00 << 24) & 0xFF000000) -> " + address);

        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("*********************");
        int host = addr[3] & 0xFF;
        System.out.println("HOST IP -> " + host);
        host |= ((addr[2] << 8) & 0xFF00);
        System.out.println("HOST IP -> " + host);
        host |= ((addr[1] << 16) & 0xFF0000);
        System.out.println("HOST IP -> " + host);
        host |= ((addr[0] << 24) & 0xFF000000);
        System.out.println("HOST IP -> " + host);

    }
}
