# airportsystemproject
With using Java,Maven,Spring Boot,Hibernate and H2 Database

● Havayolu şirketi eklenebilmeli, aranabilmeli.

● Havaalanı eklenebilmeli, aranabilmeli.

● Rota eklenebilmeli, aranabilmeli.

● Havayolu şirketine uçuş tanımlanabilmeli, aranabilmeli.

● Bilet satın alınabilmeli,

○ Satın alma işlemi sırasında kredi kartı bilgileri maskelenmeli. ( Örneğin “4221161122330005” -> “422116******0005”).
○ Burada kredi kart numarasının aralarında boşluklar ya da ayraçlar olması gibi durumları da kapsayacak şekilde geliştirme yapılmalı. Örn; Request’te kart numarası farklı formatlarda da gelse (Önr; “4221-1611-2233-0005” , “4221,1611,2233,0005”) kart bilgisi beklenen şekilde (“422116******0005”) maskelenerek satın alma işlemine alınmalı.
○ Uçuş kontenjanın her %10 artışında, bilet fiyatı da %10 arttırılmalı.

● Bilet numarası ile arama yapılabilmeli ve bilet iptali yapılabilmeli.
