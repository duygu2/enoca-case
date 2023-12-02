# enoca-case

Bu proje, Java Spring Boot ile geliştirilmiş bir uygulamadır. Enoca şirketinin case'dir. 
Şirket ve personel arasında ilişiki gösteren bir uygulamadır.

## Başlangıç


### Gereksinimler

- Java 17
- Spring Boot 3.1.2 v
- MySQL Workbench

### Kurulum

1. Bu depoyu yerel makinenize klonlayın.

    ```bash
    git clone https://github.com/duygu2/enoca-case.git
    ```

2. Proje dizinine gidin.

    ```bash
    cd enoca-case
    ```

3. Uygulamayı başlatın.


    ```bash
    mvn spring-boot:run
    ```


4. Tarayıcınızda `http://localhost:8080` adresine giderek uygulamayı görüntüleyin.

5. Postmanda `http://localhost:8080` adresine istek atarak uygulamayı görüntüleyin.

## İlişki Diyagramı

Bu uygulama, "1-N ilişkisi" olarak adlandırılan bir ilişkiyi temsil etmektedir. Bu ilişki, bir şirketin birden fazla personele sahip olabileceğini ancak her personelin yalnızca bir şirkete ait olabileceğini gösterir. Yani, bir şirketin çok sayıda personeli olabilirken, her personel sadece bir şirkete bağlıdır.

![image](https://github.com/duygu2/enoca-case/assets/56012686/1ed734e5-46f1-4bf3-b6fe-7fceb1f40f65)


## İstekler ve Çıktılar

### GET `/personnel/2`
- Açıklama: Personel ID'si 2 olan kişiyi getirir.
- Postman Ekran Görüntüsü: ![image](https://github.com/duygu2/enoca-case/assets/56012686/78aa7fc9-e373-41f0-aa8d-a6e6cf45a5aa)
  
### PUT `/personnel/2`
- Açıklama: Personel ID'si 2 olan kişinin güncellenmesi.
- Postman Ekran Görüntüsü:![image](https://github.com/duygu2/enoca-case/assets/56012686/a060a1f3-d24b-464c-b27b-8594e216defd)

### GET `/company/1/personnel`
- Açıklama: Şirket ID'si 1 olan şirketin personellerini getirir.
- Postman Ekran Görüntüsü:  
 ![image](https://github.com/duygu2/enoca-case/assets/56012686/bdf82591-8c05-49da-9640-9badecf9a0e7)

### POST `/company/2/personnel`
- Açıklama: Şirket ID'si 2 olan şirketin personellerini getirir.
- Postman Ekran Görüntüsü:![image](https://github.com/duygu2/enoca-case/assets/56012686/0afba347-f413-45ab-ad52-c94e9a39d02d)

### DELETE `/company/3`
- Açıklama: Şirket ID'si 3 olan şirketin silinmesi.
- Postman Ekran Görüntüsü: ![image](https://github.com/duygu2/enoca-case/assets/56012686/ad20a192-8b69-4fb1-ab78-cc25aecb2335)



