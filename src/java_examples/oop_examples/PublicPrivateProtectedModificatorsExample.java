package java_examples.oop_examples;

public class PublicPrivateProtectedModificatorsExample {

    public String name;
    protected String phone;
    private String pinCode;

    public void sayName() {
        System.out.println(name);
    }

    protected void sayPhone() {
        System.out.println(phone);
    }

    private void sayPinCode(){
        System.out.println(pinCode);
    }

}
