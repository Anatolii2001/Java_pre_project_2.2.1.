package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    // Добавил пользователя, ни чего не возвращает
    void add(User user);
    void add(Car car);
    // Создали список пользователей
    List<User> listUsers();
    List<Car> listCars();
    // Пользователю задали параметры машины
    User getUserByCar(Car car);
}
