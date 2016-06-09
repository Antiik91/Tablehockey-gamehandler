**Aihe:** Pöytälätkäpelien hallinnointi ja tilastojen ylläpito. Ohjelma ylläpitää pelaajien välistä sarjataulukkoa, ja suorittaa peleissä
tarvittavat toiminnot:  ajanoton, äänimerkit ja otteluiden merkitsemisen sarjataulukkoon. 

Tarkoituksena on helpottaa pöytäjääkiekkopelien pelaamista ilman paikallaolevaa tuomaria. Ottelun alussa ohjelma laskee ensimmäisen aloituksen,
mittaa aikaa, ilmoittaa viimeisen hetken lähestyessä loppuaan, ja pelin loputtua tallentaa tulokset sekä pelaajien omiin pelaajahistorioihin että
sarjataulukoihin, joista pelaajien välisiä turnauksia on helppo seurata ja ylläpitää.

**Käyttäjä:** "Turnausisäntä"

**Toiminnot:** 
  - Select Standings: Avaa uuden ikkunan, jossa mahdollisuus valita valmiiksiolemassaoleva sarjataulukko tai luoda uuusi
    - Vasemmalta puolelta valitaan listalta haluttu sarjataulukko ja painetaan select
    - Vaihtoehtoisesti kirjoitetaan tekstikenttään sarjataulukon nimi ja painetaan create, jolloin siitä tulee uusi sarjataulukko.
  - Add Player: Mikäli Current Standing on valittuna, lisätään pelaaja sarjataulukkoon uudessa ikkunassa kirjoittamalla pelaajan nimi ja painamalla Create Player Nappia. 
  - New Game: Luo uuden pelin ( Ei vielä toiminnassa) 
    - Ohjelma ylläpitää itse ajanoton, ja tallentaa automaattisesti pelin päätyttyä tulokset.
  -  Show Standings: Mikäli Current Standings on asetettuna, näytetään uudessa ikkunassa tämän hetken sarjataulukon tilanne
     - sarjataulkoita ylläpidetään Serializablen avulla, mikä tallentaa .ser muodossa sarjataulukot suoraan oliomuodossa.
  - Save Standings: Tallentaa sarjataulukon kansioon myöhempää käyttöä varten
  - Quit: Poistuu ohjelmasta
  


###Luokkakaavio
![Määrittelyvaiheenluokkakaavio](http://yuml.me/91322b8b)
