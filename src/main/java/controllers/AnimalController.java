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
        try {
            if (!filePhoto.isEmpty() && !fileAudio.isEmpty()) {
                Animal animal = new Animal();
                animal.setAnimalId(animalId);
                animal.setAnimalName(animalName);
                animal.setIdCategory(idCategory);
                animal.setAnimalPicture(Base64.getEncoder().encode(filePhoto.getBytes()));
                animal.setAnimalSound(Base64.getEncoder().encode(fileAudio.getBytes()));

                animalDao.create(animal);
                return "saved";

            } else {
                return "controllers.redirect:uploadFailure";
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
        return "controllers.redirect:uploadSuccess_2";

    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGet() {

        return "update";
    }


    @RequestMapping(value = "/readAnimalId", method = RequestMethod.GET)
    public String readIdMax() {

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
                id = rnd.nextInt((int) rIM.getAnimalId());
                Animal animal = animalDao.read((long) id);
                if (animal == null) {

                    System.out.println(i + " попытка найти существующий идишник");
                    i++;

                } else {

                    System.out.println("all good");
                    flag = false;
                    }
            }
        }

//        System.out.println("id: " + animal.getAnimalId() +
//                ", name: " + animal.getAnimalName() +
//                ", category: " + animal.getIdCategory());

        // если не равень налу то выбрать произвольный  идишник из базы и вывести на экран
//            if(rIM.getAnimalId() != 0 ){
//
//            }
//        }
//        long animalId =
//        Animal read = animalDao.read(animalId);
//        //  System.out.println(read.getAnimalId());
//        //  System.out.println(read.getAnimalName());
//
//        //  System.out.println(read.getIdCategory());
//        //System.out.println(read.getAnimalPicture());
//        String image = new String(read.getAnimalPicture());
//        String sound = new String(read.getAnimalSound());
        //  System.out.println(image);

        // model.addAttribute("image", image);
        // model.addAttribute("sound", sound);
        return "getAnimal";
    }

//    @ResponseBody
//    @RequestMapping(value = "/getAnimal", method = RequestMethod.GET)
//    public String read(@RequestParam("animalName") String f) {
//        Animal read = animalDao.getAnimal(f);
//        System.out.println(read);
//        return "getAll";
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String uploadFilePost(@RequestParam("photo") MultipartFile filePhoto,
                                 @RequestParam("audio") MultipartFile fileAudio,
                                 @RequestParam String name,
                                 @RequestParam int category,
                                 ModelMap model) {


        /*System.out.println(filePhoto);
        System.out.println(filePhoto);*/
        try {
            if (!filePhoto.isEmpty() && !fileAudio.isEmpty()) {
                // store the bytes somewhere

//                byte[] encodedBytesPhoto = Base64.getEncoder().encode(filePhoto.getBytes());
//                byte[] encodedBytesAudio = Base64.getEncoder().encode(fileAudio.getBytes());
                Animal animal = new Animal();
                animal.setAnimalName(name);
                animal.setIdCategory(category);
                animal.setAnimalPicture(Base64.getEncoder().encode(filePhoto.getBytes()));
                animal.setAnimalSound(Base64.getEncoder().encode(fileAudio.getBytes()));

//                String base64EncodedPhoto = new String(Base64.getEncoder().encode(filePhoto.getBytes()));
//                System.out.println("name: " + name);
//                System.out.println("category: " + category);
//                System.out.println("encodedBytes " + new String(encodedBytesPhoto));
//                System.out.println("encodedBytes " + new String(encodedBytesAudio));
//
//                System.out.println("---");
//                System.out.println(base64EncodedPhoto);
//                System.out.println("---");
                animalDao.create(animal);
//                model.addAttribute("image", base64EncodedPhoto);


                return "loginAdmin";
            } else {
                return "controllers.redirect:uploadFailure";
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
        return "controllers.redirect:uploadSuccess_2";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String uploadFileGet() {

        return "upload";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
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

        System.out.println(getAll);
//        for (Animal getAllAni : getAll) {
//            System.out.println(getAllAni);
//        }


        //  System.out.println("getAll.size = " + getAll.size());
      /*  for (Iterator<Animal> it = getAll.iterator(); it.hasNext();) {
            Animal animal = (Animal) it.next();
            System.out.println(animal.toString());
        }*/

        //model.addAttribute("all", getAll);
        return "getAll";
    }


}

//    @RequestMapping("/readAnimalId")
//    public String read(@RequestParam("id") int animalId, ModelMap model) {
//
//        Animal read = animalDao.read(animalId);
//        //  System.out.println(read.getAnimalId());
//        //  System.out.println(read.getAnimalName());
//
//        //  System.out.println(read.getIdCategory());
//        //System.out.println(read.getAnimalPicture());
//        String image = new String(read.getAnimalPicture());
//        String sound = new String(read.getAnimalSound());
//        //  System.out.println(image);
//
//        model.addAttribute("image", image);
//        model.addAttribute("sound", sound);
//        return "getAnimal";
//    }
