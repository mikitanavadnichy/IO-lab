# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

--- 
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC3](#uc3): Otrzymanie płatności za produkt
* [UC4](#uc4): Wysyłanie produktu

[Kupujący](#ac2)
* [UC2](#uc2): Licytowanie o produkt
* [UC3](#uc3): Wprowadzenie opłaty za produkt
* [UC4](#uc4): Odbiór produktu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Licytowanie

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wpisuje kwotę, jaką może zapłacić za produkt.
2. System weryfikuje, że wpisana przez użytkownika kwota jest większa od obecnej ceny za produkt.
3. System prosi użytkownika zaakceptować regulamin o obowiązku zapłaty przy wygraniu aukcji.
4. [Kupujący](#ac2) akceptuje regulamin.
5. System oczekuję na wprowadzenie wyższej kwoty niż obecna lub oczekuję na zakończenie terminu aukcji.
6. Po zakończeniu terminu aukcji system wybiera [kupującego](#ac2), który wprowadził największą kwotę za produkt.
7. System wysyła wiadomość o wygranej aukcji do [kupującego](#ac2).
8. System wysyła wiadomość o zakończeniu aukcji do [sprzedającego](#ac1).

**Scenariusze alternatywne:** 

2.A. Wpisana przez użytkownika kwota nie jest wyższa niż obecna cena za produkt.
* 2.A.1. System informuje o błędnie wpisanej kwocie i prosi wprowadzić wyższą kwotę.
* 2.A.2. Przejdź do kroku 3.

3.A. Użytkownik nie zaakceptował regulamin.
* 3.A.1. System prosi ponownie zaakceptować regulamin albo oferta użytkownika nie będzie więcej aktywna.
* 3.A.2. Przejdź do kroku 4.

---

<a id="uc3"></a>
### UC3: Wprowadzenie opłaty za produkt

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:** 
1. System prosi [kupującego](#ac2) o wprowadzenie danych dotyczących opłaty.
2. [Kupujący](#ac2) wprowadza dane dotyczące opłaty.
3. System weryfikuje wprowadzone dane.
4. [Kupujący](#ac2) dokonuje płatność za produkt.
5. System sprawdza, że całkowita kwota produktu została zaksięgowana na koncie.
6. System informuje [kupującego](#ac2) o pomyślnie zakończonej płatności. 
7. [Sprzedający](#ac1) otrzymuje opłatę za produkt.

**Scenariusze alternatywne:** 

3.A. Podano niepoprawne lub niekompletne dane dla opłaty.
* 3.A.1. System informuje o błędnie podanych danych.
* 3.A.2. Przejdź do kroku 4.

5.A. Niepełna kwota towaru została zaksięgowana na koncie.
* 5.A.1. System informuje że nie cała kwota towaru została zaksięgowana na koncie.
* 5.A.2. Przejdź do kroku 6.

---

<a id="uc4"></a>
### UC4: Wysyłka produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:** 
1. [Kupujący](#ac2) wprowadza swoje dane dla wysyłki produktu dla firmy kurierskiej.
2. System weryfikuje poprawność wprowadzonych danych.
3. System wysyła dane dla wysyłki do [sprzedającego](#ac1).
4. [Sprzedający](#ac1) zamawia kuriera w celu wysłania paczki z produktem na określony adres.
5. System informuje [kupującego](#ac2) oraz [sprzedającego](#ac1) o nadanie przesyłki.


**Scenariusze alternatywne:** 

2.A. Podano niepoprawne lub niekompletne dane dla wysyłki .
* 2.A.1. System informuje o błędnie podanych danych.
* 2.A.2. Przejdź do kroku 3.
---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| UC2: Licytowanie                                               |  ...   |  ...    | ... |
UC3: Wprowadzenie opłaty za produkt                                              |  ...   |  ...    | ... |
UC4: PUK                                              |  ...   |  ...    | ... |


