
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