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


    @Override
    public void create(Animal animal) {
        sessionFactory.getCurrentSession().save(animal);
    }

    @Override                        //fixme
    public void update(Animal animal) {

//        String hql = "update Contact "
//                + "SET firstName = :name "
//                +   ", lastName  = :lastName "
//                +   ", date      = :dateParam "
//                +  " where id = :idParam"
//
//
//
//
//
//        Query query = sessionFactory.getCurrentSession().createQuery(getAllHql);
//        query.setParameter("idParam"  , 48);
//        query.setParameter("name"     , "Киса");
//        query.setParameter("lastName" , "Воробьянинов");
//        query.setParameter("dateParam", new Date());
//        int result = query.executeUpdate();
//

    //    sessionFactory.getCurrentSession().update(animal);
    }

    @Override
    public void delete(Animal animal) {
        sessionFactory.getCurrentSession().delete(animal);
    }

    @Override
    public Animal read(long animalId) {
        return sessionFactory.getCurrentSession().get(Animal.class, animalId);

    }

    @Override
    public List<Animal> readIdMax() {

        String animalhqlIdMax = "FROM Animal WHERE  animalId=(SELECT MAX(animalId) FROM Animal)";
        Query query = sessionFactory.getCurrentSession().createQuery(animalhqlIdMax);


//        String animalhqlIdMax = "SELECT animalId FROM Animal ORDER BY RAND() LIMIT 1"; //FIXME
//        Query query = sessionFactory.getCurrentSession().createQuery(animalhqlIdMax);
//        List<Animal> ani = query.list();
//        System.out.println(ani);
//                        //на будущее

        List<Animal> listIdMax = query.list();

        return listIdMax;
    }

    @Override                       //fixme
    public Animal getAnimal(String animalName) {
        //указываем класс и его поля
        //то есть поиск по обьктам по полям
        String animalHQL = "FROM Animal WHERE animalName = :key";
        Query query = sessionFactory.getCurrentSession().createQuery(animalHQL);
        query.setParameter("key", animalName);

        return (Animal) query.uniqueResult();
    }


    @Override
    public List<Animal> getAll() {

        String getAllHql = "From Animal";
        Query query = sessionFactory.getCurrentSession().createQuery(getAllHql);
        List<Animal> list =  query.list();

//        List<Object[]> animalList= query.getResultList();
//        List<Animal> list = new ArrayList<Animal>();
//
//        Iterator it = animalList.iterator();                                        //рабочий вариант
//        while(it.hasNext()){
//            Object[] line = (Object[]) it.next();
//            Animal eq = new Animal();
//            eq.setAnimalId((Long) line[0]);
//            eq.setAnimalName((String) line[1]);
//            eq.setIdCategory((Integer) line[2]);
//            //And set all the Equip fields here
//            //And last thing add it to the list
//
//            list.add(eq);
//        }
//
//
//        System.out.println(list);
        return list;
    }

}