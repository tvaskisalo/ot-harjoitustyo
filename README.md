# Ohjelmistotekniikka
## Dokumentaatio
[Vaatimusmäärittely](https://github.com/tvaskisalo/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/tvaskisalo/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/tvaskisalo/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

## Komentorivitoimintoja

### Testit voidaan suorittaa komennolla 

mvn test

### Testikattavuus komennolla

mvn test jacoco:report

### Suoritus komennolla

mvn compile exec:java -Dexec.mainClass=exerciseapp.Main

### Jar:in generointi

mvn package

### Checkstylen generointi

jxr:jxr checkstyle:checkstyle
