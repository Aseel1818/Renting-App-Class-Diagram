public abstract class Building {
    private String name;
    private String address;
    private String size;

    public Building(String name, String address, String size) {
        this.name = name;
        this.address = address;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public abstract void showInformation(String name, String address, String size);


}
