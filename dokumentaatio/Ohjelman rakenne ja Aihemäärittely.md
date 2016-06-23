**Aihe:** Pöytälätkäpelien hallinnointi ja tilastojen ylläpito. Ohjelma ylläpitää pelaajien välistä sarjataulukkoa, ja suorittaa peleissä
tarvittavat toiminnot:  ajanoton, äänimerkit ja otteluiden merkitsemisen sarjataulukkoon. 

Tarkoituksena on helpottaa pöytäjääkiekkopelien pelaamista ilman paikallaolevaa tuomaria. Ottelun alussa ohjelma laskee ensimmäisen aloituksen,
mittaa aikaa, ilmoittaa viimeisen hetken lähestyessä loppuaan, ja pelin loputtua tallentaa tulokset 
sarjataulukoihin, joista pelaajien välisiä turnauksia on helppo seurata ja ylläpitää.

**Käyttäjä:** "Turnausisäntä"

**Toiminnot:** 
  - Select Standings: Avaa uuden ikkunan, jossa mahdollisuus valita valmiiksiolemassaoleva sarjataulukko tai luoda uuusi
    - Vasemmalta puolelta valitaan listalta haluttu sarjataulukko ja painetaan select
    - Vaihtoehtoisesti kirjoitetaan tekstikenttään sarjataulukon nimi ja painetaan create, jolloin siitä tulee uusi sarjataulukko.
  - Add Player: Mikäli Current Standing on valittuna, lisätään pelaaja sarjataulukkoon uudessa ikkunassa kirjoittamalla pelaajan nimi ja painamalla Create Player Nappia. 
  - New Game: Luo uuden pelin, Kysyy pelaajien nimiä ja hakee ne sarjataulukosta, vaihtoehtoisesti luo uuden pelaajan sarjataulukkoon
    mikäli pelaajaa ei siellä ole. Tarkistaa myös ettei pelaaja pelaa itseä vastaan
    - Ohjelma ylläpitää itse ajanoton, antaa merkkiäänet ja tallentaa automaattisesti pelin päätyttyä tulokset. 
  -  Show Standings: Mikäli Current Standings on asetettuna, näytetään uudessa ikkunassa tämän hetken sarjataulukon tilanne
     - sarjataulkoita ylläpidetään Serializablen avulla, mikä tallentaa .ser muodossa sarjataulukot suoraan oliomuodossa.
  - Save Standings: Tallentaa sarjataulukon kansioon myöhempää käyttöä varten
  - Quit: Poistuu ohjelmasta
  


###Luokkakaavio
![Määrittelyvaiheenluokkakaavio](http://yuml.me/6caf1ddd)

###Rakennekuvaus###
  Ohjelmaa suorittaessa ensimmäisenä näkyy GUI; se toimii päävalikkona 
  Sarjataulukoita valitaan ja luodaan uusia GUIn Select standings napin avulla.
  Pelaajia myös lisätään GUIn Inputdialogin avulla sarjataulukkoon (Standings) 
  Uutta peliä aloittaessa GUI luo uuden logiikan ja lähettää sinne kaksi pelaajaa String muodossa, käyttämänsä sarjataulukon
  ja itsensä. Logiikka luo konstruktorissa tuomarin (Referee) ja välittää itsensä, pelaajat, sarjataulukon ja GUI:n tuomarille.  Logiikka odottaa StartTimerListeneriltä actionia, jolloin logiikan startGame(int Seconds) kutsutaan. Tämä kutsuu tuomarin Startgame metodia mikä itsessään aloittaa pelin. Pelin edetessä GUI pyytää jäljelllä olevaa aikaa logiikalta ja päivittää sen ScoreboardFrameen.
  

  Tuomari luo udpatables listan, mikä koostuu Updatables rajapintaa käyttävistä luokista, jonka se lähettää TimerListenerille.TimerListener actioneventissään päivittää nämä updatablet, tällä hetkellä GUI ja Logic.
  Tuomari käyttää myös SoundPlayer luokkaa toistamaan ääniä.
  Tuomari tuntee pelaajat ja sarjataulukon, ja kun peli on loppu tuomari huolehtii että pelaajat saavat pisteet.
  
  Standingsit tallennetaan DataStoragen avulla myöhempää käyttöä varten. Standingslist listaa kaikki sarjataulukot mitkä
  ovat aikaisemmin tallennettu.
  
  

###Sekvenssikaaviot

Ensimmäinen kaavio käsittelee Sitä hetkeä, kun New Game nappia on painettu. 
![Sekvenssi1](https://github.com/Antiik91/Tablehockey-gamehandler/blob/master/dokumentaatio/newGameButtonPressedSeq.png)

Seuraava kaavio käsittelee kun Start Game nappia on painettu. Peli lähtee käyntiin ja mitä sen aikana tapahtuu logiikassa
![Sekvenssi2](https://github.com/Antiik91/Tablehockey-gamehandler/blob/master/dokumentaatio/scoreboardupdatewithlogic.png)
