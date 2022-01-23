package com.webApp.demo.webApp.service;

import com.webApp.demo.webApp.businessObjects.Customer;
import com.webApp.demo.webApp.businessObjects.NullCustomer;
import com.webApp.demo.webApp.businessObjects.RealCustomer;
import com.webApp.demo.webApp.repository.ContactInfoRep;
import org.springframework.stereotype.Service;
import com.webApp.demo.webApp.entity.ContactInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private ContactInfoRep contactInfoRep;
    private NullCustomer nullCustomer;

    public CustomerServiceImpl(ContactInfoRep theContactInfoRep, NullCustomer nullCustomer) {
        this.contactInfoRep = theContactInfoRep;
        this.nullCustomer = nullCustomer;
    }

    @Override
    public Customer findById(int theId) {
        Optional<ContactInfo> contactInfo = contactInfoRep.findById(theId);
        return this.EntityToBusinessObject(contactInfo) ;
    }

    @Override
    public void formatAndSave(RealCustomer theRealCustomer) {
        theRealCustomer.setFullName(formatFullName(theRealCustomer.getFullName()));
        ContactInfo contactInfo = BusinessObjectToEntity(theRealCustomer);
        contactInfoRep.save(contactInfo);
    }

    public static String formatFullName(String theCustomerFullName){
        if (theCustomerFullName == null || theCustomerFullName.length() <= 0)
            return "Anonymous";
        else
            return formatName(removeHonorifics(splitNames(theCustomerFullName)));
    }

    private static String formatName(List<String> names) {
        if(names.size() == 1)
            return names.get(0) + " Anonymous";
        else
            return formatMultiElementName(names);
    }

    private static String formatMultiElementName(List<String> names) {
        return String.format("%s %s", names.get(0), names.get(1));
    }

    private static List<String> removeHonorifics(List<String> names) {
        if(names.size() > 1 && isHonorific(names.get(0)))
            names.remove(0);
        return names;
    }

    private static boolean isHonorific(String word) {
        return word.matches("Mr\\.|Mrs\\.");
    }

    private static ArrayList<String> splitNames(String theCustomerName) {
        return new ArrayList<>(Arrays.asList(theCustomerName.trim().split("\\s+")));
    }

    private Customer EntityToBusinessObject(Optional<ContactInfo> theContInf){
        ContactInfo contInf = theContInf.orElse(null);
        return (contInf == null)? this.nullCustomer : new RealCustomer(contInf.getFirstName()+" "+contInf.getLastName(), contInf.getEmail());
    }

    private ContactInfo BusinessObjectToEntity(RealCustomer realcustomer){
        String names[] = realcustomer.getFullName().split(" ");
        String lastName = (names.length == 1)? null: names[1];
        ContactInfo contactInfo = new ContactInfo(names[0], lastName, realcustomer.getEmail());
        return contactInfo;
    }
}
