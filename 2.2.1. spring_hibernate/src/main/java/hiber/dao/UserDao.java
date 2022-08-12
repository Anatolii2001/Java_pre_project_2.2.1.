package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   // добавил пользователя, ни чего не возвращает
   void add(User user);
   void add(Car car);
   // создали список пользователей
   List<User> listUsers();
   List<Car> listCars();
   // пользователю задали параметры машины
   User getUserByCar(Car car);

}

