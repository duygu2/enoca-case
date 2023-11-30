package com.example.enocabackend;

import com.example.enocabackend.model.Company;
import com.example.enocabackend.model.Personnel;
import com.example.enocabackend.repository.CompanyRepository;
import com.example.enocabackend.repository.PersonnelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class EnocaBackendApplication implements CommandLineRunner {
	private final CompanyRepository companyRepository;
	private final PersonnelRepository personnelRepository;

	public EnocaBackendApplication(CompanyRepository companyRepository, PersonnelRepository personnelRepository) {
		this.companyRepository = companyRepository;
		this.personnelRepository = personnelRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(EnocaBackendApplication.class, args);
	}

	//Java uygulaması üzerinden örnek kayıt atıldı.
	@Override
	public void run(String... args) throws Exception {
		Company company = new Company();
		company.setName("Enoca Üsküdar");

		companyRepository.save(company);

		Personnel personnel = new Personnel();
		personnel.setName("Gamze Çicek");
		personnel.setMail("gamzecicek@gmail.com");
		personnel.setDepartment("Network");
		personnel.setAttendDate(new Date());
		personnel.setCompany(company);

		personnelRepository.save(personnel);
	}

}
