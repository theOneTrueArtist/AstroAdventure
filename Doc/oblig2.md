##Team Møter
Team Møte 24.2:
Hva vi har gjort:
Vi har ikke jobbet med noe serlig siden innlevering forrige uke.

Til neste uke så plannlegger vi:
Elias: se på AIs og enemies og sånn
Snorre: jobbe med vektorisering
Kasper: Skal utvide spillebrettet of fikse på miljøet
Bastian: skal se på lyd og tester.

Team Møte 3/3:
Hva vi har gjort:
Vi har fikset generel abstraktjon, som gravity og gameactors osv.

Til neste uke så plannlegger vi:
Elias: studere hvordan enemies fungerer i spill utvikling og legge til sprite og animasjon.
Snorre: legge til karakter states og fikse opp i gameactor normalilzation. se på HUD.
Kasper: lagt til sprits og designe konsept for spillbrett.
Bastian: Se på integrasjon av lyd i spillet.

Team Møte 10/3:
Hva vi har gjort:
Vi har lagt til sprites og animasjoner for enemy og karakter. vi har lagt til sprites for planneter og fikset på gravity. vi har lagt til en simpel HUD.

Til neste uke så plannlegger vi:
Elias: ha enemy bevege seg rundt med logik.
Snorre: legge til attack states og hitboxes.
Kasper: Lagge ferdig tutorial planet. outlaye map.
Bastian: finne ut lyder og se på integrasjon.




## Prosjektrapport:
* Hvordan fungerer rollene i teamet? Trenger dere å oppdatere hvem som er teamlead eller kundekontakt?

Rollene har fungerert bra. Vi tar ansvar for de rollene vi har blitt gitt.

* Trenger dere andre roller? Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.

Rollene våre har vært nokk til å beskrive være nærtidlige problemer og ansvar, men vi kan se at vi må kanskje ta på nye anvsvar i framtidige team møter når våre gamle roller ikke er nødvendige lenger.


* Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet fungerer på?

Vi føler oss konfortabel med valgene vi har tatt i forhold til utviklingen av prosjektet.

* Hvordan er gruppedynamikken? Er det uenigheter som bør løses?

Gruppedynamikken er hyggelig og avslappet, alle kommer overens fint.

* Hvordan fungerer kommunikasjonen for dere?

I gruppetimene er det god dialog og diskusjon. Over discord kan det være litt vanskelig siden folk er sjelden online på samme tid, men vi føler oss forsatt veldig konfortabel med vår fremgang.

* Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer.

Vi føler at vi har kommet oss godt i gang og har lagd grunnlaget for et veldig kult spill. Vi kunne ha hatt vært litt mere objekt-orientert og modulær i programmeringen vår tidligere i koden, det ville ha kanskje spart oss litt tid i noen steder av prosjektet. Vi hadde litt forskjellige syn av hvordan spille slutt-resultatet skulle se ut tidlig i prosjektet, men vi er nå alle "på samme side".

* Under vurdering vil det vektlegges at alle bidrar til kodebasen. Hvis det er stor forskjell i hvem som committer, må dere legge ved en kort forklaring for hvorfor det er sånn. Husk å committe alt. (Også designfiler)

Den største committeren er Snorre, han har mest erfaring og tid i spill-design. Dette har latt ham gi oss et godt grunnlag for å kode ut fra. Bastian har committet minst, da han sliter med nett og lokasjonen. Men det kommer. 

* Bli enige om maks tre forbedringspunkter fra retrospektivet, som skal følges opp under neste sprint.

Tre forbedringspunkter kan være:
 - Kommunikasjon utenfor gruppetimene.
 - Større fremgang i kode mellom gruppetimer.
 - Modulærlitet i koden og kodestil.

## Krav og spesifikasjon
* Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang. Er dere kommet forbi MVP? Forklar hvordan dere prioriterer ny funksjonalitet. 

Vi har ikke kommet oss forbi MVP enda. Vi prioriterer ny funksjonalitet ved å se hva som passer inn i spill konseptet vårt i de områdene vi har delt oss opp i.

* Forklar kort hvordan dere har prioritert oppgavene fremover 

Vi jobber alle på forskjellige felt og vi prioriterer individuelle oppgaver som fremmer funksjonalitet og bygger bakke videre funksjonalitet kan bli bygd på i de individuelle feltene.

* Har dere gjort justeringer på kravene som er med i MVP? Forklar i så fall hvorfor. Hvis det er gjort endringer i rekkefølge utfra hva som er gitt fra kunde, hvorfor er dette gjort? 

Nei.


* Husk å skrive hvilke bugs som finnes i de kravene dere har utført (dersom det finnes bugs). 

Vi finner ingen bugs enda.

* MVP:
  1. Vise et spillebrett
    * Som spiller ønsker jeg å kunne se et spillebrett slik at jeg kan vite hvor jeg er og hvor jeg skal for å fullføre en bane, det vil og hjelpe med å koble hele sammenhengen av spillet.
    
    * Akseptansekriterier:
      * Gitt at jeg viser et spillebrett så kan jeg se banen og danne en forståelse for hvor jeg er og hvor jeg skal.

      * Arbeidsoppgaver:
        * Vi er ferdige med dette MVP-kravet.
  
  2. Vise spiller på spillebrett
     * Som spiller ønsker jeg å kunne se en spiller på spillbrettet (karakteren jeg skal styre) slik at jeg kan vite hva/hvem jeg kontrollerer og danne en forståelse for hvilke egenskaper- 
     * jeg har som spiller.

     * Akseptansekriterier:
       * Gitt at jeg viser en spiller på spillebrettet så kan jeg se karakteren jeg styrer og alltid ha kontroll på hvor spilleren er på spillbrettet,- 
       * samt som jeg kan skille bakgrunn/spillebrett fra min spiller slik at det ikke oppstår misforståelser.

     * Arbeidsoppgaver:
       * Vi er ferdige med dette MVP-kravet.

  3. Flytte spiller(vha taster)
     * Som spiller ønsker jeg å kunne flytte spilleren(vha taster) slik at jeg kan ha kontroll over hvor spilleren skal gå og for å danne en grunnleggende forståelse av hvilke- 
     * muligheter jeg har når det kommer til bevegelse av spilleren.

     * Akseptansekriterier:
       * Gitt at jeg kan flytte spiller vha taster så kan jeg bevege spilleren med tastatur knappene mine og flytte karakteren rundt etter egen vilje.

     * Arbeidsoppgaver:
       * Vi er ferdige med dette MVP-kravet.

  4. Spiller interagerer med terreng
    * Som spiller ønsker jeg at spilleren (min spillbare karakter) interagerer med terreng slik at jeg skal kunne bevege meg rundt på terrenget samt som jeg skal kunne ta i bruk terregnet
    * for å komme frem til mål.
  
    * Akseptansekriterier:
      * Gitt at jeg får spiller til å interagere med terreng så vil spilleren kunne ta i bruk terreng for å kunne manøvere seg gjennom banen og frem til mål.
      * Dette vil også hjelpe med å unngå bugs hvor f.eks. spilleren kan gå gjennom en vegg eller falle gjennom bakken.

    * Arbeidsoppgaver:
      * Vi er ferdige med dette MVP-kravet.

  5. Fungerende gravitasjonsfelt på planetene (spillebrettet)
    * Som spiller ønsker jeg et fungerende gravitasjonsfelt på planetene (spillbrettet) slik at jeg kan manøvere meg fra planet til planet og kunne springe rundt på planeten jeg er på.

    * Akseptansekriterier:
      * Gitt at jeg har fungerende gravitasjonsfelt på planetene (spillebrettet) så vil spilleren og fiender kunne manøvere seg fra planet til planet samt bevege seg rundt på planetene
      * dem allerede er på.

    * Arbeidsoppgaver:
      * Vi er ferdige med dette MVP-kravet.

  6. Vise fiender/monster som også skal interagere med terreng

* Som spiller ønsker jeg fiender/monster som integrerer med terreng slik at spillet blir oppfattet befolket.

* Akseptansekriterier:
	* gitt at fiender/monstre vises og integrerer med terreng så vil fiendene være synlig grafisk og de vil ikke kunne gå igjennom terreng.

* Arbeidsoppgaver:
* vi er ferdige med dette MVP-kravet
  
  7. generelt fysikk system.

* som utvikkler ønsker jeg et generlt fysikk system som kan brukes av alle enheter slik at det er enkelt å integrer nye elementer inn i spillet.

* Akseptansekriterier: 
* gitt at fysikk systemet påvirker objekter i spillet blir riktig, så vil objekter bli påvirket determanistisk og uniformt.
 
 * Arbeidsoppgaver:
 	* vi er ferdige med dette MVP-kravet.
  9. Spiller kan dø
  
  * som spiller ønsker jeg at det skal være mulig å tappe spillet ved at spiller dør, slik at det er en utfordring å spille.
  
  *  Akseptansekriterier:
  *gitt at spiller kan dø så vil spillet være over og bli resetet tilbake til en tidligere fase.
  
  * Arbeidsoppgaver:
  * vi har integrert en død state for player og mangler bare å resete spillet til en tildligere fase.
  
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
    Vi har ikke fikset noe siden sist ettersom vi ikke hadde noen bugs eller problemer fra forrige innlevering

* Vi har ingen kjente feil ved cross-platform bruk, vi har testet spillet på både windows og Mac og dette fungerer som det skal.
* Vi har ikke fått testet på Linux, men etter overgang over prosjektet har vi erklært at det vil kjøre fint der og.

* Vi har ikke tatt i bruk statiske analyseverktøy og har dermed ingenting å formidle angående hva vi fant / om det var nyttig.
