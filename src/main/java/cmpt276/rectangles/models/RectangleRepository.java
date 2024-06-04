package cmpt276.rectangles.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<Rectangle,Integer> {
    Rectangle findByRid(int rid);
    List<Rectangle> findByName(String name);
    List<Rectangle> findByWidthAndHeight(int width, int height);
}
