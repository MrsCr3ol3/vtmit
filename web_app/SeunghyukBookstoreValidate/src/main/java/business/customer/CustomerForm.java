package business.customer;

import java.util.Calendar;
import java.util.Date;

public class CustomerForm {

    private String name;
    private String phone;
    private String email;
    private String ccNumber;
    private Date ccExpDate;

    private boolean hasNameError;
    private boolean hasPhoneError;
    private boolean hasEmailError;
    private boolean hasCcNumberError;
    private boolean hasCcExpDateError;
    // TODO: Make has-error methods for all fields except ccMonth and ccYear
    // TODO: Instead, make a has-error method for ccExpDate

    // TODO: This will change as your parameterized constructor changes
    public CustomerForm() {
        this("", "", "", "","","");
    }

    // TODO: Add more parameters as you add more fields
    public CustomerForm(String name, String phone, String email, String ccNumber, String ccMonth, String ccYear) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.ccNumber = ccNumber;
        // TODO: Initialize the fields that you add
        this.ccExpDate = getCcExpDate(ccMonth, ccYear);
        validate();
    }

    // Get methods for fields

    public String getName() {
        return name;
    }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getCcNumber() { return ccNumber; }
    public Date getCcExpDate() { return ccExpDate; }
    // TODO: Add getters for the fields you add

    // hasError methods for fields

    public boolean getHasNameError() {
        return hasNameError;
    }
    public boolean getHasPhoneError() { return hasPhoneError; }
    public boolean getHasEmailError() { return  hasEmailError; }
    public boolean getHasCcNumberError() { return hasCcNumberError; }
    public boolean getHasCcExpDateError() { return  hasCcExpDateError; }
    // TODO: Add getters for the has-error fields you add

    public boolean getHasFieldError() {
        return hasNameError || hasPhoneError || hasEmailError || hasCcNumberError || hasCcExpDateError;
        // TODO: This method returns true if *any* field has an error
        // TODO: This will evolve as you add more fields
    }

    // error messages for fields

    public String getNameErrorMessage() {
        return "Valid name required (ex: Bilbo Baggins)";
    }
    public String getPhoneErrorMessage() { return  "Valid phone number required (ex: 333-333-333)";}
    public String getEmailErrorMessage() { return  "Valid email address required (ex: aaa@ggg.com, no white space, no comma, must contain @)";}
    public String getCcNumerErrorMessage() { return  "Valid credit card number required (14-16 digits)";}
    public String getCcExpDateErrorMessage() { return  "Valid expiration date required, this card is expired";}
    // TODO: Create reasonable error messages for any field or date that can have an error

    private void validate() {
        if (name == null || name.equals("") || name.length() > 45) {
            hasNameError = true;
        }
        if (phone == null || phone.equals("") || phone.replaceAll("\\D", "").length() != 10 ) {
            hasPhoneError = true;
        }
        if (ccNumber == null || ccNumber.equals("") || ccNumber.replaceAll("\\D", "").length() < 14
                || ccNumber.replaceAll("\\D", "").length() > 16) {
            hasCcNumberError = true;
        }
        if (email == null || email.equals("") || email.contains(" ") || !email.contains("@") || email.charAt(email.length()-1) == '.') {
            hasEmailError = true;
        }

        Calendar rightNow = Calendar.getInstance();
        Date toDay = rightNow.getTime();

        if (ccExpDate == null || ccExpDate.equals("") || ccExpDate.before(toDay)) {
            hasCcExpDateError = true;
        }




        // TODO: Validate fields as you add them
    }

    // Returns a Java date object with the specified month and year
    private Date getCcExpDate(String monthString, String yearString) {
        // TODO: Implement this method
        // Assume monthString is an integer between 1 and 12
        // Assume yearString is a four-digit integer
        // Note: Calendar.getInstance() returns a calendar object
        // Note: calendar.set(Calendar.MONTH, mm) sets the month
        // Note: calendar.set(Calendar.YEAR, yyyy) sets the year
        // Note: Be careful of one-off errors

        if (monthString.equals("") || yearString.equals(""))
        {
            monthString = "1";
            yearString = "2000";
        }

        Calendar calender  = Calendar.getInstance();
        calender.clear();
        calender.set(Calendar.MONTH, Integer.parseInt(monthString)-1);
        calender.set(Calendar.YEAR, Integer.parseInt(yearString));


        Date expDate = calender.getTime();

        return expDate;
    }
}
