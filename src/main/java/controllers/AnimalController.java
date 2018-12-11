package controllers;

import dao.AnimalDao;
import entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/animal")
public class AnimalController {


    @Autowired
    private AnimalDao animalDao;


    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePost(@RequestParam("id") int animalId,
                             @RequestParam("name") String animalName,
                             @RequestParam("category") int idCategory,
                             @RequestParam("photo") MultipartFile filePhoto,
                             @RequestParam("audio") MultipartFile fileAudio) {
//        try {
//            if (!filePhoto.isEmpty() && !fileAudio.isEmpty()) {
//                Animal animal = new Animal();
//                animal.setAnimalId(animalId);
//                animal.setAnimalName(animalName);
//                animal.setIdCategory(idCategory);
//                animal.setAnimalPicture(Base64.getEncoder().encode(filePhoto.getBytes()));
//                animal.setAnimalSound(Base64.getEncoder().encode(fileAudio.getBytes()));
//
//                animalDao.create(animal);
//                return "saved";
//
//            } else {
//                return "controllers.redirect:uploadFailure";
//            }
//        } catch (Exception ex) {
//            System.out.println("error");
//        }
        return "controllers.redirect:uploadSuccess_2";

    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGet() {

        return "update";
    }


    @RequestMapping("/readAnimalId")
    public String readIdMax(ModelMap model) {

        List<Animal> readIdMax = animalDao.readIdMax();
        int id = 0;
        for (Animal rIM : readIdMax) {
            System.out.println("id: " + rIM.getAnimalId() +
                    ", name: " + rIM.getAnimalName() +
                    ", category: " + rIM.getIdCategory());

            Random rnd = new Random();
            int i = 1;
            boolean flag = true;
            while (flag) {

                //int number = min + rnd.nextInt(max - min + 1);

                id = 1 + rnd.nextInt((int) rIM.getAnimalId());
                System.out.println("-------id------" + id);
                Animal animal = animalDao.read((long) id);
                if (animal == null) {

                    System.out.println(i + " попытка найти существующий идишник");
                    i++;

                } else {

                    System.out.println("all good");
                    flag = false;
                    String image = new String(animal.getAnimalPicture());
                    String sound = new String(animal.getAnimalSound());
                    System.out.println(animal.getAnimalName());

                    model.addAttribute("id", animal.getAnimalId());
                    model.addAttribute("name", animal.getAnimalName());
                    model.addAttribute("category", animal.getIdCategory());
                    model.addAttribute("image", image);
                    model.addAttribute("sound", sound);

                }
            }
        }

        return "getAnimal";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String uploadFilePost(@RequestParam("photo") MultipartFile filePhoto,
                                 @RequestParam("audio") MultipartFile fileAudio,
                                 @RequestParam String name,
                                 @RequestParam int category) {


        try {
            if (!filePhoto.isEmpty() && !fileAudio.isEmpty()) {

                Animal animal = new Animal();
                animal.setAnimalName(name);
                animal.setIdCategory(category);
                animal.setAnimalPicture(Base64.getEncoder().encode(filePhoto.getBytes()));
                animal.setAnimalSound(Base64.getEncoder().encode(fileAudio.getBytes()));
                animalDao.create(animal);

                return "loginAdmin";

            } else {

                return "upload";
            }
        } catch (Exception ex) {

            System.out.println("error");
        }
        return "controllers.redirect:uploadSuccess_2";      //fixme
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String uploadFileGet() {

        return "upload";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)         //fixme
    public String delete(@RequestParam("id") int animalId) {
        Animal animal = new Animal();
        animal.setAnimalId(animalId);
        animalDao.delete(animal);

        //   Animal delete = animalDao.delete(animalId);
        //  System.out.println(read.getAnimalId());
        //  System.out.println(read.getAnimalName());

        //  System.out.println(read.getIdCategory());
        //System.out.println(read.getAnimalPicture());
//        String image = new String(read.getAnimalPicture());
//        String sound = new String(read.getAnimalSound());
        //  System.out.println(image);

//        model.addAttribute("image", image);
//        model.addAttribute("sound", sound);
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGet() {

        return "delete";
    }


    @RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
    public String loginAdmin() {

        return "loginAdmin";
    }


    //@RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @RequestMapping("/getAll")
    public String getAllGet(ModelMap model) {

        List<Animal> getAll = (animalDao.getAll());

        for (Animal list2 : getAll) {
            System.out.println("id: "
                    + list2.getAnimalId()
                    + ", name: "
                    + list2.getAnimalName()
                    + ", category: "
                    + list2.getIdCategory());
        }


        return "getAll";
    }


}


