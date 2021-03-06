package com.example.vkfragmentkotlin.models

import com.example.vkfragmentkotlin.R

object DataNews {

    val newsBIG : MutableList<News> = ArrayList()

    init {
        val imageNames = arrayListOf<String>()
        val timeName = arrayListOf<String>()
        val contentNames = arrayListOf<String>()
        val images = arrayListOf<Int>()
        val contentImages = arrayListOf<Int>()

        imageNames.add("PSD")
        timeName.add("15 минут назад")
        contentNames.add("Использовать шаблон можно практически во всех нишах, за исключением сфер, связанных с детьми, для них подобная цветовая схема будет слишком тёмной и строгой.")
        images.add(R.drawable.beat)
        contentImages.add(R.drawable.post1)

        imageNames.add("Tesla")
        timeName.add("47 минут назад")
        contentNames.add("Компания Tesla отзовет около 15 тыс. кроссоверов Model X из-за потенциальных \n" +
                "                проблем, которые могут привести к потере мощности усилителя руля и привести к аварии, сообщает Reuters.")
        images.add(R.drawable.acc2)
        contentImages.add(R.drawable.post2)

        imageNames.add("Новости с Востока")
        timeName.add("30 минут назад")
        contentNames.add("В ночь на 28 февраля сирийская армия нанесла удары по позициям турецких войск в районе Джебель-аз-Завия. Как стало известно позже, в результате обстрела погибли 33 военнослужащих, еще 32 получили ранения. В ответ Турция нанесла удары по позициям сирийской армии. В частности, сообщалось, что турецкие силы уничтожили конвой правительственных войск Сирии на востоке провинции Идлиб.")
        images.add(R.drawable.acc3)
        contentImages.add(R.drawable.post3)

        imageNames.add("Ким Чен Ын")
        timeName.add("30 минут назад")
        contentNames.add("Северная Корея — это разруха, голод и диктатура, а Южная — рай с «Самсунгом», кей-попом и демократией. Примерно так рассуждают люди, воспитанные на антикимовской пропаганде. Между тем реальность куда сложнее и интереснее. Специально для «Ленты.ру» известный российский кореист Константин Асмолов написал цикл статей об истории Корейского полуострова и двух государств, бывших некогда одним целым. В прошлый раз мы рассказывали, как в Южной Корее 1980-х одна диктатура сменилась другой, а протестующих давили танками. В этот раз речь пойдет о том, как президент Чон Ду Хван создавал собственный культ и расправлялся с несогласными, и в то же время дружил с США и улучшал образ страны.")
        images.add(R.drawable.acc4)
        contentImages.add(R.drawable.post4)

        imageNames.add("Мировые новости")
        timeName.add("25.02.2020")
        contentNames.add("Конгрессмены в итоговом голосовании по импичменту признали президента США невиновным по обоим пунктам обвинения — в злоупотреблении властью и препятствовании работе Конгресса. За его оправдание по первому свои голоса отдали 52 из 100 сенаторов, по второму — 53. Таким образом, не было набрано двух третей голосов (67), необходимых для признания Трампа виновным и отстранения от власти, он останется на своем посту.")
        images.add(R.drawable.acc5)
        contentImages.add(R.drawable.post5)

        imageNames.add("Угол для беседы")
        timeName.add("пол года назад")
        contentNames.add("Кабус бен Саид Аль Саид был султаном Омана без малого 50 лет — вплоть до своей смерти 10 января. Он взошел на престол на британских штыках, сместив собственного отца в результате дворцового переворота. Но молодой правитель, придя к власти, не почивал на лаврах, окружая себя роскошью, как многие султаны. Его правление буквально преобразило страну, которая стала одним из образцов просвещенной монархии. «Лента.ру» вспомнила, как Кабус — так кратко именуют его в арабском мире — превратил феодальный рабовладельческий Оман, недавнюю колонию, в самое стабильное государство арабского мира, которое сравнивают с Сингапуром и Норвегией.")
        images.add(R.drawable.acc6)
        contentImages.add(R.drawable.post6)

        imageNames.add("Бешеный Майк")
        timeName.add("Год назад")
        contentNames.add("На минувшей неделе, 2 февраля, в ЮАР в возрасте 100 лет умер один из самых знаменитых наемников в мире Майкл Хоар. Он много лет сражался за британскую корону, затем воевал с коммунистами, устраивал перевороты и угонял самолет. «Лента.ру» вспоминает историю простого бухгалтера мистера Хоара, который превратился в профессионального наемника по прозвищу Бешеный Майк, много раз мог погибнуть, но мирно скончался, дожив до глубокой старости.")
        images.add(R.drawable.acc7)
        contentImages.add(R.drawable.post7)

        imageNames.add("История и все что вокруг")
        timeName.add("2 года назад")
        contentNames.add("Египетские пирамиды и Большой сфинкс — самые древние строения в мире и единственные из семи чудес света, сохранившиеся до настоящего времени. Они простояли несколько тысяч лет, но сейчас им угрожает гибель. Как сохранить бесценное наследие Древнего Египта для будущих поколений? Существовал ли возле Великих пирамид второй сфинкс? Что мешает жителям современного Египта считаться полноценными наследниками великой цивилизации долины Нила? Обо все этом «Ленте.ру» рассказал кандидат исторических наук, научный сотрудник Центра египтологических исследований РАН, член Международной ассоциации египтологов Роман Орехов.")
        images.add(R.drawable.acc8)
        contentImages.add(R.drawable.post8)

        imageNames.add("Aliens")
        timeName.add("3 года назад")
        contentNames.add("В репозитории arXiv.org появился препринт статьи о первом в истории обнаружении повторяющегося быстрого радиовсплеска с устойчивым периодом активности 16 дней. FRB 180916.J0158+65 испускает мощные пучки радиоволн с завидной регулярностью, что породило слухи об искусственном происхождении источника. «Лента.ру» рассказывает, действительно ли стоит предполагать, что таинственные сигналы из космоса посылаются инопланетными цивилизациями.")
        images.add(R.drawable.acc9)
        contentImages.add(R.drawable.post9)

        imageNames.add("Угол для беседы")
        timeName.add("27.03.2015")
        contentNames.add("Выяснилось, что на борту МКС были обнаружены два вида бактерий. Они появились в дозаторе воды и, вероятно, были там еще до запуска устройства в космос. Однако они не представляют большей опасности, чем эти микробы на Земле.")
        images.add(R.drawable.acc10)
        contentImages.add(R.drawable.post10)

        for (i in  0..imageNames.size-1){
            val news =  News(
                imageNames.get(i),
                timeName.get(i),
                contentNames.get(i),
                images.get(i),
                contentImages.get(i),
                i,
                i,
                i,
                i,
                0,
                R.drawable.ic_favorite_black
            )
            newsBIG.add(news)
        }
    }
}