package simplejdbcdaosupport;

public class Person {

    private int id, sal;
    private String firstName, lastName;

    Person(int id,String fname, String lname,int sal) {
        firstName = fname;
        lastName = lname;
        this.id=id;
        this.sal=sal;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the sal
     */
    public int getSal() {
        return sal;
    }

    /**
     * @param sal the sal to set
     */
    public void setSal(int sal) {
        this.sal = sal;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "id="+id+",fistName="+firstName+",lastName="+lastName+",sal="+sal;
    }

}
