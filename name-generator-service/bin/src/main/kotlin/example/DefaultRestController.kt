package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import strman.Strman.toKebabCase;

@RestController
@RequestMapping("/api/v1/names")
class DefaultRestController {

    @Autowired
    lateinit var animalServiceClient :example.feignclient.AnimalServiceClient;

    @Autowired
    lateinit var scientistServiceClient :example.feignclient.ScientistServiceClient;

    @Throws(Exception::class)
    @GetMapping("/random")
    fun name(): String {
        val animal: String = animalServiceClient.randomAnimalName();
        val scientist: String = scientistServiceClient.randomScientistName();
        return toKebabCase(scientist) + "-" + toKebabCase(animal);
    }
}
