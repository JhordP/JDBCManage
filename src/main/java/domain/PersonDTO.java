package domain;

public class PersonDTO { //Table Person

    //Columns
    private int personId;
    private String personName;
    private String personLastname;
    private String personEmail;
    private long personPhone;

    public PersonDTO(){} //Empty Constructor
    public PersonDTO(int id){this.personId = id;} //personId constructor
    
    //Not ID data constructor
    public PersonDTO(String personName, String personLastname, String personEmail, long personPhone ) {
        this.personName = personName;
        this.personLastname = personLastname;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
    }

    //All columns constructor
    public PersonDTO(int personId, String personName, String personLastname, String personEmail, long personPhone) {
        this.personId = personId;
        this.personName = personName;
        this.personLastname = personLastname;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
    }

    //Getters & Setters
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public String getPersonLastname() {
        return personLastname;
    }
    public void setPersonLastname(String personLastname) {
        this.personLastname = personLastname;
    }
    public String getPersonEmail() {
        return personEmail;
    }
    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }
    public long getPersonPhone() {
        return personPhone;
    }
    public void setPersonPhone(long personPhone) {
        this.personPhone = personPhone;
    }
    
    @Override
    public String toString() {
        return "Person [personEmail=" + personEmail + ", personId=" + personId + ", personLastname=" + personLastname
                + ", personName=" + personName + ", personPhone=" + personPhone + "]";
    }

    




}
