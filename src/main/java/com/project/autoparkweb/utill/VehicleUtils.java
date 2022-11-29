package com.project.autoparkweb.utill;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Organization;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.repository.CarBrandRepository;
import com.project.autoparkweb.mvc.model.repository.DriverRepository;
import com.project.autoparkweb.mvc.model.repository.VehicleRepository;
import com.project.autoparkweb.mvc.model.services.OrganizationService;
import com.project.autoparkweb.mvc.model.services.VehicleService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleUtils {
	private final CarBrandRepository carBrandRepository;
	private final OrganizationService organizationService;
	private final DriverRepository driverRepository;
	private final VehicleService vehicleService;
	private static String[] names = new String[]{"John", "Sandra", "Robert", "James", "Brad",
			"Terry", "Mario", "Michelle", "John", "Arthur"};
	private static String[] lastnames = new String[]{"Washington", "Norman", "Boone", "White", "Smith", "Taylor", "Harper", "Henderson",
			"Reynolds", "Tyler"};
	
	@Autowired
	public VehicleUtils(CarBrandRepository carBrandRepository, OrganizationService organizationService, DriverRepository driverRepository, VehicleService vehicleService) {
		this.carBrandRepository = carBrandRepository;
		this.organizationService = organizationService;
		this.driverRepository = driverRepository;
		this.vehicleService = vehicleService;
	}
	
	/**
	 * Генерирует для списка предприятий заданное количество машинок, содержимое их
	 * формируется случайно, и водителей (чтобы примерно каждая 10-я машинка была с активным водителем).
	 */
	public List<Vehicle> createVehiclesForOrganizations(List<Organization> organizations, int vehiclesAmount) {
		organizations = organizationService.getAll();
		List<Vehicle> vehicles = new ArrayList<>();
		long driversCount = driverRepository.count();
		long brandsCount = carBrandRepository.count();
		for (Organization organization : organizations) {
			for (int i = 0; i < vehiclesAmount; i++) {
				Vehicle vehicle = new Vehicle();
				vehicle.setPrice(RandomUtils.nextInt(100000, 10000000));
				vehicle.setReleaseDate(getRandomDate());
				vehicle.setMileage(RandomUtils.nextInt(100000, 1000000));
				vehicle.setCarId(getRandomCarId());
				vehicle.setOwner(names[RandomUtils.nextInt(0, 10)] + " " + lastnames[RandomUtils.nextInt(0, 10)]);
				vehicle.setOrganizationId(organization);
				
				long carBrandId = RandomUtils.nextLong(0, brandsCount);
				Optional<CarBrand> carBrand = carBrandRepository.findById(carBrandId);
				carBrand.ifPresent(vehicle::setCarBrandId);
				
				long countMax = RandomUtils.nextLong(0, 1000);
				if (countMax >= 900) {
					long driverId = countMax % driversCount;
					vehicle.setDriverId(driverRepository.findById(driverId).get());
				}
				vehicles.add(vehicle);
			}
		}
		return vehicles;
	}
	
	private static String getRandomCarId() {
		return getRandomChar() + getRandomChar() + getRandomNum() + getRandomNum() + getRandomNum() + getRandomChar();
	}
	
	private static String getRandomChar() {
		char[] alphabets = new char[]{'E', 'T', 'O', 'P', 'A', 'H', 'K', 'X', 'C', 'B', 'M'};
		return String.valueOf(alphabets[RandomUtils.nextInt(0, alphabets.length)]);
	}
	
	private static int getRandomNum() {
		return RandomUtils.nextInt(0, 10);
	}
	
	private static String getRandomDate() {
		Date d1 = new Date(12315415);
		Date d2 = new Date(84756435);
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date randomDate = new Date(RandomUtils.nextLong(d1.getTime(), d2.getTime()));
		return simpleDateFormat.format(randomDate);
	}
}
