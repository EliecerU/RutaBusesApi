package com.api_buses.demo;

// import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
// import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

//import static java.util.Objects.requireNonNull;

@SpringBootApplication
@ComponentScan(basePackages = "com.api_buses.controllers, com.api_buses.services")
public class DemoApplication {

	public static void main(String[] args) throws IOException, NullPointerException  {

		// ClassLoader classLoader = DemoApplication.class.getClassLoader();

		// File file = new File(Objects.requireNonNull(classLoader.getResource("src/main/resources/serviceAccountKey.json")).getFile());
		// FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
		// FirebaseOptions options =  FirebaseOptions.builder()
		// 		.setCredentials(GoogleCredentials.fromStream(serviceAccount))
		// 		.build();

		// FirebaseApp.initializeApp(options);

		FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.build();

			FirebaseApp.initializeApp(options);

		SpringApplication.run(DemoApplication.class, args);
	}

}
