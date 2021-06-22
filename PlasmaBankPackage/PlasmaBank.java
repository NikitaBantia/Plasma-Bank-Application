package PlasmaBankPackage;
import java.io.InputStream;
import java.util.*;
/*Table: plasmabank
Columns:
p_id int AI PK 
p_name varchar(45) 
p_state varchar(45) 
p_city varchar(45) 
p_contactno varchar(45
*/public class PlasmaBank {
    private int p_id;
    private String name;
    private String state;
    private String city;
    private String contactno;
    public ArrayList<RequestedSeeker> listOfRequests = new ArrayList<>();
    
    PlasmaBank(int id ,String name,String state,String city, String contactno) {
        setId(id);
        setName(name);
        setState(state);
        setCity(city);
        setContactno(contactno);
    }
    public void setId(int id){
        this.p_id=id;
    }   
    public void setName(String name) {
        this.name = name;
    }
    public void setContactno(String mobileno) {
        this.contactno = mobileno;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }
    public int getId(){
        return this.p_id;
    }
    public String getContactNo() {
        return contactno;
    }  
    public  String getCity() {
        return city;
    }
    public String getState(){
        return state;
    }
    public void MakeRequest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Required Blood Group: ");
        String seekerbloodgroup = sc.next();
        System.out.println("Enter Seekers current location: ");
        String seekerlocation = sc.next();
        System.out.println("Enter Seeker's Contact No: ");
        String seekercontactno = sc.next();
        RequestedSeeker ob = new RequestedSeeker();
        ob.setSeekerBloodGroup(seekerbloodgroup);
        ob.setSeekerLocation(seekerlocation);
        ob.setSeekerContactNo(seekercontactno);
        listOfRequests.add(ob);
        ViewRequested();  
    }
    public void ViewRequested(){
        for(int i=0;i<listOfRequests.size();i++){
        RequestedSeeker obj = listOfRequests.get(i);
        System.out.println("Seeker Number : "+(i+1));
        System.out.println("Required Blood Group: "+obj.getSeekerBloodGroup());
        System.out.println("Seeker's Location  : "+obj.getSeekerLocation());
        System.out.println("Seeker's Contact No Entered: "+obj.getSeekerContactNo());
        }
    }
}
