package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// чтобы спринг знал что это хранилище
// указываем критерии для выбора спрингом
// тип  и ид объекта , кот хотим получить из бд
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // тип обертка, чтобы избежать исключений
    // опция проверить, если ли объект?
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    /*
     Интерфейсы чтобы искать данные в бд
     На заднем плане Hibernate генирирует sql запросы в бд
     и возвращает объект ы
     */


}
