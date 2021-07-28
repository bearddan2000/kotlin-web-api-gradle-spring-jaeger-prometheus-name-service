package example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "animal-service-client", url = "http://animal-name-service:9000")
interface AnimalServiceClient {

    @GetMapping("/api/v1/animals/random")
    fun randomAnimalName(): String;
}
