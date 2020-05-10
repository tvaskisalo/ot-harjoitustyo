# Testausdokumentti
Sovellusta on testattu manuaalisesti, sekä tehdyillä testeillä automaattisesti JUnitilla.

## Automaattinen JUnit testaus

### Logiikka
JUnit testit AlgebraTest, FunctionTest ja VectorTest ovat yksilötestejä luokille Algebra, Function ja Vector. Näillä testeillä pyritään testaamaan kaikkia luokkien metodeita, jotta ne toimivat oikein ja halutusti. Etenkin niissä on keskitytty siihen, mikä on olennaisinta käyttöliittymän näkökulmasta. 
JUnit testi CustomExerciseTest testaa luokan CustomExercise metodeita, sekä osittain sen toimivuutta rajapinnan DataDao kanssa. Testissä luodaan testejä varten oma tietokantatiedosto, jotta ei sotketa sovelluksen käyttämää tietokantatiedostoa.

### DAO
Rajapinnan DataDao toteuttavan luokan DataBase testaus on tehty testillä DatabaseTest. Testissä luodaan toinen testitietokantatiedosto, jonka avulla voidaan testata luokan DataBase toimivuutta.

### Testikattavuus
Jos ei oteta Main-luokkaa tai käyttöliittymäluokkia testaukseen mukaan, niin rivikattavuus on 92% ja haarautumakattavuus 86%

![testikattavuus](https://user-images.githubusercontent.com/61991314/81503518-ab2cd280-92ec-11ea-8325-d88300f52c2c.PNG)


Testeissä ei testattu gettereitä, eikä tilanteita, joita ei tapahdu, jos ohjelma toimii oikein (kuten catch() tilanteet). Myös testeistä uupuu joitain integraatiotestejä, kuten Exercise-rajapinnan toteuttavien luokkien ja Database-luokan integraatiotestaus.

## Manuaalinen järjestelmän testaus

### Asennus
Sovellus on testattu toimivan käyttöohjeeen mukaan.
Testattiin myös tilanteet, jossa tietokantatiedostot ovat olleet olemassa ja tilanne, joss sovellus joutuu tekemään ne itse.

### Toiminnallisuus
Sovellusta on testattu, niin että on testattu kaikki ![määrittelydokumentin](https://github.com/tvaskisalo/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) mainistemat toiminnallisuudet kaikilla mahdollisilla syötteillä. (Tyhjä vastauskenttä, liian pitkät vastaukset tai kirjaimia kohtiin, jotka haluaa vain numeroita).

