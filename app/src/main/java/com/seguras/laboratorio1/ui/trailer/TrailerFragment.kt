package com.seguras.laboratorio1.ui.trailer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.seguras.laboratorio1.adapter.MovieAdapter
import com.seguras.laboratorio1.databinding.FragmentTrailerBinding
import com.seguras.laboratorio1.model.Movie
import com.seguras.laboratorio1.ui.Details

class TrailerFragment : Fragment(), MovieAdapter.OnItemListener {

    private lateinit var binding: FragmentTrailerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTrailerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var movies = ArrayList<Movie>()

        val movie1 = Movie(1,"Fantastic Beasts: The Secrets of Dumbledore","Action and Adventure", "April 15th, 2022", "fantasticbeast", "fantasticbeast", "“Fantastic Beasts: The Secrets of Dumbledore” is the newest adventure in the Wizarding World™ created by J.K. Rowling. Professor Albus Dumbledore (Jude Law) knows the powerful Dark wizard Gellert Grindelwald (Mads Mikkelsen) is moving to seize control of the wizarding world.")
        val movie2 = Movie(2,"Batman","Action, Crime, Drama", "March 04th, 2022", "batman", "batman", "When the Riddler, a sadistic serial killer, begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.")
        val movie3 = Movie(3,"Coda","Comedy, Drama, Music", "August 13th, 2021", "coda", "coda", "Gloucester, Massachusetts. As a Child of Deaf Adults and the only hearing person in her family, high school senior Ruby Rossi always has a lot on her plate. Indeed, trying to juggle back-breaking work on her father's fishing boat, schoolwork, social life, and the family's expectations can be too much for a teenager. But do her parents know Ruby loves to sing? When Ruby signs up for the school choir, singing becomes a passion, and suddenly, the talented young girl finds herself at a crossroads: should Ruby spread her wings and follow her dreams, or should she keep fighting everyday battles as a member of the proud Rossi clan?")
        val movie4 = Movie(4,"Encanto","Animation, Comedy, Family", "November 24th, 2021", "encanto", "encanto", "Encanto tells the tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal-every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.")
        val movie5 = Movie(5,"Titanic","Drama, Romance", "December 19th, 1997", "titanic", "titanic", "84 years later, a 100 year-old woman named Rose DeWitt Bukater tells the story to her granddaughter Lizzy Calvert, Brock Lovett, Lewis Bodine, Bobby Buell and Anatoly Mikailavich on the Keldysh about her life set in April 10th 1912, on a ship called Titanic when young Rose boards the departing ship with the upper-class passengers and her mother, Ruth DeWitt Bukater, and her fiancé, Caledon Hockley. Meanwhile, a drifter and artist named Jack Dawson and his best friend Fabrizio De Rossi win third-class tickets to the ship in a game. And she explains the whole story from departure until the death of Titanic on its first and last voyage April 15th, 1912 at 2:20 in the morning.")
        val movie6 = Movie(6,"Avengers: Endgame","Action, Adventure, Drama", "April 26th, 2019", "avengers", "avengers", "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos's actions and undo the chaos to the universe, no matter what consequences may be in store, and no matter who they face...")
        val movie7 = Movie(7,"Joker","Crime, Drama, Thriller", "October 04th, 2019", "joker", "joker", "Arthur Fleck works as a clown and is an aspiring stand-up comic. He has mental health issues, part of which involves uncontrollable laughter. Times are tough and, due to his issues and occupation, Arthur has an even worse time than most. Over time these issues bear down on him, shaping his actions, making him ultimately take on the persona he is more known as...Joker.")
        val movie8 = Movie(8,"Schindler's List","Biography, Drama, History", "February 04th, 1994", "schindler", "schindler", "Oskar Schindler is a vain and greedy German businessman who becomes an unlikely humanitarian amid the barbaric German Nazi reign when he feels compelled to turn his factory into a refuge for Jews. Based on the true story of Oskar Schindler who managed to save about 1100 Jews from being gassed at the Auschwitz concentration camp, it is a testament to the good in all of us.")
        val movie9 = Movie(9,"The Lord of the Rings: The Return of the King","Action, Adventure, Drama", "December 17th, 2003", "lordoftherings", "lordoftherings", "The final confrontation between the forces of good and evil fighting for control of the future of Middle-earth. Frodo and Sam reach Mordor in their quest to destroy the One Ring, while Aragorn leads the forces of good against Sauron's evil army at the stone city of Minas Tirith.")
        val movie10 = Movie(10,"Inception","Action, Adventure, Sci-Fi", "July 16th, 2010", "inception", "inception", "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.")
        val movie11 = Movie(11,"The Matrix","Action, Sci-Fi", "March 31th, 1999", "matrix", "matrix", "Thomas A. Anderson is a man living two lives. By day he is an average computer programmer and by night a hacker known as Neo. Neo has always questioned his reality, but the truth is far beyond his imagination. Neo finds himself targeted by the police when he is contacted by Morpheus, a legendary computer hacker branded a terrorist by the government. As a rebel against the machines, Neo must confront the agents: super-powerful computer programs devoted to stopping Neo and the entire human rebellion.")
        val movie12 = Movie(12,"Toy Story 3","Animation, Adventure, Comedy", "June 18th, 2010", "toystory3", "toystory3", "Woody, Buzz and the whole gang are back. As their owner Andy prepares to depart for college, his loyal toys find themselves in daycare where untamed tots with their sticky little fingers do not play nice. So, it's all for one and one for all as they join Barbie's counterpart Ken, a thespian hedgehog named Mr. Pricklepants and a pink, strawberry-scented teddy bear called Lots-o'-Huggin' Bear to plan their great escape.")
        val movie13 = Movie(13,"X","Horror", "March 18th, 2022", "x", "x", "Set in 1979, adult movie actors and a small film crew arrive to a farmhouse occupied by an elderly couple in the desolate Texas countryside to film an adult movie. As the day shifts to night, the visitors slowly realize that they are not safe, and are being targeted by a nearby enemy.")
        val movie14 = Movie(14,"Spider-Man: No Way Home","Action, Adventure, Fantasy", "December 17th, 2021", "spiderman", "spiderman", "Peter Parker's secret identity is revealed to the entire world. Desperate for help, Peter turns to Doctor Strange to make the world forget that he is Spider-Man. The spell goes horribly wrong and shatters the multiverse, bringing in monstrous villains that could destroy the world.")
        val movie15 = Movie(15,"Dune","Action, Adventure, Drama", "October 22th, 2021", "dune", "dune", "A mythic and emotionally charged hero's journey, \"Dune\" tells the story of Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, who must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.")
        val movie16 = Movie(16,"Turning Red","Animation, Adventure, Comedy", "March 11th, 2022", "red", "red", "Mei Lee (voice of Rosalie Chiang) is a confident, dorky 13-year-old torn between staying her mother's dutiful daughter and the chaos of adolescence. Her protective, if not slightly overbearing mother, Ming (voice of Sandra Oh), is never far from her daughter - an unfortunate reality for the teenager. And as if changes to her interests, relationships and body weren't enough, whenever she gets too excited (which is practically ALWAYS), she \"poofs\" into a giant red panda.")
        val movie17 = Movie(17,"Sonic the Hedgehog","Action, Adventure, Comedy", "February 14th, 2020", "sonic", "sonic", "Based on the global blockbuster videogame franchise from Sega, SONIC THE HEDGEHOG tells the story of the world's speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend Tom (James Marsden) team up to defend the planet from the evil genius Dr. Robotnik (Jim Carrey) and his plans for world domination. The family-friendly film also stars Tika Sumpter and Ben Schwartz as the voice of Sonic.")
        val movie18 = Movie(18,"West Side Story","Crime, Drama, Musical", "December 10th, 2021", "westside", "westside", "Manhattan, Upper West Side, 1957. Against the backdrop of the decaying tenements in the San Juan Hill neighbourhood and the constant threat of the wrecking ball, two warring gangs--tough Riff's Jets and swaggering Bernardo's Puerto Rican Sharks--fight for supremacy. Now, with a once-and-for-all, winner-takes-all rumble on the cards, an unexpected whirlwind romance at the high-school dance between former Jet brawler Tony and Bernardo's delicate little sister María sets the stage for an all-out turf war. But what's a gang without its territory? Above all, when the future is uncertain, what's hope without love?")
        val movie19 = Movie(19,"Beast","Action, Comedy, Crime", "April 13th, 2022", "beast", "beast", "After a shopping mall in Chennai is hijacked by terrorists who hold the visitors as hostages, Veera Raghavan, a spy also trapped in the mall, decides to save the hostages by eliminating the terrorists.")
        val movie20 = Movie(20,"The Adam Project","Action, Adventure, Comedy", "March 11th, 2022", "adam", "adam", "Adam Reed, age 12 and still grieving his father's sudden death the year before, walks into his garage one night to find a wounded pilot hiding there. This mysterious pilot turns out to be the older version of himself from the future, where time travel is in its infancy. He has risked everything to come back in time on a secret mission. Together they must embark on an adventure into the past to find their father, set things right, and save the world. As the three work together, both young and grown Adam come to terms with the loss of their father and have a chance to heal the wounds that have shaped them. Adding to the challenge of the mission, the two Adams discover that they really don't like each other much, and if they are to save the world, first they need to figure out how to get along.")

        movies.add(movie1)
        movies.add(movie2)
        movies.add(movie3)
        movies.add(movie4)
        movies.add(movie5)
        movies.add(movie6)
        movies.add(movie7)
        movies.add(movie8)
        movies.add(movie9)
        movies.add(movie10)
        movies.add(movie11)
        movies.add(movie12)
        movies.add(movie13)
        movies.add(movie14)
        movies.add(movie15)
        movies.add(movie16)
        movies.add(movie17)
        movies.add(movie18)
        movies.add(movie19)
        movies.add(movie20)

        val adapter = MovieAdapter(requireContext(),movies, this)
        //val intent = Intent(this, )

        with(binding){
            rvTrailers.layoutManager = LinearLayoutManager(requireContext())
            rvTrailers.adapter = adapter
        }
    }

    override fun myClick(movie: Movie) {
        val intent = Intent(activity, Details::class.java)
        var param = Bundle()
        param.putSerializable("selMoview",movie)
        intent.putExtras(param)
        activity?.startActivity(intent)
    }
}