package com.example.demo.service;

import com.example.demo.dao.ScheduleDAO;
import com.example.demo.dao.VetDAO;
import com.example.demo.dao.VeterDAO;
import com.example.demo.pojo.Schedule;
import com.example.demo.pojo.Vet;
import com.example.demo.pojo.Veter;
import com.example.demo.utility.LocationMapper;
import com.example.demo.viewmodel.VetLocationRegister;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VetService {
    @Autowired
    VetDAO vetDAO;
    @Autowired
    VeterDAO veterDAO;
    @Autowired
    ScheduleDAO scheduleDAO;
    @Autowired
    VeterService veterService;

    /**
     * Method to get all vets
     *
     * @return list of vets
     */
    public List<Vet> listall() {

        return vetDAO.findAll(Sort.by(Sort.Direction.ASC, "vetName"));
    }

    /**
     * Method to get all undeleted vets
     *
     * @return list of undeleted vets
     */
    public List<Vet> list() {

        return vetDAO.findAllByIsDeletedFalse(Sort.by(Sort.Direction.ASC, "vetName"));
    }

    /**
     * Method to get vet by betid
     *
     * @param vetid
     * @return vet
     */
    public Vet getByVetID(Integer vetid) {

        return vetDAO.findByVetIDAndIsDeletedFalse(vetid);
    }

    /**
     * Method to edit vet profile
     *
     * @param vet
     */
    public void editVetProfile(Vet vet) {

        Date updatedDate = new Date();

        Vet vetModel = this.getByVetID(vet.getVetId());
        vetModel.setVetAddress(vet.getVetAddress());
        vetModel.setVetName(vet.getVetName());
        vetModel.setVetDescription(vet.getVetDescription());
        vetModel.setOperatingHourStart(vet.getOperatingHourStart());
        vetModel.setOperatingHourEnd(vet.getOperatingHourEnd());
        vetModel.setUpdatedBy(vet.getUpdatedBy());
        vetModel.setUpdatedDate(updatedDate);

        vetDAO.save(vetModel);
    }

    public List<Vet> dataProcess(String json) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();

        DateFormat format = new SimpleDateFormat("hh:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
        Date startTime = format.parse("09:00:00");
        Date endTime = format.parse("18:30:00");

        PublicData data = objectMapper.readValue(json, PublicData.class);
        var records = data.result.records;

        var newVets = new ArrayList<Vet>();
        for (Record record : records) {
            Vet newVet = new Vet();
            newVet.setVetName(record.name);
            newVet.setVetAddress(record.address);
            newVet.setOperatingHourStart(startTime);
            newVet.setOperatingHourEnd(endTime);
            newVet.setPostal_code(record.postal_code);
            newVet.setTel_office_1(record.tel_office_1);
            newVet.setTel_office_2(record.tel_office_2);
            newVets.add(newVet);
        }
        vetDAO.truncateTable();
        vetDAO.saveAll(newVets);

        return newVets;
    }

    public void generateVetter(){
        int i =1;
        var vetterList = new ArrayList<Veter>();

        while (i <80)
        {
            int j =0;
            while(j<3) {
                Vet vet = getByVetID(i);
                List<String> nameList = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson", "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White", "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hall", "Young", "Allen", "Sanchez", "Wright", "King", "Scott", "Green", "Baker", "Adams", "Nelson", "Hill", "Ramirez", "Campbell", "Mitchell", "Roberts", "Carter", "Phillips", "Evans", "Turner", "Torres", "Parker", "Collins", "Edwards", "Stewart", "Flores", "Morris", "Nguyen", "Murphy", "Rivera", "Cook", "Rogers", "Morgan", "Peterson", "Cooper", "Reed", "Bailey", "Bell", "Gomez", "Kelly", "Howard", "Ward", "Cox", "Diaz", "Richardson", "Wood", "Watson", "Brooks", "Bennett", "Gray", "James", "Reyes", "Cruz", "Hughes", "Price", "Myers", "Long", "Foster", "Sanders", "Ross", "Morales", "Powell", "Sullivan", "Russell", "Ortiz", "Jenkins", "Gutierrez", "Perry", "Butler", "Barnes", "Fisher", "Henderson", "Coleman", "Simmons", "Patterson", "Jordan", "Reynolds", "Hamilton", "Graham", "Kim", "Gonzales", "Alexander", "Ramos", "Wallace", "Griffin", "West", "Cole", "Hayes", "Chavez", "Gibson", "Bryant", "Ellis", "Stevens", "Murray", "Ford", "Marshall", "Owens", "Mcdonald", "Harrison", "Ruiz", "Kennedy", "Wells", "Alvarez", "Woods", "Mendoza", "Castillo", "Olson", "Webb", "Washington", "Tucker", "Freeman", "Burns", "Henry", "Vasquez", "Snyder", "Simpson", "Crawford", "Jimenez", "Porter", "Mason", "Shaw", "Gordon", "Wagner", "Hunter", "Romero", "Hicks", "Dixon", "Hunt", "Palmer", "Robertson", "Black", "Holmes", "Stone", "Meyer", "Boyd", "Mills", "Warren", "Fox", "Rose", "Rice", "Moreno", "Schmidt", "Patel", "Ferguson", "Nichols", "Herrera", "Medina", "Ryan", "Fernandez", "Weaver", "Daniels", "Stephens", "Gardner", "Payne", "Kelley", "Dunn", "Pierce", "Arnold", "Tran", "Spencer", "Peters", "Hawkins", "Grant", "Hansen", "Castro", "Hoffman", "Hart", "Elliott", "Cunningham", "Knight", "Bradley", "Carroll", "Hudson", "Duncan", "Armstrong", "Berry", "Andrews", "Johnston", "Ray", "Lane", "Riley", "Carpenter", "Perkins", "Aguilar", "Silva", "Richards", "Willis", "Matthews", "Chapman", "Lawrence", "Garza", "Vargas", "Watkins", "Wheeler", "Larson", "Carlson", "Harper", "George", "Greene", "Burke", "Guzman", "Morrison", "Munoz", "Jacobs", "Obrien", "Lawson", "Franklin", "Lynch", "Bishop", "Carr", "Salazar", "Austin", "Mendez", "Gilbert", "Jensen", "Williamson", "Montgomery", "Harvey", "Oliver", "Howell", "Dean", "Hanson", "Weber", "Garrett", "Sims", "Burton", "Fuller", "Soto", "Mccoy", "Welch", "Chen", "Schultz", "Walters", "Reid", "Fields", "Walsh", "Little", "Fowler", "Bowman", "Davidson", "May", "Day", "Schneider", "Newman", "Brewer", "Lucas", "Holland", "Wong", "Banks", "Santos", "Curtis", "Pearson", "Delgado", "Valdez", "Pena", "Rios", "Douglas", "Sandoval", "Barrett", "Hopkins", "Keller", "Guerrero", "Stanley", "Bates", "Alvarado", "Beck", "Ortega", "Wade", "Estrada", "Contreras", "Barnett", "Caldwell", "Santiago", "Lambert", "Powers", "Chambers", "Nunez", "Craig", "Leonard", "Lowe", "Rhodes", "Byrd", "Gregory", "Shelton", "Frazier", "Becker", "Maldonado", "Fleming", "Vega", "Sutton", "Cohen", "Jennings", "Parks", "Mcdaniel", "Watts", "Barker", "Norris", "Vaughn", "Vazquez", "Holt", "Schwartz", "Steele", "Benson", "Neal", "Dominguez", "Horton", "Terry", "Wolfe", "Hale", "Lyons", "Graves", "Haynes", "Miles", "Park", "Warner", "Padilla", "Bush", "Thornton", "Mccarthy", "Mann", "Zimmerman", "Erickson", "Fletcher", "Mckinney", "Page", "Dawson", "Joseph", "Marquez", "Reeves", "Klein", "Espinoza", "Baldwin", "Moran", "Love", "Robbins", "Higgins", "Ball", "Cortez", "Le", "Griffith", "Bowen", "Sharp", "Cummings", "Ramsey", "Hardy", "Swanson", "Barber", "Acosta", "Luna", "Chandler", "Blair", "Daniel", "Cross", "Simon", "Dennis", "Oconnor", "Quinn", "Gross", "Navarro", "Moss", "Fitzgerald", "Doyle", "Mclaughlin", "Rojas", "Rodgers", "Stevenson", "Singh", "Yang", "Figueroa", "Harmon", "Newton", "Paul", "Manning", "Garner", "Mcgee", "Reese", "Francis", "Burgess", "Adkins", "Goodman", "Curry", "Brady", "Christensen", "Potter", "Walton", "Goodwin", "Mullins", "Molina", "Webster", "Fischer", "Campos", "Avila", "Sherman", "Todd", "Chang", "Blake", "Malone", "Wolf", "Hodges", "Juarez", "Gill", "Farmer", "Hines", "Gallagher", "Duran", "Hubbard", "Cannon", "Miranda", "Wang", "Saunders", "Tate", "Mack", "Hammond", "Carrillo", "Townsend", "Wise", "Ingram", "Barton", "Mejia", "Ayala", "Schroeder", "Hampton", "Rowe", "Parsons", "Frank", "Waters", "Strickland", "Osborne", "Maxwell", "Chan", "Deleon", "Norman", "Harrington", "Casey", "Patton", "Logan", "Bowers", "Mueller", "Glover", "Floyd", "Hartman", "Buchanan", "Cobb", "French", "Kramer", "Mccormick", "Clarke", "Tyler", "Gibbs", "Moody", "Conner", "Sparks", "Mcguire", "Leon", "Bauer", "Norton", "Pope", "Flynn", "Hogan", "Robles", "Salinas", "Yates", "Lindsey", "Lloyd", "Marsh", "Mcbride", "Owen", "Solis", "Pham", "Lang", "Pratt", "Lara", "Brock", "Ballard", "Trujillo", "Shaffer", "Drake", "Roman", "Aguirre", "Morton", "Stokes", "Lamb", "Pacheco", "Patrick", "Cochran", "Shepherd", "Cain", "Burnett", "Hess", "Li", "Cervantes", "Olsen", "Briggs", "Ochoa", "Cabrera", "Velasquez", "Montoya", "Roth", "Meyers", "Cardenas", "Fuentes", "Weiss", "Hoover", "Wilkins", "Nicholson", "Underwood", "Short", "Carson", "Morrow", "Colon", "Holloway", "Summers", "Bryan", "Petersen", "Mckenzie", "Serrano", "Wilcox", "Carey", "Clayton", "Poole", "Calderon", "Gallegos", "Greer", "Rivas", "Guerra", "Decker", "Collier", "Wall", "Whitaker", "Bass", "Flowers", "Davenport", "Conley", "Houston", "Huff", "Copeland", "Hood", "Monroe", "Massey", "Roberson", "Combs", "Franco", "Larsen", "Pittman", "Randall", "Skinner", "Wilkinson", "Kirby", "Cameron", "Bridges", "Anthony", "Richard", "Kirk", "Bruce", "Singleton", "Mathis", "Bradford", "Boone");
                List<String> surnameList = Arrays.asList("Tan", "Lim", "Lee", "Ng", "Ong", "Wong", "Goh", "Chua", "Chan", "Koh");
                List<String> gender = Arrays.asList("Male", "Female");
                String name;
                int num1 = (int) (Math.random() * (nameList.size()));
                int num2 = (int) (Math.random() * (surnameList.size()));
                int num3 = (int) (Math.random() * (gender.size()));
                name = nameList.get(num1) + " " + surnameList.get(num2);
                Veter veterModel = new Veter();
                veterModel.setVeterName(name);
                veterModel.setVeterDescription("Description");
                veterModel.setVet(vet);
                veterModel.setGender(gender.get(num3));
                veterModel.setUpdatedBy(vet.getUpdatedBy());
                veterModel.setIsDeleted(false);
                vetterList.add(veterModel);
                j++;
            }
            i++;
        }
        veterDAO.truncateTable();
        veterDAO.saveAll(vetterList);
    }

    public void generateSchedule() throws ParseException {
        var scheduleList = new ArrayList<Schedule>();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("hh:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
        Date startTime = format.parse("09:00:00");
        Date endTime = format.parse("18:30:00");

        for (int j =1; j<79*3+1;j++){
            Veter veter = veterService.getByVeterID(j);
            for (int i=1;i<6;i++) {
                Schedule item = new Schedule();
                item.setVeter(veter);
                item.setDayOfWeek(i);
                item.setStartTime(startTime);
                item.setEndTime(endTime);
                item.setCreatedBy(1);
                item.setCreatedDate(date);
                item.setIsDeleted(false);
                scheduleList.add(item);
            }
        }
        scheduleDAO.truncateTable();
        scheduleDAO.saveAll(scheduleList);
    }





    public List<Vet> getByLocationID(Integer locationid) {
        return vetDAO.findByLocationIDAndIsDeletedFalse(locationid);
    }

    public List<LocationData> getAllLocation() {
        var locationIDs=vetDAO.findGroupByLocationID();
        var locations = new ArrayList<LocationData>();

        for(int locationID : locationIDs){
           var location = new LocationData();
           location.LocationID=locationID;
           location.Name =  LocationMapper.getValue(locationID);
           locations.add(location);
        }

        return locations;
    }

    public List<Vet> updateVetLocation(List<VetLocationRegister> info) {
        var allVets = vetDAO.findAll();
        var updateVets = new ArrayList<Vet>();

        for (VetLocationRegister vet : info) {
            var matchVet = allVets.stream().filter(v -> v.getVetId() == vet.VetID).findAny().get();
            matchVet.setLocationID(vet.LocationID);
            matchVet.setCoordinate(vet.Coordinate);
            updateVets.add(matchVet);
        }
        vetDAO.saveAll(updateVets);

        return updateVets;
    }
}
