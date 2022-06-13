package homework.eight;

public class Student {
    private String name;
    private String address;
    private String phone;
    private String email;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null) return false;

        if(obj.getClass() != getClass()) return false;
        Student casting = (Student) obj;

        if (name == null) {
            if (casting.getName()!=null) return false;
        } else if (!name.equals(casting.name)) {
            return false;
        }


        if (phone == null) {
            if (casting.getPhone()!=null) return false;
        } else if (!phone.equals(casting.phone)) {
            return false;
        }

        if (address == null) {
            if (casting.getAddress()!=null) return false;
        } else if (!address.equals(casting.address)) {
            return false;
        }

        if (email == null) {
            if (casting.getEmail()!=null) return false;
        } else if (!email.equals(casting.email)) {
            return false;

        }



        return true;
    }
}
