package example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "scientist-service-client", url = "http://scientist-name-service:8090")
interface ScientistServiceClient {
    @GetMapping("/api/v1/scientists/random")
    fun randomScientistName(): String;
}
