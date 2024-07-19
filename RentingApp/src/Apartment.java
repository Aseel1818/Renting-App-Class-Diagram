public class Apartment extends Building {
    public Apartment (String name , String address , String size)
    {
        super(name,address,size);
    }

    @Override
    public void showInformation(String name , String address , String size ) {
        System.out.println("Building name : "+name+" "+"address"+" "+address+" "+"size"+" "+size);
    }
}