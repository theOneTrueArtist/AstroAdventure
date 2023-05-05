## Team Møter

Team Møte 21.4:
Hva vi har gjort:
Vi har hatt settet fokus på bli ferdig med obligatoriske oppgaver i andre emner denne uken.
Bastian: Har settet inn soundtrack.

Til neste uke så plannlegger vi:
Lage en start-skjerm og en hjelpe side for å vise hvordan spillet fungerer.
Skal fikse at finde springer etter spiller. 


Team Møte 28.4:
Hva vi har gjort:
* Start-skjerm er lagt til
* Hjelpe-skjerm er lagt til
* Fiender følger etter spiller nå.
* Implimentere en objekt fabrikk for å kunne generer lvl'er.

Til neste uke så plannlegger vi:
* Bli ferdig med alt.
* Pusse opp funksjonene sånn at spillet kjører som det skall.
* Teste for bugs, sjekke om spillet kjører bra.

Deadline 5.5:
Spillet er ferdig, og presentasjon er på vei.
Vi jobber med og sette javadocs på public funksjoner. 



## Prosjektrapport:
Nå som vi nærmer oss deadline legger vi til de siste spill-funksjonene igjen og pusser bort alle bugs og problemer. Vi fokuserer på å få spillet klart til presentasjonen.

* Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?

Rollene fungerer fortsatt bra. Vi tar ansvar for oppgavene vi blir gitt.

* Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.

Vi har funnet at det fungerer best for oss å ta rollene som vi mener vi trenger for øyeblikket med tanke på utvikling av spillet. Og eventuelt legge fra oss gamle roller som vi ikke trenger lenger.

* Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?

Vi synes at valgene vi har tatt var gode med tanke på prosjekts utviklingen. Både med tanke på å gi utfordring, og utvikle i lag uten og trokke på hver andre. I tilegg og ha noe kult å utvikle. Vi har også hatt et godt sammerbeid i slutten av prosjektet.  



* Hvordan er gruppedynamikken? Er det uenigheter som bør løses?

Gruppedynamikken er forsatt god og avslappet og alle har en felles respekt, alle kommer overens fint.

* Hvordan fungerer kommunikasjonen for dere?

I gruppetimene er det god og åpen dialog, diskusjon og plannlegging. Det er hovedsaklig her vi diskuterer projektet men vi har også en discord kanal hvor vi snakker utenfor gruppetimene.

* Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.

Vi føler oss nokså ferdig og har lagd et interessant og et veldig kult spill. Det er lett å si at spillet kunne ha vært bedre, men vi føler oss fornøyd med innsatsen og slutt resultatet.

* Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)

Den største committeren er Snorre, han har mest erfaring og tid i spill-design. Dette har latt ham gi oss et godt grunnlag for å kode ut fra. Etter oppstarten har committene våre vært nokså gjevnt fordelt. Bastian har committet minst, da han har slitet med nett og problemmer med lydimplementasjon i forhold til Javafx. Hvor mye de enkelter på gruppen liker og commite på en gangen er forskjellig.

* Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.

Siden dette er siste innlevering skriver vi heller hva vi ville ha gjort bedre over hele prosjektet:
 - Vi burde ha hatt bedre dokumentasjon for metoder og klasser tidligere i prosjektet, dette ville ha lagt oss slippe mye spørsmål, og gjort det enklere å lese koden.
 - Snakket mere om strukturen til koden før vi startet, for slippe problemer med utviklingen av koden senere.
 - Kommunikasjon utenfor gruppetimene.

## Krav og spesifikasjon
* Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang. Er dere kommet forbi MVP? Forklar hvordan dere prioriterer ny funksjonalitet. 

Vi har kommet oss forbi MVP. Vi er ferdig med alt vi føler spillet trenger, vi har lagt til det siste av funskjoner vi trenger for spillet, nå prioriterer vi bare å være klare for presentasjon.

* Forklar kort hvordan dere har prioritert oppgavene fremover 

Siden det er deadline er den eneste oppgaven fremover å være klar for presentasjon og vidre eksamen.

* Har dere gjort justeringer på kravene som er med i MVP? Forklar i så fall hvorfor. Hvis det er gjort endringer i rekkefølge utfra hva som er gitt fra kunde, hvorfor er dette gjort? 

Nei.

* Husk å skrive hvilke bugs som finnes i de kravene dere har utført (dersom det finnes bugs). 

Vi hadde en bug der det å trykke på start knappen på start skjermen crashet spillet for en stund, men dette problemet ble fikset. 
Planen har hele veien vert at hoved-enemy skal være udødelig og dette er derfor da ikke en bug. 

* MVP:
  1. Vise et spillebrett
    * Som spiller ønsker jeg å kunne se et spillebrett slik at jeg kan vite hvor jeg er og hvor jeg skal for å fullføre en bane, det vil og hjelpe med å koble hele sammenhengen av spillet.
    
    * Akseptansekriterier:
      * Gitt at jeg viser et spillebrett så kan jeg se banen og danne en forståelse for hvor jeg er og hvor jeg skal.

      * Arbeidsoppgaver:
        * implementere grafisk funksjonalitet som tar Spill Objekter og gir en grafisk representasjon
  
  2. Vise spiller på spillebrett
     * Som spiller ønsker jeg å kunne se en spiller på spillbrettet (karakteren jeg skal styre) slik at jeg kan vite hva/hvem jeg kontrollerer og danne en forståelse for hvilke egenskaper- 
     * jeg har som spiller.

     * Akseptansekriterier:
       * Gitt at jeg viser en spiller på spillebrettet så kan jeg se karakteren jeg styrer og alltid ha kontroll på hvor spilleren er på spillbrettet,- 
       * samt som jeg kan skille bakgrunn/spillebrett fra min spiller slik at det ikke oppstår misforståelser.

     * Arbeidsoppgaver:
       * opprette en spillefigur og bruke grafisk funksjonalitet til å representere spiller med images som reflekterer de egenskapene spiller objektet har (posisjon, størelse, state)

  3. Flytte spiller(vha taster)
     * Som spiller ønsker jeg å kunne flytte spilleren(vha taster) slik at jeg kan ha kontroll over hvor spilleren skal gå og for å danne en grunnleggende forståelse av hvilke- 
     * muligheter jeg har når det kommer til bevegelse av spilleren.

     * Akseptansekriterier:
       * Gitt at jeg kan flytte spiller vha taster så kan jeg bevege spilleren med tastatur knappene mine og flytte karakteren rundt etter egen vilje.

     * Arbeidsoppgaver:
       * implementere funksjonalitet som tar inn input fra keyboard og som kan relatere informasjon fra keybord til spillet og videre til spille figur.

  4. Spiller interagerer med terreng
    * Som spiller ønsker jeg at spilleren (min spillbare karakter) interagerer med terreng slik at jeg skal kunne bevege meg rundt på terrenget samt som jeg skal kunne ta i bruk terregnet
    * for å komme frem til mål.
  
    * Akseptansekriterier:
      * Gitt at jeg får spiller til å interagere med terreng så vil spilleren kunne ta i bruk terreng for å kunne manøvere seg gjennom banen og frem til mål.
      * Dette vil også hjelpe med å unngå bugs hvor f.eks. spilleren kan gå gjennom en vegg eller falle gjennom bakken.

    * Arbeidsoppgaver:
      * implementere en form for kollisjons testing som kan brukes til å sjekke om det er mulig for spiller å bevege seg i denne rettningen.

  5. Fungerende gravitasjonsfelt på planetene (spillebrettet)
    * Som spiller ønsker jeg et fungerende gravitasjonsfelt på planetene (spillbrettet) slik at jeg kan manøvere meg fra planet til planet og kunne springe rundt på planeten jeg er på.

    * Akseptansekriterier:
      * Gitt at jeg har fungerende gravitasjonsfelt på planetene (spillebrettet) så vil spilleren og fiender kunne manøvere seg fra planet til planet samt bevege seg rundt på planetene dem allerede er på.

    * Arbeidsoppgaver:
      * bruke sin og cos til å finne ut hvilken retning spilleren skal bevege seg i iforhold til gravitasjon og endre retning som spilleren beveger seg horisontalt og vertikalt til å vere relativt til gravitasjon. også implementere gravitasjon som en konstant kraft som drar objekter.

  6. Vise fiender/monster som også skal interagere med terreng

    * Som spiller ønsker jeg fiender/monster som integrerer med terreng slik at spillet blir oppfattet befolket.

    * Akseptansekriterier:
	    * gitt at fiender/monstre vises og integrerer med terreng så vil fiendene være synlig grafisk og de vil ikke kunne gå igjennom terreng.

    * Arbeidsoppgaver:
        * implementere fiender som også bruker kollisjons funksjonalitet til å se hvor de ikke kan bevege seg.
    
  7. Generelt fysikk system.

    * Som utvikkler ønsker jeg et generelt fysikk system som kan brukes av alle enheter slik at det er enkelt å integrer nye elementer inn i spillet.

    * Akseptansekriterier: 
        * Gitt at fysikk systemet påvirker objekter i spillet blir riktig, så vil objekter bli påvirket determanistisk og uniformt.
    
    * Arbeidsoppgaver:
        * implementer abstraksjon for objekter som kan bli påvirket og kjøre alle fysikk relaterte tester på abstraksjonen

  8. Spiller kan dø
  
    * Som spiller ønsker jeg at det skal være mulig å tape spillet ved at spiller dør, slik at det er en utfordring å spille.
    
    *  Akseptansekriterier:
        * Gitt at spiller kan dø så vil spillet være over og bli resetet tilbake til en tidligere fase.
    
    * Arbeidsoppgaver:
        * sjekke om spiller har gått tom for liv og så restarte spillet over.

  9. Mål for å vinne.

    * Som spiller ønsker jeg at det skal være en måte å vinne, slik at det er et naturlig slutt-punkt for spillet utenom å dø. Spill har forskjellige vinn betingelser.

    * Akseptansekriterier:
        * Gitt vinn-betingelsen er truffet skal spillet stoppe og vise at du har vunnet.

    * Arbeidsoppgaver:
        * Sjekke for når vinn-betingelsen har blitt truffet og utfører riktig handling etter dette.

  10. Objekt-fabrikk.

    * Som utvikler har vi lyst til å kunne enkelt opprette levler slik at level design kan gjøres enklere.

    * Akseptansekriterier:
        * Gitt at koden kan ta inn et tekst dokument med funksjonsverdier skal den lage ett level med de gitte veridene fra tekst dokumentet.

    * Arbeidsoppgaver:
        * Opprette fabrikken som kan ta inn enkle verdier fra teskt dokumentet, og setter dem inn i relevante funksjoner. og fyller inn resten av informasjonen som trengs for at spillet skal fungere.

  11. Start-skjerm.

      * Som spiller har jeg lyst til å ha en start-skjerm slik at den viser oversiktlig navnet på spillet og en måte å starte spillet.

    * Akseptansekriterier:
        * Gitt at spillet åpnes skal spillet vise en meny-skjerm som viser tittel og en måte å starte selve spillet på.

    * Arbeidsoppgaver:
        * Legge til denne skjermen før spillet starter.


## Prioriteringsliste av MVP:
 
    1. Vise et spillebrett
    2. Vise spiller på spillebrett
    3. Flytte spiller(vha taster)
    4. Spiller interagerer med terreng
    5. Fungerende gravitasjonsfelt på planetene (spillebrettet)
	6. Vise fiender/monster som også skal interagere med terreng
	7. Generellt fysikk system.
	8. Spiller kan dø 
	9. Mål for å vinne
	10. Fiende følger spiller
	10. Objekt-fabrikk
	11. Start-skjerm



## Produkt og kode

* Dette har vi fikset siden sist:
    Vi har fikset en bug med start skjermen som crashet spillet.
    Vi har lagt til flere tester, fikset lyd og laget kommentarer med javadoc. Itilleg til dette har vi også gjort ferdig de gjennstående mvp kravene.

* Vi har ingen kjente feil ved cross-platform bruk, vi har testet spillet på både windows og Mac og dette fungerer som det skal.

* Vi har ikke fått testet på Linux, men etter overgang over prosjektet har vi erklært at det vil kjøre fint der og.

* Vi har ikke tatt i bruk statiske analyseverktøy og har dermed ingenting å formidle angående hva vi fant / om det var nyttig.

