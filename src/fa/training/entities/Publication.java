package fa.training.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Publication {
    private int publicationYear;
    private String publisher;
    private Date publicationDate;

    public abstract void display();

    public Publication() {
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedPublicationDate = dateFormat.format(publicationDate);
        return "publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + formattedPublicationDate;
    }
}
