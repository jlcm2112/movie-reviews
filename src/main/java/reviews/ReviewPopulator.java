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
		
		Tag dangerous = new Tag("dangerous");
		tagRepo.save(dangerous);
		
		Tag romantic = new Tag("romantic");
		tagRepo.save(romantic);
		
		Genre action = new Genre("action");
		Genre romance = new Genre("romance");
		genreRepo.save(action);
		genreRepo.save(romance);
		Review review1 = new Review (action, "Superman", "This is a good movie", "March 10, 2015", "Synopsis", "no_image.jpg", romantic);
		reviewRepo.save(review1);
		Review review2 = new Review (action, "Batman", "This is a good movie", "March 10, 2015", "Synopsis", "no_image.jpg", romantic);
		reviewRepo.save(review2);


	}

}
