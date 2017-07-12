package reviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private GenreRepository genreRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Tag dark = new Tag("Dark");
		tagRepo.save(dark);
		Tag romantic = new Tag("Romantic");
		tagRepo.save(romantic);
		Tag superhero = new Tag("Super Hero");
		tagRepo.save(superhero);
		
		Genre action = new Genre("Action");
		Genre romance = new Genre("Romance");
		genreRepo.save(action);
		genreRepo.save(romance);
		
		Review review1 = new Review (action, "Superman", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam aliquam lorem vitae metus tristique varius. Phasellus pulvinar finibus euismod. Phasellus dapibus magna ut purus viverra fermentum. Etiam pellentesque nulla sit amet ante faucibus porttitor eu a nisi. Cras eu lorem euismod, viverra ex nec, scelerisque erat. Maecenas risus urna, varius vitae auctor quis, placerat quis justo. Vestibulum sollicitudin cursus nisl, nec laoreet nibh pharetra et. Etiam commodo diam vel lectus dictum interdum. Cras tempus metus placerat, porta sapien sit amet, convallis turpis. Ut vel quam luctus, laoreet quam et, sagittis ante. Mauris in justo ac justo laoreet consequat sed id magna. Duis ipsum erat, ornare quis volutpat eu, vestibulum et tellus.", "March 10, 2015", "A Super Hero Movie", "/images/superman.jpg", superhero);
		reviewRepo.save(review1);
		Review review2 = new Review (action, "Batman", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam aliquam lorem vitae metus tristique varius. Phasellus pulvinar finibus euismod. Phasellus dapibus magna ut purus viverra fermentum. Etiam pellentesque nulla sit amet ante faucibus porttitor eu a nisi. Cras eu lorem euismod, viverra ex nec, scelerisque erat. Maecenas risus urna, varius vitae auctor quis, placerat quis justo. Vestibulum sollicitudin cursus nisl, nec laoreet nibh pharetra et. Etiam commodo diam vel lectus dictum interdum. Cras tempus metus placerat, porta sapien sit amet, convallis turpis. Ut vel quam luctus, laoreet quam et, sagittis ante. Mauris in justo ac justo laoreet consequat sed id magna. Duis ipsum erat, ornare quis volutpat eu, vestibulum et tellus.", "March 10, 2015", "A Super Hero Movie", "/images/batman.jpg", superhero, dark);
		reviewRepo.save(review2);
		Review review3 = new Review (romance, "Moulin Rouge", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam aliquam lorem vitae metus tristique varius. Phasellus pulvinar finibus euismod. Phasellus dapibus magna ut purus viverra fermentum. Etiam pellentesque nulla sit amet ante faucibus porttitor eu a nisi. Cras eu lorem euismod, viverra ex nec, scelerisque erat. Maecenas risus urna, varius vitae auctor quis, placerat quis justo. Vestibulum sollicitudin cursus nisl, nec laoreet nibh pharetra et. Etiam commodo diam vel lectus dictum interdum. Cras tempus metus placerat, porta sapien sit amet, convallis turpis. Ut vel quam luctus, laoreet quam et, sagittis ante. Mauris in justo ac justo laoreet consequat sed id magna. Duis ipsum erat, ornare quis volutpat eu, vestibulum et tellus.", "March 10, 2015", "A Super Hero Movie", "/images/moulinrouge.jpg", romantic);
		reviewRepo.save(review3);


	}

}
