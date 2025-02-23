# Restoran Yönetim Sistemi 

Bu proje, **Java** programlama dili kullanılarak geliştirilmiş bir **restoran yönetim sistemi simülasyonu**dur. Uygulama, çoklu iş parçacıkları (multithreading) ve senkronizasyon tekniklerini kullanarak bir restoranın günlük işleyişini gerçek zamanlı olarak simüle eder.

##  Özellikler

-  **Müşteri Yönetimi**: Öncelikli ve önceliksiz müşteriler oluşturulur ve masalara yerleştirilir.
-  **Masa Yönetimi**: Masaların doluluk durumu takip edilir, boş masalara yeni müşteriler oturtulur.
-  **Garson İşlemleri**: Siparişleri alır ve aşçılara iletir.
-  **Aşçı İşlemleri**: Siparişleri hazırlar ve garsonlara teslim eder.
-  **Kasiyer İşlemleri**: Müşterilerin ödemelerini alır.
-  **Grafiksel Arayüz (Swing)**: Restoranın anlık durumu görsel olarak takip edilebilir.
-  **Optimizasyon (Brute Force Algoritması)**: Maksimum karı sağlamak için masa, garson ve aşçı sayıları optimize edilir.

## 🛠 Kullanılan Teknolojiler

- **Java** – Projenin geliştirme dili
- **Swing** – Grafiksel kullanıcı arayüzü
- **Multithreading** – Gerçek zamanlı iş parçacığı yönetimi
- **BlockingQueue** – Senkronizasyon için veri yapısı

##  Kurulum

1. Bu depoyu klonlayın:
   ```bash
   git clone https://github.com/kullaniciadi/restoran-yonetim-sistemi.git
