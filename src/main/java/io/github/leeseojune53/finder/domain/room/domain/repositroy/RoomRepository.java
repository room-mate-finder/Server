package io.github.leeseojune53.finder.domain.room.domain.repositroy;

import io.github.leeseojune53.finder.domain.room.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
