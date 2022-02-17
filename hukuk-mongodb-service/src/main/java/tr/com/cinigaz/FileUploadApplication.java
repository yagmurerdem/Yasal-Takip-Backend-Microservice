package tr.com.cinigaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import tr.com.cinigaz.entity.LoadFile;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = LoadFile.class)
public class FileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication.class, args);
    }

}