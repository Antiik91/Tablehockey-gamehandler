**HUOM** Aja ohjelma käyttämällä komentoriviä:
  - Ensiksi mene sijaintiin (esim) cd git/Tablehockey-gamehandler/HockeyGameHandler/
  - Aja ohjelma suorittamalla komento java -jar HockeyGameHandler-1.0-SNAPSHOT.jar
  - Pidä huolta, että kansiot saved_files ja music ovat samassa paikassa kuin jar, mikäli siirrät niitä paikasta toiseen
  
Avatessasi ohjelman näytetään ensimmäiseksi aloitusvalikko. Mikäli Current Standings tekstikenttä on tyhjä, sinun tulee
valita sarjataulukko Select Standings näppäimestä. 

##Aloitusvalikon sisältö##

###Select Standings###
  Painamalla Select Standings nappia ohjelma avaa uuden ikkunan, jonka vasemmalta puolelta löytyy lista jo olemassa olevia
  sarjataulukoita, ja oikealta löytyy tekstikenttä, johon kirjoittamalla voit luoda uuden sarjataulukon
  - Lista
    - Valitse listasta haluamasi sarjataulukko klikkaamalla sen nimeä, ja painamalla listan alapuolelta select näppäintä
  - Uusi
    - Kirjoita haluamasi nimi tyhjään tekstikenttään ja paina create näppäintä. Mikäli tekstikenttä on tyhjä luodaan uusi
    sarjataulukko nimeltä Unnamed Standings.
  
  ###Add Player###
    Painamalla Add Player nappia tulee uusi tekstikenttä joka kysyy pelaajalle nimeä. Kirjoita nimi ja paina OK luodaksesi 
    sarjataulukkoon uuden pelaajan. Tyhjää pelaajaa ei voi luoda joten muista kirjoittaa nimi! 
    
  ###New Game###
    New Game nappi kysyy ensiksi kahta pelaajaa sarjataulukosta. Kirjoita pelaajien nimet, sarjataulukosta haetaan
    automaattisesti pelaajat(Mikäli kirjoitit vahingossa pelaajan nimen pienellä/isolla, ei haittaa, ohjelma osaa hakea automaattisesti
    pelaajan silti.) ja mikäli niitä ei löydy, luodaan uudet pelaajat sarjataulukkoon tässä vaiheessa.
    
      - Painamalla Cancel peruutetaan pelin aloitus.
    
    Kun pelaajat on haettu avataan uusi ikkuna, josta painamalla start aloitetaan peli. Tuomari laskee viidestä alaspäin
    ja sen jälkeen peliaika lähtee laskemaan kohti nollaa. Tuomari varoittaa pelin viimeisestä minuutista ja
    pelin päättymisestä.
    
    Pelin päättyessä kysytään pelaajien tulokset, aseta tehdyt maalit pelaajille. Ne tallennetaan sarjataulukkoon.
    **MUISTA TALLENTAA TULOKSET PÄÄVALIKOSTA**
    
  ###Show Standings###
     avaa ja näyttää sarjataulukon tilanteen.
    
  ###Save Standings###
    Tallentaa sarjataulukon tilanteen saved_files kansioon. Voit jatkaa sarjataulukon käyttöä myös myöhemmin
    tämän jälkeen.
    
  ###Quit###
    Sulkee ohjelman
  
