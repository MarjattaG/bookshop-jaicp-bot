require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        q!: *(прив*/здравствуй*/*даров*/добр*)*
        random:
            a: Привет, привет!
            a: Доброго времени суток!
            a: Приветствую! Рад встрече!


    
    
    
    
    state: Bye
        q!: *(пока/до свидания/до*)*
        random:
            a: Пока пока!
            a: До скорой встречи!
            a: Ещё увидимся!

   state: CatchAll
        event!: noMatch
        random:
        a: Извините, я вас не понял. Пожалуйста, попробуйте сформулировать иначе.
        a: Простите, боюсь, я вас не понял. Сформулируйте иначе.