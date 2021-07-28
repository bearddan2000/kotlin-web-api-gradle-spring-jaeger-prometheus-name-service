package example;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/animals")
class DefaultRestController {

    var nameList: List<String> = ArrayList<String>();
    val random: Random = Random();
    val fileName: String = "/animals.txt";

    @Throws(IOException::class)
    fun init() {
        val inputStream: InputStream = ClassPathResource(fileName).getInputStream();
        try {
          val reader: BufferedReader = BufferedReader(InputStreamReader(inputStream))
          nameList = reader.lines().collect(Collectors.toList());
        } catch(e: IOException) {}
    }

    @GetMapping("/random")
    fun name(@RequestHeader headers: HttpHeaders ): String {
      init();
      return nameList.get(random.nextInt(nameList.size));
    }
}
