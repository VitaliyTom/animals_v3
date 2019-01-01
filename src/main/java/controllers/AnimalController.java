
package controllers;

import dto.AnimalDto;
import entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.AnimalService;

import java.util.Base64;


@Controller
@RequestMapping("/animal")
public class AnimalController {



    @Autowired
    private AnimalService animalService;




    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String uploadFilePost(@RequestParam("photo") MultipartFile filePhoto,
                                 @RequestParam("audio") MultipartFile fileAudio,
                                 @RequestParam String name,
                                 @RequestParam int category) {

        AnimalDto animalDto = new AnimalDto();

        animalDto.setAnimalName(name);
        animalDto.setIdCategory(category);
        try {
            if (!filePhoto.isEmpty() && !fileAudio.isEmpty() ) {

                animalDto.setAnimalPicture(Base64.getEncoder().encode(filePhoto.getBytes()));
                animalDto.setAnimalSound(Base64.getEncoder().encode(fileAudio.getBytes()));
            }
        } catch (Exception ex) {
            System.out.println("error_field_upload");
        }

        animalService.create(animalDto);
//        Animal animal = new Animal();
//        animal.setAnimalName(name);
//        animal.setIdCategory(category);

//        try {
//            if (!filePhoto.isEmpty() && !fileAudio.isEmpty()) {
//                animal.setAnimalPicture(Base64.getEncoder().encode(filePhoto.getBytes()));
//                animal.setAnimalSound(Base64.getEncoder().encode(fileAudio.getBytes()));
////              animalDao.create(animal);
//            }
//        } catch (Exception ex) {
//
//            System.out.println("error_field_upload");
//        }
//
//        animalService.create(animal);

        return "loginAdmin";


    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String uploadFileGet() {

        return "upload";
    }


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
    public String readAnimalIdMax(ModelMap model) {

        animalService.getIdMax(model);
//
//        Animal animalIdMax = animalDao.getIdMax();
//
//        int id = 0;
//        Random rnd = new Random();
//        int i = 1;
//        boolean flag = true;
//        while (flag) {
//
//            id = 1 + rnd.nextInt((int) animalIdMax.getAnimalId());
//            System.out.println("-------id------" + id);
//            Animal animal = animalDao.read((long) id);
//
//            if (animal == null) {
//
//                System.out.println(i + " попытка найти существующий идишник");
//                i++;
//
//            } else {
//
//                System.out.println("all good " + "id = " + id);
//                flag = false;
//                String image = new String(animal.getAnimalPicture());
//                String sound = new String(animal.getAnimalSound());
//                System.out.println(animal.getAnimalName());
//
//                model.addAttribute("id", animal.getAnimalId());
//                model.addAttribute("name", animal.getAnimalName());
//                model.addAttribute("category", animal.getIdCategory());
//                model.addAttribute("image", image);
//                model.addAttribute("sound", sound);
//
//            }
//        }


//        System.out.println(animal.getAnimalId());
//        System.out.println(animal.getAnimalName());
//        System.out.println(animal.getIdCategory());


//        List<Animal> readIdMax = animalDao.readIdMax();
//        int id = 0;
//        for (Animal rIM : readIdMax) {
//            System.out.println("id: " + rIM.getAnimalId() +
//                    ", name: " + rIM.getAnimalName() +
//                    ", category: " + rIM.getIdCategory());
//
//            Random rnd = new Random();
//            int i = 1;
//            boolean flag = true;
//            while (flag) {
//
//                //int number = min + rnd.nextInt(max - min + 1);
//
//                id = 1 + rnd.nextInt((int) rIM.getAnimalId());
//                System.out.println("-------id------" + id);
//                Animal animal = animalDao.read((long) id);
//                if (animal == null) {
//
//                    System.out.println(i + " попытка найти существующий идишник");
//                    i++;
//
//                } else {
//
//                    System.out.println("all good");
//                    flag = false;
//                    String image = new String(animal.getAnimalPicture());
//                    String sound = new String(animal.getAnimalSound());
//                    System.out.println(animal.getAnimalName());
//
//                    model.addAttribute("id", animal.getAnimalId());
//                    model.addAttribute("name", animal.getAnimalName());
//                    model.addAttribute("category", animal.getIdCategory());
//                    model.addAttribute("image", image);
//                    model.addAttribute("sound", sound);
//
//                }
//            }
//        }

        return "getAnimal";
    }





    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePost(@RequestParam("id") int animalId) {
        Animal animal = new Animal();
        animal.setAnimalId(animalId);
        animalService.delete(animal);

        return "loginAdmin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGet() {

        return "delete";
    }


    @RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
    public String loginAdmin() {

        return "loginAdmin";
    }



    @RequestMapping("/getAll")
    public String getAllGet(ModelMap model) {

        animalService.getAll(model);

        return "getAll";
    }


}



