package vuluu.fileservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vuluu.fileservice.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

  List<Image> findByUserId(String userId);

  List<Image> findByPostId(String postId);
}