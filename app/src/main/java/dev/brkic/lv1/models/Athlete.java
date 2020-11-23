package dev.brkic.lv1.models;

public class Athlete
{
    String name;
    String bornDiedDate;
    String description;
    int imageId;

    public Athlete(String name, String bornDiedDate, String description, int imageId)
    {
        this.name=name;
        this.bornDiedDate=bornDiedDate;
        this.description=description;
        this.imageId=imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBornDiedDate() {
        return bornDiedDate;
    }

    public int getImageId() {
        return imageId;
    }

    public void setDescription(String description) { this.description = description;}

    public void setImageId(int id) { this.imageId = id;}
}
