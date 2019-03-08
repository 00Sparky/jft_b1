package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "ContactCount")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void main (String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCSV(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXML(contacts, new File(file));
        } else {
            System.out.println("unrecognized format " + format);
        }
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private  void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact: contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getNewUserName(),
                    contact.getNewUserLastname(), contact.getNewUserAddress(),
                    contact.getNewUserEmail1(), contact.getNewUserMoblle()));
        }
        writer.close();
    }

    private  List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i< count; i++) {
            contacts.add(new ContactData().withNewUserName(String.format("Name %s", i))
                    .withNewUserLastname(String.format("Lastname %s", i))
                    .withNewUserAddress(String.format("Home %s", i))
            .withNewUserEmail1(String.format("mail%s@dom.st", i))
                    .withNewUserEmail2(String.format("mail2%s@dom.st", i))
                    .withNewUserEmail3(String.format("mail3%s@dom.st", i))
                    .withNewUserHomephone(String.format("11122%s",i))
            .withNewUserMoblle(String.format("55522%s", i))
            .withNewUserWorkphone(String.format("44422%s",i)));
        }
        return contacts;
    }
}
