package pl.edu.utp.jobfinder.generator.data;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bartłomiej Skibiński
 */
public abstract class DataValues {

    // Data lists
    private static final List<String> firstnames = Arrays.asList( // 50 (5 x 10)
            "James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph", "Thomas",
            "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward", "Brian",
            "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Mary", "Patricia", "Linda", "Barbara", "Elizabeth",
            "Jennifer", "Maria", "Susan", "Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Hellen",
            "Sandra", "Donna", "Carol", "Ruth", "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah"
    );
    private static final List<String> lastnames = Arrays.asList( // 50 (5 x 10)
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson",
            "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White",
            "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hull",
            "Young", "Allen", "Sanchez", "Wright", "King", "Scott", "Green", "Baker", "Adams", "Nelson",
            "Hill", "Ramirez", "Campbell", "Mitchell", "Roberts", "Carter", "Phillips", "Evans", "Turner", "Torres"
    );
    private static final List<String> emailProviders = Arrays.asList( // 20 (4 x 5)
            "aol.com", "atmail.com", "fastmail.com", "gmail.com", "gmx.net",
            "hushmail.com", "icloud.com", "lycos.com", "mail.com", "mail.ru",
            "mailfence.com", "outlook.com", "protonmail.com", "rackspace.com", "rediff.com",
            "runbox.com", "tutanota.com", "yahoo.com", "yandex.com", "zohocorp.com"
    );
    private static final List<String> streetNames = Arrays.asList( // 50 (10 x 5)
            "High Street", "Station Road", "Main Street", "Park Road", "Church Road",
            "Church Street", "London Road", "Victoria Road", "Green Lane", "Manor Road",
            "Church Lane", "Park Avenue", "The Avenue", "The Crescent", "Queens Road",
            "New Road", "Grange Road", "Kings Road", "Kingsway", "Windsor Road",
            "Highfield Road", "Mill Lane", "Alexander Road", "York Road", "St. John's Road",
            "Main Road", "Broadway", "King Street", "The Green", "Springfield Road",
            "Georg Street", "Park Lane", "Victoria Street", "Albert Road", "Queensway",
            "New Street", "Queen Street", "West Street", "North Street", "Manchaster Road",
            "The Groove", "Richmond Road", "Grove Road", "South Street", "School Lane",
            "The Drive", "North Road", "Stanley Road", "Chester Road", "Mill Road"
    );
    private static final List<String> cities = Arrays.asList( // 64 (8 x 8)
            "Aberdeen", "Armagh", "Bangor", "Bath", "Belfast", "Birmingham", "Bradford", "Brighton & Hove",
            "Bristol", "Cambridge", "Canterbury", "Cardiff", "Carlisle", "Chelmsford", "Chester", "Chichester",
            "Coventry", "Derby", "Derry", "Dundee", "Durham", "Edinburgh", "Ely", "Exeter",
            "Glasgow", "Gloucester", "Hereford", "Inverness", "Lancaster", "Leeds", "Leicester", "Winchester",
            "Lichfield", "Lincoln", "Lisborn", "Liverpool", "City of London", "Manchaster", "Newcastle upon Tyne", "Newport",
            "Newry", "Norwich", "Nottingham", "Oxford", "Perth", "Peterborough", "Plymouth", "Portsmouth",
            "Preston", "Ripon", "Salford", "Salisbury", "Sheffield", "Southampton", "Stirling", "Sunderland",
            "Swansea", "Truro", "Wakefield", "Wells", "City of Westminster", "Wolverhampton", "Worcester", "York"
    );
    private static final List<String> schools = Arrays.asList( // 50 (10 x 5)
            "Balliol Lower School", "Christopher Reeves VA Lower School", "The Hills Academy", "Lakeview School", "Shackleton Primary School",
            "Mark Rutherford School", "Bedford Academy", "Beauchamp Middle School", "St Gregory's Roman Catholic Middle School", "Westfield School",
            "Fox Primary School", "St Mary's RC Primary School", "Thomas Jones Primary School", "Chelsea Academy", "Beddington Infants' School",
            "Robin Hood Junior School", "Stanley Park Junior School", "Cheam High School", "Wilson's School", "Sherwood Park School",
            "Hallfield Primary School", "King Solomon Academy", "St Luke's CE Primary School", "Queen's Park Primary School", "Paddington Academy",
            "Westminster Academy", "Queen Elizabeth II Jubilee School", "City of Westminster College", "Westminster Kingsway College", "Albert Bradbeer Primary School",
            "Arden Primary School", "Birches Green Infant School", "Gossey Lane Junior & Infant & Nursery School", "James Watt Primary School", "Wattville Primary School",
            "Cherry Oak School", "James Brindley School", "Victoria School", "Queensbury School", "Birmingham Metropolitan College",
            "Fircroft College", "Joseph Chamberlain Sixth Form College", "Bournville College", "Norfolk House School", "Green Heath School",
            "York College", "Askham Bryan College", "Huntington School", "York High School", "Manor Church of England School"
    );
    private static final List<String> subjects = Arrays.asList( // 80 (10 x 8)
            "Veterinary Medicine", "Farm Management", "Astronomy", "Biology", "Chemistry", "Earth Sciences", "Environmental Sciences", "Food Science and Technology",
            "Physical Geography", "Life Sciences", "Material Sciences", "Mathematics", "Physics", "Sports Science", "Architecture", "Built Environment",
            "Construction", "Planning", "Accounting", "Business Studies", "E-Commerce", "Finance", "Human Resources Management", "Management",
            "Marketing", "Office Administration", "Transportation and Logistics", "Computer Science", "Computing", "IT", "Multimedia", "Software",
            "Art", "Graphic Design", "Interior Design", "Music", "Theatre and Drama Studies", "Adult Education", "Childhood Education", "Pedagogy",
            "Electronic Engineering", "Electrical Engineering", "Mechanical Engineering", "Power and Energy Engineering", "Telecommunications", "Vehicle Engineering", "Massage", "Health and Fitness",
            "Complementary Health", "Dentistry", "Health Studies", "Health and Safety", "Medicine", "Nursing", "Pharmacology", "Physiology",
            "Physiotherapy", "Psychology", "Archaeology", "Cultural Studies", "History", "Languages", "Literature", "Philosophy",
            "Religious Studies", "Civil Law", "Criminal Law", "Public Law", "Economics", "Politics", "Sociology", "Photography",
            "Journalism", "Hotel Management", "Travel and Tourism", "Media", "Linguistics", "International relations", "Legal Advice", "Ophthalmology"
    );
    private static final List<String> employers = Arrays.asList( // 60 (10 x 6)
            "Costco Wholesale", "Google", "REI", "Memorial Hermann Health System", "United Services Automobile Association", "MD Anderson Cancer Center",
            "Penn Medicine", "Mayo Clinic", "City of Austin", "Wegmans Food Markets", "The Container Store", "JetBlue Airways",
            "Facebook", "University of Iowa Hospitals & Clinics", "University of Miami", "Trader Joe's", "QuikTrip", "Winthrop University Hospital",
            "Genentech", "Sandia National Laboratories", "SAS", "Williams", "Coldwell Banker", "The Christ Hospital Health Network",
            "Navy Federal Credit Union", "Four Seasons Hotels and Resorts", "Duke University", "Black & Veatch", "Lee Memorial Health System", "Publix Super Markets",
            "University of Texas Health Science Center at Houston", "WL Gore & Associates", "Intercontinental Hotels Group", "Michelin Group", "Southwest Airlines", "Stater Bros",
            "NASA", "Covenant Health", "H&M", "University of Colorado Health", "H-E-B Grocery Stores", "Promedica",
            "U.S. Courts", "Vanguard", "Sharp HealthCare", "Garmin", "Methodist Le Bonheur Healthcare", "Kimberly-Clark",
            "Partners HealthCare System", "Microsoft", "Houston Methodist", "UCSF Medical Center", "Cargill", "In-N-Out Burger",
            "Montgomery County Public Schools", "Marathon Petroleum", "Yale New Haven Health", "Sikorsky", "Johns Hopkins University", "LinkedIn"
    );
    private static final List<String> positions = Arrays.asList( // 80 (8 x 10)
            "Accountant", "Air Traffic Controller", "Animal Scientist", "Archeologist", "Architect", "Artist", "Astronomer", "Baker", "Barber", "Bartender",
            "Biochemist", "Biologist", "Bus Driver", "Butcher", "Camera Operator", "CEO", "CFO", "Chef", "Chemist", "Child Care",
            "Cleaner of Vehicles", "Copy Writer", "Courier", "Database Administrator", "Dentist", "Designer", "Director Of Marketing", "Economist", "Electrician", "Electronics Engineer",
            "Farmer", "Financial Analyst", "Fire Fighter", "Fraud Investigator", "Funeral Director", "Graphic Designer", "Historian", "House Cleaner", "Housekeeper", "HR Manager",
            "Inspector", "Internist", "Judge", "Lawyer", "Librarian", "Locksmith", "Logistician", "Machinist", "Marketing Manager", "Mathematician",
            "Nuclear Engineer", "Orthodontist", "Painter", "Paralegal", "Pharmacist", "Photographer", "Physician", "Physicist", "Plumber", "Police Detective",
            "PR Manager", "Private Detective and Investigator", "Production Worker", "Project Manager", "Psychiatrist", "Psychologist", "Recruiter", "Safety Engineer", "School Bus Driver", "Secretary",
            "Sheriff", "Singer", "Sociologist", "Stripper", "Teacher", "Telemarketer", "Tour Guide", "Veterinarian", "Waitress", "Webmaster"
    );
    private static final List<String> skills = Arrays.asList( // TODO : skills
            "A", "B", "C"
    );
    private static final List<String> languages = Arrays.asList( // TODO : languages
            "A", "B", "C"
    );
    private static final List<String> interests = Arrays.asList( // TODO : interests
            "A", "B", "C"
    );
    private static final List<String> words = Arrays.asList( // TODO : words
            "lorem", "ipsum", "dolor", "sit", "amet"
    );
    private static final List<String> requirementsAndAdvantages = Arrays.asList( // TODO : requirementsAndAdvantages
            "lorem", "ipsum", "dolor", "sit", "amet"
    );
    private static final List<String> businessCategories = Arrays.asList( // TODO : businessCategories
            "lorem", "ipsum", "dolor", "sit", "amet"
    );

    // Getters
    public static List<String> getFirstnames() {
        return firstnames;
    }

    public static List<String> getLastnames() {
        return lastnames;
    }

    public static List<String> getEmailProviders() {
        return emailProviders;
    }

    public static List<String> getStreetNames() {
        return streetNames;
    }

    public static List<String> getCities() {
        return cities;
    }

    public static List<String> getSchools() {
        return schools;
    }

    public static List<String> getSubjects() {
        return subjects;
    }

    public static List<String> getEmployers() {
        return employers;
    }

    public static List<String> getPositions() {
        return positions;
    }

    public static List<String> getSkills() {
        return skills;
    }

    public static List<String> getLanguages() {
        return languages;
    }

    public static List<String> getInterests() {
        return interests;
    }

    public static List<String> getWords() {
        return words;
    }

    public static List<String> getRequirementsAndAdvantages() {
        return requirementsAndAdvantages;
    }

    public static List<String> getBusinessCategories() {
        return businessCategories;
    }

}
