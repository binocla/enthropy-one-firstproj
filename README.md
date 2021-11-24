# Course 1 #

### Enthropy: Annihilation

![enthropy](https://sun9-37.userapi.com/impg/2768knmp1sOk_lSp5u1ewaNSP3wCOEKXVOLN8A/Y9ljTC55gVE.jpg?size=1900x1188&quality=96&sign=9bed2156e73d497275594c91d7fcaccb&type=album)

## Условие ##

Binocla стремился к бесконечности.

*И будут знамения в солнце и луне и звездах, а на земле уныние народов и недоумение; и море восшумит и возмутится; люди
будут издыхать от страха и ожидания бедствий, грядущих на вселенную, ибо силы небесные поколеблются*

Он смог. Смог добраться до черной дыры и рухнуть прямо в сингулярность. Отныне начинается путешествие по альтернативным
реальностям, в каждой из которых **Binocla - другое существо**

Вам необходимо завести модели с правильными полями, опираясь на написанный код. Изменять код нельзя, только дополнять.

Единственная подсказка - *timeline и timeTravelling имеют Enum тип данных*

После этого Вам необходимо отправить GraphQL запросы для проверки модифицированных моделей на корректность.

**Вот некоторые из них**:
-

    query getBinoclasWithUniverse {
        universe(universeId: 1) {
            title
            created
            blackHoleEntry
            interstellarIdentifier
            timeline
            binoclas {
                name
                height
                mass
                timeTravelling
                alive
            }
        }
    }

Результат должен быть:
-

    {
        "data": {
        "universe": {
        "title": "undefined",
        "created": "-999999994-01-02",
        "blackHoleEntry": "Unreachable Horizons A",
        "interstellarIdentifier": 0,
        "timeline": "MIXED",
        "binoclas": [
            {
                "name": "unreachable",
                "height": 1.7976931348623157e+308,
                "mass": -1,
                "timeTravelling": "MIXED",
                "alive": true
                    }
                ]
            }
        }
    }

Еще один пример:
- 

    query allUniverses {
        allUniverses {
        title
        created
        blackHoleEntry
        interstellarIdentifier
        timeline
        }
    }

С ответом:
-

    {
        "data": {
        "allUniverses": [
            {
                "title": "The Discovery",
                "created": "+15232-03-22",
                "blackHoleEntry": "UI-51223c",
                "interstellarIdentifier": -152521254879145,
                "timeline": "REVERSED"
            },
            {
                "title": "undefined",
                "created": "-999999994-01-02",
                "blackHoleEntry": "Unreachable Horizons A",
                "interstellarIdentifier": 0,
                "timeline": "MIXED"
            },
            {
                "title": "Great Saint Extermination",
                "created": "+999999-11-15",
                "blackHoleEntry": "UI-951235123b-D",
                "interstellarIdentifier": 152521879145,
                "timeline": "NATURAL"
            }
            ]
        }
    }

***Такие проверки должны быть для всех методов, описанных в UniverseResourse (allUniverses, getUniverse и
getBinoclasWithUniverse как в 1 примере***

***Все такие запросы должны быть представлены в 3-х вариантах возвращения (например, где-то без title, где-то без
нескольких полей...)***

## Запуск и проверка ##

> ./mvnw compile quarkus:dev, после - Enter или Ctrl+Enter (Windows)

Или

> mvn compile quarkus:dev, после - Enter или Ctrl+Enter (Windows)

После этого необходимо открыть браузер (или любой другой клиент - curl, postman...), перейти
на [localhost](http://localhost:8091/)
или сразу на [http://localhost:8091/q/graphql-ui](http://localhost:8091/q/graphql-ui)
и выполнить запросы. Если модели сделаны корректно - вы получите ответ выше

**Для остановки проекта в консоли (где вводили команды выше) необходимо нажать Ctrl+C**

***Внимание! Необязательно перезапускать проект при изменениях - это происходит за вас***

## Мои контакты (если что-то совсем не получается или есть корректировки к условию) ##

- **[VK](https://vk.com/binocla)**
- **[Telegram](https://t.me/binocla)**