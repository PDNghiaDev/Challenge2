package com.gmail.pdnghiadev.challenge2;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private MovieAdapter adapter;
    private ArrayList<MovieItem> movieList;
    private String json = "{\n" +
            "movies:[\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/dkMD5qlogeRMiEixC4YNPUvax2T.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        878,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"id\": 135397,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Jurassic World\",\n" +
            "      \"overview\": \"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.\",\n" +
            "      \"release_date\": \"2015-06-12\",\n" +
            "      \"poster_path\": \"uXZYawqUsChGSj54wcuBtEdUJbh.jpg\",\n" +
            "      \"popularity\": 86.59593,\n" +
            "      \"title\": \"Jurassic World\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7,\n" +
            "      \"vote_count\": 1513\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/z3tZBqmxmMmoVX8tAOvVDS5pUQH.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        878\n" +
            "      ],\n" +
            "      \"id\": 102899,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Ant-Man\",\n" +
            "      \"overview\": \"Armed with the astonishing ability to shrink in scale but increase in strength, con-man Scott Lang must embrace his inner-hero and help his mentor, Dr. Hank Pym, protect the secret behind his spectacular Ant-Man suit from a new generation of towering threats. Against seemingly insurmountable obstacles, Pym and Lang must plan and pull off a heist that will save the world.\",\n" +
            "      \"release_date\": \"2015-07-17\",\n" +
            "      \"poster_path\": \"7SGGUiTE6oc2fh9MjIk5M00dsQd.jpg\",\n" +
            "      \"popularity\": 73.529938,\n" +
            "      \"title\": \"Ant-Man\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.2,\n" +
            "      \"vote_count\": 472\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/yxR0mp83arFwlOuZDlqSRCFWs6S.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        10751,\n" +
            "        16,\n" +
            "        12,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"id\": 211672,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Minions\",\n" +
            "      \"overview\": \"Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.\",\n" +
            "      \"release_date\": \"2015-07-10\",\n" +
            "      \"poster_path\": \"/s5uMY8ooGRZOL0oe4sIvnlTsYQO.jpg\",\n" +
            "      \"popularity\": 69.690141,\n" +
            "      \"title\": \"Minions\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.2,\n" +
            "      \"vote_count\": 603\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/o4I5sHdjzs29hBWzHtS2MKD3JsM.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        878,\n" +
            "        28,\n" +
            "        53,\n" +
            "        12\n" +
            "      ],\n" +
            "      \"id\": 87101,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Terminator Genisys\",\n" +
            "      \"overview\": \"The year is 2029. John Connor, leader of the resistance continues the war against the machines. At the Los Angeles offensive, John's fears of the unknown future begin to emerge when TECOM spies reveal a new plot by SkyNet that will attack him from both fronts; past and future, and will ultimately change warfare forever.\",\n" +
            "      \"release_date\": \"2015-07-01\",\n" +
            "      \"poster_path\": \"/5JU9ytZJyR3zmClGmVm9q4Geqbd.jpg\",\n" +
            "      \"popularity\": 56.403547,\n" +
            "      \"title\": \"Terminator Genisys\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.5,\n" +
            "      \"vote_count\": 503\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/tbhdm8UJAb4ViCTsulYFL3lxMCd.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"id\": 76341,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Mad Max: Fury Road\",\n" +
            "      \"overview\": \"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.\",\n" +
            "      \"release_date\": \"2015-05-15\",\n" +
            "      \"poster_path\": \"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg\",\n" +
            "      \"popularity\": 52.43451,\n" +
            "      \"title\": \"Mad Max: Fury Road\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.8,\n" +
            "      \"vote_count\": 1418\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/L5QRL1O3fGs2hH1LbtYyVl8Tce.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        878,\n" +
            "        10749\n" +
            "      ],\n" +
            "      \"id\": 262500,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Insurgent\",\n" +
            "      \"overview\": \"Beatrice Prior must confront her inner demons and continue her fight against a powerful alliance which threatens to tear her society apart.\",\n" +
            "      \"release_date\": \"2015-03-20\",\n" +
            "      \"poster_path\": \"/aBBQSC8ZECGn6Wh92gKDOakSC8p.jpg\",\n" +
            "      \"popularity\": 42.238894,\n" +
            "      \"title\": \"Insurgent\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.1,\n" +
            "      \"vote_count\": 673\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/2BXd0t9JdVqCp9sKf6kzMkr7QjB.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        12,\n" +
            "        10751,\n" +
            "        16,\n" +
            "        28,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"id\": 177572,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Big Hero 6\",\n" +
            "      \"overview\": \"The special bond that develops between plus-sized inflatable robot Baymax, and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.\",\n" +
            "      \"release_date\": \"2014-11-07\",\n" +
            "      \"poster_path\": \"/3zQvuSAUdC3mrx9vnSEpkFX0968.jpg\",\n" +
            "      \"popularity\": 37.374133,\n" +
            "      \"title\": \"Big Hero 6\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.9,\n" +
            "      \"vote_count\": 1816\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/nkwoiSVJLeK0NI8kTqioBna61bm.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        35\n" +
            "      ],\n" +
            "      \"id\": 214756,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Ted 2\",\n" +
            "      \"overview\": \"Newlywed couple Ted and Tami-Lynn want to have a baby, but in order to qualify to be a parent, Ted will have to prove he's a person in a court of law.\",\n" +
            "      \"release_date\": \"2015-06-26\",\n" +
            "      \"poster_path\": \"/A7HtCxFe7Ms8H7e7o2zawppbuDT.jpg\",\n" +
            "      \"popularity\": 32.495079,\n" +
            "      \"title\": \"Ted 2\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7,\n" +
            "      \"vote_count\": 387\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/pfyWJUxrBTT2UIPoEQF3iFTHcQT.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        80,\n" +
            "        35,\n" +
            "        28,\n" +
            "        12\n" +
            "      ],\n" +
            "      \"id\": 207703,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Kingsman: The Secret Service\",\n" +
            "      \"overview\": \"Kingsman: The Secret Service tells the story of a super-secret spy organization that recruits an unrefined but promising street kid into the agency's ultra-competitive training program just as a global threat emerges from a twisted tech genius.\",\n" +
            "      \"release_date\": \"2015-02-13\",\n" +
            "      \"poster_path\": \"/8x7ej0LnHdKUqilNNJXYOeyB6L9.jpg\",\n" +
            "      \"popularity\": 33.118654,\n" +
            "      \"title\": \"Kingsman: The Secret Service\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.7,\n" +
            "      \"vote_count\": 1480\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        18,\n" +
            "        878\n" +
            "      ],\n" +
            "      \"id\": 157336,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Interstellar\",\n" +
            "      \"overview\": \"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.\",\n" +
            "      \"release_date\": \"2014-11-05\",\n" +
            "      \"poster_path\": \"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg\",\n" +
            "      \"popularity\": 27.380307,\n" +
            "      \"title\": \"Interstellar\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 8.4,\n" +
            "      \"vote_count\": 2828\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/cUfGqafAVQkatQ7N4y08RNV3bgu.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        18,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"id\": 254128,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"San Andreas\",\n" +
            "      \"overview\": \"In the aftermath of a massive earthquake in California, a rescue-chopper pilot makes a dangerous journey across the state in order to rescue his estranged daughter.\",\n" +
            "      \"release_date\": \"2015-05-29\",\n" +
            "      \"poster_path\": \"/6iQ4CMtYorKFfAmXEpAQZMnA0Qe.jpg\",\n" +
            "      \"popularity\": 26.274807,\n" +
            "      \"title\": \"San Andreas\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.3,\n" +
            "      \"vote_count\": 487\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/y5lG7TBpeOMG0jxAaTK0ghZSzBJ.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        878,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"id\": 198184,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Chappie\",\n" +
            "      \"overview\": \"Every child comes into the world full of promise, and none more so than Chappie: he is gifted, special, a prodigy. Like any child, Chappie will come under the influence of his surroundings—some good, some bad—and he will rely on his heart and soul to find his way in the world and become his own man. But there's one thing that makes Chappie different from any one else: he is a robot.\",\n" +
            "      \"release_date\": \"2015-03-06\",\n" +
            "      \"poster_path\": \"/saF3HtAduvrP9ytXDxSnQJP3oqx.jpg\",\n" +
            "      \"popularity\": 24.732883,\n" +
            "      \"title\": \"Chappie\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.7,\n" +
            "      \"vote_count\": 741\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/fii9tPZTpy75qOCJBulWOb0ifGp.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        36,\n" +
            "        18,\n" +
            "        53,\n" +
            "        10752\n" +
            "      ],\n" +
            "      \"id\": 205596,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"The Imitation Game\",\n" +
            "      \"overview\": \"Based on the real life story of legendary cryptanalyst Alan Turing, the film portrays the nail-biting race against time by Turing and his brilliant team of code-breakers at Britain's top-secret Government Code and Cypher School at Bletchley Park, during the darkest days of World War II.\",\n" +
            "      \"release_date\": \"2014-11-14\",\n" +
            "      \"poster_path\": \"/noUp0XOqIcmgefRnRZa1nhtRvWO.jpg\",\n" +
            "      \"popularity\": 25.715818,\n" +
            "      \"title\": \"The Imitation Game\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 8.1,\n" +
            "      \"vote_count\": 1476\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        878,\n" +
            "        14,\n" +
            "        12\n" +
            "      ],\n" +
            "      \"id\": 118340,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Guardians of the Galaxy\",\n" +
            "      \"overview\": \"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.\",\n" +
            "      \"release_date\": \"2014-08-01\",\n" +
            "      \"poster_path\": \"/9gm3lL8JMTTmc3W4BmNMCuRLdL8.jpg\",\n" +
            "      \"popularity\": 23.666423,\n" +
            "      \"title\": \"Guardians of the Galaxy\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 8.1,\n" +
            "      \"vote_count\": 2996\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/rFtsE7Lhlc2jRWF7SRAU0fvrveQ.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        878\n" +
            "      ],\n" +
            "      \"id\": 99861,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Avengers: Age of Ultron\",\n" +
            "      \"overview\": \"When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth’s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.\",\n" +
            "      \"release_date\": \"2015-05-01\",\n" +
            "      \"poster_path\": \"/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg\",\n" +
            "      \"popularity\": 21.809341,\n" +
            "      \"title\": \"Avengers: Age of Ultron\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.8,\n" +
            "      \"vote_count\": 1620\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/4liSXBZZdURI0c1Id1zLJo6Z3Gu.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        878,\n" +
            "        14,\n" +
            "        28,\n" +
            "        12\n" +
            "      ],\n" +
            "      \"id\": 76757,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Jupiter Ascending\",\n" +
            "      \"overview\": \"In a universe where human genetic material is the most precious commodity, an impoverished young Earth woman becomes the key to strategic maneuvers and internal strife within a powerful dynasty…\",\n" +
            "      \"release_date\": \"2015-02-27\",\n" +
            "      \"poster_path\": \"/aMEsvTUklw0uZ3gk3Q6lAj6302a.jpg\",\n" +
            "      \"popularity\": 22.56266,\n" +
            "      \"title\": \"Jupiter Ascending\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.4,\n" +
            "      \"vote_count\": 926\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/qhH3GyIfAnGv1pjdV3mw03qAilg.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        12,\n" +
            "        14\n" +
            "      ],\n" +
            "      \"id\": 122917,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"The Hobbit: The Battle of the Five Armies\",\n" +
            "      \"overview\": \"Mere seconds after the events of \\\"Desolation\\\", Bilbo and Company continue to claim a mountain of treasure that was guarded long ago: But with Gandalf the Grey also facing some formidable foes of his own, the Hobbit is outmatched when the brutal army of orcs led by Azog the Defiler returns. But with other armies such as the elves and the men of Lake-Town, which are unsure to be trusted, are put to the ultimate test when Smaug's wrath, Azog's sheer strength, and Sauron's force of complete ends attack. All in all, the trusted armies have two choices: unite or die. But even worse, Bilbo gets put on a knife edge and finds himself fighting with Hobbit warfare with all of his might for his dwarf-friends, as the hope for Middle-Earth is all put in Bilbo's hands. The one \\\"precious\\\" thing to end it all.\",\n" +
            "      \"release_date\": \"2014-12-17\",\n" +
            "      \"poster_path\": \"/qrFwjJ5nvFnpBCmXLI4YoeHJNBH.jpg\",\n" +
            "      \"popularity\": 22.454566,\n" +
            "      \"title\": \"The Hobbit: The Battle of the Five Armies\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.2,\n" +
            "      \"vote_count\": 1645\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/fUn5I5f4069vwGFEEvA3HXt9xPP.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        878,\n" +
            "        12,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"id\": 131631,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"The Hunger Games: Mockingjay - Part 1\",\n" +
            "      \"overview\": \"Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol.\",\n" +
            "      \"release_date\": \"2014-11-20\",\n" +
            "      \"poster_path\": \"/gj282Pniaa78ZJfbaixyLXnXEDI.jpg\",\n" +
            "      \"popularity\": 22.377506,\n" +
            "      \"title\": \"The Hunger Games: Mockingjay - Part 1\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7,\n" +
            "      \"vote_count\": 1567\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/c1OSRvorPXvGtFka7mgV6Jcw6jd.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        80,\n" +
            "        10749,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"id\": 168259,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Furious 7\",\n" +
            "      \"overview\": \"Dominic and his crew thought they left the criminal mercenary life behind. They defeated an international terrorist named Owen Shaw and went their seperate ways. But now, Shaw's brother, Deckard Shaw is out killing the crew one by one for revenge. Worse, a Somalian terrorist called Jakarde, and a shady government official called \\\"Mr. Nobody\\\" are both competing to steal a computer terrorism program called God's Eye, that can turn any technological device into a weapon. Torretto must reconvene with his team to stop Shaw and retrieve the God's Eye program while caught in a power struggle between terrorist and the United States government\",\n" +
            "      \"release_date\": \"2015-04-03\",\n" +
            "      \"poster_path\": \"/dCgm7efXDmiABSdWDHBDBx2jwmn.jpg\",\n" +
            "      \"popularity\": 22.323115,\n" +
            "      \"title\": \"Furious 7\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.6,\n" +
            "      \"vote_count\": 1175\n" +
            "    },\n" +
            "    {\n" +
            "      \"adult\": false,\n" +
            "      \"backdrop_path\": \"/szytSpLAyBh3ULei3x663mAv5ZT.jpg\",\n" +
            "      \"genre_ids\": [\n" +
            "        35,\n" +
            "        16,\n" +
            "        10751\n" +
            "      ],\n" +
            "      \"id\": 150540,\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Inside Out\",\n" +
            "      \"overview\": \"Growing up can be a bumpy road, and it's no exception for Riley, who is uprooted from her Midwest life when her father starts a new job in San Francisco. Like all of us, Riley is guided by her emotions - Joy, Fear, Anger, Disgust and Sadness. The emotions live in Headquarters, the control center inside Riley's mind, where they help advise her through everyday life. As Riley and her emotions struggle to adjust to a new life in San Francisco, turmoil ensues in Headquarters. Although Joy, Riley's main and most important emotion, tries to keep things positive, the emotions conflict on how best to navigate a new city, house and school.\",\n" +
            "      \"release_date\": \"2015-06-19\",\n" +
            "      \"poster_path\": \"/aAmfIX3TT40zUHGcCKrlOZRKC7u.jpg\",\n" +
            "      \"popularity\": 20.570847,\n" +
            "      \"title\": \"Inside Out\",\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 8.3,\n" +
            "      \"vote_count\": 591\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieList = new ArrayList<>();

        parseResult(json);
        adapter = new MovieAdapter(this, movieList);
        mRecyclerView.setAdapter(adapter);
    }

    private void parseResult(String result) {
        try{
            JSONObject jsonObject = new JSONObject(result);
            JSONArray movies = jsonObject.getJSONArray("movies");

            for (int i = 0; i < movies.length(); i++){
                JSONObject movie = movies.getJSONObject(i);
                MovieItem movieItem = new MovieItem();
                movieItem.setId(Long.parseLong(movie.getString("id")));
                String poster = "http://image.tmdb.org/t/p/w154/" + movie.getString("poster_path");
                movieItem.setPoster(poster);
                movieItem.setTitle(movie.getString("original_title"));
                String release_date = movie.getString("release_date");
                Date date = ConvertToDate(release_date);
                movieItem.setDate(date);
                movieItem.setVote(Float.parseFloat(movie.getString("vote_average")));

                movieList.add(movieItem);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private Date ConvertToDate(String dateString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                final ArrayList<MovieItem> filteredModelList = filter(movieList, query);
                adapter.animateTo(filteredModelList);
                mRecyclerView.scrollToPosition(0);
                return true;
            }
        });
        return true;
    }

    private ArrayList<MovieItem> filter(ArrayList<MovieItem> movieList, String query) {
        query = query.toLowerCase();

        final ArrayList<MovieItem> filteredModelList = new ArrayList<>();
        for (MovieItem movie : movieList) {
            final String text = movie.getTitle().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(movie);
            }
        }
        return filteredModelList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
