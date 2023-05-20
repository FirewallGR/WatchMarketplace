package ru.meowmure.clockwebmarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.meowmure.clockwebmarket.models.Watch;

public interface WatchRepository extends JpaRepository<Watch, Integer> {
}
