## Käyttöohje
Lataa tiedosto [ExerciseApp2](https://github.com/tvaskisalo/ot-harjoitustyo/releases/download/2/ExerciseApp2.0.jar)

## Konfigurointi
Ohjelmaa ei tarvitse erikseen konfiguroida, kunhan on ladattuna maven ja java 1.8

## Ohjelman käyttö

### Käynnistys
Ohjelma käynnistyyy komennolla 
````
java -jar ExerciseApp2.0.jar 
````

### Kirjautuminen
Ohjelma muistaa käyttäjiä eri käyttäjänimien pohjalta. Ohjelma kysyy ensimmäisenä käyttäjänimeä:
![Kirjautuminen](https://user-images.githubusercontent.com/61991314/80472616-a1e75180-894d-11ea-9e14-170490a63055.PNG)

Jos sinulla on jo olemassa oleva käyttäjänimi voit kirjoittaa sen suoraan tekstikenttään ja ohjelma muistaa tehtyjen tehtävien määrän ja oikeat vastaukset.
Jos et ole koskaan käyttänyt ohjelmaa, voit kirjoittaa haluamasi käyttäjänimen tekstikenttään.

### Tehtävien tekemisen aloittaminen
Kun olet valinnut käyttäjänimen pääset seuraavaan näkymään:
![menu](https://user-images.githubusercontent.com/61991314/80472650-af9cd700-894d-11ea-81cf-64cc15aca05f.PNG)

Tästä voit valita haluamasi tehtävän seuraavista: Algebra, Functions ja Vectors.
Algebra tehtäväsarjassa pääset laskemaan yksinkertaisia pluslaskuja.
Functions tehtäväsarjassa pääset ratkaisemaan eri funktioiden arvoja eri pisteissä.
Vectors tehtäväsarjassa pääset ratkaisemaan eri vektoreiden pistetuloja.

Näet myös kokoajan alapalkissa käyttäjänimen, pisteesi ja onnistumisprosentin.
Yläkulmassa olevasta napista "Main menu" pääset takaisin tehtäväsarjojen valintaan.

### Tehtävien tekeminen
Käytän tässä esimerkkinä tehtäväsarjan Algebra tehtävää, mutta ohje toimii kaikille tehtäväsarjoille.

Kun valitset tehtäväsarjan pääset näkymään, joka näyttää suunnilleen seuraavalta:

![Tehtavanteko](https://user-images.githubusercontent.com/61991314/80472693-c0e5e380-894d-11ea-8e5b-ee9a70967f69.PNG)


Näkymässä on annettu kysymys, vastauslaatikkoa ja kaksi nappia. Nappi "Check answer" tarkistaa onko tehtävän vastaus oikein vai ei.
Jos vastaus on oikein, ohjelma antaa pisteen.

![oikein](https://user-images.githubusercontent.com/61991314/80472715-c5aa9780-894d-11ea-9a95-8761c7abcfa7.PNG)

Jos vastaus on väärin, ohjelma ilmoittaa että vastaus on väärin. Voit kuitenkin koittaa vastata tehtävään uudelleen.

![vaarin](https://user-images.githubusercontent.com/61991314/80472723-c9d6b500-894d-11ea-9bbf-47f9da17f0c1.PNG)

Kun olet vastannut tehtävään kerran (ei väliä oliko vastaus oikein vai väärin) voit painaa nappia "show answer", josta näät oikean vastuksen. 
Kuitenkin et voi enää nappia painettua vastata kysymykseen.

![show](https://user-images.githubusercontent.com/61991314/80472749-d2c78680-894d-11ea-80bc-202b806c8562.PNG)

Jos haluat tehdä lisää tehtäviä, voit painaa napista "Generate a new question", jolloin ohjelma generoi uuden tehtävän.
Tai voit vaihtoehtoisesti palata tehtävien valintaan painamalla nappia "main menu".
