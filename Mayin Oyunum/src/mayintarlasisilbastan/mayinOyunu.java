/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayintarlasisilbastan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hydon
 */
class OyunEkrani extends JFrame {//jframin özelliklerine erişebilmek için kalıtım yapılıyor 

    JPanel panelSayac = new JPanel();
    public JPanel oyunAlani = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JButton oyunaBasla = new JButton();
    JFrame anaForm = new JFrame("MineSweesper");
    static JTextField gecensureKutu = new JTextField("000");
    JTextField kalanmayinKutu = new JTextField("000");
    JMenu oyunMenu = new JMenu("Oyun");
    JMenu Yardım = new JMenu("Yardım");
    JMenuItem yeniOyun = new JMenuItem("Yeni Oyun");
    JMenuItem Baslangic = new JMenuItem("Baslangic");
    JMenuItem Orta = new JMenuItem("Orta Seviye");
    JMenuItem Zor = new JMenuItem("Zor");
    JMenuItem Ozel = new JMenuItem("Özel");
    JMenuItem Cıkıs = new JMenuItem("Cikis");
    JButton deneme = new JButton();
    JButton deneme2 = new JButton();
    JButton denemeson = new JButton();
    JPanel butunpanel = new JPanel();
    Timer gecensuretimer = new Timer();

    void butonolustur(int yataybuton, int dikeybuton) {
        for (int i = 0; i < yataybuton; i++) {
            for (int j = 0; j < dikeybuton; j++) {
                final JButton btn_ij = new JButton();
                btn_ij.setFont(new Font("Tahoma", Font.PLAIN, 12));
                btn_ij.setBounds(i * 21, j * 21, 20, 20);
                btn_ij.setBackground(Color.LIGHT_GRAY);

                btn_ij.setName(Integer.toString(i) + Integer.toString(j));
                oyunAlani.add(btn_ij);
                btn_ij.addActionListener(new ActionListener() {//olusturduğumuz her buton icin bir aksiyonlistener oluusturuluyor
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }

                });
                btn_ij.addMouseListener(new MouseListener() {//mous dinleniyor
                    int bayraktiksayi = 1;

                    @Override

                    public void mouseClicked(MouseEvent e) {

                        if (e.getButton() == MouseEvent.BUTTON3 && bayraktiksayi % 2 == 0) {//button 3 burada sag clickimiz oluyor eger sag clicke bir kez basarsa bayrak katsın diyoruz
                            {
                                btn_ij.setIcon(new javax.swing.ImageIcon(getClass().getResource("bayrak.png")));

                            }

                        }
                        if (e.getButton() == MouseEvent.BUTTON3 && bayraktiksayi % 2 == 1) {
                            btn_ij.setIcon(null);//var olan iconun icini temizliyor 

                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                        bayraktiksayi++;
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });

            }
        }
    }

    void oyunubaslat(String zorlukseviye) {

        String zorlukSeviyesi = zorlukseviye;
        int boy;//yatay buton sayisi*genislik
        int genislik;
        int yataybuton = 9;
        int dikeybuton = 9;
        int mayinsayisi = 10;

        if (zorlukSeviyesi == "baslangic") { //zorluk seviyesi baslangic ve diger modlarda oyun nasıl olacak o ayalarnaıyor

            boy = (dikeybuton * 21) + 106;
            genislik = (yataybuton * 21) + 14;
            butonolustur(yataybuton, dikeybuton);
            oyun.OyunuBaslat(yataybuton + 2, dikeybuton + 2, oyun.mayinalaniniDoldur(yataybuton + 2, dikeybuton + 2, mayinsayisi));//oyunun konsol kısmı olsuturuluyor burada +2 yapmaktaki amaç mayın alanın komşuluklarını kolay şekilde kontrol etmek için bir duvar olusturuluyor
            oyunOlustur(boy, genislik, mayinsayisi);//oyunun buton kısımları olusturuyor 
            kalanmayinKutu.setText(Integer.toString(mayinsayisi));//mayın sayisi mayın kutusuna atılıyor
            timer();

        }

        if (zorlukSeviyesi == "orta") {

            yataybuton = 16;
            dikeybuton = 16;
            boy = (dikeybuton * 21) + 106;
            genislik = (yataybuton * 21) + 14;
            mayinsayisi = 40;
            butonolustur(yataybuton, dikeybuton);
            oyun.OyunuBaslat(yataybuton + 2, dikeybuton + 2, oyun.mayinalaniniDoldur(yataybuton + 2, dikeybuton + 2, mayinsayisi));//oyunun konsol kısmı olsuturuluyor burada +2 yapmaktaki amaç mayın alanın komşuluklarını kolay şekilde kontrol etmek için bir duvar olusturuluyor

            oyunOlustur(boy, genislik, mayinsayisi);
            kalanmayinKutu.setText(Integer.toString(mayinsayisi));
            timer();

        }

        if (zorlukSeviyesi == "zor") {

            yataybuton = 16;
            dikeybuton = 30;
            mayinsayisi = 99;
            boy = (dikeybuton * 21) + 106;
            genislik = (yataybuton * 21) + 14;
            butonolustur(yataybuton, dikeybuton);
            oyun.OyunuBaslat(yataybuton + 2, dikeybuton + 2, oyun.mayinalaniniDoldur(yataybuton + 2, dikeybuton + 2, mayinsayisi));//oyunun konsol kısmı olsuturuluyor burada +2 yapmaktaki amaç mayın alanın komşuluklarını kolay şekilde kontrol etmek için bir duvar olusturuluyor

            oyunOlustur(boy, genislik, mayinsayisi);
            kalanmayinKutu.setText(Integer.toString(mayinsayisi));
            timer();

        }

        Baslangic.addActionListener( //baslangic menusu icinn bir aksiyonlistener olusturuldu
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {  //baslangic menusune basildiginde olacaklar
                oyunubaslat("baslangic");

            }
        });
        Orta.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                oyunubaslat("orta");
            }
        });
        Zor.addActionListener(//zor icin bir aksiyon listener yani bir islem dinleeyici olusturduk eger bir aksiyon varsa oyun modunu zor yapıpor
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                oyunubaslat("zor");
            }
        });
        Cıkıs.addActionListener(//zor icin bir aksiyon listener yani bir islem dinleeyici olusturduk eger bir aksiyon varsa oyun modunu zor yapıpor
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);//oyunu kapatmak için

            }
        });

        Ozel.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFrame ozelForm = new JFrame("özel oyun");

                JPanel acılıralan = new JPanel();

                JTextField yataybutonTxt = new JTextField();
                yataybutonTxt.setBounds(120, 12, 90, 20);

                JTextField dikeybutonTxt = new JTextField();
                dikeybutonTxt.setBounds(120, 42, 90, 20);

                JTextField mayinsayisiTxt = new JTextField();
                mayinsayisiTxt.setBounds(120, 72, 90, 20);
                JButton btnOlustur = new JButton("olustur");

                btnOlustur.setBounds(120, 102, 90, 20);
//                ozel.setLayout(new BorderLayout());
                acılıralan.setLayout(null);

                ozelForm.add(acılıralan);
                ozelForm.setSize(200, 200);
                acılıralan.add(dikeybutonTxt);
                acılıralan.add(yataybutonTxt);
                acılıralan.add(mayinsayisiTxt);
                acılıralan.add(btnOlustur);

                JLabel yataybtnLbl = new JLabel("yatay buton sayisi");
                yataybtnLbl.setBounds(10, 15, 120, 15);

                JLabel dikeybtnLbl = new JLabel("dikey buton sayisi ");
                dikeybtnLbl.setBounds(10, 45, 120, 15);

                JLabel mayinSayisiLabel = new JLabel("mayin sayisi");
                mayinSayisiLabel.setBounds(10, 75, 120, 15);

                acılıralan.add(yataybtnLbl);
                acılıralan.add(dikeybtnLbl);
                acılıralan.add(mayinSayisiLabel);
                ozelForm.setSize(250, 200);
                ozelForm.setVisible(true);//formumuzu acıyoruz

                Image mayin = new ImageIcon(OyunEkrani.class.getResource("mayin.png")).getImage();//mayin nesnemize mayinin resmimini çektik burada classin ismi yazılacak burada ilk ilgili class için mayının konumunu getsource alıyoruz
                ozelForm.setIconImage(mayin);//olusturan imageiconu formumuz için kullanıyoruz //ozel formun  iconu mayın oluyor 
                btnOlustur.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int yataybuton = Integer.parseInt(yataybutonTxt.getText());
                        int dikeybuton = Integer.parseInt(dikeybutonTxt.getText());
                        int mayinsayisi = Integer.parseInt(mayinsayisiTxt.getText());
                        int boy = (dikeybuton * 21) + 106;
                        int genislik = (yataybuton * 21) + 14;
                        butonolustur(yataybuton, dikeybuton);
                        oyun.OyunuBaslat(yataybuton + 2, dikeybuton + 2, oyun.mayinalaniniDoldur(yataybuton + 2, dikeybuton + 2, mayinsayisi));//oyunun konsol kısmı olsuturuluyor burada +2 yapmaktaki amaç mayın alanın komşuluklarını kolay şekilde kontrol etmek için bir duvar olusturuluyor

                        oyunOlustur(boy, genislik, mayinsayisi);//oyunun buton kısımları olusturuyor 
                        kalanmayinKutu.setText(Integer.toString(mayinsayisi));//mayın sayisi mayın kutusuna atılıyor
                        ozelForm.dispose();
                        timer();

                    }
                });

            }
        });

    }

    public static void timer() {
        Timer zamanlayici = new Timer();

        TimerTask gorev = new TimerTask() {//gorev kısmının oluşturduğumuz yer aşağıdaki kısımlar otomatik geliyor 
//ne yapılacak 
            int sayac = 0;

            public void run() {
                sayac++;

                gecensureKutu.setText(Integer.toString(sayac));

            }
        };
        zamanlayici.schedule(gorev, 0, 1000);//hangi işlemi hangi saniyeden başlayarak kac saniyede yapacak burada 1000 milli saniye 1 saniyedir 1000ml=1 saniye
//        zamanlayici.cancel();//durdurmaya yarıyor 
    }

    public void oyunOlustur(int boy, int genislik, int mayinSayisi) {

        oyunAlani.setLayout(null);
        oyunAlani.setBounds(0, 72, genislik, boy);
        oyunAlani.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        anaForm.add(panelSayac);
        anaForm.add(oyunAlani);
        anaForm.add(menuBar);//menu barımızı formumuza ekliyoruz

//        menu ile kısımlar
        {
            oyunMenu.add(yeniOyun); //ilkonce menumuse bir companent ekledik sonra o menuyu bir menubara ekledik 
            oyunMenu.add(Baslangic);
            oyunMenu.add(Orta);
            oyunMenu.add(Zor);
            oyunMenu.add(Ozel);
            oyunMenu.add(Cıkıs);
            menuBar.add(oyunMenu);
            menuBar.add(Yardım);
            setJMenuBar(menuBar);
            menuBar.setBounds(0, 0, genislik - 20, 20);

            menuBar.setBackground(Color.white);

        }

        Image mayin = new ImageIcon(OyunEkrani.class.getResource("mayin.png")).getImage();//mayin nesnemize mayinin resmimini çektik burada classin ismi yazılacak burada ilk ilgili class için mayının konumunu getsource alıyoruz
        anaForm.setIconImage(mayin);//olusturan imageiconu formumuz için kullanıyoruz //anaformun iconu mayın oluyor 
        anaForm.setSize(genislik, boy);//formun ekranın tam ortasında açılmasını sağlıyor
        anaForm.setLocationRelativeTo(null);

        //oyuna başla butonu gülen yüzle  ile ilgili kısım
        {

            oyunaBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("smile.png")));
            oyunaBasla.setBounds((genislik - 50) / 2, 10, 30, 30);
        }

        //kalanmayinin gösterildiği kutu
        {
            kalanmayinKutu.setBounds(10, 10, 30, 30);

            kalanmayinKutu.setBackground(Color.black);
            kalanmayinKutu.setForeground(Color.red);
        }
        // Gecen sure kutusu  
        {
            gecensureKutu.setBounds(genislik - 50, 10, 30, 30);//en sonde olduğu için x kordinatını genisliğin 50 eksiği kadar yapıyor

            gecensureKutu.setBackground(Color.black);
            gecensureKutu.setForeground(Color.red);

        }

        //panelsayac ilgili kısımlar
        {
            panelSayac.setBounds(0, 20, genislik, 50);//panelin boyunu konumu ile ilgili kısım
            panelSayac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));//panelin bordorini yani kalınlığını ayarlıyorz
            panelSayac.setLayout(null);//panelin layautunu null yapıyoruz ki içine istediğimiz gibi companantları ekleyelim yerlerini istediğimiz gibi belirleyelim önemli
            panelSayac.add(gecensureKutu);
            panelSayac.add(oyunaBasla);
            panelSayac.add(kalanmayinKutu);

        }

        //formlar ilgili kısımlar
        {

            anaForm.add(panelSayac);
            anaForm.add(menuBar);//menu barımızı formumuza ekliyoruz
            anaForm.setLayout(new BorderLayout());

            anaForm.setVisible(true);//Formu görünür kılar tüm nesneleri görmek için en sona yazılması şarttır
            anaForm.setDefaultCloseOperation(EXIT_ON_CLOSE);//kapatma simgesine basıldığında ne olsun istiyoruz programı tamamen kapatıyoruz
            anaForm.setResizable(false);//formun boyutunu değiştirmeyi kapatmayı sağlıyor
        }

    }

}

class oyun extends OyunEkrani {

    public static String[][] mayinalaniniDoldur(int satirsayisi, int sutunsayisi, int mayinsayisi) {//mayin alanını doldurmak icin
        Random rnd = new Random();
        String mayin[][] = new String[satirsayisi + 2][sutunsayisi + 2];

        while (mayinsayisi > 0) {

            for (int i = 1; i < satirsayisi - 1; i++) {
                for (int j = 1; j < sutunsayisi - 1; j++) {

                    int random = rnd.nextInt(50) + 1;

                    if (random == 5 && mayin[i][j] == " " && mayinsayisi > 0) {
                        mayin[i][j] = "x";//aslında bombamı ifade ediyor
                        mayinsayisi = mayinsayisi - 1;
                    } else if (mayin[i][j] != "x") {
                        mayin[i][j] = " ";

                    }
                }
            }
        }

        return mayin;
    }

    static String[][] OyunuBaslat(int satirsayisi, int sutunsayisi, String mayinalani[][]) { //mayinalanı komsulukları incelemek için
        OyunEkrani form = new OyunEkrani();//oyun ekranı sınıfının bir objesini oluşturuyoruz
        System.out.println("------------------------------------------------");//yeni oyunla karıışmasın diye 
        for (int i = 1; i < satirsayisi - 1; i++)//neden +1 ve -1 ekledik duvarları kullanıcıdan gizlemek için ve o duvarlardaki ifadeleri erişimi engellemek için
        {
            for (int j = 1; j < sutunsayisi - 1; j++) {

                int bombasayi = 0;

                if (mayinalani[i][j] == " ") {
                    if (mayinalani[i + 1][j] == "x") {
                        bombasayi++;

                    }

                    if (mayinalani[i - 1][j] == "x") {
                        bombasayi++;

                    }

                    if (mayinalani[i][j + 1] == "x") {
                        bombasayi++;

                    }
                    if (mayinalani[i][j - 1] == "x") {
                        bombasayi++;

                    }

                    if (mayinalani[i + 1][j + 1] == "x") {
                        bombasayi++;

                    }

                    if (mayinalani[i - 1][j - 1] == "x") {
                        bombasayi++;
                        form.butonolustur(satirsayisi, sutunsayisi);
                    }

                    if (mayinalani[i + 1][j - 1] == "x") {
                        bombasayi++;

                    }

                    if (mayinalani[i - 1][j + 1] == "x") {
                        bombasayi++;

                    }
                    System.out.print(mayinalani[i][j] = Integer.toString(bombasayi));
                } else {

                    System.out.print(mayinalani[i][j] = "x");
                }
            }

            System.out.println("");
        }

        return mayinalani;

    }
}

public class mayinOyunu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        OyunEkrani a = new OyunEkrani();
        a.oyunubaslat("baslangic");

    }

}
