package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository //Хранилище
public class UserDaoImp implements UserDao {

   @Autowired //Автопроводка
   private SessionFactory sessionFactory; //Фабрика сеансов

   @Override //Переопределение
   //Добавить пользователя
   public void add(User user) {
      //Фабрика сеансов. Получить текущую сессию. Сохранить (пользователя)
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) {

   }

   @Override //Переопределение
   @SuppressWarnings("unchecked") //Подавление предупреждений "непроверенный"
   public List<User> listUsers() {
      //Типизированный запрос = фабрика сеансов. Получить текущую сессию. Создать запрос (от пользователя)
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList(); // Запрос. Получить список результатов
   }

   @Override
   public List<Car> listCars() {
      return null;
   }

   @Override //Переопределение
   @SuppressWarnings("unchecked") //Подавление предупреждений "непроверенный"
   public User getUserByCar(Car car) {
      String hql = "from User user where user.car.model = :model and user.car.series = :series";
      //Типизированный запрос = фабрика сеансов. Получить текущую сессию. Создать запрос (hql)
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      //Запрос. Заданный параметр
      query.setParameter("model", car.getModel()).setParameter("series", car.getSeries());
      //Запрос. Установить максимальный результат. Получить единый результат
      return query.setMaxResults(1).getSingleResult();
   }
}


