package forum.hub.api.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByTitleAndMessage(String title, String message);

    @Query("SELECT COUNT(t) > 0 FROM Topic t WHERE t.title = :title AND t.message = :message AND t.id <> :id")
    boolean existsByTitleAndMessageExcludingId(String title, String message, Long id);
}
