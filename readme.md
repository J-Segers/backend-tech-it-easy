
# Tech it easy opdracht

    Deze opdracht is verdeeld in delen en zal wekelijks worden ge-update.

## Opdracht beschrijving

    Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt.
    Voor dit bedrijf ga jij een backend applicatie programmeren.
    De winkel heeft een inventaris van televisies die moet worden bijgehouden.

## Deel opdrachten

> ### Opdracht 1
>> De opdracht moet voldoen aan de volgende voorwaarden:
>> - ✔Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Controllers;
>> - ✔Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Exceptions;
>> - ✔Het project bevat een TelevisionsController;
>> - ✔Het project bevat een ExceptionController;
>> - ✔Het project bevat een RecordNotFoundException;
>> - De TelevisionsController bevat:
>>  - ✔een GET-request voor alle televisies
>>  - ✔een GET-request voor 1 televisie
>>  - ✔een POST-request voor 1 televisie
>>  - ✔een PUT-request voor 1 televisie
>>  - ✔een DELETE-request voor 1 televisie
>> - De ExceptionController bevat:
>>  - ✔een exceptionhandler
>> - De RecordNotFoundException bevat:
>>  - ✔een default exception
>>  - ✔een exception met message
>

> ### Opdracht 2
>> - ✔Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Models;
>> - ✔Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Repositories;
>> - ✔Het project bevat een Television in de map Models;
>> - ✔Het project bevat een TelevisionRepository;
>> - Het project bevat de volgende dependencies:
>>  - ✔De Application.properties bevat de properties uit hoofdstuk 9.2 van de cursus Spring Boot(met aangepaste namen)
>>  - ✔De TelevisionRepository extends JpaRepository met de juiste parameters
>> - De Television bevat: -de attributen:
>>  - ✔Long id (incl. annotaties id en generatedValue)
>>  - ✔String type
>>  - ✔String brand
>>  - ✔String name
>>  - ✔Double price
>>  - ✔Double availableSize
>>  - ✔Double refreshRate
>>  - ✔String screenType
>>  - ✔String screenQuality
>>  - ✔Boolean smartTv
>>  - ✔Boolean wifi
>>  - ✔Boolean voiceControl
>>  - ✔Boolean hdr
>>  - ✔Boolean bluetooth
>>  - ✔Boolean ambiLight
>>  - ✔Integer originalStock
>>  - ✔Integer sold
>>  - ✔default constructor
>>  - ✔constructor
>>  - ✔alle getters en setter/s 

>###Opdracht 3
>> - ✔Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Services;
>> - ✔De map Services bevat een klasse genaamd TelevisionService;
>> - De TelevisionService bevat:
>>  - ✔de juiste annotatie
>>  - ✔een private variabele TelevisionRepository
>>  - ✔de connectie van de Service en de Repository door middel van een autowired
>>  - ✔een functie voor het ophalen van alle Televisions
>>  - ✔een functie voor het ophalen van 1 Television
>>  - ✔een functie voor het opslaan van 1 Television
>>  - ✔een functie voor het verwijderen van 1 Television
>>  - een functie voor het updaten van 1 Television
>> - ✔De Controller is door middel van een autowired gelinkt aan de Service;
>> - Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Dtos;
>> - De map Dtos bevat een TelevisionDto en een TelevisionInputDto;
>> - De requestMappings in de Controller worden aangepast zodat deze de juiste response doorgeven via de Service;
>> - De Service maakt gebruik van de gegevens die we via de Controller doorkrijgen van de Dtos;
>> - Het project bevat de validator dependency uit paragraaf 8.1 van de cursus Spring Boot in Edhub.
 
