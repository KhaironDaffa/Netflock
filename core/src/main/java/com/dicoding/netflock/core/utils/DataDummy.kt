package com.dicoding.netflock.core.utils

import com.dicoding.netflock.core.data.source.remote.response.MoviesItems
import com.dicoding.netflock.core.data.source.remote.response.ShowsItems

object DataDummy {

    fun generateDummyMovie(): List<com.dicoding.netflock.core.data.source.local.entity.MovieEntity> {

        val movies = ArrayList<com.dicoding.netflock.core.data.source.local.entity.MovieEntity>()
        val baseUrl = "https://image.tmdb.org/t/p/w500/"

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                1,
                "Godzilla vs. Kong",
                baseUrl + "pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "2021-03-24"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                2,
                "Thunder Force",
                baseUrl + "279yOM4OQREL36B3SECnRxoB4MZ.jpg",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "2021-04-09"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                3,
                "Zack Snyder's Justice League",
                baseUrl + "tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "2021-03-18"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                4,
                "Mortal Kombat",
                baseUrl + "8yhtzsbBExY8mUct2GOk4LDDuGH.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "2021-04-07"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                5,
                "Chaos Walking",
                baseUrl + "9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                "2021-02-24"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                6,
                "The Marksman",
                baseUrl + "6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "2021-01-15"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                7,
                "Raya and the Last Dragon",
                baseUrl + "lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "2021-03-03"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                8,
                "Mortal Kombat Legends: Scorpion's Revenge",
                baseUrl + "4VlXER3FImHeFuUjBShFamhIp9M.jpg",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "2020-04-12"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                9,
                "Monster Hunter",
                baseUrl + "1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "2020-12-03"
            )
        )

        movies.add(
            com.dicoding.netflock.core.data.source.local.entity.MovieEntity(
                10,
                "Sentinelle",
                baseUrl + "fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
                "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                "2021-03-05"
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity> {

        val shows = ArrayList<com.dicoding.netflock.core.data.source.local.entity.TvShowEntity>()
        val baseUrl = "https://image.tmdb.org/t/p/w500/"

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                1,
                "The Falcon and the Winter Soldier",
                baseUrl + "6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-03-19"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                2,
                "The Good Doctor",
                baseUrl + "6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "2017-09-25"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                3,
                "The Flash",
                baseUrl + "lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                4,
                "Invincible",
                baseUrl + "yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "2021-03-26"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                5,
                "Grey's Anatomy",
                baseUrl + "clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "2005-03-27"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                6,
                "Riverdale",
                baseUrl + "wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017-01-26"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                7,
                "Lucifer",
                baseUrl + "4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "2016-01-25"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                8,
                "WandaVision",
                baseUrl + "glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "2021-01-15"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                9,
                "The Walking Dead",
                baseUrl + "rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010-10-31"
            )
        )

        shows.add(
            com.dicoding.netflock.core.data.source.local.entity.TvShowEntity(
                10,
                "Who Killed Sara?",
                baseUrl + "o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "2021-03-24"
            )
        )

        return shows

    }

    fun generateRemoteDummyMovies(): List<MoviesItems> {
        val movies = ArrayList<MoviesItems>()
        val baseUrl = "https://image.tmdb.org/t/p/w500/"

        movies.add(MoviesItems(
            1,
            "Godzilla vs. Kong",
            baseUrl + "pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "2021-03-24"))

        movies.add(MoviesItems(
            2,
            "Thunder Force",
            baseUrl + "279yOM4OQREL36B3SECnRxoB4MZ.jpg",
            "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
            "2021-04-09"))

        movies.add(MoviesItems(
                3,
                "Zack Snyder's Justice League",
                baseUrl + "tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "2021-03-18")
        )

        movies.add(MoviesItems(
                4,
                "Mortal Kombat",
                baseUrl + "8yhtzsbBExY8mUct2GOk4LDDuGH.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "2021-04-07")
        )

        movies.add(MoviesItems(
                5,
                "Chaos Walking",
                baseUrl + "9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                "2021-02-24")
        )

        movies.add(MoviesItems(
                6,
                "The Marksman",
                baseUrl + "6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "2021-01-15")
        )

        movies.add(MoviesItems(
                7,
                "Raya and the Last Dragon",
                baseUrl + "lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "2021-03-03")
        )

        movies.add(MoviesItems(
                8,
                "Mortal Kombat Legends: Scorpion's Revenge",
                baseUrl + "4VlXER3FImHeFuUjBShFamhIp9M.jpg",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "2020-04-12")
        )

        movies.add(MoviesItems(
                9,
                "Monster Hunter",
                baseUrl + "1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "2020-12-03")
        )

        movies.add(MoviesItems(
                10,
                "Sentinelle",
                baseUrl + "fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
                "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                "2021-03-05")
        )

        return movies

    }

    fun generateRemoteDummyShows(): List<ShowsItems> {
        val shows = ArrayList<ShowsItems>()
        val baseUrl = "https://image.tmdb.org/t/p/w500/"

        shows.add(ShowsItems(
            1,
            "The Falcon and the Winter Soldier",
            baseUrl + "6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "2021-03-19"
        ))

        shows.add(ShowsItems(
            2,
            "The Good Doctor",
            baseUrl + "6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
            "2017-09-25"
        ))

        shows.add(ShowsItems(
            3,
            "The Flash",
            baseUrl + "lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "2014-10-07"
        ))

        shows.add(ShowsItems(
            4,
            "Invincible",
            baseUrl + "yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
            "2021-03-26"
        ))

        shows.add(ShowsItems(
            5,
            "Grey's Anatomy",
            baseUrl + "clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "2005-03-27"
        ))

        shows.add(ShowsItems(
            6,
            "Riverdale",
            baseUrl + "wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "2017-01-26"
        ))

        shows.add(ShowsItems(
            7,
            "Lucifer",
            baseUrl + "4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "2016-01-25"
        ))

        shows.add(ShowsItems(
            8,
            "WandaVision",
            baseUrl + "glKDfE6btIRcVB5zrjspRIs4r52.jpg",
            "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
            "2021-01-15"
        ))

        shows.add(ShowsItems(
            9,
            "The Walking Dead",
            baseUrl + "rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "2010-10-31"
        ))

        shows.add(ShowsItems(
            10,
            "Who Killed Sara?",
            baseUrl + "o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
            "2021-03-24"
        ))

        return shows
    }
}