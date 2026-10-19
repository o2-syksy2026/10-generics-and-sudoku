> [!NOTE]
> The English translation for this exercise can be found in [this file](./readme.en.md).

# Geneeriset tyypit ja Sudoku-peli

![Geneerinen Grid-ruudukko Sudoku-pelin pohjana: sama Grid voi sisältää numeroita, merkkijonoja tai muita olioita](img/chapters/sudoku.svg)

Tämän harjoitustehtäväpaketin myötä opit määrittelemään geneerisiä metodeja ja luokkia. Aluksi luodaan yleiskäyttöisiä metodeja, joilla voidaan käsitellä eri tyyppistä dataa toistamatta ohjelmalogiikkaa eri tyypeille. Tehtävät etenevät oman kaksiulotteisen kokoelman ([Grid](./src/main/java/grid/Grid.java)) toteuttamiseen, ja sitä käytetään lopulta Sudoku-pelin tietorakenteena.

Aiheeseen perehtymiseksi suosittelemme [dev.java-tutoriaalin](https://dev.java/learn/generics/) lukua Generics sekä videota [Generics In Java - Full Simple Tutorial (Coding with John, YouTube)](https://youtu.be/K1iu1kXkVoA).

## Tehtävän aloittaminen

Forkkaa ensin tämä repositorio omaan GitHub-repositorioosi GitHubin **Fork**-painikkeella ja kloonaa vasta sitten oma forkkisi koneellesi:

```sh
git clone https://github.com/<oma-github-tunnuksesi>/10-generics-and-sudoku.git
```

Avaa kloonattu projekti koodieditorissasi.

## Testaaminen

Tehtävän osille on valmiit [JUnit](https://junit.org/)-yksikkötestit hakemistossa [src/test/java](./src/test/java/). Kunkin osan kohdalla kerrotaan, millä testiluokalla se arvioidaan. Voit ajaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradlella](https://docs.gradle.org/current/userguide/java_testing.html), esimerkiksi:

```
./gradlew test --tests RandomizerTest        # unix
.\gradlew.bat test --tests RandomizerTest    # windows
```

Lisää komennon loppuun `--info`, jos haluat tarkemmat tiedot epäonnistuneista testeistä. Testien tekniseen toteutukseen ei tarvitse perehtyä, ja voit kokeilla ratkaisuasi myös omalla `main`-metodilla. Saat kirjoittaa omia testejä lisää, mutta älä muuta tai poista valmiita testejä.

Älä muuta valmiiden luokkien, metodien ja konstruktorien nimiä, parametreja tai paluuarvojen tyyppejä, sillä silloin testit eivät käänny. Saat tiedoston alkuperäisen version takaisin komennolla `git restore <tiedoston polku>` tai kurssijärjestelmän **Palauta lähtökoodi** -toiminnolla.

## Palauttaminen ja pisteet

Jokaisella tehtävän osalla on kurssijärjestelmässä (https://jtjuslin.kapsi.fi/java) oma sivunsa, jonka koodikentissä on osan koodipohja. Kopioi ratkaisusi koodikenttiin tai kirjoita se suoraan niihin. **Testaa ilman palautusta** ajaa osan testit tallentamatta pisteitä, ja **Lähetä** palauttaa ratkaisun. Jokainen testiluokka hyväksytään vain, jos sen kaikki testit menevät läpi, ja pisteet jaetaan hyväksyttyjen testiluokkien mukaan.

**Pisteet kahdessa vaiheessa**

1. Kun ratkaisusi menee läpi kurssijärjestelmässä, saat osasta **puolet pisteistä**.
2. Pushaa lopuksi kaikki julkiseen GitHub-repositorioosi. Paina tämän jälkeen osan sivulla **Lähetä tarkistettavaksi** -nappia. Kun testit menevät läpi, saat osasta **täydet pisteet**. Repositorio saa jäädä julkiseksi.

GitHubissa ei ole arvioivaa YAML-tehtävävirtaa (GitHub Actions -workflowta), eikä `git push` käynnistä arviointia. Kun painat **Lähetä tarkistettavaksi**, kurssijärjestelmän botti hakee koodisi repositoriostasi ja tarkistaa sen samoilla testeillä. Molemmat vaiheet pitää tehdä ennen luvun määräaikaa. Voit lähettää ratkaisusi niin monta kertaa kuin tarvitset, ja voimaan jää paras tulos.


## Tehtävä 1: Randomizer *(perusteet, 25 %)*

Toteuta [Randomizer](./src/main/java/randomizer/Randomizer.java)-luokan metodit `getRandom`, `shuffle`, `getShuffled` ja `getRandomSample` niiden javadoc-kommenttien mukaisesti. Metodeilla haetaan listalta satunnainen arvo, sekoitetaan lista satunnaiseen järjestykseen tai otetaan listalta tietty määrä satunnaisia arvoja. Tällaista satunnaisuutta tarvitaan esimerkiksi verkkopalvelussa, joka nostaa etusivulle satunnaisia myynti-ilmoituksia, tai korttipeleissä. Tässä vaiheessa metodit käsittelevät merkkijonoja.

💡 *Kiinnitä huomiota metodien samankaltaisuuteen: voisitko kutsua metodeista muita saman luokan metodeja?*

Arvioinnissa ajetaan testiluokka [RandomizerTest](./src/test/java/randomizer/RandomizerTest.java).


## Tehtävä 2: Generic randomizer *(soveltaminen, 25 %)*

Muuta [Randomizer](./src/main/java/randomizer/Randomizer.java)-luokan kaikki metodit **geneerisiksi**, jolloin esimerkiksi satunnaisen arvon hakevaa metodia voi käyttää niin merkkijonojen, numeroiden kuin omien luokkiesi kanssa. Metodien sisältöä ei yleensä tarvitse juuri muuttaa: muutokset kohdistuvat metodien otsikoihin, joissa `String`-tyypin sijasta käytetään luokan tyyppiparametria `Type`. Kurssijärjestelmä tuo tehtävän 1 `Randomizer`-luokkasi tähän tehtävään automaattisesti, kun avaat sen ensimmäisen kerran.

Muutokset eivät saa rikkoa olemassa olevaa toiminnallisuutta, joten `RandomizerTest`-luokan testien pitää edelleen mennä läpi.

Arvioinnissa ajetaan testiluokka `GenericRandomizerTest`. Se ei käänny, ennen kuin metodit ovat geneerisiä, minkä vuoksi se on repositoriossa lähdekoodien ulkopuolella tiedostossa `GenericRandomizerTest.txt`. Kurssijärjestelmä ajaa sen automaattisesti. Omalla koneellasi siirrä se paikalleen projektin juurihakemistossa komennolla, joka kirjaa siirron myös versionhallintaan:

```
git mv GenericRandomizerTest.txt src/test/java/randomizer/GenericRandomizerTest.java
```


## Tehtävä 3: Grid *(soveltaminen, 25 %)*

Toteuta [Grid](./src/main/java/grid/Grid.java)-luokka, joka edustaa **kaksiulotteista** ruudukkoa, esimerkiksi shakkilautaa, ristinollaa tai sudoku-ruudukkoa. Grid toteutetaan **geneerisenä** (`Grid<Type>`), joten sen sisältönä voi olla käyttötarkoituksen mukaan esimerkiksi numeroita (`Grid<Integer>`), merkkijonoja (`Grid<String>`) tai muita olioita (`Grid<ChessPiece>`). Yhden Grid-olion kaikki arvot ovat kuitenkin samaa tyyppiä.

Toteuta luokkaan sen javadoc-kommenttien mukaisesti tiedon tallentaminen ja hakeminen. Ne toimivat samaan tapaan kuin taulukoissa, listoissa ja mapeissa, mutta "avain" muodostuu kahdesta arvosta: rivin ja sarakkeen numerosta. Ruudukon koko ei ole kiinteä: arvoja voi asettaa missä järjestyksessä tahansa ja hyvin suuriinkin indekseihin (esim. 100 000 tai 200 000). Tyhjästä ruudusta palautetaan `null`.

💡 *Tallennukseen käytettävän tietorakenteen saat valita itse. Voit esimerkiksi tallentaa listalle olioita, joissa on rivi, sarake ja arvo. Tehokkaampaa on käyttää Map-tietorakennetta ja yhdistää rivi ja sarake merkkijonoavaimeksi (`map.put("5:8", 7)`). Edistyneempi tapa on luoda oma `Position`-luokka avaimeksi (`map.put(new Position(5, 8), 7)`). Hajautustaulun avaimena käytettävälle luokalle on toteutettava [hashCode-metodi](https://www.baeldung.com/java-hashcode), joten `Position` kannattaa toteuttaa [record-luokkana, jolle Java muodostaa sen automaattisesti](https://docs.oracle.com/en/java/javase/17/language/records.html): `record Position(int row, int col) { }`.*

Arvioinnissa ajetaan testiluokka [GridTest](./src/test/java/grid/GridTest.java).


## Tehtävä 4: Sudoku *(soveltaminen, 25 %)*

> *"Sudoku on logiikkapeli, jossa tehtävänä on täyttää neliönmuotoinen ruudukko merkeillä niin että jokaisella vaakarivillä ja pystyrivillä sekä jokaisessa osaneliössä käytetään samaa merkkiä tasan yhden kerran. Ruudukossa on aluksi valmiina jo muutama merkki. Yleisin sudoku on 9 × 9 -ruudukko, joka on jaettu yhdeksään 3 × 3 ruudun osaneliöön, ja merkkeinä käytetään numeroita 1–9"*
>
> Wikipedia. https://fi.wikipedia.org/wiki/Sudoku

Harjoitus näyttää, miten pelilogiikka, tiedon tallennus ja käyttöliittymä erotetaan omiksi luokikseen. Pelilogiikka toteutetaan [Sudoku](./src/main/java/sudoku/Sudoku.java)-luokassa, joka tarkistaa siirtojen säännönmukaisuuden. Numerot tallennetaan tehtävässä 3 toteutettuun [Grid](./src/main/java/grid/Grid.java)-luokkaan, ja käyttöliittymä on valmiina [SudokuGame](./src/main/java/sudoku/SudokuGame.java)-luokassa. Kurssijärjestelmä tuo tehtävän 3 `Grid`-luokkasi tähän tehtävään automaattisesti, kun avaat sen ensimmäisen kerran. Näin jaettua koodia on helpompi ylläpitää, testata ja käyttää uudelleen: Grid sopii muihinkin ruudukkopeleihin ja Sudoku erilaisiin käyttöliittymiin.

Toteuta `Sudoku`-luokan metodit `setNumber`, `getNumber`, `isSolved` ja `toString`. `setNumber` heittää `IllegalArgumentException`-poikkeuksen, jos numero on jo samalla rivillä, samassa sarakkeessa tai samalla 3 × 3 -alueella tai jos rivi, sarake tai numero on sallitun välin ulkopuolella. Tarkistukset kannattaa toteuttaa omiin apumetodeihinsa.

Voit pelata keskeneräistäkin peliä suorittamalla `SudokuGame`-luokan `main`-metodin. Kun metodit toimivat, peli näyttää esimerkiksi tältä:

```
███████╗██╗   ██╗██████╗  ██████╗ ██╗  ██╗██╗   ██╗
██╔════╝██║   ██║██╔══██╗██╔═══██╗██║ ██╔╝██║   ██║
███████╗██║   ██║██║  ██║██║   ██║█████╔╝ ██║   ██║
╚════██║██║   ██║██║  ██║██║   ██║██╔═██╗ ██║   ██║
███████║╚██████╔╝██████╔╝╚██████╔╝██║  ██╗╚██████╔╝
╚══════╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝ ╚═════╝

Welcome to the Sudoku game! Press Ctrl + C to exit.

2 6 7 | 8 3 9 | 5 . 4
9 . 3 | 5 1 . | 6 . .
. 5 1 | 6 . . | 8 3 9
------ ------- ------
5 1 9 | . 4 6 | 3 2 8
8 . 2 | 1 . 5 | 7 . 6
6 7 4 | 3 2 . | . . 5
------ ------- ------
. . . | 4 5 7 | 2 6 3
3 2 . | . 8 . | . 5 7
7 4 5 | . . 3 | 9 . 1

Enter the row (0-8): 1
Enter the column (0-8): 1
Enter the number (1-9): 8
```

Arvioinnissa ajetaan testiluokka [SudokuTest](./src/test/java/sudoku/SudokuTest.java). `SudokuGame`-luokalle ei ole testejä.


## Tehtävä 5: paketointi JAR-tiedostoksi *(extra, 0 %)*

Jos haluat paketoida sudoku-sovelluksen [JAR-tiedostoksi](https://en.wikipedia.org/wiki/JAR_(file_format)), jonka voi suorittaa ilman lähdekoodia ja IDE:tä, aja `./gradlew build` (Windowsissa `.\gradlew.bat build`). Paketti syntyy hakemistoon `build/libs/`, ja sen voi suorittaa komennolla `java -jar build/libs/generics-and-sudoku.jar`. Lisätietoja: [Building Java Projects with Gradle (spring.io)](https://spring.io/guides/gs/gradle). Tällä tehtävällä ei ole testejä, eikä se vaikuta arviointiin.


## Lisenssi ja tekijät

Tämän tehtävän ovat kehittäneet Teemu Havulinna ja Jukka Juslin, ja se on lisensoitu [Creative Commons BY-NC-SA -lisenssillä](https://creativecommons.org/licenses/by-nc-sa/4.0/). Tehtävänannon, lähdekoodien ja testien toteutuksessa on hyödynnetty ChatGPT 3.5 -kielimallia sekä GitHub Copilot -tekoälyavustinta.

**Sudoku ❤ Ohjelmoinnin MOOC.** Sudoku-tehtävässä on otettu vahvasti vaikutteita Helsingin yliopiston [Ohjelmoinnin perusteet -MOOC-kurssin](https://ohjelmointi-24.mooc.fi/) Python-kielisistä tehtävistä osoitteessa https://ohjelmointi-24.mooc.fi/osa-5, ja osittain täytetty ruudukko on lainattu samasta kurssista. [Ohjelmoinnin MOOC on lisensoitu CC BY-NC-SA 4.0 -lisenssillä](https://ohjelmointi-24.mooc.fi/credits):

> *Kurssimateriaalin ja tehtävien tekijät ovat Erkki Kaila, Antti Laaksonen ja Matti Luukkainen. Muutama kurssin tehtävistä on Arto Hellaksen (né Vihavainen) käsialaa.*
>
> *Kurssin materiaali on lisensoitu [Creative Commons BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.fi) -lisenssillä, joten voit käyttää ja levittää sitä vapaasti, kunhan alkuperäisten tekijöiden nimiä ei poisteta. Jos teet muutoksia materiaaliin ja haluat levittää muunneltua versiota, se täytyy lisensoida samalla lisenssillä. Materiaalien käyttö kaupalliseen tarkoitukseen on ilman erillistä lupaa kielletty.*
