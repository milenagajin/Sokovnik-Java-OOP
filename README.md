## Opis zadatka
Ovaj zadatak je dat od strane jedne IT companije kao kvalifikacioni zadatak,
u kojem je akcenat na poznavanju principa OOP. 
Zadatak je trebao biti realizovan u roku od max 3h, bez dodatnih pitanja.
Kao jezik u kojem će biti pisan zadatak odabrala sam Javu.


## Tekst zadatka

1. Klasom Voće se opisuje voćka, koja je određena svojim nazivom, težinom i time da li je
trula ili ne.
2. Jabuka je voće koje je dodatno opisano sortom.
3. Sokovnik se sastoji iz dva dela: posude za voće i cediljke.
4. Posuda za voće ima svoj kapacitet i može da sadrži voće. U posudu za voće mogu da
dodam voćku, mogu da pratim koliko voćki ima unutra i koliko je prostora ostalo.
5. Cediljka služi za ceđenje voća i radi tako što iscedi sve voće koje se nalazi u posudi. Pri
svakom ceđenju mogu da pratim koliko soka je dobijeno.
6. Ceđenjem jedne voćke se dobija količina soka jednaka 40% težine voćke.
7. Sokovnik se ne sme prepuniti, a takođe ne prihvata trule voćke.
8. Napisati program koji simulira rad sokovnika u koji može da stane 30kg jabuka.
- Nad sokovnikom se vrše akcije ceđenja i ubacivanja jabuka, pri čemu se svaka akcija
loguje u vidu ispisa na ekran ili snimanjem u .txt fajl.
- Sokovnik je programiran da izvrši 100 akcija ceđenja i ubacivanja jabuka, pri čemu se
ceđenje voća radi sa verovatnoćom 30%, a dodavanje jabuke sa verovatnoćom od 70%.
- Jabuka ima zapreminu u intervalu od 1 do 3.
- Jabuka ima 20% verovatnoće da bude trula.
- Na kraju izvršavanja programa ispisati koliko je ukupno soka dobijeno ceđenjem.

** Ukoliko se desi da se kapacitet sokovnika premaši, potrebno je baciti PremasenKapacitet
Exception, i prekinuti izvršavanje programa. **