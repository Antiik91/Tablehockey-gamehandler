Pit testikattavuus jäi alhaiseksi DataStorage, StandingList, Logic ja Referee luokista. Lisäksi jätin PlaySound luokan testien ulkopuolelle


Syy näihin löytyy tiedostojenkäsittelystä. Referee luokka kärsii countdown() metodin Thread.sleepin testien puutteesta, sekä StartGame
metodin ja speak metodin testien puutteesta. Nämä metodit käyttävät tiedostonkäsittelyä hyväksi, ja speak() äänitiedostojen toistoa.

DataStorage ja StandingList molemmilla on tiedostojen kirjoittamiseen liittyviä metodeja, jotka jäivät automaattisesti testaamatta.
Varsinkin metodien sisältä luodut Filet, input ja outputstreamit.

Logiikasta jäi pääosin refereetä koskevat, äänentoistoa ja ottelun aloitusta koskevat metodit alhaiseksi.

Jokainen näistä osista on itse ohjelman toimivuuden kannalta kuitenkin elintärkeitä. Ilman sarjataulukoiden tallennus ja hakuominaisuuksia
ei tämä ohjelma täyttäisi tarpeita, mitä tämä projektin alussa määriteltiin. Näitä luokkia on testattu joka toistokerralla niiden luonnista alkaen,
ja olen pitänyt huolta, että nämä ominaisuudet toimivat. 

Sama periaate PlaySoundilla, ja refereen kanssa. Kaikki metodit, jotka ovat jääneet punaiselle ovat käytössä joka ikinen kerta
kun ohjelmassa aloitetaan peli, ja on oleelista, että ne toimivat niinkuin pitääkin. Samalla periaatteella pitkin kurssia olen
ajanut ohjelmaa ja varmistanut käsin että nämä toimivat.


**Checkstylestä**
Checkstylen virheet tulevat pelaajan yli 200 rivin koodista. Tämä tuli siitä syystä, kun CheckStyle aikaisemmin valitteli javadocin puuttumisista gettereille ja settereille, jotka tarkistaa että arvot ovat ei negatiivisia. Kun nämä lisäsin  (Ohjeissa oli että ei tarvitse ellei tee mitään ihmeellistä -- ilmeisesti ylitti vaatimuksen siinä ) ohjelman koodirivimäärä ylittyi.

Toinen virhe tulee nested if lauseista. Valitettavasti tuo on tietääkseni ainoa tapa varmistaa, että Pelaajan paikka sarjataulukosta on oikein on nuo if lauseet, joista viimeinen tarkistaa myös kriteerillä, kuinka monta peliä on pelattu.
