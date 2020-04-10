package com.example.vk_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerViewAdapter.ItemClickListener listener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener = new RecyclerViewAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("news",  item);
                startActivity(intent);
            }
        };
        initRecyclerView();
    }

    private List<News> generateNews() {
        List<News> items = new ArrayList<>();

        ArrayList<Integer> accImage = new ArrayList<>();
        ArrayList<String> postHead = new ArrayList<>();
        ArrayList<Integer> postPhoto = new ArrayList<>();
        ArrayList<String> postDate = new ArrayList<>();
        ArrayList<String> postText = new ArrayList<>();
        ArrayList<Integer> likeNum = new ArrayList<>();
        ArrayList<Integer> comNum = new ArrayList<>();
        ArrayList<Integer> replyNum = new ArrayList<>();

        accImage.add(R.drawable.beat);
        postHead.add("PSD");
        postPhoto.add(R.drawable.post1);
        postDate.add("2 марта 2016");
        postText.add("Использовать шаблон можно практически во всех нишах, за исключением сфер, связанных с детьми, для них подобная цветовая схема будет слишком тёмной и строгой. Несмотря на все переплетения, редактировать шаблон просто. Если все эти этапы кажутся Вам очень сложными и непонятными, рекомендую изучить уроки, которые Вы можете найти в этой группе.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc2);
        postHead.add("Tesla");
        postPhoto.add(R.drawable.post2);
        postDate.add("сегодня 21:03");
        postText.add("Компания Tesla отзовет около 15 тыс. кроссоверов Model X из-за потенциальных проблем, которые могут привести к потере мощности усилителя руля и привести к аварии, сообщает Reuters.\n" +
                "\n" +
                "Национальное управление безопасностью движения на трассах США и Министерство транспорта Канады заявили, что алюминиевые болты, которыми крепится усилитель рулевого механизма к корпусу редуктора, подвержены коррозии и могут сломаться. Это, в свою очередь, приведет к снижению мощности или полному отказу усилителя.\n" +
                "\n" +
                "Речь идет о 14 193 автомобилях в США и 843 в Канаде. Tesla организует замену крепежных болтов, а также при необходимости заменит рулевой механизм. Власти стран отметили, что пока что неисправность не привела к авариям и травмам.\n");
        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc3);
        postHead.add("Новости с Востока");
        postPhoto.add(R.drawable.post3);
        postDate.add("вчера 03:12");
        postText.add("В ночь на 28 февраля сирийская армия нанесла удары по позициям турецких войск в районе Джебель-аз-Завия. Как стало известно позже, в результате обстрела погибли 33 военнослужащих, еще 32 получили ранения. В ответ Турция нанесла удары по позициям сирийской армии. В частности, сообщалось, что турецкие силы уничтожили конвой правительственных войск Сирии на востоке провинции Идлиб.\n" +
                "\n" +
                "В администрации президента Турции Реджепа Тайипа Эрдогана пообещали продолжать ответные удары. Вице-президент страны Фуат Октай заявил, что Анкара отомстит президенту Сирии Башару Асаду за гибель военных, он заплатит высокую цену. Октай назвал сирийского президента главой террористического государства и сказал, что Асад войдет в историю как военный преступник.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc4);
        postHead.add("Ким Чен Ын");
        postPhoto.add(R.drawable.post4);
        postDate.add("сегодня 08:12");
        postText.add("Северная Корея — это разруха, голод и диктатура, а Южная — рай с «Самсунгом», кей-попом и демократией. Примерно так рассуждают люди, воспитанные на антикимовской пропаганде. Между тем реальность куда сложнее и интереснее. Специально для «Ленты.ру» известный российский кореист Константин Асмолов написал цикл статей об истории Корейского полуострова и двух государств, бывших некогда одним целым. В прошлый раз мы рассказывали, как в Южной Корее 1980-х одна диктатура сменилась другой, а протестующих давили танками. В этот раз речь пойдет о том, как президент Чон Ду Хван создавал собственный культ и расправлялся с несогласными, и в то же время дружил с США и улучшал образ страны.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc5);
        postHead.add("Мировые новости");
        postPhoto.add(R.drawable.post5);
        postDate.add("сегодня 06:52");
        postText.add("Конгрессмены в итоговом голосовании по импичменту признали президента США невиновным по обоим пунктам обвинения — в злоупотреблении властью и препятствовании работе Конгресса. За его оправдание по первому свои голоса отдали 52 из 100 сенаторов, по второму — 53. Таким образом, не было набрано двух третей голосов (67), необходимых для признания Трампа виновным и отстранения от власти, он останется на своем посту.\n" +
                "\n" +
                "Сенатор-республиканец Джон Корнин ранее указал, что процедура импичмента была политически мотивирована, что создало опасный прецедент. По его словам, демократы должны принять результаты голосования.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc6);
        postHead.add("Угол для беседы");
        postPhoto.add(R.drawable.post6);
        postDate.add("сегодня 12:45");
        postText.add("Кабус бен Саид Аль Саид был султаном Омана без малого 50 лет — вплоть до своей смерти 10 января. Он взошел на престол на британских штыках, сместив собственного отца в результате дворцового переворота. Но молодой правитель, придя к власти, не почивал на лаврах, окружая себя роскошью, как многие султаны. Его правление буквально преобразило страну, которая стала одним из образцов просвещенной монархии. «Лента.ру» вспомнила, как Кабус — так кратко именуют его в арабском мире — превратил феодальный рабовладельческий Оман, недавнюю колонию, в самое стабильное государство арабского мира, которое сравнивают с Сингапуром и Норвегией.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);


        accImage.add(R.drawable.acc7);
        postHead.add("Бешеный Майк");
        postPhoto.add(R.drawable.post7);
        postDate.add("сегодня 16:50");
        postText.add("На минувшей неделе, 2 февраля, в ЮАР в возрасте 100 лет умер один из самых знаменитых наемников в мире Майкл Хоар. Он много лет сражался за британскую корону, затем воевал с коммунистами, устраивал перевороты и угонял самолет. «Лента.ру» вспоминает историю простого бухгалтера мистера Хоара, который превратился в профессионального наемника по прозвищу Бешеный Майк, много раз мог погибнуть, но мирно скончался, дожив до глубокой старости.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc8);
        postHead.add("История и все что вокруг");
        postPhoto.add(R.drawable.post8);
        postDate.add("сегодня 19:03");
        postText.add("Египетские пирамиды и Большой сфинкс — самые древние строения в мире и единственные из семи чудес света, сохранившиеся до настоящего времени. Они простояли несколько тысяч лет, но сейчас им угрожает гибель. Как сохранить бесценное наследие Древнего Египта для будущих поколений? Существовал ли возле Великих пирамид второй сфинкс? Что мешает жителям современного Египта считаться полноценными наследниками великой цивилизации долины Нила? Обо все этом «Ленте.ру» рассказал кандидат исторических наук, научный сотрудник Центра египтологических исследований РАН, член Международной ассоциации египтологов Роман Орехов.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc9);
        postHead.add("Aliens");
        postPhoto.add(R.drawable.post9);
        postDate.add("сегодня 21:26");
        postText.add("В репозитории arXiv.org появился препринт статьи о первом в истории обнаружении повторяющегося быстрого радиовсплеска с устойчивым периодом активности 16 дней. FRB 180916.J0158+65 испускает мощные пучки радиоволн с завидной регулярностью, что породило слухи об искусственном происхождении источника. «Лента.ру» рассказывает, действительно ли стоит предполагать, что таинственные сигналы из космоса посылаются инопланетными цивилизациями.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.beat);
        postHead.add("PSD");
        postPhoto.add(R.drawable.post10);
        postDate.add("Вчера в 00:00");
        postText.add("Дальтонизм – это расстройство, заключающееся в неспособности воспринимать различия между некоторыми или всеми цветами. Все указывает на то, что появились линзы, которые в значительной степени позволяют нивелировать это явление.\n" +
                "\n" +
                "Это решение не столь инновационное, как можно было бы ожидать. Ведь уже много лет на рынке существуют специальные медицинские очки, которые благодаря применению специальных фильтров могут позволить больному увидеть палитру реальных цветов.\n" +
                "\n" +
                "Линзы являются более высокотехнологичными, а их создание требует от ученых безумно точной работы. Исследователи, разрабатывающие это решение, сосредотачиваются на самой поверхности линз. Это было сделано по технологии, известной как \"metasurface\", что, благодаря вмешательству в нанометрическую структуру, должно позволить персонализировать и вручную корректировать дейтеранопию.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc3);
        postHead.add("Новости с Востока");
        postPhoto.add(R.drawable.post11);
        postDate.add("сегодня 21:30");
        postText.add("В китайском городе Чунцин на юго-западе Китая был построен туннель для обеззараживания рабочих до начала рабочего дня. Все сделано для борьбы с эпидемией коронавируса.\n" +
                "\n" +
                "Туннель оснащен инфракрасными датчиками, которые активируют распыление дезинфицирующего тумана при входе в него. Это решение является эффективным средством профилактики инфекции SARS-CoV-2. Китайские компании медленно возвращаются к нормальной работе после вспышки коронавируса, которая вынудила продлить празднование Китайского Нового года, который состоялся 25 января 2020 года.\n" +
                "\n" +
                "Эпидемиологический советник правительства КНР Чжун Наньшань считает, что в мире эпидемия продлится как минимум до июня.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc6);
        postHead.add("Угол для беседы");
        postPhoto.add(R.drawable.post12);
        postDate.add("сегодня 10:03");
        postText.add("Выяснилось, что на борту МКС были обнаружены два вида бактерий. Они появились в дозаторе воды и, вероятно, были там еще до запуска устройства в космос. Однако они не представляют большей опасности, чем эти микробы на Земле.\n" +
                "\n" +
                "Международная космическая станция является герметичной средой, но оказывается, что у астронавтов, которые там находятся, есть маленькие спутники. Это два вида бактерий: Cenocepacia cepacia и Cenocepacia contaminans, которые на Земле вызывали инфекции легких.\n" +
                "\n" +
                "Упомянутые бактерии появились в дозаторе воды, расположенном на Международной космической станции, который был установлен еще в 2009 году. Вскоре после этого в образцах были обнаружены микробы. Скорее всего, они находились там еще до запуска в космос. Позже они начали размножаться и загрязнили воду. Очевидно, бактерии не беспокоят условия микрогравитации.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc7);
        postHead.add("Бешеный Майк");
        postPhoto.add(R.drawable.post13);
        postDate.add("сегодня 16:51");
        postText.add("В интернете циркулируют истории о том, как Apple Watch спасает жизни пользователей. Оказывается, помощь могут оказать и смартфоны Huawei, в чем убедилась жительница Британии.\n" +
                "\n" +
                "Служба The Sun сообщила о несчастном случае, произошедшем с 42-летней женщиной. Бет Макдермотт из Ланкастера упала с лестницы и потеряла сознание на несколько дней. Придя в себя, женщина поняла, что не может двигать ногами, и позвать на помощь чрезвычайно сложно. Тогда же она вспомнила о смартфоне, который приобрела за два дня до несчастного случая. Именно с его помощью удалось вызвать спасательные службы.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc4);
        postHead.add("Ким Чен Ын");
        postPhoto.add(R.drawable.post14);
        postDate.add("сегодня 17:45");
        postText.add("В TechInsights был проведен анализ потенциальной стоимости производства телефона Galaxy S20 Ultra. Компания проверила стоимость компонентов, а затем создала отчет, с помощью которого мы можем выяснить, какова пропорция цены смартфона к конечной стоимости.\n" +
                "\n" +
                "Galaxy S20 Ultra в России стоит 99990 руб., так что это один из самых дорогих телефонов на рынке. Американская цена (без налогов, потому что они разные в разных штатах) в свою очередь $ 1399. Анализ TechInsights показал, что стоимость производства Galaxy S20 Ultra в рамках самих компонентов составляет 528,50 долларов. Что же столько стоит?\n" +
                "\n" +
                "Самыми дорогими частями телефона является комплект камер – за все сенсоры (включая основной 108 Mп) цена составляет 107,50 долларов. Кроме того, стоит помнить, что Samsung также установил 48-мегапиксельную перископную камеру в своем телефоне, что также влияет на конечную стоимость. Вторым самым дорогим компонентом является Snapdragon 865, который стоит 81 доллар. На третьем месте находится 6,9-дюймовый OLED-дисплей QHD+, за который нужно заплатить 67 долларов.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc6);
        postHead.add("Угол для беседы");
        postPhoto.add(R.drawable.post15);
        postDate.add("сегодня 10:03");
        postText.add("Выяснилось, что на борту МКС были обнаружены два вида бактерий. Они появились в дозаторе воды и, вероятно, были там еще до запуска устройства в космос. Однако они не представляют большей опасности, чем эти микробы на Земле.\n" +
                "\n" +
                "Международная космическая станция является герметичной средой, но оказывается, что у астронавтов, которые там находятся, есть маленькие спутники. Это два вида бактерий: Cenocepacia cepacia и Cenocepacia contaminans, которые на Земле вызывали инфекции легких.\n" +
                "\n" +
                "Упомянутые бактерии появились в дозаторе воды, расположенном на Международной космической станции, который был установлен еще в 2009 году. Вскоре после этого в образцах были обнаружены микробы. Скорее всего, они находились там еще до запуска в космос. Позже они начали размножаться и загрязнили воду. Очевидно, бактерии не беспокоят условия микрогравитации.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc9);
        postHead.add("Aliens");
        postPhoto.add(R.drawable.post16);
        postDate.add("сегодня 17:46");
        postText.add("У Intel есть еще одна проблема, потому что в ее процессорах была обнаружена новая уязвимость на аппаратном уровне. Это серьезно, потому что это позволяет преодолеть аппаратное шифрование и безопасность DRM. Ошибка обнаружена в чипах Intel за последние пять лет, но это не относится к поколению Core 10. На этот раз проблему нельзя исправить.\n" +
                "\n" +
                "Intel в последние годы не повезло. В начале 2018 года много говорилось об угрозах Spectre и Meltdown. Тем временем появлялись новые недоработки. Теперь мы узнаем, что в современных процессорах компании обнаружена новая, очень серьезная ошибка.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc8);
        postHead.add("История и все что вокруг");
        postPhoto.add(R.drawable.post17);
        postDate.add("сегодня 16:50");
        postText.add("Стадион баскетбольной команды Sacramento Kings славится многими технологическими инновациями. В течение некоторого времени зрители премиальных мест могут, в частности, рассчитывать на использование умных бутылок.\n" +
                "\n" +
                "Матчи НБА славятся своей быстрой и динамичной игрой. Специально для тех, кто хочет сосредоточиться на шоу, а не оглядываться на бармена, были подготовлены места, оборудованные специальными бутылками. Они беспроводным образом подключены к планшету, на котором мы выбираем правильный тип и количество любимого ликера, а затем умный дозатор сам измеряет купленную порцию.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);


        accImage.add(R.drawable.acc2);
        postHead.add("Tesla");
        postPhoto.add(R.drawable.post18);
        postDate.add("сегодня 18:59");
        postText.add("В то время как большая часть шумихи вокруг Oppo в прошлом месяце была сосредоточена вокруг ее горячо ожидаемых флагманских смартфонов Find X2, компания также представила свои первые умные часы.\n" +
                "\n" +
                "Новый Oppo Watch имеет внешний вид и характеристики, которые должны привлечь внимание тех, кто ищет премиум-клас подобного рода носимых гаджетов. Начиная с дисплея, Oppo представляет изогнутую AMOLED-панель с 326 ppi, охватывающую 100% цветовую гамму DCI-P3. Он поставляется в 1,6-дюймовых и 1,9-дюймовых вариантах корпуса, который имеет алюминиевую сборку и две боковые кнопки для навигации по интерфейсу.");
//        likeNum.add(0);
//        comNum.add(2);
//        replyNum.add(1);

        accImage.add(R.drawable.acc3);
        postHead.add("Новости с Востока");
        postPhoto.add(R.drawable.post19);
        postDate.add("сегодня 20:01");
        postText.add("Хотя официальный реализ шестого поколения Wi-Fi состоялся всего пару месяцев назад, но Wi-Fi Alliance активно работает над развитием седьмой версии этого способа связи. Рыночный дебют нового решения должен состояться уже в 2024 году.\n" +
                "\n" +
                "Прошло всего несколько месяцев, как пользователи смогли использовать протокол Wi-Fi 802.11 ax, который более широко известен как шестое поколение этой связи. Но похоже, что Wi-Fi Alliance, или ассоциация, занимающаяся разработкой этой технологии, делает ставку на очень динамичную эволюцию доступа к беспроводным сетям.");

        for (int i = 0; i < accImage.size(); i++) {
            News news = new News(
                    accImage.get(i),
                    postPhoto.get(i),
                    postHead.get(i),
                    postDate.get(i),
                    postText.get(i),
                    0,
                    i,
                    i,
                    0
            );
            items.add(news);
        }
        return items;
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewAdapter(generateNews(), listener);
        recyclerView.setAdapter(adapter);
    }
}