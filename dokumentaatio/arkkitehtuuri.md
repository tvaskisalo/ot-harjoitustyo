## Ohjelman rakenne:

![alustavarakenne](https://user-images.githubusercontent.com/61991314/80482207-77e95b80-895c-11ea-9ff3-cfb20d10e83f.PNG)

Pakkaus exerciseapp.ui sisältää käyttöliittymän koodin ja exerciseapp.dao sisältää tietokannan kanssa kommunikointiin relevantin koodin.
Pakkaus exerciseapp.logic sisältää kaikki tehtävien tekemiseen liittyvän koodin.

## Käyttöliittymä

Käyttöliittymässä on neljä eri näkymää:

* Kirjautuminen
* Tehtävien valinta
* Tehtävien tekeminen
* Omien tehtävien luonti

Käyttöliittymässä kirjautuminen, tehtävien valinta ja omien tehtävien luonti ovat eri scene-oliot. Tehtävien tekeminen ja valinta ovat taas samassa scene-oliossa. Nämä oliot ovat kiinni toisessa scene-oliossa, joka toimii ns. "pohjana" sovellukselle. Siihen on myös laitettu main menu-nappi, sekä käyttäjään liittyvä data.

Kun siirrytään tehtävien tekemiseen, tai omien tehtävien luontiin, vaihdetaan "pohjan" keskiosion scene-olio, jossa voidaan säilyttää helposti käyttäjän data, sekä main menu-nappi.

Käyttöliittymään päivittyy automaattiseti käyttäjän data, kun käyttäjä suorittaa tehtäviä. 

## Sovelluslogiikka

### Tehtävien tekeminen
Sovelluslogiikka  toimii seuraavan luokka- ja sekvenssikaavion mukaisesti:

![Luokkakaavio](https://user-images.githubusercontent.com/61991314/78663897-9dde8b80-78db-11ea-8596-780515a13414.PNG)
![Sekvenssikaavio](https://user-images.githubusercontent.com/61991314/79860551-80311c00-83db-11ea-82f2-3123de7af3a8.PNG)

Tehtäviä tehdessä aluksi sovellus generoi rajapinnan exercise toteuttavien luokkien avulla kysymyksen. 
Käyttöliittymä kysyy kysymyksen käyttäjältä ja välittää käyttäjän vastuksen kysymyksen generoineelle luokalle, joka tarkistaa vastauksen.
Nyt käyttöliittymä reagoi sen mukaan, oliko vastaus oikein vai ei.
Kun käyttäjä haluaa oikean vastauksen, käyttöliittymä kysyy valitulta luokalta oikean vastauksen. Luokka palauttaa sen käyttöliitymälle, joka näyttää sen käyttäjälle.

### Omien tehtävien luonti
Sovelluslogiikka on suoraviivainen, joten en esitä kaavioita, vaan esitän kaaviot sanallisesti.
Kun käyttäjä painaa aloitusruudussa nappia "Create custom exercise", sovellus luo uuden CustomExerciseUi-olion, jolle sovellus välittää käytettävän Database-olion. Käyttäjä syöttää tekstikenttiin kysymyksen ja vastauksen ja sitten CustomExerciseUi-olio välittää merkkijonot Database-oliolle, joka lisää ne tietokantaan.

## Datan tallennus
Pakkauksen exerciseapp.dao luokka DataDao antaa rajapinnan, jonka kautta luokat voivat tallentaa ja hakea tietoa. Sovelluksessa on luokka Database, joka toteuttaa rajapinnan DataDao. Database-luokka käyttää tietojen tallentamiseen SQLite-tietokantaa. Kun sovellus käynnistetään ensimmäisen kerran, se luo uuden tiedoston, johon se kirjoittaa dataa ja josta se lukee dataa. Kyseinen tiedosto on automaattisesti nimetty "usedata.db".

Sillä luokka noudattaa Data Access Object - suunnittelua, niin voidaan tehdä muita toteutuksia tietojen tallentamiseen, ilman että tarvitsee muokata sovelluslogiikkaa muualla. 

## Ohjelman heikkoudet rakenteelliesti

### Käyttöliittymä

Käyttöliittymässä on koodia, joka oikeastaan kuuluisi sovelluslogiikkaan, luokissa ExerciseUi ja CustomExerciseUi. Sovelluslogiikan täydellinen eriyttäminen olisi suotavaa, jotta voitaisiin tehdä helposti muutoksia sovelluslogiikkaan, ilman että täytyisi koskea käyttöliittymän koodiin.

### Tietojen tallennus

Tietojen tallentamisesta vastaa ainoastaan DataDao-rajapinta, jonka luokka Database toteuttaa. Kuitenkin DataDao-rajapinta voitaisiin muuttaa kahdeksi rajapinnaksi, esimerkiksi: UserDao-rajapinta, joka olisi vastuussa käyttäjien tietojen tallentamisesta (nimi, pisteet ja tehdyt tehtävät), sekä CustomExerciseDao-rajapinta, joka olisi vastuussa käyttäjien omatekemien tehtävien tallentamisesta.

Tämä olisi hyödyllistä, sillä nyt voitaisiin tehdä eri luokat, jotka toteuttavat nämä rajapinnat. Tällöin voitaisiin muuttaa esimerkiksi käyttäjien omatekemien tehtävien tallennusta ilman, että tarvitsee ottaa huomioon käyttäjien tietojen tallennusta. Hyvä käytännön esimerkki olisi jos halutaan tehdä niin, että olisi sivusto, josta voisi ladata käyttäjien omatekemiä tehtäviä. Tällöin olisi hyödyllistä tehdä omatekemien tehtävien tallennus internettiin, mutta voitaisiin kuitenkin pitää käyttäjien oma data tietokoneen tiedostona.

