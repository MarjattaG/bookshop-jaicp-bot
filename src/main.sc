require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        intent: Начнём.

    state: Hello
        q!: *(прив*/здравствуй*/*даров*/добр*)*
        random:
            a: Привет, привет!
            a: Доброго времени суток!
            a: Приветствую! Рад встрече!
        go!: /Welcome
            
    state: Welcome
        q!: *(себ*)*
        q!: *(кто/что ты | умеешь)*
        a: Я бот-помощник книжного магазина «АБВГДейка». 
            \nЯ с радостью помогу тебе подобрать книгу, расскажу о новинках книжного мира, поделюсь интересными фактами. 
            \nС чего начнем? 
            
        state: Choice
            q!: *(выбрать*/выбер*/найти*/найд*/подобер*/подобр*)*
            a: Начнем с простого: русская или заружебная литература?
            buttons:
                "Русская" -> /Welcome/Choice/Rus
                "Зарубежная" -> /Welcome/Choice/Foreign
            
            state: Rus
                a: Какой жанр тебя интересует?
                buttons:
                    "Романтика" -> /Welcome/Choice/Rus/Romance
                    "Фантастика" -> /Welcome/Choice/Rus/Fantasy
                    "Детектив" -> /Welcome/Choice/Rus/Detectives
                    "Ужасы" -> /Welcome/Choice/Rus/Horrors
                state: Romance
                    a: Хочется классики или современных авторов?
                    buttons:
                        "Отечественная классика" -> /Welcome/Choice/Rus/Romance/Classic
                        "Современные авторы" -> /Welcome/Choice/Rus/Romance/Modern
                    
                    state: Classic
                        a: Отлично! Вот лучшая классика о любви:
                        buttons: 
                            "Дама с собачкой, Антона Чехова" -> /Welcome/Choice/Rus/Romance/Classic/Chekhov
                            "Мастер и Маргарита, Михаила Булгакова" -> /Welcome/Choice/Rus/Romance/Classic/Bulgakov
                            "Анна Каренина, Лев Толстой" -> /Welcome/Choice/Rus/Romance/Classic/Tolstoy
                        state: Chekhov
                            a: Рассказ рождении неожиданной любви, любви, которую ни одна из вовлеченных сторон активно не искала. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Romance/Classic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Bulgakov
                            a: Это русский пример магического реализма, где коты ездят в трамваях, а деньги падают с неба. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Romance/Classic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Tolstoy
                            a: Для самого автора – это, прежде всего, семейный роман, роман о любви, которая, соединив две половинки, перерастает в нечто большее: в семью, детей.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Romance/Classic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                    state: Modern
                        a: Супер! Вот современные истории любви:
                        buttons:
                            "Мы же взрослые люди, Юлия Гурина" -> /Welcome/Choice/Rus/Romance/Modern/Gurina 
                            "Шесть дней, Сергей Вересков" -> /Welcome/Choice/Rus/Romance/Modern/Vereskov
                            "Опыты бесприютного неба, Степан Гаврилов" -> /Welcome/Choice/Rus/Romance/Modern/Gavrilov
                        state: Gurina
                            a: Роман вполне можно поставить на одну полку с Лианой Мориарти и Джоджо Мойес – писательнице удалось создать роман, с одной стороны, лёгкий, а с другой – глубокий, захватывающий и актуальный. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Romance/Modern
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Vereskov
                            a: Дебютный роман написан человеком, который не стесняется своей молодости, то есть не боится чего-то не знать, не анализировать, не понимать. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Romance/Modern
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Gavrilov
                            a: Попытка дать голос поколению 90-х, отрефлексировать хотя бы какие-то события современности. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Romance/Modern
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        
                state: Fantasy
                    a: Давай уточним: фэнтези или научная фантастика?
                    buttons:
                        "Фэнтези" -> /Welcome/Choice/Rus/Fantasy/Fiction
                        "Научная фантастика" -> /Welcome/Choice/Rus/Fantasy/Science
                    
                    state: Fiction
                        a: Класс! Вот топ русских книг в жанре фэнтези:
                        buttons:
                            "Ночной Дозор, Сергей Лукьяненко" -> /Welcome/Choice/Rus/Fantasy/Fiction/Lukyanenko
                            "Профессия: ведьма, Ольга Громыко" -> /Welcome/Choice/Rus/Fantasy/Fiction/Gromyko
                            "Академия Проклятий, Елена Звёздная" -> /Welcome/Choice/Rus/Fantasy/Fiction/Zvezdnaya
                        state: Lukyanenko
                            a: Действие происходит в вымышленном мире Иных, где живут различные существа: маги, ведьмы, вампиры. В темное время суток они становятся активными, но можно быть спокойным, за ними следует Ночной дозор. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Fantasy/Fiction
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Gromyko
                            a: Это история правителя небольшого государства, в котором царит не очень хорошая атмосфера.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Fantasy/Fiction
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Zvezdnaya
                            a: Адептка Академии проклятий запускает цепь странных событий. Она ничего такого не хотела, всего лишь прокляла могущественного Лорда Темной Империи.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Fantasy/Fiction
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        
                    state: Science
                        a: Хорошо! Вот подборка отечественной научной фантастики:
                        buttons:
                            "Там, Алексей Калугин" -> /Welcome/Choice/Rus/Fantasy/Science/Kalugin
                            "Карантинная зона, Павел Шушканов" -> /Welcome/Choice/Rus/Fantasy/Science/Shushkanov
                            "Вершители реальности, Светлана Свирина" -> /Welcome/Choice/Rus/Fantasy/Science/Svirina
                        state: Kalugin
                            a: В недалеком будущем ИИ победил. Городом управляет компьютер Инфор, полностью обеспечивая жителей всем необходимым.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Fantasy/Science
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Shushkanov
                            a: Добро пожаловать в зону искажений! Здесь не наступает ночь, нет вирусов, старение клеток остановлено.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Fantasy/Science
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state:Svirina
                            a: 1970 год, Байконур. Ракета с командой ученых таинственно исчезает во время полета.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Fantasy/Science
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                            
                state: Detectives
                    a: Давай выберем одного из русских мастеров детективного жанра:
                    buttons:
                        "Борис Акунин" -> /Welcome/Choice/Rus/Detectives/Akunin
                        "Валерия Вербинина" -> /Welcome/Choice/Rus/Detectives/Verbinina
                        "Татьяна Устинова" -> /Welcome/Choice/Rus/Detectives/Ustinova
                    state: Akunin
                        a: Вот популярные книги Акунина.
                        buttons:
                            "Азазель" -> /Welcome/Choice/Rus/Detectives/Akunin/Azazel
                            "Пелагия и белый бульдог" -> /Welcome/Choice/Rus/Detectives/Akunin/Pelagia
                            "Левиафан" -> /Welcome/Choice/Rus/Detectives/Akunin/Leviathan
                            "Назад" -> /Welcome/Choice/Rus/Detectives/
                        state: Azazel
                            a: Убийство богатого бизнесмена и исчезновение молодой женщины, сеть коррупции и обмана, которая доходит до самых высоких слоев общества.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Akunin
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Pelagia
                            a: Действие книги происходит в Заволжской губернии XIX века, куда из столицы приезжает инспектор Бубенцов. Ему предстоит расследовать появление в губернии язычества. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Akunin
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Leviathan
                            a: В 1878 году в блистательном Париже произошло неординарное событие: были убиты лорд Литтлби и девять его слуг.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Akunin
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                    state: Verbinina
                        a: Вот популярные книги Вербининой.
                        buttons:
                            "Московское время" -> /Welcome/Choice/Rus/Detectives/Verbinina/Time
                            "Амалия под ударом" -> /Welcome/Choice/Rus/Detectives/Verbinina/Amalia
                            "Театральная площадь" -> /Welcome/Choice/Rus/Detectives/Verbinina/Theater
                            "Назад" -> /Welcome/Choice/Rus/Detectives/
                        state: Time
                            a: Цвет советской элиты несет потери: друг за другом гибнут известный журналист, фотокорреспондент ТАСС и переводчица "Интуриста", причем убийства старательно скрывают от народа.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Verbinina
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Amalia
                            a: Неоднократные покушения на ее жизнь вынуждают мадемуазель Амалию Тамарину стать детективом поневоле.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Verbinina
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Theater
                            a: Пропадает один из артистов балета, и сыщик уголовного розыска Иван Опалин понимает, что в храме искусства не все безоблачно.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Verbinina
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice

            
                    state: Ustinova
                        a: Вот популярные книги Устиновой.
                        buttons:
                            "Хроника гнусных времен" -> /Welcome/Choice/Rus/Detectives/Ustinova/Chronicle
                            "Мой личный враг" -> /Welcome/Choice/Rus/Detectives/Ustinova/Enemy
                            "Седьмое небо" -> /Welcome/Choice/Rus/Detectives/Ustinova/Seventh
                            "Назад" -> /Welcome/Choice/Rus/Detectives/
                        state: Chronicle
                            a: Кирилл никак не предполагал, что девушка в очках по имени Настя окажется ему настолько дорога, и он, плюнув на поездку в Дублин, будет заниматься расследованием смерти ее бабушки!
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Ustinova
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Enemy
                            a: Что делать, если твоя жизнь превратилась в кошмар? Тележурналистке Александре Потаповой кажется, что кругом одни только враги.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Ustinova
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Seventh
                            a: Лидия Шевелева, корреспондент газеты "Время, вперед!", и не подозревала, что стала пешкой в большой игре, когда получила из анонимного источника потрясающие материалы.
                            buttons:
                                "Назад" -> /Welcome/Choice/Rus/Detectives/Ustinova
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice

                state: Horrors
        
            
            
            state: Foreign
        #       a: Какой жанр тебе интересен?
                #buttons:
                    #"Романтика" -> /Welcome/Choice/Foreign/Romance
                    #"Фэнтези" -> /Welcome/Choice/Foreign/Fantasy
                    #"Детектив" -> /Welcome/Choice/Foreign/Detectives
                    #"Ужасы" -> /Welcome/Choice/Foreign/Horrors
                #state: Romance
                    #a: Ищем классическое произведение или зарубежные новинки? 
            #    buttons:
             #       "Зарубежная классика" -> /Welcome/Choice/Foreign/Romance/Classic
              #      "Зарубежные новинки" -> /Welcome/Choice/Foreign/Romance/Modern
               # state: Classic
                
                #state: Modern
                
                
        #    state: Fantasy
         #   state: Detectives
          #  state: Horrors
    
    
    
    
        state: New
            q!: *(нов*)*
            a: Хорошо! Выбери жанр, который тебя интересует. Я покажу, какие новинки ожидаются в этом жанре в 2023 году.
            buttons:
                "Романтика" -> /Welcome/New/Romance
                "Фэнтези" -> /Welcome/New/Fantasy
                "Детектив" -> /Welcome/New/Detectives
                "Ужасы" -> /Welcome/New/Horrors
            state: Romance
                a: **Новинки жанра "Романтика"**
                buttons:
                    "Разрушительная любовь, Ана Хуан" -> /Welcome/New/Romance/R_1
                    "Только попробуй уйти,Ася Лавринович" -> /Welcome/New/Romance/R_2
                    "Пленённая принцесса, Софи Ларк" -> /Welcome/New/Romance/R_3
                state: R_1
                    a: Иногда разрушительная любовь приходит не для того, чтобы разбить сердце, а для того, чтобы собрать его по кусочкам. 
                    buttons:
                        "Назад" -> /Welcome/New/Romance
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: R_2
                    a: Легкая, летняя, милая романтическая книга, которая дарит чарующую атмосферу отдыха в деревне. 
                    buttons:
                        "Назад" -> /Welcome/New/Romance
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: R_3
                    a: Жаркий и чувственный роман о мафии.
                    buttons:
                        "Назад" -> /Welcome/New/Romance
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New

            state: Fantasy
                a: **Новинки жанра "Фэнтези"**
                buttons:
                    "Утраченный металл, Брендон Сандерсон" -> /Welcome/New/Fantasy/F_1
                    "На руинах империи,Брайан Стейвли" -> /Welcome/New/Fantasy/F_2
                    "Цветок яблони, Алексей Пехов" -> /Welcome/New/Fantasy/F_3
                state: F_1
                    a: Магия и технологии легко уживаются в этом интереснейшем мире, созданном одним из самых именитых фантастов современности.
                    buttons:
                        "Назад" -> /Welcome/New/Fantasy
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: F_2
                    a: Увлекательное исследование того, как империи падают и что происходит после их разрушения. 
                    buttons:
                        "Назад" -> /Welcome/New/Fantasy
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: F_3
                    a: Демоны пришли из мрака и ночь окрашена в цвет крови. Война разгорается. 
                    buttons:
                        "Назад" -> /Welcome/New/Fantasy
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
            
            state: Detectives
                a: **Новинки жанра "Детектив"**
                buttons:
                    "Книга несчастных случаев,Чак Вендиг" -> /Welcome/New/Detectives/D_1
                    "Снежная девочка, Хавьер Кастильо" -> /Welcome/New/Detectives/D_2
                    "Скала Жнеца, Сара Пирс" -> /Welcome/New/Detectives/D_3
                state: D_1
                    a: Когда-то одержимый числами маньяк Эдмунд Риз провалил миссию, которую считал священной, – убить 99 девочек в парке Рэмбл-Рок.
                    buttons:
                        "Назад" -> /Welcome/New/Detectives
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: D_2
                    a: Ровно пять лет с момента загадочного исчезновения дочери убитые горем родители получают странную посылку: кассету, на которой их подросшая девочка играет в незнакомой комнате. 
                    buttons:
                        "Назад" -> /Welcome/New/Detectives
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: D_3
                    a: На острове у побережья Англии открылся идиллический курорт, обещающий своим гостям первоклассный отдых. Вот только у этого места, известного как Скала Жнеца, очень дурная слава. Несколько лет назад тут произошла серия жестоких убийств…
                    buttons:
                        "Назад" -> /Welcome/New/Detectives
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New

            state: Horrors
                a: **Новинки жанра "Ужасы"**
                buttons:
                    "Как продать дом с привидениями, Грейди Хендрикс" -> /Welcome/New/Horrors/H_1
                    "Скажи мне, что я ничего не стою,Элисон Румфитт" -> /Welcome/New/Horrors/H_2
                    "Наша доля ночи, Мариана Энрикес" -> /Welcome/New/Horrors/H_3
                state: H_1
                    a: Родители Луизы скончались, и она возвращается в маленький южный городок, где выросла, чтобы подготовить их дом к продаже. Это означает, что ей придется проводить время со своим младшим братом — и их старые обиды делают это ужасающей перспективой. Но детские обиды бледнеют по сравнению с опасностями, исходящими от того, что все еще живет внутри дома.
                    buttons:
                        "Назад" -> /Welcome/New/Horrors
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: H_2
                    a: Мрачная, непоколебимая история о доме с привидениями, которая противостоит как сверхъестественным, так и реальным ужасам/
                    buttons:
                        "Назад" -> /Welcome/New/Horrors
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
                state: H_3
                    a: Волшебная смесь готики, фантастики и глубокого реализма, граничащего с экзистенциальным, приобретает в этом романе поразительную неожиданность.
                    buttons:
                        "Назад" -> /Welcome/New/Horrors
                        "То, что надо!" -> /Welcome/Reaction_Pos
                        "Другой жанр" -> /Welcome/New
            
        state: Reaction_Pos
            a: Ура! Приятного чтения! 
                \nХочешь посмотреть, что нового есть в других жанрах?
            buttons:
                "Другой жанр" -> /Welcome/New
                "Нет, спасибо!" -> /Leave
            
        state: Facts
            q!: *(интересн*/факт*)*
            a: Спасаясь с горящего корабля, Тургенев расталкивал женщин и детей и даже пытался подкупить матроса. Позже он устыдился своей выходки и в качестве покаяния описал ее в очерке «Пожар на море».
            inlineButtons:
                { text: "Пожар на море", url: "https://онлайн-читать.рф/тургенев-пожар-на-море/" }
    
    
    state: CatchAll
        event!: noMatch
        random:
            a: Извини, я не понял. Пожалуйста, попробуй сформулировать иначе.
            a: Прости, боюсь, я тебя не понял. Можешь задать вопрос по-другому?

    state: Leave
        a: Удалось найти всё, что искал?
        state: Yes
            q: *(ага/угу/да*/хват*/достаточно)*
            a: Супер! Я очень рад, что смог тебе помочь :)
        state: No
            q: *(не*/не(*нрав*/подошл*/подход*)/откаж*/фигня/отстой/фу)*
            a: Давай посмотрим другие варинаты?
            buttons:
                "Попробовать" -> /Welcome/Choice
                "Уйти" -> /Sad_bye
    state: Sad_bye
        a: Всего доброго! Я обещаю, в следующий раз, когда ты вернешься, я стану лучше!
    state: Bye
        q!: *(пок*/до свидания/до*/бывай)*
        random:
            a: Пока пока!
            a: До скорой встречи!
            a: Ещё увидимся!