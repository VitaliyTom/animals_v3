package dao.impl;

import dao.AnimalDao;
import entity.Animal;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AnimalDaoImpl implements AnimalDao {

    @Autowired
    private SessionFactory sessionFactory;

//    использовать метод saveOrUpdate
    @Deprecated
    @Override
    public void create(Animal animal) {
        sessionFactory.getCurrentSession().save(animal);
    }
//    использовать метод saveOrUpdate
    @Deprecated
    @Override
    public void update(Animal animal) {

    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(this.read(id));
    }

    @Override
    public void saveOrUpdate(Animal animal) {

        sessionFactory.getCurrentSession().saveOrUpdate(animal);
    }

    @Override
    public Animal read(long animalId) {

        return sessionFactory.getCurrentSession().get(Animal.class, animalId);
    }

 //   selection search max id пока не используется
    @Deprecated
    @Override
    public Animal getIdMax() {

        String animalHQL = "FROM Animal WHERE  animalId = (SELECT MAX(animalId) FROM Animal)";
        Query query = sessionFactory.getCurrentSession().createQuery(animalHQL);
        return (Animal) query.uniqueResult();
    }
//    список всех животных
    @Override
    public List<Animal> getAll() {
        String getAllHql = "From Animal";
        Query query = sessionFactory.getCurrentSession().createQuery(getAllHql);
        List<Animal> list = query.list();
        return list;
    }
}