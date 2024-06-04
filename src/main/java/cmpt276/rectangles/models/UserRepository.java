package cmpt276.rectangles.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<User, Integer> {
    List<User> findBySize(int size);
    List<User> findByNameAndPassword(String name, String password);
}
