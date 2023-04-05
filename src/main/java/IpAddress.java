import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddress {
    //Задание 1 "IP-адреса"
//        IpV4 адрес состоит из 4 октетов, значит его можно хранить в переменной типа int32.
//        Реализуйте пару функций, которые однозначно преобразуют строковое представление IpV4 адрес (вида "127.0.0.1") в значение типа int32 и наоборот.
//
//        Примеры:
//        2149583360 ==> "128.32.10.0"
//        255        ==> "0.0.0.255"

    public static void ipv4ToInt32(String IpV4){
        String[] massiveIpV4 = IpV4.split("\\.");
        long[] massIpV4 = new long[massiveIpV4.length];
        for (int i = 0; i<massiveIpV4.length; i++){
            massIpV4[i] = Long.parseLong(massiveIpV4[i]);
        }
        long int32 = (long) (massIpV4[0]*Math.pow(2,24)+massIpV4[1]*Math.pow(2,16)+massIpV4[2]*Math.pow(2,8)+massIpV4[3]);
        System.out.println("IpV4  ->  int32    " + IpV4 + " -> " + int32);
    }
    public static void int32ToIpV4(int ipaddr) throws UnknownHostException {
        byte[] addr = new byte[4];
        addr[0] = (byte) ((ipaddr >> 24) & 0xFF);
        addr[1] = (byte) ((ipaddr >> 16) & 0xFF);
        addr[2] = (byte) ((ipaddr >> 8 ) & 0xFF);
        addr[3] = (byte) (ipaddr & 0xFF);
        InetAddress inetAddr = InetAddress.getByAddress(addr);
        String inetAdressString = inetAddr.toString().replaceAll("/", "");

        System.out.println("int32  ->  IpV4    " + ipaddr + " -> " + inetAdressString);
    }
    public static void main(String[] args) throws UnknownHostException {
        ipv4ToInt32("128.32.10.0");
        ipv4ToInt32("0.0.0.255");
        ipv4ToInt32("999.999.99.999");
        int32ToIpV4(2142583360);
        int32ToIpV4(255);
        int32ToIpV4(914952360);
    }
}
