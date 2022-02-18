import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
    ContactManager contactManager;

    @BeforeAll
    public void setupAll(){
        System.out.println("Should print before all test, just testin beforeAll tag of junit");
    }

    @BeforeEach
    public void setup(){
        //We cant set up an instance of obj here instead of each method ej.
        contactManager = new ContactManager();
    }


    @Test
    public void shouldCreateContact(){
        contactManager.addContact("Jhon", "Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size() );
    }

    @Test
    @DisplayName("Should no create Contact when is name null")
    public void shouldthrowRuntimeExceptionWhenfirstNameIsNull(){
    Assertions.assertThrows(RuntimeException.class, () ->{
        contactManager.addContact(null, "Dow", "0123456789");
    });
    }

    @Test
    @DisplayName("Should no create Contact when lastname is null")
    public void shouldthrowRuntimeExceptionWhenlastNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            contactManager.addContact("Jhonn", null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should no create Contact when phone is null")
    public void shouldthrowRuntimeExceptionWhenphoneNumIsNull(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            contactManager.addContact("Jhon", "Dow", null);
        });
    }
    @AfterEach
    public void TearDown(){
        System.out.println("Should execute this at the end of the test");

    }

    @AfterAll
    public void tearDownAll(){
        System.out.println("Should be executed at the end of the Test");
    }

    @Test
    @DisplayName("Should not create on Mac")
    @DisabledOnOs(value = OS.MAC,disabledReason = "Disabled on Mac")
    public void shouldCreateCountOnlyOnMac(){
        contactManager.addContact("Jhon", "Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
        .filter(contact -> contact.getFirstName().equals("Jhon") &&
                contact.getLastName().equals("Doe") &&
                contact.getPhoneNumber().equals("0123456789"))
        .findAny()
        .isPresent());
    }

}