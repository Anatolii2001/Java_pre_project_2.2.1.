package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //Сервис
public class UserServiceImp implements UserService {

   @Autowired //Автопроводка
   private UserDao userDao;
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional //Транзакционный
   @Override //Переопределение
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public void add(Car car) {

   }

   @Transactional(readOnly = true) //Транзакционный (только для чтения = истина)
   @Override //Переопределение
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public List<Car> listCars() {
      return null;
   }

   @Transactional(readOnly = true) //Транзакционный (только для чтения = истина)
   @Override //Переопределение
   public User getUserByCar(Car car) {
      return userDao.getUserByCar(car);
   }
}

