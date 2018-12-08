package dao.impl;

import dao.AnimalDao;
import entity.Animal;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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

    @Override
    public void update(Animal animal) {
        sessionFactory.getCurrentSession().update(animal);
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
    public Animal readIdMax() {


       /* String animalhqlIdMax = "SELECT animalId FROM Animal ORDER BY RAND() LIMIT 1"; //FIXME
        Query query = sessionFactory.getCurrentSession().createQuery(animalhqlIdMax);
        List<Animal> ani = query.list();
        System.out.println(ani);
       */                 //на будущее

        return null ;
    }

    @Override
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

        String getAllHql = "Select animalId,animalName,idCategory From Animal";
        Query query = sessionFactory.getCurrentSession().createQuery(getAllHql);


        List<Animal> list =  query.list();

        for (Animal list2 : list ) {

            System.out.println(list2.getAnimalId());
        }









/*
        List<Object[]> animalList= query.getResultList();
        List<Animal> list = new ArrayList<Animal>();

        Iterator it = animalList.iterator();                                        //рабочий вариант
        while(it.hasNext()){
            Object[] line = (Object[]) it.next();
            Animal eq = new Animal();
            eq.setAnimalId((Long) line[0]);
            eq.setAnimalName((String) line[1]);
            eq.setIdCategory((Integer) line[2]);
            //And set all the Equip fields here
            //And last thing add it to the list

            list.add(eq);
        }


        System.out.println(list);
*/

//        for (Object list22 : list2) {
//            Long animalId = ;
//            String userPassword = user.getPassword();
//            if (login.equals(userLogin) && password.equals(userPassword)) {
//                // Bingo!
//            }
//        }


/*
        final List<Animal> list = new LinkedList<>();
        for(final Object o : query.list()) {
            list.add((Animal) o);

        }
        System.out.println(list);
        */

        return null;
    }

}


// ArrayList<Animal> all = (ArrayList<Animal>) query.list();

//   System.out.println(all.size());

//     for ( Object getAllAni : all   ) {
//  getAllAni = (Animal) getAllAni;
//            System.out.println(((Animal) getAllAni).getAnimalId());
//            System.out.println(((Animal) getAllAni).getAnimalName());
//            System.out.println(getAllAni);
//            Animal animal = (Animal) getAllAni;
//            System.out.println(animal.getAnimalName());
//
//        }

//        System.out.println(getAllAnimals);
//        return  null;