# TestEngine

1. Ssh client üzerinden smyrna linux makinasına bağlanılır.
2. Giriş yapıldığında mevcut dizin "/home/ubuntu" olacaktır. Burdan "cd testsuite" komutu ile çalıştırılacak programın olduğu dizine geçilri.
3. Bu dizin altına, ftp client ile konfigürasyon xml dosyası smyrna-testsuite-configuration.xml ismi ile atılır. Eğer konfigürasyon dosyası atılmaz ise program otomatik modda çalışacaktır. Eğer atılan xml yapısında hata var ise program çalışma aşamasında hata verecektir.
4. java -cp test-engine-1.0-SNAPSHOT-jar-with-dependencies.jar smyrna.tester.TestLoader komutu ile program çalıştırılır.
5. Program tamamlandıktan sonra oluşan logs dizini altındaki output xml dosyası kontrol edilir.
6. Üretilen veri couchbase üzerine ulaşmadıysa storm arayüzüne giriş yapılarak topolojilerde hata olup olmadığı kontrol edilir.
7. Detaylı bilgi için docker ps komutu ile storm supervisor container ları bulunarak, contaier içinde yer alan log dosyaları kontrol edilir.
