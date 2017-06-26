package reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepository {

	//Creating review map
	Map<Long,Review> reviewMap = new HashMap<Long, Review>();
	
	//Constructor
	public ReviewRepository() {
    
	//Constructor 
		Review review = new Review(55555, " Forest Gump ", 
				"/images/forestgump.jpg", 
				" Drama ", 
				" This is a great movie. ",
				" July 6, 1994 ", 
				" Slow-witted man inspires many with his life story");
		reviewMap.put(review.getId(),review);	
		Review review2 = new Review(67890, " Mad Max ", "/images/madmax.jpg", " Action ", " This is a great movie. ", " May 15, 2015 "," Ultra-fast paced feminist action movie");
		reviewMap.put(review2.getId(),review2);
		Review review3 = new Review(11121, " My Neighbor Totoro ", "/images/totoro.jpg", " Animation "," This is a great movie. ", " May 7, 1993 "," A wonderful animated film for children" );
		reviewMap.put(review3.getId(),review3);
	 
	}	
	//Method find all values in review map
    public Collection<Review> findAll() {
    	return reviewMap.values();
    }
    //Find one review in the map
    public Review findOne(Long id) {
    	return reviewMap.get(id);
    }
}