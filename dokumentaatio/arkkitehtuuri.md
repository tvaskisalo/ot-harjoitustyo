## Alustava ohjelman rakenne:

![alustavarakenne](https://user-images.githubusercontent.com/61991314/80482207-77e95b80-895c-11ea-9ff3-cfb20d10e83f.PNG)

Pakkaus exerciseapp.ui sisältää käyttöliittymän koodin ja exerciseapp.dao sisältää tietokannan kanssa kommunikointiin relevantin koodin.
Pakkaus exerciseapp.logic sisältää kaikki tehtävien tekemiseen liittyvän koodin.

## Käyttöliittymä

Käyttöliittymässä on kolme eri näkymää:

* Kirjautuminen
* Tehtävien valinta
* Tehtävien tekeminen

Käyttöliittymässä kirjautuminen ja tehtävien valinta on eri scene-oliot. Tehtävien tekeminen ja valinta on taas samassa scene-oliossa.
Kuitenkin kun siirrytään tehtävien tekemiseen vaihdetaan scenen keskiosio erilaiseksi, jotta voidaan säilyttää käyttäjän data, sekä main menu nappi helposti.

Käyttöliittymä on pyritty eriyttämään sovelluslogiikasta, mutta nyt luokka exerciseUi tekee myös sovelluslogiikkaa, joka pyritään eriyttämään ennen lopullista julkaisua.

## Sovelluslogiikka
Sovelluslogiikka toimii seuraavan luokka- ja sekvenssikaavion mukaisesti:

![Luokkakaavio](https://user-images.githubusercontent.com/61991314/78663897-9dde8b80-78db-11ea-8596-780515a13414.PNG)
![Sekvenssikaavio](https://user-images.githubusercontent.com/61991314/79860551-80311c00-83db-11ea-82f2-3123de7af3a8.PNG)

Tehtäviä tehdessä aluksi sovellus generoi rajapinnan exercise toteuttavien luokkien avulla kysymyksen. 
Käyttöliittymä kysyy kysymyksen käyttäjältä ja välittää käyttäjän vastuksen kysymyksen generoineelle luokalle, joka tarkistaa vastauksen.
Nyt käyttöliittymä reagoi sen mukaan, oliko vastaus oikein vai ei.
Kun käyttäjä haluaa oikean vastauksen, käyttöliittymä kysyy valitulta luokalta oikean vastauksen. Luokka palauttaa sen käyttöliitymälle, joka näyttää sen käyttäjälle.
