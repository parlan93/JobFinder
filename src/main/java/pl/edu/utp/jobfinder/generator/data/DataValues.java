package pl.edu.utp.jobfinder.generator.data;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bartłomiej Skibiński
 */
public abstract class DataValues {

    // Data lists
    private static final List<String> FIRSTNAMES = Arrays.asList( // 50 (5 x 10)
            "James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph", "Thomas",
            "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward", "Brian",
            "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Mary", "Patricia", "Linda", "Barbara", "Elizabeth",
            "Jennifer", "Maria", "Susan", "Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Hellen",
            "Sandra", "Donna", "Carol", "Ruth", "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah"
    );
    private static final List<String> LASTNAMES = Arrays.asList( // 50 (5 x 10)
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson",
            "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White",
            "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hull",
            "Young", "Allen", "Sanchez", "Wright", "King", "Scott", "Green", "Baker", "Adams", "Nelson",
            "Hill", "Ramirez", "Campbell", "Mitchell", "Roberts", "Carter", "Phillips", "Evans", "Turner", "Torres"
    );
    private static final List<String> EMAIL_PROVIDERS = Arrays.asList( // 20 (4 x 5)
            "aol.com", "atmail.com", "fastmail.com", "gmail.com", "gmx.net",
            "hushmail.com", "icloud.com", "lycos.com", "mail.com", "mail.ru",
            "mailfence.com", "outlook.com", "protonmail.com", "rackspace.com", "rediff.com",
            "runbox.com", "tutanota.com", "yahoo.com", "yandex.com", "zohocorp.com"
    );
    private static final List<String> STREET_NAMES = Arrays.asList( // 50 (10 x 5)
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
    private static final List<String> CITIES = Arrays.asList( // 64 (8 x 8)
            "Aberdeen", "Armagh", "Bangor", "Bath", "Belfast", "Birmingham", "Bradford", "Brighton & Hove",
            "Bristol", "Cambridge", "Canterbury", "Cardiff", "Carlisle", "Chelmsford", "Chester", "Chichester",
            "Coventry", "Derby", "Derry", "Dundee", "Durham", "Edinburgh", "Ely", "Exeter",
            "Glasgow", "Gloucester", "Hereford", "Inverness", "Lancaster", "Leeds", "Leicester", "Winchester",
            "Lichfield", "Lincoln", "Lisborn", "Liverpool", "City of London", "Manchaster", "Newcastle upon Tyne", "Newport",
            "Newry", "Norwich", "Nottingham", "Oxford", "Perth", "Peterborough", "Plymouth", "Portsmouth",
            "Preston", "Ripon", "Salford", "Salisbury", "Sheffield", "Southampton", "Stirling", "Sunderland",
            "Swansea", "Truro", "Wakefield", "Wells", "City of Westminster", "Wolverhampton", "Worcester", "York"
    );
    private static final List<String> SCHOOLS = Arrays.asList( // 50 (10 x 5)
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
    private static final List<String> SUBJECTS = Arrays.asList( // 80 (10 x 8)
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
    private static final List<String> EMPLOYERS = Arrays.asList( // 60 (10 x 6)
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
    private static final List<String> POSITIONS = Arrays.asList( // 80 (8 x 10)
            "Accountant", "Air Traffic Controller", "Animal Scientist", "Archeologist", "Architect", "Artist", "Astronomer", "Baker", "Barber", "Bartender",
            "Biochemist", "Biologist", "Bus Driver", "Butcher", "Camera Operator", "CEO", "CFO", "Chef", "Chemist", "Child Care",
            "Cleaner of Vehicles", "Copy Writer", "Courier", "Database Administrator", "Dentist", "Designer", "Director Of Marketing", "Economist", "Electrician", "Electronics Engineer",
            "Farmer", "Financial Analyst", "Fire Fighter", "Fraud Investigator", "Funeral Director", "Graphic Designer", "Historian", "House Cleaner", "Housekeeper", "HR Manager",
            "Inspector", "Internist", "Judge", "Lawyer", "Librarian", "Locksmith", "Logistician", "Machinist", "Marketing Manager", "Mathematician",
            "Nuclear Engineer", "Orthodontist", "Painter", "Paralegal", "Pharmacist", "Photographer", "Physician", "Physicist", "Plumber", "Police Detective",
            "PR Manager", "Private Detective and Investigator", "Production Worker", "Project Manager", "Psychiatrist", "Psychologist", "Recruiter", "Safety Engineer", "School Bus Driver", "Secretary",
            "Sheriff", "Singer", "Sociologist", "Stripper", "Teacher", "Telemarketer", "Tour Guide", "Veterinarian", "Waitress", "Webmaster"
    );
    private static final List<String> SKILLS = Arrays.asList( // 70 (10 x 7)
            "Accounting", "Active Listening", "Administrative", "Analytical", "Behavioral", "Business Intelligence", "Business",
            "Business Storytelling", "Collaboration", "Communication", "Computer", "Conceptual", "Conflict Management", "Conflict Resolution",
            "Consulting", "Content Strategy", "Creative Thinking", "Critical Thinking", "Customer Service", "Decision Making", "Delegation",
            "Deductive Reasoning", "Digital Marketing", "Digital Media", "Editing", "Employability", "Entrepreneurial", "Finance",
            "Flexibility", "General", "Health Care Skills Listed by Job", "Hard Skills", "Life Skills", "Hospitality Industry", "Inductive Reasoning",
            "Information Technology", "Interpersonal", "Leadership", "Legal", "Listening", "Logical Thinking", "Management",
            "Marketing", "Microsoft Office Skills", "Motivational", "Multitasking", "Negotiations", "Nonverbal Communication", "Organizational",
            "Personal", "Persuasive", "Presentation", "Problem Solving", "Public Speaking", "Research", "Retail Industry",
            "Sales", "Social", "Social Media", "Soft Skills", "Strategic Planning", "Strengths", "Team Building",
            "Teamwork", "Tech Skills", "Technical", "Time Management", "Transferable", "Verbal Communication", "Writing"
    );
    private static final List<String> LANGUAGES = Arrays.asList( // 25 (5 x 5)
            "Mandarin", "Spanish", "English", "Hindi", "Arabic",
            "Portuguese", "Bengali", "Russian", "Japanese", "German",
            "Malay", "Vietnamese", "Korean", "French", "Turkish",
            "Italian", "Thai", "Polish", "Ukrainian", "Romanian",
            "Dutch", "Greek", "Czech", "Swedish", "Belarusian"
    );
    private static final List<String> INTERESTS = Arrays.asList( // 70 (7 x 10)
            "Astrology", "Basketball", "Bingo", "Bird Watching", "Board Games", "Bowling", "Brewing Beer", "Butterfly Collecting", "Cake Making", "Calligraphy",
            "Camping", "Chess", "Child Care", "Cinema", "Crafts", "Cycling", "Dancing", "Darts", "Design", "Drawing",
            "Eating Out", "Fashion", "Fishing", "Football", "Golf", "Gym or Weight Training", "Hiking", "Horse Riding", "Ice Skating", "Judo",
            "Latin Dancing", "Listening to Music", "Magic", "Martial Arts", "Meditation", "Meeting Friends", "Model Cars", "Modelling", "Motorbikes", "Needlepoint",
            "Nights Out", "Origami", "Painting", "Photography", "Ping Pong", "Playing Guitar", "Playing Piano", "Pool", "Reading", "Riding",
            "Running", "Singing", "Skiing", "Snooker", "Snowboarding", "Stamp collecting", "Surfing", "Suring the Internet", "Swimming", "Tennis",
            "Travelling", "Video Games", "Walking", "Watching Movies", "Watching TV", "Writing", "Yoga", "Jogging", "TV Series", "Cars"
    );
    private static final List<String> WORDS = Arrays.asList( // 48 (6 x 8)
            "integer", "vitae", "consequat", "lacus", "pulvinar", "nibh", "at", "semper",
            "fusce", "mattis", "rutrum", "ligula", "venenatis", "blandit", "consectetur", "elit",
            "odio", "luctus", "rhoncus", "risus", "pellentesque", "sit", "amet", "etiam",
            "sodales", "lectus", "ac", "libero", "efficitur", "condimentum", "tincidunt", "mattis",
            "mauris", "sed", "cursus", "augue", "pretium", "proin", "rutrum", "ultrices",
            "sem", "nulla", "ligula", "lacus", "congue", "lorem", "ipsum", "dolor"
    );
    private static final List<String> BUSINESS_CATEGORIES = Arrays.asList( // 25 (5 x 5)
            "Arts", "Automotive", "Beauty & Spas", "Education", "Event Planning & Services", 
            "Financial Services", "Food", "Health & Medical", "Home Services", "Hotels & Travel", 
            "Local Services", "Mass Media", "Nightlife", "Pets", "Professional Services", 
            "Public Services & Government", "Real Estate", "Religious Organizations", "Restaurants", "Shopping",
            "Computers & Electronics", "Entertainment", "Manufacturing", "Distribution", "Transportation"
    );

    // Getters
    public static List<String> getFirstnames() {
        return FIRSTNAMES;
    }

    public static List<String> getLastnames() {
        return LASTNAMES;
    }

    public static List<String> getEmailProviders() {
        return EMAIL_PROVIDERS;
    }

    public static List<String> getStreetNames() {
        return STREET_NAMES;
    }

    public static List<String> getCities() {
        return CITIES;
    }

    public static List<String> getSchools() {
        return SCHOOLS;
    }

    public static List<String> getSubjects() {
        return SUBJECTS;
    }

    public static List<String> getEmployers() {
        return EMPLOYERS;
    }

    public static List<String> getPositions() {
        return POSITIONS;
    }

    public static List<String> getSkills() {
        return SKILLS;
    }

    public static List<String> getLanguages() {
        return LANGUAGES;
    }

    public static List<String> getInterests() {
        return INTERESTS;
    }

    public static List<String> getWords() {
        return WORDS;
    }

    public static List<String> getBusinessCategories() {
        return BUSINESS_CATEGORIES;
    }

}
