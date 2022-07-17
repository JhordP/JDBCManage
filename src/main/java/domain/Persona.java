package domain;

public class Persona { //Table Persona

    //Columns
    private int personId;
    private String personName;
    private String personLastname;
    private String personEmail;
    private long personPhone;

    public Persona(){} //Empty Constructor
    public Persona(int id){this.personId = id;} //personId constructor
    
    public Persona(String personName, String personLastname, String personEmail, long personPhone ) {
        this.personName = personName;
        this.personLastname = personLastname;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
    }
    public Persona(int personId, String personName, String personLastname, String personEmail, long personPhone) {
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
        return "Persona [personEmail=" + personEmail + ", personId=" + personId + ", personLastname=" + personLastname
                + ", personName=" + personName + ", personPhone=" + personPhone + "]";
    }

    




}
