
package dao.impl;

import dao.AnimalDao;
import entity.Animal;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class AnimalDaoImpl implements AnimalDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Deprecated
    @Override
    public void create(Animal animal) {
        sessionFactory.getCurrentSession().save(animal);
    }

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
        System.out.println(animalId);
        return sessionFactory.getCurrentSession().get(Animal.class, animalId);
    }

    @Override
    public Animal getIdMax() {              //selection search max id

        String animalHQL = "FROM Animal WHERE  animalId = (SELECT MAX(animalId) FROM Animal)";
        Query query = sessionFactory.getCurrentSession().createQuery(animalHQL);
        return (Animal) query.uniqueResult();
    }

    @Override
    public List<Animal> getAll() {
        String getAllHql = "From Animal";
        Query query = sessionFactory.getCurrentSession().createQuery(getAllHql);
        List<Animal> list = query.list();
        return list;
    }
}