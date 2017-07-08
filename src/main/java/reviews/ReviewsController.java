package reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReviewsController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;
	
	@Resource 
	GenreRepository genreRepo;
	
	@RequestMapping("/genres")
	public String showAllGenres(Model model) {
		model.addAttribute("allGenresModel", genreRepo.findAll());
		return "allGenres";
	}
	
	@RequestMapping("/genre")
	public String showSingleGenre(@RequestParam long id, Model model) {
		model.addAttribute("singleGenreModel", genreRepo.findOne(id));
		return "genre";
	}
		
	@RequestMapping("/reviews")
	public String fetchReviews(Model model) {
		model.addAttribute("reviewsAsCollection", reviewRepo.findAll());
		return "reviews";
	}
	
	@RequestMapping("/onereview")
    public String fetchOne(@RequestParam(value="id") Long id, Model model) {
         model.addAttribute("onereview", reviewRepo.findOne(id));
 		model.addAttribute("tags", tagRepo.findAll());

         
         return "onereview";
     }
	
	@RequestMapping("/tags")
	public String showTags(@RequestParam(value="id") Long id, Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
		
	}
	
	@RequestMapping("/tag")
	public String fetchTagDetail(@RequestParam("id") Long id, Model model) {
		Tag selectedTag = tagRepo.findOne(id);
		model.addAttribute(selectedTag);
		return "tag";
	}
	
	@RequestMapping("/tags/delete")
	public String deleteTag(@RequestParam long tagId, @RequestParam long reviewId) {
		Tag toDelete = tagRepo.findOne(tagId);
 		for(Review review: toDelete.getReviewsWithTag()) {
 			review.remove(toDelete);
 			reviewRepo.save(review);
 		}
		
		tagRepo.delete(toDelete);
		return "redirect:/onereview?id=" + reviewId;
	}
	
		
		@RequestMapping("/createTag")
		public String createTag(@RequestParam(value="id") Long id, String name) {
			Tag tag = new Tag(name);
			tagRepo.save(tag); 
			Review review = reviewRepo.findOne(id);
			review.add(tag);
			reviewRepo.save(review);
			return "redirect:/onereview?id=" + id;
		}
}