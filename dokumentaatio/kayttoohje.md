## Käyttöohje
Lataa tiedosto [ExerciseApp](https://github.com/tvaskisalo/ot-harjoitustyo/releases/download/final/ExerciseApp.jar)

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

![menu](https://user-images.githubusercontent.com/61991314/81474517-a134a200-920e-11ea-9581-99165c20d2cd.PNG)

Tästä voit valita haluamasi tehtävän seuraavista: Algebra, Functions ja Vectors.
Algebra tehtäväsarjassa pääset laskemaan yksinkertaisia pluslaskuja.
Functions tehtäväsarjassa pääset ratkaisemaan eri funktioiden arvoja eri pisteissä.
Vectors tehtäväsarjassa pääset ratkaisemaan eri vektoreiden pistetuloja.
Custom tehtäväsarjassa pääset tekemään omatekemiä tai toisten käyttäjien tekemiä tehtäviä.

Nappiin "Create custom exercise" paneudutaan osiossa "Oman tehtävän luonti"

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

### Oman tehtävän luonti
Jos valitsee alkuruudusta painikkeen "Create custom exercise" pääsee seuraavaan näkymään:

![Custom](https://user-images.githubusercontent.com/61991314/81474511-9bd75780-920e-11ea-9fef-5059cffd471b.PNG)

Tässä voit lisätä oman tehtäväsi sovellukseen. Kirjoita vasemmanpuoleiseen tekstikenttään haluamasi kysymys ja oikeanpuoleiseen tekstikenttään kysymyksen oikea vastaus. Huomioi, että kysymyksen ja vastuksen pituus voi olla maksimissaan 50 merkkiä.

![create](https://user-images.githubusercontent.com/61991314/81474507-9712a380-920e-11ea-8ed3-fc21f0ac3040.PNG)

Jos haluat lisätä tehtävän sovellukseen paina nappia "Add exercise". Jos kysymys ja vastaus olivat oikean pituisia, sovellus kertoo, että tehtävä on lisätty.

![added](https://user-images.githubusercontent.com/61991314/81474504-92e68600-920e-11ea-96cb-ead56c6616fb.PNG)

Jos kuitenkin laitoit liian pitkän kysymyksen tai vastauksen tai toinen tekstikentistä oli tyhjä, antaa sovellus virheilmoituksen.

![long](https://user-images.githubusercontent.com/61991314/81474497-895d1e00-920e-11ea-8a32-e388ae25d174.PNG)

Esimerkissä kysymys oli "Onko sataviisikymmentätuhattakolmesataayksi liian pitkä kysymyslause?", joka on liian pitkä.

Kun olet lisännyt tehtävän sovellukseen, voi tehtävä tulla vastaan, kun tekee tehtäväsarjan "Custom" tehtäviä. Se arpoo satunnaisesti tehtäviä kaikkien käyttäjien tekemistä tehtävistä.



