# INF112 Project – *Astro Adventure*

![astroadventure](/src/main/resources/astroadventure_title.png)

* Team: *Java Junkies* (Gruppe 1): *Snorre Haland, Kasper Treborg , Bastian Sunde, Elias Aronsen*
* Trello Link: https://trello.com/invite/b/f9N23lGE/ATTIe6bde57c79ea9dd4b28bf7a10b2c4b325186A05D/inf112

## Om spillet
*« Dirk er galaksens beste romutforsker, men etter romskipet hans krasjet må han løpe fra forfølgere hans ved å krysse galaksen! Hjelp ha med å finne portalen hjem!»*

## Hvordan man spiller
* Bruk pil-tastene for å bevege deg rundt!
* Mellomsromstasten brukes for å hoppe mellom planeter!
* Shift bruker for å skli og gå ned på huk!
* R for spiller død state!
* Bruk A for å utføre angrep. trykk A tre ganger for å utføre kombo angrep

## Kjøring
* Kompileres med `mvn package`.
* Kjøres med `java -jar target/kurt-mario-1.0-SNAPSHOT-fat.jar`
* Krever Java 15 eller senere


## Credits
* https://rvros.itch.io/animated-pixel-hero
* https://deep-fold.itch.io/pixel-planet-generator
* https://mattwalkden.itch.io/free-space-runner-pack

## Roller

* Fysikk og hovedkarakter: Snorre
* Terreng: Kasper
* Fiende: Elias
* Git-ansvarlig / kundekontakt: Bastian
* Upgrades og poeng: Alle




## KONSEPT
* "Vi har lyst til å lage en 2D-platform spill der man hopper rundt fra planet til planet mens man unngår fiender og vanskelig       terreng."


* Spillfigur som kan styres – gå til høyre/venstre, hoppe oppover
* Todimensjonal verden:
    * Plattform – planeter spilleren kan stå eller gå på planeter, spillet skal la deg hoppe fra planet til planet.
    * Planetene skal kunne være forskjellige størrelser.
    * Spilleren beveger seg oppover ved å hoppe, og nedover ved å falle, retningene skal automatisk justeres for hvor du befinner deg rundt planeten.
* Fiender som beveger seg mot karakteren og er skadelige ved berøring
* Spilleren kan samle poeng ved å plukke opp ting.
* Spilleren kan utvide arsenalet ved å plukke opp en "upgrade" i formen av en powercell.
* Utfordringen blir å holde seg på planetene og månene uten å falle ut i verdensrommet, løpe fra fiender som jager deg og finne en portal hjem!

Reffererer til:
* Det blir litt av en blanding mellom Metroid Dread og Super mario oddesey's sin "Moon Kingdom" 2D-section



