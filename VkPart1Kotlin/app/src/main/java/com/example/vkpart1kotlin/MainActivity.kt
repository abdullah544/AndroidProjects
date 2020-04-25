package com.example.vkpart1kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.RecyclerViewItemClick {

    lateinit var recyclerView : RecyclerView
    private var newsAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rec)
        recyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = RecyclerViewAdapter(GenerateNews(),itemClickListener = this)
        recyclerView.adapter = newsAdapter
    }

    override fun itemClick(position: Int, item: News)  {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }

    private fun GenerateNews() : List<News> {
        var items: MutableList<News> = ArrayList()
        var accImage = arrayListOf<Int>()
        var postHead = arrayListOf<String>()
        var postPhoto = arrayListOf<Int>()
        var postDate = arrayListOf<String>()
        var postText = arrayListOf<String>()
        var likeNum = arrayListOf<Int>()
        var comNum = arrayListOf<Int>()
        var replyNum = arrayListOf<Int>()

        accImage.add(R.drawable.beat)
        postHead.add("PSD")
        postPhoto.add(R.drawable.post1)
        postDate.add("2 марта 2016")
        postText.add("Использовать шаблон можно практически во всех нишах, за исключением сфер, " +
                "связанных с детьми, для них подобная цветовая схема будет слишком тёмной и " +
                "строгой. Несмотря на все переплетения, редактировать шаблон просто. Если все эти " +
                "этапы кажутся Вам очень сложными и непонятными, рекомендую изучить уроки, которые " +
                "Вы можете найти в этой группе.")
//        likeNum.add(0)
        comNum.add(2)
        replyNum.add(1)

        accImage.add(R.drawable.acc2)
        postHead.add("Tesla")
        postPhoto.add(R.drawable.post2)
        postDate.add("сегодня 21:03")
        postText.add("Компания Tesla отзовет около 15 тыс. кроссоверов Model X из-за потенциальных " +
                "проблем, которые могут привести к потере мощности усилителя руля и привести к " +
                "аварии, сообщает Reuters.")
        //likeNum.add(0)
        comNum.add(2);
        replyNum.add(1);


        accImage.add(R.drawable.acc3)
        postHead.add("Новости с Востока")
        postPhoto.add(R.drawable.post3)
        postDate.add("вчера 03:12")
        postText.add("В ночь на 28 февраля сирийская армия нанесла удары по позициям турецких " +
                "войск в районе Джебель-аз-Завия. Как стало известно позже, в результате обстрела " +
                "погибли 33 военнослужащих, еще 32 получили ранения.")
        comNum.add(2);
        replyNum.add(1);



        accImage.add(R.drawable.acc4)
        postHead.add("Ким Чен Ын")
        postPhoto.add(R.drawable.post4)
        postDate.add("сегодня 08:12")
        postText.add("Северная Корея — это разруха, голод и диктатура, а Южная — рай с «Самсунгом», " +
                "кей-попом и демократией. Примерно так рассуждают люди, воспитанные на антикимовской " +
                "пропаганде.")
        comNum.add(2);
        replyNum.add(1);


        accImage.add(R.drawable.acc5)
        postHead.add("Мировые новости")
        postPhoto.add(R.drawable.post5)
        postDate.add("сегодня 06:52")
        postText.add("Конгрессмены в итоговом голосовании по импичменту признали президента США " +
                "невиновным по обоим пунктам обвинения — в злоупотреблении властью и препятствовании " +
                "работе Конгресса. ")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc6)
        postHead.add("Угол для беседы")
        postPhoto.add(R.drawable.post6)
        postDate.add("сегодня 12:45")
        postText.add("Кабус бен Саид Аль Саид был султаном Омана без малого 50 лет — вплоть до " +
                "своей смерти 10 января. Он взошел на престол на британских штыках, сместив " +
                "собственного отца в результате дворцового переворота. ")
        comNum.add(2);
        replyNum.add(1);


        accImage.add(R.drawable.acc7)
        postHead.add("Бешеный Майк")
        postPhoto.add(R.drawable.post7)
        postDate.add("сегодня 16:50")
        postText.add("На минувшей неделе, 2 февраля, в ЮАР в возрасте 100 лет умер один из самых " +
                "знаменитых наемников в мире Майкл Хоар. Он много лет сражался за британскую " +
                "корону, затем воевал с коммунистами, устраивал перевороты и угонял самолет.")
        comNum.add(2);
        replyNum.add(1);


        accImage.add(R.drawable.acc8)
        postHead.add("История и все что вокруг")
        postPhoto.add(R.drawable.post8)
        postDate.add("сегодня 19:03")
        postText.add("Египетские пирамиды и Большой сфинкс — самые древние строения в мире и " +
                "единственные из семи чудес света, сохранившиеся до настоящего времени. Они " +
                "простояли несколько тысяч лет, но сейчас им угрожает гибель.")
        comNum.add(2);
        replyNum.add(1);


        accImage.add(R.drawable.acc9)
        postHead.add("Aliens")
        postPhoto.add(R.drawable.post9)
        postDate.add("сегодня 21:26")
        postText.add("В репозитории arXiv.org появился препринт статьи о первом в истории " +
                "обнаружении повторяющегося быстрого радиовсплеска с устойчивым периодом " +
                "активности 16 дней.")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.beat)
        postHead.add("PSD")
        postPhoto.add(R.drawable.post10)
        postDate.add("Вчера в 00:00")
        postText.add("Дальтонизм – это расстройство, заключающееся в неспособности воспринимать " +
                "различия между некоторыми или всеми цветами. Все указывает на то, что появились " +
                "линзы, которые в значительной степени позволяют нивелировать это явление.")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc3)
        postHead.add("Новости с Востока")
        postPhoto.add(R.drawable.post11)
        postDate.add("сегодня 21:30")
        postText.add("В китайском городе Чунцин на юго-западе Китая был построен туннель для " +
                "обеззараживания рабочих до начала рабочего дня. Все сделано для борьбы с " +
                "эпидемией коронавируса.")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc6)
        postHead.add("Угол для беседы")
        postPhoto.add(R.drawable.post12)
        postDate.add("сегодня 10:03")
        postText.add("Выяснилось, что на борту МКС были обнаружены два вида бактерий. Они " +
                "появились в дозаторе воды и, вероятно, были там еще до запуска устройства " +
                "в космос. Однако они не представляют большей опасности, чем эти микробы на Земле.")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc7)
        postHead.add("Бешеный Майк")
        postPhoto.add(R.drawable.post13)
        postDate.add("сегодня 16:51")
        postText.add("В интернете циркулируют истории о том, как Apple Watch спасает жизни " +
                "пользователей. Оказывается, помощь могут оказать и смартфоны Huawei, в чем " +
                "убедилась жительница Британии.")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc4)
        postHead.add("Ким Чен Ын")
        postPhoto.add(R.drawable.post14)
        postDate.add("сегодня 17:45")
        postText.add("В TechInsights был проведен анализ потенциальной стоимости производства " +
                "телефона Galaxy S20 Ultra. Компания проверила стоимость компонентов, а затем " +
                "создала отчет, с помощью которого мы можем выяснить, какова пропорция цены " +
                "смартфона к конечной стоимости.")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc6)
        postHead.add("Угол для беседы")
        postPhoto.add(R.drawable.post15)
        postDate.add("сегодня 10:03")
        postText.add("Выяснилось, что на борту МКС были обнаружены два вида бактерий. Они " +
                "появились в дозаторе воды и, вероятно, были там еще до запуска устройства " +
                "в космос. Однако они не представляют большей опасности, чем эти микробы на Земле.")
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc9)
        postHead.add("Aliens")
        postPhoto.add(R.drawable.post16)
        postDate.add("сегодня 17:46")
        postText.add("У Intel есть еще одна проблема, потому что в ее процессорах была обнаружена " +
                "новая уязвимость на аппаратном уровне. Это серьезно, потому что это позволяет " +
                "преодолеть аппаратное шифрование и безопасность DRM.")
        //likeNum.add(0);
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc8)
        postHead.add("История и все что вокруг")
        postPhoto.add(R.drawable.post17)
        postDate.add("сегодня 16:50")
        postText.add(" Стадион баскетбольной команды Sacramento Kings славится многими " +
                "технологическими инновациями. В течение некоторого времени зрители премиальных " +
                "мест могут, в частности, рассчитывать на использование умных бутылок.")
//        //likeNum.add(0);
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc2)
        postHead.add("Tesla")
        postPhoto.add(R.drawable.post18)
        postDate.add("сегодня 18:59")
        postText.add(" В то время как большая часть шумихи вокруг Oppo в прошлом месяце была " +
                "сосредоточена вокруг ее горячо ожидаемых флагманских смартфонов Find X2, компания " +
                "также представила свои первые умные часы.")
        //likeNum.add(0);
        comNum.add(2);
        replyNum.add(1);

        accImage.add(R.drawable.acc3)
        postHead.add("Новости с Востока")
        postPhoto.add(R.drawable.post19)
        postDate.add("сегодня 20:01")
        postText.add("Хотя официальный реализ шестого поколения Wi-Fi состоялся всего пару месяцев " +
                "назад, но Wi-Fi Alliance активно работает над развитием седьмой версии этого " +
                "способа связи. Рыночный дебют нового решения должен состояться уже в 2024 году.")
        //likeNum.add(0);
        comNum.add(2);
        replyNum.add(1);


        for (i in  0..9){
            var news =  News(
                accImage.get(i),
                postHead.get(i),
                postPhoto.get(i),
                postDate.get(i),
                postText.get(i),
                0,
                comNum.get(i),
                replyNum.get(i),
                0,
                R.drawable.ic_like
            )
            items.add(news)
        }
        return items
    }
}
