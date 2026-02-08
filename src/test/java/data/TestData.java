package data;

import com.github.javafaker.*;

public class TestData {

    Faker faker = new Faker();

    public String fullName = faker.name().fullName(),
            email = faker.internet().emailAddress(),
            number = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().fullAddress(),
            someText = faker.harryPotter().character();
}