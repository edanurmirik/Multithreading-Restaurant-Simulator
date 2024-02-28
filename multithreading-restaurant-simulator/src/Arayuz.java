import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Arayuz {
    private final int width = 1200;
    private final int height = 800;
    private final JPanel panel;

    public Arayuz() {

        JFrame frame = new JFrame();
        frame.setTitle("Restaurant");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(66, 66, 66));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(2));
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                draw(g2d);
            }
        };

        panel.setOpaque(false);
        frame.add(panel);

        JButton maxkazanc = new JButton("Maksimum Kazanç");
        maxkazanc.setBounds(20, 700, 150, 40);
        maxkazanc.setBackground(Color.lightGray);
        panel.add(maxkazanc);

        maxkazanc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maxKazanc(); // İkinci ekranı açan metod
            }
        });

        frame.setVisible(true);

        Timer guncel = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });

        guncel.start();
    }

    private void maxKazanc() {
        JFrame frame = new JFrame();
        frame.setTitle("İkinci Ekran");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        Problem2 simulation = new Problem2(180, 4, 1, 1, 1, 1);
        simulation.eniyidurum();

        JLabel bilgiLabel = new JLabel("Masa sayısı: " + simulation.enIyiMasa);
        panel.add(bilgiLabel);
        JLabel bilgiLabel2 = new JLabel("Garson sayısı: " + simulation.enIyiGarson);
        panel.add(bilgiLabel2);
        JLabel bilgiLabel3 = new JLabel("Aşçı sayısı: " + simulation.enIyiAsci);
        panel.add(bilgiLabel3);
        JLabel bilgiLabel4 = new JLabel("En fazla kazanç: " + simulation.maksimumGelir);
        panel.add(bilgiLabel4);
        JLabel bilgiLabel5 = new JLabel("Müşteri sayısı: " + simulation.maxMusteriSayisi);
        panel.add(bilgiLabel5);

        frame.add(panel);

        frame.setVisible(true);
    }

    private void draw(Graphics2D g) {
        int tableWidth = 150;
        int tableHeight = 100;
        int startX = 50;
        int startY = 50;
        int gap = 20;

        for (int i = 0; i < Restaurant.masalar.size(); i++) {
            Masa masa = Restaurant.masalar.get(i);

            Color tableColor = masa.isEmpty() ? Color.RED : Color.GREEN;

            g.setColor(tableColor);
            g.fillRect(startX + i * (tableWidth + gap), startY, tableWidth, tableHeight);

            g.setColor(Color.BLACK);
            g.drawRect(startX + i * (tableWidth + gap), startY, tableWidth, tableHeight);

            // Masa numarasını çizmek için
            g.setColor(Color.BLACK);
            g.drawString(masa.name, startX + i * (tableWidth + gap) + 10, startY + 20);
            if(!masa.isEmpty())
                g.drawString(masa.oturanMusteri.name , startX + i * (tableWidth + gap) + 10, startY + 40);
            if(!masa.isEmpty() && masa.oturanMusteri.isYemekYiyorMu() && masa.oturanMusteri != Restaurant.kasiyer.odemeAldigiMusteri)
                g.drawString("Yemek yiyor" , startX + i * (tableWidth + gap) + 10, startY + 60);
            else if(!masa.isEmpty() && masa.oturanMusteri.isYemekYiyorMu() && masa.oturanMusteri == Restaurant.kasiyer.odemeAldigiMusteri && masa.oturanMusteri.isYemegiBittiMi())
                g.drawString("Ödeme yapıyor" , startX + i * (tableWidth + gap) + 10, startY + 60);
            else if(!masa.isEmpty() && masa.oturanMusteri.isYemekYiyorMu() && masa.oturanMusteri != Restaurant.kasiyer.odemeAldigiMusteri && masa.oturanMusteri.isYemegiBittiMi())
                g.drawString("Ödeme için bekliyor" , startX + i * (tableWidth + gap) + 10, startY + 60);
        }

        // Garsonları çiz
        for (int i = 0; i < Restaurant.garsonlar.size() ; i++) {
            Garson garson = Restaurant.garsonlar.get(i);
            Musteri ilgiliMusteri = garson.ilgilendigiMusteri;

            Color garsonLabel = garson.calisiyor ? Color.GREEN : Color.RED;

            g.setColor(garsonLabel);
            g.fillRect(startX + i * (tableWidth + gap), startY + tableHeight + 50, tableWidth,tableHeight);

            g.setColor(Color.BLACK);
            g.drawRect(startX + i * (tableWidth + gap), startY + tableHeight + 50, tableWidth,tableHeight);

            g.setColor(Color.BLACK);
            g.drawString(garson.name, startX + i * (tableWidth + gap) + 10, startY + tableHeight + 70);

            if(ilgiliMusteri == null){
                g.drawString("beklemede.",startX + i * (tableWidth + gap) + 10, startY + tableHeight + 90);
            }else {
                g.drawString(ilgiliMusteri.name + "'in", startX + i * (tableWidth + gap) + 10, startY + tableHeight + 90);
                g.drawString("siparişini alıyor.", startX + i * (tableWidth + gap) + 10, startY + tableHeight + 110);
            }
        }

        // Şefleri çiz
        for (int i = 0; i < 2; i++) {
            Asci asci = Restaurant.ascilar.get(i);
            //Musteri hazirlananMusteri = asci.siparisiniHazirladigiMusteri;
            ArrayList<Musteri> siparisListesi = asci.siparisListesi;

            Color asciLabel = asci.calisiyor ? Color.GREEN : Color.RED;

            g.setColor(asciLabel);
            g.fillRect(startX + i * (tableWidth + gap), startY + (2 * tableHeight) + 100, tableWidth,tableHeight);

            g.setColor(Color.BLACK);
            g.drawRect(startX + i * (tableWidth + gap), startY + (2 * tableHeight) + 100, tableWidth,tableHeight);

            g.setColor(Color.BLACK);
            g.drawString(asci.name, startX + i * (tableWidth + gap) + 10, startY + (2 * tableHeight) + 120);

            if(siparisListesi.isEmpty()){
                g.drawString("beklemede.",startX + i * (tableWidth + gap) + 10, startY + (2 * tableHeight) + 140);
            }else{
                if(siparisListesi.size() == 2){
                    g.drawString(siparisListesi.get(0).name + ", ", startX + i * (tableWidth + gap) + 10, startY + (2 * tableHeight) + 140);
                    g.drawString(siparisListesi.get(1).name + "'in", startX + i * (tableWidth + gap) + 10, startY + (2 * tableHeight) + 160);
                    g.drawString("siparişini hazırlıyor.", startX + i * (tableWidth + gap) + 10, startY + (2 * tableHeight) + 180);
                }else {
                    g.drawString(siparisListesi.get(0).name + "'in", startX + i * (tableWidth + gap) + 10, startY + (2 * tableHeight) + 140);
                    g.drawString("siparişini hazırlıyor.", startX + i * (tableWidth + gap) + 10, startY + (2 * tableHeight) + 160);
                }
            }
        }

        Kasiyer kasiyer = Restaurant.kasiyer;
        Musteri bekleyenMusteri = kasiyer.odemeAldigiMusteri;

        Color kasiyerLabel = kasiyer.odemeAliyor ? Color.GREEN : Color.RED;

        g.setColor(kasiyerLabel);
        g.fillRect(50, startY + (3 * tableHeight) + 150, tableWidth,tableHeight);

        g.setColor(Color.BLACK);
        g.drawRect(50, startY + (3 * tableHeight) + 150, tableWidth,tableHeight);

        g.setColor(Color.BLACK);
        g.drawString("Kasiyer", 60, startY + (3 * tableHeight) + 170);

        if(bekleyenMusteri == null && !kasiyer.odemeAliyor){
            g.drawString("beklemede.",60,540);
        }else if(bekleyenMusteri != null && kasiyer.odemeAliyor){
            g.drawString(bekleyenMusteri.name + "'in",60,540);
            g.drawString("ödemesini alıyor.",60,560);
        }
    }
}
