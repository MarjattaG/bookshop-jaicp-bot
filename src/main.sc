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
                    "Назад" -> /Welcome/Choice
    
                state: Romance
                    a: Хочется классики или современных авторов?
                    buttons:
                        "Отечественная классика" -> /Welcome/Choice/Rus/Romance/Classic
                        "Современные авторы" -> /Welcome/Choice/Rus/Romance/Modern
                        "Назад" -> /Welcome/Choice/Rus
            
                    state: Classic
                        a: Отлично! Вот лучшая классика о любви:
                        buttons: 
                            "Дама с собачкой, Антона Чехова" -> /Welcome/Choice/Rus/Romance/Classic/Chekhov
                            "Мастер и Маргарита, Михаила Булгакова" -> /Welcome/Choice/Rus/Romance/Classic/Bulgakov
                            "Анна Каренина, Лев Толстой" -> /Welcome/Choice/Rus/Romance/Classic/Tolstoy
                            "Назад" -> /Welcome/Choice/Rus/Romance
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
                            "Назад" -> /Welcome/Choice/Rus/Romance
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
                        "Назад" -> /Welcome/Choice/Rus
                    
                    state: Fiction
                        a: Класс! Вот топ русских книг в жанре фэнтези:
                        buttons:
                            "Ночной Дозор, Сергей Лукьяненко" -> /Welcome/Choice/Rus/Fantasy/Fiction/Lukyanenko
                            "Профессия: ведьма, Ольга Громыко" -> /Welcome/Choice/Rus/Fantasy/Fiction/Gromyko
                            "Академия Проклятий, Елена Звёздная" -> /Welcome/Choice/Rus/Fantasy/Fiction/Zvezdnaya
                            "Назад" -> /Welcome/Choice/Rus/Fantasy
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
                            "Назад" -> /Welcome/Choice/Rus/Fantasy
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
                        "Назад" -> /Welcome/Choice/Rus
                
                    state: Akunin
                        a: Вот популярные книги Акунина.
                        buttons:
                            "Азазель" -> /Welcome/Choice/Rus/Detectives/Akunin/Azazel
                            "Пелагия и белый бульдог" -> /Welcome/Choice/Rus/Detectives/Akunin/Pelagia
                            "Левиафан" -> /Welcome/Choice/Rus/Detectives/Akunin/Leviathan
                            "Назад" -> /Welcome/Choice/Rus/Detectives
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
                            "Назад" -> /Welcome/Choice/Rus/Detectives
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
                            "Назад" -> /Welcome/Choice/Rus/Detectives
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
                    a: Вот подборка отличных хорроров от российских писателей:
                    buttons:
                        "Как закалялась жесть, Александр Щеголев" -> /Welcome/Choice/Rus/Horrors/Shchegolev
                        "Ночной смотрящий, Олег Дивов" -> /Welcome/Choice/Rus/Horrors/Divov
                        "Убыр, Шамиль Идиатуллин" -> /Welcome/Choice/Rus/Horrors/Idiatullin
                        "Назад" -> /Welcome/Choice/Rus/
        
                    state: Shchegolev
                        a: Произведение посвящено подпольной торговле человеческими частями тела, которые омерзительные эскулапы берут у еще живых «доноров» против их воли.
                        buttons:
                            "Назад" -> /Welcome/Choice/Rus/Horrors
                            "То, что надо!" -> /Welcome/Reaction_Pos
                            "Другие варианты" -> /Welcome/Choice
                    state: Divov
                        a: Книга, стоящая на стыке темного городского фэнтези и мистического хоррора, освещающая жизнь и взаимоотношения между вампирами, оборотнями и прочими представителями осовремененной нечисти, а также о вполне обычных людях, которые порой оказываются страшнее и омерзительнее всяких чудовищ.
                        buttons:
                            "Назад" -> /Welcome/Choice/Rus/Horrors
                            "То, что надо!" -> /Welcome/Reaction_Pos
                            "Другие варианты" -> /Welcome/Choice
                    state: Idiatullin
                        a:  Главные герои – брат и сестра, которые находятся в беспрерывном бегстве от чего-то зловещего и могущественного.
                        buttons:
                            "Назад" -> /Welcome/Choice/Rus/Horrors
                            "То, что надо!" -> /Welcome/Reaction_Pos
                            "Другие варианты" -> /Welcome/Choice
            
            state: Foreign
                a: Какой жанр тебе интересен?
                buttons:
                    "Романтика" -> /Welcome/Choice/Foreign/Romance
                    "Фэнтези" -> /Welcome/Choice/Foreign/Fantasy
                    "Детектив" -> /Welcome/Choice/Foreign/Detectives
                    "Ужасы" -> /Welcome/Choice/Foreign/Horrors
                    "Назад" -> /Welcome/Choice
                
                state: Romance
                    a: Ищем классическое произведение или современных авторов? 
                    buttons:
                        "Зарубежная классика" -> /Welcome/Choice/Foreign/Romance/Classic
                        "Зарубежные современники" -> /Welcome/Choice/Foreign/Romance/Modern
                        "Назад" -> /Welcome/Choice/Foreign
        
                    state: Classic
                        a: Хорошо! Вот лучшие книги зарубежной классики:
                        buttons:
                            "Граф Монте-Кристо, Александр Дюма" -> /Welcome/Choice/Foreign/Romance/Classic/Dumas
                            "Собор Парижской Богоматери, Виктор Гюго" -> /Welcome/Choice/Foreign/Romance/Classic/Hugo
                            "Ромео и Джульетта, Уильям Шекспир" -> /Welcome/Choice/Foreign/Romance/Classic/Shakespeare
                            "Назад" -> /Welcome/Choice/Foreign/Romance
                        state: Dumas
                            a:  В этом приключенческом романе повествуется история моряка Эдмона Дантеса, который на своем пути встречает несправедливость и предательство, из-за чего попадает под заключение на 14 лет.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Romance/Classic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Hugo
                            a: Главной героиней культового романа является танцовщица Эсмеральда, о нелегкой судьбе которой и повествует автор.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Romance/Classic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Shakespeare
                            a: В трагедии одного из величайших драматургов мира Уильяма Шекспира повествуется о любви юноши и девушки из двух родов, которые постоянно враждуют между собой. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Romance/Classic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                    state: Modern
                        a: Хорошо! Вот топ самых красивых любовных романов современных зарубежных авторов:
                        buttons:
                            "Грешник (#1), Эмма Скотт" -> /Welcome/Choice/Foreign/Romance/Modern/Scott
                            "У любви на крючке, Тесса Бейли" -> /Welcome/Choice/Foreign/Romance/Modern/Bailey
                            "Пока бьётся сердце, Дженнифер Хартманн" -> /Welcome/Choice/Foreign/Romance/Modern/Hartmann
                            "Назад" -> /Welcome/Choice/Foreign/Romance
                        state: Scott
                            a: Нетипичный роман, в котором Скотт обращается к романтике ангелов и демонов. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Romance/Modern
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Bailey
                            a: Бестселлер о сестрах Беллинджер и их любовных историях, происходящих в декорациях небольшого рыбацкого городка. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Romance/Modern
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Hartmann
                            a:  Врагам предстоит объединиться, чтобы спастись, а после – справиться с травмами, построить заново жизнь и отношения.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Romance/Modern
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                
                state: Fantasy
                    a: Мистика или боевик? 
                    buttons:
                        "Мистическая зарубежная фантастика" -> /Welcome/Choice/Foreign/Fantasy/Mystery
                        "Фантастический зарубежный боевик" -> /Welcome/Choice/Foreign/Fantasy/Action
                        "Назад" -> /Welcome/Choice/Foreign
        
                    state: Mystery
                        a: Отличено! Вот лучшее среди мистических фантастических романав:
                        buttons:
                            "Четыре жизни Хелен Ламберт, Констанс Сэйерс" -> /Welcome/Choice/Foreign/Fantasy/Mystery/Sayers
                            "Женщина в песках, Кобо Абэ" -> /Welcome/Choice/Foreign/Fantasy/Mystery/Abe
                            "Лавка дурных снов, Стивен Кинг" -> /Welcome/Choice/Foreign/Fantasy/Mystery/King
                            "Назад" -> /Welcome/Choice/Foreign/Fantasy
                        state: Sayers
                            a:  Чтобы разорвать проклятый круг смерти, перерождений и любовных интриг, делающих несчастной её и других, Хелен придётся пожертвовать самым дорогим.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Fantasy/Mystery
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Abe
                            a: Кобо Абэ – знаменитый японский прозаик и драматург. Эти своеобразные романы-притчи повествуют о людях, находящихся под властью навязчивой идеи или оказавшихся в ситуации, похожей на фантастический сон.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Fantasy/Mystery
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: King
                            a: Захватывающие и пугающие, будоражащие воображение и предостерегающие, эти рассказы — маленькие шедевры, которые мог написать только великий Стивен Кинг. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Fantasy/Mystery
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                    state: Action
                        a: Супер! Вот лучшие фантастические зарубежные боевики:
                        buttons:
                            "Царства смерти, Кристофер Рокко" -> /Welcome/Choice/Foreign/Fantasy/Action/Rocco
                            "Последняя сказительница, Донна Игера" -> /Welcome/Choice/Foreign/Fantasy/Action/Higuera
                            "Тираны и мстители, Брендон Сандерсон" -> /Welcome/Choice/Foreign/Fantasy/Action/Sanderson
                            "Назад" -> /Welcome/Choice/Foreign/Fantasy
                        state: Rocco
                            a: Жертва придворных интриг, Адриан Морло, прозванный Пожирателем Солнца, отправляется в ссылку на далекую планету.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Fantasy/Action
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Higuera
                            a: Через несколько дней Земля погибнет. Человечество должно немедленно покинуть планету, но космических корабля всего три.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Fantasy/Action
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Sanderson
                            a: Через год после того, как в небесах засияла кровавая звезда Напасть, на Земле появились эпики - загадочные существа, обладающие феноменальными способностями, природу которых не понимают даже они сами.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Fantasy/Action
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                
                state: Detectives
                    a: Лучшие зарубежные детективы всех времён:
                    buttons:
                        "Убийство на улице Морг, Эдгар Аллан По" -> /Welcome/Choice/Foreign/Detectives/Poe
                        "Молчание ягнят, Томас Харрис" -> /Welcome/Choice/Foreign/Detectives/Harris
                        "Скрюченный домишко, Агата Кристи" -> /Welcome/Choice/Foreign/Detectives/Christie
                        "Назад" -> /Welcome/Choice/Foreign
    
                    state: Poe
                        a: Когда в Париже случается загадочное и крайне жестокое убийство двух женщин, в дело включается Андре Дюпен — молодой человек с нетривиальными способностями к аналитике.
                        buttons:
                            "Назад" -> /Welcome/Choice/Foreign/Detectives
                            "То, что надо!" -> /Welcome/Reaction_Pos
                            "Другие варианты" -> /Welcome/Choice
                    state: Harris
                        a: Курсантка академии ФБР пытается найти серийного убийцу, с особой жестокостью действующего в окрестностях города.
                        buttons:
                            "Назад" -> /Welcome/Choice/Foreign/Detectives
                            "То, что надо!" -> /Welcome/Reaction_Pos
                            "Другие варианты" -> /Welcome/Choice
                    state: Christie
                        a: Среди всех романов, написанных королевой детектива, этот считается одним из лучших из-за увлекательности сюжета и непредсказуемости финала. 
                        buttons:
                            "Назад" -> /Welcome/Choice/Foreign/Detectives
                            "То, что надо!" -> /Welcome/Reaction_Pos
                            "Другие варианты" -> /Welcome/Choice
                    
                    
                state: Horrors
                    a: Ищем книгу или графический роман? 
                    buttons:
                        "Книги ужасов" -> /Welcome/Choice/Foreign/Horrors/Books
                        "Графичесике романы" -> /Welcome/Choice/Foreign/Horrors/Graphic
                        "Назад" -> /Welcome/Choice/Foreign
    
                    state: Books
                        a: Самые страшные книги, ужасы и мистика:
                        buttons:
                            "Хребты безумия, Говард Лавкрафт" -> /Welcome/Choice/Foreign/Horrors/Books/Lovecraft
                            "Косиног. История о колдовстве, Бром" -> /Welcome/Choice/Foreign/Horrors/Books/Brom
                            "Дом на Холодном холме, Питер Джеймс" -> /Welcome/Choice/Foreign/Horrors/Books/James
                            "Назад" -> /Welcome/Choice/Foreign/Horrors
                        state: Lovecraft
                            a: Необычная документальная манера повествования делает читателей свидетелями особой реальности описываемых событий.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Horrors/Books
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Brom
                            a: Наводящее ужас сказание о волшебстве обязательно понравится поклонникам жанра, ведь читатели столкнутся с самим Косиногом, демоном, дьяволом.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Horrors/Books
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: James
                            a: Автор погружает читателей в ужасное прошлое дома на Холодном холме.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Horrors/Books
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                    state: Graphic
                        a: Лучшие комиксы в жанре ужасов: 
                        buttons:
                            "Бэтмен. Долгий Хэллоуин, Джеф Лоэб " -> /Welcome/Choice/Foreign/Horrors/Graphic/Loeb
                            "Черная дыра, Чарльз Бернс" -> /Welcome/Choice/Foreign/Horrors/Graphic/Burns
                            "Голограф на Радужном поле, Инио Асано" -> /Welcome/Choice/Foreign/Horrors/Graphic/Asano
                            "Назад" -> /Welcome/Choice/Foreign/Horrors
                        state: Loeb
                            a: Происходящий во времена первых шагов Бэтмена на дороге борьбы с преступностью «Долгий Хэллоуин» повествует о загадочном убийце по прозвищу Праздник, отмечающем красные даты календаря кровью очередной жертвы.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Horrors/Graphic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Burns
                            a: Этот недуг поражал не только тинейджеров. Одни называли его молодежной чумой, другие - просто заразой. Но самое ужасное было в том, что если болезнь тебя пометила, ты становился изгоем навсегда. 
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Horrors/Graphic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                        state: Asano
                            a: Детские страшилки, монстр, живущий в тоннеле, семейные секреты, необычно большая популяция бабочек — все эти отдельные ниточки переплетаются в едином узоре Апокалипсиса Новой Эры.
                            buttons:
                                "Назад" -> /Welcome/Choice/Foreign/Horrors/Graphic
                                "То, что надо!" -> /Welcome/Reaction_Pos
                                "Другие варианты" -> /Welcome/Choice
                            
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
                    "Только попробуй уйти, Ася Лавринович" -> /Welcome/New/Romance/R_2
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
                \nХочешь познакомиться с новинками других жанров?
            buttons:
                "Другой жанр" -> /Welcome/New
                "Нет, спасибо!" -> /Leave
            
        state: Facts
            q!: *(интересн*/факт*)*
            random:
                image: https://drasler.ru/wp-content/uploads/2019/06/Картинки-о-книгах-о-чтении-фото003.jpg
                a: Спасаясь с горящего корабля, Тургенев расталкивал женщин и детей и даже пытался подкупить матроса. Позже он устыдился своей выходки и в качестве покаяния описал ее в очерке «Пожар на море».
                a: В 1931 году тело Гоголя решили перезахоронить. При вскрытии гроба оказалось, что на месте все... кроме головы Николая Васильевича. Кому и зачем могла понадобиться эта часть тела Гоголя, доподлинно неизвестно, она не найдена до сих пор.
                image: https://wl-adme.cf.tsp.li/resize/728x/jpg/012/557/6a191355ef8ad1d713d602b4a4.jpg
    
    state: CatchAll
        event!: noMatch
        random:
            a: Извини, я не понял. Пожалуйста, попробуй сформулировать иначе.
            a: Прости, боюсь, я тебя не понял. Можешь задать вопрос по-другому?

    state: Leave
        a: Удалось найти всё, что искал?
        state: Yes
            q: *(ага/угу/да/конечно/вполне/разумеется)*
            a: Супер! Я очень рад, что смог тебе помочь! 
                \nХочешь поделиться своими впечатлениями?
            buttons:
                "Дать обратную связь" -> /Feedback
                "Воздержусь" -> /Bye
        state: No
            q: *(не*/не(*нрав*/подошл*/подход*)/откаж*/фигня/отстой/фу)*
            a: Давай посмотрим другие варинаты, или расскажи, что пошло не так?
            buttons:
                "Попробовать еще раз" -> /Welcome/Choice
                "Дать обратную связь" -> /Feedback
                "Уйти" -> /Sad_bye
    
    state: Feedback
        InputText:
            prompt = Каковы твои впечатления от общения со мной?
            varName = feedback
            then = /Feedback/GetFeedback

        state: GetFeedback
            a: Спасибо за обратную связь! До встречи!
            script:
                $analytics.setSessionData("Отзыв о качестве услуг", $session.feedback);
                $jsapi.stopSession();
            EndSession:
                
    state: Sad_bye
        a: Всего доброго! Я обещаю, в следующий раз, когда ты вернешься, я стану лучше!
        EndSession:
        
    state: Bye
        q!: *(пок*/до свидания/до*/бывай)*
        random:
            a: Пока, пока!
            a: До скорой встречи!
            a: Ещё увидимся!
        EndSession:
      