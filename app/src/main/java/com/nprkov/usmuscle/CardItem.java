package com.nprkov.usmuscle;

public class CardItem {
    private int imageResource;
    private String title;
    private String description;
    private String engineSize;
    private String learnMoreLink;

    public CardItem(int imageResource, String title, String description, String engineSize, String learnMoreLink) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.engineSize = engineSize;
        this.learnMoreLink = learnMoreLink;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public String getLearnMoreLink() {
        return learnMoreLink;
    }
}
