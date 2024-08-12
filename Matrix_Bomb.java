import java.util.Random;
import java.util.Scanner;

public class Matrix_Bomb{
    private static String tanıtım = "Merhaba!\n" +
    "* Amacınız, rastgele oluşan 3x3'lük matrix tahtadaki bombayı bulup patlamasını engellemek.\n" +
    "* Bunu yaparken 3 deneme hakkınız olacak.\n" +
    "! Unutmayın, indexler 0'dan başlar, yani 1. kutu aslında 0. index'tir.\n" +
    "- BOL ŞANS -";
    private static String bombaLine = " ";
    private static int hamleSayısı = 3;
    private static String[][] bomba = new String[3][3];
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);        

    //Oyun tahtasını oluşturan modül.
    private static void oyunTahtası(){

        //Oluşturulan bombanın kullanıcıya gösterilmemesi ve oyuncu tahtasını oluşturulmasını sağlayan bölüm.
        System.out.println("    Y0 Y1 Y2");
        for(int i = 0; i<bomba.length; i++){
            System.out.print("X"+i+":");
            for(int j = 0; j<bomba[i].length; j++){
                if(bomba[i][j].equals("*")){
                    System.out.print("|"+bombaLine+"|");
                }
                else{
                System.out.print("|"+bomba[i][j]+"|");
                }
            }
            System.out.println();
        }

    }
    //Bomba rastgele indexe yerleştirilmesini sağlayan modül.
    private static void bombayıYerleştir(){
        for(int i = 0; i<bomba.length; i++){
            for(int j = 0; j<bomba[i].length; j++){
                bomba[i][j] = " ";
            }
        }
        //Rastgele bomba için oluşturulan indexler.
        int rasgeleBombax = random.nextInt(3);
        int rasgeleBombay = random.nextInt(3);
        //Bombanın atanması.
        bomba[rasgeleBombax][rasgeleBombay] = "*";
    }
    //Yapılan seçimleri kontrol eden modül.
    private static void seçim(){
        while(true){
            System.out.println("Lütfen seçmek istediğiniz indexleri girin ilk olarak X sonra Y(Kordinat sistemi gibi) örnek = (1 2)");
            System.out.print("--->");
            int seçimx = scanner.nextInt();
            int seçimy = scanner.nextInt();
            //Inputun doğruluğunu kontrol eder.
            if(seçimx >= 3||seçimy >= 3||seçimx < 0||seçimy < 0){
                System.out.println("Lütfen geçerli indexler girin");
                continue;
            }
            scanner.nextLine();//Buffer
            if(bomba[seçimx][seçimy].equals("*")){
                System.out.println("Tebrikler bombayı buldunuz...");
                bombaLine = "*";
                oyunTahtası();
                break;
            }
            else{
                System.out.println("Bombayı bulamadınız tekrar deneyiniz...");
                hamleSayısı--;
                System.out.println("Kalan hamle sayınız : " + hamleSayısı);
                if(hamleSayısı == 0){
                    System.out.println("Bomba patladı...");
                    bombaLine = "*";
                    oyunTahtası();
                    break;
                }
                oyunTahtası();
                continue;
            }
        }
    }
    //Okunabilirliği arttırmak için oluşturulan modül
    public static void oyunBaşlat(){
        //Bombayı seçer.
        bombayıYerleştir();
        //Oyun tahtasını oluşturur.
        oyunTahtası();
        //Seçimleri kontrol eder.
        seçim();
    }
    public static void main(String[] args) {
        System.out.println(tanıtım);
        //Oyunu başlatır.
        oyunBaşlat();
    }
}
